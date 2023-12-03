package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameObjectController implements KeyListener {
	private GameObject[] objects;
	private int highlight;
	private int canvasW, canvasH;

	public GameObjectController() {
		highlight = 0;

		objects = new GameObject[4];
		objects[0] = new Type_A_GameObject(200, 200);
		// objects[0] = new Type_B_GameObject(250, 200);
		// objects[0] = new Type_C_GameObject(200, 250);
		objects[0] = new Type_D_GameObject(250, 250);

	}

	public void run(Canvas c) {
		for (GameObject obj : objects) {
			obj.move(c);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			objects[highlight].setDirection(Direction.UP);
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			objects[highlight].setDirection(Direction.DOWN);
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			objects[highlight].setDirection(Direction.LEFT);
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			objects[highlight].setDirection(Direction.RIGHT);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() != KeyEvent.VK_TAB) {
			objects[highlight].setDirection(Direction.NONE);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}
