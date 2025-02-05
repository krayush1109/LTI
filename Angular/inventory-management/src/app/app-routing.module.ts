import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListRoomComponent } from './components/list-room/list-room.component';
import { AddRoomComponent } from './components/add-room/add-room.component';
import { View1RoomComponent } from './components/view1-room/view1-room.component';
import { EditRoomComponent } from './components/edit-room/edit-room.component';

const routes: Routes = [
  { path: '', redirectTo: "/rooms", pathMatch: 'full' },
  { path: 'rooms', component: ListRoomComponent },
  { path: 'add', component: AddRoomComponent },
  { path: 'view/:id', component: View1RoomComponent },
  { path: 'edit/:id', component: EditRoomComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
