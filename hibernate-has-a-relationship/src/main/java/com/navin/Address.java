package com.navin;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Embeddable
public class Address {
    private String street;
    private String city;
    private String state;
    private String country;
    private int pinCode;

}
