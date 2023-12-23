package com.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Methods  implements Details {
    List<DetailsImpl> dc = new ArrayList<>();


    public void addDetails(Scanner sc) {
        System.out.println("Enter Id");
        int id = sc.nextInt();
        System.out.println("Enter First Name");
        String firstName = sc.next();
        System.out.println("Enter Last Name");
        String lastName = sc.next();
        System.out.println("Enter City");
        String city = sc.next();
        System.out.println("Enter Email");
        String emailAddress = sc.next();
        if (Pattern.compile("^(.+)@(\\S+)$").matcher(emailAddress).matches()) {
            dc.add(new DetailsImpl(id, firstName, lastName, city, emailAddress));
        }
        else{
            System.out.println("Error emailaddress ");
        }


    }

    public void writeFile() {
        //Reading data first in the file
        try {
            FileInputStream file = new FileInputStream("details.txt");
            ObjectInputStream in = new ObjectInputStream(file);
            List<DetailsImpl>  d1 = (List<DetailsImpl>) in.readUnshared();
            for (DetailsImpl i:d1
                 ) {dc.add(new DetailsImpl(i.getId(),i.getFirstName(),i.getLastName(),i.getCity(),i.getEmail()));
            }
            in.close();
            file.close();

        } catch (Exception ex) {
            System.out.println("error : " + ex);
        }

        //and storing in dc list then writing into file

        try {
            FileOutputStream f = new FileOutputStream("details.txt");
            ObjectOutputStream out = new ObjectOutputStream(f);
            out.writeObject(dc);
            out.close();
            f.close();

        } catch (Exception e) {
            System.out.println("writer");
        }
    }
    public void displayDetails() {
        try {
            FileInputStream file = new FileInputStream("details.txt");
            ObjectInputStream in = new ObjectInputStream(file);
            List<DetailsImpl> d1 = (List<DetailsImpl>) in.readUnshared();
            System.out.println("Personal Details :  ");
            for (DetailsImpl i : d1) {
                System.out.println();
                System.out.println("Id        : " + i.getId());
                System.out.println("First Name: " + i.getFirstName());
                System.out.println("Last  Name: " + i.getLastName());
                System.out.println("City      : " + i.getCity());
                System.out.println("Email     : " + i.getEmail());
            }
            in.close();
            file.close();

        } catch (Exception ex) {
           System.out.println("error : " + ex);
        }
    }

}