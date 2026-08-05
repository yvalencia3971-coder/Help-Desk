import { Component } from '@angular/core';
import { TicketForm } from './components/ticket-form/ticket-form';
import { TicketList } from './components/ticket-list/ticket-list';


@Component({

selector:'app-root',

standalone:true,

imports:[
  TicketForm,
  TicketList
],

templateUrl:'./app.html',

styleUrl:'./app.css'

})


export class App {

}