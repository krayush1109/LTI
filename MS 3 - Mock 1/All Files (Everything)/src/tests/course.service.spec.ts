import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { CourseService } from '../app/services/course.service';
import { Course } from '../app/models/course';
import { environment } from 'src/environments/environment';

describe('CourseService', () => {
  let service: CourseService;
  let httpMock: HttpTestingController;

  const mockCourses: Course[] = [
    {
      id: 1,
      title: 'Angular Basics',
      instructor: 'John Doe',
      description: 'Learn the basics of Angular framework',
      duration: 10,
      difficulty: 'Beginner',
      userRating: 4.5,
      enrollmentCount: 200
    },
    {
      id: 2,
      title: 'Advanced Angular',
      instructor: 'Jane Smith',
      description: 'Deep dive into Angular features',
      duration: 20,
      difficulty: 'Advanced',
      userRating: 4.8,
      enrollmentCount: 150
    }
  ];

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [CourseService]
    });

    service = TestBed.inject(CourseService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify();
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  describe('#getCourses', () => {
    it('should retrieve all courses from the API via GET', () => {
      service.getCourses().subscribe((courses) => {
        expect(courses.length).toBe(2);
        expect(courses).toEqual(mockCourses);
      });

      const req = httpMock.expectOne(`${environment.apiUrl}/courses`);
      expect(req.request.method).toBe('GET');
      req.flush(mockCourses);
    });

    it('should handle error response for getCourses', () => {
      service.getCourses().subscribe({
        next: () => fail('Expected an error, not courses'),
        error: (error) => {
          expect(error.status).toBe(500);
          expect(error.statusText).toBe('Internal Server Error');
        }
      });

      const req = httpMock.expectOne(`${environment.apiUrl}/courses`);
      req.flush('Error', { status: 500, statusText: 'Internal Server Error' });
    });
  });

  describe('#addCourse', () => {
    it('should add a new course via POST', () => {
      const newCourse: Course = {
        id: 3,
        title: 'RxJS in Depth',
        instructor: 'Mark Johnson',
        description: 'Comprehensive guide to RxJS',
        duration: 15,
        difficulty: 'Intermediate',
        userRating: 4.7,
        enrollmentCount: 100
      };

      service.addCourse(newCourse).subscribe((course) => {
        expect(course).toEqual(newCourse);
      });

      const req = httpMock.expectOne(`${environment.apiUrl}/courses`);
      expect(req.request.method).toBe('POST');
      expect(req.request.body).toEqual(newCourse);
      req.flush(newCourse);
    });

    it('should handle error response for addCourse', () => {
      const newCourse: Course = {
        id: 4,
        title: 'Testing Angular',
        instructor: 'Alex Smith',
        description: 'Learn testing strategies for Angular apps',
        duration: 12,
        difficulty: 'Beginner',
        userRating: 4.6,
        enrollmentCount: 50
      };

      service.addCourse(newCourse).subscribe({
        next: () => fail('Expected an error, not a course'),
        error: (error) => {
          expect(error.status).toBe(400);
          expect(error.statusText).toBe('Bad Request');
        }
      });

      const req = httpMock.expectOne(`${environment.apiUrl}/courses`);
      req.flush('Invalid Data', { status: 400, statusText: 'Bad Request' });
    });
  });
});
