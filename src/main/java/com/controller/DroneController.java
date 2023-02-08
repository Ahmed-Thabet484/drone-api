package com.controller;

import com.entity.Drone;
import com.entity.Medication;
import com.request.DroneRequest;
import com.request.LoadRequest;
import com.response.BatteryLevelResponse;
import com.service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class DroneController {

    @Autowired
    private DroneService droneService;

    @PostMapping(value = "register")
    public Drone registerDrone(@Valid  @RequestBody DroneRequest droneRequest){
        return this.droneService.saveDrone(droneRequest);
    }

    @PutMapping(value = "load-drone")
    public Drone loadingDrone(@Valid  @RequestBody LoadRequest loadRequest){
        return this.droneService.loadMedications(loadRequest);
    }

    @GetMapping(value = "drone/{serialNumber}")
    public List<Medication> getMedicationBySerialNumber(@PathVariable String serialNumber){
        return this.droneService.getMedicationsByDrone(serialNumber);
    }

    @GetMapping(value = "/idle-drones")
    public List<Drone> getIdleDrones(){
        return this.droneService.getIdleDrones();
    }

    @GetMapping(value = "/battery-level/{serialNumber}")
    public BatteryLevelResponse getDroneBatteryLevel(@PathVariable String serialNumber){
        return this.droneService.getDroneBatteryLevel(serialNumber);
    }
}
