import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';

import { Ticket } from '../../models/ticket';
import { TicketService } from '../../services/ticket.service';

@Component({
  selector: 'app-ticket-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './ticket-list.html',
  styleUrl: './ticket-list.css'
})
export class TicketList implements OnInit {

  tickets: Ticket[] = [];

  constructor(private ticketService: TicketService){}

  ngOnInit(): void {

    this.cargarTickets();

  }

  cargarTickets(){

    this.ticketService.getTickets().subscribe(datos=>{

      this.tickets = datos;

    });

  }

  eliminar(id:number){

    this.ticketService.eliminarTicket(id).subscribe(()=>{

      this.cargarTickets();

    });

  }

}