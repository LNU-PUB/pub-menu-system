package controller;

import model.MainMenu;
import view.ConsoleUi;

/**
 * The main class of the application.
 *
 * <p>It creates the instances of the model and view classes and starts the application.
 *
 * @version 1.0
 * @since 2021-09-30
 */
public class App {
  public String getGreeting() {
    return "Hello World!";
  }

  /**
   * The main method of the application.
   *
   * @param args The command line arguments.
   */
  public static void main(String[] args) {
    ClubAdministration clubAdmin = new ClubAdministration();
    MainMenuCommandMapper mainMapper = new MainMenuCommandMapper(clubAdmin);
    MemberMenuCommandMapper memberMapper = new MemberMenuCommandMapper(clubAdmin);
    MenuController menuController = new MenuController(mainMapper, memberMapper);
    ConsoleUi consoleUi = new ConsoleUi(clubAdmin, menuController);
    boolean exit = false;

    clubAdmin.enterMenu(MainMenu.values());

    while (!exit) {
      consoleUi.displayMenu();
      consoleUi.getUserInputAndExecute();
      if (clubAdmin.getCurrentMenu() == null) {
        exit = true;
      }
    }

    exit();
  }

  private static void exit() {
    System.out.println("\nApplication is closing ...");
    System.exit(0);
  }
}
