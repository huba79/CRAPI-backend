/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.swagger.api;

import io.swagger.model.Reservations;
import java.util.ArrayList;
import java.util.List;
import io.swagger.ReservationsRepository;

/**
 *
 * @author huba.tanczos
 */
//Reservation validator: cannot place a reservation for a stage being used in the requested interval
public class NewReservationValidator {
    ReservationsRepository repository;
    Reservations reservation;
    public NewReservationValidator(ReservationsRepository pRepository,Reservations data){
        this.reservation = data;
        this.repository = pRepository;
    }

    public boolean validateReservation() {
        List<Reservations> reservationsList = new ArrayList<>();
            reservationsList = repository.findByStageIdAndDateFromAndDateToNamedParams(reservation.getStageId(), 
                                reservation.getDateFrom(),reservation.getDateTo());
        return reservationsList.isEmpty();
    }

}
