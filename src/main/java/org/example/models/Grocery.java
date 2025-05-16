package org.example.models;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Grocery{
    public static ArrayList<Object> groceryList = new ArrayList<>();

    public static void printSorted(){
        System.out.println("Güncel alışveriş listesi: ");
        for (int i = 0; i < groceryList.size(); i++){
            System.out.println(groceryList.get(i));
        }

    }

    public static int checkItemIsInList(String item){


       for (int i = 0; i < groceryList.size(); i++){
           if(item.toLowerCase(Locale.ROOT).trim().equals(groceryList.get(i).toString().toLowerCase(Locale.ROOT).trim())){

              return i;
           }

        };
        return -1;

    };

    public static void addItems(String item){
        if(checkItemIsInList(item) != -1){System.out.println("Eklemek istediğiniz ürün listede bulunuyor.");} else {
            groceryList.add(item);
            System.out.println( item + " listeye eklendi.");
        }
    };

    public static void removeItems(String item){
        if(checkItemIsInList(item)!= -1){groceryList.remove(item);
        System.out.println(item + " listeden çıkarıldı.");} else {
            System.out.println("Çıkartmak istediğiniz ürün listede yok.");
        }
    }

    public static void startGrocery(){
    Scanner sc = new Scanner(System.in);
    boolean devam = true;
        while (devam){
            System.out.println("Alışveriş listesine hoşgeldiniz.");
            System.out.println("Ne yapmak istersiniz ?");
            System.out.println("0--Uygulamayı durdur.");
            System.out.println("1--Listeye ürün ekleyin.");
            System.out.println("2--Listeden ürün çıkartın.");
            int secim = sc.nextInt();
            sc.nextLine();

            switch (secim) {
                case 0:
                    System.out.println("Uygulama kapatılıyor iyi günler.");
                    devam = false;
                    break;
                case 1:
                    System.out.println("Lütfen eklemek istediğiniz ürün veya ürünleri aralarında virgül olacak şekilde yazınız.");
                    String inputEkle = sc.nextLine();
                    String[] eklenecekUrunler = inputEkle.split(",");

                    for (int i = 0; i < eklenecekUrunler.length; i++) {

                        addItems(eklenecekUrunler[i]);

                    }
                    printSorted();
                    break;
                case 2:
                    printSorted();
                    System.out.println("Lütfen çıkartmak istediğiniz ürün veya ürünleri aralarında virgül olacak şekilde yazınız.");
                    String inputCikar = sc.nextLine();
                    String[] cikacakUrunler = inputCikar.split(",");

                    for (int i = 0; i < cikacakUrunler.length; i++) {

                        removeItems(cikacakUrunler[i]);

                    }
                    printSorted();

                    break;
                default:
                    System.out.println("Lütfen geçerli bir seçim yapınız");
            }
        }
       sc.close();
    }

}
