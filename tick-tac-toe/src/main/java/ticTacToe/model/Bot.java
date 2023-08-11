package ticTacToe.model;

import ticTacToe.model.enums.BotDifficultyLevel;
import ticTacToe.model.enums.PlayerType;
import ticTacToe.strategy.BotPlaying.BotPlayingFactory;

public class Bot extends Player {

  public Bot(Symbole symbole, String name) {
    super(symbole, name, PlayerType.BOT);
  }

  private BotDifficultyLevel botDifficultyLevel;

  public BotDifficultyLevel getBotDifficultyLevel() {
    return botDifficultyLevel;
  }

  public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
    this.botDifficultyLevel = botDifficultyLevel;
  }

  @Override
  public Cell makeMove(Board board) {
    // TODO Auto-generated method stub
    return BotPlayingFactory.getBotPlayingStrategy(botDifficultyLevel).makeMove(board);
  }

}
