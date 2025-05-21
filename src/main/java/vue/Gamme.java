package vue;

import java.util.*;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author thoma
 */
public class Gamme extends Stage {
    
    private modele.Gamme gamme;
    private modele.Atelier atelier;
    private ObservableList operations;
    
    private Scene scene;
    private BorderPane root;
    
    
    private Label affichage;
    private Label ajoutPremLab;
    private Label ajoutDerLab;
    
    
    private ComboBox ajoutPrem;
    private ComboBox ajoutDer;
    
    
    private Button suppPrem;
    private Button suppDer;
    private Button supp;

    private GridPane pad;
    

    

  

    
    public Gamme(modele.Gamme g, modele.Atelier atelier) {
        
        
        
        this.gamme = g;
        this.atelier = atelier;
        this.operations = (ObservableList) this.atelier.getListeOperations();
        
        
        
        this.affichage = new Label(g.affiche());
        this.ajoutPremLab = new Label("Ajouter au début : ");
        this.ajoutDerLab = new Label("Ajouter à la fin : ");
        
        
        this.ajoutPrem = new ComboBox(this.operations);
        this.ajoutDer = new ComboBox(this.operations);
        this.suppPrem = new Button("Supprimer première");
        this.suppDer = new Button("Supprimer dernière");
        this.supp = new Button("Supprimer la gamme");
        
        this.pad = new GridPane();
        this.pad.setAlignment(Pos.BOTTOM_CENTER);
        this.pad.setHgap(5.5);
        this.pad.setVgap(5.5);

        // Place nodes in the pane_saisiedesinfo at positions column,row
        this.pad.add(this.suppPrem, 0, 0);
        this.pad.add(this.ajoutPremLab, 1, 0);
        this.pad.add(this.ajoutPrem, 2, 0);
        this.pad.add(this.suppDer, 0, 1);
        this.pad.add(this.ajoutDerLab, 1, 1);
        this.pad.add(this.ajoutDer, 2, 1);
        this.pad.add(this.supp, 0, 2);
        

        // Expression lambda pour construire un EventHandler<ActionEvent>
        this.supp.setOnAction(evt -> {
            this.atelier.getListeOperations().remove(gamme);
            this.close();
           
        });
        
        this.suppPrem.setOnAction(evt -> {
            this.gamme.getProtocole().removeFirst();
            this.affichage.setText(this.gamme.affiche());
            this.operations = (ObservableList) this.atelier.getListeOperations();
             
        });
        
        this.suppDer.setOnAction(evt -> {
            this.gamme.getProtocole().removeLast();
            this.affichage.setText(this.gamme.affiche());
            this.operations = (ObservableList) this.atelier.getListeOperations();
        });

        this.ajoutPrem.setOnAction(evt -> {
            this.gamme.getProtocole().addFirst((modele.Operation) this.ajoutPrem.getSelectionModel().getSelectedItem());
            this.affichage.setText(this.gamme.affiche());
            this.operations = (ObservableList) this.atelier.getListeOperations();
        });
        
        this.ajoutDer.setOnAction(evt -> {
            this.gamme.getProtocole().addLast((modele.Operation) this.ajoutPrem.getSelectionModel().getSelectedItem());
            this.affichage.setText(this.gamme.affiche());
            this.operations = (ObservableList) this.atelier.getListeOperations();
        });
        
        
        
        
        this.setTitle(this.gamme.getRef());        
        this.root = new BorderPane(this.affichage);
        this.root.setBottom(pad);
        this.scene = new Scene(root);
        this.show();
    }
}
