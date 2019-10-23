import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomepageComponent } from './homepage/homepage.component';
import { ProfilpageComponent } from './profilpage/profilpage.component';

export const routes: Routes = [
  { path: '', pathMatch: 'full', component: HomepageComponent},
  { path: 'homepage', component: HomepageComponent },
  { path: 'profil', component: ProfilpageComponent },
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
