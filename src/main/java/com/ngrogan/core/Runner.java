package com.ngrogan.core;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import com.ngrogan.array_flatten.ArrayFlatterer;
import com.ngrogan.customer_distance.CalculateDistance;
import com.ngrogan.customer_distance.CustomerComparator;
import com.ngrogan.customer_distance.ReadCustomers;
import com.ngrogan.customer_distance.model.Customer;

public final class Runner {

    private Runner(){}

    public static void main(final String[] args) throws IOException {
        Runner r = new Runner();
        flattenNestedArrays();
        printPartyList(r.getFilePath());
    }
    
    public static void flattenNestedArrays() {

        int[] a = {1};
        int[][] b = {{2}, {3, 4}};
        Object[][] c = {{5}, {6, 7, new Object[] {new int[] {8, 9}}}};
        Object[][] d = {{10}, {11, 12, new Object[] {new int[] {13, 14}, new int[][] {new int[] {15, 16}}}}};

        List<Object> startArray = new ArrayList<Object>();
        startArray.add(a);
        startArray.add(b);
        startArray.add(c);
        startArray.add(d);

        ArrayFlatterer arrayFlatterer = new ArrayFlatterer();
        List<Integer> allIntegersInArrays = arrayFlatterer.flattenNestedArrays(startArray);
        System.out.println("Arrays Flattened: \n" +allIntegersInArrays + "\n");
    }


    private static void printPartyList(final String filePath){
        ReadCustomers rc = new ReadCustomers();
        List<Customer> customers = rc.readJSONFileToCustomers(filePath);

        CalculateDistance cd = new CalculateDistance(customers);
        List<Customer> customersToBeInvited = cd.getCustomersWithinRange();

        Collections.sort(customersToBeInvited, new CustomerComparator());

        System.out.println("Customers Invited: \n" + customersToBeInvited + "\n");

    }
    
    private String getFilePath() throws IOException{
        final String fileName = "customers.json";
        
        final File jarFile = new File(getClass().getProtectionDomain().getCodeSource().getLocation().getPath());

        if(jarFile.isFile()) {
            URL fileURL = this.getClass().getResource("/" + fileName);
            File fireFile = new File(fileURL.toString());
            return fireFile.getPath();
        }
        return fileName;
    }
    
}
