package com.ensak.abdennour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
   @RequestMapping("/")
   public String indexredir() {
      return "redirect:/abdennour/all";
   }
}