package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TopCustomersReportThread implements Runnable{

    private final Map<Customer, Double> map;
    static List<Map.Entry<Customer, Double>> sortedMap = new ArrayList<>();


    TopCustomersReportThread(Map<Customer, Double> customerByMoneySpent) {
        this.map = customerByMoneySpent;
    }

    @Override
    public void run() {
        int n = map.size();
        this.sortedMap = MapUtil.getFirstN(map, n);
    }
}
