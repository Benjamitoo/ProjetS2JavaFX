package controleurs;

import modele.Atelier;
import modele.Machine;
import modele.Evenement;
import vue.VueFiabilite;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;

public class ControleurFiabilite {
    private Atelier atelier;
    private VueFiabilite vue;

    public ControleurFiabilite(Atelier atelier, VueFiabilite vue) {
        this.atelier = atelier;
        this.vue = vue;

        vue.getBoutonAjouter().addActionListener(e -> ajouterEvenement());
        vue.getBoutonCalculer().addActionListener(e -> afficherFiabilites());
    }

    private void ajouterEvenement() {
        String nomMachine = (String) vue.getListeMachines().getSelectedItem();
        Machine m = atelier.getMachineParNom(nomMachine);
        if (m == null) {
            JOptionPane.showMessageDialog(null, "Machine non trouvée !");
            return;
        }

        try {
            String dateStr = JOptionPane.showInputDialog("Date de l'événement (format YYYY-MM-DD) :");
            if (dateStr == null) return; // annulation
            LocalDate date = LocalDate.parse(dateStr, DateTimeFormatter.ISO_LOCAL_DATE);

            String timeStr = JOptionPane.showInputDialog("Heure de l'événement (format HH:mm) :");
            if (timeStr == null) return; // annulation
            LocalTime time = LocalTime.parse(timeStr, DateTimeFormatter.ofPattern("HH:mm"));

            String idOperateur = JOptionPane.showInputDialog("ID de l'opérateur :");
            if (idOperateur == null) return;

            String nomOperateur = JOptionPane.showInputDialog("Nom de l'opérateur :");
            if (nomOperateur == null) return;

            String prenomOperateur = JOptionPane.showInputDialog("Prénom de l'opérateur :");
            if (prenomOperateur == null) return;

            Operateur operateur = new Operateur(idOperateur, nomOperateur, prenomOperateur);

            String cause = JOptionPane.showInputDialog("Cause de l'événement :");
            if (cause == null) return;

            Evenement e = new Evenement(date, time, operateur, cause);
            m.addEvenement(e);

            JOptionPane.showMessageDialog(null, "Événement ajouté avec succès !");
        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(null, "Format de date ou heure invalide !\nDate attendue : YYYY-MM-DD\nHeure attendue : HH:mm");
        }
    }

    private void afficherFiabilites() {
        StringBuilder sb = new StringBuilder();
        for (Machine m : atelier.getMachinesTrieesParFiabilite()) {
            sb.append(m.getDes())
              .append(" → Fiabilité : ")
              .append(String.format("%.2f", m.getFiabilite()))
              .append("\n");
        }
        vue.afficherTexte(sb.toString());
    }
}
