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


    if (
      this.ticket.titulo.trim() === '' ||
      this.ticket.descripcion.trim() === '' ||
      this.ticket.categoria.trim() === ''
    ) {

      alert('Complete todos los campos');

      return;

    }


    this.ticketService.crearTicket(this.ticket)
      .subscribe({

        next: (respuesta: Ticket) => {

          console.log(
            'Ticket guardado:',
            respuesta
          );


          alert(
            'Ticket registrado correctamente'
          );


          this.limpiar();


          this.ticketCreado.emit();

        },


        error: (error) => {

          console.error(
            'Error:',
            error
          );


          alert(
            'Error al guardar ticket'
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