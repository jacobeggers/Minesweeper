import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Graphics;

public class Panel extends JPanel {
	
	public static final int TILE_COLS = 30;
	public static final int TILE_ROWS = 16; 
	
	public static final int BOMB_NUMBER = 99;
	
	public static final int WINDOW_WIDTH = TILE_COLS * 50;
	public static final int WINDOW_HEIGHT = TILE_ROWS * 50;
	
	public Panel() {
		this.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
	}
	
	public void paint(Graphics g) {
		
		g.setColor(new Color(200, 200, 200));
		g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
		
		for (int i = 1; i < TILE_COLS; i++) {
			g.setColor(new Color(100, 100, 100));
			g.drawLine(i * WINDOW_WIDTH / TILE_COLS, 0, i * WINDOW_WIDTH / TILE_COLS, WINDOW_HEIGHT);
		}
		for (int i = 1; i < TILE_ROWS; i++) {
			g.setColor(new Color(100, 100, 100));
			g.drawLine(0, i * WINDOW_HEIGHT / TILE_ROWS, WINDOW_WIDTH, i * WINDOW_HEIGHT / TILE_ROWS);
		}
		
		int ii = 0;
		for (int i = 0; i < TILE_ROWS; i++) {
			for (int j = 0; j < TILE_COLS; j++) {
				
				try {
					if (Board.drawBoard().charAt(ii) == '#') {
						g.drawImage(new ImageIcon("tile.png").getImage(), j * (WINDOW_WIDTH / TILE_COLS), i * (WINDOW_HEIGHT / TILE_ROWS), null);
					} else if (Board.drawBoard().charAt(ii) == '*') {
						g.drawImage(new ImageIcon("mine.png").getImage(), j * (WINDOW_WIDTH / TILE_COLS), i * (WINDOW_HEIGHT / TILE_ROWS), null);
					} else if (Board.drawBoard().charAt(ii) == '1') {
						g.drawImage(new ImageIcon("one.png").getImage(), j * (WINDOW_WIDTH / TILE_COLS), i * (WINDOW_HEIGHT / TILE_ROWS), null);
					} else if (Board.drawBoard().charAt(ii) == '2') {
						g.drawImage(new ImageIcon("two.png").getImage(), j * (WINDOW_WIDTH / TILE_COLS), i * (WINDOW_HEIGHT / TILE_ROWS), null);
					} else if (Board.drawBoard().charAt(ii) == '3') {
						g.drawImage(new ImageIcon("three.png").getImage(), j * (WINDOW_WIDTH / TILE_COLS), i * (WINDOW_HEIGHT / TILE_ROWS), null);
					} else if (Board.drawBoard().charAt(ii) == '4') {
						g.drawImage(new ImageIcon("four.png").getImage(), j * (WINDOW_WIDTH / TILE_COLS), i * (WINDOW_HEIGHT / TILE_ROWS), null);
					} else if (Board.drawBoard().charAt(ii) == '5') {
						g.drawImage(new ImageIcon("five.png").getImage(), j * (WINDOW_WIDTH / TILE_COLS), i * (WINDOW_HEIGHT / TILE_ROWS), null);
					} else if (Board.drawBoard().charAt(ii) == '6') {
						g.drawImage(new ImageIcon("six.png").getImage(), j * (WINDOW_WIDTH / TILE_COLS), i * (WINDOW_HEIGHT / TILE_ROWS), null);
					} else if (Board.drawBoard().charAt(ii) == '7') {
						g.drawImage(new ImageIcon("seven.png").getImage(), j * (WINDOW_WIDTH / TILE_COLS), i * (WINDOW_HEIGHT / TILE_ROWS), null);
					} else if (Board.drawBoard().charAt(ii) == '8') {
						g.drawImage(new ImageIcon("eight.png").getImage(), j * (WINDOW_WIDTH / TILE_COLS), i * (WINDOW_HEIGHT / TILE_ROWS), null);
					}
					
					ii++;
				} catch (NullPointerException e) {
					;
				}
			}
		}
		if (Board.hasLost == true) {
			g.drawImage(new ImageIcon("lose.png").getImage(), (WINDOW_WIDTH / 2) - 100, (WINDOW_HEIGHT / 2) - 50, null);
		}
		if (Board.hasWon == true) {
			g.drawImage(new ImageIcon("win.png").getImage(), (WINDOW_WIDTH / 2) - 100, (WINDOW_HEIGHT / 2) - 50, null);
		}
	}
	
	public void updateWindow() {
		repaint();
	}
}