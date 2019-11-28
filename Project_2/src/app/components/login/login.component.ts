import { Component, OnInit } from '@angular/core';
import { SpotifyService } from 'src/app/services/spotify.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  email: string;
  password: string;

  constructor(private spotifyService: SpotifyService,
              private router: Router) { }

  ngOnInit() {
    localStorage.clear();
  }

  loginUser() {
        this.spotifyService.loginUser(this.email,this.password)  
        .subscribe(res => {
            localStorage.setItem('token', JSON.stringify(res.userId));
            if(res!=null) {  
              this.login();
            }
        });   
  }
  login() {
        this.router.navigate(['/spotlight']);  
  }
}
