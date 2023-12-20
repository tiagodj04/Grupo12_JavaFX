package pt.upt.ei.lp.db;

import java.util.Iterator;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.ManyToOne;


public class VendedorStand_Service {
	
	protected  EntityManager em;
	
	/*
	private static final String PERSISTENCE_UNIT_NAME = "LibraryJPA";
	private static EntityManagerFactory factory;
	private static EntityManager em = null;
	
	
	private static EntityManager getEM() {
		if (em == null) {
			factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
			em = factory.createEntityManager();
		}
		return em;
	}
	 */
	public VendedorStand_Service(EntityManager em) {
		this.em = em;
	}
	/*
	public VendedorStand_Service() {
		  this.em = getEM();		// TODO Auto-generated constructor stub
	}
	*/
	public VendedorStand updateVendedorStand( String nome, String pass, List<CarroEletrico> carrosEletricos) {
	    VendedorStand vendS = em.find(VendedorStand.class, nome);
	    
	    if (vendS == null) {
	        vendS = new VendedorStand();
	        em.persist(vendS);
	    }
	    
	    //vendS.setId(id);
	    vendS.setNome(nome);
	    vendS.setPass(pass);
	    vendS.getCarrosEletricos().clear();
	    vendS.getCarrosEletricos().addAll(carrosEletricos);
	    
	    return vendS;
	}

	public VendedorStand updateVendedorStand( String nome, String pass) {
	    VendedorStand vendS = em.find(VendedorStand.class, nome);
	    
	    if (vendS == null) {
	        vendS = new VendedorStand();
	        em.persist(vendS);
	    }
	    
	    //vendS.setId(id);
	    vendS.setNome(nome);
	    vendS.setPass(pass);
	    vendS.getCarrosEletricos().clear();
	    
	    return vendS;
	}
	public void removeVendedorStand(int id) {
		
		VendedorStand vendST = findVendedorStand(id);
		
		if (vendST != null)
			em.remove(vendST);
		
		return;		
	}

	public VendedorStand findVendedorStand( int id) {
		return em.find(VendedorStand.class, id);
		
	}
	
	public List<VendedorStand> findAllVendedoresStand() {
		 Query qd = em.createQuery("SELECT vendS FROM VendedorStand vendS");
		 return qd.getResultList();
	}

	public void listVendedoresStand() {
		try {
			em.getTransaction().begin();
			
			@SuppressWarnings("unchecked")
			List<VendedorStand> clients = em.createQuery("SELECT vendS FROM VendedorStand vendS").getResultList();
			
			for (Iterator<VendedorStand> iterator = clients.iterator(); iterator.hasNext();) {
				VendedorStand vendedorStand = (VendedorStand) iterator.next();
				System.out.println(vendedorStand.toString());
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

}
