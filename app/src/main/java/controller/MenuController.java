package controller;

import model.Command;
import model.MainMenu;
import model.MemberMenu;
import model.MenuOption;

/**
 * Maps the menu options to the commands that should be executed.
 *
 * @version 1.0
 * @since 2021-09-30
 */
public class MenuController {
  private MainMenuCommandMapper mainMapper;
  private MemberMenuCommandMapper memberMapper;

  /**
   * Creates a new instance of the MenuController class.
   *
   * @param mainMapper   - The main menu command mapper.
   * @param memberMapper - The member menu command mapper.
   */
  public MenuController(MainMenuCommandMapper mainMapper, MemberMenuCommandMapper memberMapper) {
    this.mainMapper = mainMapper;
    this.memberMapper = memberMapper;
  }

  /**
   * Gets the command that should be executed for the given menu option.
   *
   * @param menuOption - The menu option.
   */
  public void executeCommand(MenuOption menuOption) {
    Command command = null;
    if (menuOption instanceof MainMenu) {
      command = mainMapper.getCommand((MainMenu) menuOption);
    } else if (menuOption instanceof MemberMenu) {
      command = memberMapper.getCommand((MemberMenu) menuOption);
    }
    if (command != null) {
      command.execute();
    }
  }
}
