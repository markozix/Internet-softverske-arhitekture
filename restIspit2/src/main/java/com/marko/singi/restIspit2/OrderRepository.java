package com.marko.singi.restIspit2;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Testorder, Integer>{

}
