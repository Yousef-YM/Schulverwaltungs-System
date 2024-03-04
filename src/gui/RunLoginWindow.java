/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author CC-Student
 */
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javase.ss.handler.BenutzerHandler;

public class RunLoginWindow extends Application {

    private Button loginButton;
    private TextField usernameTextField;
    private PasswordField passwordField;
    private boolean isLoggedIn = false;

    public Button getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(Button loginButton) {
        this.loginButton = loginButton;
    }

    @Override
    public void start(Stage primaryStage) {

        // Labels und Textfelder für Benutzername und Passwort
        Label usernameLabel = new Label("Benutzername:");
        usernameTextField = new TextField();
        Label passwordLabel = new Label("Passwort:");
        passwordField = new PasswordField();

        // Login-Button
        loginButton = new Button("Anmelden");
        loginButton.setDefaultButton(true);
        loginButton.setOnAction(e -> handleLogin());

        // GridPane für Anordnung der Labels und Textfelder
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.add(usernameLabel, 0, 0);
        gridPane.add(usernameTextField, 1, 0);
        gridPane.add(passwordLabel, 0, 1);
        gridPane.add(passwordField, 1, 1);

        // HBox für Login-Button
        HBox buttonBox = new HBox();
        buttonBox.setAlignment(Pos.CENTER_RIGHT);
        buttonBox.getChildren().add(loginButton);

        // VBox für die Gesamtanordnung des Login-Fensters
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(20));
        vBox.setSpacing(20);
        vBox.getChildren().addAll(gridPane, buttonBox);

        // Scene erstellen und dem Stage hinzufügen
        Scene scene = new Scene(vBox, 400, 200);
        primaryStage.setTitle("Login-Fenster");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    private void handleLogin() {
        String username = usernameTextField.getText();
        String password = passwordField.getText();

        if (BenutzerHandler.checkLogin(username, password)) {
            isLoggedIn = true;

            RunClass run = new RunClass();
            Stage runStage = new Stage();
            try {
                run.start(runStage);
            } catch (Exception ex) {
                Logger.getLogger(RunLoginWindow.class.getName())
                        .log(Level.SEVERE, null, ex);
            }

            loginButton.getScene().getWindow().hide();

        } else {
            // Ansonsten geben wir eine Fehlermeldung aus:
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Fehler beim Anmelden");
            alert.setHeaderText("Falscher Benutzername oder Passwort");
        alert.setContentText("Bitte geben Sie Ihre Anmeldedaten erneut ein.");
            alert.showAndWait();
        }
    }

}
