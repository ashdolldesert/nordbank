import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { NgxCleaveDirectiveModule } from 'ngx-cleave-directive';
import { CleavejsComponent } from './cleavejs/cleavejs.component';

@NgModule({
  declarations: [
    AppComponent,
    CleavejsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgxCleaveDirectiveModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
