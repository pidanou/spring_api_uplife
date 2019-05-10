package com.uplife.api.repository;

import com.uplife.api.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoomsRepository extends JpaRepository <Room, Long>{

}
