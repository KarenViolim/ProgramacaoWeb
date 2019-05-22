package com.karen.bagagemaviao.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.karen.bagagemaviao.models.Passageiro;


public interface PassageiroRepository extends JpaRepository<Passageiro, Long>{
	
}
