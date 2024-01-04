package com.example.childhealth.controller;

import com.example.childhealth.entity.AppointmentEntity;
import com.example.childhealth.dto.AppointmentDto;
import com.example.childhealth.service.AppointmentService;
import com.example.childhealth.service.ChildProfileService;
import com.example.childhealth.service.DiseaseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/profiles/{profileId}/appointments")
@RequiredArgsConstructor
public class AppointmentsController {
    @Value("${app.title.appointments}")
    private String title;

    private final AppointmentService appointmentService;
    private final DiseaseService diseaseService;
    private final ChildProfileService childProfileService;

    @GetMapping
    public String appointmentsPage(Model model, @RequestParam(required = false) UUID editedId,
                                   @PathVariable UUID profileId){
        List<AppointmentEntity> appointments = appointmentService.findAll();

        model.addAttribute("title", title);
        model.addAttribute("appointments", appointments);
        model.addAttribute("editedId", editedId);
        model.addAttribute("profile", childProfileService.findById(profileId));

        if(editedId != null){
            model.addAttribute("editAppointment", appointmentService.findById(editedId));
        }

        return "appointments";
    }

    @GetMapping("/create")
    public String create (Model model, @PathVariable UUID profileId){
        AppointmentEntity newAppointment = new AppointmentEntity();

        model.addAttribute("newAppointment", newAppointment);
        model.addAttribute("diseasesId", diseaseService.diseasesIdList(profileId));
        model.addAttribute("profile", childProfileService.findById(profileId));

        return "createAppointment";
    }

    @PostMapping("/create")
    public String createAction(@Valid AppointmentDto newAppointment, BindingResult result, Model model,
                               @PathVariable UUID profileId){

        if(result.hasErrors()){
            model.addAttribute(newAppointment);
            model.addAttribute("org.springframework.validation.BindingResult.newAppointment", result);
            model.addAttribute("diseasesId", diseaseService.diseasesIdList(profileId));

            return "createAppointment";
        }
        model.addAttribute("profile", childProfileService.findById(profileId));
        model.addAttribute("profileId", profileId);

        AppointmentEntity appointment = appointmentService.saveAppointmentModelToEntity(newAppointment);
        appointment.setChild(childProfileService.findById(profileId));
        appointmentService.save(appointment);

        return "redirect:/profiles/{profileId}/appointments";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable UUID id){
        appointmentService.deleteById(id);

        return "redirect:/profiles/{profileId}/appointments";
    }

    @PostMapping("/edit/{id}")
    public String edit(AppointmentEntity appointment, @PathVariable UUID id){
        AppointmentEntity existing = appointmentService.findById(id);

        existing.setDate(appointment.getDate());
        existing.setDiagnosis(appointment.getDiagnosis());
        existing.setMedicines(appointment.getMedicines());
        existing.setAntibiotic(appointment.isAntibiotic());
        existing.setNotes(appointment.getNotes());
        existing.setDisease(appointment.getDisease());

        appointmentService.save(existing);

        return "redirect:/profiles/{profileId}/appointments";
    }
}
