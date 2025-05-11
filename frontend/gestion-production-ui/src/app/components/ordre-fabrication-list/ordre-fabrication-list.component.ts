import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common'; 
import { RouterModule } from '@angular/router';
import { OrdreFabricationService } from '../../services/ordre-fabrication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-ordre-fabrication-list',
  imports: [ 
    FormsModule,
    CommonModule,
    RouterModule,],
  templateUrl: './ordre-fabrication-list.component.html',
  styleUrls: ['./ordre-fabrication-list.component.css']
})
export class OrdreFabricationListComponent {
  ordresFabrication: any[] = [];

  constructor(
    private ordreFabricationService: OrdreFabricationService,
    private router: Router
  ) {
    this.ordreFabricationService.getAllOrdres().subscribe(
      (data) => {
        this.ordresFabrication = data;
      },
      (error) => {
        console.error('Error fetching ordres de fabrication:', error);
      }
    );
  }

  addOrdre(): void {
    this.router.navigate(['/ordres-fabrication/add']);
  }

  editOrdre(id: number): void {
    this.router.navigate(['/ordres-fabrication/edit', id]);
  }

  deleteOrdre(id: number): void {
    if (confirm('Êtes-vous sûr de vouloir supprimer cet ordre de fabrication ?')) {
      this.ordreFabricationService.deleteOrdre(id).subscribe(
        () => {
          this.ordresFabrication = this.ordresFabrication.filter(o => o.id !== id);
        },
        (error) => {
          console.error('Error deleting ordre de fabrication:', error);
        }
      );
    }
  }
}
