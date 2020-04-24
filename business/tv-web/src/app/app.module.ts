import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { RouterModule, Routes} from "@angular/router";
import { HttpClientModule} from "@angular/common/http";

import { AnchorListComponent } from './anchor-list/anchor-list.component';
import { AnchorComponent } from './anchor/anchor.component';
import { PlayerComponent } from './player/player.component';

const appRoutes: Routes = [
  {path: '', component: AnchorListComponent},
  {path: ':roomId', component: PlayerComponent},
];

@NgModule({
  declarations: [
    AppComponent,
    AnchorListComponent,
    AnchorComponent,
    PlayerComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes, {enableTracing:true})
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
