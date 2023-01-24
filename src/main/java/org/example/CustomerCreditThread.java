package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CustomerCreditThread implements Runnable{

    private final Map<String, Integer> map;
    static List<Map.Entry<String, Integer>> sortedMap = new ArrayList<>();


    CustomerCreditThread(Map<String, Integer> customerByCredit) {
        this.map = customerByCredit;
    }

    @Override
    public void run() {
        int n = map.size();
        this.sortedMap = MapUtil.getFirstN(map, n);
    }
}
