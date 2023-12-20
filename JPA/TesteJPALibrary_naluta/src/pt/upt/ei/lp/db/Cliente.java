package pt.upt.ei.lp.db;

import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table//(name="Cliente")
public class Cliente  {
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)  // Adjust this based on your database strategy
	  //@Column(name = "ID")
	    
	
	private Long id;
	
	//private String clientSpecific = "CLIENT_SPECIFIC";
	private String email;
	private String nome;
	//private String pass;
	
	public Cliente() {
	}
	
	public Cliente(int id, String email, String nome) {
		
		// TODO Auto-generated constructor stub
		this.nome=nome;
		this.email=email;
		
		//this.id=id;
	}

	/**
	 * @return the clientSpecific
	 */
	/*
	public String getClientSpecific() {
		return clientSpecific;
	}
	
	/**
	 * @param clientSpecific the clientSpecific to set
	 */
	/*
	public void setClientSpecific(String clientSpecific) {
		this.clientSpecific = clientSpecific;
	}
	*/
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", email=" + email + ", nome=" + nome + "]";
	}

	

	



}
