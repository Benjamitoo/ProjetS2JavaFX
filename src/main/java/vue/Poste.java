package vue;

import java.util.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author thoma
 */
public class Poste extends Stage {
    
    private modele.Poste poste;
    private modele.Atelier atelier;
    private ObservableList operations;
    private ObservableList machinesIn;
    private ObservableList machinesOut;
    private  ArrayList<Button> boutonsMachines;
    
    private Scene scene;
    private BorderPane root;
    
    
    private HBox affichage;
    private Label ajoutLab;
    private Label suppLab;
    
    
    private ComboBox supprimer;
    private ComboBox ajouter;
    
    private Button supp;

    private GridPane pad;
    
    void updateLinks(){
        for(int i = 0; i<this.boutonsMachines.size(); i++){
            modele.Atelier a = this.atelier;
            modele.Machine  machine = this.poste.getListeMachines().get(i);
            
            this.boutonsMachines.get(i).setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent t) {
                    Machine fen = new Machine(machine, a);
                }
            });
        }
        
    }
    
    HBox updatedAffichage(){
        HBox box = new HBox();
        ArrayList<modele.Machine> liste = this.poste.getListeMachines();
        this.boutonsMachines = new ArrayList<Button>();
        for(int i = 0; i<liste.size(); i++){
            this.boutonsMachines.add(new Button(liste.get(i).getRef()));
            box.getChildren().add(this.boutonsMachines.get(i));
        
        }
        updateLinks();
        return box;
    }
    

    

  

    
    public Poste(modele.Poste p, modele.Atelier atelier) {
        
        
        
        this.poste = p;
        this.atelier = atelier;
        this.machinesIn = (ObservableList) this.poste.getListeMachines();
        this.machinesOut = (ObservableList) this.atelier.getListeMachines();
        this.machinesOut.removeAll(this.machinesIn);
        
        
        
        
        this.affichage = updatedAffichage();
        this.ajoutLab = new Label("Ajouter : ");
        this.ajoutLab = new Label("Enlever : ");
        
        
        this.supprimer = new ComboBox(this.machinesIn);
        this.ajouter = new ComboBox(this.machinesOut);
        
        this.supp = new Button("Supprimer le poste");
        
        this.pad = new GridPane();
        this.pad.setAlignment(Pos.BOTTOM_CENTER);
        this.pad.setHgap(5.5);
        this.pad.setVgap(5.5);

        this.pad.add(this.ajoutLab, 0, 0);
        this.pad.add(this.ajouter, 1, 0);
        this.pad.add(this.suppLab, 0, 1);
        this.pad.add(this.supprimer, 1, 1);
        this.pad.add(this.supp, 0, 2);
        

        // Expression lambda pour construire un EventHandler<ActionEvent>
        this.supp.setOnAction(evt -> {
            this.atelier.getListePostes().remove(poste);
            this.close();
        });
        
        this.ajouter.setOnAction(evt -> {
            Object machine = this.ajouter.getSelectionModel().getSelectedItem();
            this.poste.getListeMachines().add((modele.Machine) machine);
            this.machinesIn.add(machine);
            this.machinesOut.remove(machine);
            this.affichage = updatedAffichage();
            
        });
        
        this.supprimer.setOnAction(evt -> {
            Object machine = this.supprimer.getSelectionModel().getSelectedItem();
            this.poste.getListeMachines().remove((modele.Machine) machine);
            this.machinesIn.remove(machine);
            this.machinesOut.remove(machine);
            this.affichage = updatedAffichage();
        });
        
        
        
        
        this.setTitle(this.poste.getRef());        
        this.root = new BorderPane(this.affichage);
        this.root.setBottom(pad);
        this.scene = new Scene(root);
        this.show();
    }
}
