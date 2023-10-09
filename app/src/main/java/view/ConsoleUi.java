package view;

import controller.ClubAdministration;
import controller.MenuController;
import java.util.Scanner;

import model.MainMenu;
import model.MenuOption;

/**
 * Represents the console user interface.
 *
 * @version 1.0
 * @since 2021-09-30
 */
public class ConsoleUi {
  private final ClubAdministration clubAdmin;
  private final MenuController menuController;
  private final Scanner scanner = new Scanner(System.in, "UTF-8");

  /**
   * Creates a new instance of the ConsoleUi class.
   *
   * @param clubAdmin      - The club administration instance.
   * @param menuController - The menu controller instance.
   */
  public ConsoleUi(ClubAdministration clubAdmin, MenuController menuController) {
    this.clubAdmin = clubAdmin.clone();
    this.menuController = menuController;
  }

  /**
   * Displays the main menu.
   */
  public void displayMenu() {
    MenuOption[] currentMenu = clubAdmin.getCurrentMenu();
    if (currentMenu != null) {
      System.out.println("\n*** " + currentMenu[0].getMenuName() + " ***\n");
      for (int i = 0; i < currentMenu.length; i++) {
        System.out.println((i + 1) + ". " + currentMenu[i].getDescription());
      }
      if(currentMenu[0].getMenuName().contains("Main")) {
        System.out.println("q. Quit");
      } else {
        System.out.println("0. Go back");
      }
    }
  }

  /**
   * Gets the user input and executes the command.
   */
  public void getUserInputAndExecute() {
    // boolean exit = false;
    try {
      System.out.print("\nEnter your choice: ");
      String input = scanner.next();
      int choice = input.equalsIgnoreCase("q") ? 0 : Integer.parseInt(input);
      MenuOption[] currentMenu = clubAdmin.getCurrentMenu();
      if (choice >= 1 && choice <= currentMenu.length) {
        menuController.executeCommand(currentMenu[choice - 1]);
      } else if (choice == 0) {
        clubAdmin.exitMenu();
      } else {
        throw new Exception();
      }
    } catch (Exception e) {
      System.out.println("Invalid input!");
      // exit = true;
    }
    // return exit;
  }

  private boolean isNumber(String str) {
    String regex = "[0-9]+";

    return str.matches(regex);
  }
}
