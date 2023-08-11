package ticTacToe.strategy.BotPlaying;

import ticTacToe.model.Board;
import ticTacToe.model.Cell;

public interface BotPlayingStrategy {

  Cell makeMove(Board borad);
}
