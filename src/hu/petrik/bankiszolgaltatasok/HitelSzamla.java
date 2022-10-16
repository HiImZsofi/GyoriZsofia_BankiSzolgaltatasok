package hu.petrik.bankiszolgaltatasok;

public class HitelSzamla extends Szamla{
    private int hitelkeret;

    public HitelSzamla(Tulajdonos tulajdonos, int hitelkeret) {
        super(tulajdonos);
        this.hitelkeret = hitelkeret;
    }

    public int getHitelkeret() {
        return hitelkeret;
    }

    public boolean kivesz(int osszeg){
        if(this.hitelkeret + this.aktualisEgyenleg >= osszeg){
            this.aktualisEgyenleg = this.aktualisEgyenleg - osszeg;
            return true;
        }
        else{
            return false;
        }
    }
}
