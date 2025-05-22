package modele;

import java.util.*;

public class EquipementRepository {
    public static List<Equipement> equipements = new ArrayList<>();

    static {
        equipements.add(new Machine("M1", "Machine A", " ", " ", 54, 3, 2));
        //equipements.add(new Poste("P1", "Poste B"));
        // etc.
    }

    public static List<Equipement> getEquipements() {
        return equipements;
    }
}
