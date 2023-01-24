package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class TopCustomersReport {
    public static void generate(Map<Customer, Double> customerByMoneySpent) throws IOException, InterruptedException {
        FileWriter fw = new FileWriter("TaskTwoThread.csv");
        fw.write("Customer, Money Spent \n");

        TopCustomersReportThread c1 = new TopCustomersReportThread(customerByMoneySpent);

        Thread t2 = new Thread(c1);
        t2.start();
        t2.join();

        for (Map.Entry<Customer, Double> e : TopCustomersReportThread.sortedMap) {
            fw.write(e.getKey() + ", " + e.getValue() + "\n");
        }

        fw.close();
    }
}
