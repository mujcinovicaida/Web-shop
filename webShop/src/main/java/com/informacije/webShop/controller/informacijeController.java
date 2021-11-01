package com.informacije.webShop.controller;

import com.informacije.webShop.domain.informacije;
import com.informacije.webShop.service.informacijeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
public class informacijeController {
    @Autowired
    private informacijeService service;
    @GetMapping("/")
    public String home (Model model){
        return "homePage";
    }
    @GetMapping("/index")
    public String viewHomePage(Model model){
        List<informacije> listinformacije= service.listAll();
        model.addAttribute("listinformacije",listinformacije);
        System.out.println("Get /");
        return "index";
    }
    @GetMapping("/index1")
    public String viewHomePage1(Model model){
        List<informacije> listinformacije= service.listAll();
        model.addAttribute("listinformacije",listinformacije);
        System.out.println("Get /");
        return "index1";
    }

    @GetMapping("/novi")
    public String add(Model model){
        model.addAttribute("informacije",new informacije());
        return "novi";
    }

    @RequestMapping(value="/save",method= RequestMethod.POST)
    public String saveInformacije(@ModelAttribute("informacije") informacije inf, @RequestParam("file")MultipartFile file) throws IOException {
        service.saveInformacije(inf,file);
        return "redirect:/";
    }

    @GetMapping("/edit/{ID}")
    public String editInform(Model model,@PathVariable("ID") long ID){
        informacije editInfo=service.get(ID);
        model.addAttribute("informacije",editInfo);
        return "editInformacija";
    }

    @RequestMapping(value="/update/{ID}",method= RequestMethod.POST)
    public String updateInformacije(@ModelAttribute("informacije") informacije inf,@PathVariable("ID") long ID, @RequestParam("file")MultipartFile file) throws IOException {
        service.saveInformacije(inf,file);
        return "redirect:/";
    }
}
