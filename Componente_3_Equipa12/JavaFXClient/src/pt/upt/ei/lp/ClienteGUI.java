package pt.upt.ei.lp;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import pt.upt.ei.lp.db.Cliente;
import pt.upt.ei.lp.db.Cliente_Service;

import javax.swing.JOptionPane;

public class ClienteGUI extends Application {

    private Cliente cliente = new Cliente();
    private TextField nomeField;
    private TextField emailField;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Cliente GUI");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        Label nameLabel = new Label("Nome:");
        nomeField = new TextField();
        nomeField.setPromptText("Enter nome");
        grid.add(nameLabel, 0, 0);
        grid.add(nomeField, 1, 0);

        Label emailLabel = new Label("Email:");
        emailField = new TextField();
        emailField.setPromptText("Enter email");
        grid.add(emailLabel, 0, 1);
        grid.add(emailField, 1, 1);

        Button displayButton = new Button("Display Cliente Info");
        grid.add(displayButton, 1, 2);

        Button addButton = new Button("Adicionar Cliente");
        grid.add(addButton, 0, 2);

        Button listButton = new Button("Listar Clientes");
        grid.add(listButton, 0, 3);

        Button removeButton = new Button("Remover Cliente");
        grid.add(removeButton, 1, 3);

        displayButton.setOnAction(e -> {
            cliente.setNome(nomeField.getText());
            cliente.setEmail(emailField.getText());
            System.out.println(cliente.toString());
        });

        addButton.setOnAction(e -> {
            String nome = nomeField.getText();
            String email = emailField.getText();

            Cliente newCliente = new Cliente();
            newCliente.setNome(nome);
            newCliente.setEmail(email);

            Cliente_Service clienteService = new Cliente_Service();
            clienteService.updateCliente(newCliente);

            clearFields();
        });

        listButton.setOnAction(e -> {
            Cliente_Service clienteService = new Cliente_Service();
            clienteService.listClientes();
        });

        removeButton.setOnAction(e -> {
            try {
                Long id = Long.parseLong(JOptionPane.showInputDialog("Enter Cliente ID to remove:"));
                Cliente_Service clienteService = new Cliente_Service();
                clienteService.removeCliente(id);
                JOptionPane.showMessageDialog(null, "Cliente removido com sucesso!");
            } catch (NumberFormatException ex) {
                showAlert("Erro", "ID inválido", "Por favor, insira um ID válido para remover o cliente.");
            }
        });

        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void clearFields() {
        nomeField.clear();
        emailField.clear();
    }

    private void showAlert(String title, String header, String content) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}