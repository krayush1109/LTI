import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { CommonService } from '../services/common.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {
  userForm: FormGroup;  // FormGroup instance to manage the user form
  users: any;  // Array to hold the list of users
  editMode: boolean = false;  // Flag to determine if the form is in edit mode
  userIdToEdit: any = null;  // Store the ID of the user being edited

  constructor(private fb: FormBuilder, private service: CommonService) {
    // Initializing the form with FormBuilder
    this.userForm = this.fb.group({
      name: [''],
      email: [''],
      mobile: [''],
      age: ['']
    });
  }

  ngOnInit(): void {
    // Fetch all users when the component initializes
    this.getAllUsers();
  }

  // Method to handle form submission for adding a new user
  onSubmit() {
    if (this.userForm.valid) {
      this.service.AddNewUser(this.userForm.value).subscribe(data => {
        alert("User added successfully");
        this.userForm.reset();  // Reset the form after submission
        console.log(data);
        this.getAllUsers();  // Refresh the user list
      });
    }
  }

  // Method to handle updating an existing user
  onUpdateBtnClicked() {
    if (this.userForm.valid) {
      console.log("Id when update bng clicked is : ", this.userIdToEdit);
      this.service.updateUser(this.userIdToEdit, this.userForm.value).subscribe(data => {
        alert("User updated successfully");
        this.userForm.reset();  // Reset the form after updating

        // Reset edit mode flags
        this.editMode = false;
        this.userIdToEdit = null;
        console.log(data);

        this.getAllUsers();  // Refresh the user list
      });
    }
  }

  // Method to fetch and display all users
  getAllUsers() {
    this.service.getAllUsers().subscribe(data => {
      console.log("All Users: ", data);
      this.users = data;  // Assign fetched users to the users array
    });
  }

  // Method to fetch and display details of a specific user by ID
  getUserById(id: any) {
    this.service.getUserById(id).subscribe(data => {
      console.log("User Detail of particular id: ", data);
      this.userForm.patchValue({
        name: data.name,
        email: data.email,
        mobile: data.mobile,
        age: data.age
      });
      this.editMode = true;  // Set edit mode to true
      this.userIdToEdit = id;  // Store the ID of the user being edited
    });
  }

  // Method to delete a user by ID
  deleteUser(id: any) {
    this.service.deleteUserById(id).subscribe(data => {
      console.log("Deleted Button Clicked having id: " + id);
      this.getAllUsers();  // Refresh the user list after deletion
    });
  }

  // Method to initiate the edit process for a specific user
  editUser(id: any) {
    console.log("UPDATING USER DETAILS .....")
    console.log("Get User with id : " + id);

    this.service.getUserById(id).subscribe(data => {
      console.log(data);
      this.userForm.patchValue({
        name: data.name,
        email: data.email,
        mobile: data.mobile,
        age: data.age
      });
      
      this.editMode = true;  // Set edit mode to true
      this.userIdToEdit = data.id;  // Store the ID of the user being edited
    });
  }
}
