import { Component } from '@angular/core';
import { DomSanitizer} from "@angular/platform-browser";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'tv-web';

  url = 'rtmp://192.168.3.38/live/8888';
  safeUrl: any;

  constructor(private sanitizer: DomSanitizer) {
    this.getUrl(this.url);
  }

  getUrl(url: string) {
    this.safeUrl = this.sanitizer.bypassSecurityTrustUrl(url);  // 获取安全链接
  }
}
