package menu;

import api.HotelResource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MainMenu {

    public static void main(String[] args) {
        rootmenu();
    }

    public static void rootmenu(){
        boolean keepRunning = true;
        Scanner scanner = new Scanner(System.in);
            while (keepRunning) {
                try {
                    System.out.println("1. Find and reserve a room");
                    System.out.println("2. See my reservation");
                    System.out.println("3. Create an account");
                    System.out.println("4. Admin");
                    System.out.println("5. Exit");
                    int selection = Integer.parseInt(scanner.nextLine());

                    if (selection == 1) {
                        Scanner scannerdate = new Scanner(System.in);
                        System.out.println("Enter check in date: mm-dd-yyyy");
                        String date1 = scannerdate.nextLine();
                        Date checkin = null;
                        try {
                            checkin = new SimpleDateFormat("MM-dd-yyyy").parse(date1);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Enter check out date: MM-dd-yyyy");
                        String date2 = scannerdate.nextLine();
                        Date checkout = null;
                        try {
                            checkout = new SimpleDateFormat("MM-dd-yyyy").parse(date2);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        HotelResource.findARoom(checkin, checkout);
                    }

                    if (selection == 2) {
                        Scanner scanneremail = new Scanner(System.in);
                        System.out.println("Enter your email address");
                        String email = scanneremail.nextLine();
                        HotelResource.getCustomerReservations(email);
                    }

                    if (selection == 3) {
                        Scanner scannercust = new Scanner(System.in);
                        System.out.println("Enter your email address");
                        String email = scannercust.nextLine();
                        System.out.println("Enter your first name");
                        String firstname = scannercust.nextLine();
                        System.out.println("Enter your last name");
                        String lastname = scannercust.nextLine();
                        HotelResource.createACustomer(email, firstname, lastname);
                        MainMenu.rootmenu();
                    }

                    if (selection == 4) {
                        AdminMenu.AdminMenu();
                    }

                    if (selection == 5) {
                        keepRunning = false;
                    }

                    else{
                        System.out.println("\nInvalid input. Valid selection is 1 to 5. Please try again. \n");
                    }
                }
                catch (Exception ex) {
                    System.out.println("\nInvalid input. Valid selection is 1 to 5. Please try again.\n\n");
                }
            }
        }


}
