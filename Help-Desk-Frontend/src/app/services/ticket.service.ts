import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Ticket } from '../models/ticket';


@Injectable({
  providedIn: 'root'
})
export class TicketService {


  private url = 'http://localhost:8080/tickets';


  constructor(
    private http: HttpClient
  ) {}



  // Obtener todos los tickets
  getTickets(): Observable<Ticket[]> {

    return this.http.get<Ticket[]>(this.url);

  }



  // Crear ticket
  crearTicket(ticket: Ticket): Observable<Ticket> {

    return this.http.post<Ticket>(
      this.url,
      ticket
    );

  }



  // Eliminar ticket
  eliminarTicket(id: number): Observable<void> {

    return this.http.delete<void>(
      `${this.url}/${id}`
    );

  }


}