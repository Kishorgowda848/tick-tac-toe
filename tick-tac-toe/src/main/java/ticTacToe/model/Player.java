package ticTacToe.model;

import java.util.Scanner;

import ticTacToe.model.enums.PlayerType;

public class Player {

  private Symbole symbole;

  private PlayerType playerType;

  private String name;

  private Scanner scanner = new Scanner(System.in);

  public Player(Symbole symbole, String name, PlayerType playerType) {
    this.symbole = symbole;
    this.name = name;
    this.playerType = playerType;
  }

  public Symbole getSymbole() {
    return symbole;
  }

  public void setSymbole(Symbole symbole) {
    this.symbole = symbole;
  }

  public PlayerType getPlayerType() {
    return playerType;
  }

  public void setPlayerType(PlayerType playerType) {
    this.playerType = playerType;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Cell makeMove(Board board) {
    System.out.println("Enter the row Number");
    int row = scanner.nextInt();
    System.out.println("Enter the column number");
    int column = scanner.nextInt();

    return new Cell(row, column);
  }
}
