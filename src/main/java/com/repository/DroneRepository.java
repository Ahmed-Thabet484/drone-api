package com.repository;

import com.entity.Drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DroneRepository extends JpaRepository<Drone, String>{
    @Query(value = "select * from drone where state = :state", nativeQuery = true)
    List<Drone> getIdleDrones(@Param("state") String state);

    @Query(value = "select battery_capacity from drone where serial_number = :serialNumber", nativeQuery = true)
    double getDroneBatteryLevel(@Param("serialNumber") String serialNumber);
}
