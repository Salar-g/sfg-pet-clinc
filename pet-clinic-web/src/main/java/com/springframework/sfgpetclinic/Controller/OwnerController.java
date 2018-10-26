package com.springframework.sfgpetclinic.Controller;

import com.springframework.sfgpetclinic.service.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"/owners","/owners/index"})
    public String listOwners(Model model){
        model.addAttribute("owners", ownerService.findAll());
        return "Owners/index";
    }

    @RequestMapping({"/owners/find"})
    public String findOwners(){
        return "notImplemented";
    }


    @RequestMapping({"/oups"})
    public String oupsHandler(){
        return "notImplemented";
    }

}
