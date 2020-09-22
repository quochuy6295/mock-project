import { StudentDetailsComponent } from './screens/student/student-details/student-details.component';
import { CreateStudentComponent } from './screens/student/create-student/create-student.component';
import { TeamDetailsComponent } from './screens/team/team-details/team-details.component';
import { UpdateTeamComponent } from './screens/team/update-team/update-team.component';
import { ListUserComponent } from './screens/user/list-user/list-user.component';
import { UserDetailsComponent } from './screens/user/user-details/user-details.component';
import { ListTeamComponent } from './screens/team/list-team/list-team.component';
import { CreateTeamComponent } from './screens/team/create-team/create-team.component';
import { ListStudentComponent } from './screens/student/list-student/list-student.component';
import { UpdateUserComponent } from './screens/user/update-user/update-user.component';
import { CreateUserComponent } from './screens/user/create-user/create-user.component';
import { HomeComponent } from './screens/home/home.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
  },
  { path: 'home', component: HomeComponent, pathMatch: 'full' },
  {
    path: 'users',
    component: ListUserComponent,
  },
  {
    path: 'users/create',
    component: CreateUserComponent,
  },
  {
    path: 'users/update/:id',
    component: UpdateUserComponent,
  },
  {
    path: 'users/details/:id',
    component: UserDetailsComponent,
  },
  {
    path: 'teams',
    component: ListTeamComponent,
  },
  {
    path: 'teams/create',
    component: CreateTeamComponent,
  },
  {
    path: 'teams/add-user',
    component: UpdateTeamComponent,
  },
  {
    path: 'teams/remove-user',
    component: UpdateTeamComponent,
  },
  {
    path: 'teams/details',
    component: TeamDetailsComponent,
  },
  {
    path: 'students',
    component: ListStudentComponent,
  },
  {
    path: 'students/create',
    component: CreateStudentComponent,
  },
  {
    path: 'students/details',
    component: StudentDetailsComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
