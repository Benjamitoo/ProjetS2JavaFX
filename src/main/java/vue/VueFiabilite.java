package vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import modele.Machine;
import modele.Atelier;



public class VueFiabilite extends JFrame {
    private Atelier atelier;
    private JTextArea zoneAffichage;
    private JComboBox<String> listeMachines;
    private JButton boutonAjouter;
    private JButton boutonCalculer;

    public VueFiabilite(Atelier atelier) {
        this.atelier = atelier;
        setTitle("Fiabilité des Machines");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Haut : choix de machine
        JPanel panelHaut = new JPanel();
        listeMachines = new JComboBox<>();
        for (Machine m : atelier.getMachines()) {
            listeMachines.addItem(m.getDes());
        }
        boutonAjouter = new JButton("Ajouter événement");
        panelHaut.add(listeMachines);
        panelHaut.add(boutonAjouter);

        // Centre : zone d'affichage
        zoneAffichage = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(zoneAffichage);
        
        // Bas : bouton calcul
        JPanel panelBas = new JPanel();
        boutonCalculer = new JButton("Afficher fiabilités");
        panelBas.add(boutonCalculer);

        add(panelHaut, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(panelBas, BorderLayout.SOUTH);

        setVisible(true);
    }

    public JButton getBoutonAjouter() { return boutonAjouter; }
    public JButton getBoutonCalculer() { return boutonCalculer; }
    public JComboBox<String> getListeMachines() { return listeMachines; }
    public void afficherTexte(String texte) { zoneAffichage.setText(texte); }
}
