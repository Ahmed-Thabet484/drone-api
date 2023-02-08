package com.response;

import lombok.*;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BatteryLevelResponse {
    private double batteryCapacity;
}
