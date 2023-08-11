package ticTacToe.strategy.BotPlaying;

import java.util.List;

import ticTacToe.model.Board;
import ticTacToe.model.Cell;
import ticTacToe.model.enums.CellStatus;

public class EassyBotPlayingStategy implements BotPlayingStrategy {

  public Cell makeMove(Board board) {

    for (List<Cell> row : board.getBoard()) {

      for (Cell cell : row) {
        if (cell.getCellStatus().equals(CellStatus.EMPTY)) {
          return cell;
        }
      }
    }

    return null;/* Never exitute this we are already checking */
  }

}
