package pt.upt.ei.lp;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import pt.upt.ei.lp.db.CarroEletrico;
import pt.upt.ei.lp.db.CarroEletrico_Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CarroEletricoGUI extends Application {

    private EntityManagerFactory emf;
    private EntityManager em;
    private CarroEletrico_Service carroEletricoService;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("CarroEletrico GUI");

        emf = Persistence.createEntityManagerFactory("LibraryJPA");
        em = emf.createEntityManager();
        carroEletricoService = new CarroEletrico_Service(em);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        // Labels
        Label marcaLabel = new Label("Marca:");
        GridPane.setConstraints(marcaLabel, 0, 0);

        Label modeloLabel = new Label("Modelo:");
        GridPane.setConstraints(modeloLabel, 0, 1);

        Label anoLabel = new Label("Ano:");
        GridPane.setConstraints(anoLabel, 0, 2);

        Label kmsLabel = new Label("Quilômetros:");
        GridPane.setConstraints(kmsLabel, 0, 3);

        Label descricaoLabel = new Label("Descrição:");
        GridPane.setConstraints(descricaoLabel, 0, 4);

        Label cavalosLabel = new Label("Cavalos:");
        GridPane.setConstraints(cavalosLabel, 0, 5);

        Label autonomiaLabel = new Label("Autonomia:");
        GridPane.setConstraints(autonomiaLabel, 0, 6);

        Label precoLabel = new Label("Preço:");
        GridPane.setConstraints(precoLabel, 0, 7);

        Label estadoLabel = new Label("Estado:");
        GridPane.setConstraints(estadoLabel, 0, 8);

        Label idLabel = new Label("ID:");
        GridPane.setConstraints(idLabel, 0, 9);

        // TextFields
        TextField marcaInput = new TextField();
        GridPane.setConstraints(marcaInput, 1, 0);

        TextField modeloInput = new TextField();
        GridPane.setConstraints(modeloInput, 1, 1);

        TextField anoInput = new TextField();
        GridPane.setConstraints(anoInput, 1, 2);

        TextField kmsInput = new TextField();
        GridPane.setConstraints(kmsInput, 1, 3);

        TextField descricaoInput = new TextField();
        GridPane.setConstraints(descricaoInput, 1, 4);

        TextField cavalosInput = new TextField();
        GridPane.setConstraints(cavalosInput, 1, 5);

        TextField autonomiaInput = new TextField();
        GridPane.setConstraints(autonomiaInput, 1, 6);

        TextField precoInput = new TextField();
        GridPane.setConstraints(precoInput, 1, 7);

        CheckBox estadoCheckBox = new CheckBox("Disponível");
        GridPane.setConstraints(estadoCheckBox, 1, 8);

        TextField idInput = new TextField();
        GridPane.setConstraints(idInput, 1, 9);

        // Buttons
        Button adicionarButton = new Button("Adicionar Carro");
        GridPane.setConstraints(adicionarButton, 1, 10);
        adicionarButton.setOnAction(e -> adicionarCarro(
                marcaInput.getText(),
                modeloInput.getText(),
                Integer.parseInt(anoInput.getText()),
                Integer.parseInt(kmsInput.getText()),
                descricaoInput.getText(),
                Integer.parseInt(cavalosInput.getText()),
                Integer.parseInt(autonomiaInput.getText()),
                Double.parseDouble(precoInput.getText()),
                estadoCheckBox.isSelected()
        ));

        Button listarButton = new Button("Listar Carros");
        GridPane.setConstraints(listarButton, 1, 11);
        listarButton.setOnAction(e -> listarCarros());

        Button removerButton = new Button("Remover Carro");
        GridPane.setConstraints(removerButton, 1, 12);
        removerButton.setOnAction(e -> removerCarro(Integer.parseInt(idInput.getText())));

        grid.getChildren().addAll(
                marcaLabel, modeloLabel, anoLabel, kmsLabel, descricaoLabel,
                cavalosLabel, autonomiaLabel, precoLabel, estadoLabel,
                idLabel,
                marcaInput, modeloInput, anoInput, kmsInput, descricaoInput,
                cavalosInput, autonomiaInput, precoInput, estadoCheckBox,
                idInput,
                adicionarButton, listarButton, removerButton
        );

        Scene scene = new Scene(grid, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

        
        primaryStage.setOnCloseRequest(windowEvent -> emf.close());
    }

    private void adicionarCarro(String marca, String modelo, int ano, int kms,
                                String descricao, int cavalos, int autonomia,
                                double preco, boolean estado) {
        CarroEletrico carro = new CarroEletrico();
        carro.setMarca(marca);
        carro.setModelo(modelo);
        carro.setAno(ano);
        carro.setKms(kms);
        carro.setDescricao(descricao);
        carro.setCavalos(cavalos);
        carro.setAutonomia(autonomia);
        carro.setPreco(preco);
        carro.setEstado(estado);

        em.getTransaction().begin();
        em.persist(carro);
        em.getTransaction().commit();

        System.out.println("Carro adicionado: " + carro.toString());
    }

    private void listarCarros() {
        List<CarroEletrico> carros = carroEletricoService.findAllCarrosEletricos();
        for (CarroEletrico carro : carros) {
            System.out.println(carro.toString());
        }
    }

    private void removerCarro(int id) {
        CarroEletrico carro = carroEletricoService.findCarroEletrico(id);
        if (carro != null) {
            em.getTransaction().begin();
            em.remove(carro);
            em.getTransaction().commit();
    
       }
    }
}