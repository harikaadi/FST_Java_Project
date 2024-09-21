package com.amaze.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amaze.dto.MessageDto;
import com.amaze.exception.NoRoomsAvailableException;
import com.amaze.model.Room;
import com.amaze.service.RoomService;

@Controller

public class RoomController {
	
	
	@Autowired
    private RoomService roomService;
	
	
    @PostMapping("/room/add")
    public ResponseEntity<?> addRoom(@RequestBody Room room, MessageDto messageDto) {
        try {
            Room savedRoom = roomService.addRoom(room);
            return ResponseEntity.ok(savedRoom);
        } catch (Exception e) {
            messageDto.setMsg(e.getMessage());
            return ResponseEntity.badRequest().body(messageDto);
        }
    }

    @GetMapping("room/a")
    public ResponseEntity<?> getAvailableRooms(MessageDto messageDto) {
    	System.out.println("room available");
        try {
            List<Room> rooms = roomService.getAvailableRooms();
            return ResponseEntity.ok(rooms);
        } catch (NoRoomsAvailableException e) {
            messageDto.setMsg(e.getMessage());
            return ResponseEntity.badRequest().body(messageDto);
        }
    }

}
