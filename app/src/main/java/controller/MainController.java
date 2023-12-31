package controller;

import java.util.Stack;

import view.model.MenuOption;

/**
 * This class represents the controller of the application. It is responsible
 * for managing the
 * application state and for executing the user's commands.
 *
 * @since 1.0.0
 */
public class MainController implements Cloneable {
  private Stack<MenuOption[]> menuStack = new Stack<>();

  /**
   * This method is called when the user selects a menu option. It executes the
   * corresponding command.
   *
   * @param newMenu - The menu corresponding to the selected option.
   */
  public void enterMenu(MenuOption[] newMenu) {
    menuStack.push(newMenu);
  }

  /**
   * Returns a copy of the current instance.
   *
   * @return - A copy of the current instance.
   */
  @Override
  public MainController clone() {
    try {
      return (MainController) super.clone();
    } catch (CloneNotSupportedException e) {
      throw new AssertionError(); // Can't happen
    }
  }

  /**
   * This method is called when the user wants to go back to the previous menu.
   */
  public void exitMenu() {
    if (!menuStack.isEmpty()) {
      menuStack.pop();
    }
  }

  /**
   * Returns the menu corresponding to the current state of the application.
   *
   * @return - The menu corresponding to the current state of the application.
   */
  public MenuOption[] getCurrentMenu() {
    return menuStack.isEmpty() ? null : menuStack.peek();
  }

  // Methods corresponding to menu options

  /**
   * This method is called when the user wants to add a new member.
   */
  public void addMember() {
    // Implement logic
  }

  /**
   * This method is called when the user wants to delete a member.
   */
  public void deleteMember() {
    // Implement logic
  }

  // Additional methods
}
