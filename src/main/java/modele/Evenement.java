package modele;



import java.time.LocalDate;
import java.time.LocalTime;


public class Evenement {
    
    private LocalDate date;
    private LocalTime heure;
    private int duree; //en minute
    private Operateur operateur;
    private String cause;
    
    public Evenement(LocalDate date, LocalTime heure, int duree, Operateur operateur, String cause) {
        this.date=date;
        this.heure=heure;
        this.duree=duree;
        this.operateur=operateur;
        this.cause=cause;
    }
    
    
    public LocalDate getDate() {
        return this.date;
    }
    
    public LocalTime getHeure() {
        return this.heure;
    }
    
    public int getDuree() {
        return this.duree;
    }
    
    public Operateur getOperateur() {
        return this.operateur;
    }
    
    public String getCause() {
        return this.cause;
    }
    
    
    public void setDate(LocalDate d) {
        this.date=d;
    }
    
    public void setHeure(LocalTime h) {
        this.heure=h;
    }
    
    public void setDuree(int d) {
        this.duree=d;
    }
    
    public void setOperateur(Operateur o) {
        this.operateur=o;
    }
    
    public void setCause(String c) {
        this.cause=c;
    }
    
    
    
}
