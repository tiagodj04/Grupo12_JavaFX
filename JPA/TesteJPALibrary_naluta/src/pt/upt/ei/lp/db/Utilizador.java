package pt.upt.ei.lp.db;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.eclipse.persistence.annotations.ClassExtractor;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@ClassExtractor(UtilizadorClassExtractor.class)
public abstract class Utilizador {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	private String pass;
	
	public Utilizador() {
	}
	
	public Utilizador(int id, String pass) {
		this.pass = pass;
		this.id = id;
	}
	
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
	 * @return the pass
	 */
	public String getPass() {
		return pass;
	}
	
	/**
	 * @param pass the pass to set
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", pass=" + pass + "]";
	}
	
	

}
