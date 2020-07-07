package com.marko.singi.restIspit;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DockRepository extends JpaRepository<Dock, Integer>{

	List<Dock> findByFull(Boolean bool);

}
