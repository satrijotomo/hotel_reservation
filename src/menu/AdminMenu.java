package menu;

import api.AdminResource;
import model.Customer;
import model.IRoom;
import model.Room;
import model.RoomType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class AdminMenu {
        public static void AdminMenu(){
            boolean keeprunning = true;
            Scanner scanneradm= new Scanner(System.in);

            while (keeprunning){
                try{
                    System.out.println("1. See all Customers");
                    System.out.println("2. See all Rooms");
                    System.out.println("3. see all Reservations");
                    System.out.println("4. Add a Room");
                    System.out.println("5. Back to Main Menu");
                    int selectionadm = Integer.parseInt(scanneradm.nextLine());

                    if (selectionadm ==1 ){
                        Collection<Customer> allcusts = AdminResource.getAllCustomers();
                        for (Customer customer: allcusts
                        ) {
                            System.out.println(customer.toString());
                        }
                        System.out.println("\n");
                    }

                    if (selectionadm ==2 ){
                        Collection<IRoom> allrooms =  AdminResource.getAllRooms();
                        for (IRoom room: allrooms
                        ) {
                            room.toString();
                        }
                        System.out.println("\n");
                    }

                    if (selectionadm ==3 ){
                        AdminResource.displayAllReservations();
                        System.out.println("\n");
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
                        IRoom newroom = new Room(roomNumber, price, roomtype, true);
                        rooms2add.add(newroom);
                        AdminResource.addRoom(rooms2add);

                        System.out.println("\n");
                    }

                    if (selectionadm ==5 ){
                        keeprunning = false;

                    }
                } catch (Exception e){
                    System.out.println("nInvalid input. Valid selection is 1 to 5. Please try again.\n\n");
                }
            }


        }


}


