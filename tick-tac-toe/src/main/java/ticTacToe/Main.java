package ticTacToe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ticTacToe.controller.GameController;
import ticTacToe.model.Bot;
import ticTacToe.model.Game;
import ticTacToe.model.Player;
import ticTacToe.model.Symbole;
import ticTacToe.model.enums.GameStatus;
import ticTacToe.model.enums.PlayerType;
import ticTacToe.strategy.OneColumnWinningStartegy;
import ticTacToe.strategy.OneDiagnalWinningStartegy;
import ticTacToe.strategy.OneRowWinningStrategy;
import ticTacToe.strategy.WinningStartegy;

public class Main {

  public static void main(String[] args) {
    System.out.println("Hey It sis working");

    GameController gameContoller = new GameController();

    Scanner scanner = new Scanner(System.in);

    List<Player> players = new ArrayList<Player>();

    players.add(new Player(new Symbole('X'), "Kishore", PlayerType.HUMAN));
    players.add(new Bot(new Symbole('Y'), "RoBoot"));

    List<WinningStartegy> winningStargey = new ArrayList<WinningStartegy>();
    winningStargey.add(new OneColumnWinningStartegy());
    winningStargey.add(new OneDiagnalWinningStartegy());
    winningStargey.add(new OneRowWinningStrategy());

    Game game = gameContoller.createGame(2, players, winningStargey);

    while (game.getGameStatus().equals(GameStatus.INPROGRESS)) {

      gameContoller.displayBoard(game);
      System.out.println();
      System.out.println("Does any one wants to undo Y/N ?");

      String input = scanner.next();

      if (input.equals("Y")) {
        gameContoller.undo();
      } else {
        gameContoller.makeMove(game);
      }

    }

  }
}
