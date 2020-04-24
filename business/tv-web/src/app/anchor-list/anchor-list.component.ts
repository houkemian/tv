import { Component, OnInit } from '@angular/core';

import { AnchorService} from "../service/anchor.service";
import {Result} from "../result";

@Component({
  selector: 'app-anchor-list',
  templateUrl: './anchor-list.component.html',
  styleUrls: ['./anchor-list.component.css']
})
export class AnchorListComponent implements OnInit {

  constructor(private anchorService: AnchorService) { }

  anchorList = [];

  ngOnInit(): void {
    this.anchorService.getAnchorList().subscribe((data: Result) => this.anchorList = data.data);
  }

}
