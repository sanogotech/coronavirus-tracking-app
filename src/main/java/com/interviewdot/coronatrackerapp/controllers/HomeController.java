package com.interviewdot.coronatrackerapp.controllers;

import com.interviewdot.coronatrackerapp.models.CoronaCaseDTO;
import com.interviewdot.coronatrackerapp.services.CoronaDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private CoronaDataService coronaDataService;

    @GetMapping("/")
    public String coronaApp(Model model) {
        CoronaCaseDTO coronaCaseDTO = coronaDataService.getCoronaData();
        model.addAttribute("totalCases", coronaCaseDTO.getConfirmed().getLatest());
        model.addAttribute("date", coronaCaseDTO.getConfirmed().getLast_updated().substring(0, 10));
        model.addAttribute("locations", coronaCaseDTO.getConfirmed().getLocations());
        return "home";
    }
}
