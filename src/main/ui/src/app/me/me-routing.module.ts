import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MsalGuard } from '@azure/msal-angular';
import { RouterModule, Routes } from '@angular/router';
import { ListSkillsComponent } from './list-skills/list-skills.component';
import { BrowserUtils } from '@azure/msal-browser';
import { ProfileComponent } from './profile/profile.component';


const routes: Routes = [
  {
    path: 'me',
    canActivate: [MsalGuard],
    children: [
      {
        path: '',
        component: ListSkillsComponent
      },
      {
        path: 'profile',
        component: ProfileComponent
      }
    ]
  }
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes, {
      initialNavigation: !BrowserUtils.isInIframe() && !BrowserUtils.isInPopup() ? 'enabledNonBlocking' : 'disabled'
    })
  ],
  exports: [RouterModule]
})
export class MeRoutingModule { }
