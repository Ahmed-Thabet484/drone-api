package com.scheduler;

import com.entity.Drone;
import com.repository.DroneRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.DecimalFormat;
import java.util.List;


@SpringBootApplication
@EnableScheduling
@EnableAsync
public class DroneBatteryScheduler {

    static final Logger log = LoggerFactory.getLogger(DroneBatteryScheduler.class);

    @Autowired
    private DroneRepository droneRepository;


    @Scheduled(fixedRate = 5000)
    public void checkDroneBattery(){

        List<Drone> drones = droneRepository.findAll();

        DecimalFormat decFormat = new DecimalFormat("#%");

        for(Drone drone : drones){
            log.info("Drone: " + drone.getSerialNumber() + " has battery level: "+ decFormat.format(drone.getBatteryCapacity()));
        }

    }


}
