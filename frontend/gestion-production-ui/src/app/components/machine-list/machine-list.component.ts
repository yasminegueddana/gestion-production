import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MachineService } from '../../services/machine.service';
import { Router } from '@angular/router';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-machine-list',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './machine-list.component.html',
  styleUrls: ['./machine-list.component.css']
})
export class MachineListComponent {

  machines: {
    id: number;
    nom: string;
    etat: string;
    maintenanceProchaine: string; // ou Date si nécessaire
  }[] = [];

  constructor(
    private machineService: MachineService,
    private router: Router
  ) {
    this.loadMachines();
  }

  loadMachines(): void {
    this.machineService.getAllMachines().subscribe(
      (data) => {
        console.log('Fetched machines:', data);
        this.machines = data;
      },
      (error) => {
        console.error('Error fetching machines:', error);
      }
    );
  }

  addMachine(): void {
    this.router.navigate(['/machines/add']);
  }

  editMachine(id: number): void {
    this.router.navigate(['/machines/edit', id]);
  }

  deleteMachine(id: number): void {
    if (confirm('Are you sure you want to delete this machine?')) {
      this.machineService.deleteMachine(id).subscribe(
        () => {
          this.loadMachines(); // recharge proprement la liste après suppression
        },
        (error) => {
          console.error('Error deleting machine:', error);
        }
      );
    }
  }
}
