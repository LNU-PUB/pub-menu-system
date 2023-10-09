package controller;

import java.util.HashMap;
import java.util.Map;
import model.Command;
import model.MemberMenu;

/**
 * Maps the member menu options to the commands that should be executed.
 *
 * @version 1.0
 * @since 2021-09-30
 */
public class MemberMenuCommandMapper {
  private final Map<MemberMenu, Command> commandMap = new HashMap<>();

  /**
   * Creates a new instance of the MemberMenuCommandMapper class.
   *
   * @param clubAdmin - The club administration instance.
   */
  public MemberMenuCommandMapper(ClubAdministration clubAdmin) {
    commandMap.put(MemberMenu.ADDMEMBER, clubAdmin::addMember);
    commandMap.put(MemberMenu.DELETEMEMEBER, clubAdmin::deleteMember);
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
