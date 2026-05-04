public class Board {
    private String fen = "";
    private String board = "";

    Board(String fen) {
        this.fen = fen;
        parseFenFormat();
    }

    private void parseFenFormat() {
        // fen format:
        // rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1

        int firstSpace = fen.indexOf(" ");
        board = fen.substring(0, firstSpace);
        //System.out.println("Just the board: |" + board + "|");
    }

    public String getFen() {
        return fen;
    }

    public void setFen(String fen) {
        this.fen = fen;
    }

    public void print() {
        String[] chessRows = board.split("/");

        System.out.println("Printing out the board");

        for(int i = 0; i < chessRows.length; i++) {
            prettyPrintRow(chessRows[i]);
        }
    }

    private void prettyPrintRow(String chessRow) {

        char[] chessPieces = chessRow.toCharArray();
        for(int i = 0; i < chessPieces.length; i++) {
            if(Character.isDigit(chessPieces[i])) {
                prettyPrintEmptySquare(chessPieces[i]);
            } else {
                System.out.print(chessPieces[i] + " ");
            }
        }
        System.out.println();
    }

    private void prettyPrintEmptySquare(char spaces) {
        // 8
        int numSpaces = spaces - '0';
        for(int i = 0; i < numSpaces; i++) {
            System.out.print("_ ");

        }
    }
}