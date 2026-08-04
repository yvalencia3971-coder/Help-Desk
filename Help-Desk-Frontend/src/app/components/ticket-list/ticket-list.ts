import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TicketService } from '../../services/ticket.service';
import { Ticket } from '../../models/ticket';


@Component({
  selector: 'app-ticket-list',
  standalone: true,
  imports: [
    CommonModule
  ],
  templateUrl: './ticket-list.html',
  styleUrl: './ticket-list.css'
})
export class TicketList implements OnInit {


  tickets: Ticket[] = [];


  constructor(
    private ticketService: TicketService
  ) {}


  ngOnInit(): void {

    console.log("TicketList iniciado");

    this.cargarTickets();

  }



  cargarTickets(): void {


    console.log("Entró a cargarTickets");


    this.ticketService.getTickets()
      .subscribe({


        next: (datos: Ticket[]) => {


          console.log("Datos recibidos desde API:", datos);


          // Fuerza la actualización de Angular
          this.tickets = [...datos];


          console.log(
            "Cantidad de tickets en tabla:",
            this.tickets.length
          );


          console.log(
            "Tickets guardados en variable:",
            this.tickets
          );


        },


        error: (err: any) => {


          console.error(
            "Error al obtener tickets:",
            err
          );


        }


      });


  }



  eliminarTicket(id: number): void {


    this.ticketService.eliminarTicket(id)
      .subscribe({


        next: () => {


          alert(
            "Ticket eliminado correctamente"
          );


          // Recargar lista después de eliminar
          this.cargarTickets();


        },


        error: (err: any) => {


          console.error(
            "Error al eliminar ticket:",
            err
          );


          alert(
            "Error al eliminar el ticket"
          );


        }


      });


  }


}