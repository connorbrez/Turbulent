package com.connorbrezinsky.turbulent;

import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;

public class SpriteLoader {

	SpriteSheet sprites;

	public SpriteLoader(SpriteSheet s) {
		sprites = s;
	}

	public void draw(int x, int y, int image){
		if(sprites != null) {
			sprites.startUse();
			if(image >= 0 && image <= 9) {
				sprites.renderInUse(x, y, image, 0);
			}else if(image >= 10 && image <= 19) {
				sprites.renderInUse(x, y, image, 1);
			}else if(image >= 20 && image <= 29) {
				sprites.renderInUse(x, y, image, 2);
			}else if(image >= 30 && image <= 39) {
				sprites.renderInUse(x, y, image, 3);
			}else if(image >= 40 && image <= 49) {
				sprites.renderInUse(x, y, image, 4);
			}else if(image >= 50 && image <= 59) {
				sprites.renderInUse(x, y, image, 5);
			}else if(image >= 60 && image <= 69) {
				sprites.renderInUse(x, y, image, 6);
			}else if(image >= 70 && image <= 79) {
				sprites.renderInUse(x, y, image, 7);
			}else if(image >= 80 && image <= 89) {
				sprites.renderInUse(x, y, image, 8);
			}else if(image >= 90 && image <= 99) {
				sprites.renderInUse(x, y, image, 9);
			}else{
				System.err.println("Error: No Image #" + image);
			}
			sprites.endUse();
		}
	}

	public Image getImage(int image){
		sprites.startUse();
		if(sprites != null) {
			if(image >= 0 && image <= 9) {
				sprites.endUse();
				return sprites.getSubImage(image, 0);
			}else if(image >= 10 && image <= 19) {
				sprites.endUse();
				return sprites.getSubImage(image, 1);
			}else if(image >= 20 && image <= 29) {
				sprites.endUse();
				return sprites.getSubImage(image, 2);
			}else if(image >= 30 && image <= 39) {
				sprites.endUse();
				return sprites.getSubImage(image, 3);
			}else if(image >= 40 && image <= 49) {
				sprites.endUse();
				return sprites.getSubImage(image, 4);
			}else if(image >= 50 && image <= 59) {
				sprites.endUse();
				return sprites.getSubImage(image, 5);
			}else if(image >= 60 && image <= 69) {
				sprites.endUse();
				return sprites.getSubImage(image, 6);
			}else if(image >= 70 && image <= 79) {
				sprites.endUse();
				return sprites.getSubImage(image, 7);
			}else if(image >= 80 && image <= 89) {
				sprites.endUse();
				return sprites.getSubImage(image, 8);
			}else if(image >= 90 && image <= 99) {
				sprites.endUse();
				return sprites.getSubImage(image, 9);
			}else{
				System.err.println("Error: No Image #" + image);
				sprites.endUse();

				return sprites.getSubImage(image, 0);
			}
		}else{
			sprites.endUse();
			return sprites.getSubImage(image, 0);

		}

	}

}
