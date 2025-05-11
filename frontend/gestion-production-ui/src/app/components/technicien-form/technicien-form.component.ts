import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ApiService } from '../../services/api.service';

@Component({
  selector: 'app-technicien-form',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './technicien-form.component.html',
  styleUrls: ['./technicien-form.component.css']
})
export class TechnicienFormComponent {
  technicien = {
    nom: '',
    competences: ''
  };

  constructor(private apiService: ApiService) {}

  onSubmit(): void {
    this.apiService.addTechnicien(this.technicien).subscribe(response => {
      console.log('Technicien ajouté avec succès :', response);
    });
  }
}