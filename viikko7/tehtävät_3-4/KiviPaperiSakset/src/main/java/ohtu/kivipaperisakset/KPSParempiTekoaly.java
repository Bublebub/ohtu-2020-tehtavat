package ohtu.kivipaperisakset;

public class KPSParempiTekoaly extends KPSPeli {
    
    KPSParempiTekoaly() {
        super(new Tuomari(), new TekoalyParannettu(20));
    }
    
}