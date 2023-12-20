package pt.upt.ei.lp.db;

import java.util.List;




import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import pt.upt.ei.lp.db.CarroEletrico;

//import stand.CarroEletrico;
public class CarroEletrico_Service {

    private final EntityManager em;

    public CarroEletrico_Service(EntityManager em) {
        this.em = em;
    }

    public CarroEletrico updateCarroEletrico(int id, String marca, String modelo, int ano, int kms, int cavalos, int autonomia, String descricao, double preco, boolean estado) {
        CarroEletrico car = em.find(CarroEletrico.class, id);
        if (car == null) {
            car = new CarroEletrico(id, marca, modelo, ano, kms, cavalos, autonomia, descricao, preco, estado);
            em.persist(car);
        } else {
            car.setMarca(marca);
            car.setModelo(modelo);
            car.setAno(ano);
            car.setKms(kms);
            car.setCavalos(cavalos);
            car.setAutonomia(autonomia);
            car.setDescricao(descricao);
            car.setPreco(preco);
            car.setEstado(estado);
        }
        return car;
    }

    public void removeCarroEletrico(int id) {
        CarroEletrico ce = findCarroEletrico(id);
        if (ce != null)
            em.remove(ce);
    }

    public CarroEletrico findCarroEletrico(int id) {
        return em.find(CarroEletrico.class, id);
    }

    public List<CarroEletrico> findAllCarrosEletricos() {
        Query qd = em.createQuery("SELECT car FROM CarroEletrico car");
        return qd.getResultList();
    }
    public void printCarroEletrico(int id) {
        CarroEletrico car = findCarroEletrico(id);
        if (car != null) {
            System.out.println("Detalhes do Carro Elétrico com ID " + id + ":");
            System.out.println("Marca: " + car.getMarca());
            System.out.println("Modelo: " + car.getModelo());
            System.out.println("Ano: " + car.getAno());
            System.out.println("Quilometragem: " + car.getKms() + " km");
            System.out.println("Cavalos: " + car.getCavalos());
            System.out.println("Autonomia: " + car.getAutonomia() + " km");
            System.out.println("Descrição: " + car.getDescricao());
            System.out.println("Preço: " + car.getPreco() + " EUR");
            System.out.println("Estado: " + (car.isEstado() ? "Disponível" : "Indisponível"));
        } else {
            System.out.println("Carro Elétrico com o id " + id + " não encontrado.");
        }
    }
   
} 





























/*public class CarroEletrico_Service {
	
	protected EntityManager em;
	
	public CarroEletrico_Service (EntityManager em) {
		this.em = em;
	}
	
	public CarroEletrico updateCarroEletrico(int id,String marca, String modelo, int ano,int kms, int cavalos, int autonomia, String descricao, double preco, boolean estado) {
		CarroEletrico car = em.find(CarroEletrico.class,id);
		if (car == null) {
			car = new CarroEletrico();
			em.persist(car);
		}
		car.setMarca(marca);
		car.setModelo(modelo);
		car.setAno(ano);
		car.setKms(kms);
		car.setCavalos(cavalos);
		car.setAutonomia(autonomia);
		car.setDescricao(descricao);
		car.setPreco(preco);
		car.setEstado(estado);
		
		return car;
	}
	
	public void removeCarroEletrico(int id) {
		CarroEletrico ce = findCarroEletrico(id);
		if (ce!= null)
			em.remove(ce);
		return;
	}
	public CarroEletrico findCarroEletrico(int id) {
		return em.find(CarroEletrico.class, id);
	}
	
	public  List<CarroEletrico> findAllCarrosEletricos(){
		Query qd = em.createQuery("SELECT car FROM CarroEletrico car");
		return qd.getResultList();
	}
*/
	
	
	
	
	
	
	
	
	
	
	
	/*private static final String PERSISTENCE_UNIT_NAME = "LibraryJPA";
	private static EntityManagerFactory factory;
	private static EntityManager em = null;
	
	private static EntityManager getEM() {
		if (em == null) {
			factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
			em = factory.createEntityManager();
		}
		return em;
	}
	
	public CarroEletrico_Service(EntityManager em) {
		this.em = em;
	}
	
	public CarroEletrico_Service() {
		this.em = getEM();
	}
	
	public CarroEletrico updateCarro(int id,String marca, String modelo, int ano,int kms, int cavalos, int autonomia, String descricao, double preco, boolean estado) {	
		CarroEletrico car = findCarrosEletricos(id);
		if (car == null) {
			car = new CarroEletrico();
			// Begin a new local transaction so that we can persist new entities
			if (!em.getTransaction().isActive()) {
			em.getTransaction().begin();
			em.persist(car);
			// Commit the transaction, which will cause the entity to
			// be stored in the database
			em.getTransaction().commit();
		}
			em.persist(car);	
		}
		
		car.setMarca(marca);
		car.setModelo(modelo);
		car.setAno(ano);
		car.setKms(kms);
		car.setCavalos(cavalos);
		car.setAutonomia(autonomia);
		car.setDescricao(descricao);
		car.setPreco(preco);
		car.setEstado(estado);
		
		// Begin a new local transaction so that we can persist new entities
		em.persist(car);
		// Commit the transaction, which will cause the entity to
		// be stored in the database
		return car;
	}
	
	public boolean removeCarroEletrico(int id) {
		CarroEletrico car = findCarrosEletricos(id);
		if (car != null) {
			// Begin a new local transaction so that we can persist new entities
			em.getTransaction().begin();
			em.remove(car);
			// Commit the transaction, which will cause the entity to
			// be stored in the database
			em.getTransaction().commit();

			return true;
		}
		return false;
		}
	
	public CarroEletrico findbvCarrosEletricos( int id) {
		return em.find(CarroEletrico.class, id);
	}
	
	public List<CarroEletrico> findAllCarros() {
		 Query qd = em.createQuery("SELECT el FROM CarroEletrico el");
		 return qd.getResultList();
	}
	*/

