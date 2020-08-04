package com.example.charting.gateway.repository;

import com.example.charting.gateway.model.AppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<AppUser,String> {
    public Optional<AppUser> findByMail(String mail);
}
