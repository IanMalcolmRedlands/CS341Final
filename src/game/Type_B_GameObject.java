package game;

/**
 * Contrived class I need to implement a contrived adapter pattern.
 */
public class Type_B_GameObject {
	public int x, y, velocity;
	public int direction;

	public Type_B_GameObject(int x, int y) {
		this.x = x;
		this.y = y;

		direction = Direction.LEFT;
		velocity = 3;
	}
	
	public void rollDirection() {
		direction = (int) (Math.random()*4) + 1;
	}
}