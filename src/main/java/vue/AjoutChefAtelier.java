package vue;

import controleur.AjoutChefAtelierControleur;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AjoutChefAtelier {

    private Stage stage;
    private TextField idField, nField, pField;
    private Button evenementButton, creerButton, retourButton;

    public AjoutChefAtelier(Stage primaryStage) {
        this.stage = primaryStage;
        buildUI();
    }

    private void buildUI() {
        stage.setTitle("Ajout d'un Chef d'Atelier");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(10);
        grid.setHgap(10);

        // Création des champs
        idField = new TextField();
        nField = new TextField();
        pField = new TextField();

        // Ajout des éléments à la grille
        grid.add(new Label("Entrer un id :"), 0, 0);
        grid.add(idField, 1, 0);

        grid.add(new Label("Entrer un nom :"), 0, 1);
        grid.add(nField, 1, 1);

        grid.add(new Label("Entrer un prenom :"), 0, 2);
        grid.add(pField, 1, 2);

        
        

        // Bouton Créer
        creerButton = new Button("Créer");
        creerButton.setOnAction(e -> {
    try {
        new AjoutChefAtelierControleur().creerChefAtelier(
            idField.getText(),
            nField.getText(),
            pField.getText()
        );

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Succès");
        alert.setHeaderText(null);
        alert.setContentText("Chef d'atelier créé avec succès !");
        alert.showAndWait();

    } catch (Exception ex) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText("Échec de création");
        alert.setContentText("Le chef d'atelier n’a pas pu être créé.\nDétail : " + ex.getMessage());
        alert.showAndWait();
    }
});

        // Bouton Retour
        retourButton = new Button("Retour à l'accueil");
        retourButton.setOnAction(e -> {
            // Redirection vers Accueil (fenêtre à gérer selon ta classe Accueil)
            System.out.println("Retour à l'accueil.");
        });

        grid.add(creerButton, 0, 8);
        grid.add(retourButton, 1, 8);

        Scene scene = new Scene(grid, 500, 400);
        stage.setScene(scene);
        stage.show();
    }
}
