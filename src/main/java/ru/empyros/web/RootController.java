package ru.empyros.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RootController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String root() {
        return "redirect:releases";
    }

    @RequestMapping(value = "/releases",method = RequestMethod.GET)
    public String releasesList() {
        return "releasesList";
    }
}
