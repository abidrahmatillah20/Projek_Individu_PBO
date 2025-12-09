
import java.util.Scanner;

public class TestBus {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Bus bus = new Bus();

        while (true) {
            System.out.println("========================================");
            System.out.println("         BUS TRANS KOETARADJA");
            System.out.println("========================================");
            System.out.println("1. Naikkan Penumpang");
            System.out.println("2. Turunkan Penumpang");
            System.out.println("3. Lihat Penumpang");
            System.out.println("4. Keluar");
            System.out.println("----------------------------------------");
            System.out.print("Pilihan Anda : ");
            int p = in.nextInt();

            if (p == 1) {
                System.out.println("\nMasukkan data penumpang:");
                System.out.println("Format → ID Umur Hamil[y/n]");
                System.out.print("Input  : ");

                int id = in.nextInt();
                int umur = in.nextInt();
                String h = in.next();
                boolean hamil = h.equalsIgnoreCase("y");

                Penumpang pen = new Penumpang(id, umur, hamil);

                if (bus.naikkanPenumpang(pen)) {
                    System.out.println("✔ Penumpang ID " + pen.getID() + " berhasil naik!");
                } else {
                    System.out.println("✘ Gagal naik! Bus penuh atau saldo tidak cukup.");
                }
                System.out.println();
            }

            else if (p == 2) {
                System.out.print("\nMasukkan ID penumpang yang turun: ");
                int id = in.nextInt();

                if (bus.turunkanPenumpang(id)) {
                    System.out.println("✔ Penumpang berhasil turun.");
                } else {
                    System.out.println("✘ ID tidak ditemukan.");
                }
                System.out.println();
            }

            else if (p == 3) {
                System.out.println("\n========================================");
                System.out.println("           DAFTAR PENUMPANG");
                System.out.println("========================================");
                System.out.println(bus);
                System.out.println("========================================\n");
            }

            else if (p == 4) {
                System.out.println("\nTerima kasih telah menggunakan sistem bus.");
                break;
            }

            else {
                System.out.println("\n✘ Pilihan tidak valid!\n");
            }
        }
    }
}
