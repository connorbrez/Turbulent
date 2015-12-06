package com.connorbrezinsky.turbulent;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import com.connorbrezinsky.turbulent.levels.Level;
import com.connorbrezinsky.turbulent.levels.LevelEight;
import com.connorbrezinsky.turbulent.levels.LevelFive;
import com.connorbrezinsky.turbulent.levels.LevelFour;
import com.connorbrezinsky.turbulent.levels.LevelNine;
import com.connorbrezinsky.turbulent.levels.LevelOne;
import com.connorbrezinsky.turbulent.levels.LevelSeven;
import com.connorbrezinsky.turbulent.levels.LevelSix;
import com.connorbrezinsky.turbulent.levels.LevelTen;
import com.connorbrezinsky.turbulent.levels.LevelThree;
import com.connorbrezinsky.turbulent.levels.LevelTwo;
import com.connorbrezinsky.turbulent.levels.TestChamber;

public class Main extends StateBasedGame {

	public static int viewportWidth = 800;
	public static int viewportHeight = 600;

	public static int worldsizeX = 1600;
	public static int worldsizeY = 600;

	public static int offsetMaxX = worldsizeX - viewportWidth;
	public static int offSetMaxY = worldsizeY - viewportHeight;

	public static double VERSION = 0.2;

	public static boolean buttonClick(Input input, int mx, int my, int bx, int by, int bw, int bh){
		if(mx > bx && mx < bx + bw && my > by && my < by + bh && input.isMousePressed(0)) {
			return true;
		}else{
			return false;
		}
	}

	public static int getMidX(int width){
		return viewportWidth / 2 - (width / 2);
	}

	public static int getMidY(int height){
		return viewportHeight / 2 - (height / 2);
	}

	public static boolean addCollisonBox(float x1, float y1, float w1, float h1, float x2, float y2, float w2,
			float h2){
		float boxX = x2;
		float boxY = y2;
		float boxH = h2;
		float boxW = w2;

		if(x1 >= boxX && x1 <= boxX + boxW && y1 >= boxY && y1 <= boxY + boxH) {
			return true;
		}else{
			return false;
		}
	}

	public static boolean leftBoxCollider(Character c, Object p){
		if(Main.addCollisonBox(c.getX() + c.getWidth(), c.getY(), c.getWidth(), c.getHeight(), p.x, p.y, 10,
				p.height)) {
			return true;

		}else if(c.x + c.width > p.x && c.x + c.width < p.x + 10 && c.y < p.y && c.y + c.height > p.y + p.height) {
			return true;

		}else{
			return false;
		}
	}

	public static boolean bottomBoxCollider(Character c, Object p){
		if(Main.addCollisonBox(c.getX(), c.getY(), c.getWidth(), c.getHeight(), p.x, p.y + p.height - 10, p.width,
				10)) {
			return true;
		}else
			if(c.x < p.x && c.x + c.width > p.x && c.y < p.y + p.height - 10 && c.y + c.height > p.y + p.height - 10) {
			return true;
		}else if(Main.addCollisonBox(c.getX() + c.getHeight(), c.getY(), c.getWidth(), c.getHeight(), p.x,
				p.y + p.height - 10, p.width, 10)) {
			return true;
		}else{
			return false;
		}
	}

	public static boolean topBoxCollider(Character c, Object p){
		if(Main.addCollisonBox(c.getX() + c.getWidth(), c.getY() + c.getHeight(), c.getWidth(), c.getHeight(), p.x, p.y,
				p.width, 10)) {
			return true;
		}else if(Main.addCollisonBox(c.getX(), c.getY() + c.getHeight(), c.getWidth(), c.getHeight(), p.x, p.y, p.width,
				10)) {
			return true;
		}else if(c.x < p.x && c.x + c.width > p.x && c.y + c.height > p.y && c.y + c.height < p.y + 10) {
			return true;
		}else{
			return false;
		}
	}

	public static boolean rightBoxCollider(Character c, Object p){

		if(Main.addCollisonBox(c.getX(), c.getY(), c.getWidth(), c.getHeight(), p.x + p.width - 10, p.y, 10,
				p.height)) {
			return true;
		}else if(c.x > p.x && c.x < p.x + 10 && c.y < p.y && c.y + c.height > p.y + p.height) {
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean checkCollison(Character c, Object o){
		if(c.getX()>o.getX() && c.getX()+c.getWidth() < o.getX()+o.getWidth() && c.getY()>o.getY()&&c.getY()+c.getHeight()<o.getY()+o.getHeight()){
			return true;
		}else{
			return false;
		}
	}

	
	
	
	
	public static boolean rightBoxCollider(Character c, Trigger p){

		if(Main.addCollisonBox(c.getX(), c.getY(), c.getWidth(), c.getHeight(), p.x + p.width - 10, p.y, 10,
				p.height)) {
			return true;
		}else if(c.x > p.x && c.x < p.x + 10 && c.y < p.y && c.y + c.height > p.y + p.height) {
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean leftBoxCollider(Character c, Trigger p){
		if(Main.addCollisonBox(c.getX() + c.getWidth(), c.getY(), c.getWidth(), c.getHeight(), p.x, p.y, 10,
				p.height)) {
			return true;

		}else if(c.x + c.width > p.x && c.x + c.width < p.x + 10 && c.y < p.y && c.y + c.height > p.y + p.height) {
			return true;

		}else{
			return false;
		}
	}

	public static boolean bottomBoxCollider(Character c, Trigger p){
		if(Main.addCollisonBox(c.getX(), c.getY(), c.getWidth(), c.getHeight(), p.x, p.y + p.height - 10, p.width,
				10)) {
			return true;
		}else
			if(c.x < p.x && c.x + c.width > p.x && c.y < p.y + p.height - 10 && c.y + c.height > p.y + p.height - 10) {
			return true;
		}else if(Main.addCollisonBox(c.getX() + c.getHeight(), c.getY(), c.getWidth(), c.getHeight(), p.x,
				p.y + p.height - 10, p.width, 10)) {
			return true;
		}else{
			return false;
		}
	}

	public static boolean topBoxCollider(Character c, Trigger p){
		if(Main.addCollisonBox(c.getX() + c.getWidth(), c.getY() + c.getHeight(), c.getWidth(), c.getHeight(), p.x, p.y,
				p.width, 10)) {
			return true;
		}else if(Main.addCollisonBox(c.getX(), c.getY() + c.getHeight(), c.getWidth(), c.getHeight(), p.x, p.y, p.width,
				10)) {
			return true;
		}else if(c.x < p.x && c.x + c.width > p.x && c.y + c.height > p.y && c.y + c.height < p.y + 10) {
			return true;
		}else{
			return false;
		}
	}

	public static boolean rightBoxCollider(Character c, Switch p){

		if(Main.addCollisonBox(c.getX(), c.getY(), c.getWidth(), c.getHeight(), p.x + p.width - 10, p.y, 10,
				p.height)) {
			return true;
		}else if(c.x > p.x && c.x < p.x + 10 && c.y < p.y && c.y + c.height > p.y + p.height) {
			return true;
		}else{
			return false;
		}
	}

	
	// TODO add simpler physObj collision functions here

	public static boolean rightBoxCollider(PhysicsObject c){
		return false;
	}

	public static boolean leftBoxCollider(PhysicsObject c){
		return false;
	}

	public static boolean topBoxCollider(PhysicsObject c){
		return false;
	}

	public static boolean bottomBoxCollider(PhysicsObject c){
		return false;
	}

	public static boolean getKeyPress(Input i, int key){
		if(i.isKeyPressed(key) && i.isKeyDown(key)) {
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean getControllerPress(Input i, int button){
		if(i.getControllerCount()>1){
			if(i.isControlPressed(button)){
				i.clearControlPressedRecord();
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}

	public Main(String name) {
		super("Turbulent v" + VERSION);

		/*
		 * addState this.addState(new State(state));
		 */

		this.addState(new LevelOne(Level.stage[1]));
		this.addState(new LevelTwo(Level.stage[2]));
		this.addState(new LevelThree(Level.stage[3]));
		this.addState(new LevelFour(Level.stage[4]));
		this.addState(new LevelFive(Level.stage[5]));
		this.addState(new LevelSix(Level.stage[6]));
		this.addState(new LevelSeven(Level.stage[7]));
		this.addState(new LevelEight(Level.stage[8]));
		this.addState(new LevelNine(Level.stage[9]));
		this.addState(new LevelTen(Level.stage[10]));
		this.addState(new TestChamber(Level.testChamber));

	}

	@Override
	public void initStatesList(GameContainer arg0) throws SlickException{

		/*
		 * Init state this.getState(state).init(GameContaniner, this);
		 */

		this.getState(Level.stage[1]).init(arg0, this);
		this.getState(Level.stage[2]).init(arg0, this);
		this.getState(Level.stage[3]).init(arg0, this);
		this.getState(Level.stage[4]).init(arg0, this);
		this.getState(Level.stage[5]).init(arg0, this);
		this.getState(Level.stage[6]).init(arg0, this);
		this.getState(Level.stage[7]).init(arg0, this);
		this.getState(Level.stage[8]).init(arg0, this);
		this.getState(Level.stage[9]).init(arg0, this);
		this.getState(Level.stage[10]).init(arg0, this);
		this.getState(Level.testChamber).init(arg0, this);

	}

	public static void main(String[] args){

		AppGameContainer a;
		try{

			a = new AppGameContainer(new Main("game"));
			a.setDisplayMode(viewportWidth, viewportHeight, false);
			a.setVSync(true);
			a.setTargetFrameRate(60);
			a.start();

		}catch(SlickException e){
			e.printStackTrace();
		}

	}

}
