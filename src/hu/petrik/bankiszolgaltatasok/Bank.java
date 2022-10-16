package hu.petrik.bankiszolgaltatasok;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Szamla> szamlaLista = new ArrayList<>();

    public Szamla szamlanyitas(Tulajdonos tulajdonos, int hitelKeret){
        if(hitelKeret > 0){
            HitelSzamla ujhitel = new HitelSzamla(tulajdonos, hitelKeret);
            szamlaLista.add(ujhitel);
            return ujhitel;
        }
        else if(hitelKeret == 0){
            MegtakaritasiSzamla ujmegtakaritas = new MegtakaritasiSzamla(tulajdonos);
            szamlaLista.add(ujmegtakaritas);
            return ujmegtakaritas;
        }
        else{
            throw new IllegalArgumentException("Érvénytelen hitelkeret, a szám nem lehet kisebb mint 0");
        }
    }

    public int getOsszEgyenleg(Tulajdonos tulajdonos){
        int sum = 0;
        for (int i = 0; i < szamlaLista.size(); i++) {
            if(szamlaLista.get(i).getTulajdonos() == tulajdonos){
               sum += szamlaLista.get(i).aktualisEgyenleg;
            }
        }
        return sum;
    }

    private Szamla getLegnagyobbEgyenleguSzamla(Tulajdonos tulajdonos){
        int max = 0;
        int index = 0;
        for (int i = 0; i < szamlaLista.size(); i++) {
            if(szamlaLista.get(i).aktualisEgyenleg > max){
                max = szamlaLista.get(i).aktualisEgyenleg;
                index = i;
            }
        }
        return szamlaLista.get(index);
    }

    public long getOsszHitelkeret(){
        int sum = 0;
        for (int i = 0; i < szamlaLista.size(); i++) {
            if(szamlaLista.get(i) instanceof HitelSzamla){
                sum = sum + ((HitelSzamla) szamlaLista.get(i)).getHitelkeret();
            }
        }
        return sum;
    }
}
