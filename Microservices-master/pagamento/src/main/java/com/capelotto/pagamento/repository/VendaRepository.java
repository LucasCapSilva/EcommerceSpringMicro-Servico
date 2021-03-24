package com.capelotto.pagamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capelotto.pagamento.entity.Venda;

@Repository
public interface VendaRepository  extends JpaRepository<Venda, Long>{

}
