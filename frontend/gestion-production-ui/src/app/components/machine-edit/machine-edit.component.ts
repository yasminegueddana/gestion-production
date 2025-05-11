import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { MachineService } from '../../services/machine.service';

@Component({
  selector: 'app-machine-edit',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './machine-edit.component.html',
  styleUrls: ['./machine-edit.component.css']
})
export class MachineEditComponent implements OnInit {
  machineForm!: FormGroup;
  machineId!: number;
  today: string;
 

  constructor(
    private route: ActivatedRoute,
    private fb: FormBuilder,
    private machineService: MachineService,
    private router: Router
  ) {
    const now = new Date();
  this.today = now.toISOString().split('T')[0];  // ex : "2025-05-10"
  }

  ngOnInit(): void {
    this.machineId = Number(this.route.snapshot.paramMap.get('id'));

    this.machineForm = this.fb.group({
      nom: ['', Validators.required],
      etat: ['', Validators.required],
      maintenanceProchaine: ['', Validators.required]
    });

    this.machineService.getMachineById(this.machineId).subscribe(
      (machine) => {
        this.machineForm.patchValue({
          nom: machine.nom,
          etat: machine.etat,
          maintenanceProchaine: machine.maintenanceProchaine
        });
      },
      (error) => {
        console.error('Erreur lors de la récupération de la machine :', error);
      }
    );
  }

  onSubmit(): void {
    if (this.machineForm.valid) {
      const updatedMachine = this.machineForm.value;
      this.machineService.updateMachine(this.machineId, updatedMachine).subscribe(
        () => {
          this.router.navigate(['/machines']);
        },
        (error) => {
          console.error('Erreur lors de la mise à jour de la machine :', error);
        }
      );
    }
  }
}
