package pt.upt.ei.lp.db;

import javax.persistence.EntityManager;

public class VendaService {

    private final EntityManager em;

    public VendaService(EntityManager em) {
        this.em = em;
    }
    

    public Venda createVenda(Cliente cliente, VendedorStand vendedorStand, CarroEletrico carroEletrico,double preco) {
        Venda venda = new Venda(cliente, vendedorStand, carroEletrico, preco);
        double precoCarro = carroEletrico.getPreco() ;
        em.getTransaction().begin();
        em.persist(venda);
        
        em.getTransaction().commit();

        return venda;
    }
}
