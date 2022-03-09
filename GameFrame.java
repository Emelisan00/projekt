/*
 * DENNA KLASSEN EXTENDAR HBOX OCH ANVÄNDS FÖR ATT SKAPA GAMEPANEL OCH LÄGGA TILL PANELEN I GAMEFRAMEN
 */
import javafx.scene.layout.HBox;

public class GameFrame extends HBox {
	private GamePanel gp;

	public GameFrame(GameModel model, int width, int height) {
		gp = new GamePanel(model, width, height);
		this.getChildren().add(gp);

	}

	public void repaint() {
		gp.repaint();

	}
}
