package game;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Canvas extends JComponent implements ActionListener {
	// DEFAULT SERIAL NUMBER
	private static final long serialVersionUID = 1L;

	//GAME LOOP USES A FRAME AND TIMER
	private JFrame frame;
	private Timer gameLoopTimer;
	
	private GameObjectController objectController;
	


	public Canvas() {
		// TASK 1: CREATE A LIST OF CHARACTERS THAT WILL APPEAR ON THE CANVAS
		objectController = new GameObjectController();
		this.addKeyListener(objectController);

		// TASK 2: CREATE A WINDOW FOR THE APPLICATION
		frame = new JFrame("Animation Canvas");
		frame.setSize(800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);

		// TASK 3: CONSTRUCT A TIMER FOR GAME LOOP
		gameLoopTimer = new Timer(25, this);
		gameLoopTimer.start();
		
		setFocusTraversalKeysEnabled(false);

		// TASK 4: MAKE THE WINDOW VISIBLE
		frame.setVisible(true);

	}


	/**
	 * Draws the GameObject graphic onto the Canvas
	 */
	public synchronized void paint(Graphics g) {
		objectController.draw(this, g);
	}
	
	
	// ****************************************************
	// Canvas must implement the inherited abstract method
	// ActionListener.actionPerformed(ActionEvent)
	public synchronized void actionPerformed(ActionEvent e) {
		objectController.run(this);
		repaint();
	}
}
