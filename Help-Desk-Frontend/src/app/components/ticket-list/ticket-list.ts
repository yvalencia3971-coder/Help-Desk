import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TicketService } from '../../services/ticket.service';
import { Ticket } from '../../models/ticket';


@Component({

  selector: 'app-ticket-list',

  standalone: true,

  imports:[
    CommonModule
  ],

  templateUrl:'./ticket-list.html',

  styleUrl:'./ticket-list.css'

})


export class TicketList implements OnInit {


tickets: Ticket[] = [];


constructor(
 private ticketService: TicketService
){}



ngOnInit(): void {

 this.cargarTickets();

}



cargarTickets():void{


this.ticketService.getTickets()
.subscribe({

next:(datos)=>{


this.tickets = datos;


console.log(
"Tickets cargados:",
this.tickets
);


},


error:(error)=>{


console.error(
"Error cargando tickets:",
error
);


}


});


}



eliminarTicket(id:number){


this.ticketService.eliminarTicket(id)
.subscribe(()=>{


this.cargarTickets();


});


}



}