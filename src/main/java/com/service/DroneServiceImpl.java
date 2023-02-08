package com.service;

import com.entity.Drone;
import com.entity.Medication;
import com.repository.DroneRepository;
import com.request.DroneRequest;
import com.request.LoadRequest;
import com.request.State;
import com.response.BatteryLevelResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DroneServiceImpl implements DroneService{

    @Autowired
    private DroneRepository droneRepository;

    @Override
    public Drone saveDrone(DroneRequest droneRequest) {
        Drone drone = prepareDroneObj(droneRequest);
        return droneRepository.save(drone);
    }

    @Override
    public Drone loadMedications(LoadRequest loadRequest) {

        Drone drone = getDrone(loadRequest.getSerialNumber());

        if(drone.getBatteryCapacity() < 0.25){
            throw new RuntimeException("Unable to load medications, drone battery level is below 25%");
        }
        drone.setState(State.LOADING.toString());
        droneRepository.save(drone);

        List<Medication> medications = loadRequest.getMedications().stream()
                .map(medicationRequest -> new Medication(medicationRequest.getName(), medicationRequest.getWeight(), medicationRequest.getCode(), medicationRequest.getImage()))
                .collect(Collectors.toList());

        double totalWeight = medications.stream().mapToDouble(Medication::getWeight).sum();

        if(totalWeight>drone.getWeightLimit()){
            throw new RuntimeException("Drone is overloaded!");
        }

        drone.setMedications(medications);
        drone.setState(State.LOADED.toString());
        return droneRepository.save(drone);
    }

    @Override
    public List<Medication> getMedicationsByDrone(String serialNumber){
        return getDrone(serialNumber).getMedications();
    }

    @Override
    public List<Drone> getIdleDrones() {
        return droneRepository.getIdleDrones(State.IDLE.toString());
    }

    @Override
    public BatteryLevelResponse getDroneBatteryLevel(String serialNumber) {
        return new BatteryLevelResponse(droneRepository.getDroneBatteryLevel(serialNumber));
    }

    private Drone prepareDroneObj(DroneRequest droneRequest) {
        Drone drone = new Drone();
        drone.setSerialNumber(droneRequest.getSerialNumber());
        drone.setModel(droneRequest.getModel());
        drone.setState(droneRequest.getState());
        drone.setBatteryCapacity(droneRequest.getBatteryCapacity());
        drone.setWeightLimit(droneRequest.getWeightLimit());
        return drone;
    }

    private Drone getDrone(String serialNumber){
        boolean droneExists = droneRepository.findById(serialNumber).isPresent();

        if(!droneExists){
            throw new RuntimeException("Drone not found");
        }

        return droneRepository.findById(serialNumber).get();

    }
}
