import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { OrdreFabricationService } from '../../services/ordre-fabrication.service';
import { FormsModule } from '@angular/forms'; // pour ngModel, ngForm
import { CommonModule } from '@angular/common'; // pour *ngIf, *ngFor, date pipe
import { RouterModule } from '@angular/router'; // pour routerLink

@Component({
  selector: 'app-ordre-fabrication-edit',
   imports: [
    FormsModule,
    CommonModule,
    RouterModule,],
  templateUrl: './ordre-fabrication-edit.component.html',
  styleUrls: ['./ordre-fabrication-edit.component.css']
})
export class OrdreFabricationEditComponent implements OnInit {
  ordre: any = {
    quantite: 0,
    date: '',
    statut: '',
    machine: null,
    produit: null
  };
  machines: any[] = [];
  produits: any[] = [];

  constructor(
    private route: ActivatedRoute,
    private ordreFabricationService: OrdreFabricationService,
    private router: Router
  ) {}

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.ordreFabricationService.getOrdreById(id).subscribe(data => {
        this.ordre = data;
      });
    }

    this.ordreFabricationService.getAllMachines().subscribe(data => {
      this.machines = data;
    });

    this.ordreFabricationService.getAllProduits().subscribe(data => {
      this.produits = data;
    });
  }

  onSubmit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.ordreFabricationService.updateOrdre(id, this.ordre).subscribe(
        () => {
          this.router.navigate(['/ordres-fabrication']);
        },
        (error) => {
          console.error('Erreur lors de la modification de l\'ordre de fabrication:', error);
        }
      );
    }
  }
}
