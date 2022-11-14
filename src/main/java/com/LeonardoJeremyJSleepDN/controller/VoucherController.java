package com.LeonardoJeremyJSleepDN.controller;

import com.LeonardoJeremyJSleepDN.Algorithm;
import com.LeonardoJeremyJSleepDN.Price;
import com.LeonardoJeremyJSleepDN.Voucher;
import com.LeonardoJeremyJSleepDN.dbjson.JsonAutowired;
import com.LeonardoJeremyJSleepDN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voucher")
public class VoucherController implements BasicGetController<Voucher> {
    @JsonAutowired(value = Voucher.class, filepath = "C:\\_UNI\\OOP\\_Praktikum OOP\\UNTUK PRAKTIKUM OOP\\JSleep\\json\\voucher.json")
    public static JsonTable<Voucher> voucherTable;

    @RequestMapping("/voucher/{id}/canApply")
    public boolean canApply(
            @PathVariable int id,
            @RequestParam double price
) {
        Voucher voucher = Algorithm.<Voucher>find(voucherTable, pred -> pred.id == id);
        if(voucher == null){
            return false;
        }
        return voucher.canApply(new Price(price));
    }


    @GetMapping("/voucher/{id}/getAvailable")
    public List<Voucher> getAvailable(
            @PathVariable int page,
            @PathVariable int pageSize
    ){
        return Algorithm.<Voucher>paginate(voucherTable, page, pageSize, pred ->  !pred.isUsed());
    }

    @RequestMapping("/voucher/{id}/isUsed")
    public boolean isUsed(@PathVariable int id){
        Voucher voucher = (Voucher) Algorithm.<Voucher>find(voucherTable, pred->pred.id == id);
        if(voucher != null){
            return voucher.isUsed;
        }
        return false;
    }


    public JsonTable<Voucher> getJsonTable(){
        return voucherTable;
    }
}
