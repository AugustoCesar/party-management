package com.algaworks.party.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.algaworks.party.model.GuestRepository;

@Controller
public class GuestsController {
	
	@Autowired
	private GuestRepository guests;
	
	@GetMapping("/guests")
	public ModelAndView toList() {
		
		ModelAndView modelAndView = new ModelAndView("GuestsList");
		
		modelAndView.addObject("guests", guests.findAll());
		
		return modelAndView;
	}
}
