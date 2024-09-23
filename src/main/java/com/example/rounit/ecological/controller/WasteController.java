package com.example.rounit.ecological.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.rounit.ecological.entity.Register;
import com.example.rounit.ecological.entity.Bid;
import com.example.rounit.ecological.entity.Waste;
import com.example.rounit.ecological.service.WasteDatabaseService;

import jakarta.validation.Valid;

@Controller
public class WasteController {

    @Autowired
    private WasteDatabaseService wasteDatabaseService;

    @GetMapping("/wasteDataform")
    public ModelAndView showWasteData() {
        String viewName = "wasteDataform";
        Map<String, Object> model = new HashMap<>();
        model.put("wasteDataform", new Waste());
        return new ModelAndView(viewName, model);
    }

    @PostMapping("/wasteDataform")
    public String submitWasteForm(@ModelAttribute("wasteDataform") Waste waste) {
        wasteDatabaseService.create(waste);
        return "redirect:/dashboard";
    }

    @GetMapping("/dashboard")
    public ModelAndView getDashboard() {
        String viewName = "dashboard";
        Map<String, Object> model = new HashMap<>();

        List<Waste> wasteList = wasteDatabaseService.getAllWaste();

        double totalPlastic = 0;
        double totalPaper = 0;
        double totalGlass = 0;
        double totalMetal = 0;

        for (Waste waste : wasteList) {
            totalPlastic += waste.getPlastic();
            totalPaper += waste.getPaper();
            totalGlass += waste.getGlass();
            totalMetal += waste.getMetal();
        }

        model.put("totalPlastic", totalPlastic);
        model.put("totalPaper", totalPaper);
        model.put("totalGlass", totalGlass);
        model.put("totalMetal", totalMetal);

        return new ModelAndView(viewName, model);
    }

    @GetMapping("/auction")
    public ModelAndView showSellForm() {
        String viewName = "auction";
        Map<String, Object> model = new HashMap<>();
        model.put("auction", new Bid());
        return new ModelAndView(viewName, model);
    }

    @PostMapping("/auction")
    public String submitBidForm(@ModelAttribute("auction") Bid bid) {
        wasteDatabaseService.createBid(bid);
        return "redirect:/";
    }

    @GetMapping("/")
    public ModelAndView getBidlist() {
        String viewName = "index";
        Map<String, Object> model = new HashMap<>();
        List<Bid> bidList = wasteDatabaseService.getAllBids();
        model.put("dataRows", bidList);
        model.put("noofBids", bidList.size());
        return new ModelAndView(viewName, model);
    }

    @GetMapping("/events")
    public ModelAndView showEvents() {
        String viewName = "events";
        Map<String, Object> model = new HashMap<>();
        model.put("events", new Waste());
        return new ModelAndView(viewName, model);
    }

    @GetMapping("/Register")
    public ModelAndView showRegisterForm() {
        String viewName = "Register";
        Map<String, Object> model = new HashMap<>();
        model.put("Register", new Register());
        return new ModelAndView(viewName, model);
    }

    @PostMapping("/Register")
    public String submitRegisterForm(@ModelAttribute("Register") @Valid Register register, BindingResult result) {
        if (result.hasErrors()) {
            return "Register";
        }
        wasteDatabaseService.createRegister(register);
        return "redirect:/";
    }
}
