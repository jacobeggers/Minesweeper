import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Graphics;

public class Panel extends JPanel {
	
	public static final int WINDOW_WIDTH = 400;
	public static final int WINDOW_HEIGHT = 400;
	
	public Panel() {
		this.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
	}
	
	public void paint(Graphics g) {
		
		g.setColor(new Color(200, 200, 200));
		g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
		
		for (int i = 1; i < 8; i++) {
			g.setColor(new Color(100, 100, 100));
			g.drawLine(i * WINDOW_WIDTH / 8, 0, i * WINDOW_WIDTH / 8, WINDOW_HEIGHT);
		}
		for (int i = 1; i < 8; i++) {
			g.setColor(new Color(100, 100, 100));
			g.drawLine(0, i * WINDOW_WIDTH / 8, WINDOW_HEIGHT, i * WINDOW_WIDTH / 8);
		}
		
		int ii = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				
				
				if (Board.drawBoard().charAt(ii) == '#') {
					g.drawImage(new ImageIcon("tile.png").getImage(), j * (WINDOW_WIDTH / 8), i * (WINDOW_WIDTH / 8), null);
				} else if (Board.drawBoard().charAt(ii) == '*') {
					g.drawImage(new ImageIcon("mine.png").getImage(), j * (WINDOW_WIDTH / 8), i * (WINDOW_WIDTH / 8), null);
				} else if (Board.drawBoard().charAt(ii) == '1') {
					g.drawImage(new ImageIcon("one.png").getImage(), j * (WINDOW_WIDTH / 8), i * (WINDOW_WIDTH / 8), null);
				} else if (Board.drawBoard().charAt(ii) == '2') {
					g.drawImage(new ImageIcon("two.png").getImage(), j * (WINDOW_WIDTH / 8), i * (WINDOW_WIDTH / 8), null);
				} else if (Board.drawBoard().charAt(ii) == '3') {
					g.drawImage(new ImageIcon("three.png").getImage(), j * (WINDOW_WIDTH / 8), i * (WINDOW_WIDTH / 8), null);
				} else if (Board.drawBoard().charAt(ii) == '4') {
					g.drawImage(new ImageIcon("four.png").getImage(), j * (WINDOW_WIDTH / 8), i * (WINDOW_WIDTH / 8), null);
				} else if (Board.drawBoard().charAt(ii) == '5') {
					g.drawImage(new ImageIcon("five.png").getImage(), j * (WINDOW_WIDTH / 8), i * (WINDOW_WIDTH / 8), null);
				} else if (Board.drawBoard().charAt(ii) == '6') {
					g.drawImage(new ImageIcon("six.png").getImage(), j * (WINDOW_WIDTH / 8), i * (WINDOW_WIDTH / 8), null);
				} else if (Board.drawBoard().charAt(ii) == '7') {
					g.drawImage(new ImageIcon("seven.png").getImage(), j * (WINDOW_WIDTH / 8), i * (WINDOW_WIDTH / 8), null);
				} else if (Board.drawBoard().charAt(ii) == '8') {
					g.drawImage(new ImageIcon("eight.png").getImage(), j * (WINDOW_WIDTH / 8), i * (WINDOW_WIDTH / 8), null);
				}
				
				ii++;
				
			}
		}
	}
	
	public void updateWindow() {
		repaint();
	}
}