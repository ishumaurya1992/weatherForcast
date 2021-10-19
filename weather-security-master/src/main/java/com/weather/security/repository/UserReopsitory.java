package com.weather.security.repository;

import com.weather.security.models.CustomUserDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

;

@Repository
public interface UserReopsitory extends MongoRepository<CustomUserDetails, String> {

    CustomUserDetails save(CustomUserDetails user);

    CustomUserDetails findByEmail(String name);
}
