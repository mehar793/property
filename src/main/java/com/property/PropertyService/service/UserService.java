package com.property.PropertyService.service;

import com.property.PropertyService.entity.SignUp;
import com.property.PropertyService.exception.InvalidPasswordException;
import com.property.PropertyService.exception.UserNotFoundException;
import com.property.PropertyService.model.SignIn;
import com.property.PropertyService.model.SignUpDTO;
import com.property.PropertyService.repository.SignUpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {


    @Autowired
    private SignUpRepo repo;
    public void registerUser(SignUpDTO signUpDTO) {
     repo.save(mapToEntity(signUpDTO));
    }


    public String loginUser(SignIn signIn) {
        SignUp signUp = repo.findByEmail(signIn.getEmail());

        if (signUp == null) {
            throw new UserNotFoundException("User not found!");
        }

        if (!signUp.getPassword().equals(signIn.getPassword())) {
            throw new InvalidPasswordException("Invalid password!");
        }
        return "User signed in successfully!";
    }





    private SignUp mapToEntity(SignUpDTO signUpDTO) {
        SignUp sign= new SignUp();
        sign.setEmail(signUpDTO.getEmail());
        sign.setPassword(signUpDTO.getPassword());
        return sign;
    }



}
