package com.connorbrezinsky.turbulent.gui;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import com.connorbrezinsky.turbulent.Main;
import com.connorbrezinsky.turbulent.guiutils.Gui;
import com.connorbrezinsky.turbulent.guiutils.GuiButton;
import com.connorbrezinsky.turbulent.util.Save;
import com.connorbrezinsky.turbulent.util.Texture;

public class GuiPauseMenu {

	static Gui guiMenu = new Gui(315, 200, 170, 200).hide().addSprite(Texture.menu);

	static GuiButton menu = new GuiButton(guiMenu, 335, 220, 130, 30).addSprite(Texture.bMenu);
	static GuiButton save = new GuiButton(guiMenu, 335, 260, 130, 30).addSprite(Texture.bSave);
	static GuiButton exit = new GuiButton(guiMenu, 335, 300, 130, 30).addSprite(Texture.bExit);
	static GuiButton restart = new GuiButton(guiMenu, 335, 370, 130, 30);

	public static void render(Graphics g) {
		guiMenu.render(g);
	}

	public static void update(GameContainer container, StateBasedGame game) throws SlickException {
		Input i = container.getInput();

		if (menu.getClick(i)) {
			game.enterState(1923);
			guiMenu.hide();
			Main.isPaused = false;
		} else if (save.getClick(i)) {
			Save.save(game.getCurrentStateID());
		} else if (exit.getClick(i)) {
			container.exit();
		}

		if (Main.getKeyPress(i, Input.KEY_ESCAPE)) {
			if (guiMenu.isVisible) {
				guiMenu.hide();
				Main.isPaused = true;
			} else {
				guiMenu.unHide();
				Main.isPaused = false;
			}
		}
	}

}
