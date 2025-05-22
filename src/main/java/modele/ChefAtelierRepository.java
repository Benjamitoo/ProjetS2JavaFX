package modele;

import java.util.*;

public class ChefAtelierRepository {
    public static List<ChefAtelier> chefAtelier = new ArrayList<>();

    static {
        chefAtelier.add(new ChefAtelier("A1", "ARKS", "Alex"));
        //equipements.add(new Poste("P1", "Poste B"));
        // etc.
    }

    public static List<ChefAtelier> getChefAtelier() {
        return chefAtelier;
    }
}
