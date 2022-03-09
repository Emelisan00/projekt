/*
 * DENNA KLASSEN ÄR STATEN MAN KOMMER TILL OM MAN HAR FÖRLORAT SPELET
 * DEN VISAR TYDLIGT ATT MAN HAR FÖRLORAT OCH FÖRKLARAR HUR MAN TAR SIG TILLBAKA TILL MENYN
 */

import static constants.Constants.SCREEN_HEIGHT;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class GameOverState extends GameState {
	private String gameOverText;
	private String informationText;
	private Color bgColor;
	private Color fontColor;

	public GameOverState(GameModel model) {
		super(model);
		gameOverText = "GAME OVER\n";
		informationText = "Press ESCAPE to return to the Menu";
		bgColor = Color.DARKSLATEGREY;
		fontColor = Color.ORANGE;
		changeHS(model);
	}

	private void changeHS(GameModel model) {
		try {
			InputStream inputStream = new FileInputStream(
					"C:\\Users\\Emelie Bergeryd\\eclipse-TDDE10\\Projekt\\src\\highscore.txt");
			InputStreamReader isReader = new InputStreamReader(inputStream);
			BufferedReader reader = new BufferedReader(isReader);
			StringBuffer sb = new StringBuffer();
			String str;
			while ((str = reader.readLine()) != null) {
				sb.append(str);
			}
			if (Integer.valueOf(sb.toString()) < model.getScore()) {
				FileWriter fileWriter = new FileWriter(
						"C:\\Users\\Emelie Bergeryd\\eclipse-TDDE10\\Projekt\\src\\highscore.txt");
				fileWriter.write(Integer.toString(model.getScore()));
				fileWriter.close();
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Override
	public void keyPressed(KeyEvent key) {
		System.out.println("Trycker på " + key.getCode() + " i PlayState");

		if (key.getCode() == KeyCode.ESCAPE) {
			model.switchState(new MenuState(model));

		}
	}

	@Override
	public void draw(GraphicsContext gc) {
		drawBg(gc, bgColor);

		gc.setFill(fontColor);
		gc.setFont(new Font(90));
		gc.fillText(gameOverText, 520, SCREEN_HEIGHT / 2);
		gc.fillText(informationText, 100, 550);

	}

	@Override
	public void activate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deactivate() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent key) {
		// TODO Auto-generated method stub

	}

}
