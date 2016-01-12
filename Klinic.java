package ru.zl.zla;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by AB on 09.01.2016.
 */
public class Klinic implements Serializable{
     static int nbr=5;
   public Klient[]listClients=new Klient[nbr];

//лечение и удаление из списка
      public void doctor(){
          Scanner sc=new Scanner(System.in);
          System.out.println(Arrays.toString(listClients)+"\n");
          if(listClients[0]==null){
              System.out.println("Cpicok pyct");return;
          }

          System.out.println("Для выхода нажать (Х) продолжить (Z)" );
          String s= sc.next();
          if(s.equals("X")||s.equals("x")){
              return;
          }
          boolean b=true;
          do {

              System.out.println("Введите номер пацеента " );
              String st=sc.next();
               if (Integer.valueOf(st)>0&&Integer.valueOf(st)<=nbr) {
                   int n = Integer.valueOf(st) - 1;

                      try{ if (listClients[n] == null) {

                           throw new NullPointerException();
                       }
                       for (int i = 0; i < listClients[n].getAnimal().length; i++) {

                           int a = (int) (Math.random() * 2) + 1;
                           boolean d = ((a == 1) ? true : false);
                           listClients[n].getAnimal()[i].setHealth(d);
                           if (d == true) {
                               System.out.println("Питомец здоров");
                           } else {
                               System.out.println("Питомец не излечим");
                           }

                           listClients[n] = null;
                         if(n+1==listClients.length) {
                            return;
                         }
                           for (int j = n + 1; listClients[j] != null || listClients.length > j; j++) {//сортировка
                               if (listClients[j]==null){
                                   return;
                               }
                               listClients[j - 1] = listClients[j];
                               listClients[j] = null;
                               listClients[j - 1].setNbrQueue(j);
                                 if(j+1==listClients.length){
                                     return;
                                 }
                           }
                           return;
                       }

                   }catch (NullPointerException e){
                          System.out.println("Не правильный ввод нет в списке");
                      }


               }else {

                       System.out.println("Не правильный ввод");}


          }while (b);


      }
            //удаление из списка сортировка
    public void removeFromList(){
        Scanner sc=new Scanner(System.in);
        System.out.println(Arrays.toString(listClients)+"\n");
        if(listClients[0]==null){
            System.out.println("Cpicok pyct");return;
        }
        boolean b=true;
        do {
            System.out.println("Введите номер пацеента " );
            String st=sc.next();
            if (Integer.valueOf(st)>0&&Integer.valueOf(st)<=nbr){
                int n=Integer.valueOf(st)-1;
             try {
                 if (listClients[n] == null) {
                     throw new NullPointerException();
                 }

                 if (n+1 == listClients.length) {
                     listClients[n] = null;
                     return;
                 }


                         listClients[n] = null;

                         for (int j = n + 1; listClients[j]!= null || listClients.length > j; j++) { //сортировка
                               if (listClients[j]==null){
                                   return;
                               }
                             listClients[j - 1] = listClients[j];
                             listClients[j] = null;
                             listClients[j - 1].setNbrQueue(j);
                             if (j + 1 == listClients.length) {
                                 return;
                             }
                         }
                         return;



             }catch (NullPointerException e){System.out.println("Не правильный ввод нет в списке");}
            }else {
                System.out.println("Не правильный ввод");}

        }while (b);

    }
         //запись в фаил обьекта клиника
    public void zapicatVfail(Klinic z){

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("filecpicok.txt"))) {


            oos.writeObject(z);

        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }


    @Override
    public String toString() {
        return
              "List klients" + Arrays.toString(listClients) ;

    }
}
