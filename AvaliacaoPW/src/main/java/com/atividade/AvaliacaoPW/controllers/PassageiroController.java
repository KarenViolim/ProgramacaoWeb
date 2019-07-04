package com.atividade.AvaliacaoPW.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.atividade.AvaliacaoPW.models.Passageiro;
import com.atividade.AvaliacaoPW.repository.PassageiroRepository;

@Controller
public class PassageiroController {
	@Autowired
	private PassageiroRepository repositoryPassageiro;
	
	@GetMapping("/listarPassageiro")
	public ModelAndView lista() {
		ModelAndView mv = new ModelAndView("/passageiro");
		mv.addObject("passageiro", repositoryPassageiro.findAll());
		return mv;
	}
	
	@GetMapping("/adicionarPassageiro")
	public ModelAndView add(Passageiro passageiro) {
		ModelAndView mv = new ModelAndView("/addpassageiro");
		mv.addObject("passageiro", passageiro);
		return mv;
	}
	
	@GetMapping("/editarPassageiro/{id}")
	public ModelAndView editar(@PathVariable("id") Long id){
		Optional<Passageiro> passageiro = repositoryPassageiro.findById(id);
		Passageiro p = passageiro.get();
		return add(p);
	}
	@GetMapping("/removerPassageiro/{id}")
	public ModelAndView remover(@PathVariable("id") Long id){
		Optional<Passageiro> passageiro = repositoryPassageiro.findById(id);
		Passageiro p = passageiro.get();
		repositoryPassageiro.delete(p);
		return lista();
	}

	@PostMapping("/salvarPassageiro")
	public ModelAndView salvar(@Valid Passageiro passageiro, BindingResult result) {
		if(result.hasErrors()) {
			return add(passageiro);
		}
		repositoryPassageiro.saveAndFlush(passageiro);
		return lista();
	}
}
