import { Component, Output, EventEmitter } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { TicketService } from '../../services/ticket.service';
import { Ticket } from '../../models/ticket';


@Component({
  selector: 'app-ticket-form',
  standalone: true,
  imports: [
    FormsModule
  ],
  templateUrl: './ticket-form.html',
  styleUrl: './ticket-form.css'
})
export class TicketForm {
@Output() ticketCreado = new EventEmitter<void>();

  ticket: Ticket = {

    titulo: '',
    descripcion: '',
    categoria: '',
    prioridad: 'Media',
    estado: 'Abierto'
  };

  constructor(
    private ticketService: TicketService
  ) {}

  guardar(): void {


  // Validar campos obligatorios
  if (
    this.ticket.titulo.trim() === '' ||
    this.ticket.descripcion.trim() === '' ||
    this.ticket.categoria.trim() === ''
  ) {

    alert('Por favor complete todos los campos obligatorios');

    return;

  }


  this.ticketService.crearTicket(this.ticket)
    .subscribe({

      next: (respuesta: Ticket) => {


        console.log(
          'Ticket creado:',
          respuesta
        );


        alert(
          'Ticket registrado correctamente'
        );


        this.limpiar();
        this.ticketCreado.emit();

      },


      error: (error: any) => {


        console.error(
          'Error al registrar ticket:',
          error
        );


        alert(
          'Error al registrar ticket'
        );


      }


    });


}



  limpiar(): void {


    this.ticket = {

      titulo: '',

      descripcion: '',

      categoria: '',

      prioridad: 'Media',

      estado: 'Abierto'

    };


  }


}