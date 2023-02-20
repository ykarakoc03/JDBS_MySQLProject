package Telefon_Rehberi;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<kayitSinifi> telList = new ArrayList<>();
    static kayitSinifi kayit;
    static DBaseHelper db = new DBaseHelper();
    static Scanner scan = new Scanner(System.in);
    static Scanner scanNL = new Scanner(System.in);

    public static void main(String[] args) {
        telList = db.listData();
        //  telList = db.listDataWithRowSet();
        menu();
    }

    private static void menu() {
        System.out.println("\n\n\n\n-------------------");
        System.out.println("1 - List Records");
        System.out.println("2 - Delete Record  ");
        System.out.println("3 - UpDate Record  ");
        System.out.println("4 - Add new Record ");
        System.out.println("X - Exit");
        System.out.println("-------------------");
        System.out.print("\n" + "Seçiminiz : ");
        String secim = scan.next();
        switch (secim.toUpperCase()) {
            case "1":
                listing();
                break;
            case "2":
                deleting();
                break;
            case "3":
                upDating();
                break;
            case "4":
                adding();
                break;
            case "X": /*System.exit(0); */
                break;
            default:
                System.out.println("Hatalı giriş");
                break;
        }
        if (!secim.equalsIgnoreCase("x")) menu();
    }

    private static void adding() {
        System.out.println("-- Ekleme --");
        kayit = new kayitSinifi();
        System.out.print("Isim   : ");
        kayit.setIsim(scanNL.nextLine());
        System.out.print("Tel No : ");
        kayit.setTel(scanNL.nextLine());
        db.addData(kayit);

        kayit.id = db.getLastIndex();
        telList.add(kayit);
        // telList = db.listData(); // ustekı ıkı satır yerıne
    }

    private static void upDating() {
        System.out.println("-- Değiştirme --");
        System.out.println("-1 : Vazgeç");
        System.out.print("Kayıt ID? : ");
        int id = scan.nextInt();
        if (id == -1) return;
        boolean idInclude = false;
        int index = -1;
        kayit = new kayitSinifi();
        for (int i = 0; i < telList.size(); i++) {
            if (telList.get(i).getId() == id) {
                idInclude = true;
                kayit = telList.get(i);
                index = i;
            }

        }
        if (idInclude) {
            System.out.println("güncellemek istemediğiniz alana x yazarak entere basın");
            System.out.print("Yeni isim   : ");
            String isim = scanNL.nextLine();
            System.out.print("Yeni Tel no : ");
            String tel = scanNL.nextLine();
            int id2 = kayit.getId();
            if (isim.equalsIgnoreCase("x")) isim = kayit.getIsim();
            if (tel.equalsIgnoreCase("x")) tel = kayit.getTel();
            System.out.printf("%27s\t\t\t--> %25s\n", "Eski Kayıt ", "Yeni Kayıt");
            System.out.printf("%27s\t\t\t    %25s\n", "---------- ", "----------");
            System.out.printf("%20s%15s --> %20s%15s\n", kayit.getIsim(), kayit.getTel(), isim, tel);
            System.out.print("Kayıt yukarıdaki şekilde güncelenecektir onaylıyor musunuz(E:Evet)");
            String secim = scan.next();
            kayit = new kayitSinifi();
            kayit.setId(id2);
            kayit.setIsim(isim);
            kayit.setTel(tel);
            if (secim.equalsIgnoreCase("E")) {
                telList.set(index, kayit);
                db.upDateData(kayit);
            } else System.out.println("Güncelleme iptal edildi");
        } else {
            System.out.println("ID bulunamadı");
        }
    }

    private static void deleting() {
        System.out.println("-- Silme --");
        System.out.println("X : Vazgeç");
        System.out.print("Kayıt ID? : ");
        int id = scan.nextInt();
        boolean idInclude = false;
        int index = -1;
        kayit = new kayitSinifi();
        for (int i = 0; i < telList.size(); i++) {
            if (telList.get(i).getId() == id) {
                idInclude = true;
                kayit = telList.get(i);
                index = i;
            }

        }
        if (idInclude) {
            System.out.printf("%5d%20s%15s%n", kayit.getId(), kayit.getIsim(), kayit.getTel());
            System.out.print("Yukarıdaki kayıt silinecektir onaylıyor musunuz(E:Evet)");
            String secim = scan.next();

            if (secim.equalsIgnoreCase("E")) {
                telList.remove(index);
                db.deleteData(kayit.getId());
            } else System.out.println("Silme iptal edildi");
        } else {
            System.out.println("ID bulunamadı");
        }
    }

    private static void listing() {
        clearScreen();
        System.out.printf("%4S%20S%17S\n", "id", "isim soyisim", "telefon no");
        System.out.printf("%4S%20S%17S\n", "--", "------------", "------------");
        for (int i = 0; i < telList.size(); i++) {
            System.out.printf("%4d%20s%17s\n", telList.get(i).getId(), telList.get(i).getIsim(), telList.get(i).getTel());

        }
        if (telList.size() == 0) System.out.println("Gösterilebilecek kayıt bulunamadı");
    }

    private static void clearScreen() {
        System.out.printf("%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n");
    }
}
