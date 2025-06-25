package com.example.easyFold.repository;

import com.example.easyFold.entity.UserPhones;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PhoneRepository extends JpaRepository<UserPhones, UUID> {
}
