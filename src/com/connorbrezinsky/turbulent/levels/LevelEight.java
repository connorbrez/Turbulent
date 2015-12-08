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
import com.connorbrezinsky.turbulent.Door;
import com.connorbrezinsky.turbulent.Hazard;
import com.connorbrezinsky.turbulent.Main;
import com.connorbrezinsky.turbulent.Object;
import com.connorbrezinsky.turbulent.ObjectSpawner;
import com.connorbrezinsky.turbulent.PhysicsObject;
import com.connorbrezinsky.turbulent.Platform;
import com.connorbrezinsky.turbulent.SpriteLoader;
import com.connorbrezinsky.turbulent.Switch;

public class LevelEight implements GameState {

	int stage = 0;

	Color bg = Color.white;
	public Character player = new Character(40, Main.getMidY(20) + 200, 20, 20, Color.darkGray);
	public SpriteSheet aLoader;
	public SpriteLoader sLoader;

	public PhysicsObject finishCube = new PhysicsObject(200, 600 - 20, 10, 10, Color.blue, true);
	public ObjectSpawner fcSpawner;

	public Platform[] walls = { new Platform(165, 600 - 80, 10, 80, Color.red),
			new Platform(165, 600 - 80, 80, 10, Color.red), new Platform(165 + 70, 600 - 80, 10, 80, Color.red) };

	Door finishDoor = new Door(620, 520, 10, 80, Color.blue);

	Platform obj0 = new Platform(590, 0, 250, 520, Color.black);
	Platform obj1 = new Platform(450, 550, 100, 10, Color.black);
	// Stage 1
	Platform obj2 = new Platform(0, 300, 50, 300, Color.white);
	Platform obj3 = new Platform(100, 300, 50, 300, Color.white);
	Platform obj4 = new Platform(650, 350, 150, 350, Color.white);
	Platform obj5 = new Platform(500, 350, 150, 80, Color.white);
	Platform obj6 = new Platform(200, 550, 60, 10, Color.white);
	Platform obj7 = new Platform(300, 460, 60, 10, Color.white);
	Platform obj8 = new Platform(400, 380, 60, 10, Color.white);
	Platform obj9 = new Platform(650, 200, 150, 150, Color.white);
	Platform[] obj10 = { new Platform(635, 320, 15, 10), new Platform(635, 270, 15, 10),
			new Platform(635, 220, 15, 10) };
	Platform obj11 = new Platform(510, 180, 50, 10, Color.white);
	Platform obj12 = new Platform(360, 240, 50, 10, Color.white);
	Platform obj13 = new Platform(220, 300, 50, 10, Color.white);
	Platform obj14 = new Platform(0, 200, 10, 100, Color.white);
	Platform[] obj15 = { new Platform(10, 280, 10, 10), new Platform(10, 240, 10, 10), new Platform(10, 200, 10, 10) };
	Platform obj16 = new Platform(100, 150, 50, 10, Color.white);
	Platform obj17 = new Platform(200, 100, 50, 10, Color.white);
	Platform obj18 = new Platform(300, 50, 50, 10, Color.white);
	Platform obj19 = new Platform(400, 80, 800, 10);
	Object oSprite = new Object(400, 80, 20, 10);
	Switch sOneSwitch = new Switch(600, 80 - 4, 40, 4, Color.red);
	PhysicsObject sOneCube = new PhysicsObject(600, 600 - 20, 10, 10, Color.red, true);
	ObjectSpawner sOneSpawner;
	Hazard spike1 = new Hazard(50, 600 - 20, 20F, 13);
	Hazard spike2 = new Hazard(62, 600 - 20, 20F, 13);
	Hazard spike3 = new Hazard(80, 600 - 20, 20F, 13);
	// TODO Stage 2
	Platform obj20 = new Platform(0, 600 - 100, 200, 100, Color.white);
	Platform obj21 = new Platform(300, 600 - 150, 20, 150);
	Hazard[] spikeStrip = { new Hazard(200, 600 - 20, 20F, 13), new Hazard(220, 600 - 20, 20F, 13),
			new Hazard(240, 600 - 20, 20F, 13), new Hazard(260, 600 - 20, 20F, 13),
			new Hazard(280, 600 - 20, 20F, 13) };
	Platform obj22 = new Platform(740, 550, 50, 10, Color.white);
	Platform obj23 = new Platform(640, 500, 50, 10, Color.white);
	Platform obj24 = new Platform(540, 450, 50, 10, Color.white);
	Platform obj25 = new Platform(440, 400, 50, 10, Color.white);
	Platform obj26 = new Platform(340, 350, 50, 10, Color.white);
	Platform obj27 = new Platform(240, 300, 50, 10, Color.white);
	Platform obj28 = new Platform(200, 500, 10, 10, Color.white);
	Platform obj29 = new Platform(290, 450, 10, 10, Color.white);
	Platform obj30 = new Platform(0, 200, 100, 150, Color.white);
	Platform obj31 = new Platform(450, Main.getMidY(10), 50, 10, Color.white);
	Platform obj32 = new Platform(600, Main.getMidY(10), 50, 10, Color.white);
	Platform obj33 = new Platform(800 - 100, 250, 100, 150, Color.white);
	Platform obj34 = new Platform(600, 200, 50, 10, Color.white);
	Platform obj35 = new Platform(500, 200, 10, 10);
	Platform obj36 = new Platform(400, 200, 10, 10);
	Platform obj37 = new Platform(300, 200, 10, 10);
	Platform obj38 = new Platform(200, 200, 10, 10);
	Platform obj39 = new Platform(100, 200, 10, 10);

	PhysicsObject sTwoCube = new PhysicsObject(45, 500 - 20, 10, 10, Color.red, true);
	ObjectSpawner sTwoSpawner;
	Switch sTwoSwitch = new Switch(50 - 20, 200 - 5, 40, 5, Color.red);
	// TODO Stage 3

	public Switch[] lSwitch = { new Switch(460, 550 - 50, 20, 20), new Switch(490, 550 - 50, 20, 20),
			new Switch(520, 550 - 50, 20, 20) };
	public Switch finishSwitch = new Switch(Main.getMidX(40), 600 - 5, 40, 5, Color.blue);
	public Switch sBack = new Switch(-20, -20, 20, 20);
	public float sx_1;
	float sx_2;
	float sx_3;

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
		sx_1 = finishCube.getX() - 10;
		sx_2 = sOneCube.getX() - 10;
		sx_3 = sTwoCube.getX() - 10;

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

		Level.levelFinish = new Platform(750, 600 - 60, 20, 60, iLevelFinish, Level.duration);
		Level.levelFinish.setType(Object.FINISH);
		fcSpawner = new ObjectSpawner(iPhysSpawner, Level.objSDuration);
		sOneSpawner = fcSpawner;
		sTwoSpawner = fcSpawner;

		sOneCube.setSpawnerPos(sx_2, 600 - 50);
		sTwoCube.setSpawnerPos(sx_3, 500 - 50);

		lSwitch[0].setCustomActionRadius(5, 20, 10, 80);
		lSwitch[1].setCustomActionRadius(5, 20, 10, 80);
		lSwitch[2].setCustomActionRadius(5, 20, 10, 80);

		lSwitch[0].addSprite(sLoader.getImage(4));
		lSwitch[1].addSprite(sLoader.getImage(4));
		lSwitch[2].addSprite(sLoader.getImage(4));
		spike1.addSprite(sLoader.getImage(7));
		spike2.addSprite(sLoader.getImage(7));
		spike3.addSprite(sLoader.getImage(7));
		obj10[0].addSprite(sLoader.getImage(8));
		obj10[1].addSprite(sLoader.getImage(8));
		obj10[2].addSprite(sLoader.getImage(8));
		obj15[0].addSprite(sLoader.getImage(11));
		obj15[1].addSprite(sLoader.getImage(11));
		obj15[2].addSprite(sLoader.getImage(11));
		obj19.addSprite(sLoader.getImage(8));
		oSprite.addSprite(sLoader.getImage(8));
		obj21.addSprite(sLoader.getImage(11));
		spikeStrip[0].addSprite(sLoader.getImage(7));
		spikeStrip[1].addSprite(sLoader.getImage(7));
		spikeStrip[2].addSprite(sLoader.getImage(7));
		spikeStrip[3].addSprite(sLoader.getImage(7));
		spikeStrip[4].addSprite(sLoader.getImage(7));
		obj35.addSprite(sLoader.getImage(8));
		obj36.addSprite(sLoader.getImage(8));
		obj37.addSprite(sLoader.getImage(8));
		obj38.addSprite(sLoader.getImage(8));
		obj39.addSprite(sLoader.getImage(8));
		sBack.addSprite(sLoader.getImage(2));

	}

	@Override
	public void leave(GameContainer arg0, StateBasedGame arg1) throws SlickException{

	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException{
		g.setBackground(bg);

		sBack.render(g);

		if(!lSwitch[0].isTriggered() && !lSwitch[1].isTriggered() && !lSwitch[2].isTriggered()) {
			bg = Color.white;
			finishSwitch.render(g);
			g.setColor(Color.black);
			if(sOneSwitch.isTriggered()) {
				g.setColor(Color.green);
				g.drawString("S1", 460, 550 - 70);
			}else{
				g.setColor(Color.black);
				g.drawString("S1", 460, 550 - 70);
			}

			if(!sTwoSwitch.isTriggered()) {
				g.setColor(Color.black);
				g.drawString("S2", 490, 550 - 70);
			}else{
				g.setColor(Color.green);
				g.drawString("S2", 490, 550 - 70);
			}

			g.setColor(Color.black);
			g.drawString("S3", 520, 550 - 70);
			lSwitch[0].render(g);
			lSwitch[1].render(g);
			lSwitch[2].render(g);

			g.setColor(Color.black);
			g.fillRect(sx_1 - 25, 600 - 80, 80, 80);
			finishCube.setSpawnerPos(sx_1, 600 - 50);
			finishCube.render(g, fcSpawner);

			walls[0].render(g);
			walls[1].render(g);
			walls[2].render(g);

			obj0.render(g);
			obj1.render(g);

			finishDoor.render(g);

			Level.levelFinish.render(g);

		}else if(lSwitch[0].isTriggered()) {
			stage = 1;
			bg = Color.black;
			obj2.render(g);
			spike1.render(g);
			spike2.render(g);
			spike3.render(g);
			obj3.render(g);
			obj4.render(g);
			obj5.render(g);
			obj6.render(g);
			obj7.render(g);
			obj8.render(g);
			obj9.render(g);
			obj10[0].render(g);
			obj10[1].render(g);
			obj10[2].render(g);
			obj11.render(g);
			obj12.render(g);
			obj13.render(g);
			obj14.render(g);
			obj15[0].render(g);
			obj15[1].render(g);
			obj15[2].render(g);
			obj16.render(g);
			obj17.render(g);
			obj18.render(g);
			obj19.render(g);
			oSprite.render(g);
			sOneSwitch.render(g);

			sOneCube.render(g, sOneSpawner);

		}else if(lSwitch[1].isTriggered()) {
			stage = 2;
			bg = Color.black;
			obj20.render(g);
			obj21.render(g);
			obj22.render(g);
			spikeStrip[0].render(g);
			spikeStrip[1].render(g);
			spikeStrip[2].render(g);
			spikeStrip[3].render(g);
			spikeStrip[4].render(g);
			obj23.render(g);
			obj24.render(g);
			obj25.render(g);
			obj26.render(g);
			obj27.render(g);
			obj28.render(g);
			obj29.render(g);
			obj30.render(g);
			obj31.render(g);
			obj32.render(g);
			obj33.render(g);
			obj34.render(g);
			obj35.render(g);
			obj36.render(g);
			obj37.render(g);
			obj38.render(g);
			obj39.render(g);

			sTwoSwitch.render(g);
			sTwoCube.render(g, sTwoSpawner);

		}else if(lSwitch[2].isTriggered()) {
			stage = 3;
			bg = Color.black;
		}

		player.render(g);

	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException{
		Input i = arg0.getInput();
		player.addBasicController(i, Input.KEY_A, Input.KEY_D, Input.KEY_SPACE);
		player.addPhysics();
		player.addWorldCollider();

		sBack.addCollider(player);
		sBack.addListener(player, Switch.ACTION, i);

		if(sBack.isTriggered()) {
			switch(stage){
			case 1:
				lSwitch[0].triggered = false;
				player.setPos(lSwitch[0].getX(), lSwitch[0].getY() + 21);
				break;
			case 2:
				lSwitch[1].triggered = false;
				player.setPos(lSwitch[1].getX(), lSwitch[1].getY() + 21);
				break;
			case 3:
				lSwitch[2].triggered = false;
				player.setPos(lSwitch[2].getX(), lSwitch[2].getY() + 21);
				break;
			}
			sBack.triggered = false;
		}

		if(!lSwitch[0].isTriggered() && !lSwitch[1].isTriggered() && !lSwitch[2].isTriggered()) {
			sBack.setPos(-20, -20);
			finishCube.addPhysics();
			finishCube.addPlayer(player);
			finishCube.addPlayerCollider(player);
			finishCube.addListener(i);

			finishSwitch.addCollider(player, finishCube);
			finishSwitch.addListener(player, finishCube, Switch.PRESSURE, i);

			lSwitch[0].addListener(player, Switch.ACTION, i);
			lSwitch[1].addListener(player, Switch.ACTION, i);
			lSwitch[2].addListener(player, Switch.ACTION, i);
			lSwitch[0].addCollider(player);
			lSwitch[1].addCollider(player);
			lSwitch[2].addCollider(player);

			obj0.addCollider(player);
			obj1.addCollider(player, finishCube);

			finishDoor.addCollider(player);
			finishDoor.addSwitch(finishSwitch);

			walls[0].addCollider(player, finishCube);
			walls[1].addCollider(player, finishCube);
			walls[2].addCollider(player, finishCube);

			if(lSwitch[0].isTriggered()) {
				lSwitch[0].changeSprite(sLoader.getImage(5));

			}else{
				lSwitch[0].changeSprite(sLoader.getImage(4));
			}

			if(lSwitch[1].isTriggered()) {
				lSwitch[1].changeSprite(sLoader.getImage(5));
			}else{

				lSwitch[1].changeSprite(sLoader.getImage(4));
			}

			if(lSwitch[2].isTriggered()) {
				lSwitch[2].changeSprite(sLoader.getImage(5));
			}else{
				lSwitch[2].changeSprite(sLoader.getImage(4));
			}

			Level.levelFinish.addCollider(player, finishCube);
			Level.levelFinish.setNextLevel(Level.stage[9]);
			if(Level.levelFinish.isFinished(player)) {
				Level.levelFinish.goToNextLevel(arg1);
			}
		}else if(lSwitch[0].isTriggered()) {
			player.setSpawn(200, 580);
			sBack.setPos(160, 600 - 30);

			spike1.addCollider(player);
			spike2.addCollider(player);
			spike3.addCollider(player);

			sOneCube.addListener(i);
			sOneCube.addPhysics();
			sOneCube.addPlayer(player);
			sOneCube.addPlayerCollider(player);

			sOneSwitch.addCollider(player, sOneCube);
			sOneSwitch.addListener(player, sOneCube, Switch.PRESSURE, i);

			obj2.addCollider(player, sOneCube);
			obj3.addCollider(player, sOneCube);
			obj4.addCollider(player, sOneCube);
			obj5.addCollider(player, sOneCube);
			obj6.addCollider(player, sOneCube);
			obj7.addCollider(player, sOneCube);
			obj8.addCollider(player, sOneCube);
			obj9.addCollider(player, sOneCube);
			obj10[0].addCollider(player, sOneCube);
			obj10[1].addCollider(player, sOneCube);
			obj10[2].addCollider(player, sOneCube);
			obj11.addCollider(player, sOneCube);
			obj12.addCollider(player, sOneCube);
			obj13.addCollider(player, sOneCube);
			obj14.addCollider(player, sOneCube);
			obj15[0].addCollider(player, sOneCube);
			obj15[1].addCollider(player, sOneCube);
			obj15[2].addCollider(player, sOneCube);
			obj16.addCollider(player, sOneCube);
			obj17.addCollider(player, sOneCube);
			obj18.addCollider(player, sOneCube);
			obj19.addCollider(player, sOneCube);

		}else if(lSwitch[1].isTriggered()) {
			sBack.setPos(640, 600 - 30);
			player.setSpawn(680, 600 - 30);

			obj20.addCollider(player, sTwoCube);
			obj21.addCollider(player, sTwoCube);
			obj22.addCollider(player, sTwoCube);
			obj23.addCollider(player, sTwoCube);
			obj24.addCollider(player, sTwoCube);
			obj25.addCollider(player, sTwoCube);
			obj26.addCollider(player, sTwoCube);
			obj27.addCollider(player, sTwoCube);
			obj28.addCollider(player, sTwoCube);
			obj29.addCollider(player, sTwoCube);
			obj30.addCollider(player, sTwoCube);
			obj31.addCollider(player, sTwoCube);
			obj32.addCollider(player, sTwoCube);
			obj33.addCollider(player, sTwoCube);
			obj34.addCollider(player, sTwoCube);
			obj35.addCollider(player, sTwoCube);
			obj36.addCollider(player, sTwoCube);
			obj37.addCollider(player, sTwoCube);
			obj38.addCollider(player, sTwoCube);
			obj39.addCollider(player, sTwoCube);

			sTwoCube.addListener(i);
			sTwoCube.addPhysics();
			sTwoCube.addPlayer(player);
			sTwoCube.addPlayerCollider(player);

			sTwoSwitch.addListener(player, sTwoCube, Switch.PRESSURE, i);
			sTwoSwitch.addCollider(player, sTwoCube);

			spikeStrip[0].addCollider(player);
			spikeStrip[1].addCollider(player);
			spikeStrip[2].addCollider(player);
			spikeStrip[3].addCollider(player);
			spikeStrip[4].addCollider(player);

		}else if(lSwitch[2].isTriggered()) {
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
