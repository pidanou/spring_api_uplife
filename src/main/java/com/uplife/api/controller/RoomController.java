package com.uplife.api.controller;

import com.uplife.api.model.Room;
import com.uplife.api.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RoomController {


    @Autowired
    private RoomRepository roomRepository;

    @GetMapping("/user/room/getAllRooms")
    public List<Room> getAllRooms(){
        return roomRepository.findAll();
    }

    @GetMapping("/user/room/getById/{id}")
    public Optional<Room> getRoomByID(@PathVariable long id){
        return roomRepository.findById(id);
    }

    @GetMapping("/user/room/getByName/{name}")
    public Optional<Room> getRoomByName(@PathVariable String name){
        return roomRepository.findRoomByName(name);
    }

    @GetMapping("/user/room/getAllByCampus/{campus}")
    public List<Room> getRoomsByCampus(@PathVariable String campus){
        return roomRepository.findRoomByCampus(campus);
    }

    @PostMapping("/admin/registerRoom")
    public void registerRoom(Room room){
        roomRepository.save(room);
    }
}
