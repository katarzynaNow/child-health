package com.example.childhealth.controller;

import com.example.childhealth.entity.VacStatus;
import com.example.childhealth.entity.Vaccination;
import com.example.childhealth.service.ChildProfileService;
import com.example.childhealth.service.VaccinationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/profiles/{profileId}/vaccination")
@RequiredArgsConstructor
public class VaccinationController {
    @Value("${app.title.vaccination}")
    private String title;

    private final VaccinationService vaccinationService;
    private final ChildProfileService childProfileService;

    @GetMapping
    public String vaccinationSchedulePage(Model model, @RequestParam(required = false) UUID editedId,
                                          @PathVariable UUID profileId){
        List<Vaccination> vaccinations = vaccinationService.findAll();

        model.addAttribute("vaccinations", vaccinations);
        model.addAttribute("title", title);
        model.addAttribute("editedId", editedId);
        model.addAttribute("profile", childProfileService.findById(profileId));


        if(editedId != null) {
            model.addAttribute("editVaccination", vaccinationService.findById(editedId));
        }

        return "vaccination";
    }

    @GetMapping("/update")
    public String updateStatus(@RequestParam UUID id, @RequestParam VacStatus vacStatus){

        Vaccination existing = vaccinationService.findById(id);
        existing.setStatus(vacStatus);
        vaccinationService.save(existing);
        return "redirect:/profiles/{profileId}/vaccination";
    }

    @PostMapping("/edit/{id}")
    public String editDateAndNotes(String notes, LocalDate date, @PathVariable UUID id) {
        Vaccination existing = vaccinationService.findById(id);
        existing.setNotes(notes);
        existing.setDate(date);

        vaccinationService.save(existing);
        return "redirect:/profiles/{profileId}/vaccination";
    }
}
