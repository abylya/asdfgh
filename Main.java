import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;

/**
 * Created by AB on 13.01.2016.
 */
public class Main {

    public static void main(String[] args) {
        Klinic klinic=new Klinic();
        Registry registry=new Registry();
     Failjop.readFail(klinic);
       int nbrMinu=6;
        boolean per=true;
        do {
            Minu.minu();
            try {
                Scanner scanner = new Scanner(System.in);
                String s = scanner.next();
                if (Integer.valueOf(s) > 0 && Integer.valueOf(s) <=nbrMinu) {
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
                            System.out.println(klinic.listClients);
                            break;
                        case "6":
                            Failjop.writeFail(klinic);
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
