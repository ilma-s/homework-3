package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class CustomersSortedByCredit {

    public static void generate(Map<String, Integer> customerByCredit) throws IOException, InterruptedException {
        FileWriter fw = new FileWriter("ThreadsTaskReport.csv");
        fw.write("Customer, Credit \n");

        CustomerCreditThread c1 = new CustomerCreditThread(customerByCredit);

        Thread t1 = new Thread(c1);
        t1.start();
        t1.join();

        for (Map.Entry<String, Integer> e : CustomerCreditThread.sortedMap) {
            fw.write(e.getKey() + ", " + e.getValue() + "\n");
        }

        fw.close();
    }

}
