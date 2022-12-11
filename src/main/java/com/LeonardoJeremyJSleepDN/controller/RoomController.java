package com.LeonardoJeremyJSleepDN.controller;

import com.LeonardoJeremyJSleepDN.*;
import com.LeonardoJeremyJSleepDN.dbjson.JsonAutowired;
import com.LeonardoJeremyJSleepDN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController implements BasicGetController<Room> {

    @JsonAutowired(value = Room.class, filepath = "C:\\_UNI\\OOP\\_Praktikum OOP\\UNTUK PRAKTIKUM OOP\\JSleep\\json\\room.json")
    public static JsonTable<Room> roomTable;

    @PostMapping("/room/create")
    public Room create(
            @RequestParam int accountId,
            @RequestParam String name,
            @RequestParam int size,
            @RequestParam int price,
            @RequestParam Facility facility,
            @RequestParam City city,
            @RequestParam String address
    ){
        Account account = Algorithm.<Account>find(AccountController.accountTable, pred -> pred.id == accountId && pred.renter != null);
        if(account == null){
            return null;
        }
        Room room = new Room(accountId, name, size, price, facility, city, address);
        roomTable.add(room);
        return room;
    }

    @RequestMapping("/room/{id}/renter")
    public List<Room> getRoomByRenter(
            @RequestParam int id,
            @RequestParam int page,
            @RequestParam int pageSize
    ) {
        return Algorithm.<Room>paginate(getJsonTable(), page, pageSize, pred -> pred.accountId == id);
    }

    @GetMapping("/getAllRoom")
    public List<Room> getAllRoom(
            @RequestParam int page,
            @RequestParam int pageSize

    ) {
        return Algorithm.<Room>paginate(getJsonTable(), page, pageSize, pred -> true);
    }


    @RequestMapping("/room")
    @Override
    public JsonTable<Room> getJsonTable() {
        return Room.jsonTable;
    }

}
