package vue;

import controleur.AjoutMachineControleur;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AjoutMachine {

    private Stage stage;
    private TextField idField, refField, desField, typeField, coutField, xField, yField;
    private Button evenementButton, creerButton, retourButton;

    public AjoutMachine(Stage primaryStage) {
        this.stage = primaryStage;
        buildUI();
    }

    private void buildUI() {
        stage.setTitle("Ajout d'une Machine");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(10);
        grid.setHgap(10);

        // Création des champs
        idField = new TextField();
        refField = new TextField();
        desField = new TextField();
        typeField = new TextField();
        coutField = new TextField();
        xField = new TextField();
        yField = new TextField();

        // Ajout des éléments à la grille
        grid.add(new Label("Entrer un id :"), 0, 0);
        grid.add(idField, 1, 0);

        grid.add(new Label("Entrer un ref :"), 0, 1);
        grid.add(refField, 1, 1);

        grid.add(new Label("Entrer une description :"), 0, 2);
        grid.add(desField, 1, 2);

        grid.add(new Label("Entrer un type :"), 0, 3);
        grid.add(typeField, 1, 3);

        grid.add(new Label("Entrer un coût :"), 0, 4);
        grid.add(coutField, 1, 4);

        grid.add(new Label("Entrer x :"), 0, 5);
        grid.add(xField, 1, 5);

        grid.add(new Label("Entrer y :"), 0, 6);
        grid.add(yField, 1, 6);

        // Bouton pour la liste des événements
        evenementButton = new Button("Détails de la liste d’événements");
        evenementButton.setOnAction(e -> {
            // Appel de la classe VueEvenement (à implémenter séparément)
            System.out.println("Ouverture de la fenêtre VueEvenement...");
        });
        grid.add(evenementButton, 1, 7);

        // Bouton Créer
        creerButton = new Button("Créer");
        creerButton.setOnAction(e -> {
    try {
        new AjoutMachineControleur().creerMachine(
            idField.getText(),
            refField.getText(),
            desField.getText(),
            typeField.getText(),
            coutField.getText(),
            xField.getText(),
            yField.getText()
        );

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Succès");
        alert.setHeaderText(null);
        alert.setContentText("Machine créée avec succès !");
        alert.showAndWait();

    } catch (Exception ex) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText("Échec de création");
        alert.setContentText("La machine n’a pas pu être créée.\nDétail : " + ex.getMessage());
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
