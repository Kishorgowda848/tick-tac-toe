package ticTacToe.controller;

import java.util.List;

import ticTacToe.model.Game;
import ticTacToe.model.Player;
import ticTacToe.strategy.WinningStartegy;

public class GameController {

  public Game createGame(int boardSize, List<Player> players, List<WinningStartegy> winningStrategys) {
    return Game.getBuilder().setDimenstion(boardSize).setPlayers(players).setWinningStrategys(winningStrategys).build();
  }

  public void displayBoard(Game game) {
    game.print();
  }

  public void undo() {

  }

  public void makeMove(Game game) {
    game.makeMove();
  }
}
