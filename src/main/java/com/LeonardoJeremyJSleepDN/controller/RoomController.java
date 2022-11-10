package com.LeonardoJeremyJSleepDN.controller;

import com.LeonardoJeremyJSleepDN.City;
import com.LeonardoJeremyJSleepDN.Facility;
import com.LeonardoJeremyJSleepDN.Room;
import com.LeonardoJeremyJSleepDN.dbjson.JsonAutowired;
import com.LeonardoJeremyJSleepDN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class RoomController implements BasicGetController<Room> {

    @JsonAutowired(value = Room.class, filepath = "C:\\_UNI\\OOP\\_Praktikum OOP\\UNTUK PRAKTIKUM OOP\\JSleep\\json\\account.json")
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
        return roomTable;
    }

    @RequestMapping("/room")
    @Override
    public JsonTable<Room> getJsonTable() {
        return Room.jsonTable;
    }

}
