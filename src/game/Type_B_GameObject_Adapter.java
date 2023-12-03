package game;

import java.util.LinkedList;
import javax.swing.Icon;
import javax.swing.ImageIcon;


public class Type_B_GameObject_Adapter extends GameObject {
	
	private Type_B_GameObject object;

	public Type_B_GameObject_Adapter(int x, int y) {
		super(x, y);
		
		object = new Type_B_GameObject(x, y);

		imageList = new LinkedList<Icon>();
		imageList.add(new ImageIcon("images/Type_B_Up.png"));
		imageList.add(new ImageIcon("images/Type_B_Down.png"));
		imageList.add(new ImageIcon("images/Type_B_Left.png"));
		imageList.add(new ImageIcon("images/Type_B_Right.png"));
	}

	public void move(Canvas c) {
		Icon icon = getCurrentImage();

		int iconHeight = icon.getIconHeight();
		int iconWidth = icon.getIconWidth();
		int canvasHeight = (int) c.getSize().getHeight();
		int canvasWidth = (int) c.getSize().getWidth();

		switch (object.direction) {
		case Direction.UP:
			object.y = object.y - object.velocity;
			if (object.y < 0) {
				object.y = 0;
			}
			break;
		case Direction.DOWN:
			object.y = object.y + object.velocity;
			if (object.y + iconHeight > canvasHeight) {
				object.y = (int) (canvasHeight - iconHeight);
			}
			break;
		case Direction.LEFT:
			object.x = object.x + object.velocity;
			if (object.x + iconWidth > canvasWidth) {
				object.x = (int) (canvasWidth - iconWidth);
			}
			break;
		case Direction.RIGHT:
			object.x = object.x - object.velocity;
			if (object.x < 0) {
				object.x = 0;
			}
			break;
		default:
			break;
		}

		setX(object.x);
		setY(object.y);
		setVelocity(object.velocity);
	}
	
	@Override
	public void setDirection(int direction) {
		super.setDirection(direction);
		object.direction = direction;
	}

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
		case Direction.LEFT:
			currentImage = 2;
			break;
		case Direction.RIGHT:
			currentImage = 3;
			break;
		default:
			break;
		}
	}

}
