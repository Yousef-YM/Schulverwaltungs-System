/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javase.ss.classes.AGs;
import javase.ss.classes.Lehrer;
import javase.ss.classes.Schueler;
import javase.ss.handler.AGsHandler;
import javase.ss.handler.LehrerHandler;
import javase.ss.handler.SchuelerHandler;

/**
 *
 * @author CC-Student
 */
public class TopBottomBereich extends Application {

    private StackPane topPane;
    private HBox bottomPane;

    public StackPane getTopPane() {
        return topPane;
    }

    public void setTopPane(StackPane topPane) {
        this.topPane = topPane;
    }

    public HBox getBottomPane() {
        return bottomPane;
    }

    public void setBottomPane(HBox bottomPane) {
        this.bottomPane = bottomPane;
    }

    //_________________________________________________________
    @Override

    public void start(Stage primaryStage) throws Exception {

        topPane = new StackPane();
        topPane.setStyle("-fx-background-color: lightgreen");

        HBox dateTimeBox = new HBox();
        dateTimeBox.setSpacing(10);

        Label dateLabel = new Label();
        dateLabel.setStyle("-fx-font-size: 17px; -fx-text-fill: black;");
        Label timeLabel = new Label();
        timeLabel.setStyle("-fx-font-size: 17px; -fx-text-fill: black;");
        Label dayLabel = new Label();
        dayLabel.setStyle("-fx-font: 19px 'Calibri'");

        dateTimeBox.getChildren().addAll(dayLabel, dateLabel, timeLabel);
        topPane.getChildren().add(dateTimeBox);

// Aktualisierungsfunktion für das Datum- und Uhrzeit-Label
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                LocalDate currentDate = LocalDate.now();
                String day = currentDate.getDayOfWeek().
                        getDisplayName(TextStyle.FULL, Locale.getDefault());

                LocalDateTime currentDateTime = LocalDateTime.now();
                String date = currentDateTime.format
                            (DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                String time = currentDateTime.format
                            (DateTimeFormatter.ofPattern("HH:mm:ss"));

                dayLabel.setText(day.toLowerCase());
                dateLabel.setText(date.toLowerCase());
                timeLabel.setText(time.toLowerCase());
            }
        };
        timer.start();

        
        // Add the panes and bottomPane buttons to the root pane
        //______________________________________________
        // BottomTeil
        bottomPane = new HBox();
        bottomPane.setPadding(new Insets(0));
        bottomPane.setSpacing(0);
        bottomPane.setStyle("-fx-background-color: ");
        bottomPane.setPrefHeight(70);

        Button addSchueler = new Button("Schüler hinzufügen");
        addSchueler.setPrefSize(1500, 75);
        addSchueler.setFont(Font.font("System", FontWeight.EXTRA_BOLD, 15));
        addSchueler.setStyle("-fx-background-color: #6495ED; "
                + "-fx-border-color: lightgreen; "
                + "-fx-border-width:  9 0 0 0; "
                + "-fx-text-fill: black; "
                + "-fx-font-weight: bold;");

        addSchueler.setOnMouseEntered(e -> {
            addSchueler.setStyle("-fx-background-color: #87CEEB; "
                    + "-fx-border-color: lightgreen; "
                    + "-fx-border-width: 9 0 0 0; "
                    + "-fx-text-fill: black; "
                    + "-fx-font-weight: bold;"
                    + "-fx-font-size: 20;");
        });

        addSchueler.setOnMouseExited(e -> {//#87CEEB
            addSchueler.setStyle("-fx-background-color: #6495ED; "
                    + "-fx-border-color: lightgreen; "
                    + "-fx-border-width: 9 0 0 0; "
                    + "-fx-text-fill: black; "
                    + "-fx-font-weight: bold;"
                    + "-fx-font-size: 15;");
        });

        Button addLehrer = new Button("Lehrer hinzufügen");
        addLehrer.setPrefSize(1500, 75);
        addLehrer.setFont(Font.font("System", FontWeight.EXTRA_BOLD, 15));
        addLehrer.setStyle("-fx-background-color: #F0E68C; "
                + "-fx-border-color: lightgreen; "
                + "-fx-border-width:  9 0 0 0; "
                + "-fx-text-fill: black; "
                + "-fx-font-weight: bold;");

        addLehrer.setOnMouseEntered(e -> {
            addLehrer.setStyle("-fx-background-color: #FFFACD; "
                    + "-fx-border-color: lightgreen; "
                    + "-fx-border-width: 9 0 0 0; "
                    + "-fx-text-fill: black; "
                    + "-fx-font-weight: bold;"
                    + "-fx-font-size: 20;");
        });

        addLehrer.setOnMouseExited(e -> {//#87CEEB
            addLehrer.setStyle("-fx-background-color: #F0E68C; "
                    + "-fx-border-color: lightgreen; "
                    + "-fx-border-width: 9 0 0 0; "
                    + "-fx-text-fill: black; "
                    + "-fx-font-weight: bold;"
                    + "-fx-font-size: 15;");
        });

        addSchueler.setOnAction(e -> {

            createSchuelerDialog();

        });

        addLehrer.setOnAction(e -> {

            createLehrerDialog();

        });

        Button ag = new Button("AGs Liste");
        ag.setPrefSize(1500, 75);
        ag.setFont(Font.font(15));
        ag.setStyle("-fx-background-color: lightgreen; "
                + "-fx-text-fill: black; -fx-font-weight: bold;");

        ag.setOnMouseEntered(e -> {
            ag.setStyle("-fx-background-color: lightgreen; "
                    + "-fx-text-fill: black; "
                    + "-fx-font-weight: bold;"
                    + "-fx-font-size: 20;");
        });

        ag.setOnMouseExited(e -> {
            ag.setStyle("-fx-background-color: lightgreen; "
                    + "-fx-text-fill: black; "
                    + "-fx-font-weight: bold;"
                    + "-fx-font-size: 15;");
        });

        ag.setOnAction(e -> {
            // Erstellen eines neuen Fensters
            Stage agStage = new Stage();
            agStage.setTitle("AG Fenster");

            // Erstellen der Tabelle
            TableView<AGs> agTable = new TableView<>();

            // Erstellen der Spalten
            TableColumn<AGs, Integer> agIdCol = new TableColumn<>("AG ID");
            agIdCol.setCellValueFactory(new PropertyValueFactory<>("agId"));

            TableColumn<AGs, String> agNameCol = new TableColumn<>("AG Name");
            agNameCol.setCellValueFactory(new PropertyValueFactory<>("agName"));

            TableColumn<AGs, String> agTagCol = new TableColumn<>("Tag");
            agTagCol.setCellValueFactory(new PropertyValueFactory<>("agTag"));

            TableColumn<AGs, String> uhrzeitCol = new TableColumn<>("Uhrzeit");
            uhrzeitCol.setCellValueFactory
                            (new PropertyValueFactory<>("uhrzeit"));

            TableColumn<AGs, String> raumCol = new TableColumn<>("Raum");
            raumCol.setCellValueFactory(new PropertyValueFactory<>("raum"));

            TableColumn<AGs, Integer> lehrerIdCol 
                            = new TableColumn<>("Lehrer ID");
            lehrerIdCol.setCellValueFactory
                            (new PropertyValueFactory<>("lehrerId"));

            TableColumn<AGs, String> lehrerVornameCol 
                            = new TableColumn<>("Lehrer Vorname");
            lehrerVornameCol.setCellValueFactory
                            (new PropertyValueFactory<>("lehrerVorname"));

            TableColumn<AGs, String> lehrerNachnameCol 
                            = new TableColumn<>("Lehrer Nachname");
            lehrerNachnameCol.setCellValueFactory
                            (new PropertyValueFactory<>("lehrerNachname"));

            TableColumn<AGs, Integer> schuelerIdCol 
                            = new TableColumn<>("Schueler ID");
            schuelerIdCol.setCellValueFactory
                            (new PropertyValueFactory<>("schuelerId"));

            TableColumn<AGs, String> schuelerVornameCol 
                            = new TableColumn<>("Schueler Vorname");
            schuelerVornameCol.setCellValueFactory
                            (new PropertyValueFactory<>("schuelerVorname"));

            TableColumn<AGs, String> schuelerNachnameCol 
                            = new TableColumn<>("Schueler Nachname");
            schuelerNachnameCol.setCellValueFactory
                            (new PropertyValueFactory<>("schuelerNachname"));

            // Hinzufügen der Spalten zur Tabelle
            agTable.getColumns().addAll(agIdCol, agNameCol, agTagCol, 
                    uhrzeitCol, raumCol, lehrerIdCol, lehrerVornameCol, 
                    lehrerNachnameCol, schuelerIdCol,
                    schuelerVornameCol, schuelerNachnameCol);

            // Hinzufügen der Daten zur Tabelle
            ObservableList<AGs> ags = FXCollections.observableArrayList();
            AGsHandler agHandler = new AGsHandler();
            ags.addAll(agHandler.getAllAgs());
            agTable.setItems(ags);

            // Erstellen des Layouts
            BorderPane layout = new BorderPane();
            layout.setCenter(agTable);

            // Anzeigen des Fensters
            Scene scene = new Scene(layout, 1000, 400);
            scene.getStylesheets().add("style.css");
            agStage.setScene(scene);
            agStage.show();

        });

        bottomPane.getChildren().addAll(addSchueler, ag, addLehrer);
        
        
        
        //________________________________________________________________________

    }

    public void createSchuelerDialog() {
        // Erstellen des Dialogfensters
        Dialog<Schueler> dialog = new Dialog<>();
        dialog.setTitle("Neuen Schüler hinzufügen");

        // Erstellen der Eingabefelder
        TextField vornameTextField = new TextField();
        TextField nachnameTextField = new TextField();
        TextField geburtstagTextField = new TextField();
        TextField geschlechtTextField = new TextField();
        TextField vaterNameTextField = new TextField();
        TextField mutterNameTextField = new TextField();
        TextField adresseTextField = new TextField();
        TextField phoneTextField = new TextField();
        TextField mailTextField = new TextField();

        // ...
        // Hinzufügen der Eingabefelder zum Dialog
        GridPane grid = new GridPane();
        grid.add(new Label("Vorname:"), 0, 0);
        grid.add(vornameTextField, 1, 0);
        grid.add(new Label("Nachname:"), 0, 1);
        grid.add(nachnameTextField, 1, 1);
        grid.add(new Label("Geburtstag:"), 0, 2);
        grid.add(geburtstagTextField, 1, 2);
        grid.add(new Label("Geschlecht:"), 0, 3);
        grid.add(geschlechtTextField, 1, 3);
        grid.add(new Label("Vatername:"), 0, 4);
        grid.add(vaterNameTextField, 1, 4);
        grid.add(new Label("Muttername:"), 0, 5);
        grid.add(mutterNameTextField, 1, 5);
        grid.add(new Label("Adresse:"), 0, 6);
        grid.add(adresseTextField, 1, 6);
        grid.add(new Label("Phone:"), 0, 7);
        grid.add(phoneTextField, 1, 7);
        grid.add(new Label("E-Mail:"), 0, 8);
        grid.add(mailTextField, 1, 8);
        // ...
        dialog.getDialogPane().setContent(grid);

        // Erstellen der Buttons
        ButtonType addButton = new ButtonType("Hinzufügen", ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(addButton, ButtonType.CANCEL);

        // Festlegen der Aktionen für die Buttons
        dialog.setResultConverter(button -> {
            if (button == addButton) {
                // Erstellen eines neuen Schülers mit den eingegebenen Daten
                String vorname = vornameTextField.getText();
                String nachname = nachnameTextField.getText();
                String geburtstag = geburtstagTextField.getText();
                String geschlecht = geschlechtTextField.getText();
                String vatername = vaterNameTextField.getText();
                String muttername = mutterNameTextField.getText();
                String adresse = adresseTextField.getText();
                String phone = phoneTextField.getText();
                String mail = mailTextField.getText();

                Schueler schueler = new Schueler(vorname, nachname, geburtstag,
                        geschlecht, vatername, muttername, adresse, phone, mail);
                // Aufrufen der insertSchueler-Methode im SchuelerHandler, um den Schüler in die Datenbank einzufügen
                SchuelerHandler handler = new SchuelerHandler();
                handler.insertSchueler(schueler);
                //return schueler;
            }
            return null;
        });

        // Öffnen des Dialogfensters
        dialog.showAndWait();

    }

    public void createLehrerDialog() {
        // Erstellen des Dialogfensters
        Dialog<Lehrer> dialog = new Dialog<>();
        dialog.setTitle("Neuen Lehrer hinzufügen");

        // Erstellen der Eingabefelder
        TextField vornameTextField = new TextField();
        TextField nachnameTextField = new TextField();
        TextField adresseTextField = new TextField();
        TextField phoneTextField = new TextField();
        TextField mailTextField = new TextField();
        TextField rolleField = new TextField();

        // ...
        // Hinzufügen der Eingabefelder zum Dialog
        GridPane grid = new GridPane();
        grid.add(new Label("Vorname:"), 0, 0);
        grid.add(vornameTextField, 1, 0);
        grid.add(new Label("Nachname:"), 0, 1);
        grid.add(nachnameTextField, 1, 1);
        grid.add(new Label("Geburtstag:"), 0, 2);
        grid.add(adresseTextField, 1, 2);
        grid.add(new Label("Geschlecht:"), 0, 3);
        grid.add(phoneTextField, 1, 3);
        grid.add(new Label("Vatername:"), 0, 4);
        grid.add(mailTextField, 1, 4);
        grid.add(new Label("Muttername:"), 0, 5);
        grid.add(rolleField, 1, 5);

        // ...
        dialog.getDialogPane().setContent(grid);

        // Erstellen der Buttons
        ButtonType addButton = new ButtonType("Hinzufügen", ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(addButton, ButtonType.CANCEL);

        // Festlegen der Aktionen für die Buttons
        dialog.setResultConverter(button -> {
            if (button == addButton) {
                // Erstellen eines neuen Schülers mit den eingegebenen Daten
                String vorname = vornameTextField.getText();
                String nachname = nachnameTextField.getText();
                String adresse = adresseTextField.getText();
                String phone = phoneTextField.getText();
                String mail = mailTextField.getText();
                String rolle = rolleField.getText();

                Lehrer lehrer = new Lehrer(vorname, nachname, adresse, phone, mail, rolle);
                // Aufrufen der insertSchueler-Methode im SchuelerHandler, um den Schüler in die Datenbank einzufügen
                LehrerHandler lehrerH = new LehrerHandler();
                lehrerH.insertLehrer(lehrer);
                //return schueler;
            }
            return null;
        });

        // Öffnen des Dialogfensters
        dialog.showAndWait();
    }

}
