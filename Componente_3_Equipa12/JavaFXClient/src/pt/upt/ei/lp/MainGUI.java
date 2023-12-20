package pt.upt.ei.lp;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainGUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        showWelcomeScreen(primaryStage);
    }

    private void showWelcomeScreen(Stage primaryStage) {
        primaryStage.setTitle("Welcome Screen");

        VBox welcomeLayout = new VBox(10);
        welcomeLayout.setPadding(new Insets(20, 20, 20, 20));

        Label welcomeLabel = new Label("Bem-vindo à aplicação de gerir um stand automóvel!");
        welcomeLabel.setStyle("-fx-font-size: 16px;");

        ProgressIndicator loadingIndicator = new ProgressIndicator();

        Button avancarButton = new Button("Avançar");
        avancarButton.setOnAction(e -> {
            primaryStage.close(); // Fechar a tela de boas-vindas
            openMainScreen(); // Abrir a tela principal
        });

        // Botão de suporte
        Button suporteButton = new Button("Suporte");
        suporteButton.setOnAction(e -> exibirInformacoesDeContato());

        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().addAll(avancarButton, suporteButton);

        welcomeLayout.getChildren().addAll(welcomeLabel, loadingIndicator, buttonBox);

        Scene welcomeScene = new Scene(welcomeLayout, 400, 200);
        primaryStage.setScene(welcomeScene);
        primaryStage.show();

        // Simula uma tarefa demorada antes de avançar para a tela principal
        simulateLoadingTask(() -> {
            loadingIndicator.setVisible(false);
            avancarButton.setDisable(false);
        });
    }

    private void openMainScreen() {
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Main GUI");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(10);

        Button carroEletricoButton = new Button("Carro Elétrico GUI");
        carroEletricoButton.setOnAction(e -> {
            Stage carroEletricoStage = new Stage();
            new CarroEletricoGUI().start(carroEletricoStage);
        });

        Button vendaButton = new Button("Venda GUI");
        vendaButton.setOnAction(e -> {
            Stage vendaStage = new Stage();
            new VendaGUI().setVisible(true);
        });

        Button clienteButton = new Button("Cliente GUI");
        clienteButton.setOnAction(e -> {
            Stage clienteStage = new Stage();
            new ClienteGUI().start(clienteStage);
        });

        Button sairButton = new Button("Sair");
        sairButton.setOnAction(e -> primaryStage.close());

        Button ajudaButton = new Button("Ajuda");
        ajudaButton.setOnAction(e -> exibirInstrucoes());

        grid.add(carroEletricoButton, 0, 0);
        grid.add(vendaButton, 1, 0);
        grid.add(clienteButton, 2, 0);
        grid.add(sairButton, 3, 0);
        grid.add(ajudaButton, 4, 0);

        Scene scene = new Scene(grid, 600, 400);
        primaryStage.setScene(scene);

        primaryStage.setOnCloseRequest(e -> {
            // Adicione aqui qualquer lógica adicional que você deseja executar antes de fechar
            // Por exemplo, salvar dados ou realizar verificações
            System.out.println("Fechando a aplicação...");
        });

        primaryStage.show();
    }

    private void exibirInstrucoes() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ajuda");
        alert.setHeaderText(null);
        alert.setContentText("Bem-vindo à aplicação!\n\n" +
                "Instruções:\n" +
                "- Clique nos botões para acessar diferentes funcionalidades.\n" +
                "- O botão 'Sair' fecha a aplicação.\n" +
                "- Para obter mais ajuda, entre em contato com o suporte.");

        alert.showAndWait();
    }

    private void exibirInformacoesDeContato() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Suporte");
        alert.setHeaderText(null);
        alert.setContentText("Para suporte, entre em contato com:\n" +
                "- Paula Morais: pmorais@upt.pt\n" +
                "- Tiago Silva: thiago.silva@upt.pt\n\n" +
                "😊"); // Adiciona um emoji smile

        alert.showAndWait();
    }

    private void simulateLoadingTask(Runnable onTaskComplete) {
        new Thread(() -> {
            try {
                // Simula uma tarefa demorada
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            onTaskComplete.run();
        }).start();
    }
}










