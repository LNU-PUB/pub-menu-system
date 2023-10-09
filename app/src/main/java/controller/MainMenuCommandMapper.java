package controller;

import java.util.HashMap;
import java.util.Map;
import model.Command;
import model.MainMenu;
import model.MemberMenu;

/**
 * Maps the main menu options to the commands that should be executed.
 *
 * @version 1.0
 * @since 2021-09-30
 */
public class MainMenuCommandMapper {
  private final Map<MainMenu, Command> commandMap = new HashMap<>();

  /**
   * Creates a new instance of the MainMenuCommandMapper class.
   *
   * @param mainController - The club administration instance.
   */
  public MainMenuCommandMapper(MainController mainController) {
    commandMap.put(MainMenu.MEMBER_MENU, () -> mainController.enterMenu(MemberMenu.values()));
    // Add more mappings
  }

  /**
   * Gets the command that should be executed for the given menu option.
   *
   * @param menuOption - The menu option.
   * @return - The command that should be executed.
   */
  public Command getCommand(MainMenu menuOption) {
    return commandMap.get(menuOption);
  }
}
