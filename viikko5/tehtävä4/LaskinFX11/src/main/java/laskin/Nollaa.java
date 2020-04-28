
package laskin;

import javafx.scene.control.TextField;

public class Nollaa extends Komento {

    TextField tuloskentta;
    TextField syotekentta;
    Sovelluslogiikka sovellus;
    int tulos;
    
    public Nollaa(TextField tuloskentta, TextField syotekentta, Sovelluslogiikka sovellus) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.sovellus = sovellus;
    }
    
    @Override
    public void suorita() {
        tulos = Integer.parseInt(tuloskentta.getText());
        
        sovellus.nollaa();
        
        tuloskentta.setText("0");
    }

    @Override
    public void peru() {
        sovellus.plus(tulos);
        
        tuloskentta.setText(Integer.toString(tulos));
    }
    
}
