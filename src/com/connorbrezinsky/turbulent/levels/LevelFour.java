package com.connorbrezinsky.turbulent.levels;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.connorbrezinsky.turbulent.Character;
import com.connorbrezinsky.turbulent.Main;
import com.connorbrezinsky.turbulent.Trigger;
import com.connorbrezinsky.turbulent.object.Door;
import com.connorbrezinsky.turbulent.object.Object;
import com.connorbrezinsky.turbulent.object.Platform;
import com.connorbrezinsky.turbulent.object.Switch;
import com.connorbrezinsky.turbulent.util.SpriteLoader;
import com.connorbrezinsky.turbulent.util.State;
import com.connorbrezinsky.turbulent.util.Texture;

public class LevelFour extends BasicGameState {

	State levelFour = new State(this);
	
	
	Color bg = Color.black;

	public Character player = new Character(40, Main.getMidY(20) + 100, 20, 20, Color.darkGray);

	public Platform obj1 = new Platform(150, 530, 40, 10, Color.orange);
	public Platform obj2 = new Platform(200, 480, 30, 10, Color.orange);
	public Platform obj3 = new Platform(250, 400, 100, 10, Color.red);
	public Platform obj4 = new Platform(600, 0, 200, 600 - 70, Color.black);
	public Platform roof = new Platform(0, 0, 800, 300, Color.black);

	public Trigger bgColorSwitch = new Trigger(250, 0, 100, 410, Trigger.NORMAL);

	public Door finishDoor = new Door(620, 600 - 100, 10, 100, Color.black);

	public Switch sFinishDoor;
	boolean isActive = false;

	SpriteLoader sLoader;

	public LevelFour(int s) {

	}


	@Override
	public int getID(){
		return levelFour.getId();
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException{
		
		sLoader = new SpriteLoader(new SpriteSheet(new Image("res/sprites.png"), 20, 20));
		Image[] iLevelFinish = Texture.loadLevelFinish();

		Level.levelFinish = new Platform(700, 600 - 60, 20, 60, iLevelFinish, Level.duration);
		Level.levelFinish.setType(Object.FINISH);

		sFinishDoor = new Switch(320, 400 - 30, 20, 20);
		sFinishDoor.addSprite(Texture.switchWhite_off);

	}

	@Override
	public void leave(GameContainer arg0, StateBasedGame arg1) throws SlickException{

	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException{
		g.setBackground(bg);
		if(isActive) {
			Texture.e_key.draw(280, 365);
			sFinishDoor.render(g);
		}

		obj1.render(g);
		obj2.render(g);
		obj3.render(g);
		obj4.render(g);
		roof.render(g);

		finishDoor.render(g);

		Level.levelFinish.render(g);
		player.render(g);

	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException{
		Input i = arg0.getInput();
		player.addBasicController(i, Input.KEY_A, Input.KEY_D, Input.KEY_SPACE);
		player.addPhysics();
		player.addWorldCollider();

		obj1.addCollider(player);
		obj2.addCollider(player);
		obj3.addCollider(player);
		obj4.addCollider(player);
		roof.addCollider(player);

		bgColorSwitch.addBasicCollider(player);

		finishDoor.addCollider(player);
		finishDoor.addSwitch(sFinishDoor);

		sFinishDoor.addListener(player, Switch.ACTION, i);
		sFinishDoor.addCollider(player);

		Level.levelFinish.addCollider(player);
		Level.levelFinish.setNextLevel(Level.stage[5]);

		if(Level.levelFinish.isFinished(player)) {
			Level.levelFinish.goToNextLevel(arg1);
		}

		if(bgColorSwitch.isTriggered) {
			player.setColor(Color.darkGray);
			bg = Color.red;
			obj3.setColor(Color.black);
			isActive = true;
		}else{
			bg = Color.black;
			obj3.setColor(Color.red);
			isActive = false;

		}

		if(sFinishDoor.isTriggered()) {
			sFinishDoor.changeSprite(Texture.switchWhite_on);
		}else{

			sFinishDoor.changeSprite(Texture.switchWhite_off);
		}

		Level.goToLevel(i, arg1);
	}


}
