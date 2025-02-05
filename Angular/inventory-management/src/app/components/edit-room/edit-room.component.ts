import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { RoomService } from 'src/app/service/room.service';

@Component({
  selector: 'app-edit-room',
  templateUrl: './edit-room.component.html',
  styleUrls: ['./edit-room.component.css']
})
export class EditRoomComponent implements OnInit {

  roomFrm: FormGroup;
  roomId: any;

  constructor(
    private fb: FormBuilder, 
    private roomService: RoomService, 
    private route: ActivatedRoute,
    private router: Router) {


      this.roomFrm = this.fb.group({
          name: ['', [Validators.required]],
          floor: ['', [Validators.required]  ],
          capacity: ['', [Validators.required]],
          lastInspection: ['', [Validators.required]],
          status: ['', [Validators.required]],
      })

    }

  ngOnInit(): void {
    this.roomId = this.route.snapshot.paramMap.get('id');

    this.roomService.getRoomById(this.roomId).subscribe((data) => {
      console.log(data);
      this.roomFrm.patchValue(data);
    } )


    // console.log(this.roomId);
  }

  handleUpdate(){
    if(this.roomFrm.valid){
      this.roomService.updateRoom({...this.roomFrm.value}, this.roomId).subscribe(()=>{
        this.router.navigateByUrl('/');
      });
    }
  }

}
