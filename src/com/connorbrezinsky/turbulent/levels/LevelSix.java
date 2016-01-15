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
import com.connorbrezinsky.turbulent.ObjectSpawner;
import com.connorbrezinsky.turbulent.gui.GuiPauseMenu;
import com.connorbrezinsky.turbulent.object.Door;
import com.connorbrezinsky.turbulent.object.Object;
import com.connorbrezinsky.turbulent.object.PhysicsObject;
import com.connorbrezinsky.turbulent.object.Platform;
import com.connorbrezinsky.turbulent.object.Switch;
import com.connorbrezinsky.turbulent.util.SpriteLoader;
import com.connorbrezinsky.turbulent.util.State;
import com.connorbrezinsky.turbulent.util.Texture;

public class LevelSix extends BasicGameState {

	State levelSix = new State(this);

	Color bg = Color.black;
	public Character player = new Character(40, Main.getMidY(20) + 200, 20, 20, Color.darkGray);
	public Door finishDoor = new Door(650, 600 - 100, 10, 100, Color.blue);

	public Platform obj0 = new Platform(0, 0, 800, 200);
	public Platform obj00 = new Platform(600, 0, 300, 500);
	public Platform obj1 = new Platform(400, 350, 80, 10, Color.orange);
	public Platform obj2 = new Platform(290, 400, 40, 10, Color.blue);
	public Platform obj3 = new Platform(230, 480, 40, 10, Color.blue);
	public Platform obj4 = new Platform(330, 500, 40, 10, Color.blue);
	public Platform obj5 = new Platform(400, 550, 40, 10, Color.blue);


	SpriteLoader sLoader;

	Switch pressureSwitch = new Switch(430, 350 - 5, 20, 5, Color.black);

	Platform finish = Level.levelFinish;

	public ObjectSpawner objSpawner;
	public PhysicsObject cube = new PhysicsObject(200, 600 - 20, 10, 10, Color.blue, true);
	float sx;

	public LevelSix(int s) {

	}

	@Override
	public int getID() {
		return levelSix.getId();
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		sLoader = new SpriteLoader(new SpriteSheet(new Image("res/sprites.png"), 20, 20));

		Image[] iLevelFinish = Texture.loadLevelFinish();
		Image[] iPhysSpawner = Texture.loadPhysicsSpawner();

		objSpawner = new ObjectSpawner(iPhysSpawner, Level.objSDuration);

		sx = cube.getX() - 10;
		cube.addPlayer(player);

		obj0.addSprite(Texture.blockMagenta);
		obj00.addSprite(Texture.blockMagenta);

		finish = new Platform(700, 600 - 60, 20, 60, iLevelFinish, Level.duration);
		finish.setType(Object.FINISH);
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException {
		g.setBackground(bg);
		finish.render(g);
		obj0.render(g);
		obj00.render(g);
		obj1.render(g);
		obj2.render(g);
		obj3.render(g);
		obj4.render(g);
		obj5.render(g);

		finishDoor.render(g);

		g.setColor(Color.white);
		g.fillRect(100, 490, 75, 50);
		Texture.pickup.draw(105, 500);

		g.fillRect(pressureSwitch.getX() - 10, 350 - 60, 40, 60);
		Texture.downarrow.draw(pressureSwitch.getX() - 2, 350 - 50);
		pressureSwitch.render(g);

		cube.setSpawnerPos(sx, 600 - 50);
		cube.render(g, objSpawner);

		player.render(g);

		GuiPauseMenu.render(g);

	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		Input i = arg0.getInput();
		GuiPauseMenu.update(arg0, arg1);

		player.addBasicController(i, Input.KEY_A, Input.KEY_D, Input.KEY_SPACE);
		player.addPhysics();
		player.addWorldCollider();

		pressureSwitch.addListener(player, cube, Switch.PRESSURE, i);
		pressureSwitch.addCollider(player);
		pressureSwitch.addCollider(cube);
		cube.addPhysics();
		cube.addPlayer(player);
		cube.addListener(i);

		obj0.addCollider(player, cube);
		obj00.addCollider(player, cube);
		obj1.addCollider(player, cube);
		obj2.addCollider(player, cube);
		obj3.addCollider(player, cube);
		obj4.addCollider(player, cube);
		obj5.addCollider(player, cube);
		finishDoor.addCollider(player);
		cube.addPlayerCollider(player);

		finish.setNextLevel(Level.stage[7]);
		if (finish.isFinished(player)) {
			finish.goToNextLevel(arg1);
		}

		if (pressureSwitch.isTriggered()) {
			finishDoor.open();
		} else {
			finishDoor.close();
		}

		Level.goToLevel(i, arg1);

	}

}
