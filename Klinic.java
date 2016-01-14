import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by AB on 13.01.2016.
 */
public class Klinic implements Serializable {

    int limitList = 10;
    List<Klient> listClients = new ArrayList<Klient>(limitList);

    public void doctor() {

        if (this.listClients.size() == 0) {
            System.out.println("Список пуст");    //выходим если список пуст
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Ведите номер клиента");
        boolean b = true;
        int n = 0;

        do {

            if (sc.hasNextInt()) {
                n = sc.nextInt();                                     //лечим если получится
                if (n < 1 || n > this.listClients.size()) {
                    System.out.println("Не правильный ввод");
                } else {
                    for (int j = 0; j < this.listClients.get(n - 1).getAnimal().size(); j++) {
                        int a = (int) (Math.random() * 2) + 1;
                        boolean zd = ((a == 1) ? true : false);
                        if (zd == true) {
                            this.listClients.get(n - 1).getAnimal().get(j).setHealth(zd);
                            this.listClients.get(n - 1).getAnimal().get(j).setNicknaim(this.listClients.get(n - 1).getAnimal().get(j).getNicknaim() + "-Обс-н");
                            System.out.println("Ваш питомец здоров");
                        } else {
                            this.listClients.get(n - 1).getAnimal().get(j).setNicknaim("X");
                            System.out.println("Ваш питомец не излечим");
                        }
                    }
                    return;
                }

            } else {
                sc.next();
                System.out.println("Не правильный ввод");
            }

        } while (b);
    }


    /*
******************************************************
     */
    public void removeFromList() {
        if (this.listClients.size() == 0) {
            System.out.println("Список пуст");    //выходим если список пуст
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println(this.listClients);
        boolean b = true;
        int n = 0;
        do {
            System.out.println("Ведите номер клиента");

            if (sc.hasNextInt()) {
                n = sc.nextInt();
                if (n < 1 || n > this.listClients.size()) {
                    System.out.println("Не правильный ввод");
                } else {
                    b = false;
                    break;
                }
            } else {
                sc.next();
                System.out.println("Не правильный ввод");
            }
        } while (b);

        this.listClients.remove(n - 1);

        for (int i = n - 1; i < this.listClients.size(); i++) {      //сортируем и присваеваим номер в очереди
            this.listClients.get(i).setNbrQueue(i + 1);
        }

    }
/*
**********************************************
 */
}