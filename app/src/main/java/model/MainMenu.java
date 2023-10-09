package model;

/**
 * Represents the main menu options.
 *
 * @version 1.0
 * @since 2021-09-30
 */
public enum MainMenu implements MenuOption {
  MEMBER_MENU("Member Menu"),
  ADVANCE_DAYS("Advance Days");

  private final String description;

  MainMenu(String description) {
    this.description = description;
  }

  /**
   * Gets the description of the menu option.
   *
   * @return - The description of the menu option.
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the name of the menu.
   *
   * @return - The name of the menu.
   */
  @Override
  public String getMenuName() {
    return "Main Menu";
  }
}
