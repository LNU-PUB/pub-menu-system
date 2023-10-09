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

  /**
   * The main method of the application.
   *
   * @param args The command line arguments.
   */
  public static void main(String[] args) {
    MainController mainController = new MainController();
    MainMenuCommandMapper mainMapper = new MainMenuCommandMapper(mainController);
    MemberMenuCommandMapper memberMapper = new MemberMenuCommandMapper(mainController);
    MenuController menuController = new MenuController(mainMapper, memberMapper);
    ConsoleUi consoleUi = new ConsoleUi(mainController, menuController);
    boolean exit = false;

    mainController.enterMenu(MainMenu.values());

    while (!exit) {
      consoleUi.displayMenu();
      consoleUi.getUserInputAndExecute();
      if (mainController.getCurrentMenu() == null) {
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
