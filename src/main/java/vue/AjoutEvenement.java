package vue;



import controleur.AjoutEvenementControleur;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import modele.Operateur;
import modele.OperateurRepository;

public class AjoutEvenement {

    private Stage stage;
    private TextField dateField, heureField, dureeField, causeField;
    private ComboBox<Operateur> operateurCombo;
    private Button evenementButton, creerButton, retourButton;

    public AjoutEvenement(Stage primaryStage) {
        this.stage = primaryStage;
        buildUI();
    }

    private void buildUI() {
        stage.setTitle("Ajout d'un Evenement");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(10);
        grid.setHgap(10);

        // Création des champs
        dateField = new TextField();
        heureField = new TextField();
        dureeField = new TextField();
        causeField = new TextField();
        
        // ComboBox d'équipement
        operateurCombo = new ComboBox<>();
        operateurCombo.getItems().addAll(OperateurRepository.getOperateurs());
        operateurCombo.setPromptText("Sélectionner un opérateur");

        // Personnalisation de l'affichage dans la liste
        operateurCombo.setCellFactory(cb -> new ListCell<>() {
            @Override
            protected void updateItem(Operateur item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : item.getId());
            }
        });
        operateurCombo.setButtonCell(new ListCell<>() {
            @Override
            protected void updateItem(Operateur item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : item.getId());
            }
        });

        // Ajout des éléments à la grille
        grid.add(new Label("Entrer une date (format YYYY-MM-DD :"), 0, 0);
        grid.add(dateField, 1, 0);

        grid.add(new Label("Entrer un heure (format HH:MM :"), 0, 1);
        grid.add(heureField, 1, 1);

        grid.add(new Label("Entrer une durée de panne (en minute) :"), 0, 2);
        grid.add(dureeField, 1, 2);

        grid.add(new Label("Entrer un cause :"), 0, 3);
        grid.add(causeField, 1, 3);
        
        grid.add(new Label("Opérateur :"), 0, 4);
        grid.add(operateurCombo, 1, 4);

        // Bouton Créer
        creerButton = new Button("Créer");
        creerButton.setOnAction(e -> {
    try {
        new AjoutEvenementControleur().creerEvenement(
            dateField.getText(),
            heureField.getText(),
            dureeField.getText(),
            operateurCombo.getValue(),
            causeField.getText()
        );

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Succès");
        alert.setHeaderText(null);
        alert.setContentText("Evenement créé avec succès !");
        alert.showAndWait();

    } catch (Exception ex) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText("Échec de création");
        alert.setContentText("L'évenement n’a pas pu être créé.\nDétail : " + ex.getMessage());
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
