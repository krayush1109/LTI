// src/app/book-details/book-details.component.spec.ts

import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { BookDetailsComponent } from '../app/book-details/book-details.component';
import { RouterTestingModule } from '@angular/router/testing';
import { of } from 'rxjs';

describe('BookDetailsComponent', () => {
  let component: BookDetailsComponent;
  let fixture: ComponentFixture<BookDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BookDetailsComponent ],
      imports: [ RouterTestingModule ],
      providers: [
        {
          provide: ActivatedRoute,
          useValue: { params: of({ id: 1 }) }
        }
      ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BookDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should display book details for the selected book', () => {
    const compiled = fixture.nativeElement;
    expect(compiled.querySelector('h2').textContent).toContain(component.book?.title);
  });
});
