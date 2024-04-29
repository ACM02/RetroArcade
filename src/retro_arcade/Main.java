/**
 * Main.java - Main class, runs the program by making a frame
 */
package retro_arcade;

import retro_arcade.main_menu.MainMenu;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Frame game = new Frame(new MainMenu());
	}

}
