import { Component, OnInit } from '@angular/core';
import { Produit, ProduitService } from '../core/api/v1';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  produits : Produit[];

  constructor(private produitService: ProduitService) { }

  ngOnInit() {
    this.produitService.findAll().subscribe(res => {
      this.produits = res;
    })
  }

}
