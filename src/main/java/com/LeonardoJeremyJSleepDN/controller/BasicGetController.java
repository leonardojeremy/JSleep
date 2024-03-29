package com.LeonardoJeremyJSleepDN.controller;

import com.LeonardoJeremyJSleepDN.Algorithm;
import com.LeonardoJeremyJSleepDN.dbjson.JsonTable;
import com.LeonardoJeremyJSleepDN.dbjson.Serializable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface BasicGetController <T extends Serializable>{
    @GetMapping("/page")
    public default List<T> getPage(
            @RequestParam int page,
            @RequestParam int pageSize
    ){
        return Algorithm.<T>paginate(getJsonTable(), page, pageSize, pred->true);
    }

    @GetMapping("/{id}")
    public default T getById(
            @PathVariable int id
    ){
        return (T)Algorithm.<T>find(getJsonTable(), pred->pred.id == id);
    }

    public abstract JsonTable<T> getJsonTable();


}
