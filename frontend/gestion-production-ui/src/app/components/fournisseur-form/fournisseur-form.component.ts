import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms'; 
import { FournisseurService } from '../../services/fournisseur.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-fournisseur-form',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './fournisseur-form.component.html',
  styleUrls: ['./fournisseur-form.component.css']
})
export class FournisseurFormComponent {
  fournisseur = {
    nom: '',
    adresse: '',
    telephone: ''
  };

  constructor(private fournisseurService: FournisseurService, private router: Router) {}

  onSubmit(): void {
    this.fournisseurService.createFournisseur(this.fournisseur).subscribe(
      () => {
        this.router.navigate(['/fournisseurs']); 
      },
      (error) => {
        console.error('Error creating fournisseur:', error);
      }
    );
  }
}