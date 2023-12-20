package pt.upt.ei.lp.db;

import java.util.Iterator;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.Entity;


public class Cliente_Service {
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

    public Cliente_Service(EntityManager em) {
        this.em = em;
    }

    public Cliente_Service() {
        this.em = getEM();
    }

    public Cliente updateCliente(Cliente cli) {
        if (cli.getId() == null) {
            // Se o ID for nulo, é uma nova entidade
            em.persist(cli);
            return cli;
        } else {
            // Se o ID não for nulo, busca e atualiza a entidade existente
            Cliente cliToUpdate = em.find(Cliente.class, cli.getId());

            if (cliToUpdate == null) {
                // Lidar com o caso em que a entidade não existe no banco de dados
                em.persist(cli);
                return cli;
            }

            cliToUpdate.setNome(cli.getNome());
            cliToUpdate.setEmail(cli.getEmail());
            em.persist(cliToUpdate);

            return cliToUpdate;
        }
    }

    public Cliente updateCliente(Long id, String pass, String mail, String nome) {
        Cliente cli = em.find(Cliente.class, id);

        if (cli == null) {
            cli = new Cliente();

            cli.setNome(nome);
            cli.setEmail(mail);
            em.persist(cli);
            return cli;
        }

        cli.setNome(nome);
        cli.setEmail(mail);
        em.persist(cli);

        return cli;
    }

    public void removeCliente(Long id) {
        Cliente cli = findCliente(id);

        if (cli != null)
            em.remove(cli);

        return;
    }

    public Cliente findCliente(long id) {
        return em.find(Cliente.class, id);
    }

    public List<Cliente> findAllClientes() {
        Query qd = em.createQuery("SELECT cli FROM Cliente cli");
        return qd.getResultList();
    }

    public List<Cliente> findAllClientes(EntityManager em) {
        Query qd = em.createQuery("SELECT cli FROM Cliente cli");
        return qd.getResultList();
    }

    public void listClientes() {
        try {
            em.getTransaction().begin();

            @SuppressWarnings("unchecked")
            List<Cliente> clients = em.createQuery("SELECT cli FROM Cliente cli").getResultList();

            for (Iterator<Cliente> iterator = clients.iterator(); iterator.hasNext();) {
                Cliente client = iterator.next();
                System.out.println(client.toString());
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }
}














































/*
public class Cliente_Service {
	//protected EntityManager em;
	
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
	

	public Cliente_Service(EntityManager em) {
		this.em = em;
	}
	
	public Cliente_Service() {
		  this.em = getEM();		
	}

	public Cliente updateCliente(Cliente cli) {
		
		Cliente cliToUpdate = em.find(Cliente.class, cli.getId());
		
		if (cliToUpdate == null) {			
			em.persist(cli);
			return cli;
		}

		cliToUpdate.setNome(cli.getNome());
		cliToUpdate.setEmail(cli.getEmail());
		//cliToUpdate.setPass(cli.getPass());
		em.persist(cliToUpdate);
		
		return cliToUpdate;
	}

	public Cliente updateCliente(Long id ,String pass,String mail,String nome) {
		
		Cliente cli = em.find(Cliente.class, id);
		
		if (cli == null) {
			cli = new Cliente();
			
			cli.setNome(nome);
			cli.setEmail(mail);
			//cli.setPass(pass);
			
			em.persist(cli);
			return cli;
		}

		cli.setNome(nome);
		cli.setEmail(mail);
		//cli.setPass(pass);
		
		em.persist(cli);
		
		return cli;
	}

	public void removeCliente(Long id) {
		
		Cliente cli = findCliente(id);
		
		if (cli != null)
			em.remove(cli);
		
		return;		
	}

	public Cliente findCliente(long id) {
		return em.find(Cliente.class, id);
		
	}

	public List<Cliente> findAllClientes() {
		 Query qd = em.createQuery("SELECT cli FROM Cliente cli");
		 return qd.getResultList();
	}
	
	public List<Cliente> findAllClientes(EntityManager em) {
		 Query qd = em.createQuery("SELECT cli FROM Cliente cli");
		 return qd.getResultList();
	}

	public void listClientes() {
		try {
			em.getTransaction().begin();
			
			@SuppressWarnings("unchecked")
			List<Cliente> clients = em.createQuery("SELECT cli FROM Cliente cli").getResultList();
			
			for (Iterator<Cliente> iterator = clients.iterator(); iterator.hasNext();) {
				Cliente client = (Cliente) iterator.next();
				System.out.println(client.toString());
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

}
*/