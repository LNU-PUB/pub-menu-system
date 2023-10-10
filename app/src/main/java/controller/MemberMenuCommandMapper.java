package controller;

import java.util.HashMap;
import java.util.Map;
import model.Command;
import model.MemberMenu;

/**
 * Maps the member menu options to the commands that should be executed.
 *
 * @since 1.0.0
 */
public class MemberMenuCommandMapper {
  private final Map<MemberMenu, Command> commandMap = new HashMap<>();

  /**
   * Creates a new instance of the MemberMenuCommandMapper class.
   *
   * @param mainController - The club administration instance.
   */
  public MemberMenuCommandMapper(MainController mainController) {
    commandMap.put(MemberMenu.ADDMEMBER, mainController::addMember);
    commandMap.put(MemberMenu.DELETEMEMEBER, mainController::deleteMember);
    // Add more mappings
  }

  /**
   * Gets the command that should be executed for the given menu option.
   *
   * @param menuOption - The menu option.
   * @return - The command that should be executed.
   */
  public Command getCommand(MemberMenu menuOption) {
    return commandMap.get(menuOption);
  }
}
