
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

        for (int i = 0; i < berdiri.length; i++) {
            if (berdiri[i] == null) {
                berdiri[i] = p;
                p.kurangiSaldo(ONGKOS);
                pendapatan += ONGKOS;
                return true;
            }
        }

        return false;
    }

    public boolean turunkanPenumpang(int id) {
        for (int i = 0; i < biasa.length; i++)
            if (biasa[i] != null && biasa[i].getID() == id) { biasa[i] = null; return true; }

        for (int i = 0; i < prioritas.length; i++)
            if (prioritas[i] != null && prioritas[i].getID() == id) { prioritas[i] = null; return true; }

        for (int i = 0; i < berdiri.length; i++)
            if (berdiri[i] != null && berdiri[i].getID() == id) { berdiri[i] = null; return true; }

        return false;
    }

    private String list(Penumpang[] arr) {
        String s = "";
        for (Penumpang p : arr) if (p != null) s += p + ", ";
        if (s.equals("")) return "<kosong>";
        return s.substring(0, s.length() - 2);
    }

    public String toString() {
        return  "Biasa      : " + list(biasa) + "\n" +
                "Prioritas  : " + list(prioritas) + "\n" +
                "Berdiri    : " + list(berdiri) + "\n" +
                "Pendapatan : " + pendapatan + "\n";
    }
}
