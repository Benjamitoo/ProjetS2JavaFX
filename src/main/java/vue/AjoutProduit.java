package vue;

import controleur.AjoutProduitControleur;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AjoutProduit {

    private Stage stage;
    private TextField idField, stockField;
    private Button evenementButton, creerButton, retourButton;

    public AjoutProduit(Stage primaryStage) {
        this.stage = primaryStage;
        buildUI();
    }

    private void buildUI() {
        stage.setTitle("Ajout d'un Produit");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(10);
        grid.setHgap(10);

        // Création des champs
        idField = new TextField();
        stockField = new TextField();

        // Ajout des éléments à la grille
        grid.add(new Label("Entrer un id :"), 0, 0);
        grid.add(idField, 1, 0);

        grid.add(new Label("Entrer un stock :"), 0, 1);
        grid.add(stockField, 1, 1);

        // Bouton Créer
        creerButton = new Button("Créer");
        creerButton.setOnAction(e -> {
    try {
        new AjoutProduitControleur().creerProduit(
            idField.getText(),
            stockField.getText()
        );

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Succès");
        alert.setHeaderText(null);
        alert.setContentText("Produit créé avec succès !");
        alert.showAndWait();

    } catch (Exception ex) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText("Échec de création");
        alert.setContentText("Le produit n’a pas pu être créée.\nDétail : " + ex.getMessage());
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
