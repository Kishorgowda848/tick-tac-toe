package ticTacToe.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ticTacToe.model.enums.CellStatus;
import ticTacToe.model.enums.GameStatus;
import ticTacToe.model.enums.PlayerType;
import ticTacToe.strategy.WinningStartegy;

public class Game {

  private Board board;

  private Player winner;

  private List<Player> players;

  private List<Move> moves;

  private int currentPlayerIndex;

  private GameStatus gameStatus;

  private List<WinningStartegy> winningStrategys;

  private Game(int boardSize, List<Player> players, List<WinningStartegy> winningStrategys) {
    this.board = new Board(boardSize);
    this.players = players;
    this.winningStrategys = winningStrategys;
    this.gameStatus = GameStatus.INPROGRESS;
    this.currentPlayerIndex = 0;
    this.moves = new ArrayList<Move>();

  }

  public Board getBoard() {
    return board;
  }

  public void setBoard(Board board) {
    this.board = board;
  }

  public Player getWinner() {
    return winner;
  }

  public void setWinner(Player winner) {
    this.winner = winner;
  }

  public List<Move> getMoves() {
    return moves;
  }

  public void setMoves(List<Move> moves) {
    this.moves = moves;
  }

  public int getCurrentPlayerIndex() {
    return currentPlayerIndex;
  }

  public void setCurrentPlayerIndex(int currentPlayerIndex) {
    this.currentPlayerIndex = currentPlayerIndex;
  }

  public GameStatus getGameStatus() {
    return gameStatus;
  }

  public void setGameStatus(GameStatus gameStatus) {
    this.gameStatus = gameStatus;
  }

  public List<WinningStartegy> getWinningStrategys() {
    return winningStrategys;
  }

  public void setWinningStrategys(List<WinningStartegy> winningStrategys) {
    this.winningStrategys = winningStrategys;
  }

  public List<Player> getPlayers() {
    return players;
  }

  public void setPlayers(List<Player> players) {
    this.players = players;
  }

  public void print() {
    this.board.print();
  }

  public static Builder getBuilder() {
    return new Builder();
  }

  private boolean validate(Cell cell) {
    int row = cell.getRow();
    int col = cell.getCol();

    if (row < 0 || col < 0 || row > board.getSize() || col > board.getSize()) {
      return false;
    }

    return board.getBoard().get(row).get(col).getCellStatus().equals(CellStatus.EMPTY);
  }

  public void makeMove() {
    Player currentPlayer = players.get(currentPlayerIndex);
    System.out.println(" This turn is for " + currentPlayer.getName());
    Cell proposedCell = currentPlayer.makeMove(this.board);

    if (!validate(proposedCell)) {
      return;
    }

    Cell cellInBoard = board.getBoard().get(proposedCell.getRow()).get(proposedCell.getCol());
    cellInBoard.setCellStatus(CellStatus.FILLED);
    cellInBoard.setPlayer(currentPlayer);

    Move move = new Move(currentPlayer, cellInBoard);
    moves.add(move);

    currentPlayerIndex += 1;
    currentPlayerIndex = currentPlayerIndex % players.size();

  }

  public static class Builder {

    private List<Player> players;

    private List<WinningStartegy> winningStrategys;

    private int dimenstion;

    public List<Player> getPlayers() {
      return players;
    }

    public Builder setPlayers(List<Player> players) {
      this.players = players;
      return this;
    }

    public List<WinningStartegy> getWinningStrategys() {
      return winningStrategys;
    }

    public Builder setWinningStrategys(List<WinningStartegy> winningStrategys) {
      this.winningStrategys = winningStrategys;
      return this;
    }

    public int getDimenstion() {
      return dimenstion;
    }

    public Builder setDimenstion(int dimenstion) {
      this.dimenstion = dimenstion;
      return this;
    }

    public boolean validate() {
      if (this.players.size() < 2) {
        return false;
      }

      if (this.players.size() != this.dimenstion - 1) {
        return false;
      }

      int botCount = 0;

      for (Player player : this.players) {

        if (player.getPlayerType().equals(PlayerType.BOT)) {
          botCount++;
        }
      }

      if (botCount > 1) {
        return false;
      }

      Set<Character> set = new HashSet<Character>();

      for (Player player : this.players) {
        if (set.contains(player.getSymbole().getaChar())) {
          return false;
        }

        set.add(player.getSymbole().getaChar());
      }

      return true;

    }

    public Game build() {
      validate();
      return new Game(getDimenstion(), getPlayers(), getWinningStrategys());
    }

  }

}

// All attributes must be private
// Without exception and have getters and setters for each;
