package eus.birt.dam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eus.birt.dam.domain.Driver;

public interface DriverRepository extends JpaRepository<Driver, Long>{
	
}