package ru.zl.zla;
import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Klinic klinic=new Klinic();
        Registry registry=new Registry();
        File file=new File("filecpicok.txt"); //создаем фаил для памяти
        if (file.length()!=0){
            //если в файле чтото есть производим инецыализацыю нашей лечебницы
            try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("filecpicok.txt"))) {

                klinic = (Klinic) is.readObject();

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }


        boolean per=true;
        do {
            Minu.minu();
            try {
                Scanner scanner = new Scanner(System.in);
                String s = scanner.next();
                if (Integer.valueOf(s) > 0 && Integer.valueOf(s) < 7) {
                    switch (s) {
                        case "1":
                        registry.addList(klinic);
                            break;
                        case "2":
                            registry.scan(klinic);
                            break;
                        case "3":
                            klinic.doctor();
                            break;
                        case "4":
                            klinic.removeFromList();
                            break;
                        case "5":
                            System.out.println(klinic.toString());
                            break;
                        case "6":
                            klinic.zapicatVfail(klinic);
                            per = false;
                            break;
                    }
                } else {
                    System.out.println("Неправильный ввод");
                }
            }catch (NumberFormatException e){
                System.out.println("Неправильный ввод");
            }

        }while (per);


    }
}
