package game;

import java.util.LinkedList;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Type_A_GameObject extends GameObject {
	
	public Type_A_GameObject(int x, int y) {
		super(x, y);
		setDirection(Direction.UP);
		setVelocity(3);

		imageList = new LinkedList<Icon>();
		imageList.add(new ImageIcon("images/Type_A_Up.png"));
		imageList.add(new ImageIcon("images/Type_A_Down.png"));
	}

	public void move(Canvas c) {
		Icon icon = getCurrentImage();

		int iconHeight = icon.getIconHeight();
		int canvasHeight = (int) c.getSize().getHeight();

		// MOVE BLUE GAME OBJECT
		switch (getDirection()) {
		case Direction.UP:
			setY(getY() - getVelocity());
			if (getY() < 0) {
				setY(0);
				setDirection(Direction.DOWN);
			}
			break;
		case Direction.DOWN:
			setY(getY() + getVelocity());
			if (getY() + iconHeight > canvasHeight) {
				setY((int) (canvasHeight - iconHeight));
				setDirection(Direction.UP);
			}
			break;
		default:
			break;
		}

	}
	
	@Override
	public void setDirection(int direction) {
		if (direction==Direction.UP || direction==Direction.DOWN || direction==Direction.NONE) {
			super.setDirection(direction);
		}
	}

	// SPECIFY THE IMAGE TO DISPLAY
	// USED FOR ANIMATION
	public void setImage() {
		switch (getDirection()) {
		case Direction.NONE:
			break;
		case Direction.UP:
			currentImage = 0;
			break;
		case Direction.DOWN:
			currentImage = 1;
			break;
		default:
			break;
		}
	}
}
