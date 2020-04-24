import { Component, OnInit } from '@angular/core';
import {AnchorService} from "../service/anchor.service";

@Component({
  selector: 'app-anchor',
  templateUrl: './anchor.component.html',
  styleUrls: ['./anchor.component.css']
})
export class AnchorComponent implements OnInit {

  constructor(private anchorService : AnchorService) { }

  ngOnInit(): void {
    this.anchorService.getAnchor("1").subscribe((data: Object) => console.info(data));
  }

}
