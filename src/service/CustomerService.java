package service;

import model.*;

import java.util.*;

public class CustomerService {
    static Map<String, Customer> mapOfPeople = new HashMap<String, Customer>();
    public static void addCustomer(String email, String firstname, String lastname){
        Customer customer = new Customer(firstname,lastname,email);
        mapOfPeople.put(customer.getEmail(), customer);
    }

   public static Customer getCustomer(String customerEmail){
        return mapOfPeople.get(customerEmail);
   }


   public static Collection<Customer> getAllCustomers(){
        return mapOfPeople.values();
   }


}
