import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { RoomService } from 'src/app/service/room.service';

@Component({
  selector: 'app-add-room',
  templateUrl: './add-room.component.html',
  styleUrls: ['./add-room.component.css']
})
export class AddRoomComponent {

  roomFrm: FormGroup;

  constructor(private fb: FormBuilder, private roomService: RoomService, private router: Router) {

    this.roomFrm = fb.group({
      name: ['', [Validators.required]],
      floor: ['', [Validators.required]  ],
      capacity: ['', [Validators.required]],
      lastInspection: ['', [Validators.required]],
      status: ['', [Validators.required]],
    })

  }

  handleSubmit(): void {
    
    const newRoom = {...this.roomFrm.value};

    this.roomService.addMovie(newRoom).subscribe( () => {
      this.router.navigateByUrl('/');
    } )

  }

}
