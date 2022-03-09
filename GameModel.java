/*
 * DENNA KLASSEN REPRESENTERAR DET STATET VI ÄR I JUST NU.
 * KLASSEN HÅLLER KOLL PÅ VILKET STATE VI ÄR I MED HJÄLP AV METODEN SWITCHSTATE
 * KLASSEN HÅLLER ÄVEN PÅ POÄNGEN FÖR SPELET SOM SPELAS JUST NU
 */
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class GameModel {
	private GameState currentState;
	private int score = 0;

	public GameModel() {
		this.currentState = new MenuState(this);

	}

	public void switchState(GameState nextState) {
		currentState.deactivate();
		currentState = nextState;
		currentState.activate();
	}

	public void keyPressed(KeyEvent key) {
		currentState.keyPressed(key);
	}

	public void mousePressed(MouseEvent event) {

		currentState.mousePressed(event);
	}

	public void update() {
		currentState.update();
	}

	public void draw(GraphicsContext gc) {
		currentState.draw(gc);
	}

	public void setState(GameState currentState) {
		this.currentState = currentState;
	}

	public GameState getState() {

		return currentState;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
