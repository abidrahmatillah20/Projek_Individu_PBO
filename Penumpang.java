public class Penumpang {
    private int id;
    private int umur;
    private boolean hamil;
    private int saldo;

    public Penumpang(int id, int umur, boolean hamil) {
        this.id = id;
        this.umur = umur;
        this.hamil = hamil;
        this.saldo = 10000;
    }

    public int getID() { return id; }
    public int getUmur() { return umur; }
    public boolean getHamil() { return hamil; }
    public int getSaldo() { return saldo; }
