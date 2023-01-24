package org.example;
import org.junit.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class CustomersSortedByCreditTest {
    @Test
    public void generate() throws IOException, InterruptedException {
        Map<String, Integer> customerByCredit = new HashMap<>();

        customerByCredit.put("Bob", 150);
        customerByCredit.put("Alice", 140);
        customerByCredit.put("Jane", 15);
        customerByCredit.put("John", 50);
        customerByCredit.put("Jack", 8);

        CustomersSortedByCredit.generate(customerByCredit);

        BufferedReader r = new BufferedReader(new FileReader("ThreadsTaskReport.csv"));

        assertEquals("Customer, Credit ", r.readLine());
        assertEquals("Bob, 150", r.readLine());
        assertEquals("Alice, 140", r.readLine());
        assertEquals("John, 50", r.readLine());
        assertEquals("Jane, 15", r.readLine());
        assertEquals("Jack, 8", r.readLine());

    }

}