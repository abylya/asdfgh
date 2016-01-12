package ru.zl.zla;
import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by AB on 09.01.2016.
 */
public class Klient implements Serializable{
   private String naim;
  private   int nbrPasport;
    private int nbrQueue; //номер в очереди
    private int quantity;//количество ритомцев
  private Animal[] animal;

    public Klient(String naim, int quantity, int nbrPasport) {
        this.naim = naim;
        this.quantity = quantity;
        this.animal = new Animal[quantity];
        this.nbrPasport = nbrPasport;


    }

    public void setNbrQueue(int nbrQueue) {
        this.nbrQueue = nbrQueue;
    }

    public void setAnimal(Animal[] animal) {
        this.animal = animal;
    }

    public String getNaim() {
        return naim;
    }

    public int getNbrPasport() {
        return nbrPasport;
    }

    public int getNbrQueue() {
        return nbrQueue;
    }

    public int getQuantity() {
        return quantity;
    }

    public Animal[] getAnimal() {
        return animal;
    }

    @Override
    public String toString() {
        return
                "\n{"+nbrQueue+"# Naim-'" + naim + '\'' +
                ",Pasport-" + nbrPasport +
                ", Quantity animal-" + quantity +":"+
                 Arrays.toString(animal) +
                '}';
    }
}
