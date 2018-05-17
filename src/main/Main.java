package main;

import centreTri.CentreDeTri;
import matiere.Materiaux;
import matiere.Neptunium;
import planete.*;
import vaisseau.Leger;
import vaisseau.Lourd;
import vaisseau.Normal;
import vaisseau.Vaisseau;

import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Main {


    public static int nbVLight=definir();
    public static int nbVNorm=definir2();
    public static int nbVLourd=definir3();
    public static int nbCentreTri=definir4();
    public static int pourcPlut=definir5();
    public static int pourcThul=definir6();
    public static int pourcGad=definir7();
    public static int pourcTerb=definir8();
    public static int pourcNep=definir9();
    public static int nbMaxDechet=definir10();
    public static int nbMaxVaiss=definir11();
    public static boolean fini=false;
    public static CentreDeTri tabCentre[]=new CentreDeTri[nbCentreTri];

    public static void main(String[] args) {
        //Creer vaisseau
        Vaisseau[] tabVais=new Vaisseau[nbVLight+nbVNorm+nbVLourd];
        for (int i=0;i<tabVais.length;i++){
            if (i<nbVLight){
                tabVais[i]=new Leger();
            }
            else if (i<(nbVLight+nbVNorm)){
                tabVais[i]=new Normal();
            }
            else {
                tabVais[i]=new Lourd();
            }
        }
        System.out.println("Your "+tabVais.length+" Vaisseau are successfully created");
        //Creer centre tri
        for (int i=0;i<tabCentre.length;i++){
            tabCentre[i]=new CentreDeTri(nbMaxDechet,nbMaxVaiss,i);
        }
        System.out.println("Your "+tabCentre.length+" Tri Center are successfully created"+System.lineSeparator());

        //SIMULATION
        System.out.println("Bienvenue dans le futur!!!");
        System.out.println("Progamme qui simule un projet de récupération de déchets");
        System.out.println("---------------------------------------------------------------------------------------");
        int i=0;
        while (!fini){
            //REMPLIR VAISSEAU
            try {
                tabVais[i].remplir(getRandomPlanet());
            }catch (Exception ex){
                System.out.println("Tout les Vaisseau sont parti quelque part");
                System.out.println("---------------------------------------------------------------------------------------");
                fini=true;
            }
            //ALLER PORTER LE VAISSEAU
            if (fini==false){
                try {
                    tabVais[i].go(tabCentre[0]);
                }catch (Exception ex){
                    System.out.println("probleme methode go");
                    System.out.println("---------------------------------------------------------------------------------------");
                    Main.fini=true;
                }

            }
            i++;

        }
        //AFFICHAGE CENTRE TRI
        System.out.println("--Affichage--");
        for (int j=0;j<tabCentre.length;j++){
            System.out.println("Centre de Tri #"+(j+1));
            System.out.println("il y a "+tabCentre[j].getVaissoLine().size()+" vaisseau dans la file");
            System.out.println("Plutonium  : "+tabCentre[j].getStackPlut().size());
            System.out.println("Thulium    : "+tabCentre[j].getStackThul().size());
            System.out.println("Gadolinium : "+tabCentre[j].getStackGad().size());
            System.out.println("Terbium    : "+tabCentre[j].getStackTerb().size());
            System.out.println("Neptunium  : "+tabCentre[j].getStackNep().size());
            envoyerInfo();
        }
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        try {
            PrintWriter sortie = new PrintWriter(new BufferedWriter(new FileWriter(timeStamp+".xml")));
            sortie.println("World");
        }catch (Exception ex){
            System.out.println("créer dans un fichier qui n'existe pas.");
        }






    }
    public static Planet getRandomPlanet(){
        Planet p1=new Pluton();
        Planet p2=new Gadolile();
        Planet p3=new Thulipe();
        Planet p4=new Terrbe();
        Planet p5=new Neptune();
        int sa=(int)(Math.random()*(5)+1);
        if (sa==1){
            return p1;
        }
        else  if (sa==2){
            return p2;
        }
        else  if (sa==3){
            return p3;
        }
        else  if (sa==4){
            return p4;
        }
        else  {
            return p5;
        }
    }
    public static int definir(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Entrez le nombre de vaisseaux légers");
        int nbVaisseauLeger=sc.nextInt();
        return nbVaisseauLeger;

    }
    public static int definir2(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Entrez le nombre de vaisseaux normaux");
        int nbVaisseauNormal=sc.nextInt();
        return nbVaisseauNormal;
    }
    public static int definir3(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Entrez le nombre de vaisseaux lourds");
        int nbVaisseauLourd=sc.nextInt();
        return nbVaisseauLourd;
    }
    public static int definir4(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Entrez le nombre de Centres de tri");
        int nbCentreTri=sc.nextInt();
        return nbCentreTri;
    }
    public static int definir5(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Entrez le pourcentage de PLUTONIM recyclable");
        int pourcentgeRecyclablePlut=sc.nextInt();
        return pourcentgeRecyclablePlut;
    }
    public static int definir6(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Entrez le pourcentage de THULIUM recyclable");
        int pourcentgeRecyclableThul=sc.nextInt();
        return pourcentgeRecyclableThul;
    }
    public static int definir7(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Entrez le pourcentage de GALOLINIUM recyclable");
        int pourcentgeRecyclableGado=sc.nextInt();
        return pourcentgeRecyclableGado;
    }
    public static int definir8(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Entrez le pourcentage de TERBIUM recyclable");
        int pourcentgeRecyclableTerb=sc.nextInt();
        return pourcentgeRecyclableTerb;
    }
    public static int definir9(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Entrez le pourcentage de NEPTUNIUM recyclable");
        int pourcentgeRecyclableNept=sc.nextInt();
        return pourcentgeRecyclableNept;
    }
    public static int definir10(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Entrez le nombre de déchet maximum par pile");
        int nbMaxDechet=sc.nextInt();
        return nbMaxDechet;
    }
    public static int definir11(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Entrez le nombre de Vaisseau maximum par file dans les Centres de tri");
        int nbMaxVais=sc.nextInt();
        return nbMaxVais;
    }

    public static void envoyerInfo(){
        try {
            Socket socket = new Socket("127.0.0.1", 8080);
            OutputStream fluxSortant = socket.getOutputStream();
            OutputStreamWriter sortie = new OutputStreamWriter(fluxSortant);
            sortie.write(tabCentre.length);
            for(int i=0;i<tabCentre.length;i++) {
                sortie.write(tabCentre[i].getVaissoLine().size());
                sortie.write(tabCentre[i].getStackPlut().size());
                sortie.write(tabCentre[i].getStackGad().size());
                sortie.write(tabCentre[i].getStackNep().size());
                sortie.write(tabCentre[i].getStackTerb().size());
                sortie.write(tabCentre[i].getStackThul().size());
            }
            sortie.close();
        } catch(Exception ex){
            System.out.println("Le socket ne fonctionne pas : "+ex);
        }
    }
    public static void reprendreInfo(){

    }
}
