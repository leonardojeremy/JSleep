package com.LeonardoJeremyJSleepDN.controller;

import com.LeonardoJeremyJSleepDN.Algorithm;
import com.LeonardoJeremyJSleepDN.Invoice;
import com.LeonardoJeremyJSleepDN.Payment;
import com.LeonardoJeremyJSleepDN.dbjson.JsonAutowired;
import com.LeonardoJeremyJSleepDN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class PaymentController implements BasicGetController<Payment> {
    @JsonAutowired(value = Payment.class, filepath = "C:\\_UNI\\OOP\\_Praktikum OOP\\UNTUK PRAKTIKUM OOP\\JSleep\\json\\account.json")
    public JsonTable<Payment> paymentTable;

    @PostMapping("/payment/{id}")
    public boolean cancel(int id){
        Payment payment = (Payment) Algorithm.<Payment>find(paymentTable, pred->pred.id == id);
        if(payment != null){
            paymentTable.remove(payment);
            return true;
        }
        return false;
    }

    public JsonTable<Payment> getJsonTable(){
        return paymentTable;
    }

    @PostMapping("/payment/create")
    public Payment create(
            @RequestParam int buyerId,
            @RequestParam int renterId,
            @RequestParam int roomId,
            @RequestParam String from,
            @RequestParam String to
    ) {
        return null;
    }

    @PostMapping("/payment/{id}")
    public boolean accept(int id){
        return false;
    }


}
