// src/app/auth.service.spec.ts

import { TestBed } from '@angular/core/testing';
import { AuthService } from '../app/auth.service';

describe('AuthService', () => {
  let service: AuthService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AuthService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should return true for valid credentials', () => {
    expect(service.login('admin', 'admin')).toBe(true);
  });

  it('should return false for invalid credentials', () => {
    expect(service.login('invalid', 'credentials')).toBe(false);
  });

  it('should return true if the user is logged in', () => {
    service.login('admin', 'admin');
    expect(service.isLoggedIn()).toBe(true);
  });

  it('should return false if the user is logged out', () => {
    service.login('admin', 'admin');
    service.logout();
    expect(service.isLoggedIn()).toBe(false);
  });
});
