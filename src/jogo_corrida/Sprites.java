package jogo_corrida;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprites {

	public static BufferedImage road_left;
	public static BufferedImage road_top;
	public static BufferedImage grass;
	
	public Sprites() {
		try {
			road_left = ImageIO.read(getClass().getResource("/road_left.png"));
			road_top = ImageIO.read(getClass().getResource("/road_top.png"));
			grass = ImageIO.read(getClass().getResource("/grass.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

