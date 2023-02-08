package com.entity;

import com.request.Model;
import com.request.State;
import com.validator.ValueOfEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Drone {

    @Id
    @NotBlank
    @Length(max = 100)
    private String serialNumber;
    @ValueOfEnum(enumClass = Model.class)
    private String model;
    @Max(value = 500)
    @Min(value = 0)
    @NotNull
    private double weightLimit;
    private double batteryCapacity;
    @ValueOfEnum(enumClass = State.class)
    private String state;
    @OneToMany(targetEntity = Medication.class, cascade = CascadeType.ALL)
    @JoinColumn(name="dm_fk")
    private List<Medication> medications;
}
