package game;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameObjectController implements KeyListener {
	private GameObject[] objects;
	private int highlight;

	public GameObjectController() {
		highlight = 0;

		objects = new GameObject[4];
		objects[0] = new Type_A_GameObject(200, 200);
		objects[1] = new Type_B_GameObject_Adapter(400, 200);
		objects[2] = new Type_C_GameObject(200, 400);
		objects[3] = new Type_D_GameObject(400, 400);
	}

	public void run(Canvas c) {
		for (GameObject obj : objects) {
			obj.move(c);
		}
	}

	public void draw(Component c, Graphics g) {
		for (GameObject obj : objects) {
			obj.draw(c, g);
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
		} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			objects[highlight].setDirection(Direction.NONE);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_TAB) {
			highlight = (++highlight)%objects.length;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}
