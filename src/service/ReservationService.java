package service;

import model.*;

import java.text.SimpleDateFormat;
import java.util.*;

public class ReservationService {

    static Collection<Reservation> reservations = new HashSet<>();
    static Map<String, IRoom> rooms = new HashMap<String, IRoom>();


    public void addRoom(IRoom room) {
        rooms.put(room.getRoomNumber(), room);

    }

    public static IRoom getARoom(String roomID) {
        return rooms.get(roomID);

    }

    public static Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
        reservations.add(reservation);
        return reservation;

    }

    public Collection<IRoom> findARoom(Date checkInDate, Date checkOutDate) {
        // ref: https://www.baeldung.com/java-between-dates
        Collection<IRoom> listOfRoom = new HashSet<IRoom>();
        List<Date> datesInRange = new ArrayList<>();
        Calendar startCalendar = new GregorianCalendar();
        startCalendar.setTime(checkInDate);

        Calendar endCalendar = new GregorianCalendar();
        endCalendar.setTime(checkOutDate);

        while (startCalendar.before(endCalendar)) {
            Date result = startCalendar.getTime();
            datesInRange.add(result);
            startCalendar.add(Calendar.DATE, 1);
        }

        Iterator iterator = datesInRange.iterator();

        while(iterator.hasNext()){
            for (Reservation reservation: reservations
                 ) {if (reservation.getCheckInDate() != iterator) {
                        System.out.println(reservation.getRoom());
                        listOfRoom.add(reservation.getRoom());
                    }

            }
        }
        return listOfRoom;

    }


    public static Collection<Reservation> getCustomersReservation (Customer customer){
        Collection<Reservation> resCollection = new ArrayList<Reservation>();

        for (Reservation reservation: reservations
             ) {if (reservation.getCustomer() == customer){
                 resCollection.add(reservation);
                }
        }
        return resCollection;

    }

    public void printAllReservation () {
        System.out.println(reservations);

    }

}
