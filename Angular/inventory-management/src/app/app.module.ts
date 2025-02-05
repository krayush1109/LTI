import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddRoomComponent } from './components/add-room/add-room.component';
import { ListRoomComponent } from './components/list-room/list-room.component';
import { RouterModule } from '@angular/router';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { View1RoomComponent } from './components/view1-room/view1-room.component';
import { EditRoomComponent } from './components/edit-room/edit-room.component';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    AddRoomComponent,
    ListRoomComponent,
    View1RoomComponent,
    EditRoomComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule,

    HttpClientModule, // add this manually
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
