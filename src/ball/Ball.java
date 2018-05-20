package ball;

import javax.swing.Timer;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Ball extends JPanel {
	private int delay = 10; // Create a timer with delay 1000 ms
	private Timer timer = new Timer(delay, new TimerListener());
	private int x = 0;
	private int y = 0; // Current ball position
	private int radius = 5; // Ball radius
	private int dx = 2; // Increment on ball's x-coordinate
	private int dy = 2; // Increment on ball's y-coordinate
	private ArrayList<newBalls> balls = new ArrayList<>();
	

	public Ball() {
		timer.start();
	}

	private class TimerListener implements ActionListener {
		/** Handle the action event */
		public void actionPerformed(ActionEvent e) {
			repaint();
		}
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.red);
		if (x < radius)
			dx = Math.abs(dx); // Check boundaries
		if (x > getWidth() - radius)
			dx = -Math.abs(dx);
		if (y < radius)
			dy = Math.abs(dy);
		if (y > getHeight() - radius)
			dy = -Math.abs(dy);
		x += dx; // Adjust ball position
		y += dy;
		g.fillOval(x - radius, y - radius, radius * 2, radius * 2);

		for (int i = 0; i < balls.size(); i++) {
			g.setColor(balls.get(i).c);
			if (balls.get(i).x < balls.get(i).radius)
				balls.get(i).dx = Math.abs(balls.get(i).dx); // Check boundaries
			if (balls.get(i).x > getWidth() - balls.get(i).radius)
				balls.get(i).dx = -Math.abs(balls.get(i).dx);
			if (balls.get(i).y < balls.get(i).radius)
				balls.get(i).dy = Math.abs(balls.get(i).dy);
			if (balls.get(i).y > getHeight() - balls.get(i).radius)
				balls.get(i).dy = -Math.abs(balls.get(i).dy);
			balls.get(i).x += balls.get(i).dx; // Adjust ball position
			balls.get(i).y += balls.get(i).dy;
			g.fillOval(balls.get(i).x - balls.get(i).radius, balls.get(i).y - balls.get(i).radius,
					balls.get(i).radius * 2, balls.get(i).radius * 2);
		}
	}

	public void addBall(Color c, int radius) {

		balls.add(new newBalls(c, radius));

	}

	public void suspend() {
		timer.stop();
	} // Suspend timer

	public void resume() {
		timer.start();
	} // Resume timer

	public void setDelay(int delay) {
		this.delay = delay;
		timer.setDelay(delay);
	}

	public class newBalls {

		private int x = 0;
		private int y = 0; // Current ball position
		private int radius;
		private int dx = 2; // Increment on ball's x-coordinate
		private int dy = 2;
		private Color c;

		public newBalls(Color c, int radius) {

			this.dx = dx;
			this.dy = dy;
			this.radius = radius;
			this.x = x;
			this.y = y;
			this.c = c;

		}

	}

}
