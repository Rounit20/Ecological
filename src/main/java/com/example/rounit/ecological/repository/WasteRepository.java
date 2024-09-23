package com.example.rounit.ecological.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rounit.ecological.entity.Waste;

@Repository
public interface WasteRepository extends JpaRepository<Waste, Integer>{

}
