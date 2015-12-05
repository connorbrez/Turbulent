package com.connorbrezinsky.turbulent.levels;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;

import com.connorbrezinsky.turbulent.Character;
import com.connorbrezinsky.turbulent.Main;
import com.connorbrezinsky.turbulent.ObjectSpawner;
import com.connorbrezinsky.turbulent.PhysicsObject;
import com.connorbrezinsky.turbulent.Platform;
import com.connorbrezinsky.turbulent.SpriteLoader;
import com.connorbrezinsky.turbulent.Switch;
import com.connorbrezinsky.turbulent.Object;

public class LevelEight implements GameState {

	Color bg = Color.white;
	public Character player = new Character(40, Main.getMidY(20) + 200, 20, 20, Color.darkGray);
	// TODO make animation loader
	public SpriteSheet aLoader;
	public SpriteLoader sLoader;

	public PhysicsObject finishCube = new PhysicsObject(200, 600 - 20, 10, 10, Color.blue, true);
	public ObjectSpawner fcSpawner;

	public Platform[] walls = { new Platform(165, 600 - 80, 10, 80, Color.red),
			new Platform(165, 600 - 80, 80, 10, Color.red), new Platform(165 + 70, 600 - 80, 10, 80, Color.red) };

	public Platform obj1 = new Platform(450, 550, 100, 10, Color.black);

	public Switch[] lSwitch = { new Switch(460, 550 - 50, 20, 20), new Switch(490, 550 - 50, 20, 20),
			new Switch(520, 550 - 50, 20, 20) };
	public Switch finishSwitch = new Switch(Main.getMidX(40), 600 - 5, 40, 5, Color.blue);
	public float sx;

	public LevelEight(int s) {

	}

	@Override
	public void enter(GameContainer arg0, StateBasedGame arg1) throws SlickException{

	}

	@Override
	public int getID(){
		return 8;
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException{

		aLoader = new SpriteSheet(new Image("res/animations_20x60.png"), 20, 60);
		sLoader = new SpriteLoader(new SpriteSheet(new Image("res/sprites.png"), 20, 20));

		aLoader.startUse();
		Image[] iLevelFinish = { aLoader.getSubImage(0, 0), aLoader.getSubImage(1, 0), aLoader.getSubImage(2, 0),
				aLoader.getSubImage(3, 0), aLoader.getSubImage(4, 0), aLoader.getSubImage(5, 0),
				aLoader.getSubImage(6, 0), aLoader.getSubImage(7, 0), aLoader.getSubImage(8, 0),
				aLoader.getSubImage(9, 0), aLoader.getSubImage(0, 1), aLoader.getSubImage(1, 1) };
		aLoader.endUse();

		Image[] iPhysSpawner = { new Image("res/animation/physSpawner/physSpawner1.png"),
				new Image("res/animation/physSpawner/physSpawner2.png"),
				new Image("res/animation/physSpawner/physSpawner3.png"),
				new Image("res/animation/physSpawner/physSpawner4.png"),
				new Image("res/animation/physSpawner/physSpawner5.png"),
				new Image("res/animation/physSpawner/physSpawner6.png"), };
		sx = finishCube.getX() - 10;

		fcSpawner = new ObjectSpawner(Level.aObjectSpawner, iPhysSpawner, Level.objSDuration);

		lSwitch[0].addSprite(sLoader.getImage(4));
		lSwitch[1].addSprite(sLoader.getImage(4));
		lSwitch[2].addSprite(sLoader.getImage(4));

		Level.levelFinish = new Platform(700, 600 - 60, 20, 60, iLevelFinish,
				Level.duration);
		Level.levelFinish.setType(Object.FINISH);
	}

	@Override
	public void leave(GameContainer arg0, StateBasedGame arg1) throws SlickException{

	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException{
		g.setBackground(bg);
		finishSwitch.render(g);
		g.setColor(Color.black);
		g.drawString("L1", 460, 550 - 70);
		g.drawString("L2", 490, 550 - 70);
		g.drawString("L3", 520, 550 - 70);
		lSwitch[0].render(g);
		lSwitch[1].render(g);
		lSwitch[2].render(g);
		lSwitch[0].showTrigRadius(g, Color.green);
		lSwitch[0].setCustomActionRadius(lSwitch[0].getX()-5, lSwitch[0].getY(), 30, 60);

		g.setColor(Color.black);
		g.fillRect(sx - 25, 600 - 80, 80, 80);
		finishCube.setSpawnerPos(sx, 600 - 50);
		finishCube.render(g, fcSpawner);

		walls[0].render(g);
		walls[1].render(g);
		walls[2].render(g);

		obj1.render(g);

		Level.levelFinish.render(g);
		player.render(g);

	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException{
		Input i = arg0.getInput();
		player.addBasicController(i, Input.KEY_A, Input.KEY_D, Input.KEY_SPACE);
		player.addPhysics();
		player.addWorldCollider();

		finishCube.addPhysics();
		finishCube.addPlayer(player);
		finishCube.addPlayerCollider(player);
		finishCube.init(i);
		
		finishSwitch.addCollider(player, finishCube);
		finishSwitch.init(player, finishCube, Switch.PRESSURE, i);
		
		lSwitch[0].init(player, Switch.ACTION, i);
		//lSwitch[1].init(player, Switch.ACTION, i);
		//lSwitch[2].init(player, Switch.ACTION, i);
		lSwitch[0].addCollider(player);


		obj1.addCollider(player, finishCube);

		/*walls[0].addCollider(player, finishCube);
		walls[1].addCollider(player, finishCube);
		walls[2].addCollider(player, finishCube);*/

		if(lSwitch[0].isTriggered()){
			lSwitch[0].changeSprite(sLoader.getImage(5));
		}else{
			lSwitch[0].changeSprite(sLoader.getImage(4));
		}
		
		if(lSwitch[1].isTriggered()){
			lSwitch[1].changeSprite(sLoader.getImage(5));
		}else{
			lSwitch[1].changeSprite(sLoader.getImage(4));
		}
		
		if(lSwitch[2].isTriggered()){
			lSwitch[2].changeSprite(sLoader.getImage(5));
		}else{
			lSwitch[2].changeSprite(sLoader.getImage(4));
		}
		
		Level.levelFinish.addCollider(player, finishCube);
		Level.levelFinish.setNextLevel(Level.stage[9]);
		if(Level.levelFinish.isFinished(player)) {
			Level.levelFinish.goToNextLevel(arg1);
		}
		Level.goToLevel(i, arg1);

	}

	@Override
	public void mouseClicked(int arg0, int arg1, int arg2, int arg3){

	}

	@Override
	public void mouseDragged(int arg0, int arg1, int arg2, int arg3){

	}

	@Override
	public void mouseMoved(int arg0, int arg1, int arg2, int arg3){

	}

	@Override
	public void mousePressed(int arg0, int arg1, int arg2){

	}

	@Override
	public void mouseReleased(int arg0, int arg1, int arg2){

	}

	@Override
	public void mouseWheelMoved(int arg0){

	}

	@Override
	public void inputEnded(){

	}

	@Override
	public void inputStarted(){

	}

	@Override
	public boolean isAcceptingInput(){
		return false;
	}

	@Override
	public void setInput(Input arg0){

	}

	@Override
	public void keyPressed(int arg0, char arg1){

	}

	@Override
	public void keyReleased(int arg0, char arg1){

	}

	@Override
	public void controllerButtonPressed(int arg0, int arg1){

	}

	@Override
	public void controllerButtonReleased(int arg0, int arg1){

	}

	@Override
	public void controllerDownPressed(int arg0){

	}

	@Override
	public void controllerDownReleased(int arg0){

	}

	@Override
	public void controllerLeftPressed(int arg0){

	}

	@Override
	public void controllerLeftReleased(int arg0){

	}

	@Override
	public void controllerRightPressed(int arg0){

	}

	@Override
	public void controllerRightReleased(int arg0){

	}

	@Override
	public void controllerUpPressed(int arg0){

	}

	@Override
	public void controllerUpReleased(int arg0){

	}

}
