import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BannerComponent } from './banner/banner.component';
import { FooterComponent } from './footer/footer.component';
import { MenuLeftComponent } from './menu-left/menu-left.component';
import { HomeComponent } from './screens/home/home.component';
import { CreateUserComponent } from './screens/user/create-user/create-user.component';
import { ListUserComponent } from './screens/user/list-user/list-user.component';
import { UserDetailsComponent } from './screens/user/user-details/user-details.component';
import { CreateTeamComponent } from './screens/team/create-team/create-team.component';
import { ListTeamComponent } from './screens/team/list-team/list-team.component';
import { TeamDetailsComponent } from './screens/team/team-details/team-details.component';
import { ListStudentComponent } from './screens/student/list-student/list-student.component';
import { StudentDetailsComponent } from './screens/student/student-details/student-details.component';
import { UpdateUserComponent } from './screens/user/update-user/update-user.component';
import { CreateStudentComponent } from './screens/student/create-student/create-student.component';
import { UpdateTeamComponent } from './screens/team/update-team/update-team.component';
import { ErrorComponent } from './error/error/error.component';
import { NgxCsvParserModule } from 'ngx-csv-parser';
import { StudentService } from './service/student/student.service';
@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    BannerComponent,
    MenuLeftComponent,
    HomeComponent,
    CreateUserComponent,
    ListUserComponent,
    UserDetailsComponent,
    CreateTeamComponent,
    ListTeamComponent,
    TeamDetailsComponent,
    ListStudentComponent,
    StudentDetailsComponent,
    UpdateUserComponent,
    CreateStudentComponent,
    UpdateTeamComponent,
    ErrorComponent,

  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    AppRoutingModule,
    NgxCsvParserModule,
    ReactiveFormsModule,
  ],
  providers: [StudentService],
  bootstrap: [AppComponent],
})
export class AppModule {}
