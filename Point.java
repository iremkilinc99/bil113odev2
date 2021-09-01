public class Point {
    int x, y;
    String points;

    public Point() {}
    public Point( String s) {
        points = replaceSpaces(s);
        setPoints(points);
    }

    public String replaceSpaces(String s){
        String newLine = "";
        for (int i = 0; i < s.length(); i++)
            if(s.charAt(i) != ' ')
                newLine += s.charAt(i);

        return points = newLine;
    }

    public void set(String s) {
        points = replaceSpaces(s);
        setPoints(points);
    }

    public void setPoints(String newPoints){
        int indexComma = 0, deger = 1;
        double xValue, yValue;

        for (int i = 0; i < newPoints.length(); i++) {
            if (newPoints.charAt(i) == ',') {
                indexComma = i;
                break;
            }
        }

        String X = newPoints.substring(0, indexComma);
        String Y = newPoints.substring(indexComma+1);

        for (int i = X.length()-1 ; 0 <= i; i--) {
            if(i !=  X.length()-1) {
                for (int j = 0; j < X.length() - i -1 ; j++)
                    deger *= 10;

                x += (X.charAt(i) - '0') * deger;
            }else
                x += (X.charAt(i) - '0');
        }

        deger = 1;

        for (int i = Y.length()-1 ; 0 <= i; i--) {
            if(i !=  Y.length()-1) {
                for (int j = 0; j < Y.length() - i -1 ; j++)
                    deger *= 10;

                y += (Y.charAt(i) - '0') * deger;
            }else
                y += (Y.charAt(i) - '0');
        }
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

    public double uzaklik(Line line) {
        double result1, result2;
        int result3;

        if ((line.x * x + line.y * y + line.c) < 0) {
            result1 = -1 * (line.x * x + line.y * y + line.c) / karekok(line.x * line.x + line.y * line.y);
            result3 = (int) result1;
            result2 = (result1 - result3) * 1000;
            result3 = (int) result2;
            result2 = result2 - result3; // silinecek virgul kismi
            result1 = result1 - result2/1000;
            return result1;
        } else {
            result1 = (line.x * x + line.y * y + line.c) / karekok(line.x * line.x + line.y * line.y);
            result3 = (int) result1;
            result2 = (result1 - result3) * 1000;
            result3 = (int) result2;
            result2 = result2 - result3; // silinecek virgul kismi
            result1 = result1 - result2/1000;
            return result1;
        }
    }
    public String writeOutput() {
         return "x=" + x +", y=" + y;
    }
}
