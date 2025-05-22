package modele;

import java.util.*;

public class OperateurRepository {
    public static List<Operateur> operateurs = new ArrayList<>();

    static {
        operateurs.add(new Operateur("O1", "ARKS", "Alex"));
        //equipements.add(new Poste("P1", "Poste B"));
        // etc.
    }

    public static List<Operateur> getOperateurs() {
        return operateurs;
    }
}
