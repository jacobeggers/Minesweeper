import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame extends JFrame implements MouseListener {
	
	Panel panel = new Panel();
	
	private boolean testForOverlap(int[] bx, int[] by) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (i != j && bx[i] == bx[j] && by[i] == by[j]) {
					String testX = "";
					String testY = "";
					for (int ii = 0; ii < 10; ii++) {
						testX += bx[ii];
						testY += by[ii];
					}
					System.out.println(String.format("(%s)", testX));
					System.out.println(String.format("(%s)", testY));
					return true;
				}
			}
		}
		return false;
	}
	
	public Frame() {
		System.out.println();
		Bomb bomb = new Bomb(10, 9, 9);
		int[] bombX = bomb.placeBombsX();
		int[] bombY = bomb.placeBombsY();
		
		while (testForOverlap(bombX, bombY) == true) {
			System.out.println("Mines Overlapped");
			bombX = bomb.placeBombsX();
			bombY = bomb.placeBombsY();
		}
		
		String testX = "";
		String testY = "";
		for (int i = 0; i < 10; i++) {
			testX += bombX[i];
			testY += bombY[i];
		}
		System.out.println(String.format("(%s)", testX));
		System.out.println(String.format("(%s)", testY));

		Board.createBoard(bombX, bombY);
		System.out.println(Board.drawBoard());

		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setTitle("Minesweeper");
		this.add(panel);
		this.pack();
		this.addMouseListener(this);
		this.setVisible(true);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		;
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		int x = (e.getX() - 8) / (Panel.WINDOW_WIDTH / 9);
		int y = (e.getY() - 32) / (Panel.WINDOW_HEIGHT / 9);
		Board.selectOnBoard(x, y);
		panel.updateWindow();
		System.out.println(Board.drawBoard());
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		;
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		;
	}
}