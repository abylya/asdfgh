package ru.zl.zla;
import java.io.Serializable;

/**
 * Created by AB on 09.01.2016.
 */
public class Animal implements Serializable{
  private String animalClass;
    private String nicknaim;
    private boolean health;

  public String getAnimalClass() {
    return animalClass;
  }

  public void setAnimalClass(String animalClass) {
    this.animalClass = animalClass;
  }

  public boolean isHealth() {
    return health;
  }

  public void setHealth(boolean health) {
    this.health = health;
  }

  public String getNicknaim() {
    return nicknaim;
  }

  public void setNicknaim(String nicknaim) {
    this.nicknaim = nicknaim;
  }

  @Override
  public String toString() {

    return " Animal " +
             animalClass +
            ", nicknaim=" + nicknaim + '\'' +
            ", health=" + health ;
  }
}
