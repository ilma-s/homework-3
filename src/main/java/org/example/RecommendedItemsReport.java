package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class RecommendedItemsReport {

    public static void generate(Map<String, Integer> customerByCredit, ArrayList<Item> allItems) throws IOException {
        FileWriter fw = new FileWriter("NewTask1Report.csv");
        fw.write("Customer, Recommended Product \n");

        for (Map.Entry<String, Integer> e : customerByCredit.entrySet()) {
            Double maxNum = 0.0;
            Item recommendation = null;

            for (Item i : allItems) {
                if (i.getPrice() <= e.getValue())
                    if (i.getPrice() >= maxNum)  {
                        maxNum = i.getPrice();
                        recommendation = i;
                    }
            }

            if (e.getValue() == 0) fw.write(e.getKey() + " has no credit \n");
            else fw.write(e.getKey() + ", " + recommendation + "\n");
        }

        fw.close();
    }
}
