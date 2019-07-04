package com.atividade.AvaliacaoPW.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class Reserva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Passageiro passageiro;
	
	@Column(nullable = false, length = 50)
	@NotEmpty(message = "A origem é obrigatória")
	private String origem;
	
	@Column(nullable = false, length = 50)
	@NotEmpty(message = "O destino é obrigatório")
	private String destino;
	
	@Column(nullable = false, length = 50)
	@NotEmpty(message = "Obrigatório cadastrar a Data de Reserva")
	private String dataReserva;
	
	@Column(nullable = false, length = 50)
	@NotEmpty(message = "Hora de Saída obrigatória!")
	private String horaSaida;
	
	@Column(nullable = false, length = 50)
	@NotEmpty(message = "A empresa é obrigatório")
	private String empresa;
	
	@Column(nullable = false, length = 50)
	private Double valorReserva;
	
	@Column(nullable = true, length = 50)
	private String observacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Passageiro getPassageiro() {
		return passageiro;
	}

	public void setPassageiro(Passageiro passageiro) {
		this.passageiro = passageiro;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(String dataReserva) {
		this.dataReserva = dataReserva;
	}

	public String getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(String horaSaida) {
		this.horaSaida = horaSaida;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public Double getValorReserva() {
		return valorReserva;
	}

	public void setValorReserva(Double valorReserva) {
		this.valorReserva = valorReserva;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
