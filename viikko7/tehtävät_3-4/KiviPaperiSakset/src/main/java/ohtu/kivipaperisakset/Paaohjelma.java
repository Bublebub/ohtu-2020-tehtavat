package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Paaohjelma {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetetaan");

            String vastaus = scanner.nextLine();
            if (vastaus.endsWith("a")) {
                KPSPeli.luoKPSPelaajaVsPelaaja().pelaa();
            } else if (vastaus.endsWith("b")) {
                KPSPeli.luoKPSTekoaly().pelaa();
            } else if (vastaus.endsWith("c")) {
                KPSPeli.luoKPSParempiTekoaly().pelaa();
            } else {
                break;
            }

        }

    }
}
