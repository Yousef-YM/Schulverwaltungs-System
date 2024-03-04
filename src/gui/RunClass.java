/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

// in diese Klasse können wir den Projekt ohne Anmeldung ausführen
public class RunClass extends Application {
    private static final int DEFAULT_WIDTH = 1200;
    private static final int DEFAULT_HEIGHT = 600;
    @Override
    public void start(Stage primaryStage) throws Exception {
                    SchuelerFenster schuelerFenster = new SchuelerFenster();
                    LehrerFenster lehrerFenster = new LehrerFenster();
                    TopBottomBereich topBereich = new TopBottomBereich();
                    // Start SchuelerFenster
                    Stage schuelerStage = new Stage();
                    schuelerFenster.start(schuelerStage);                  
                    // Start LehrerFenster
                    Stage lehrerStage = new Stage();
                    lehrerFenster.start(lehrerStage);                    
                    // Start Top bereich
                    Stage topStage = new Stage();
                    topBereich.start(topStage);                   
                    // Richte das Layout ein.
                    BorderPane root = new BorderPane();
                    root.setLeft(schuelerFenster.getSchueleButton());
                    root.setRight(lehrerFenster.getLehrerButton());
                    root.setTop(topBereich.getTopPane());
                    root.setBottom(topBereich.getBottomPane());
                    
                    //Anpassen die Buttons Lehrer und Schueler
        primaryStage.widthProperty().addListener((obs, oldVal, newVal) -> {
        double width = 
  (double) newVal - root.getPadding().getLeft() - root.getPadding().getRight();
        schuelerFenster.getSchueleButton().setPrefWidth(width / 2);
        lehrerFenster.getLehrerButton().setPrefWidth(width / 2);
        });
                    
            Scene scene = new Scene(root, DEFAULT_WIDTH, DEFAULT_HEIGHT);
            primaryStage.setScene(scene);
            primaryStage.show();       
    }
    public static void main(String[] args) {
        launch(args);
    }
}

    /*
    In diese Klasse werden die Anderern Run machen durch die objekte, die ich 
    von die selbe klassen erstellt habe (get methode)
    die Größe der Fenster ist die Größe die Buttons.
    */
