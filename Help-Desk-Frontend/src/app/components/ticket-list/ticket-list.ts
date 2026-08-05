import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
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
  totalAbiertos = 0;
  totalProceso = 0;
  totalResueltos = 0;

 constructor(
 private ticketService: TicketService,
 private cd: ChangeDetectorRef
){}



  ngOnInit(): void {


    console.log("TicketList iniciado");


    this.cargarTickets();


  }



  cargarTickets(): void {

  this.ticketService.getTickets()
    .subscribe({

      next: (datos: Ticket[]) => {

       this.tickets = datos;


      this.totalAbiertos =
      this.tickets.filter(
      t => t.estado === 'Abierto'
      ).length;


      this.totalProceso =
      this.tickets.filter(
      t => t.estado === 'En Proceso'
      ).length;


      this.totalResueltos =
      this.tickets.filter(
      t => t.estado === 'Resuelto'
      ).length;


      this.cd.detectChanges();

      },

      error: (error: any) => {

        console.error(
          "Error cargando tickets:",
          error
        );

      }

    });

}



  eliminarTicket(id:number):void {


    this.ticketService.eliminarTicket(id)
      .subscribe({


        next:()=>{


          alert(
            "Ticket eliminado correctamente"
          );


          this.cargarTickets();


        },


        error:(error:any)=>{


          console.error(
            "Error eliminando ticket:",
            error
          );


        }


      });


  }


}