package jogo_corrida;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player {

	public int width = 88;
	public int height = 40;
	
	public double x,y;
	public double dx,dy;
	public double speed = 0;
	public double aceleration = 2;
	public double rotation = 0;
	
	public BufferedImage sprite;
	
	public boolean right = false;
	public boolean left = false;
	
	public boolean up = false;
	
	public int lastPoint = 0;
	
	public Player(int x,int y) {
		this.x = x;
		this.y = y;
		
		try {
			sprite = ImageIO.read(getClass().getResource("/carro_player.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void tick() {
		if(right) {
			rotation+=8;
		}else if(left) {
			rotation-=8;
		}
		
		for(int i = 0; i < Main.blocos.size(); i++) {
			Rectangle boxCarro = new Rectangle((int)x,(int)y,88/2,40/2);
			Rectangle bloco = new Rectangle(Main.blocos.get(i).x,Main.blocos.get(i).y,48,48);
			if(boxCarro.intersects(bloco)) {
				if(Main.blocos.get(i).type > 1) {
					//Grama
					if(speed >= 4) {
						speed = 4;
					}
				}
			}
		}
		
		if(up) {
			speed+=aceleration;
			if(speed >= 15) {
				speed = 15;
			}

		}else {
			speed-=aceleration;
			if(speed <=0) {
				speed = 0;
			}
		}
		
		dx = Math.cos(Math.toRadians(rotation));
		dy = Math.sin(Math.toRadians(rotation));
		x+=dx*speed;
		y+=dy*speed;
		
		Rectangle boxCarro = new Rectangle((int)x,(int)y,88/2,40/2);
		if(boxCarro.intersects(Main.point1)) {
			lastPoint = 1;
		}
		else if(boxCarro.intersects(Main.point2)) {
			if(lastPoint == 1) {
				Main.voltas++;
			}
			lastPoint = 2;
		}
		
	}
	
	public void render(Graphics2D g2) {
		g2.rotate(Math.toRadians(rotation),x+width/2 /2,y+height/2 /2);
		g2.drawImage(sprite,(int)x,(int)y,width/2,height/2,null);
		g2.rotate(Math.toRadians(-rotation),x+width/2 /2,y+height/2 /2);
	}
	
}
