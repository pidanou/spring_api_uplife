package com.uplife.api.controller;

import com.uplife.api.exception.RoomNotFoundException;
import com.uplife.api.model.Room;
import com.uplife.api.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class RoomController {


    @Autowired
    private RoomRepository RoomRepository;

    @GetMapping("/user/room/getAllRooms")
    public List<Room> getAllRooms(){
        return RoomRepository.findAll();
    }

    @GetMapping("/user/room/getById/{id}")
    public Optional<Room> getRoomByID(@PathVariable long id){
        return RoomRepository.findById(id);
    }

    @GetMapping("/user/room/getByName/{name}")
    public Optional<Room> getRoomByName(@PathVariable String name){
        return RoomRepository.findRoomByName(name);
    }

    @GetMapping("/user/room/getAllByCampus/{campus}")
    public List<Room> getRoomsByCampus(@PathVariable String campus){
        return RoomRepository.findRoomByCampus(campus);
    }

}
