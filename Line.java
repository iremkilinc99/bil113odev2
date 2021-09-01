public class Line {
        int x,y,c;
        String dogru;

        public Line() {}

        public Line( String s) {
            dogru = replaceSpaces(s);
            findSlopeAnC(dogru);
        }

        public String replaceSpaces(String s){
            String newLine = "";
            for (int i = 0; i < s.length(); i++)
                if(s.charAt(i) != ' ')
                    newLine += s.charAt(i);

            return dogru = newLine;
        }

        public void findSlopeAnC(String line) {
            String part1 = "", part2 = "", part3 = "";
            int  operator = 0, indexOperator = 0;

            for (int i = 0; i < line.length(); i++) {
                if((line.charAt(i) == '+' || line.charAt(i) == '-') && operator == 0 && i!= 0 ) {
                    part1 = line.substring(0, i);
                    indexOperator = i;
                    operator++;
                }
                else if((line.charAt(i) == '+' || line.charAt(i) == '-') && operator == 1) {
                    part2 = line.substring(indexOperator, i);
                    part3 = line.substring(i);
                    break;
                }
            }

            boolean notIn = true;
            for (int i = 0; i < part1.length(); i++) {
                if(part1.charAt(i) == 'x'){
                    findX(part1);
                    notIn = false;
                    break;
                }

                if(part1.charAt(i) == 'y') {
                    findY(part1);
                    notIn = false;
                    break;
                }
            }

            if(notIn) findC(part1);
            notIn = true;

            for (int i = 0; i < part2.length(); i++) {
                if(part2.charAt(i) == 'x') {
                    findX(part2);
                    notIn = false;
                    break;
                }

                if(part2.charAt(i) == 'y') {
                    findY(part2);
                    notIn = false;
                    break;
                }

            }

            if(notIn) findC(part2);
            notIn = true;

            for (int i = 0; i < part3.length(); i++) {
                if(part3.charAt(i) == 'x') {
                    findX(part3);
                    notIn = false;
                    break;
                }

                if(part3.charAt(i) == 'y') {
                    findY(part3);
                    notIn = false;
                    break;
                }

            }

            if(notIn) findC(part3);
        }

        public void findX(String X) {
            String valueOfX = "";
            int deger  = 1;
            boolean pos = true;

            for (int i = X.length() - 1; 0 <= i; i--) {
                if (48 <= X.charAt(i) && X.charAt(i) < 58)// rakamlarin ascii degerleriyle karsilastiriyorum
                    valueOfX = X.charAt(i) + valueOfX;

                if(X.charAt(i) == '-') pos = false;
            }

            if( valueOfX == "") valueOfX ="1";

            for (int i = valueOfX.length()-1 ; 0 <= i; i--) {
                if (i != valueOfX.length() - 1) {
                    for (int j = 0; j < valueOfX.length() - i -1 ; j++)
                        deger *= 10;

                    x += (valueOfX.charAt(i) - '0') * deger;
                } else
                    x += (valueOfX.charAt(i) - '0');
            }

            if(!pos) x *= -1;
        }

        public void findY(String Y) {
            String valueOfY = "";
            int deger  = 1;
            boolean pos = true;

            for (int i = Y.length() - 1; 0 <= i; i--) {
                if (48 <= Y.charAt(i) && Y.charAt(i) < 58)// rakamlarin ascii degerleriyle karsilastiriyorum
                    valueOfY = Y.charAt(i) + valueOfY;

                if(Y.charAt(i) == '-') pos = false;
            }

            if( valueOfY == "") valueOfY ="1";

            for (int i = valueOfY.length()-1 ; 0 <= i; i--) {
                if (i != valueOfY.length() - 1) {
                    for (int j = 0; j < valueOfY.length() - i -1 ; j++)
                        deger *= 10;

                    y += (valueOfY.charAt(i) - '0') * deger;
                } else
                    y += (valueOfY.charAt(i) - '0');
            }

            if(!pos) y *= -1;
       }

        public void findC(String C) {
            String valueOfC = "";
            int deger  = 1;
            boolean pos = true;

            for (int i = C.length() - 1; 0 <= i; i--) {
                if (48 <= C.charAt(i) && C.charAt(i) < 58)// rakamlarin ascii degerleriyle karsilastiriyorum
                    valueOfC = C.charAt(i) + valueOfC;

                if(C.charAt(i) == '-') pos = false;
            }

            for (int i = valueOfC.length()-1 ; 0 <= i; i--) {
                if (i != valueOfC.length() - 1) {
                    for (int j = 0; j < valueOfC.length() - i -1 ; j++)
                        deger *= 10;

                    c += (valueOfC.charAt(i) - '0') * deger;
                } else
                    c += (valueOfC.charAt(i) - '0');
            }

            if(!pos) c *= -1;
       }

        public void set(String line) {
            x = y = c = 0 ;
            dogru = replaceSpaces(line);
            findSlopeAnC(dogru);
        }

        public void setX(int newX) {
            x = newX;
        }

        public double getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void setY(int newY) {
            y = newY;
        }

        public void setC(int yeniC) {
            c = yeniC;
        }

        public int getC() {
            return c;
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

        public double uzaklik(Point point) {
            double result1, result2;
            int result3;

            if ((point.x * x + point.y * y + c) < 0) {
                result1 = -1 * (point.x * x + point.y * y + c) / karekok(x * x + y * y);
                result3 = (int) result1;
                result2 = (result1 - result3) * 1000;
                result3 = (int) result2;
                result2 = result2 - result3; // silinecek virgul kismi
                result1 = result1 - result2/1000;
                return result1;
            }else{
                result1 =(point.x * x + point.y * y + c) / karekok(x * x + y * y);
                result3 = (int) result1;
                result2 = (result1 - result3)*1000;
                result3 = (int) result2;
                result2 = result2 - result3; // silinecek virgul kismi
                result1 = result1 - result2/1000;
                return result1;
            }
        }

        public String writeOutput() {
            if(c >= 0 && y > 0)
                return x +"x+" + y +"y+" + c;
            else if(y >= 0)
                return x +"x+" + y +"y" + c;
            else if( c >= 0)
                return x +"x" + y +"y+" + c;
            else
                return x +"x" + y +"y" + c;
    }
}
