import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AB on 13.01.2016.
 */
public class Klient implements Serializable{
   final static int limitAnim=3;
    private String naim;
    private   int nbrPasport;
    private int nbrQueue; //номер в очереди
    private List<Animal>animal=new ArrayList<Animal>(limitAnim);


    public Klient(String naim, int nbrPasport) {
        this.naim = naim;
        this.nbrPasport = nbrPasport;
    }

    public String getNaim() {
        return naim;
    }

    public void setNaim(String naim) {
        this.naim = naim;
    }

    public int getNbrPasport() {
        return nbrPasport;
    }

    public void setNbrPasport(int nbrPasport) {
        this.nbrPasport = nbrPasport;
    }

    public int getNbrQueue() {
        return nbrQueue;
    }

    public void setNbrQueue(int nbrQueue) {
        this.nbrQueue = nbrQueue;
    }



    public List<Animal> getAnimal() {
        return animal;
    }

    public void setAnimal(List<Animal> animal) {
        this.animal = animal;
    }

    @Override
    public String toString() {
        return "\nKlient"+nbrQueue+"{" +
                "naim='" + naim + '\'' +
                ", nbrPasport=" + nbrPasport +
                ", animal=" + animal +
                '}';
    }
}
