package jogo_corrida;

import java.awt.Graphics;

public class Bloco {

	public int type = 0;
	public int x,y;
	
	public Bloco(int x,int y, int type) {
		this.x = x;
		this.y = y;
		this.type = type;
	}
	
	public void render(Graphics g) {
		if(type == 0) {
			g.drawImage(Sprites.road_top, x,y,null);
		}else if(type == 1) {
			g.drawImage(Sprites.road_left, x,y,null);
		}else {
			g.drawImage(Sprites.grass, x,y,null);
		}
	}
	
}
