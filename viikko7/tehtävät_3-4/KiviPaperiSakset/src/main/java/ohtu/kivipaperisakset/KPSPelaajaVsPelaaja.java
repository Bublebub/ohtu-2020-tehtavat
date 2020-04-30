package ohtu.kivipaperisakset;

public class KPSPelaajaVsPelaaja extends KPSPeli {

    KPSPelaajaVsPelaaja() {
        super();
    }
    
    @Override
    protected String toisenPelaajanSiirto() {
        System.out.print("Toisen pelaajan siirto: ");
        String tokanSiirto = super.getScanner().nextLine();
        
        return tokanSiirto;
    }
    
    @Override
    protected void tekoalynSiirto(String ekanSiirto){
        //Ei tarvita kaksinpelissa, joten ylikirjoitetaan
    }

}