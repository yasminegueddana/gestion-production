import { NgModule } from '@angular/core';
import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms'; // <-- Ajoute FormsModule ici

import { MachineService } from '../../services/machine.service';

@Component({
  selector: 'app-machine-form',
  imports: [
     CommonModule,
     FormsModule
  ],
  templateUrl: './machine-form.component.html',
  styleUrl: './machine-form.component.css'
})
export class MachineFormComponent {
  machine = {
    nom: '',
    etat: '',
    maintenanceProchaine: ''
  };
  
  today: string;
  constructor(
    private machineService: MachineService,
    private router: Router
  ) {const now = new Date();
  this.today = now.toISOString().split('T')[0];}

  // La méthode onSubmit qui sera appelée lors de la soumission du formulaire
  onSubmit(): void {
    this.machineService.createMachine(this.machine).subscribe(
      () => {
        this.router.navigate(['/machines']);  // Rediriger vers la liste des machines après l'ajout
      },
      (error: any) => {
        console.error('Erreur lors de l\'ajout de la machine', error);
      }
    );
  }
}