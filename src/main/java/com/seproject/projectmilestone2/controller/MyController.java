package com.seproject.projectmilestone2.controller;

import com.seproject.projectmilestone2.dto.DoctorDto;
import com.seproject.projectmilestone2.dto.PatientDto;
import com.seproject.projectmilestone2.service.DoctorService;
import com.seproject.projectmilestone2.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;

    @RequestMapping("/")
    public String homePage(Model model) {

        return "home";
    }
    @RequestMapping("/patients")
    public String showAllPatients(Model model) {

        List<PatientDto> allPatientDto = patientService.getAllPatients();
        model.addAttribute("allPts", allPatientDto);
        return "all-patients";
    }

    @RequestMapping("/addNewPatient")
    public String addNewPatient(Model model) {
        PatientDto patientDto = new PatientDto();
        model.addAttribute("patient", patientDto);

        return "add-patient";
    }

    @RequestMapping("/savePatient")
    public String savePatient(@ModelAttribute("patient") PatientDto patientDto, Model model) {
        boolean noException = patientService.savePatient(patientDto);

        if (!noException) {
            String exception = "Patient already exists";
            model.addAttribute("exception", exception);
            return "add-patient";
        }

        return "redirect:/patients";
    }

    @RequestMapping("/persistPatient")
    public String persistPatient(@ModelAttribute("patient") PatientDto patientDto, Model model) {

        boolean noException = patientService.persistPatient(patientDto);

        if (!noException) {
            String exception = "Patient with this IIN already exists in the database";
            model.addAttribute("exception", exception);
            return "add-patient";
        }

        return "redirect:/patients";
    }

    @RequestMapping("/updatePatient/{id}")
    public String updatePatient(@PathVariable("id") int id, Model model) {

        PatientDto patientDto = patientService.getPatient(id);
        model.addAttribute("patient", patientDto);

        return "update-patient";
    }

    
    @RequestMapping("/doctors")
    public String showAllDoctors(Model model) {

        List<DoctorDto> allDoctorsDto = doctorService.getAllDoctors();
        model.addAttribute("allDrs", allDoctorsDto);
        return "all-doctors";
    }

    @RequestMapping("/addNewDoctor")
    public String addNewDoctor(Model model) {
        DoctorDto doctorDto = new DoctorDto();
        model.addAttribute("doctor", doctorDto);

        return "add-doctor";
    }

    @RequestMapping("/saveDoctor")
    public String saveDoctor(@ModelAttribute("doctor") DoctorDto doctorDto, Model model) {

        boolean noException = doctorService.saveDoctor(doctorDto);

        if (!noException) {
            String exception = "Doctor with this IIN already exists in the database";
            model.addAttribute("exception", exception);
            return "add-doctor";
        }

        return "redirect:/doctors";
    }

    @RequestMapping("/persistDoctor")
    public String persistDoctor(@ModelAttribute("doctor") DoctorDto doctorDto, Model model) {

        boolean noException = doctorService.persistDoctor(doctorDto);

        if (!noException) {
            String exception = "Doctor already exists";
            model.addAttribute("exception", exception);
            return "add-doctor";
        }

        return "redirect:/doctors";
    }

    @RequestMapping("/updateDoctor/{id}")
    public String updateDoctor(@PathVariable("id") int id, Model model) {

        DoctorDto doctorDto = doctorService.getDoctor(id);

        model.addAttribute("doctor", doctorDto);

        return "update-doctor";
    }
}
