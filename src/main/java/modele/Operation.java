package modele;







public class Operation {
    private String ref;
    private String des;
    private int duree;
    private Equipement equipement;

    public Operation(String ref, String des, int duree, Equipement equipement) {
        this.ref = ref;
        this.des = des;
        this.duree = duree;
        this.equipement = equipement;
    }

    public String getRef() {
        return ref;
    }

    public String getDes() {
        return des;
    }

    public int getDuree() {
        return duree;
    }

    public Equipement getEquipement() {
        return equipement;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public void setEquipement(Equipement equipement) {
        this.equipement = equipement;
    }
    
    
    
    
}
