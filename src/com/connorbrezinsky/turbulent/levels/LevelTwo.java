package com.connorbrezinsky.turbulent.levels;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.connorbrezinsky.turbulent.Character;
import com.connorbrezinsky.turbulent.Hazard;
import com.connorbrezinsky.turbulent.Main;
import com.connorbrezinsky.turbulent.Trigger;
import com.connorbrezinsky.turbulent.gui.GuiPauseMenu;
import com.connorbrezinsky.turbulent.object.Object;
import com.connorbrezinsky.turbulent.object.Platform;
import com.connorbrezinsky.turbulent.util.SpriteLoader;
import com.connorbrezinsky.turbulent.util.State;
import com.connorbrezinsky.turbulent.util.Texture;

public class LevelTwo extends BasicGameState {

	State levelTwo = new State(this);

	Color bg = Color.black;
	public Character player = new Character(40, Main.getMidY(20) + 100, 20, 20, Color.darkGray);

	SpriteLoader sLoader;

	public Platform obj_1 = new Platform(400 - 65, 600 - 30, 20, 30, Color.lightGray);
	public Platform obj_2 = new Platform(400 - 20, 600 - 50, 20, 50, Color.darkGray);
	public Platform obj_3 = new Platform(400 + 25, 600 - 30, 20, 30, Color.lightGray);
	public Trigger obj2ColorTrigger = new Trigger(400 - 40, 0, 60, 600, Trigger.AREA);

	Hazard[] spikes = { new Hazard(400 - 43, 600 - 20, 20F, 13), new Hazard(403, 600 - 20, 20F, 13), };

	public LevelTwo(int s) {

	}

	@Override
	public int getID() {
		return levelTwo.getId();
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {

		Image[] iLevelFinish = Texture.loadLevelFinish();

		Level.levelFinish = new Platform(700, 600 - 60, 20, 60, iLevelFinish, Level.duration);
		Level.levelFinish.setType(Object.FINISH);

		spikes[0].addSprite(Texture.spike);
		spikes[1].addSprite(Texture.spike);

		player.setSpawn(60, 600 - 40);

	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException {
		g.setBackground(bg);
		
		Level.levelFinish.render(g);
		obj_1.render(g);
		obj_2.render(g);
		obj_3.render(g);

		spikes[0].render(g);
		spikes[1].render(g);

		Texture.space_key.draw(10, 400);
		GuiPauseMenu.render(g);
		player.render(g);

	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		Input i = arg0.getInput();
		GuiPauseMenu.update(arg0, arg1);
		player.addBasicController(i, Input.KEY_A, Input.KEY_D, Input.KEY_SPACE);
		player.addPhysics();
		player.addWorldCollider();

		Level.levelFinish.setNextLevel(Level.stage[3]);
		Level.levelFinish.addCollider(player);

		obj_1.addCollider(player);
		obj_2.addCollider(player);
		obj_3.addCollider(player);
		spikes[0].addCollider(player);
		spikes[1].addCollider(player);
		;

		obj2ColorTrigger.addBasicCollider(player);

		if (obj2ColorTrigger.isTriggered) {
			player.setColor(Color.lightGray);
		} else {
			player.setColor(Color.darkGray);
		}

		if (Level.levelFinish.isFinished(player)) {
			Level.levelFinish.goToNextLevel(arg1);
		}

		Level.goToLevel(i, arg1);
	}

}
