package com.example.rounit.ecological.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.rounit.ecological.entity.Register;

@Repository
public interface RegisterRepo extends JpaRepository<Register, Integer> {

}
