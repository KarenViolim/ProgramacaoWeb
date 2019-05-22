package com.karen.bagagemaviao.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Passageiro implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String cpf;
	private String numvoo;
	private double pesomala;
	private double alturamala;
	private double larguramala;
	private double comprimentomala;
	private double valorbagagem;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNumvoo() {
		return numvoo;
	}
	public void setNumvoo(String numvoo) {
		this.numvoo = numvoo;
	}
	public double getPesomala() {
		return pesomala;
	}
	public void setPesomala(double pesomala) {
		this.pesomala = pesomala;
	}
	public double getAlturamala() {
		return alturamala;
	}
	public void setAlturamala(double alturamala) {
		this.alturamala = alturamala;
	}
	public double getLarguramala() {
		return larguramala;
	}
	public void setLarguramala(double larguramala) {
		this.larguramala = larguramala;
	}
	public double getComprimentomala() {
		return comprimentomala;
	}
	public void setComprimentomala(double comprimentomala) {
		this.comprimentomala = comprimentomala;
	}
	public double getValorbagagem() {
		return valorbagagem;
	}
	public void setValorbagagem(double valorbagagem) {
		this.valorbagagem = valorbagagem;
	}
}
