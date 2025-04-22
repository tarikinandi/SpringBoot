package com.tarikinandi.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTOIU {

    @NotEmpty(message = "FirstName alanı boş bırakılamaz!")
    @Min(value = 3 , message = "Firstname alanı minimum 3 karakter olmalıdır!")
    @Max(value = 15 , message = "Firstname alanı maksimum 15 karakter olmalıdır!")
    private  String firstName;

    @Size(min = 2, max = 25 , message = "Lastname alanı 2 ile 25 karakter arasında olmalıdır!")
    private  String lastName;

    private  Date birthOfDate;

    @Email(message = "Email formatında bir adres giriniz!")
    private String email;

    @Size(min = 11, max = 11 , message = "Tckn alanı 11 karakter olmalıdır.")
    @NotEmpty(message = "Tckn alanı boş bırakılamaz.")
    private String tckn;
}
