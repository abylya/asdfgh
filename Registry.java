package ru.zl.zla;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by AB on 10.01.2016.
 */
public class Registry {

   // добовление в срисок
    public void addList(Klinic cp){
        Scanner sc=new Scanner(System.in);
    boolean bl=true;
       do {
           for (int i=0;i<cp.listClients.length;i++){


             if(cp.listClients[i]==null){
                 boolean b=true;
                 String naims;
                 int nbrP1=0;
                 int nbrQ2=0;
                 System.out.println("Для выхода нажать (Х) продолжить запись (Z)" );
                 String st= sc.next();
                 if(st.equals("X")||st.equals("x")){
                     bl=false;break;
                 }
                 System.out.println("\nЗапишите имя- "+(i+1)+" клиента");
                 naims=sc.next();

                 do {

                     System.out.println("Запишите номер паспорта клиента 6 цыфер");
                     if(sc.hasNextInt()){
                         nbrP1=sc.nextInt();
                         if(nbrP1<=99999||nbrP1>999999){

                         }else {
                             b=false;break;}
                     }else
                         sc.next();System.out.println("Не правильный ввод");

                 }while (b);b=true;

                 do {
                     System.out.println("Запишите количество питомцев не больше 3-х");
                     if(sc.hasNextInt()){
                         nbrQ2=sc.nextInt();
                         if(nbrQ2==0||nbrQ2>3){

                         }else{
                             b=false;break;}
                     }else
                         sc.next();System.out.println("Не правильный ввод");

                 }while (b);b=true;

                 cp.listClients[i]=new Klient(naims,nbrQ2,nbrP1);
                 cp.listClients[i].setNbrQueue(i+1);
                 for (int j=0;j<cp.listClients[i].getAnimal().length;j++){
                     cp.listClients[i].getAnimal()[j]=new Animal();
                     System.out.println("Запишите вид-"+(j+1)+" питомца" );
                     String v=sc.next();
                     cp.listClients[i].getAnimal()[j].setAnimalClass(v);
                     System.out.println("Запишите кличку-"+(j+1)+" питомца" );
                     String k=sc.next();
                     cp.listClients[i].getAnimal()[j].setNicknaim(k);
                 }
             }
           if (i+1==cp.listClients.length){
               System.out.println("Список полон" );bl=false;break;
           }


         }

        }while (bl);
    }
     //поиск клиента
    //
    public void scan(Klinic cp){
        if(cp.listClients[0]==null){
            System.out.println("Список пуст");
            return;
        }
        Scanner sc=new Scanner(System.in);
        System.out.println("Введите имя клиента " );
        String nm=sc.next();
        System.out.println("Введите кличку питомца " );
        String nn=sc.next();

        for (int i=0;i<cp.listClients.length;i++) {
            if (cp.listClients[i].getNaim().equals(nm)){
                for (int j=0;j<cp.listClients[i].getAnimal().length;j++){
                    if(cp.listClients[i].getAnimal()[j].getNicknaim().equals(nn)){
                        System.out.println(cp.listClients[i].toString());return;
                    }

                }
            }
            if(i+1==cp.listClients.length) {
                System.out.println("Нет такого клиента");return;
            }
            if(cp.listClients[i+1]==null){
                System.out.println("Нет такого клиента");return;
            }


        }  System.out.println("Нет такого клиента");return;

    }

}
