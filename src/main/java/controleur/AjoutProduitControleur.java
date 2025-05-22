package controleur;

import modele.Produit;

public class AjoutProduitControleur {

    public void creerProduit(String id, String stockStr) throws Exception {
        try {
            int stock = Integer.parseInt(stockStr);

            if (id == null || id.isEmpty()) {
                throw new Exception("L'identifiant ne peut pas être vide.");
            }

            // Création de la machine
            Produit p = new Produit(id, stock);

            // Ici tu peux ajouter la machine à une liste ou base de données

            // Message console utile pour debug
            System.out.println("Produit créé : " + p);

        } catch (NumberFormatException e) {
            throw new Exception("Veuillez entrer une valeur numérique valide pour le stock.");
        }
    }
}

