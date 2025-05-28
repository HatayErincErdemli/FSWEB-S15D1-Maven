package org.example.models;

import java.util.*;

public class Grocery{
    public static ArrayList<String> groceryList = new ArrayList<>();

    public static void printSorted(){
        Collections.sort(groceryList);
        if(groceryList.isEmpty()){System.out.println("Listede ürün bulunmuyor.");} else {System.out.println("Güncel alışveriş listesi: ");
        for (int i = 0; i < groceryList.size(); i++){
            System.out.println(groceryList.get(i));
        }}

    }

    private static boolean checkItemIsInList(String item){
    return groceryList.contains(item);
    };


    public static void addItems(String eklenecekUrunler){
        String [] eklenecekUrun = eklenecekUrunler.split(",");
        for (String urun: eklenecekUrun){
            if (checkItemIsInList(urun)){
                System.out.println("Eklemek istediğiniz ürün listede mevcut: " + urun);
            } else {groceryList.add(urun);
            System.out.println(urun +" listeye eklendi.");}
        }
        printSorted();
    };

    public static void removeItems(String cıkarılacakUrunler){
        String [] cıkacakUrun = cıkarılacakUrunler.split(",");
        for (String urun: cıkacakUrun){
            if(checkItemIsInList(urun)){groceryList.remove(urun);
                System.out.println(urun + " listeden çıkarıldı.");} else {
                System.out.println("Çıkartmak istediğiniz ürün listede yok.");
            }
        }
        printSorted();
    }

    public static void startGrocery(){
    Scanner sc = new Scanner(System.in);
    boolean devam = true;
        System.out.println("Alışveriş listesine hoşgeldiniz.");
        while (devam){
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

                    String eklenecekUrunler = sc.nextLine();
                    addItems(eklenecekUrunler);

                    break;
                case 2:
                    printSorted();
                    System.out.println("Lütfen eklemek istediğiniz ürün veya ürünleri aralarında virgül olacak şekilde yazınız.");

                    String cıkarılacakUrunler = sc.nextLine();
                    removeItems(cıkarılacakUrunler);

                    break;



                default:
                    System.out.println("Lütfen geçerli bir seçim yapınız");
            }
        }
       sc.close();
    }

}
