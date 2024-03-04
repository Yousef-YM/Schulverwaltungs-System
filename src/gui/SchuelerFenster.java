/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javase.ss.classes.Anwesenheit;
import javase.ss.classes.AusgelieheneBuecher;
import javase.ss.classes.Schueler;
import javase.ss.handler.AnwesenheitsHandler;
import javase.ss.handler.NotenHandler;
import javase.ss.handler.SchuelerHandler;
import javase.ss.classes.Note;
import javase.ss.handler.AusgeleihenenBuecherHandler;

/**
 *
 * @author CC-Student
 */
public class SchuelerFenster extends Application {

    private static final int DEFAULT_WIDTH = 1200;
    private SchuelerHandler schuelerHandler;
    private Button schueleButton;
    private AnwesenheitsHandler anwesenH;

    List<Schueler> schuelerListe = new ArrayList<>();
    TableView<Schueler> schuelerTableView = new TableView<>();
    List<Anwesenheit> anwesenheitsliste = new ArrayList<>();

    public Button getSchueleButton() {
        return schueleButton;
    }

    public void setSchueleButton(Button schueleButton) {
        this.schueleButton = schueleButton;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        schuelerHandler = new SchuelerHandler();

        schueleButton = new Button("Schüler");

        schueleButton.setMaxWidth(Double.MAX_VALUE);
        schueleButton.setMaxHeight(Double.MAX_VALUE);
        //schueleButton.setFont(Font.font("System", FontWeight.EXTRA_BOLD, 35));
        schueleButton.setFont(Font.font("System", FontWeight.EXTRA_BOLD, 35));
        schueleButton.setStyle("-fx-background-color: #6495ED;");

        schueleButton.setOnMouseEntered(e -> {
            schueleButton.setStyle("-fx-background-color: #87CEEB; "
                    + "-fx-border-color: lightgreen; "
                    + "-fx-border-width: 9 0 0 0; "
                    + "-fx-text-fill: black; "
                    + "-fx-font-weight: bold;");
            schueleButton.setFont(Font.font("System", FontWeight.EXTRA_BOLD, 45));
        });

        schueleButton.setOnMouseExited(e -> {
            schueleButton.setStyle("-fx-background-color: #6495ED;");
            schueleButton.setFont(Font.font("System", FontWeight.BOLD, 35));
        });

        // handle Schüler button click
        schueleButton.setOnAction(e -> {

            // Erstellen eines neuen Fensters
            Stage schuelerStage = new Stage();
            schuelerStage.setTitle("Schüler Fenster");

            // Erstellen der Tabelle
            TableView<Schueler> table = new TableView<>();
            // Erstellen der Spalten
            TableColumn<Schueler, Integer> idCol
                    = new TableColumn<>("Schueler ID");
            idCol.setCellValueFactory(new PropertyValueFactory<>("schuelerId"));

            TableColumn<Schueler, String> vornameCol
                    = new TableColumn<>("Vorname");
            vornameCol.setCellValueFactory(new PropertyValueFactory<>("vorname"));

            TableColumn<Schueler, String> nachnameCol
                    = new TableColumn<>("Nachname");
            nachnameCol.setCellValueFactory(new PropertyValueFactory<>("nachname"));

            TableColumn<Schueler, String> geburtstagCol
                    = new TableColumn<>("Geburtstag");
            geburtstagCol.setCellValueFactory(new PropertyValueFactory<>("geburtstag"));

            TableColumn<Schueler, String> geschlechtCol
                    = new TableColumn<>("Geschlecht");
            geschlechtCol.setCellValueFactory(new PropertyValueFactory<>("geschlecht"));

            TableColumn<Schueler, String> vaternameCol
                    = new TableColumn<>("Vatername");
            vaternameCol.setCellValueFactory(new PropertyValueFactory<>("vaterName"));

            TableColumn<Schueler, String> mutternameCol
                    = new TableColumn<>("Muttername");
            mutternameCol.setCellValueFactory(new PropertyValueFactory<>("mutterName"));

            TableColumn<Schueler, String> adresseCol
                    = new TableColumn<>("Adresse");
            adresseCol.setCellValueFactory(new PropertyValueFactory<>("adresse"));

            TableColumn<Schueler, String> phoneCol
                    = new TableColumn<>("Telefon");
            phoneCol.setCellValueFactory(new PropertyValueFactory<>("telefon"));

            TableColumn<Schueler, String> mailCol
                    = new TableColumn<>("E-Mail");
            mailCol.setCellValueFactory(new PropertyValueFactory<>("mail"));

            TableColumn<Schueler, String> lehrerIdCol
                    = new TableColumn<>("Lehrer ID");
            lehrerIdCol.setCellValueFactory(new PropertyValueFactory<>("lehrerId"));

            // Hinzufügen der Spalten zur Tabelle
            table.getColumns().addAll(idCol, vornameCol, nachnameCol, geburtstagCol,
                    geschlechtCol, vaternameCol, mutternameCol, adresseCol, phoneCol,
                    mailCol, lehrerIdCol);

//AnwesenheitsHandler schueler = new AnwesenheitsHandler();
// _______________________________________________________________ Anwesenheit
            Button anwesenheitButton = new Button("Anwesenheit");
            anwesenheitButton.setFont(Font.font("System", FontWeight.EXTRA_BOLD, 14));
            anwesenheitButton.setStyle("-fx-background-color: #6495ED;");

            // Setzen der Aktionen für die Buttons
            anwesenheitButton.setOnAction(addEvent -> {
                TextInputDialog dialog = new TextInputDialog("");
                dialog.setTitle("Anwesenheitsinformationen anzeigen");
                dialog.setHeaderText("Bitte geben Sie die Schüler-ID ein:");
                dialog.setContentText("ID:");

                Optional<String> result = dialog.showAndWait();
                if (result.isPresent()) {
                    int schuelerId = Integer.parseInt(result.get());
                    AnwesenheitsHandler anwesenheitsHandler = new AnwesenheitsHandler();
                    Anwesenheit anwesenheitsInfos
                            = anwesenheitsHandler.getAnwesenheitsInfoById(schuelerId);

                    TableView<Anwesenheit> tableA = new TableView<>();
                    TableColumn<Anwesenheit, Integer> idColumn = new TableColumn<>("ID");
                    idColumn.setCellValueFactory(new PropertyValueFactory<>("anwesenheitId"));
                    TableColumn<Anwesenheit, String> datumColumn = new TableColumn<>("Datum");
                    datumColumn.setCellValueFactory(new PropertyValueFactory<>("fehltagDatum"));
                    TableColumn<Anwesenheit, String> tagColumn = new TableColumn<>("Tag");
                    tagColumn.setCellValueFactory(new PropertyValueFactory<>("fehltagTag"));
                    TableColumn<Anwesenheit, String> grundColumn = new TableColumn<>("Grund");
                    grundColumn.setCellValueFactory(new PropertyValueFactory<>("grund"));
                    TableColumn<Anwesenheit, String> entschuldigtColumn
                            = new TableColumn<>("Entschuldigt");
                    entschuldigtColumn.setCellValueFactory(new PropertyValueFactory<>("entschuldigt"));

                    tableA.getColumns().addAll(idColumn, datumColumn, tagColumn,
                            grundColumn, entschuldigtColumn);
                    tableA.getItems().addAll(anwesenheitsInfos);

                    Scene anwesenheitScene = new Scene(new BorderPane(tableA), 400, 500);
                    Stage stage = new Stage();
                    stage.setScene(anwesenheitScene);
                    stage.setTitle("Anwesenheitsinformationen für Schüler mit ID " + schuelerId);
                    stage.show();
                }

            });

//____________________________________________________________Ende Anwesenheit
//________________________________________________________________ bearbeitung
            Button editButton = new Button("Bearbeiten");
            editButton.setFont(Font.font("System", FontWeight.EXTRA_BOLD, 14));
            editButton.setStyle("-fx-background-color: #6495ED;");

            editButton.setOnAction(editEvent -> {

            });
//__________________________________________________________ Ende bearbeitung

//_________________________________________________________________ löchen 


            Button deleteButton = new Button("Löschen");
            deleteButton.setFont(Font.font("System",FontWeight.EXTRA_BOLD, 14));
            deleteButton.setStyle("-fx-background-color: #6495ED;");

            deleteButton.setOnAction(deleteEvent -> {

                TextInputDialog dialogL = new TextInputDialog();
                dialogL.setTitle("Schüler löschen");
                dialogL.setHeaderText("Schüler löschen");
                dialogL.setContentText
                ("Geben Sie die ID des Schülers ein, den Sie löschen möchten:");

                Optional<String> resultO = dialogL.showAndWait();

                resultO.ifPresent(schuelerId -> {
                    try {
                        int id = Integer.parseInt(schuelerId);
                        SchuelerHandler.deleteSchueler(id);

                Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
                        confirmation.setTitle("Schüler löschen");
                        confirmation.setHeaderText("Schüler löschen");
                        confirmation.setContentText
            ("Möchten Sie den Schüler mit der ID " + id + " wirklich löschen?");

                        Optional<ButtonType> deleteConfirmation 
                                = confirmation.showAndWait();

                        if (deleteConfirmation.get() == ButtonType.OK) {
                            SchuelerHandler.deleteSchueler(id);
                        }
                    } catch (NumberFormatException ex) {

                    }
                });

            });
            
            
            //__________________________________________________________ Ende löchen   

//_____________________________________________________________________ Noten



            Button notenButton = new Button("Noten");
            notenButton.setFont(Font.font("System", FontWeight.EXTRA_BOLD, 14));
            notenButton.setStyle("-fx-background-color: #6495ED;");

    notenButton.setOnAction(notenEvent -> {
    TextInputDialog dialog = new TextInputDialog("");
    dialog.setTitle("die Noten Anzeigen");
    dialog.setHeaderText("Bitte geben Sie die Schüler-ID ein:");
    dialog.setContentText("ID:");
    Optional<String> result = dialog.showAndWait();
    if (result.isPresent()) {
    int schuelerId = Integer.parseInt(result.get());
    NotenHandler notenH = new NotenHandler();
    Note note = null;
    try {
    note = notenH.getNotenInfoById(schuelerId);
    } catch (SQLException ex) {
    Logger.getLogger(SchuelerFenster.class.getName()).log(Level.SEVERE, null, ex);
    }
    TableView<Note> tableN = new TableView<>();
    TableColumn<Note, String> sVornameCol = new TableColumn<>("Vorname");
 sVornameCol.setCellValueFactory(new PropertyValueFactory<>("schuelerVorname"));
    TableColumn<Note, String> sNachnameCol = new TableColumn<>("Nachname");
 sNachnameCol.setCellValueFactory(new PropertyValueFactory<>("schuelerNachname"));
    TableColumn<Note, String> lVornameCol = new TableColumn<>("Lehrer Vorname");
  lVornameCol.setCellValueFactory(new PropertyValueFactory<>("lehrerVorname"));
  TableColumn<Note, String> lNachnameCol = new TableColumn<>("Lehrer Nachname");
 lNachnameCol.setCellValueFactory(new PropertyValueFactory<>("lehrerNachname"));
    TableColumn<Note, String> fachCol = new TableColumn<>("Fach");
    fachCol.setCellValueFactory(new PropertyValueFactory<>("fachNote"));
    TableColumn<Note, String> testDatumCol = new TableColumn<>("Test Datum");
    testDatumCol.setCellValueFactory(new PropertyValueFactory<>("testDatum"));
    TableColumn<Note, String> noteCol = new TableColumn<>("ENote");
    noteCol.setCellValueFactory(new PropertyValueFactory<>("noteNote"));

    tableN.getColumns().addAll(sVornameCol, sNachnameCol, lVornameCol, 
            lNachnameCol, fachCol,testDatumCol, noteCol);
            tableN.getItems().addAll(note);

            Scene noteScene = new Scene(new BorderPane(tableN), 700, 500);
            Stage stage = new Stage();
            stage.setScene(noteScene);
            stage.setTitle("Noten für Schüler mit ID " + schuelerId);
            stage.show();
                }
            });
            
            
//_________________________________________________________________ Ende Note            

//_________________________________________________________________ Ausleihien


            Button ausleiheButton = new Button("Ausgeleihenen Bücher");
            ausleiheButton.setFont(Font.font("-fx-text-fill: white;", 
                    FontWeight.EXTRA_BOLD, 14));
            ausleiheButton.setStyle("-fx-background-color: #6495ED;");

            ausleiheButton.setOnAction(ausleiheEvent -> {

                TextInputDialog dialog = new TextInputDialog("");
                dialog.setTitle("Ausgeleihenen Bücher anzeigen");
                dialog.setHeaderText("Bitte geben Sie die Schüler-ID ein:");
                dialog.setContentText("ID:");

                Optional<String> result = dialog.showAndWait();
                if (result.isPresent()) {
                    int schuelerId = Integer.parseInt(result.get());
                    AusgeleihenenBuecherHandler ausleiheH 
                            = new AusgeleihenenBuecherHandler();
                    AusgelieheneBuecher ausleih 
                          = ausleiheH.getAllAusgelienenBuecherById(schuelerId);

                    TableView<AusgelieheneBuecher> tableB 
                            = new TableView<>();
                    TableColumn<AusgelieheneBuecher, Integer> idColumnB 
                            = new TableColumn<>("ID");
                    idColumnB.setCellValueFactory
                            (new PropertyValueFactory<>("ausleiId"));

                    TableColumn<AusgelieheneBuecher, String> titelColumnB 
                            = new TableColumn<>("Buch Titel");
                    titelColumnB.setCellValueFactory
                            (new PropertyValueFactory<>("titel"));

                    TableColumn<AusgelieheneBuecher, Integer> sIdColumnB 
                            = new TableColumn<>("Schüler ID");
                    sIdColumnB.setCellValueFactory
                            (new PropertyValueFactory<>("schueler_Id"));

                    TableColumn<AusgelieheneBuecher, String> sVColumnB 
                            = new TableColumn<>("Schüler Vorname");
                    sVColumnB.setCellValueFactory
                            (new PropertyValueFactory<>("schuelerVorname"));

                    TableColumn<AusgelieheneBuecher, String> sNColumnB 
                            = new TableColumn<>("Schüler Nachname");
                    sNColumnB.setCellValueFactory
                            (new PropertyValueFactory<>("schuelerNachname"));

                TableColumn<AusgelieheneBuecher, String> ausleiheDatumColumnB 
                            = new TableColumn<>("Ausleihe Datum");
                    ausleiheDatumColumnB.setCellValueFactory
                            (new PropertyValueFactory<>("ausleiDatum"));

                TableColumn<AusgelieheneBuecher, String> rueckgabeDatumColumnB 
                            = new TableColumn<>("Rückgabe Datum");
                    rueckgabeDatumColumnB.setCellValueFactory
                            (new PropertyValueFactory<>("rueckgabeDatum"));

                    TableColumn<AusgelieheneBuecher, String> statusColumnB 
                            = new TableColumn<>("Status");
                    statusColumnB.setCellValueFactory
                            (new PropertyValueFactory<>("status"));

    tableB.getColumns().addAll(idColumnB, titelColumnB, sIdColumnB, sVColumnB, 
    sNColumnB, ausleiheDatumColumnB, rueckgabeDatumColumnB, statusColumnB);
                    tableB.getItems().addAll(ausleih);

    Scene ausleihenScene = new Scene(new BorderPane(tableB), 800, 500);
    Stage stage = new Stage();
    stage.setScene(ausleihenScene);
    stage.setTitle("Ausgeliehenen Bücher für Schüler mit ID " + schuelerId);
    stage.show();
    
                }

            });

//_____________________________________________________________ Ende Ausleihen
//_________________________________________________________________ close


            Button closeButton = new Button("Schließen");
            closeButton.setTextFill(Color.WHITE);
            closeButton.setFont(Font.font("System", FontWeight.EXTRA_BOLD, 14));
            closeButton.setStyle("-fx-background-color: #FF5733;");
            closeButton.setOnAction(closeEvent -> {
                schuelerStage.close();
            });
            
            
//__________________________________________________________ Ende close

            // Hinzufügen der Buttons zur Tabelle
            HBox buttonBox = new HBox(anwesenheitButton, notenButton, ausleiheButton, editButton, deleteButton, closeButton);
            buttonBox.setSpacing(10);
            buttonBox.setPadding(new Insets(10));
            // Setzen der HBox-Größe auf die Breite des Fensters
            buttonBox.prefWidthProperty().bind(primaryStage.widthProperty());
            // Anpassen der Button-Größe
            anwesenheitButton.prefWidthProperty().bind(buttonBox.widthProperty().divide(6));
            notenButton.prefWidthProperty().bind(buttonBox.widthProperty().divide(6));
            ausleiheButton.prefWidthProperty().bind(buttonBox.widthProperty().divide(6));
            editButton.prefWidthProperty().bind(buttonBox.widthProperty().divide(6));
            deleteButton.prefWidthProperty().bind(buttonBox.widthProperty().divide(6));
            closeButton.prefWidthProperty().bind(buttonBox.widthProperty().divide(6));

            // Laden der Schülerliste
            SchuelerHandler schuelerH = new SchuelerHandler();
            ArrayList<Schueler> schuelerList = schuelerH.getAllSchueler();

            // Hinzufügen der Schüler zur Tabelle
            table.getItems().addAll(schuelerList);

            // Erstellen einer neuen Scene mit der Tabelle und den Buttons
            BorderPane root1 = new BorderPane();
            root1.setCenter(table);
            root1.setBottom(buttonBox);
            Scene schuelerScene = new Scene(root1, 1000, 400);

            schueleButton.setPrefWidth(DEFAULT_WIDTH / 2);

            // Setzen der Scene für das Fenster und Anzeigen des Fensters
            schuelerStage.setScene(schuelerScene);
            schuelerStage.show();

        });

        // Create the left pane with the Schüler button
        StackPane leftPane = new StackPane();
        leftPane.setStyle("-fx-background-color: lightgreen;");
        leftPane.getChildren().add(schueleButton);

    }

    public static void main(String[] args) {
        launch(args);
    }

}
