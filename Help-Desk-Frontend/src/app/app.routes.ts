import { Routes } from '@angular/router';
import { TicketList } from './components/ticket-list/ticket-list';
import { TicketForm } from './components/ticket-form/ticket-form';

export const routes: Routes = [

  {
    path: '',
    component: TicketList
  },

  {
    path: 'crear-ticket',
    component: TicketForm
  }

];