import {Component, OnDestroy, OnInit} from '@angular/core';
import {ActivatedRoute, ParamMap} from "@angular/router";
import { Router } from "@angular/router";
import { DomSanitizer} from "@angular/platform-browser";
import { ElementRef} from '@angular/core';
import {AnchorService} from "../service/anchor.service";

import videojs from 'video.js';
import {Result} from "../result";
import {Anchor} from "../entity/anchor";

// import '~video.js/dist/video-js.css';

@Component({
  selector: 'app-player',
  templateUrl: './player.component.html',
  styleUrls: ['./player.component.css']
})
export class PlayerComponent implements OnInit,OnDestroy {

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private sanitizer: DomSanitizer,
    private anchorService: AnchorService
  ) { }

  rmtpUrl: any;

  player: videojs.Player;

  anchor: Anchor = {state:"OFF",key:""};

  roomId: string;


  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      this.roomId = params.get("roomId");
    })
    this.anchorService.getAnchor(this.roomId).subscribe((data: Result) => {
      if (data.success==true) {
        this.anchor = data.data;
        console.info(this.anchor);
        if (this.anchor.state == 'ON') {
          let url = "rtmp://192.168.3.38/live/" + this.anchor.key;
          this.rmtpUrl = this.sanitizer.bypassSecurityTrustUrl(url);
          // this.options.sources[0].src = this.rmtpUrl;
        }
      }
    });

    this.player = videojs("tv-player");
    console.info(this.player);
  }

  ngOnDestroy(): void {
    if (this.player) {
      this.player.dispose();
    }
  }

}
