import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MeRoutingModule } from './me-routing.module';
import { ListSkillsComponent } from './list-skills/list-skills.component';
import { ProfileComponent } from './profile/profile.component';
import { HttpClientModule } from '@angular/common/http';
import { MatTableModule } from '@angular/material/table'



@NgModule({
  declarations: [
    ListSkillsComponent,
    ProfileComponent
  ],
  imports: [
    CommonModule,
    MeRoutingModule,
    HttpClientModule,
    MatTableModule,
  ]
})
export class MeModule { }
