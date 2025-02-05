---
Problem Statement: Building an Online Course Catalog with Search 
Functionality part 1
Scenario: You're developing an online learning platform with a wide range of courses available 
to users. These courses are stored in JSON format, each containing information like title, 
instructor, description, duration, difficulty level, user rating, and enrollment count.
Core Functionality:
● Create:
Provide an interface for instructors or administrators to add new courses to the 
catalog.
Include form validation to ensure all necessary details are provided and in the 
correct format.
Store the new course data in the JSON structure.
● Read:
Display course information in a user-friendly card or list format.
Allow users to view detailed descriptions of each course.

● Search:
 Implement a search bar that allows users to find courses by:
Title (Required)
Instructor name (Required)
Description

Validations:
Duration (in hours)
Validations Required:
Must be a numeric value
Positive integer or decimal (e.g., 1.5, 10)
Range validation (e.g., 1 to 100 hours)

User Rating
Validations Required:
Must be a numeric value
Range between 1 to 5 (e.g., 4.5)

The form should not allow a course to be added unless all fields are filled in correctly.

****Db.json should look like this
{
  "courses": [
    {
      "id": 1,
      "title": "Introduction to Angular",
      "instructor": "Jane Doe",
      "description": "Learn the basics of Angular, a popular framework for building web applications.",
      "duration": 5,
      "difficulty": "easy",
      "userRating": 4.5,
      "enrollmentCount": 150
    }
  ]
}