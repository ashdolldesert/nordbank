import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CleavejsComponent } from 'src/app/cleavejs/cleavejs.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'cleavejs', component: CleavejsComponent },
  // { path: '**', component: PageNotFoundComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
