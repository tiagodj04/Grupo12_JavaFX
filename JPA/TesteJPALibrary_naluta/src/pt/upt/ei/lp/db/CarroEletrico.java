package pt.upt.ei.lp.db;

import javax.persistence.Entity
;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;


@Entity
public class CarroEletrico {
	@ManyToOne
	@JoinTable(name = "VENDEDORSTAND_CARROELETRICO",
	    joinColumns = @JoinColumn(name = "carrosEletricos_ID"),
	    inverseJoinColumns = @JoinColumn(name = "VendedorStand_NOME"))
	private VendedorStand vendedorStand;
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    private String marca;
    private String modelo;
    private int ano;
    private int kms;
    private String descricao;
    //private String classe; //classe 1 / 2 
    private int cavalos;
    private int autonomia;
    private double preco;
    private boolean estado; // disponivel(true) / vendido(false) 
    
    //construtor sem parámetros
    public CarroEletrico() {
    }
    //construtor com parámetros (parametro do vendedor em falta /!\/!\/!\/!\/!\ )
    public CarroEletrico(int id,String marca, String modelo, int ano,int kms, int cavalos, int autonomia, String descricao, double preco, boolean estado) {
    	this.id=id;
    	this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.kms= kms;
        this.descricao = descricao;
        this.preco = preco;
        this.autonomia = autonomia;
        this.cavalos = cavalos;
        this.estado= true;
    }
    
    
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getModelo() {
		return modelo;
	}
	/**
	 * @param modelo the modelo to set
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	/**
	 * @return the ano
	 */
	public int getAno() {
		return ano;
	}
	/**
	 * @param ano the ano to set
	 */
	public void setAno(int ano) {
		this.ano = ano;
	}
	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}
	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
/*

	public String getClasse() {
		return classe;
	}
	
	public void setClasse(String classe) {
		this.classe = classe;
	}
*/
	/**
	 * @return the cavalos
	 */
	public int getCavalos() {
		return cavalos;
	}
	/**
	 * @param cavalos the cavalos to set
	 */
	public void setCavalos(int cavalos) {
		this.cavalos = cavalos;
	}
	/**
	 * @return the autonomia
	 */
	public int getAutonomia() {
		return autonomia;
	}
	/**
	 * @param autonomia the autonomia to set
	 */
	public void setAutonomia(int autonomia) {
		this.autonomia = autonomia;
	}
	/**
	 * @return the preco
	 */
	public double getPreco() {
		return preco;
	}
	/**
	 * @param preco the preco to set
	 */
	public void setPreco(double preco) {
		this.preco = preco;
	}
	/**
	 * @return the estado
	 */
	public boolean isEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getKms() {
		return kms;
	}
	public void setKms(int kms) {
		this.kms = kms;
	}
	
	//To String
	@Override
	public String toString() {
		String st = "CarroEletrico [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", ano=" + ano + ", kms=" + kms + ", descricao="
				+ descricao + ", cavalos=" + cavalos + ", autonomia=" + autonomia + ", preco="
				+ preco + ", estado=" + estado + "]";
		return st;
	}
    
}
