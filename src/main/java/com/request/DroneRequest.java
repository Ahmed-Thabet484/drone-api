package com.request;

import com.validator.ValueOfEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DroneRequest {

    @NotBlank
    @Length(max = 100)
    private String serialNumber;
    @ValueOfEnum(enumClass = Model.class)
    private String model;
    @Max(value = 500)
    @Min(value = 0)
    @NotNull
    private Double weightLimit;
    private Double batteryCapacity;
    @ValueOfEnum(enumClass = State.class)
    private String state;

}
