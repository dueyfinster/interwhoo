package com.ngrogan.customer_distance;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ngrogan.customer_distance.model.Customer;

public class ReadCustomers {

    public List<Customer> readJSONFileToCustomers(final String filePath) {
        List<Customer> customers;

        if (doesFileExist(filePath)) {
            final String jsonText = readFile(filePath);
            customers = convertJSONStringToCustomers(jsonText);
        } else {
            customers = Collections.EMPTY_LIST;
        }

        return customers;
    }

    private String readFile(final String filePath) {
        StringBuilder result = new StringBuilder();
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(filePath).getFile());

        try (final Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();
    }

    public List<Customer> convertJSONStringToCustomers(final String jsonLines) {
        List<Customer> customers = new ArrayList<Customer>();

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        String[] lines = jsonLines.split("[\\r\\n]+");

        for (String line : lines) {
            Customer customer = gson.fromJson(line, Customer.class);
            customers.add(customer);
        }

        return customers;
    }

    private boolean doesFileExist(final String filePath) {

        ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource(filePath);
        if (url != null) {
            File file = new File(classLoader.getResource(filePath).getFile());

            if (file != null) {
                return file.exists() && !file.isDirectory();
            }
        }

        return false;
    }
}
