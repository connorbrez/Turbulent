package com.connorbrezinsky.turbulent;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.connorbrezinsky.turbulent.gui.GuiButton;
import com.connorbrezinsky.turbulent.levels.Level;
import com.connorbrezinsky.turbulent.util.Texture;

public class Menu extends BasicGameState {

	GuiButton play;
	GuiButton exit;

	public Menu(int i) {
	}

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException{

		play = new GuiButton(400 - Texture.bPlay.getWidth() / 2, 300 - Texture.bPlay.getHeight() / 2,
				Texture.bPlay.getWidth(), Texture.bPlay.getHeight());
		exit = new GuiButton(400 - Texture.bExit.getWidth() / 2,
				300 - (Texture.bExit.getHeight() / 2) + Texture.bPlay.getHeight() + 5, Texture.bExit.getWidth(),
				Texture.bExit.getHeight());

		play.addSprite(Texture.bPlay);
		exit.addSprite(Texture.bExit);
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException{
		Texture.background.draw();
		play.render(g);
		exit.render(g);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException{
		Input i = container.getInput();
		if(play.getClick(i)){
			game.enterState(1);
		}else if(exit.getClick(i)){
			container.exit();
		}

		Level.goToLevel(i, game);

	}

	@Override
	public int getID(){
		return 1923;
	}

}
