import { AuthService } from './../services/auth.service';
import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';
import { User } from '../model/user.model';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private auth:AuthService) { }

  
  User=new User();
  passConf!:string;


  ngOnInit(): void {
  }

  register() {
    if (!this.User.username || !this.User.email || !this.User.password || !this.passConf) {
      // Vérifier si l'un des champs est vide
      Swal.fire({
        icon: 'error',
        title: 'Tous les champs sont obligatoires.',
      });
      return;
    }
  
    if (this.User.password !== this.passConf) {
      Swal.fire({
        icon: 'error',
        title: 'Les deux mots de passe ne sont pas identiques.',
      });
      return;
    }
  
    console.log(this.User);
  
    this.auth.Register(this.User).subscribe(
      data => {
        console.log(data);
        Swal.fire({
          icon: 'success',
          title: 'Vérifiez votre email pour activer votre compte.',
          timer: 5000,
        });
      },
      err => {
        console.log(err);
        Swal.fire({
          icon: 'error',
          title: 'un erreur s\'est produit.',
        });
      }
    );
  }
  
}
