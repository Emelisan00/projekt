/*
 * DENNA KALSSEN ÄR VÅRT CANVAS SOM ANVÄNDS I ALLA STATES
 * HÄR SKAPAS ÄVEN GAMEMODEL SOM SKICKAS TILL ALLA STATES
 */

import javafx.scene.canvas.Canvas;

public class GamePanel extends Canvas {

	private GameModel model;

	public GamePanel(GameModel model, int width, int height) {
		this.model = model;
		this.setWidth(width);
		this.setHeight(height);

	}

	public void repaint() {
		model.draw(getGraphicsContext2D());
	}

}
