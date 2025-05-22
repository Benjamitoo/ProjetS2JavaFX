package modele;







public class Equipement {
    private String id;
    private String ref;

    public Equipement(String id, String ref) {
        this.id=id;
        this.ref=ref;
    }
    
    public String getId() {
        return id;
    }

    public String getRef() {
        return ref;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }
    
    
    
    
}
