
package ohtu.verkkokauppa;

import java.util.ArrayList;

public interface Accounting {

    ArrayList<String> getTapahtumat();

    void lisaaTapahtuma(String tapahtuma);
    
}
