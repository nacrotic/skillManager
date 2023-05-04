import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { MsalService } from '@azure/msal-angular';


const GRAPH_ENDPOINT = environment.microsoft.graph.endpoint;

type ProfileType = {
  givenName?: string,
  surname?: string,
  userPrincipalName?: string,
  id?: string,
  officeLocation?: string,
  roles?: string[],
  token?: string,
};

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  profile!: ProfileType | undefined;

  constructor(
    private http: HttpClient,
    private msalService: MsalService,
  ) { }

  ngOnInit() {
    this.getProfile();
  }

  getProfile() {
    localStorage.getItem('profile')
    this.http.get(GRAPH_ENDPOINT)
      .subscribe(profile => {
        this.profile = profile;
        if (this.profile.id) {
          const info = this.msalService.instance.getAccountByLocalId(this.profile.id);
          this.profile.roles = info?.idTokenClaims?.roles
          this.profile.token = info?.idToken
        }
      });
  }
}