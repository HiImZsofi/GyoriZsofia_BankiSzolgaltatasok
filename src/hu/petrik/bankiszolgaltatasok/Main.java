package hu.petrik.bankiszolgaltatasok;

public class Main {
    public static void main(String[] args) {
        Tulajdonos tulajdonos = new Tulajdonos("Gipsz Jakab");
        Szamla szamla = new MegtakaritasiSzamla(tulajdonos);
        System.out.println(tulajdonos.getNev());
        szamla.befizet(1000);
        szamla.kivesz(1000);
        System.out.println(szamla.aktualisEgyenleg);

        HitelSzamla hitel = new HitelSzamla(tulajdonos, 1000);
        System.out.println("Hitel: " + hitel.getHitelkeret());
        hitel.kivesz(100);
        System.out.println("UjHitel: " + hitel.getHitelkeret());

        MegtakaritasiSzamla megtakaritas = new MegtakaritasiSzamla(tulajdonos);
        System.out.println(megtakaritas.getKamat());
        megtakaritas.kamatJovairas();
        System.out.println("Mostani kamat: " + megtakaritas.getKamat());
        megtakaritas.setKamat(1.2);
        megtakaritas.kamatJovairas();
        System.out.println("Uj kamat: " + megtakaritas.getKamat());

        Kartya bkartya = new Kartya(tulajdonos, szamla, "1234 5678 9123 4567");
        System.out.println(bkartya.getKartyaszam());
        bkartya.vasarlas(500);
        System.out.println(szamla.getAktualisEgyenleg());

        Bank bank = new Bank();
        HitelSzamla hitel2 = (HitelSzamla) bank.szamlanyitas(tulajdonos, 1000);
        hitel2.befizet(1000);
        hitel2.kivesz(1000);
        System.out.println(bank.getOsszEgyenleg(tulajdonos));
        System.out.println(bank.getOsszHitelkeret());

    }
}
