package modele;







public class Produit {
    private String id;
    private int Stock;
    
    public Produit(String id, int Stock){
        this.id=id;
        this.Stock=Stock;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
    
    
}
