package eus.birt.dam.domain;

import java.util.ArrayList;
import java.util.List;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="team")
public class Team implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String country;
	
	private String manager;
	
	@JsonManagedReference
	@OneToMany (mappedBy = "team",cascade = CascadeType.ALL)
	List <Driver> drivers = new ArrayList<>();

	public Team(String name, String country, String manager) {
		super();
		this.name = name;
		this.country = country;
		this.manager = manager;
	}
	
	
}
