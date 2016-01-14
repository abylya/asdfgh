import java.io.Serializable;

/**
 * Created by AB on 13.01.2016.
 */
public class Animal implements Serializable{
    private String animalClass;
    private String nicknaim;
    private boolean health;

    public Animal(String animalClass, String nicknaim) {
        this.animalClass = animalClass;
        this.nicknaim = nicknaim;
    }

    public String getAnimalClass() {
        return animalClass;
    }

    public void setAnimalClass(String animalClass) {
        this.animalClass = animalClass;
    }

    public String getNicknaim() {
        return nicknaim;
    }

    public void setNicknaim(String nicknaim) {
        this.nicknaim = nicknaim;
    }

    public boolean isHealth() {
        return health;
    }

    public void setHealth(boolean health) {
        this.health = health;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "animalClass='" + animalClass + '\'' +
                ", nicknaim='" + nicknaim + '\'' +
                ", health=" + health +
                '}';
    }
}
