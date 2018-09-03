package tn.insat.client;

import java.math.BigDecimal;
import java.util.List;

import tn.insat.dao.ComptesRepository;
import tn.insat.dao.ComptesRepositoryImplHibernateHQL;
import tn.insat.entities.Compte;

public class TestDAO_HQL 
{
	public static void main( String[] args )
    {
		 ComptesRepository repo = new ComptesRepositoryImplHibernateHQL();
		// test_findAll(repo);
		 //test_findById(repo);
		// test_create(repo);
		 test_count(repo);
      
    }

	private static void test_count(ComptesRepository repo) {
		Long count = repo.count();
		System.out.println("The count : "+count);
		
	}

	private static void test_create(ComptesRepository repo) {
		 Compte resultat = repo.create(new Compte("APPLE","Steve Jobs", new BigDecimal("1234.456")));
		System.out.println(resultat);
	}

	private static void test_findById(ComptesRepository repo) {
		Compte resultat = repo.findById("A100");
		System.out.println(resultat);
		
	}

	private static void test_findAll(ComptesRepository repo) {
		
		List<Compte> resultat = repo.findAll();
		for (Compte compte : resultat) {
			System.out.println(compte);
		}
		
	}
}
