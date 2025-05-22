package vue;

import controleur.AjoutAtelierControleur;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import modele.ChefAtelier;
import modele.ChefAtelierRepository;

public class AjoutAtelier {

    private Stage stage;
    private TextField nomField, equipementsField, produitsField, operationField;
    private ComboBox<ChefAtelier> chefAtelierCombo;
    private Button creerButton, retourButton;

    public AjoutAtelier(Stage primaryStage) {
        this.stage = primaryStage;
        buildUI();
    }

    private void buildUI() {
        stage.setTitle("Création d'un Atelier");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(10);
        grid.setHgap(10);

        // Champs de saisie
        nomField = new TextField();

        // ComboBox d'équipement
        chefAtelierCombo = new ComboBox<>();
        chefAtelierCombo.getItems().addAll(ChefAtelierRepository.getChefAtelier());
        chefAtelierCombo.setPromptText("Sélectionner un équipement");

        // Personnalisation de l'affichage dans la liste
        chefAtelierCombo.setCellFactory(cb -> new ListCell<>() {
            @Override
            protected void updateItem(ChefAtelier item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : item.getId());
            }
        });
        chefAtelierCombo.setButtonCell(new ListCell<>() {
            @Override
            protected void updateItem(ChefAtelier item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : item.getId());
            }
        });

        // Ajout des éléments à la grille
        grid.add(new Label("Entrer un nom :"), 0, 0);
        grid.add(nomField, 1, 0);

        grid.add(new Label("Chef d'Atelier :"), 0, 1);
        grid.add(chefAtelierCombo, 1, 1);
        
        // Bouton Équipements
        grid.add(new Label("Equipements :"), 0, 2);
        Button equipementsButton = new Button("Détails");
        equipementsButton.setOnAction(e -> new VueEquipement());
        grid.add(equipementsButton, 1, 2);

        // Bouton Produits
        grid.add(new Label("Produits :"), 0, 3);
        Button produitsButton = new Button("Détails");
        produitsButton.setOnAction(e -> new VueProduit());
        grid.add(produitsButton, 1, 3);

        // Bouton Opérations
        grid.add(new Label("Opérations :"), 0, 4);
        Button operationsButton = new Button("Détails");
        operationsButton.setOnAction(e -> new VueOperation());
        grid.add(operationsButton, 1, 4);

        // Bouton Créer
        creerButton = new Button("Créer");
        creerButton.setOnAction(e -> {
            try {
                new AjoutAtelierControleur().creerAtelier(
                    nomField.getText(),
                    chefAtelierCombo.getValue()
                );

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Succès");
                alert.setHeaderText(null);
                alert.setContentText("Opération créée avec succès !");
                alert.showAndWait();

            } catch (Exception ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText("Échec de création");
                alert.setContentText("L'opération n’a pas pu être créée.\nDétail : " + ex.getMessage());
                alert.showAndWait();
            }
        });

        // Bouton Retour
        retourButton = new Button("Retour à l'accueil");
        retourButton.setOnAction(e -> {
            System.out.println("Retour à l'accueil.");
        });

        // Positionnement des boutons
        grid.add(creerButton, 0, 5);
        grid.add(retourButton, 1, 5);

        Scene scene = new Scene(grid, 500, 350);
        stage.setScene(scene);
        stage.show();
    }
}
