import { Component, OnDestroy, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, of, Subscription } from 'rxjs';
import { AuthService } from '../auth.service';
import { User } from '../auth/user.model';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit, OnDestroy {

  isAuthenticated = false;

  username$: Observable<User | undefined> = of(undefined);
  value: string | undefined = ''


  private userSub!: Subscription;

  constructor(private authService : AuthService) { 

  }

  onLogout() {
    this.authService.logout();
  }

  ngOnInit(): void {
    this.userSub = this.authService.user.subscribe(u => {
      // this.isAuthenticated = !u ? false : true;
      // console.log(this.isAuthenticated);
      this.isAuthenticated = !!u;
      this.username$ = this.authService.username;
      this.username$.subscribe(name => {
        this.value = name?.email;
      })
    });
    // this.username = JSON.parse(localStorage.getItem('userData') || '{}').email;
  }
  
  ngOnDestroy(): void {
    this.userSub.unsubscribe();
  }

}
