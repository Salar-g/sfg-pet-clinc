package com.springframework.sfgpetclinic.Controller;

import com.springframework.sfgpetclinic.service.VetSerivce;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {
private final VetSerivce vetSerivce;

    public VetController(VetSerivce vetSerivce) {
        this.vetSerivce = vetSerivce;
    }

    @RequestMapping({"/vets","/vets/index"})
    public String listVets(Model model){
        model.addAttribute("vets", vetSerivce.findAll());

        return "vets/index";
    }

}
