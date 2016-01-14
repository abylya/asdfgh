import java.util.Scanner;

/**
 * Created by AB on 13.01.2016.
 */
public class Registry {


    public void scan(Klinic k){


        if (k.listClients.size()==0){
            System.out.println("Список пуст");    //выходим если список пуст
            return;
        }
        System.out.println(k.listClients);

        Scanner sc = new Scanner(System.in);
        System.out.println("Ведите имя клиента");
        String nm=sc.next();
        System.out.println("Ведите кличку питомца");
        String nk=sc.next();

        for (int i=0;i<k.listClients.size();i++){
            if(k.listClients.get(i).getNaim().equals(nm)){
                for (int j=0;j<k.listClients.get(i).getAnimal().size();j++) {

                    if (k.listClients.get(i).getAnimal().get(j).getNicknaim().equals(nk)) {
                        System.out.println("Есть такой клиент");
                        System.out.println(k.listClients.get(i).toString());
                        return;
                    }
                }
            }

        }

        System.out.println("Нет такой клиент");
    }

    /*
    ******************************************************
     */
    public void addList(Klinic k) {

        Scanner sc = new Scanner(System.in);
        boolean bl = true;
        int n = k.listClients.size();
        int np = 0;
        do {

            for (int i = n; i < k.limitList; i++) {

                System.out.println("Завершить запись клиентов нажать (Х) продолжить запись (Z)");
                String st = sc.next();
                if (st.equals("X") || st.equals("x")) {
                    bl = false;
                    break;
                }
                System.out.println("\nЗапишите имя- " + (i + 1) + " клиента");
                String naims = sc.next();
                boolean b = true;
                do {

                    System.out.println("Запишите номер паспорта клиента 6 цыфер");
                    if (sc.hasNextInt()) {
                        np = sc.nextInt();
                        if (np <= 99999 || np > 999999) {
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
                b = true;


                k.listClients.add(new Klient(naims, np));
                k.listClients.get(i).setNbrQueue(i + 1);
                do {
                    for (int j = 0; j < Klient.limitAnim; j++) {

                        System.out.println("Ведите вид питомца " + (j + 1));
                        String v = sc.next();
                        System.out.println("Ведите кличку питомца" + (j + 1));
                        String kl = sc.next();
                        k.listClients.get(i).getAnimal().add(new Animal(v, kl));

                        if (j + 1 == Klient.limitAnim) {
                            System.out.println("Список питомцев полон");
                            b = false;
                            break;
                        }

                        System.out.println("Завершить запись питомцев нажать (Х) продолжить запись (Z)");
                        String str = sc.next();
                        if (str.equals("X") || str.equals("x")) {
                            b = false;
                            break;
                        }
                    }
                } while (b);
                b = true;

                if (i + 1 == k.limitList) {
                    System.out.println("Список полон");
                    bl = false;
                    break;
                }

            }


        } while (bl);
    }

}
