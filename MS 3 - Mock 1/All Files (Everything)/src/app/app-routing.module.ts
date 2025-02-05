import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CourseListComponent } from './course-list/course-list.component';
import { CourseFormComponent } from './course-form/course-form.component';





const routes: Routes = [
  { path: 'course-list', component: CourseListComponent },
  { path: 'course-form', component: CourseFormComponent },
  { path: '', redirectTo: '/course-list', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
