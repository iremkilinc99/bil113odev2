public class Oyun {
    String A = "X";
    String B = "O";
    String board[][];
    int scoreA, scoreB, emptyBlock;

    public Oyun() {
        board = new String[4][4];
        emptyBlock = 16;
        setTheBoard();
    }

    public void setTheBoard() {
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++)
                board[i][j] = "#";

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++)
                System.out.print(board[i][j]);
            System.out.println();
        }
        System.out.println();
    }

    public int getEmptyBlock() {
        return emptyBlock;
    }

    public boolean playA(int positionX, int positionY){
        if(board[positionX][positionY] == "#"){
            board[positionX][positionY] = A;
            emptyBlock--;

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++)
                    System.out.print(board[i][j]);
                System.out.println();
            }
            System.out.println();
            return true;
        }else
            return false;
    }

    public boolean playB(int positionX, int positionY){
        if(board[positionX][positionY] == "#"){
            board[positionX][positionY] = B;
            emptyBlock--;

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++)
                    System.out.print(board[i][j]);
                System.out.println();
            }
            System.out.println();
            return true;
        }else
            return false;
    }

    public int checkA() {
        int currentScore = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (0 <j && j< board[i].length -1 && board[i][j-1] == "X" && board[i][j] == "X" && board[i][j +1] == "X") {
                    currentScore = 3;
                }

                if (currentScore >= 3 && 0 <= j && i < board.length -1 &&(board[i][j] == "O" || j == board[i].length -1)) {
                    for(int k = j - currentScore +1; k < j; k++)
                        if (board[i + 1][k] == "X") scoreA++;

                    if((j == board[i].length -1 && board[i][j] == "O" && board[i + 1][j-1] == "X" && scoreA >0) ||
                            (j == board[i].length -1 && board[i][j] == "X" && board[i + 1][j-2] == "X" && board[i - 1][j - 3] == "O" && scoreA >0)) scoreA--;
                }
            }
            currentScore = 0;
        }

        for (int i = board.length -1 ; 0<= i ; i--) {
            for (int j = 0; j < board[i].length; j++) {
                if (0 <j && j< board[i].length -1 && board[i][j-1] == "X" && board[i][j] == "X" && board[i][j +1] == "X") {
                    currentScore = 3;
                }

                if (currentScore >= 3 && j <= board[i].length -1 && 0 < i && (board[i][j] == "O" || j == board[i].length -1)) {
                        for(int k = j - currentScore +1; k < j; k++)
                            if (board[i - 1][k] == "X") scoreA++;

                         if((j == board[i].length -1 && board[i][j] == "O" && board[i - 1][j-1] == "X" && scoreA >0) ||
                            (j == board[i].length -1 && board[i][j] == "X" && board[i - 1][j-2] == "X"  && board[i - 1][j - 3] == "O"  && scoreA >0)) scoreA--;
                    }
                }
            currentScore = 0;
        }

        return scoreA;
    }

    public int checkB() {
        int currentScore = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (0 <j && j< board[i].length -1 && board[i][j-1] == "O" && board[i][j] == "O" && board[i][j +1] == "O") {
                    currentScore = 3;
                }

                if (currentScore >= 3 && 0 <= j && i < board.length - 1 && (board[i][j] == "X" || j == board[i].length - 1)) {
                    for (int k = j - currentScore + 1; k < j; k++)
                        if (board[i + 1][k] == "O") scoreB++;

                    if((j == board[i].length -1 && board[i][j] == "X" && board[i + 1][j-1] == "O" && scoreB >0) ||
                            (j == board[i].length -1 && board[i][j] == "O" && board[i + 1][j-2] == "O" && board[i - 1][j - 3] == "X" && scoreB >0)) scoreB--;
                }
            }
            currentScore = 0;
        }

        for (int i = board.length -1 ; 0<= i ; i--) {
            for (int j = 0; j < board[i].length; j++) {
                if (0 < j && j < board[i].length - 1 && board[i][j - 1] == "O" && board[i][j] == "O" && board[i][j + 1] == "O") {
                    currentScore = 3;
                }

                if (currentScore >= 3 && j <= board[i].length - 1 && 0 < i && (board[i][j] == "X" || j == board[i].length - 1)) {
                    for (int k = j - currentScore + 1; k < j; k++)
                        if (board[i - 1][k] == "O") scoreB++;

                    if ((j == board[i].length - 1 && board[i][j] == "X" && board[i - 1][j - 1] == "O" && scoreB > 0) ||
                            (j == board[i].length - 1 && board[i][j] == "O" && board[i - 1][j - 2] == "O" && board[i - 1][j - 3] == "X" && scoreB > 0))
                        scoreB--;
                }
            }
            currentScore = 0;
        }

        return  scoreB;
    }

}
