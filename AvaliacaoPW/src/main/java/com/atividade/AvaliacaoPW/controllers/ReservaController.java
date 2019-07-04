package com.atividade.AvaliacaoPW.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.atividade.AvaliacaoPW.models.Reserva;
import com.atividade.AvaliacaoPW.repository.PassageiroRepository;
import com.atividade.AvaliacaoPW.repository.ReservaRepository;

@Controller
public class ReservaController {
	@Autowired
	private ReservaRepository repositoryReserva;
	
	@Autowired
	private PassageiroRepository repositoryPassageiro;
	
	@GetMapping("/listarReserva")
	public ModelAndView lista() {
		ModelAndView mv = new ModelAndView("/reserva");
		mv.addObject("reserva", repositoryReserva.findAll());
		List<Reserva> reserva.size();
		return mv;
	}
	@PostMapping("/buscarReserva")
	public ModelAndView buscarPorDestino(String destino) {
		ModelAndView mv = new ModelAndView("reserva");
		mv.addObject("reserva", repositoryReserva.buscarPorDestino(destino));
		return mv;
	}
	@GetMapping("/adicionarReserva")
	public ModelAndView add(Reserva reserva) {
		ModelAndView mv = new ModelAndView("/addreserva");
		mv.addObject("reserva", reserva);
		mv.addObject("passageiro", repositoryPassageiro.findAll());
		return mv;
	}
	
	@GetMapping("/editarReserva/{id}")
	public ModelAndView editar(@PathVariable("id") Long id){
		Optional<Reserva> reserva = repositoryReserva.findById(id);
		Reserva r = reserva.get();
		return add(r);
	}
	@GetMapping("/removerReserva/{id}")
	public ModelAndView remover(@PathVariable("id") Long id){
		Optional<Reserva> reserva = repositoryReserva.findById(id);
		Reserva r = reserva.get();
		repositoryReserva.delete(r);
		return lista();
	}
	@PostMapping("/salvarReserva")
	public ModelAndView salvar(@Valid Reserva reserva, BindingResult result) {
		if(result.hasErrors()) {
			return add(reserva);
		}
		String dest = reserva.getDestino();
		if(dest.equals("Colômbia")) {
			reserva.setObservacao("Certificado Internacional de Vacinação");
		}
		if(dest.equals("República Dominicana")) {
			reserva.setObservacao("Certificado Internacional de Vacinação");
		}		
		repositoryReserva.saveAndFlush(reserva);
		return lista();
	}
}
