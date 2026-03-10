package com.example.payments;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        Map<String, PaymentGateway> gateways = new HashMap<>();
        gateways.put("fastpay", new FastPayAdapter(new FastPayClient()));
        gateways.put("safecash", new SafeCashAdapter(new SafeCashClient()));

        PaymentGateway fastpay = getGateway(gateways, "fastpay");
        PaymentGateway safecash = getGateway(gateways, "safecash");

        OrderService svc1 = new OrderService(fastpay);
        OrderService svc2 = new OrderService(safecash);

        String id1 = svc1.charge("cust-1", 1299);
        String id2 = svc2.charge("cust-2", 1299);

        
        System.out.println(id1);
        System.out.println(id2);
    }

    private static PaymentGateway getGateway(Map<String, PaymentGateway> gateways, String provider) {
        PaymentGateway gw = gateways.get(provider);
        if (gw == null) throw new IllegalArgumentException("unknown provider: " + provider);
        return gw;
    }
}