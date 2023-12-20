
package pt.upt.ei.lp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CreateAccountGui extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Create Account");

        VBox vbox = new VBox(); // Adicione seus elementos aqui

        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showCreateAccount() {
        launch();
    }
}