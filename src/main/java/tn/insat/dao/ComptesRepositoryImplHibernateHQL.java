package tn.insat.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import tn.insat.entities.Compte;
import tn.insat.utilities.HibernateUtil;

public class ComptesRepositoryImplHibernateHQL implements ComptesRepository {

	@Override
	public Compte create(Compte c) {
		Compte resultat = null;
		Transaction tx = null;
		try {
			tx = getSession().beginTransaction();
			getSession().save(c);
			tx.commit();
			resultat = c;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return resultat;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Compte> findAll() {
		List<Compte> resultat = null;
		Transaction tx = null;
		try {
			tx = getSession().beginTransaction();
			resultat = (List<Compte>) getSession().createQuery("FROM Compte")
					.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return resultat;
	}

	@Override
	public Compte findById(String id) {
		Compte resultat = null;
		Transaction tx = null;
		try {
			tx = getSession().beginTransaction();
			resultat = (Compte) getSession()
					.createQuery("FROM Compte WHERE numero = :numCompte")
					.setParameter("numCompte", id).uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return resultat;
	}

	@Override
	public Compte update(Compte c) {
		Compte resultat = null;
		Transaction tx = null;
		try {
			tx = getSession().beginTransaction();
			getSession().merge(c);
			tx.commit();
			resultat = c;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return resultat;
	}

	@Override
	public void delete(String id) {
	
		Transaction tx = null;
		try {
			tx = getSession().beginTransaction();
			getSession().createQuery("DELETE FROM Compte WHERE numero = :numCompte")
	                .setParameter("numCompte", id)
	                .executeUpdate();
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public Long count() {
		Long resultat = null;
		Transaction tx = null;
		try {
			tx = getSession().beginTransaction();
			resultat = (Long) getSession().createQuery("SELECT count(*) FROM Compte").uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return resultat;
	}

	private Session getSession() {
		return HibernateUtil.getSessionFactory().getCurrentSession();
	}

}
