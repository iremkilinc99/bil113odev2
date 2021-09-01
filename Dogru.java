public class Dogru {
    double egim;
    double c;
    String dogru;

    public Dogru() {}

    public Dogru(String s) {
        String line =replaceSpaces(s);
        findSlopeAnC(line);
    }

    public String replaceSpaces(String s){
        String newLine = "";
        for (int i = 0; i < s.length(); i++)
            if(s.charAt(i) != ' ')
                newLine += s.charAt(i);

        return dogru = newLine;
    }

    public void findSlopeAnC(String line) {
        int indexOfX = line.indexOf('x');
        String beforeX = line.substring(0, indexOfX);
        String afterX = line.substring(indexOfX + 1);
        String cVlalue = "", mValueOfX = "";
        double deger = 1, m = 0;

        if(line.indexOf('y') < indexOfX)  beforeX = beforeX.substring(line.indexOf('y')+1);

        for (int i = beforeX.length() - 1; 0 <= i; i--) {
            if (48 <= beforeX.charAt(i) && beforeX.charAt(i) < 58)// rakamlarin ascii degerleriyle karsilastiriyorum
                mValueOfX = beforeX.charAt(i) + mValueOfX;
        }

        if( mValueOfX == "") mValueOfX ="1";

        for (int i = mValueOfX.length()-1 ; 0 <= i; i--) {
            if (i != mValueOfX.length() - 1) {
                for (int j = 0; j < mValueOfX.length() - i -1 ; j++)
                    deger *= 10;

                m += (mValueOfX.charAt(i) - '0') * deger;
            } else
                m += (mValueOfX.charAt(i) - '0');
        }

        deger = 1;
        egim = m;

        boolean pos = true;
        if(line.indexOf('y') > indexOfX) {
            for (int i = 0; i < beforeX.length(); i++)
                if (48 < beforeX.charAt(i) && beforeX.charAt(i) < 58)// rakamlarin ascii degerleriyle karsilastiriyorum
                    cVlalue += beforeX.charAt(i);
                else
                    if(beforeX.charAt(i) == '-')
                        pos = false;

        }else {
            for (int i = 0; i < afterX.length(); i++) {
                if (48 < afterX.charAt(i) && afterX.charAt(i) < 58)// rakamlarin ascii degerleriyle karsilastiriyorum
                    cVlalue += afterX.charAt(i);
                else
                    if(afterX.charAt(i) == '-')
                        pos = false;

            }
        }

        for (int i = cVlalue.length()-1 ; 0 <= i; i--){
            if(i != cVlalue.length()-1 ) {
                for(int j = 0; j < cVlalue.length() - i -1; j++)
                   deger *= 10 ;

                c += (cVlalue.charAt(i) - '0') * deger;
            }else
                c += (cVlalue.charAt(i) -'0');
        }

        if(!pos) c *= -1;
    }

    public void setEgim(double yeniEgim) {
        egim = yeniEgim;
    }

    public void setC(double yeniC) {
        c = yeniC;
    }

    public void setDogru(double yeniEgim, double yeniC) {
        egim = yeniEgim;
        c = yeniC;
    }

    public void set(String s) {
        String line =replaceSpaces(s);
        findSlopeAnC(line);
    }

    public double getEgim() {
        return egim;
    }

    public double getC() {
        return c;
    }

    public boolean paralelMi(Dogru dogruNesnesi) {
        if(egim != dogruNesnesi.egim) return false;
        return true;
    }

    public double karekok(double sayi) {
        double result;
        double squareRoot = sayi / 2;
        do {
            result = squareRoot;
            squareRoot = (result + (sayi / result)) / 2;
        } while ((result - squareRoot) != 0);

        return squareRoot;
    }

    public double uzaklik(Dogru dogruNesnesi) {
        double result1, result2;
        int result3;

        if(dogruNesnesi.c > c) {
            result1 = (dogruNesnesi.c - c) / karekok(1 + egim * egim);
            result3 = (int) result1;
            result2 = (result1 - result3) * 1000;
            result3 = (int) result2;
            result2 = result2 - result3;
            result1 = result1 - result2/1000;
            return result1;
        }else{
            result1 = (c - dogruNesnesi.c) / karekok(1 + egim * egim);
            result3 = (int) result1;
            result2 = (result1 - result3) * 1000;
            result3 = (int) result2;
            result2 = result2 - result3;
            result1 = result1 - result2/1000;
            return result1;
        }
    }
}
