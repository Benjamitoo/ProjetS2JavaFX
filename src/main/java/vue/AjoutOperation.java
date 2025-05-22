package vue;

import controleur.AjoutOperationControleur;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import modele.Equipement;
import modele.EquipementRepository;

public class AjoutOperation {

    private Stage stage;
    private TextField refField, desField, dureeField;
    private ComboBox<Equipement> equipementCombo;
    private Button creerButton, retourButton;

    public AjoutOperation(Stage primaryStage) {
        this.stage = primaryStage;
        buildUI();
    }

    private void buildUI() {
        stage.setTitle("Ajout d'une Opération");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(10);
        grid.setHgap(10);

        // Champs de saisie
        refField = new TextField();
        desField = new TextField();
        dureeField = new TextField();

        // ComboBox d'équipement
        equipementCombo = new ComboBox<>();
        equipementCombo.getItems().addAll(EquipementRepository.getEquipements());
        equipementCombo.setPromptText("Sélectionner un équipement");

        // Personnalisation de l'affichage dans la liste
        equipementCombo.setCellFactory(cb -> new ListCell<>() {
            @Override
            protected void updateItem(Equipement item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : item.getRef());
            }
        });
        equipementCombo.setButtonCell(new ListCell<>() {
            @Override
            protected void updateItem(Equipement item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : item.getRef());
            }
        });

        // Ajout des éléments à la grille
        grid.add(new Label("Entrer une référence :"), 0, 0);
        grid.add(refField, 1, 0);

        grid.add(new Label("Entrer une description :"), 0, 1);
        grid.add(desField, 1, 1);

        grid.add(new Label("Entrer une durée :"), 0, 2);
        grid.add(dureeField, 1, 2);

        grid.add(new Label("Choisir un équipement :"), 0, 3);
        grid.add(equipementCombo, 1, 3);

        // Bouton Créer
        creerButton = new Button("Créer");
        creerButton.setOnAction(e -> {
            try {
                new AjoutOperationControleur().creerOperation(
                    refField.getText(),
                    desField.getText(),
                    dureeField.getText(),
                    equipementCombo.getValue()
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
