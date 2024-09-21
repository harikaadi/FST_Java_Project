package com.amaze.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.amaze.enums.RoomType;
import com.amaze.model.Room;

@Repository
public interface RoomRepository  extends JpaRepository<Room, Integer>{
	 Optional<List<Room>> findByIsAvailable(Boolean isAvailable);
	 
	 // select * from room where roomtype="GENERAL_WARD_ROOM" AND beds_count>0 and is_available=1;AND r.bedsCount > 0 AND r.isAvailable = true
	 @Query("select r from Room r where r.roomtype = ?1 AND r.bedsCount > 0 AND r.isAvailable = true")
	 List<Room> findRoomAvailable(RoomType roomType);
	 
	 /*@Query("SELECT r FROM Room r WHERE r.roomtype = ?1 AND r.bedsCount > 0 AND r.isAvailable = true")
	 List<Room> findAvailableRoomsByRoomType(RoomType roomType);*/
	

}
