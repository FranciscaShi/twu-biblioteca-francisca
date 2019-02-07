package com.twu.dao;

import com.twu.dto.CustomerDto;

import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl {
    public static final int INITIAL_VALUE = 0;
    List<CustomerDto> customers;

    public CustomerDaoImpl(){

        customers = new ArrayList<CustomerDto>();
        CustomerDto customer1 = new CustomerDto("Constanza","coni@mail.com","111111",
                "123-4444","coni");

        CustomerDto customer2 = new CustomerDto("Maite","maite@mail.com","2222222",
                "333-4444","maite");

        customers.add(customer1);
        customers.add(customer2);
    }

    public List<CustomerDto> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerDto> customers) {
        this.customers = customers;
    }

    public boolean checkCustomerLibraryNumber(String libraryNumber){
        for (int index = 0; index < customers.size(); index++) {
            if(customers.get(index).getLibraryNumber().equalsIgnoreCase(libraryNumber)){
                return true;
            }
        }
        return false;
    }

    public boolean checkCustomerPassword(String password){
        for (int index = 0; index < customers.size(); index++) {
            if(customers.get(index).getPassword().equalsIgnoreCase(password)){
                return true;
            }
        }
        return false;
    }

    public boolean loginUsuario(String libraryNumber,String password){
        if (this.checkCustomerLibraryNumber(libraryNumber) && this.checkCustomerPassword(password)){
            return true;
        }
        return false;
    }

    public String seeUserInformation(String libraryNumber){
        for (int index = 0; index < customers.size(); index++) {
            if (this.checkCustomerLibraryNumber(libraryNumber)){
                return customers.get(index).getName()+" "+customers.get(index).getEmail()+" "+
                        customers.get(index).getPhoneNumber();
            }
        }
        return null;
    }
}
