import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { RoomService } from 'src/app/service/room.service';

@Component({
  selector: 'app-view1-room',
  templateUrl: './view1-room.component.html',
  styleUrls: ['./view1-room.component.css']
})
export class View1RoomComponent implements OnInit{

    room:any;

    id: any;

    constructor(private service: RoomService, private route: ActivatedRoute ) {}

    ngOnInit(): void{
        // this.id = this.route.snapshot.paramMap.get('id'
        this.id = this.route.snapshot.paramMap.get('id')
        this.service.getRoomById(this.id).subsr 
    }

}
