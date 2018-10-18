package com.springframework.sfgpetclinic.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({ "", "/"})
    public String getTest() {

        return "test1";
    }

}
