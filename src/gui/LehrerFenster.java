/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.ArrayList;
import java.util.Optional;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javase.ss.classes.Lehrer;
import javase.ss.handler.LehrerHandler;

/**
 * 06957003680
 *
 * @author CC-Student
 */
public class LehrerFenster extends Application {

    private static final int DEFAULT_WIDTH = 1200;

    private Button lehrerButton;

    @Override
    public void start(Stage primaryStage) throws Exception {

        //BorderPane root = new BorderPane();
        // Create the Lehrer button
        lehrerButton = new Button("Lehrer");
        lehrerButton.setMaxWidth(Double.MAX_VALUE);
        lehrerButton.setMaxHeight(Double.MAX_VALUE);
        lehrerButton.setFont(Font.font("System", FontWeight.EXTRA_BOLD, 35));

        lehrerButton.setStyle("-fx-background-color: #F0E68C; "
                + "-fx-text-fill: black; -fx-font-weight: bold;");

        lehrerButton.setOnMouseEntered(e -> {
            lehrerButton.setStyle("-fx-background-color: #FFFACD; "
                    + "-fx-border-color: lightgreen; "
                    + "-fx-border-width: 9 0 0 0; "
                    + "-fx-text-fill: black; "
                    + "-fx-font-weight: bold;");
            lehrerButton.setFont(Font.font("System", FontWeight.EXTRA_BOLD, 45));
        });

        lehrerButton.setOnMouseExited(e -> {
            lehrerButton.setStyle("-fx-background-color: #F0E68C; "
                    + "-fx-border-color: transparent; "
                    + "-fx-border-width: 0;");
            lehrerButton.setFont(Font.font("System", FontWeight.BOLD, 35));
        });

        lehrerButton.setOnAction(e -> {

            //handle Lehrer button click
            Stage lehrerStage = new Stage();
            lehrerStage.setTitle("Lehrer Fenster");

            // Erstellen der Tabelle
            TableView<Lehrer> table = new TableView<>();

            // Erstellen der Spalten
            TableColumn<Lehrer, String> idCol = new TableColumn<>("LEHRER_ID");
            idCol.setCellValueFactory(new PropertyValueFactory<>("lehrerId"));

            TableColumn<Lehrer, String> vornameCol = new TableColumn<>("Vorname");
            vornameCol.setCellValueFactory(new PropertyValueFactory<>("vorname"));

            TableColumn<Lehrer, String> nachnameCol = new TableColumn<>("Nachname");
            nachnameCol.setCellValueFactory(new PropertyValueFactory<>("nachname"));

            TableColumn<Lehrer, String> adresseCol = new TableColumn<>("Adresse");
            adresseCol.setCellValueFactory(new PropertyValueFactory<>("adresse"));

            TableColumn<Lehrer, String> phoneCol = new TableColumn<>("Phone");
            phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));

            TableColumn<Lehrer, String> mailCol = new TableColumn<>("Mail");
            mailCol.setCellValueFactory(new PropertyValueFactory<>("mail"));

            TableColumn<Lehrer, String> rolleCol = new TableColumn<>("Rolle");
            rolleCol.setCellValueFactory(new PropertyValueFactory<>("rolle"));

            // Hinzufügen der Spalten zur Tabelle
            table.getColumns().addAll(idCol, vornameCol, nachnameCol, adresseCol,
                    phoneCol, mailCol, rolleCol);

            // Laden der Lehrerliste
            LehrerHandler lehrerH = new LehrerHandler();
            ArrayList<Lehrer> lehrerList = lehrerH.getAllLehrer();

            // Hinzufügen der Lehrer zur Tabelle
            table.getItems().addAll(lehrerList);

            // Erstellen der Buttons
            Button vertretung = new Button("Vertretungsliste");
            vertretung.setFont(Font.font("System", FontWeight.EXTRA_BOLD, 14));
            vertretung.setStyle("-fx-background-color: #F0E68C; "
                + "-fx-text-fill: black; -fx-font-weight: bold;");

            Button editButton = new Button("Bearbeiten");
            editButton.setFont(Font.font("System", FontWeight.EXTRA_BOLD, 14));
            editButton.setStyle("-fx-background-color: #F0E68C; "
                + "-fx-text-fill: black; -fx-font-weight: bold;");

            // Setzen der Aktionen für die Buttons
            vertretung.setOnAction(addEvent -> {

                // Erstellen der Tabelle
                TableView<Lehrer> tableV = new TableView<>();

                // Erstellen der Spalten
                TableColumn<Lehrer, String> idColV = new TableColumn<>("LEHRER_ID");
                idColV.setCellValueFactory(new PropertyValueFactory<>("lehrerId"));

                TableColumn<Lehrer, String> vornameColV = new TableColumn<>("Vorname");
                vornameColV.setCellValueFactory(new PropertyValueFactory<>("vorname"));

                TableColumn<Lehrer, String> nachnameColV = new TableColumn<>("Nachname");
                nachnameColV.setCellValueFactory(new PropertyValueFactory<>("nachname"));

                TableColumn<Lehrer, String> adresseColV = new TableColumn<>("Adresse");
                adresseColV.setCellValueFactory(new PropertyValueFactory<>("adresse"));

                TableColumn<Lehrer, String> phoneColV = new TableColumn<>("Phone");
                phoneColV.setCellValueFactory(new PropertyValueFactory<>("phone"));

                TableColumn<Lehrer, String> mailColV = new TableColumn<>("Mail");
                mailColV.setCellValueFactory(new PropertyValueFactory<>("mail"));

                TableColumn<Lehrer, String> rolleColV = new TableColumn<>("Rolle");
                rolleColV.setCellValueFactory(new PropertyValueFactory<>("rolle"));

                // Hinzufügen der Spalten zur Tabelle
                tableV.getColumns().addAll(idColV, vornameColV, nachnameColV, adresseColV,
                        phoneColV, mailColV, rolleColV);

                LehrerHandler lehrerHV = new LehrerHandler();

                ArrayList<Lehrer> lehrerListV = lehrerHV.getAllVertretung();

                tableV.getItems().addAll(lehrerListV);

                Scene lehrerSceneV = new Scene(new BorderPane(tableV), 700, 500);
                Stage stage = new Stage();
                stage.setScene(lehrerSceneV);
                stage.setTitle("Vertretungsliste");
                stage.show();

            });

            editButton.setOnAction(editEvent -> {

            });

//____________________________________________________________________ löchen            
            Button deleteButton = new Button("Löschen");
            deleteButton.setFont(Font.font("System", FontWeight.EXTRA_BOLD, 14));
            deleteButton.setStyle("-fx-background-color: #F0E68C; "
                + "-fx-text-fill: black; -fx-font-weight: bold;");
            
            deleteButton.setOnAction(deleteEvent -> {

                // Erstelle eine TextInputDialog, um die Schüler-ID abzufragen
                TextInputDialog dialogL = new TextInputDialog();
                dialogL.setTitle("Lehrer löschen");
                dialogL.setHeaderText("Lehrer löschen");
                dialogL.setContentText("Geben Sie die ID des Lehrers ein, den Sie löschen möchten:");

                // Zeige den Dialog an und warte auf die Eingabe des Benutzers
                Optional<String> resultO = dialogL.showAndWait();

                // Wenn der Benutzer die Eingabe bestätigt hat, versuche den Schüler zu löschen
                resultO.ifPresent(lehrerId -> {
                    // Erstelle eine Bestätigungs-Dialogbox
                    Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
                    confirmation.setTitle("Lehrer löschen");
                    confirmation.setHeaderText("Lehrer löschen");
                    confirmation.setContentText("Möchten Sie den Lehrer mit der ID " + lehrerId + " wirklich löschen?");

                    // Zeige den Bestätigungsdialog an und warte auf die Antwort des Benutzers
                    Optional<ButtonType> deleteConfirmation = confirmation.showAndWait();

                    // Wenn der Benutzer den Löschvorgang bestätigt hat, lösche den Schüler
                    if (deleteConfirmation.get() == ButtonType.OK) {
                        LehrerHandler.deleteLehrer(Integer.parseInt(lehrerId));

                    }

                });
            });
//_________________________________________________________________ Ende löchen

            Button closeButton = new Button("Schließen");
            closeButton.setTextFill(Color.WHITE);
            closeButton.setFont(Font.font("System", FontWeight.EXTRA_BOLD, 14));
            closeButton.setStyle("-fx-background-color: #FF5733;");
            closeButton.setOnAction(closeEvent -> {
                lehrerStage.close();
            });

            // Hinzufügen der Buttons zur Tabelle
            HBox buttonBox = new HBox(vertretung, editButton, deleteButton, closeButton);
            buttonBox.setSpacing(10);
            buttonBox.setPadding(new Insets(10));

            // Erstellen einer neuen Scene mit der Tabelle und den Buttons
            BorderPane root1 = new BorderPane();
            root1.setCenter(table);
            root1.setBottom(buttonBox);
            Scene lehrerScene = new Scene(root1, 1000, 400);
            // Setzen der HBox-Größe auf die Breite des Fensters
            buttonBox.prefWidthProperty().bind(primaryStage.widthProperty());

// Anpassen der Button-Größe
            vertretung.prefWidthProperty().bind(buttonBox.widthProperty().divide(4));
            editButton.prefWidthProperty().bind(buttonBox.widthProperty().divide(4));
            deleteButton.prefWidthProperty().bind(buttonBox.widthProperty().divide(4));
            closeButton.prefWidthProperty().bind(buttonBox.widthProperty().divide(4));

            lehrerButton.setPrefWidth(DEFAULT_WIDTH / 2);

            // Setzen der Scene für das Fenster und Anzeigen des Fensters
            lehrerStage.setScene(lehrerScene);
            lehrerStage.show();

        });

        // Create the right pane with the Lehrer button
        StackPane rightPane = new StackPane();
        rightPane.setStyle("-fx-background-color: lightblue;");
        rightPane.getChildren().add(lehrerButton);

        //root.setRight(lehrerButton);

        /*   // Set the scene and show the stage
        Scene scene = new Scene(root, DEFAULT_WIDTH, DEFAULT_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
         */
    }

    public Button getLehrerButton() {
        return lehrerButton;
    }

    public void setLehrerButton(Button lehrerButton) {
        this.lehrerButton = lehrerButton;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
