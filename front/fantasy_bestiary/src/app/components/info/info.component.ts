import { Component, importProvidersFrom } from '@angular/core';
import { CommonModule } from '@angular/common';
import { bootstrapApplication } from '@angular/platform-browser';
import { AuthModule, AuthService } from '@auth0/auth0-angular';

bootstrapApplication(AuthModule, {
  providers: [
    importProvidersFrom(
      AuthModule.forRoot({
        domain: 'dev-vvw64vche480sgak.eu.auth0.com',
        clientId: 'dTge1bT76Ca92ls1oSDT0woP5fBt5t2p',
      })
    ),
  ],
});

@Component({
  selector: 'app-info',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './info.component.html',
  styleUrl: './info.component.css'
})
export class InfoComponent {

  constructor(public _auth:AuthService) {

  }

}
