package com.capelotto.sendMail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capelotto.sendMail.entity.Produto;



@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long>{

}
