package com.uplife.api.controller;

import com.uplife.api.exception.RoomNotFoundException;
import com.uplife.api.model.Room;
import com.uplife.api.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import javax.validation.Valid;
import java.util.List;

@RestController
public class RoomController {

@Autowired
/*RoomRepository RoomRepository;

/*@GetMapping("/rooms")
    public List<Room> getAllNotes(){
    return RoomRepository.findAll();
}*/

@GetMapping("/room")
    public String test(){
    return "test";
}


}
