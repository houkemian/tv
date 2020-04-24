import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class AnchorService {

  constructor(private http: HttpClient) { }

  prefix: string = "http://192.168.3.28:9001/anchor/anchor";
  api = {
    list: this.prefix,
    single: this.prefix+"/",
  }

  getAnchor(id) {
    return this.http.get(this.api.single+id);
  }

  getAnchorList(){
    return this.http.get(this.api.list);
  }
}
