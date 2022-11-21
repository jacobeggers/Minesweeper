import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame extends JFrame implements MouseListener {
	
	Panel panel = new Panel();
	
	public Frame() {
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.add(panel);
		this.pack();
		this.addMouseListener(this);
		this.setVisible(true);
		
		System.out.println();
		Bomb bomb = new Bomb(10, 8, 8);
		int[] bombX = bomb.placeBombsX();
		int[] bombY = bomb.placeBombsY();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (i != j && bombX[i] == bombX[j] && bombY[i] == bombY[j]) {
					System.out.println("Mines Overlapped");
					bombX = bomb.placeBombsX();
					bombY = bomb.placeBombsY();
				}
			}
		}
		Board.createBoard(bombX, bombY);
		System.out.println(Board.drawBoard());
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		;
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		int x = (e.getX() - 8) / (Panel.WINDOW_WIDTH / 8);
		int y = (e.getY() - 32) / (Panel.WINDOW_HEIGHT / 8);
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