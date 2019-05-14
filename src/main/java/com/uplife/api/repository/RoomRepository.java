package com.uplife.api.repository;

import com.uplife.api.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface RoomRepository extends JpaRepository <Room, Long>{

    List<Room> findAll();
    Optional<Room> findById(long id);

    @Query(value="SELECT * FROM rooms r WHERE r.name = :name", nativeQuery = true)
    Optional<Room> findRoomByName(@Param("name") String name);

    @Query(value="SELECT * FROM rooms r WHERE r.campus = :campus", nativeQuery = true)
    List<Room> findRoomByCampus(@Param("campus") String campus);
}
