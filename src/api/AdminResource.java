package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import javax.imageio.spi.RegisterableService;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AdminResource {
    public static Customer getCustomer(String email){
        return CustomerService.getCustomer(email);
    }

    public static void addRoom(List<IRoom> rooms){
        for (IRoom room: rooms
             ) {
            ReservationService.addRoom(room);
        }
    }

    public static Collection<IRoom> getAllRooms(){

        return ReservationService.getAllRooms();
    }

    public static Collection<Customer> getAllCustomers(){
        return CustomerService.getAllCustomers();
    }

    public static void displayAllReservations(){
        ReservationService.printAllReservation();
    }

}
