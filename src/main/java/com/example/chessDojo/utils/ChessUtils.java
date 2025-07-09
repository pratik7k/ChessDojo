package com.example.chessDojo.utils;

import com.github.bhlangonijr.chesslib.*;
import com.github.bhlangonijr.chesslib.move.*;
//import com.github.bhlangonijr.chesslib.game.SanUtils;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

public class ChessUtils {

    @Getter
    public static class MoveResult {
        public boolean legal;
        public String san;
        public String uci;
        public String fen;
        public String lastMove;
        public String wc;
        public String bc;
        public int turns;

    }

//    public static MoveResult applyMove(String fen, String uciMove) {
//        MoveResult result = new MoveResult();
//
//        Board board = new Board();
//        board.loadFromFen(fen);
//
//        Square from = Square.valueOf(uciMove.substring(0, 2).toUpperCase());
//        Square to = Square.valueOf(uciMove.substring(2, 4).toUpperCase());
//
//        Move move = new Move(from, to);
//
//        List<Move> legalMoves = board.legalMoves();
//
//        if (!legalMoves.contains(move)) {
//            result.legal = false;
//            return result;
//        }

//        result.legal = true;
//
//        // Get SAN before applying move
////        result.san = SanUtils.getSan(board, move);
//        result.uci = uciMove;
//        result.lastMove = uciMove;
//
//        board.doMove(move);
//
//        result.fen = board.getFen();
//        result.turns = board.getHalfMoveCounter(); // OR calculate full move number manually
//
//        result.wc = getCastlingRights(board, Side.WHITE);
//        result.bc = getCastlingRights(board, Side.BLACK);
//
//        return result;
//    }

//    private static String getCastlingRights(Board board, Side side) {
//        List<CastlingRight> rights = board.getCastlingRights();
//
//        return rights.stream()
//                .filter(r -> r.getSide() == side)
//                .map(r -> {
//                    if (r == CastlingRight.KING_SIDE) return side == Side.WHITE ? "h1" : "h8";
//                    else return side == Side.WHITE ? "a1" : "a8";
//                })
//                .collect(Collectors.joining());
//    }
}
