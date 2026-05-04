public class Main {
    public static void main(String[] args) throws Exception {
        //String fen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
        FenFileReader fenFileReader = new FenFileReader();
        String[] fens = fenFileReader.readFenFile("resources/chess_positions.fen");

        for(int i = 0; i < fens.length; i++) {
            String fen = fens[i];
            System.out.println(fen);

            Board board = new Board(fen);
            board.print();

            System.out.println("next best move is...");
            ChessApiClient chessApiClient = new ChessApiClient();
            String newFen = chessApiClient.callRestAPIForNextMove(fen);
            Board newBoard = new Board(newFen);
            newBoard.print();

            Thread.sleep(2000);


        }
    }
}



