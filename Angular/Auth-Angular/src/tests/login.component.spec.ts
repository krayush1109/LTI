// src/app/login/login.component.spec.ts

import { ComponentFixture, TestBed } from '@angular/core/testing';
import { LoginComponent } from '../app/login/login.component';
import { AuthService } from '../app/auth.service';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { RouterTestingModule } from '@angular/router/testing';

describe('LoginComponent', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;
  let authService: AuthService;
  let router: Router;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoginComponent ],
      imports: [ FormsModule, RouterTestingModule ],
      providers: [ AuthService ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LoginComponent);
    component = fixture.componentInstance;
    authService = TestBed.inject(AuthService);
    router = TestBed.inject(Router);
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should display an error message for invalid credentials', () => {
    spyOn(authService, 'login').and.returnValue(false);
    component.username = 'invalid';
    component.password = 'invalid';
    component.login();
    expect(component.errorMessage).toBe('Invalid username or password');
  });

  it('should navigate to the library for valid credentials', () => {
    spyOn(authService, 'login').and.returnValue(true);
    spyOn(router, 'navigate');
    component.username = 'admin';
    component.password = 'admin';
    component.login();
    expect(router.navigate).toHaveBeenCalledWith(['/']);
  });
});
