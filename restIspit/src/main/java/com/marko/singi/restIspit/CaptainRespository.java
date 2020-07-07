package com.marko.singi.restIspit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaptainRespository extends JpaRepository<Captain, Integer> {

}
