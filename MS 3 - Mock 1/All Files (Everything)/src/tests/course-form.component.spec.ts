import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ReactiveFormsModule } from '@angular/forms';
import { CourseFormComponent } from '../app/course-form/course-form.component';
import { CourseService } from '../app/services/course.service';
import { of } from 'rxjs';

// Mock CourseService
class MockCourseService {
  addCourse() {
    return of({});
  }
}

describe('CourseFormComponent', () => {
  let component: CourseFormComponent;
  let fixture: ComponentFixture<CourseFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CourseFormComponent],
      imports: [ReactiveFormsModule],
      providers: [{ provide: CourseService, useClass: MockCourseService }]
    }).compileComponents();

    fixture = TestBed.createComponent(CourseFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create the component', () => {
    expect(component).toBeTruthy();
  });

  describe('Form validation', () => {
    it('should have an invalid form when initialized', () => {
      expect(component.courseForm.valid).toBeFalsy();
    });

    it('should validate title field as required', () => {
      const titleControl = component.courseForm.get('title');
      titleControl?.setValue('');
      expect(titleControl?.valid).toBeFalsy();
      expect(titleControl?.errors?.['required']).toBeTruthy();
    });

    it('should validate instructor field as required', () => {
      const instructorControl = component.courseForm.get('instructor');
      instructorControl?.setValue('');
      expect(instructorControl?.valid).toBeFalsy();
      expect(instructorControl?.errors?.['required']).toBeTruthy();
    });

    it('should validate description field as required', () => {
      const descriptionControl = component.courseForm.get('description');
      descriptionControl?.setValue('');
      expect(descriptionControl?.valid).toBeFalsy();
      expect(descriptionControl?.errors?.['required']).toBeTruthy();
    });

    it('should validate duration field with required and numeric pattern', () => {
      const durationControl = component.courseForm.get('duration');

      durationControl?.setValue('');
      expect(durationControl?.valid).toBeFalsy();
      expect(durationControl?.errors?.['required']).toBeTruthy();

      durationControl?.setValue('abc'); // Invalid non-numeric
      expect(durationControl?.valid).toBeFalsy();
      expect(durationControl?.errors?.['pattern']).toBeTruthy();

      durationControl?.setValue(101); // Above max limit
      expect(durationControl?.valid).toBeFalsy();
      expect(durationControl?.errors?.['max']).toBeTruthy();

      durationControl?.setValue(0); // Below min limit
      expect(durationControl?.valid).toBeFalsy();
      expect(durationControl?.errors?.['min']).toBeTruthy();

      durationControl?.setValue(50); // Valid value
      expect(durationControl?.valid).toBeTruthy();
    });

    it('should validate difficulty field as required', () => {
      const difficultyControl = component.courseForm.get('difficulty');
      difficultyControl?.setValue('');
      expect(difficultyControl?.valid).toBeFalsy();
      expect(difficultyControl?.errors?.['required']).toBeTruthy();
    });

    it('should validate userRating field with min and max constraints', () => {
      const userRatingControl = component.courseForm.get('userRating');

      userRatingControl?.setValue('');
      expect(userRatingControl?.valid).toBeFalsy();
      expect(userRatingControl?.errors?.['required']).toBeTruthy();

      userRatingControl?.setValue(0); // Below minimum value
      expect(userRatingControl?.valid).toBeFalsy();
      expect(userRatingControl?.errors?.['min']).toBeTruthy();

      userRatingControl?.setValue(6); // Above maximum value
      expect(userRatingControl?.valid).toBeFalsy();
      expect(userRatingControl?.errors?.['max']).toBeTruthy();

      userRatingControl?.setValue(4); // Valid value
      expect(userRatingControl?.valid).toBeTruthy();
    });

    it('should allow enrollmentCount to default to 0', () => {
      const enrollmentCountControl = component.courseForm.get('enrollmentCount');
      expect(enrollmentCountControl?.value).toBe(0);
      expect(enrollmentCountControl?.valid).toBeTruthy();
    });

    it('should be valid when all required fields have correct values', () => {
      component.courseForm.setValue({
        title: 'Angular Fundamentals',
        instructor: 'John Doe',
        description: 'Learn the fundamentals of Angular',
        duration: 20,
        difficulty: 'Beginner',
        userRating: 4,
        enrollmentCount: 50
      });

      expect(component.courseForm.valid).toBeTruthy();
    });
  });
});
