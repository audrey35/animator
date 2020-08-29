package com.portfolio.animator.controller;

import com.portfolio.animator.generator.GeneratorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path="/")
public class HomeController {

    private GeneratorService generatorService;

    public HomeController(GeneratorService generatorService) {
        this.generatorService = generatorService;
    }

    @GetMapping(path="/")
    public String showSvg(Model model) {
        List<String> options = generatorService.getAnimationNames();
        model.addAttribute("options", options);

        List<String> animations = generatorService.getAnimations();
        model.addAttribute("animations", animations);

        return "home";
    }
}
