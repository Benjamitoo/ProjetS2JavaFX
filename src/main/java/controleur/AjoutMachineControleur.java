package controleur;

import modele.Machine;

public class AjoutMachineControleur {

    public void creerMachine(String id, String ref, String des, String type,
                             String coutStr, String xStr, String yStr) throws Exception {
        try {
            float cout = Float.parseFloat(coutStr);
            float x = Float.parseFloat(xStr);
            float y = Float.parseFloat(yStr);

            if (id == null || id.isEmpty()) {
                throw new Exception("L'identifiant ne peut pas être vide.");
            }

            // Création de la machine
            Machine m = new Machine(id, ref, des, type, cout, x, y);

            // Ici tu peux ajouter la machine à une liste ou base de données

            // Message console utile pour debug
            System.out.println("Machine créée : " + m);

        } catch (NumberFormatException e) {
            throw new Exception("Veuillez entrer des valeurs numériques valides pour coût, x et y.");
        }
    }
}

