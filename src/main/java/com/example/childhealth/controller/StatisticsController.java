package com.example.childhealth.controller;

import com.example.childhealth.service.AppointmentService;
import com.example.childhealth.service.ChildProfileService;
import com.example.childhealth.service.DiseaseService;
import com.example.childhealth.service.VaccinationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class StatisticsController {
    @Value("${app.title.statistics}")
    private String title;

    private final AppointmentService appointmentService;
    private final DiseaseService diseaseService;
    private final VaccinationService vaccinationService;
    private final ChildProfileService childProfileService;

    @GetMapping("/profiles/{profileId}/statistics")
    public String statisticsPage(Model model, @PathVariable UUID profileId){
        LocalDate currentDate = LocalDate.now();

        int[] sickDaysEveryMonthData = diseaseService.daysInMonthsSick(profileId);
        int sickDaysInYear = diseaseService.sickDaysInYear(sickDaysEveryMonthData);
        int sickPercentage = diseaseService.sickDaysPercentage(sickDaysInYear) ;
        int[] data = {100-sickPercentage, sickPercentage};

        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        model.addAttribute("title", title);
        model.addAttribute("currentDate", currentDate);

        model.addAttribute("sickDaysInYear", sickDaysInYear );
        model.addAttribute("sickPercentage",sickPercentage);
        model.addAttribute("data", data);

        model.addAttribute("antibiotics", appointmentService.howManyAntibiotics(profileId));

        model.addAttribute("monthsLabels", months);
        model.addAttribute("sickDaysEveryMonthData", sickDaysEveryMonthData );

        model.addAttribute("mandatoryVac", vaccinationService.howManyMandatoryVaccinations(profileId));
        model.addAttribute("recommendedVac", vaccinationService.howManyRecommendedVaccinations(profileId));

        model.addAttribute("profile", childProfileService.findById(profileId));

        return "statistics";
    }
}
