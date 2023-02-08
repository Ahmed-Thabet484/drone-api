package com.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MedicationRequest {
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9_-]*$")
    private String name;
    private Double weight;
    @Pattern(regexp = "^[a-zA-Z0-9_]*$")
    private String code;
    private byte[] image;
}
