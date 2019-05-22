package com.karen.bagagemaviao.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.karen.bagagemaviao.models.Passageiro;
import com.karen.bagagemaviao.repository.PassageiroRepository;

@Controller
public class PassageiroController {

	@Autowired
	private PassageiroRepository passageiroRepository;
	
	@RequestMapping(value = "/cadastrarPassageiro", method = RequestMethod.GET)
	public String passageiros() {
		return "formPassageiro";
	}
	
	@RequestMapping(value = "/cadastrarPassageiro", method = RequestMethod.POST)
	public String form(Passageiro passageiro) {
		if 
		passageiroRepository.save(passageiro);
		return "redirect:/cadastrarPassageiro";
	}
	
	@RequestMapping(value = "/listaPassageiros")
	public ModelAndView listaPassageiros() {
		ModelAndView mv = new ModelAndView("/listaPassageiro");
		List<Passageiro> passageiro = passageiroRepository.findAll();
		mv.addObject("passageiro", passageiro);
		return mv;
	}
}
