package pt.upt.ei.lp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.persistence.Query;


import pt.upt.ei.lp.db.CarroEletrico_Service;
import pt.upt.ei.lp.db.CarroEletrico;
import pt.upt.ei.lp.db.Venda;
import pt.upt.ei.lp.db.VendaService;
import pt.upt.ei.lp.db.Cliente;
import pt.upt.ei.lp.db.Cliente_Service;

public class VendaGUI extends JFrame {
	
    private final EntityManagerFactory emf;
    private final EntityManager em;

    private JTextField idCarroField;
    private JTextField compradorField;
    private JTextField valorField;
    private JTextArea outputArea;

    
    
    public VendaGUI() {
        emf = Persistence.createEntityManagerFactory("LibraryJPA");
        em = emf.createEntityManager();

        setTitle("Sistema de Vendas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        initComponents();
    }

    private void initComponents() {
        setLayout(new GridLayout(5, 2));

        JLabel idCarroLabel = new JLabel("ID do Carro:");
        idCarroField = new JTextField();

        JLabel compradorLabel = new JLabel("Comprador:");
        compradorField = new JTextField();

        JLabel valorLabel = new JLabel("Valor:");
        valorField = new JTextField();

        JButton realizarVendaButton = new JButton("Realizar Venda");
        realizarVendaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarVenda();
            }
        });

        JButton listarVendasButton = new JButton("Listar Vendas");
        listarVendasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarVendas();
            }
        });

        JButton listarCarrosButton = new JButton("Listar IDs dos Carros");
        listarCarrosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarIdsDosCarros();
            }
        });

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        add(idCarroLabel);
        add(idCarroField);
        add(compradorLabel);
        add(compradorField);
        add(valorLabel);
        add(valorField);
        add(realizarVendaButton);
        add(listarVendasButton);
        add(listarCarrosButton);
        add(scrollPane);
    }

    private void realizarVenda() {
        try {
            int idCarro = Integer.parseInt(idCarroField.getText());
            String comprador = compradorField.getText();
            double preco = Double.parseDouble(valorField.getText());

            em.getTransaction().begin();

            CarroEletrico carro = em.find(CarroEletrico.class, idCarro);

            if (carro != null) {
                Venda venda = new Venda();
                venda.setCarroEletrico(carro);

                em.persist(venda);

                System.out.println("Venda realizada com sucesso!");
            } else {
                System.out.println("Carro com ID " + idCarro + " não encontrado.");
            }

            em.getTransaction().commit();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira valores numéricos válidos.");
        }
    }

   
    private void listarVendas() {
        Query query = em.createQuery("SELECT v FROM Venda v");
        List<Venda> vend = query.getResultList();

        StringBuilder vendas = new StringBuilder("Lista de Vendas:\n");
        for (Venda venda : vend) {
        	if (venda.getCliente()!=null) {
        	 vendas.append(venda).append("\n");
        }

        outputArea.setText(vendas.toString());
        
        	//
        	
        	//outputArea.append("ID da Venda: " + venda.getId() + "\n");
            // outputArea.append("Carro: " + venda.getCarroEletrico().getMarca() + " " + venda.getCarroEletrico().getModelo() + "\n");
            // outputArea.append("Comprador: " + venda.getCliente().getNome() + "\n");
           // outputArea.append("Preço: " + venda.getCarroEletrico().getPreco() + "\n");
           // outputArea.append("-----------\n");
        }
    }
    

    private void listarIdsDosCarros() {
    	 
    	 Query query = em.createQuery("SELECT car FROM CarroEletrico car");
    	 List<CarroEletrico> n = query.getResultList();

        StringBuilder sb = new StringBuilder("IDs dos Carros:\n");
        for (CarroEletrico id : n) {
            sb.append(id).append("\n");
        }

        outputArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VendaGUI().setVisible(true);
            }
        });
    }
}
