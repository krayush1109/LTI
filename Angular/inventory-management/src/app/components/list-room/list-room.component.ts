import { Component, OnInit } from '@angular/core';
import {  Router } from '@angular/router';
import { Room } from 'src/app/models/room.model';
import { RoomService } from 'src/app/service/room.service';

@Component({
  selector: 'app-list-room',
  templateUrl: './list-room.component.html',
  styleUrls: ['./list-room.component.css']
})
export class ListRoomComponent implements OnInit {

  rooms: Room[] = [];

  constructor( private service: RoomService, private router: Router ){}

  reloadList(): void {
    this.service.getRooms().subscribe( (data) => {
      // console.log(data)
      this.rooms = data;
    } )
  }

  ngOnInit(): void {
    this.reloadList();
  }

  handleDelete(id: any): void {
    this.service.deleteRoom(id).subscribe(() => {
      this.reloadList();
    });
  }

}
