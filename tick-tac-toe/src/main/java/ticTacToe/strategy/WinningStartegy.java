package ticTacToe.strategy;

import ticTacToe.model.Board;
import ticTacToe.model.Move;

public interface WinningStartegy {
  boolean checkWinner(Board board, Move move);
}
