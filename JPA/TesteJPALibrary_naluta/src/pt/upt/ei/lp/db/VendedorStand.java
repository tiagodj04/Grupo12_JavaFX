package pt.upt.ei.lp.db;

import java.util.ArrayList;



import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Column;


@Entity
public class VendedorStand {
	
	
	//@Column(name = "VENDEDORSTAND_SPECIFIC")
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	//private String vendedorStandSpecific = "VENDEDOR_SPECIFIC";
	private String nome;
	private int id;
	private String pass;
	
	@OneToMany
	List<CarroEletrico> carrosEletricos = new ArrayList<CarroEletrico>();
	
	public VendedorStand() {
		
	}
	
/*
	public String getVendedorStandSpecific() {
		return vendedorStandSpecific;
	}


	public void setVendedorStandSpecific(String vendedorStandSpecific) {
		this.vendedorStandSpecific = vendedorStandSpecific;
	}
*/

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
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

	public List<CarroEletrico> getCarrosEletricos() {
		return carrosEletricos;
	}

	@Override
	public String toString() {
		String st ="VendedorStand [nome=" + nome +  ", pass=" + pass + "]";
		/*for (CarroEletrico ce : carrosEletricos) {
			st += " " + ce + "\n";
		}*/
		return st;
			}	
}
