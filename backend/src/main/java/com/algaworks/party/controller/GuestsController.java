package com.algaworks.party.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.algaworks.party.model.Guest;
import com.algaworks.party.model.GuestRepository;

@Controller
@RequestMapping("/guests")
public class GuestsController {
	
	@Autowired
	private GuestRepository guestRepository;
	
	@GetMapping
	public ModelAndView toList() {
		
		ModelAndView modelAndView = new ModelAndView("GuestsList");
				
		modelAndView.addObject("guests", guestRepository.findAll());
		
		modelAndView.addObject(new Guest());
		
		
		return modelAndView;
	}
	
	@PostMapping
	public String save(Guest guest) {
		
		this.guestRepository.save(guest);
				
		return "redirect:/guests";
	}
}
