package pt.upt.ei.lp.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private VendedorStand vendedorStand;

    @OneToOne
    private CarroEletrico carroEletrico;
    
    
    private double preco;

    public Venda() {
    }

    public Venda(Cliente cliente, VendedorStand vendedorStand, CarroEletrico carroEletrico,double preco) {
        this.preco=preco;
    	this.cliente = cliente;
        this.vendedorStand = vendedorStand;
        this.carroEletrico = carroEletrico;
        this.carroEletrico.setEstado(false);
    }

    public Long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public VendedorStand getVendedorStand() {
        return vendedorStand;
    }

    public void setVendedorStand(VendedorStand vendedorStand) {
        this.vendedorStand = vendedorStand;
    }

    public CarroEletrico getCarroEletrico() {
        return carroEletrico;
    }

    public void setCarroEletrico(CarroEletrico carroEletrico) {
        this.carroEletrico = carroEletrico;
    }
    

    public double getPreco() {
		return preco;
	}

	@Override
	public String toString() {
		return "Venda [id=" + id + ", cliente=" + cliente + ", vendedorStand=" + vendedorStand + ", carroEletrico="
				+ carroEletrico + ", preco=" + preco + "]";
	}

	
}