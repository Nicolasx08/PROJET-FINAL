package vaisseau;

import centreTri.CentreDeTri;
import main.Main;
import matiere.*;
import planete.Planet;

import java.util.ArrayList;

public class Vaisseau {
    private String type;
    private int capacite;
    private ArrayList<Materiaux> contenu=new ArrayList<>();
    protected int centreActuel=0;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public ArrayList<Materiaux> getContenu() {
        return contenu;
    }

    public void setContenu(ArrayList<Materiaux> contenu) {
        this.contenu = contenu;
    }

    public int getCentreActuel() {
        return centreActuel;
    }

    public void setCentreActuel(int centreActuel) {
        this.centreActuel = centreActuel;
    }

    public void remplir(Planet planete){
        int i=0;
        int chiffre=0;
        while (i<capacite){
            chiffre=(int)(Math.random()* 101);
            if (chiffre<planete.getNbGad()){
                contenu.add(new Gadolinium(Main.pourcGad));
            }
            else if (chiffre>=planete.getNbGad()&&chiffre< (planete.getNbGad()+planete.getNbNep())){
                contenu.add(new Neptunium(Main.pourcNep));
            }
            else if (chiffre>= (planete.getNbGad()+planete.getNbNep()) && chiffre<  (planete.getNbGad()+planete.getNbNep()+planete.getNbPlut())){
                contenu.add(new Plutonium(Main.pourcPlut));
            }
            else if (chiffre>=(planete.getNbGad()+planete.getNbNep()+planete.getNbPlut())  &&  chiffre<  (planete.getNbGad()+planete.getNbNep()+planete.getNbPlut()+planete.getNbTer())){
                contenu.add(new Terbium(Main.pourcTerb));
            }
            else {
                contenu.add(new Thulium(Main.pourcThul));
            }

            i++;
        }

    }

    public void go(CentreDeTri centreDeTri){
        try {
            vider(centreDeTri);
            centreDeTri.getVaissoLine().add(this);
            centreDeTri.recycler();
            if (centreDeTri.getVaissoLine().size()==centreDeTri.getMaxVaisQueue()){
                centreDeTri.getVaissoLine().peek().remplir(Main.getRandomPlanet());
                centreDeTri.getVaissoLine().poll().go(Main.tabCentre[0]);
            }
        }catch (Exception ez){
            System.out.println("Simon est bo");
            Main.fini=true;
        }
    }
    public void vider(CentreDeTri centreDeTri){
        try {
            for (int i=0;i<contenu.size();i++){
                if (contenu.get(i).getMasseVol()==2){
                    centreDeTri.getStackPlut().add(new Plutonium(Main.pourcPlut));
                }
                else if (contenu.get(i).getMasseVol()==3){
                    centreDeTri.getStackThul().add(new Thulium(Main.pourcThul));
                }
                else if (contenu.get(i).getMasseVol()==4){
                    centreDeTri.getStackGad().add(new Gadolinium(Main.pourcGad));
                }
                else if (contenu.get(i).getMasseVol()==5){
                    centreDeTri.getStackTerb().add(new Terbium(Main.pourcTerb));
                }
                else {
                    centreDeTri.getStackNep().add(new Neptunium(Main.pourcNep));
                }

            }
            contenu.clear();
        }catch (Exception ex){
            System.out.println("Méthode VIDER");
            Main.fini=true;
        }

    }
}
