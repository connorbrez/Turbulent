package com.connorbrezinsky.turbulent;

import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;

public class SpriteLoader {

	SpriteSheet sprites;
	SpriteSheet[] sprites_;

	// TODO make animation loader

	public SpriteLoader(SpriteSheet s) {
		sprites = s;
	}

	public SpriteLoader(SpriteSheet[] s) {
		sprites_ = s;
	}

	public void draw(int x, int y, int image, int spritesheet){
		if(sprites_[spritesheet] != null) {
			sprites_[spritesheet].startUse();
			if(image >= 0 && image <= 9) {
				sprites_[spritesheet].renderInUse(x, y, image, 0);
			}else if(image >= 10 && image <= 19) {
				sprites_[spritesheet].renderInUse(x, y, image, 1);
			}else if(image >= 20 && image <= 29) {
				sprites_[spritesheet].renderInUse(x, y, image, 2);
			}else if(image >= 30 && image <= 39) {
				sprites_[spritesheet].renderInUse(x, y, image, 3);
			}else if(image >= 40 && image <= 49) {
				sprites_[spritesheet].renderInUse(x, y, image, 4);
			}else if(image >= 50 && image <= 59) {
				sprites_[spritesheet].renderInUse(x, y, image, 5);
			}else if(image >= 60 && image <= 69) {
				sprites_[spritesheet].renderInUse(x, y, image, 6);
			}else if(image >= 70 && image <= 79) {
				sprites_[spritesheet].renderInUse(x, y, image, 7);
			}else if(image >= 80 && image <= 89) {
				sprites_[spritesheet].renderInUse(x, y, image, 8);
			}else if(image >= 90 && image <= 99) {
				sprites_[spritesheet].renderInUse(x, y, image, 9);
			}else{
				System.err.println("Error: No Image #" + image);
			}
			sprites_[spritesheet].endUse();
		}else{
			System.err.println("Error: No Spritesheet #" + spritesheet);
		}
	}

	public Image getImage(int image, int spritesheet){
		sprites_[spritesheet].startUse();
		if(sprites_[spritesheet] != null) {
			if(image >= 0 && image <= 9) {
				sprites_[spritesheet].endUse();
				return sprites_[spritesheet].getSubImage(image, 0);
			}else if(image >= 10 && image <= 19) {
				sprites_[spritesheet].endUse();
				return sprites_[spritesheet].getSubImage(image - 10, 1);
			}else if(image >= 20 && image <= 29) {
				sprites_[spritesheet].endUse();
				return sprites_[spritesheet].getSubImage(image - 20, 2);
			}else if(image >= 30 && image <= 39) {
				sprites_[spritesheet].endUse();
				return sprites_[spritesheet].getSubImage(image - 30, 3);
			}else if(image >= 40 && image <= 49) {
				sprites_[spritesheet].endUse();
				return sprites_[spritesheet].getSubImage(image - 40, 4);
			}else if(image >= 50 && image <= 59) {
				sprites_[spritesheet].endUse();
				return sprites_[spritesheet].getSubImage(image - 50, 5);
			}else if(image >= 60 && image <= 69) {
				sprites_[spritesheet].endUse();
				return sprites_[spritesheet].getSubImage(image - 60, 6);
			}else if(image >= 70 && image <= 79) {
				sprites_[spritesheet].endUse();
				return sprites_[spritesheet].getSubImage(image - 70, 7);
			}else if(image >= 80 && image <= 89) {
				sprites_[spritesheet].endUse();
				return sprites_[spritesheet].getSubImage(image - 80, 8);
			}else if(image >= 90 && image <= 99) {
				sprites_[spritesheet].endUse();
				return sprites_[spritesheet].getSubImage(image - 90, 9);
			}else{
				System.err.println("Error: No Image #" + image);
				sprites_[spritesheet].endUse();

				return sprites_[spritesheet].getSubImage(image, 0);
			}
		}else{
			sprites_[spritesheet].endUse();
			return sprites_[spritesheet].getSubImage(image, 0);

		}

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
				return sprites.getSubImage(image - 10, 1);
			}else if(image >= 20 && image <= 29) {
				sprites.endUse();
				return sprites.getSubImage(image - 20, 2);
			}else if(image >= 30 && image <= 39) {
				sprites.endUse();
				return sprites.getSubImage(image - 30, 3);
			}else if(image >= 40 && image <= 49) {
				sprites.endUse();
				return sprites.getSubImage(image - 40, 4);
			}else if(image >= 50 && image <= 59) {
				sprites.endUse();
				return sprites.getSubImage(image - 50, 5);
			}else if(image >= 60 && image <= 69) {
				sprites.endUse();
				return sprites.getSubImage(image - 60, 6);
			}else if(image >= 70 && image <= 79) {
				sprites.endUse();
				return sprites.getSubImage(image - 70, 7);
			}else if(image >= 80 && image <= 89) {
				sprites.endUse();
				return sprites.getSubImage(image - 80, 8);
			}else if(image >= 90 && image <= 99) {
				sprites.endUse();
				return sprites.getSubImage(image - 90, 9);
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
