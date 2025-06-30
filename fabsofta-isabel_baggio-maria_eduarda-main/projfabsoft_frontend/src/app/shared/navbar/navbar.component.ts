import { Component } from '@angular/core';
import { RouterModule } from '@angular/router'; // Importe RouterModule para usar routerLink
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-navbar',
  standalone: true, // Componente standalone
  imports: [RouterModule, CommonModule], // Importe RouterModule para roteamento
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent {
  // A classe do componente pode ficar vazia, pois a lógica está no HTML
}