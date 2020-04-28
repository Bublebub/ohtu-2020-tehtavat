
package laskin;

import javafx.scene.control.TextField;

public class Summa extends Komento {

    TextField tuloskentta;
    TextField syotekentta;
    Sovelluslogiikka sovellus;
    
    int syote, tulos;
    
    public Summa(TextField tuloskentta, TextField syotekentta, Sovelluslogiikka sovellus) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.sovellus = sovellus;
    }
    
    @Override
    public void suorita() {
        syote = Integer.parseInt(syotekentta.getText());
        
        sovellus.plus(syote);
        
        tulos = sovellus.tulos();
        
        tuloskentta.setText(Integer.toString(tulos));
    }

    @Override
    public void peru() {
        sovellus.miinus(syote);
        
        tulos = sovellus.tulos();
        
        tuloskentta.setText(Integer.toString(tulos));
    }
    
}
