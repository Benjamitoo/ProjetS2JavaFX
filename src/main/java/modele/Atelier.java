package modele;

import controleurs.ChefAtelier;
import java.util.*;



public class Atelier {
    
    private String nom;
    private ChefAtelier CA;
    private ArrayList<Poste> listePostes;
    private ArrayList<Machine> listeMachines;
    private ArrayList<Produit> listeProduits;
    private ArrayList<Operation> listeOperations;
    private ArrayList<Gamme> listeGammes;

    public Atelier(String nom, ChefAtelier CA) {
        this.nom = nom;
        this.CA = CA;
        this.listePostes = new ArrayList<Poste>();
        this.listeMachines = new ArrayList<Machine>();
        this.listeProduits = new ArrayList<Produit>();
        this.listeOperations = new ArrayList<Operation>();
        this.listeGammes = new ArrayList<Gamme>();
    }

    public String getNom() {
        return nom;
    }

    public ChefAtelier getCA() {
        return CA;
    }

    public ArrayList<Poste> getListePostes() {
        return listePostes;
    }

    public ArrayList<Machine> getListeMachines() {
        return listeMachines;
    }

    public ArrayList<Produit> getListeProduits() {
        return listeProduits;
    }

    public ArrayList<Operation> getListeOperations() {
        return listeOperations;
    }

    public ArrayList<Gamme> getListeGammes() {
        return listeGammes;
    }

    
    
    
    
    
    
    //POUR FIABILITÉ
    public ArrayList<Machine> getMachines() {
        ArrayList<Machine> machines = new ArrayList<>();
        for (Equipement e : listeEquipement) {
            if (e instanceof Machine) {
                machines.add((Machine) e);
            } else if (e instanceof Poste) {
                machines.addAll(((Poste) e).getListeMachines());
            }
        }
         return machines;
    }
    
    public Machine getMachineParNom(String nom) {
        for (Machine m : getListeMachines()) {
            if (m.getDes().equals(nom)) {  // ou getRef() ou getId(), selon le champ utilisé comme nom
                return m;
            }
        }
        return null;
    }
    
    
    public List<Machine> getMachinesTrieesParFiabilite() {
        List<Machine> machines = getMachines(); // récupère toutes les machines
        machines.sort(Comparator.comparingDouble(Machine::getFiabilite).reversed());
        return machines;
    }
    
    
    
}
