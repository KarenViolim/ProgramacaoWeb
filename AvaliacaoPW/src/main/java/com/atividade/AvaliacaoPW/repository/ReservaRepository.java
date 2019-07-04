package com.atividade.AvaliacaoPW.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.atividade.AvaliacaoPW.models.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

	@Query("select r from Reserva r where r.destino like %?1%")
	List<Reserva> buscarPorDestino(String destino);

	Optional<Reserva> size();
}
