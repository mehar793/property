package com.property.PropertyService.repository;

import com.property.PropertyService.entity.PropertyForSale;
import com.property.PropertyService.entity.SignUp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SignUpRepo extends JpaRepository<SignUp,Integer> {
    SignUp findByEmail(String email);
}
