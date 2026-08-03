import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { TicketService } from '../../services/ticket.service';
import { Ticket } from '../../models/ticket';

@Component({
  selector: 'app-ticket-form',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './ticket-form.html',
  styleUrl: './ticket-form.css'
})
export class TicketForm {

  ticket: Ticket = {
    titulo: '',
    descripcion: '',
    categoria: '',
    prioridad: '',
    estado: 'Abierto'
  };

  constructor(private ticketService: TicketService) {}

  guardar() {

    this.ticketService.crearTicket(this.ticket).subscribe(() => {

      alert("Ticket registrado correctamente");

      this.ticket = {
        titulo: '',
        descripcion: '',
        categoria: '',
        prioridad: '',
        estado: 'Abierto'
      };

      location.reload();

    });

  }

}