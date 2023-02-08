package com.service;

import com.entity.Drone;
import com.entity.Medication;
import com.request.DroneRequest;
import com.request.LoadRequest;
import java.util.List;

public interface DroneService {

    Drone saveDrone(DroneRequest drone);

    Drone loadMedications(LoadRequest loadRequest);

    List<Medication> getMedicationsByDrone(String serialNumber);

    List<Drone> getIdleDrones();

    double getDroneBatteryLevel(String serialNumber);
}
