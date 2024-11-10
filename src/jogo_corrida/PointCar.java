package jogo_corrida;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class PointCar extends Rectangle{

	
	public int point = 0;
	
	public PointCar(int x,int y,int width,int height) {
		super(x,y,width,height);
	}
	
	
	public void render(Graphics g) {
		//g.setColor(Color.green);
		//g.fillRect(x, y, width, height);
	}
	
}
