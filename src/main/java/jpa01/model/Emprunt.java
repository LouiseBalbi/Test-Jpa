package jpa01.model;


import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="emprunt")
public class Emprunt {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATE_DEBUT", nullable = false)
	private Date dateDebut;
	

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATE_FIN", nullable = true)
	private Date dateFin;
	
	@Column(name="DELAI", nullable = true)
	private long delai;
	
	@ManyToOne
	@JoinColumn(name = "ID_CLIENT", nullable = false) 
	private Client client;
	


	public Emprunt() {
		
	}

	@ManyToMany
	@JoinTable(name="compo", 
				joinColumns = @JoinColumn(name="ID_EMP", referencedColumnName="ID"),
				inverseJoinColumns = @JoinColumn(name="ID_LIV", referencedColumnName = "ID"))
	private Set<Livre>livres;
	
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the dateDebut
	 */
	public Date getDateDebut() {
		return dateDebut;
	}

	/**
	 * @param dateDebut the dateDebut to set
	 */
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * @return the dateFin
	 */
	public Date getDateFin() {
		return dateFin;
	}

	/**
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	/**
	 * @return the delai
	 */
	public long getDelai() {
		return delai;
	}

	/**
	 * @param delai the delai to set
	 */
	public void setDelai(long delai) {
		this.delai = delai;
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}
			/**
		 * @return the livres
		 */
		public Set<Livre> getLivres() {
			return livres;
		}

		/**
		 * @param livres the livres to set
		 */
		public void setLivres(Set<Livre> livres) {
			this.livres = livres;
		}
		
		@Override
	public String toString() {
		return "Emprunt [id=" + id + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", delai=" + delai
				+ "]";
	}


		
}
