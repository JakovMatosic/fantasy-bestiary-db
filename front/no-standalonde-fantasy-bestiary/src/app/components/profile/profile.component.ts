import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '@auth0/auth0-angular';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.css'
})
export class ProfileComponent implements OnInit{
  public user: any = null;
  constructor(public auth: AuthService, public router: Router) {}

  ngOnInit(): void {
    this.auth.user$.subscribe((user) => {
      if(user) {
        this.user = user;
      } else {
        this.router.navigate(['/']);
      }
      
    });
  }



}
