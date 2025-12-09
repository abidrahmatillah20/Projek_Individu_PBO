
public class Bus {
    private Penumpang[] biasa = new Penumpang[16];
    private Penumpang[] prioritas = new Penumpang[4];
    private Penumpang[] berdiri = new Penumpang[20];

    public static final int ONGKOS = 2000;
    private int pendapatan = 0;

    public boolean naikkanPenumpang(Penumpang p) {
        if (p.getSaldo() < ONGKOS) return false;

        if (p.prioritas()) {
            for (int i = 0; i < prioritas.length; i++) {
                if (prioritas[i] == null) {
                    prioritas[i] = p;
                    p.kurangiSaldo(ONGKOS);
                    pendapatan += ONGKOS;
                    return true;
                }
            }
        }

        for (int i = 0; i < biasa.length; i++) {
            if (biasa[i] == null) {
                biasa[i] = p;
                p.kurangiSaldo(ONGKOS);
                pendapatan += ONGKOS;
                return true;
            }
        }
