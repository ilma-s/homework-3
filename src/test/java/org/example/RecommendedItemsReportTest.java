package org.example;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class RecommendedItemsReportTest {
    @Test
    public void generate() throws IOException {
        Map<String, Integer> customerByCredit = new HashMap<>();
        customerByCredit.put("Bob", 150); //
        customerByCredit.put("Alice", 140);//
        customerByCredit.put("Jane", 15);
        customerByCredit.put("John", 50);
        customerByCredit.put("Jack", 8); //

        ArrayList<Item> allItems = new ArrayList<>();
        allItems.add(new Item("Ball", 150.0, 15, "sports equipment"));
        allItems.add(new Item("Cake", 5.0, 14, "food"));
        allItems.add(new Item("Sofa", 138.0, 158, "furniture"));
        allItems.add(new Item("Book", 14.0, 15, "book"));
        allItems.add(new Item("Laptop", 36.0, 14, "electronics"));

        RecommendedItemsReport.generate(customerByCredit, allItems);

        BufferedReader r = new BufferedReader(new FileReader("NewTask1Report.csv"));

        assertEquals("Customer, Recommended Product ", r.readLine());
        assertEquals("Bob, Item: {name: Ball price: 150.0 quantity: 15 category: sports equipment}", r.readLine());
        assertEquals("Alice, Item: {name: Sofa price: 138.0 quantity: 158 category: furniture}", r.readLine());
        assertEquals("John, Item: {name: Laptop price: 36.0 quantity: 14 category: electronics}", r.readLine());
        assertEquals("Jack, Item: {name: Cake price: 5.0 quantity: 14 category: food}", r.readLine());
        assertEquals("Jane, Item: {name: Book price: 14.0 quantity: 15 category: book}", r.readLine());
    }
}