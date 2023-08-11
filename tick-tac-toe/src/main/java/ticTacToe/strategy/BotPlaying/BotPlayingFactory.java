package ticTacToe.strategy.BotPlaying;

import ticTacToe.model.enums.BotDifficultyLevel;

public class BotPlayingFactory {

  public static BotPlayingStrategy getBotPlayingStrategy(BotDifficultyLevel botDifficultyLevel) {

    return new EassyBotPlayingStategy();
    // switch (botDifficultyLevel) {
    // case EASY:
    // return new EassyBotPlayingStategy();
    // case HARD:
    // return new HardBotPlayingStrategy();
    // case MEDIUM:
    // break;
    // }

    // return null;
  }

}
