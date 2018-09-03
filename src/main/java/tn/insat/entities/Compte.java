package tn.insat.entities;


import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="Comptes")
public class Compte implements java.io.Serializable {

	@Id
	private String numero;
	private String proprietaire;
	private BigDecimal solde;

	public Compte() {
	}

	public Compte(String numero) {
		this.numero = numero;
	}

	public Compte(String numero, String proprietaire, BigDecimal solde) {
		this.numero = numero;
		this.proprietaire = proprietaire;
		this.solde = solde;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getProprietaire() {
		return this.proprietaire;
	}

	public void setProprietaire(String proprietaire) {
		this.proprietaire = proprietaire;
	}

	public BigDecimal getSolde() {
		return this.solde;
	}

	public void setSolde(BigDecimal solde) {
		this.solde = solde;
	}

	@Override
	public String toString() {
		return "Comptes [numero=" + numero + ", proprietaire=" + proprietaire
				+ ", solde=" + solde + "]";
	}

}
