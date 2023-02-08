package com.request;

import com.entity.Drone;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoadRequest {
    private String serialNumber;
    @Valid
    private List<MedicationRequest> medications;
}
