package com.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.Valid;
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
