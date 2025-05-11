import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms'; // pour ngModel, ngForm
import { CommonModule } from '@angular/common'; // pour *ngIf, *ngFor, date pipe
import { RouterModule } from '@angular/router'; // pour routerLink

import { OrdreFabricationService } from '../../services/ordre-fabrication.service';

@Component({
  selector: 'app-ordre-fabrication-form',
   imports: [ 
    FormsModule,
    CommonModule,
    RouterModule,],
  templateUrl: './ordre-fabrication-form.component.html',
  styleUrls: ['./ordre-fabrication-form.component.css']
})
export class OrdreFabricationFormComponent {
  ordre : any = {
    quantite: 0,
    date: '',
    statut: '',
    machine: null,
    produit: null
  };

  machines: any[] = [];
  produits: any[] = [];

  constructor(
    private ordreFabricationService: OrdreFabricationService,
    private router: Router
  ) {
    // On suppose que tu as des méthodes pour récupérer les machines et produits
    this.ordreFabricationService.getAllMachines().subscribe(data => {
      this.machines = data;
    });
    this.ordreFabricationService.getAllProduits().subscribe(data => {
      this.produits = data;
    });
  }

  onSubmit(): void {
    this.ordreFabricationService.createOrdre(this.ordre).subscribe(
      () => {
        this.router.navigate(['/ordres-fabrication']);
      },
      (error) => {
        console.error('Erreur lors de la création de l\'ordre de fabrication:', error);
      }
    );
  }
}
