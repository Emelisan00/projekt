/*
 * DETTA ÄR KLASSEN FÖR VAPNET ARROW. 
 * DEN HAR KOLL PÅ DENS KOORDINATER OCH VILKEN IMAGE DEN HAR
 * OCH RITAR ÄVEN UT IMAGEN 
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Arrow {

	private int xCoords;
	private int yCoords;
	private int size;
	private static Image arrowImage;
	private int ySpeed;

	public Arrow(int xCoords, int yCoords, int size) {
		this.xCoords = xCoords;
		this.yCoords = yCoords;
		this.size = size;
		ySpeed = 18;

	}

	public int getXCoords() {
		return xCoords;
	}

	public void setXCoords(int xCoords) {
		this.xCoords = xCoords;
	}

	public int getYCoords() {
		return yCoords;
	}

	public void setYCoords(int yCoords) {
		this.yCoords = yCoords;
	}

	public void draw(GraphicsContext gc) {
		gc.drawImage(arrowImage, xCoords, yCoords, size, size);
	}

	public void update() {
		if (getYCoords() > -700) {
			setYCoords(getYCoords() - ySpeed);

		}
	}

	public static void setPic() {
		try {
			arrowImage = new Image(
					new FileInputStream("C:\\Users\\Emelie Bergeryd\\eclipse-TDDE10\\Projekt\\src\\arrow3.png"));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}

}
