// src/app/library/library.component.spec.ts

import { ComponentFixture, TestBed } from '@angular/core/testing';
import { LibraryComponent } from '../app/library/library.component';
import { RouterTestingModule } from '@angular/router/testing';

describe('LibraryComponent', () => {
  let component: LibraryComponent;
  let fixture: ComponentFixture<LibraryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LibraryComponent ],
      imports: [ RouterTestingModule ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LibraryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should display a list of books', () => {
    const compiled = fixture.nativeElement;
    expect(compiled.querySelectorAll('li.list-group-item').length).toBe(component.books.length);
  });
});
