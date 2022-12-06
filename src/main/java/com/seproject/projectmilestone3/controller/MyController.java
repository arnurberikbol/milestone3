package com.seproject.projectmilestone3.controller;

import com.seproject.projectmilestone3.dao.DoctorDao;
import com.seproject.projectmilestone3.dto.AppointmentDto;
import com.seproject.projectmilestone3.dto.DoctorDto;
import com.seproject.projectmilestone3.dto.PatientDto;
import com.seproject.projectmilestone3.entity.Doctor;
import com.seproject.projectmilestone3.service.AppointmentService;
import com.seproject.projectmilestone3.service.DoctorService;
import com.seproject.projectmilestone3.service.PatientService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
public class MyController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private AppointmentService appointmentService;

    @RequestMapping("/")
    public String homePage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String auth = String.valueOf(authentication.getAuthorities());


        //[ROLE_PATIENT]

        if (auth.equals("[ROLE_ADMIN]"))
            return "admin-home";


        List<DoctorDto> allDoctorsDto = doctorService.getAllDoctors();
        model.addAttribute("allDrs", allDoctorsDto);
        model.addAttribute("doctors", allDoctorsDto);

        return "patient-home";
    }
    @RequestMapping("/appointments")
    public String showAllAppointments(Model model) {

        List<AppointmentDto> allAppointmentDto = appointmentService.getAllAppointments();
        model.addAttribute("allAps", allAppointmentDto);
        return "all-appointments";
    }

    @RequestMapping("/saveAppointment")
    public String saveAppointment(@ModelAttribute("appointment") AppointmentDto appointmentDto, Model model) {

        appointmentService.saveAppointment(appointmentDto);

        return "redirect:/";
    }

    @RequestMapping("/setAppointment/{id}")
    public String setAppointment(@PathVariable("id") int id, Model model) {

        DoctorDto doctorDto = doctorService.getDoctor(id);
        AppointmentDto appointmentDto = new AppointmentDto();

        appointmentDto.setDoctor_name(doctorDto.getName());
        appointmentDto.setDoctor_surname(doctorDto.getSurname());
        appointmentDto.setDoctor_spec(doctorDto.getCategory());
        model.addAttribute("appointment", appointmentDto);
        model.addAttribute("doctor", doctorDto);
        return "set-appointment";
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

    @RequestMapping("/searchDoctor")
    public String searchDoctors(@RequestParam("fullname") String name, Model model) {

        List<DoctorDto> allDoctorsDto = doctorService.searchDoctor(name);
        model.addAttribute("doctors", allDoctorsDto);

        List<DoctorDto> allDoctorsDto2 = doctorService.getAllDoctors();
        model.addAttribute("allDrs", allDoctorsDto2);

        return "patient-home";
    }

    @RequestMapping("/searchDoctorBySpec")
    public String searchDoctorsBySpec(@RequestParam("spec") String spec, Model model) {

        List<DoctorDto> allDoctorsDto = doctorService.searchDoctorBySpec(spec);
        model.addAttribute("doctors", allDoctorsDto);

        List<DoctorDto> allDoctorsDto2 = doctorService.getAllDoctors();
        model.addAttribute("allDrs", allDoctorsDto2);

        return "patient-home";
    }

    @Autowired
    private DoctorDao DoctorDao;

    @RequestMapping("/doctor/image/{id}")
    public void showProductImage(@PathVariable int id,
                               HttpServletResponse response) throws IOException {
        response.setContentType("image/jpeg"); // Or whatever format you wanna use

        Doctor doctor = DoctorDao.getDoctor(id);

        InputStream is = new ByteArrayInputStream(doctor.getPhoto());
        IOUtils.copy(is, response.getOutputStream());
    }
}
