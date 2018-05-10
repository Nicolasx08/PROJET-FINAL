package matiere;

public class Materiaux {
    private String nom;
    private double masseVol;
    private int pourcentageRecyclabe;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getMasseVol() {
        return masseVol;
    }

    public void setMasseVol(double masseVol) {
        this.masseVol = masseVol;
    }

    public int getPourcentageRecyclabe() {
        return pourcentageRecyclabe;
    }

    public void setPourcentageRecyclabe(int pourcentageRecyclabe) {
        this.pourcentageRecyclabe = pourcentageRecyclabe;
    }
}
