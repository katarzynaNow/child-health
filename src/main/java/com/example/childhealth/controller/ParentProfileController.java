package com.example.childhealth.controller;

import com.example.childhealth.dto.ParentProfileDto;
import com.example.childhealth.entity.ParentProfileEntity;
import com.example.childhealth.service.ParentProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/parent")
@RequiredArgsConstructor
public class ParentProfileController {

    @Value("${app.title.parents}")
    private String title;

    private final ParentProfileService parentProfileService;

    @GetMapping
    public String profilesList(Model model, @RequestParam(required = false) UUID editedId){
        model.addAttribute("title", title);
        model.addAttribute("profiles", parentProfileService.findAll());

        if(editedId != null) {
            model.addAttribute("editProfile", parentProfileService.findById(editedId));
        }

        return "parentProfiles";
    }

    @GetMapping("/create")
    public String create(Model model){
        ParentProfileEntity newProfile = new ParentProfileEntity();
        model.addAttribute("newProfile", newProfile);
        return "createParentProfile";
    }

    @PostMapping("/create")
    public String createAction(@Valid ParentProfileDto newProfile, BindingResult result, Model model){

        if(result.hasErrors()){
            model.addAttribute(newProfile);
            model.addAttribute("org.springframework.validation.BindingResult.newProfile", result);

            return "createParentProfile";
        }

        parentProfileService.saveParentProfileDtoToEntity(newProfile);
        return "redirect:/parentProfiles";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable UUID id){
        parentProfileService.deleteById(id);
        return "redirect:/parentProfiles";
    }
}
