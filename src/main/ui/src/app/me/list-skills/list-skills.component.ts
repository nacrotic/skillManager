import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Skill } from 'src/app/shared/skill';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-list-skills',
  templateUrl: './list-skills.component.html',
  styleUrls: ['./list-skills.component.css']
})
export class ListSkillsComponent implements OnInit {
  skills: Skill[] = []
  displayedColumns = ["label", "details"]
  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.http.get<Skill[]>(environment.backend.url + "/skill")
      .subscribe(body => this.skills = body)
  }

}
