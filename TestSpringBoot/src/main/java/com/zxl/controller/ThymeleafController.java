package com.zxl.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThymeleafController {
	
	@RequestMapping("/index")
	public String index(Locale locale, Model model)
	{
		
		return "index";
	}
}
