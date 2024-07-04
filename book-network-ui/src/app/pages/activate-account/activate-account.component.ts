import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { skipUntil } from 'rxjs';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { CodeInputModule } from 'angular-code-input';
import { AuthenticationService } from '../../api/services';
@Component({
  selector: 'app-activate-account',
  standalone: true,
  imports: [FormsModule, CommonModule, CodeInputModule],
  templateUrl: './activate-account.component.html',
  styleUrl: './activate-account.component.scss',
})
export class ActivateAccountComponent {
  message = '';
  isOkay = true;
  submitted = false;
  constructor(
    private router: Router,
    private authService: AuthenticationService
  ) {}

  redirectToLogin() {
    this.router.navigate(['login']);
  }

  onCodeCompleted(token: string) {
    this.confirmAccount(token);
  }
  confirmAccount(token: string) {
    this.authService
      .confirm({
        token,
      })
      .subscribe({
        next: () => {
          this.message =
            'Your account has been successfully activated.\nNow you can proceed to login';
          this.submitted = true;
        },
        error: () => {
          this.message = 'Token has been expired or invalid';
          this.submitted = true;
          this.isOkay = false;
        },
      });
  }
}
