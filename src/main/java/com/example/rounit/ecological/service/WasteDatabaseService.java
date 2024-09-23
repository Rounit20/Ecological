package com.example.rounit.ecological.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rounit.ecological.entity.Bid;
import com.example.rounit.ecological.entity.Register;
import com.example.rounit.ecological.entity.Waste;
import com.example.rounit.ecological.repository.BidRepo;
import com.example.rounit.ecological.repository.RegisterRepo;
import com.example.rounit.ecological.repository.WasteRepository;


@Service
public class WasteDatabaseService {

    @Autowired
    WasteRepository wasteRepository;
    
    @Autowired
    BidRepo bidRepo;
    
    @Autowired
    RegisterRepo registerRepo;
    
    

    // Create or save a new waste entry
    public void create(Waste waste) {
        wasteRepository.save(waste);
    }
    
    public void createBid(Bid bid)
    {
    	bidRepo.save(bid);
    }
    public Bid getMovieById(Integer id)
	{
		return bidRepo.findById(id).get();
		
	}
    public List<Bid> getAllBids() {
        return bidRepo.findAll();
    }
    
    public void createRegister(Register register)
    {
    	registerRepo.save(register);
    	
    }
    
    
    
   
    

    // Retrieve all waste entries
    public List<Waste> getAllWaste() {
        return wasteRepository.findAll();
    }

    // Retrieve a waste entry by ID
    public Waste getWasteById(Integer id) {
        Optional<Waste> waste = wasteRepository.findById(id);
        return waste.orElse(null); // Returns the Waste object or null if not found
    }

    // Update an existing waste entry
    public void updateWaste(Waste waste, Integer id) {
        Waste existingWaste = getWasteById(id);
        if (existingWaste != null) {
            existingWaste.setMetal(waste.getMetal());
            existingWaste.setGlass(waste.getGlass());
            existingWaste.setPaper(waste.getPaper());
            existingWaste.setPlastic(waste.getPlastic());
            existingWaste.setName(waste.getName());
            existingWaste.setEmail(waste.getEmail());
            wasteRepository.save(existingWaste);
        }
    }

    // Delete a waste entry by ID
    public void deleteWasteById(Integer id) {
        wasteRepository.deleteById(id);
    }




	
}
