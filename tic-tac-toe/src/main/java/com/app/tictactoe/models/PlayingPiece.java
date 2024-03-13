package com.app.tictactoe.models;

import com.app.tictactoe.enums.PieceType;

public class PlayingPiece {
    PieceType pieceType;

    public PlayingPiece(PieceType pieceType) {
        this.pieceType = pieceType;
    }

    public PieceType getPieceType() {
        return pieceType;
    }
}
