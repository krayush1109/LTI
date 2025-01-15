The International Premier League (IPL) is the world's leading cricket tournament, featuring teams from around the globe. The league management has identified the need for a modern web-based management system to handle team and player data, allow for player bidding, and present all the necessary information in an intuitive interface for both administrators and users. The objective of this project is to create a comprehensive digital platform for IPL management that integrates team composition, player bidding, and detailed statistical insights.

Objective:

The goal is to build a platform that enables administrators to manage team data, player bids, and matches, while also providing a user-friendly interface for fans to access real-time IPL updates, statistics, and team composition. The system should support secure data access and role-based controls for admins and users.

Note:

The submission of the project should only be done after the successful completion of all tasks by Day 26 of MS3.

MS1: Establishing the Foundational Software Structure (Week 1)

Scenario:

The IPL League is starting its digital transformation, and the first step is to create a digital record of all teams and players.



Day 1:
Task1: Design the Entity models for Team, Cricketer and Match.
 You need to complete the implementation of the following classes:

 User.java

 Team.java

 Cricketer.java

 Match.java

 DatabaseConnectionManager.java

Note: Don't hardcode the values in DatabaseConnectionManager.java file. Read it dynamically from application.properties file

 CREATE TABLE user (

    user_id INT AUTO_INCREMENT PRIMARY KEY, 

    full_name VARCHAR(255) NOT NULL,

    username VARCHAR(50) NOT NULL,    

    password VARCHAR(255) NOT NULL,

    email VARCHAR(100) NOT NULL,

    role VARCHAR(100) NOT NULL            

);



 CREATE TABLE team (

    team_id INT PRIMARY KEY AUTO_INCREMENT,

    team_name VARCHAR(100) NOT NULL,

    location VARCHAR(100),

    owner_name VARCHAR(100),

    establishment_year INT

);



 CREATE TABLE cricketer (

    cricketer_id INT PRIMARY KEY AUTO_INCREMENT,

    team_id INT,

    cricketer_name VARCHAR(100) NOT NULL,

    age INT,

    nationality VARCHAR(100),

    experience INT,

    role VARCHAR(50), 

    total_runs INT,

    total_wickets INT

);

NOTE: The role column in the Cricketer table is for “Batsman”, “Bowler”, “All-rounder” and “Wicketkeeper”. (Use exact these strings”

 CREATE TABLE matches (

    match_id INT PRIMARY KEY AUTO_INCREMENT,

    first_team_id INT NOT NULL,

    second_team_id INT NOT NULL,

    match_date DATE NOT NULL,

    venue VARCHAR(100),

    result VARCHAR(100),

    status VARCHAR(100),

    winner_team_id INT

);

NOTE: The role status in the Match table is for “Pending”, “Scheduled” and “Completed”. (Use exact these strings)





Task 2: Build a layered architecture such as Client, Service, DAO, etc. Implement interfaces for DAO, DAO Impl, Service, Service Impl.


 You need to work on following files :

 TeamDAOImpl.java

 TeamServiceImplJdbc.java

 TeamServiceImplArraylist.java

 CricketerDAOImpl.java

 CricketerServiceImplJdbc.java

 CricketerServiceImplArraylist.java

 MatchDAOImpl.java

 MatchServiceImplJdbc.java





Day 2:
Task1: Use Java Collection ArrayList to store sample Team and Cricketer data.
 You need to work on following files :

 TeamServiceImplArraylist.java

 CricketerServiceImplArraylist.java





Task2: Display the list of Team sorted by team name and Cricketer sorted by experience by using Java’s Comparator and Comparable interfaces.


You need to work on following files :

Team.java

Cricketer.java

 TeamServiceImplArraylist.java

 CricketerServiceImplArraylist.java





Day 3:
Task1: Apply exception handling using try-catch-finally and throw/throws. Start JDBC integration for persistent data storage.
Task2: Develop the DAO layer for interaction with the database.


 You need to work on following files :

 TeamDAO.java

 TeamDAOImpl.java

 TeamService.java

 TeamServiceImplJdbc.java

 CricketerDAO.java

 CricketerDAOImpl.java

 CricketerService.java

 CricketerServiceImplJdbc.java

 MatchDAO.java

 MatchDAOImpl.java

 MatchService.java

 MatchServiceImplJdbc.java



MS2: Enhancing Database Interaction (Week 2)

Scenario:

With the foundational software components in place, IPL Project now focuses on enhancing database interactions and developing the application layer.



Day 4:
Task: Set up a Spring Boot project with an initial "Hello IPL Progressive Project" message. Also add the necessary Springboot annotations to the controller classes and entity classes.
You need to work on following files :

IplApplication.java.

TeamController.java

CricketerController.java

MatchController.java

Team.java

Cricketer.java

Match.java

User.java





Day 5:
Task:Construct Controller for Team and implement the JPA Service layers for Team.
Create REST APIs in the Team controller to return data from ArrayLists (done on Day 2) as JSON and test it. Also implement the JPA services for Team



You need to complete the implementation of the following classes, ensuring adherence to the specified API endpoints as listed below :

1. TeamController.java 

getAllTeams - GET /team

getTeamById - GET /team/{teamID}

addTeam - POST /team

updateTeam - PUT /team/{teamID}

deleteTeam - DELETE /team/{teamID}

getAllTeamsFromArrayList - GET /team/fromArrayList

addTeamToArrayList - POST /team/toArrayList

getAllTeamsSortedByNameFromArrayList - GET /teamId/fromArrayList/sorted

2. TeamServiceImplJpa.java



Update TeamServiceImplArraylist.java as service in order to store Team data in an ArrayList.





Day 6:
Task: Implement Spring Boot JPA for Team, Cricketer and Match. And also shift CRUD operations to SpringDataJPA for Team
You need to work on following files :

TeamServiceImplJpa.java

CricketerServiceImplJpa.java

MatchServiceImplJpa.java

TeamRepository.java

CricketerRepository.java

MatchRepository.java





Day 7:
Task1: Add associations between Team, Cricketer, and Match entities.
Update the Team, Cricketer, and Match entities to establish proper One-to-Many/Many-to-One associations between Team and Cricketer, as well as between Team and Match, and ensure the corresponding package structure is updated for Spring Data JPA compliance.

Cricketer.java

Match.java



Note: Your code should meet the following functional requirements:





Proper associations between Team and Cricketer should be built.
Team and Match Entity should be updated (during Spring Data JPA inclusion) to have these One-to-Many/Many-to-one Associations between Team and Match.
Task2: Shift CRUD operations to SpringDataJPA for Cricketer


You need to complete the implementation of the following classes, ensuring adherence to the specified API endpoints as listed below :

CricketerServiceImplJpa.java

CricketerService.java

CricketerRepository.java

CricketerController.java: 

getAllCricketers - GET /cricketer

getCricketerById - GET /cricketer/{cricketerID}

getCricketersByTeam - GET /cricketer/team/{teamID}

addCricketer - POST /cricketer

updateCricketer - PUT /cricketer/{cricketerID}

deleteCricketer - DELETE /cricketer/{cricketerID}





Day 8:
Task: Shift CRUD operations to SpringDataJPA for Match
You need to complete the implementation of the following classes, ensuring adherence to the specified API endpoints as listed below :

MatchServiceImplJpa.java

MatchService.java

MatchRepository.java

MatchController.java: 

getAllMatches - GET /match

getMatchById - GET /match/{matchID}

addMatch - POST /match

updateMatch - PUT /match/{matchID}

deleteMatch - DELETE /match/{matchID}

getAllMatchesByStatus - GET /match/status/{status}



NOTE: The role status in the Match is for “Pending”, “Scheduled” and “Completed”. (Use exact these strings)





Day 9:
Task: Add the following custom exceptions to Service layer:
TeamDoesNotExistException: This exception should be thrown when fetching a team that does not exist in the system.

TeamCricketerLimitExceededException: This exception should be thrown when attempting to add or update a cricketer to a team that has already reached its maximum limit of 11 cricketers. In IPL teams, each team can have a maximum of 11 players on the field, and adding more cricketers would exceed this limit.

NoMatchesFoundException: This exception should be thrown when querying for matches with a specific status and no matches are found in the database. 

TeamAlreadyExistsException: When creating or updating a team with data that already exists (like a team name that is already taken).



You need to complete the implementation of the following classes and also raise add these exceptions as required in the Services classes.:

TeamDoesNotExistException.java

TeamCricketerLimitExceededException.java

NoMatchesFoundException.java

TeamAlreadyExistsException.java

TeamServiceImplJpa.java

CricketerServiceImplJpa.java

MatchServiceImplJpa.java

TeamRepository.java

CricketerRepository.java

TeamController.java

CricketerController.java

MatchController.java





Day 10:
Task: Create Voting Functionality and Implement CRUD for Voting using SpringDataJPA. Also create the table for Vote.
You need to complete the implementation of the following classes, ensuring adherence to the specified API endpoints as listed below:

Vote.java

VoteService.java

VoteServiceImpl.java

VoteRepository.java

VoteController.java:

	getAllVotes - GET /vote

	createVote - POST /vote

	getVotesCountOfAllCategories - GET /vote/count (categories - “Team”, “Batsman”, “Bowler”, “All-rounder” and “Wicketkeeper”)

 Note: Use exact strings for category as mentioned above,



 CREATE TABLE Vote (

    vote_id INT PRIMARY KEY AUTO_INCREMENT,

    email VARCHAR(100) NOT NULL,

    category VARCHAR(100) NOT NULL,

    cricketer_id INT,

    team_id INT

);







Day 11:
Task: Create Ticket Booking Functionality and Implement CRUD for Ticket Booking for matches which have status as “Scheduled” using SpringDataJPA.
You need to complete the implementation of the following classes, ensuring adherence to the specified API endpoints as listed below:

	TicketBooking.java

	TicketBookingService.java

	TicketBookingServiceImpl.java

	TicketBookingRepository.java

	TicketBookingController.java :

 getAllTicketBookings - GET /ticket

 createBooking - POST /ticket

 cancelBooking - DELETE /ticket/{bookingID}

 getBookingsByUserEmail - GET /ticket/user/{email}



	CREATE TABLE ticket_booking (

    booking_id INT PRIMARY KEY AUTO_INCREMENT,

    match_id INT NOT NULL,

    email VARCHAR(100) NOT NULL,

    number_of_tickets INT NOT NULL

);





Day 12:
Scenario: For enhanced security and user experience, IPL wants registration/logins and wants to secure its APIs.





Task: Implement Secure token functionalities


 You need to work on following files :

 JwtUtil.java

 JwtRequestFilter.java

 UserRepository.java

 UserLoginServiceImpl.java

MS3:



Day 13:
Task 1: Implement User Registration and Login functionalities.
You need to implement the following classes, ensuring adherence to the specified API endpoints as listed below :

UserServiceImpl.java

UserRepository.java

LoginRequest.java

LoginResponse.java

UserLoginController.java :

registerUser - POST /user/register

loginUser - POST /user/login

UserLoginServiceImpl.java





Task 2: Secure all api. All endpoints should be allowed to only "ADMIN or USER" authority roles.


You need to implement the following classes:

SecurityConfig.java (Remove the existing methods)

Configurations.java



A person with the role “USER” must be able to perform the following tasks:



Ability to login/register on the platform.
Ability to view details of teams/cricketers/matches.
Ability to vote for their favorite team or cricketer.
Ability to book tickets for matches that are in the "Scheduled" status through a button in the navbar bar.
Ability to see their booked ticket for the Scheduled match.
A person with the role “ADMIN” must be able to perform the following tasks:



Ability to login/register on the platform.
Ability to create/update/delete a team, cricketer and match
Ability to view all the votes and tickets booked.
Day 14 and Day 15:


Scenario: IPL wants a modern Front-end and a mobile-friendly interface for its digital platform.





Task: Apply Frontend validation for registration and login pages using JavaScript.


The validation rules should include checks for the following cases:



Username should not contain special characters.
Passwords should be at least 8 digits and must contain at least one capital letter and one numeric.
The fields in the registration form are all mandatory fields and do not accept empty inputs.
The email entered should be a valid email address.
Implement the following files:

./frontend/day_14_15/login.html

./frontend/day_14_15/registaration.html

./frontend/day_14_15/js/validation.js

NOTE to Learners: Create separate JavaScript files to do the above validations.*





Day 16:
Task: Use TypeScript to design classes for User, Team, Cricketer, Match, Vote and TicketBooking. Also console the attributes of these tables as key-value pairs.
Implement the following files:

src/app/ipl/types/Team.ts

src/app/ipl/types/Cricketer.ts

src/app/ipl/types/Match.ts

src/app/ipl/types/Vote.ts

src/app/ipl/types/User.ts

src/app/ipl/types/TicketBooking.ts





Day 17:
Task: Create Angular components for Team and Cricketer. Bind sample data to Team and Cricketer classes.
Implement the following files:

src/app/ipl/components/teamsample/teamsample.component.ts

src/app/ipl/components/teamsample/teamsample.component.html

src/app/ipl/components/teamsample/teamsample.component.scss

src/app/ipl/components/cricketersample/cricketersample.component.ts

src/app/ipl/components/cricketersample/cricketersample.component.html

src/app/ipl/components/cricketersample/cricketersample.component.scss





Day 18:
Task1: Implement two-way data binding and event binding for Team using angular forms.
Implement the following files:

src/app/ipl/components/teamcreate/teamcreate.component.html

src/app/ipl/components/teamcreate/teamcreate.component.ts

src/app/ipl/components/teamcreate/teamcreate.component.scss





Task2: Add Cricketer data using JSON Array. Showcase Cricketer data using *ngFor and *ngIf directives in Angular.


Implement the following files:

src/app/ipl/components/cricketerarray/cricketerarray.component.html

src/app/ipl/components/cricketerarray/cricketerarray.component.ts

src/app/ipl/components/cricketerarray/cricketerarray.component.scss





Day 19:
Task: Create Angular components for Cricketer and Match. Implement two-way data binding and event binding in Angular Forms.
Implement the following files:

src/app/ipl/components/cricketercreate/cricketercreate.component.ts

src/app/ipl/components/cricketercreate/cricketercreate.component.html

src/app/ipl/components/cricketercreate/cricketercreate.component.scss

src/app/ipl/components/matchcreate/matchcreate.component.html

src/app/ipl/components/matchcreate/matchcreate.component.ts

src/app/ipl/components/matchcreate/matchcreate.component.scss





Day 20:
Task: Develop Angular components for creating votes and ticket bookings, utilizing two-way data binding and event binding in Angular forms.
Implement the following files:

src/app/ipl/components/vote/vote.component.ts

src/app/ipl/components/vote/vote.component.html

src/app/ipl/components/vote/vote.component.scss

src/app/ipl/components/ticketbooking/ticketbooking.component.html

src/app/ipl/components/ticketbooking/ticketbooking.component.ts

src/app/ipl/components/ticketbooking/ticketbooking.component.scss





Day 21:
Task1: Apply Frontend form functionalities and validation for registration and login forms. Design forms to capture user data.
The validation rules should include checks for the following cases:



The email entered should be a valid email address.
Username should not contain special characters.
Passwords should be at least 8 digits and must contain at least one capital letter and one numeric.
The fields in the registration form are all mandatory fields and do not accept empty inputs.
Note: The error messages from the Backend should be properly propagated and displayed in UI.

Implement the following files:

src/app/auth/components/login/login.component.html

src/app/auth/components/login/login.component.ts

src/app/auth/components/login/login.component.scss

src/app/auth/components/registration/registration.component.ts

src/app/auth/components/registration/registration.component.html

src/app/auth/components/registration/registration.component.scss





Task2: Continue form functionalities and validations for Team and Cricketer forms.


The validation rules should include checks for the following cases:





Team id cannot be null.
Experience of the cricketer has to be non-negative.
Team names must not contain any special characters.
There should be proper validation that the email is a proper email address.
Note: The error messages from the Backend should be properly propagated and displayed in UI.

Implement the following files:

src/app/ipl/components/teamcreate/teamcreate.component.html

src/app/ipl/components/teamcreate/teamcreate.component.ts

src/app/ipl/components/teamcreate/teamcreate.component.scss

src/app/ipl/components/cricketercreate/cricketercreate.component.ts

src/app/ipl/components/cricketercreate/cricketercreate.component.html

src/app/ipl/components/cricketercreate/cricketercreate.component.scss





Day 22:
Scenario: For a seamless user journey, IPL wants routing, forms, integration with Backend services, and style enhancements.



Note: Edit the following files to establish ManyToOne relationships between the entities with Team entity -

src/app/ipl/types/Match.ts

src/app/ipl/types/Cricketer.ts

src/app/ipl/components/matchcreate/matchcreate.component.ts

src/app/ipl/components/cricketercreate/cricketercreate.component.ts





Task1: Apply routing in Angular.


Implement the following files:

src/app//ipl/ipl-routing.module.ts

src/app//ipl/ipl.module.ts

src/app/auth/auth-routing.module.ts





Task2: Use Angular services and HTTP client to fetch data from the SpringBoot application. Implement login workflow for admin and user roles.


Implement the following files:

src/app/ipl/services/ipl.service.ts

src/app/auth.interceptors.ts

src/app/auth/services/auth.service.ts

src/app/auth/auth-routing.module.ts

src/app/auth/auth.module.ts

src/app/auth/auth.component.ts

src/app/auth/auth.component.scss

src/app/auth/auth.component.html

src/app/auth/components/login/login.component.ts

src/app/auth/components/login/login.component.html

src/app/auth/components/login/login.component.scss

src/app/auth/components/logout/logout.component.ts

src/app/auth/components/logout/logout.component.html

src/app/auth/components/logout/logout.component.scss

src/app/auth/components/registration/registration.component.ts

src/app/auth/components/registration/registration.component.html

src/app/auth/components/registration/registration.component.scss







Day 23:
Task: Use Angular services and HTTP client to fetch data from the SpringBoot application.
Modify the dashboard component to meet the following functionalities when a User with the role of "ADMIN" logs in:



Display teams, cricketers, and matches in table format.
Display a navbar on top with links to forms for adding teams, cricketers, and matches.
Implement IPL services to support the creation of teams, cricketers, and matches through these forms.
Implement the following files:

src/app/shared/shared.module.ts

src/app/shared/navbar/navbar.component.html

src/app/shared/navbar/navbar.component.ts

src/app/shared/navbar/navbar.component.scss

src/app/ipl/ipl.module.ts

src/app/ipl/components/cricketercreate/cricketercreate.component.ts

src/app/ipl/components/cricketercreate/cricketercreate.component.html

src/app/ipl/components/cricketercreate/cricketercreate.component.scss

src/app/ipl/components/teamcreate/teamcreate.component.ts

src/app/ipl/components/teamcreate/teamcreate.component.html

src/app/ipl/components/teamcreate/teamcreate.component.scss

src/app/ipl/components/matchcreate/matchcreate.component.ts

src/app/ipl/components/matchcreate/matchcreate.component.html

src/app/ipl/components/matchcreate/matchcreate.component.scss

src/app/ipl/components/dashboard/dashboard.component.html

src/app/ipl/components/dashboard/dashboard.component.ts

src/app/ipl/components/dashboard/dashboard.component.scss





Day 24:
Task: Modify the dashboard component to meet the following functionalities when a User with the role of "USER" logs in:
Display teams, cricketers, and matches in table format.
Ability to view votes.
Ability to view ticket bookings.
Allow users to vote for their favorite team or cricketer using a button in the navbar.
Enable users to book tickets for matches that are in the "Scheduled" status through a button in the navbar bar.
Complete the implementation in the file below:

src/app/ipl/components/dashboard/dashboard.component.ts

src/app/ipl/components/dashboard/dashboard.component.html

src/app/ipl/components/dashboard/dashboard.component.scss

src/app/ipl/components/vote/vote.component.html

src/app/ipl/components/vote/vote.component.ts

src/app/ipl/components/vote/vote.component.scss

src/app/ipl/components/ticketbooking/ticketbooking.component.html

src/app/ipl/components/ticketbooking/ticketbooking.component.ts

src/app/ipl/components/ticketbooking/ticketbooking.component.scss





Day 25:
Task: Update the Dashboard component for user of role “ADMIN” add functionality to perform the following tasks:
Ability to add/update/delete teams.
Ability to add/update/delete cricketers.
Ability to add/update/delete matches.
Ability to view votes.
Ability to view ticket bookings.
Make sure add/edit/delete buttons for teams, cricketers and matches are only visible to User of role “ADMIN”.
Complete the implementation in the file below:

src/app/ipl/ipl.module.ts

src/app/ipl/components/cricketeredit/cricketeredit.component.ts

src/app/ipl/components/cricketeredit/cricketeredit.component.html

src/app/ipl/components/cricketeredit/cricketeredit.component.scss

src/app/ipl/components/teamedit/teamedit.component.ts

src/app/ipl/components/teamedit/teamedit.component.html

src/app/ipl/components/teamedit/teamedit.component.scss

src/app/ipl/components/matchedit/matchedit.component.ts

src/app/ipl/components/matchedit/matchedit.component.html

src/app/ipl/components/matchedit/matchedit.component.scss

src/app/ipl/components/dashboard/dashboard.component.ts

src/app/ipl/components/dashboard/dashboard.component.html

src/app/ipl/components/dashboard/dashboard.component.scss





Day 26:
Task: Enhancement in UI design using the Bootstrap. Apply Bootstrap for responsive design and style enhancement.
Note: You are directed to craft well-designed web pages incorporating responsive design by utilizing Bootstrap. The page should be clean and professional while maintaining all the UI and UX needed to complete all the given tasks.