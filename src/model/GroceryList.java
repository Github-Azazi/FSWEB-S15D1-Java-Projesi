package model;

import java.util.ArrayList;
import java.util.Collections;

public class GroceryList {

    private ArrayList<String> items;

    public GroceryList() {
        this.items = new ArrayList<>();
    }

    public void addItems(String items) {
        String[] splitItems = splitItems(items);
        for (String item : splitItems) {
            String trimmedItem = item.trim();
            if (checkItemIsInList(trimmedItem)) {
                System.out.println("girilen item listede mevcut: " + item);
            } else {
                this.items.add(trimmedItem);
                sortItems();
            }
        }
    }

    private static String[] splitItems(String items) {
        String[] splitItems = items.split(",");
        return splitItems;
    }

    public void removeItems(String items) {
        String[] splitItems = splitItems(items);
        for (String item : splitItems) {
            String trimmedItem = item.trim();
            if (!checkItemIsInList(trimmedItem)) {
                System.out.println("Bu item zaten mevcut değil: " + item);
            } else {
                this.items.remove(trimmedItem);
                //sortItems();
            }
        }
    }

    public void printSorted(){
        System.out.println("Mevcut pazar listesi: ");
        for (String item : this.items){
            System.out.println(item);
        }
    }

    public boolean checkItemIsInList(String item) {
        return items.contains(item);
    }

    public void sortItems() {
        Collections.sort(this.items);
    }
}
/*
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GroceryListApp {
    public static void main(String[] args) {
        ArrayList<String> groceryList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("0: Uygulamayı durdur");
            System.out.println("1: Eleman ekle");
            System.out.println("2: Eleman çıkar");
            System.out.print("Seçiminizi yapın: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Boş satırı oku

            switch (choice) {
                case 0:
                    System.out.println("Uygulama kapatılıyor.");
                    return;
                case 1:
                    System.out.print("Eklemek istediğiniz eleman(lar)ı virgülle ayırarak girin: ");
                    String input = scanner.nextLine();
                    String[] itemsToAdd = input.split(",");
                    addItems(groceryList, itemsToAdd);
                    break;
                case 2:
                    System.out.print("Çıkarmak istediğiniz eleman(lar)ı virgülle ayırarak girin: ");
                    input = scanner.nextLine();
                    String[] itemsToRemove = input.split(",");
                    removeItems(groceryList, itemsToRemove);
                    break;
                default:
                    System.out.println("Geçersiz seçim. Lütfen 0, 1 veya 2 girin.");
            }

            // Liste her operasyon sonrasında sıralansın
            Collections.sort(groceryList);
            printSorted(groceryList);
        }
    }

    public static void addItems(ArrayList<String> list, String[] items) {
        for (String item : items) {
            if (!list.contains(item)) {
                list.add(item);
                System.out.println(item + " eklendi.");
            } else {
                System.out.println(item + " zaten listede var.");
            }
        }
    }

    public static void removeItems(ArrayList<String> list, String[] items) {
        for (String item : items) {
            if (list.contains(item)) {
                list.remove(item);
                System.out.println(item + " çıkarıldı.");
            } else {
                System.out.println(item + " listede bulunamadı.");
            }
        }
    }

    public static void printSorted(ArrayList<String> list) {
        System.out.println("Listenin güncel hali:");
        for (String item : list) {
            System.out.println(item);
        }
    }
}
*/