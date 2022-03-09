/*
 * DETTA ÄR KLASSEN FÖR FIENDEN REDBALL. 
 * DEN HAR KOLL PÅ DENS KOORDINATER OCH RÖRELSE, OM ARROWN INTERSECTAT MED DEN OCH VILKEN IMAGE DEN HAR
 * OCH RITAR ÄVEN UT IMAGEN 
 */

import static constants.Constants.SCREEN_HEIGHT;
import static constants.Constants.SCREEN_WIDTH;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class RedBall {

	private int xCoords;
	private int yCoords;
	private int size;
	private int xSpeed;
	private int ySpeed;
	private static Image redBallImage;
	private Boolean hasBeenHit;

	public RedBall(int xCoords, int yCoords, int size) {
		this.xCoords = xCoords;
		this.yCoords = yCoords;
		this.size = size;
		xSpeed = 34;
		ySpeed = 10;
		this.hasBeenHit = false;
	}

	public static void setPic() {

		try {
			redBallImage = new Image(
					new FileInputStream("C:\\Users\\Emelie Bergeryd\\eclipse-TDDE10\\Projekt\\src\\redBall7.png"));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}

	public boolean intersect(Arrow arrow) {
		Rectangle2D theArrow = new Rectangle2D(arrow.getXCoords(), arrow.getYCoords(), 70, 100);
		Rectangle2D theBall = new Rectangle2D(getXCoords(), getYCoords(), size, size);
		return theArrow.intersects(theBall);
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
		gc.drawImage(redBallImage, xCoords, yCoords, size, size);

	}

	public void update() {
		xCoords = xCoords + xSpeed;
		yCoords = yCoords + ySpeed;
		if (yCoords > SCREEN_HEIGHT - (size + 30) || yCoords < 0) {
			ySpeed = ySpeed * -1;

		} else if (xCoords > SCREEN_WIDTH - 140 || xCoords < 0) {
			xSpeed = xSpeed * -1;

		}

	}

	public void destroy() {
		this.yCoords = 0;
	}

	public void setHasBeenHit(boolean hasBeenHit) {
		this.hasBeenHit = hasBeenHit;
	}

	public boolean getHasBeenHit() {
		return hasBeenHit;
	}

	public int getSize() {
		return size;
	}

}
