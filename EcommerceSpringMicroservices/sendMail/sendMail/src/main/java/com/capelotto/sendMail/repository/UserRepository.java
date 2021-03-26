package com.capelotto.sendMail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capelotto.sendMail.entity.Produto;
import com.capelotto.sendMail.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

}
