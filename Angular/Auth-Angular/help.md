---
Library Management System:

In this task, you are required to develop an Angular application for managing a library, where users can browse books, view details, and borrow books if they are authenticated. 



Sub-tasks: 



Create Angular Components: 

LibraryComponent: This component should display the list of available books to all users. 
BookDetailsComponent: This component should display detailed information about a selected book. 
LoginComponent: This component should display a login form with fields for username and password. 
Implement Authentication Service: 

Create an Angular service, AuthService, responsible for handling user authentication. 

This service should include the following methods: 



login(username: string, password: string): Authenticate the user with the provided username and password. 
logout(): Log out the authenticated user. 
isLoggedIn(): Return true if the user is authenticated, and false otherwise. 
 

Implement Auth Guard: 



Create an Angular Auth Guard, AuthGuard, to protect the BookDetailsComponent. Only authenticated users should be allowed to view book details. 
 

Implement Routing: 



Implement Angular routing to navigate between the LibraryComponent, BookDetailsComponent, and LoginComponent. 
 

Notes: 

Use the username: admin and the password: admin to login as an admin user. 
 

Requirements: 
The AuthService should be correctly implemented with the specified methods. 
The AuthGuard should be correctly implemented to protect the BookDetailsComponent from unauthenticated access. 
The Angular routing should be correctly implemented to navigate between the LibraryComponent, BookDetailsComponent, and LoginComponent. 
 

Evaluation Criteria: 
Correct implementation of the AuthService with the specified methods. 
Proper implementation of the AuthGuard to protect the BookDetailsComponent. 
Accurate implementation of Angular routing to navigate between components. 