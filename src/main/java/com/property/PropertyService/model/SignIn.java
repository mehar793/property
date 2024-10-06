package com.property.PropertyService.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignIn {

    @NotBlank(message="email should not be empty!!")
    @Email(message="email is invalid!!")
    private String email;

    @NotBlank(message="password should not be blank!!")
    @Size(min=8,message="password should contain atleast 8 characters!!")
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&#])[A-Za-z\\d@$!%*?&#]{8,}$",
            message = "Password must contain at least one uppercase letter, one digit, and one special character!"
    )
    private String password;
}
