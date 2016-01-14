import java.io.*;
import java.util.ArrayList;

/**
 * Created by AB on 13.01.2016.
 */
public class Failjop {

    static void writeFail(Klinic k){

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("filecpicok.txt"))) {


            oos.writeObject(k.listClients);

        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }

    static void readFail(Klinic k){
        File file=new File("filecpicok.txt"); //создаем фаил для памяти
        if (file.length()!=0){
            //если в файле чтото есть производим инецыализацыю нашей лечебницы
            try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("filecpicok.txt"))) {

                k.listClients = (ArrayList<Klient>) is.readObject();

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

    }


}
