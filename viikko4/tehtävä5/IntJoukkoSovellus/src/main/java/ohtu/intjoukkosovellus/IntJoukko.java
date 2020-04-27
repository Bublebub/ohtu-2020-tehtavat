
package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] lukujoukko;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        lukujoukko = new int[KAPASITEETTI];
        for (int i = 0; i < lukujoukko.length; i++) {
            lukujoukko[i] = 0;
        }
        alkioidenLkm = 0;
        this.kasvatuskoko = OLETUSKASVATUS;
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            return;
        }
        lukujoukko = new int[kapasiteetti];
        for (int i = 0; i < lukujoukko.length; i++) {
            lukujoukko[i] = 0;
        }
        alkioidenLkm = 0;
        this.kasvatuskoko = OLETUSKASVATUS;
    }
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti väärin");//heitin vaan jotain :D
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("kapasiteetti2");//heitin vaan jotain :D
        }
        lukujoukko = new int[kapasiteetti];
        for (int i = 0; i < lukujoukko.length; i++) {
            lukujoukko[i] = 0;
        }
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;

    }

    public boolean lisaaLukuJoukkoon(int luku) {

        if (alkioidenLkm == 0) {
            lukujoukko[0] = luku;
            alkioidenLkm++;
            return true;
        }
        
        if (!onkoLukuJoukossa(luku)) {
            lukujoukko[alkioidenLkm] = luku;
            alkioidenLkm++;
            if (alkioidenLkm % lukujoukko.length == 0) {
                int[] apuTaulukko = lukujoukko;
                kopioiTaulukko(lukujoukko, apuTaulukko);
                lukujoukko = new int[alkioidenLkm + kasvatuskoko];
                kopioiTaulukko(apuTaulukko, lukujoukko);
            }
            return true;
        }
        return false;
    }

    public boolean onkoLukuJoukossa(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == lukujoukko[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean poistaLukuJoukosta(int luku) {
        int indeksi = -1;
        int apumuuttuja;
        
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == lukujoukko[i]) {
                indeksi = i; //siis luku löytyy tuosta kohdasta :D
                lukujoukko[indeksi] = 0;
                break;
            }
        }
        if (indeksi != -1) {
            for (int j = indeksi; j < alkioidenLkm - 1; j++) {
                apumuuttuja = lukujoukko[j];
                lukujoukko[j] = lukujoukko[j + 1];
                lukujoukko[j + 1] = apumuuttuja;
            }
            alkioidenLkm--;
            return true;
        }


        return false;
    }

    private void kopioiTaulukko(int[] vanhaTaulukko, int[] uusiTaulukko) {
        for (int i = 0; i < vanhaTaulukko.length; i++) {
            uusiTaulukko[i] = vanhaTaulukko[i];
        }
    }

    public static IntJoukko yhdiste(IntJoukko ensimmainenJoukko, IntJoukko toinenJoukko) {
        return joukkoOperaatio(ensimmainenJoukko, toinenJoukko, "yhdiste");
    }
    
    public static IntJoukko erotus ( IntJoukko ensimmainenJoukko, IntJoukko toinenJoukko) {
        return joukkoOperaatio(ensimmainenJoukko, toinenJoukko, "erotus");
    }
    
    public static IntJoukko leikkaus(IntJoukko ensimmainenJoukko, IntJoukko toinenJoukko) {
        return joukkoOperaatio(ensimmainenJoukko, toinenJoukko, "leikkaus");
    }
    
    private static IntJoukko joukkoOperaatio(IntJoukko ensimmainenJoukko, IntJoukko toinenJoukko, String operaatio) {
        IntJoukko tulosJoukko = new IntJoukko();
        int[] ensimmainenTaulukko = ensimmainenJoukko.toIntArray();
        int[] toinenTaulukko = toinenJoukko.toIntArray();
        
        //Valitaan erotus, yhdiste tai leikkaus
        if (operaatio.equals("erotus") || operaatio.equals("yhdiste")) {
            for (int i = 0; i < ensimmainenTaulukko.length; i++) tulosJoukko.lisaaLukuJoukkoon(ensimmainenTaulukko[i]);
            
            if (operaatio.equals("erotus")) {
                for (int i = 0; i < toinenTaulukko.length; i++) tulosJoukko.poistaLukuJoukosta(toinenTaulukko[i]);
            } else {
                for (int i = 0; i < toinenTaulukko.length; i++) tulosJoukko.lisaaLukuJoukkoon(toinenTaulukko[i]);
            }
        } else if (operaatio.equals("leikkaus")) {
            for (int i = 0; i < ensimmainenTaulukko.length; i++) {
                for (int j = 0; j < toinenTaulukko.length; j++) {
                    if (ensimmainenTaulukko[i] == toinenTaulukko[j]) tulosJoukko.lisaaLukuJoukkoon(toinenTaulukko[j]);
                }   
            }
        }
        return tulosJoukko;
    }
    
    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        } else if (alkioidenLkm == 1) {
            return "{" + lukujoukko[0] + "}";
        } else {
            String tuloste = "{";
            for (int i = 0; i < alkioidenLkm - 1; i++) {
                tuloste += lukujoukko[i];
                tuloste += ", ";
            }
            tuloste += lukujoukko[alkioidenLkm - 1];
            tuloste += "}";
            return tuloste;
        }
    }

    public int[] toIntArray() {
        int[] taulukko = new int[alkioidenLkm];
        for (int i = 0; i < taulukko.length; i++) {
            taulukko[i] = lukujoukko[i];
        }
        return taulukko;
    }
    
    public int getAlkioidenLkm() {
        return alkioidenLkm;
    }
}
