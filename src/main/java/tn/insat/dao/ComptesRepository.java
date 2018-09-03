package tn.insat.dao;

import java.util.List;

import tn.insat.entities.Compte;

public interface ComptesRepository {

	Compte create(Compte c);
	List<Compte> findAll();
	Compte findById(String id);
	Compte update(Compte c);
	void delete(String id);
	Long count();

}
