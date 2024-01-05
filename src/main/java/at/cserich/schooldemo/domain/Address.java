package at.cserich.schooldemo.domain;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Slf4j
@Embeddable
public class Address  {

    @NotNull
    @NotBlank(message = "CountryCode cannot be Empty or Blank")
    private String zipCode;

    @NotNull
    @NotBlank(message = "StreetName cannot be Empty or Blank")
    private String streetName;

    @NotNull
    @NotBlank(message = "Country cannot be Empty or Blank")
    private String country;

    @NotNull
    @NotBlank(message = "City cannot be Empty or Blank")
    private String city;

    @NotNull
    @NotBlank(message = "StreetNumber cannot be Empty or Blank")
    private int streetNumber;
}
