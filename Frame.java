import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame extends JFrame implements MouseListener {
	
	Panel panel = new Panel();
	Bomb bomb = new Bomb(10, 9, 9);
	
	public Frame() {
		bomb.shuffleBombs();
		Board.createBoard(bomb.placeBombsX(), bomb.placeBombsY());
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setTitle("Minesweeper");
		this.setLocation((int)(dim.getWidth() / 2) - (Panel.WINDOW_WIDTH / 2), (int)(dim.getHeight() / 2) - (Panel.WINDOW_HEIGHT / 2));
		this.setResizable(false);
		this.add(panel);
		this.pack();
		this.addMouseListener(this);
		this.setVisible(true);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// who's idea wasd it
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		if (Board.hasLost == false && Board.hasWon == false) {
			int x = (e.getX() - 8) / (Panel.WINDOW_WIDTH / 9);
			int y = (e.getY() - 32) / (Panel.WINDOW_HEIGHT / 9);
			Board.selectOnBoard(x, y);
			panel.updateWindow();
		} else {
			bomb.shuffleBombs();
			Board.createBoard(bomb.placeBombsX(), bomb.placeBombsY());
			panel.updateWindow();
			Board.hasLost = false;
			Board.hasWon = false;
		}
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// to make it where
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		// all of these methods have to be listed 
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// despite not having any use???
	}
}