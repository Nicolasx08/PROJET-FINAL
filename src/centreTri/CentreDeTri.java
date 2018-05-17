package centreTri;

import main.Main;
import matiere.*;
import vaisseau.Vaisseau;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CentreDeTri {
    private int qMax;
    private int maxVaisQueue;
    private Queue<Vaisseau> vaissoLine= new LinkedList<Vaisseau>() {};
    private Stack<Materiaux> stackPlut= new Stack<>();
    private Stack<Materiaux> stackGad= new Stack<>();
    private Stack<Materiaux> stackTerb= new Stack<>();
    private Stack<Materiaux> stackThul= new Stack<>();
    private Stack<Materiaux> stackNep= new Stack<>();
    private int position;

    public CentreDeTri(int qMax,int maxVaisQueue, int position) {
        this.qMax = qMax;
        this.maxVaisQueue=maxVaisQueue;
        this.position= position;
    }

    public int getMaxVaisQueue() {
        return maxVaisQueue;
    }

    public void setMaxVaisQueue(int maxVaisQueue) {
        this.maxVaisQueue = maxVaisQueue;
    }

    public int getqMax() {
        return qMax;
    }

    public void setqMax(int qMax) {
        this.qMax = qMax;
    }

    public Queue<Vaisseau> getVaissoLine() {
        return vaissoLine;
    }

    public void setVaissoLine(Queue<Vaisseau> vaissoLine) {
        this.vaissoLine = vaissoLine;
    }

    public Stack<Materiaux> getStackPlut() {
        return stackPlut;
    }

    public void setStackPlut(Stack<Materiaux> stackPlut) {
        this.stackPlut = stackPlut;
    }

    public Stack<Materiaux> getStackGad() {
        return stackGad;
    }

    public void setStackGad(Stack<Materiaux> stackGad) {
        this.stackGad = stackGad;
    }

    public Stack<Materiaux> getStackTerb() {
        return stackTerb;
    }

    public void setStackTerb(Stack<Materiaux> stackTerb) {
        this.stackTerb = stackTerb;
    }

    public Stack<Materiaux> getStackThul() {
        return stackThul;
    }

    public void setStackThul(Stack<Materiaux> stackThul) {
        this.stackThul = stackThul;
    }

    public Stack<Materiaux> getStackNep() {
        return stackNep;
    }

    public void setStackNep(Stack<Materiaux> stackNep) {
        this.stackNep = stackNep;
    }

    public void recycler() {
        try {
            if (stackPlut.size() > qMax) {
                for (int i = 0; i < (qMax * Main.pourcPlut / 100); i++) {
                    vaissoLine.peek().getContenu().add(new Plutonium(Main.pourcPlut));
                    stackPlut.pop();
                    if (i == vaissoLine.peek().getCapacite()) {
                        vaissoLine.poll().go(Main.tabCentre[this.position + 1]);
                    }
                }
                vaissoLine.poll().go(Main.tabCentre[this.position + 1]);
            }
            if (stackGad.size() > qMax) {
                for (int i = 0; i < (qMax * Main.pourcGad / 100); i++) {
                    vaissoLine.peek().getContenu().add(new Gadolinium(Main.pourcGad));
                    stackGad.pop();
                    if (i == vaissoLine.peek().getCapacite()) {
                        vaissoLine.poll().go(Main.tabCentre[this.position + 1]);

                    }
                }
                vaissoLine.poll().go(Main.tabCentre[this.position + 1]);
            }
            if (stackNep.size() > qMax) {
                for (int i = 0; i < (qMax * Main.pourcNep / 100); i++) {
                    vaissoLine.peek().getContenu().add(new Neptunium(Main.pourcNep));
                    stackNep.pop();
                    if (i == vaissoLine.peek().getCapacite()) {
                        vaissoLine.poll().go(Main.tabCentre[this.position + 1]);

                    }
                }
                vaissoLine.poll().go(Main.tabCentre[this.position + 1]);
            }
            if (stackTerb.size() > qMax) {
                for (int i = 0; i < (qMax * Main.pourcTerb / 100); i++) {
                    vaissoLine.peek().getContenu().add(new Terbium(Main.pourcTerb));
                    stackTerb.pop();
                    if (i == vaissoLine.peek().getCapacite()) {
                        vaissoLine.poll().go(Main.tabCentre[this.position + 1]);

                    }
                }
                vaissoLine.poll().go(Main.tabCentre[this.position + 1]);
            }
            if (stackThul.size() > qMax) {
                for (int i = 0; i < (qMax * Main.pourcThul / 100); i++) {
                    vaissoLine.peek().getContenu().add(new Thulium(Main.pourcThul));
                    stackThul.pop();
                    if (i == vaissoLine.peek().getCapacite()) {
                        vaissoLine.poll().go(Main.tabCentre[this.position + 1]);

                    }
                }
                vaissoLine.poll().go(Main.tabCentre[this.position + 1]);
            }
        } catch (Exception ex) {
            System.out.println("Méthode Recycler");
            Main.fini=true;
        }
    }
}
