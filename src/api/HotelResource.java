package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.Date;

public class HotelResource {

    public Customer getCustomer(String email){
        return CustomerService.getCustomer(email);
    }

    public void createACustomer(String email, String firstname, String lastname){
        CustomerService.addCustomer(email, firstname, lastname);
    }

    public IRoom getRoom(String roomNumber){
        return ReservationService.getARoom(roomNumber);
    }

    public Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate){
        return ReservationService.reserveARoom(CustomerService.getCustomer(customerEmail), room, checkInDate, checkOutDate);
    }

    public Collection<Reservation> getCustomerReservations(String customerEmail){
        return ReservationService.getCustomersReservation(CustomerService.getCustomer(customerEmail));

    }

    public Collection<IRoom> findARoom(Date checkIn, Date checkOut){
        return null;
    }

}
