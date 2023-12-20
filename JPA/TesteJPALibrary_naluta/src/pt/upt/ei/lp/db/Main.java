package pt.upt.ei.lp.db;

import java.util.List;







import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


//import pt.upt.ei.lp.db.AdminStand;
import pt.upt.ei.lp.db.Utilizador;

import javax.persistence.Query;
import pt.upt.ei.lp.db.CarroEletrico;
//import pt.upt.ei.lp.db.AdminStand;
import pt.upt.ei.lp.db.Cliente;
import pt.upt.ei.lp.db.Utilizador;
import pt.upt.ei.lp.db.VendedorStand;

public class Main {
	
	
	
	private static final String PERSISTENCE_UNIT_NAME = "LibraryJPA";
	private static EntityManagerFactory factory;
	private static EntityManager emanager = null;

	public static void fill() {
		System.out.println("========");
		System.out.println("  FILL -- NOVO");
		System.out.println("========");
		EntityManager em = getEM();
		Query q = null;
		
		List<VendedorStand> vendedorStands = null;
		List<CarroEletrico> carrosEletricos= null;
		List<Cliente>Cliente=null;
		
		VendedorStand_Service vss = new VendedorStand_Service(getEM());
		List<VendedorStand> vendedorStandList = vss.findAllVendedoresStand();
		for (VendedorStand a : vendedorStandList) {
			//vss.removeVendedorStand(a.getId());
		
	    }
		
		CarroEletrico_Service cs = new CarroEletrico_Service(getEM());
		List<CarroEletrico> carroEletricoList = cs.findAllCarrosEletricos();
		for (CarroEletrico c : carroEletricoList) {
			cs.removeCarroEletrico(c.getId());
		
		}
		
		Cliente_Service ad= new Cliente_Service(getEM());
		List<Cliente> clienteList= ad.findAllClientes();
		for (Cliente m : clienteList) {
			ad.removeCliente(m.getId());
			
		}
		
		
		System.out.println("Cleaned DB");
		System.out.println("------------------------");
		// Begin a new local transaction so that we can persist new entities
		em.getTransaction().begin();
		
		//List<Utilizador> utilizadores = null;
	    //List<AdminStand> adminStands = null;
	    //List<Cliente> clientes = null
	   
	    //em.getTransaction().begin();
	  
	 
	  VendedorStand v3 = vss.updateVendedorStand("123pass", "Vendedor3");
	  VendedorStand v1 = vss.updateVendedorStand("123pass", "Vendedor1");
	  VendedorStand v2 = vss.updateVendedorStand("123pass", "Vendedor2");
	  //VendedorStand v3 = vss.updateVendedorStand("123pass", "Vendedor3");

	  CarroEletrico c1 = cs.updateCarroEletrico(0, "BMW"    , "I4"       , 2018  ,103123, 240, 516, "Carro importado full extras", 47600 , true);
	  v1.getCarrosEletricos().add(c1);
	  CarroEletrico c2 = cs.updateCarroEletrico(0, "Audi"   , "E-tron GT", 2021  ,1360  , 530, 420, "Carro importado full extras", 160000, true);
	  v2.getCarrosEletricos().add(c2);
	  CarroEletrico c3 = cs.updateCarroEletrico(0, "BMW"    , "I3"       , 2016  ,98000 , 160, 412, "Carro importado full extras", 15600 , true);
	  v3.getCarrosEletricos().add(c3);
	  CarroEletrico c4 = cs.updateCarroEletrico(0, "Pegeout", "e-308"    , 2020  ,30000 , 212, 468, "Carro importado full extras", 32000 , true);
	  v1.getCarrosEletricos().add(c4);
	  CarroEletrico c5 = cs.updateCarroEletrico(0, "Tesla"  , "Model 3"  , 2018  ,87000 , 320, 579, "Carro importado full extras", 31600 , true);
	  v3.getCarrosEletricos().add(c5);
	  
	  Cliente t1= ad.updateCliente((long) 0,"123pass", "cli@upt.pt", "Nome12");

	  Cliente t2= ad.updateCliente((long) 0,"123pass", "cli@upt.pt", "Nome23");
	 
	  
	  em.getTransaction().commit();
	  
	  vendedorStands = vss.findAllVendedoresStand();
		System.out.println("------------------------");
		System.out.println("Vendedores_Stand table");
		for (VendedorStand p : vendedorStands) {
			System.out.println(p);
		}
	  
		
		carrosEletricos = cs.findAllCarrosEletricos();
		System.out.println("------------------------");
		System.out.println("Carros_Eletricos table");
		for (CarroEletrico e : carrosEletricos) {
			System.out.println(e);
		}
		
		Cliente = ad.findAllClientes();
		System.out.println("------------------------");
		System.out.println("Cliente table NOVO");
		for (Cliente h : Cliente) {
			System.out.println(h);
		}
		
		 VendaService vendaService = new VendaService(em);
		 Venda venda = vendaService.createVenda(t1, v1, c1, c1.getPreco());

	       System.out.println("Venda registrada com sucesso: " + venda);
	       System.out.println("Estado carro:"+ c1.isEstado());
	       
	      
	       
		
		
		System.out.println("------------------------");
		System.out.println("\n\nFinished!!!");
	}  
	
	public static EntityManager getEM() {
		if(emanager == null) {
			factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
			emanager = factory.createEntityManager();
		}
		return emanager;
	}
	
	public static void main(String[] args) {
		fill();
	}
}

