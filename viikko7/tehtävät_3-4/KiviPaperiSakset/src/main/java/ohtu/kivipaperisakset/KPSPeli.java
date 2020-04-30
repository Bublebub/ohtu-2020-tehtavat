
package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSPeli {
    
    private static final Scanner scanner = new Scanner(System.in);
    
    private final Tuomari tuomari;
    private final Tekoaly tekoaly;
    
    //---------------------Konstruktorit----------------------------------------
    
    public KPSPeli() {
        tuomari = new Tuomari();
        tekoaly = new Tekoaly();
    }
    
    public KPSPeli (Tuomari tuomari, Tekoaly tekoaly) {
        this.tuomari = tuomari;
        this.tekoaly = tekoaly;
    }
    
    //---------------------Pelimoodit-------------------------------------------
    
    public static KPSPeli luoKPSParempiTekoaly() {
        return new KPSParempiTekoaly();
    }
    
    public static KPSPeli luoKPSTekoaly() {
        return new KPSTekoaly();
    }
    
    public static KPSPeli luoKPSPelaajaVsPelaaja() {
        return new KPSPelaajaVsPelaaja();
    }
    
    //---------------------Pelilogiikka-----------------------------------------
    
    public void pelaa() {
        System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
        System.out.print("Ensimmäisen pelaajan siirto: ");
        String ekanSiirto = scanner.nextLine();
        String tokanSiirto;

        tokanSiirto = toisenPelaajanSiirto();

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();

            System.out.print("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = scanner.nextLine();

            tokanSiirto = toisenPelaajanSiirto();
            tekoalynSiirto(ekanSiirto);
        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }
    
    //---------------------Siirto-metodit---------------------------------------
    
    protected String toisenPelaajanSiirto() {
        String tokanSiirto = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + tokanSiirto);
        
        return tokanSiirto;
    }
    
    protected void tekoalynSiirto(String ekanSiirto) {
        tekoaly.asetaSiirto(ekanSiirto);
    }
    
    protected static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
    
    //---------------------Getterit---------------------------------------------
    
    protected Scanner getScanner() {
        return scanner;
    }
}
