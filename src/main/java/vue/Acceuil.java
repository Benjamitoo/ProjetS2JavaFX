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
public class Acceuil extends Stage {
    
    
    private modele.Atelier atelier;
    
    
    private Scene scene;
    private BorderPane root;
    
    
    private Label affichage;
    
    private Button machines;
    private Button gammes;
    private Button operations;
    private Button postes;
    

    private VBox pad;
    

    

  

    
    public Acceuil(modele.Atelier atelier) {
        
        this.atelier = atelier;
        
        this.affichage = new Label("Que voulez vous travailler");
        
        
        
        this.pad = new VBox();
        this.pad.setAlignment(Pos.BOTTOM_CENTER);
        

        // Place nodes in the pane_saisiedesinfo at positions column,row
        this.pad.getChildren().add(this.machines);
        this.pad.getChildren().add(this.postes);
        this.pad.getChildren().add(this.operations);
        this.pad.getChildren().add(this.gammes);
        
        

        
        
        
        
        
        
        
        
        this.setTitle(this.atelier.getNom());        
        this.root = new BorderPane(this.affichage);
        this.root.setBottom(pad);
        this.scene = new Scene(root);
        this.show();
    }
}
