package controleur;

import modele.Atelier;
import modele.ChefAtelier;

public class AjoutAtelierControleur {

    public void creerAtelier(String nom, ChefAtelier chefAtelier) throws Exception {
        try {

        if (nom == null || nom.isEmpty()) {
            throw new Exception("L'atelier doit avoir un nom.");
        }

        if (chefAtelier == null) {
            throw new Exception("L'atelier doit avoir un chef d'atelier.");
        }

        Atelier a = new Atelier(nom, chefAtelier);
        System.out.println("Atelier créé : " + a);

        } catch (NumberFormatException e) {
            throw new Exception("Veuillez entrer une valeur valide pour la durée.");
        }
    }
}

