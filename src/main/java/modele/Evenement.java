package modele;

import controleurs.Operateur;
import java.time.LocalDate;
import java.time.LocalTime;



public class Evenement {
    
    private LocalDate date;
    private LocalTime heure;
    private Operateur operateur;
    private String cause;
    
    public Evenement(LocalDate d, LocalTime h, Operateur o, String c) {
        this.date=d;
        this.heure=h;
        this.operateur=o;
        this.cause=c;
    }
    
    
    public LocalDate getDate() {
        return this.date;
    }
    
    public LocalTime getHeure() {
        return this.heure;
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
    
    public void setOperateur(Operateur o) {
        this.operateur=o;
    }
    
    public void setCause(String c) {
        this.cause=c;
    }
    
    
    
}
