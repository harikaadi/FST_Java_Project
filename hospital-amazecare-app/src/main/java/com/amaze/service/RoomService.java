package com.amaze.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amaze.exception.NoRoomsAvailableException;
import com.amaze.model.Room;
import com.amaze.repo.RoomRepository;

@Service
public class RoomService {
	 @Autowired
	    private RoomRepository roomRepository;

	    public Room addRoom(Room room) {
	        return roomRepository.save(room);
	    }

	    public List<Room> getAvailableRooms() throws NoRoomsAvailableException {
	        Optional<List<Room>> optionalRooms = roomRepository.findByIsAvailable(true);
	        if (optionalRooms.isEmpty()) {
	            throw new NoRoomsAvailableException("No available rooms found.");
	        }
	        return optionalRooms.get();
	    }

}
