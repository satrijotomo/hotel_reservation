package menu;

import api.AdminResource;
import model.IRoom;
import model.Room;
import model.RoomType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminMenu {
        public static void AdminMenu(){
            Scanner scanneradm= new Scanner(System.in);
            System.out.println("1. See all Customers");
            System.out.println("2. See all Rooms");
            System.out.println("3. see all Reservations");
            System.out.println("4. Add a Room");
            System.out.println("5. Back to Main Menu");
            int selectionadm = Integer.parseInt(scanneradm.nextLine());

            if (selectionadm ==1 ){
                AdminResource.getAllCustomers();
            }

            if (selectionadm ==2 ){
                AdminResource.getAllRooms();
            }

            if (selectionadm ==3 ){
                AdminResource.displayAllReservations();
            }

            if (selectionadm ==4 ){
                //Room(String roomNumber, Double price, RoomType enumeration)
                Scanner scannerroom= new Scanner(System.in);
                System.out.println("Enter room number: ");
                String roomNumber = scannerroom.nextLine();
                System.out.println("Enter room price: ");
                Double price = Double.parseDouble(scannerroom.nextLine());
                System.out.println("Enter room type (SINGLE/DOUBLE): ");
                RoomType roomtype = RoomType.valueOf(scannerroom.nextLine());

                List<IRoom> rooms2add = new ArrayList<>();
                IRoom newroom = new Room(roomNumber, price, roomtype);
                rooms2add.add(newroom);
                AdminResource.addRoom(rooms2add);
            }

            if (selectionadm ==5 ){
                MainMenu.rootmenu();

            }

        }


}


