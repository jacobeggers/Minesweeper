import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame extends JFrame implements MouseListener {
	
	Panel panel = new Panel();
	
	public Frame() {
		System.out.println();
		Bomb bomb = new Bomb(20, 9, 9);
		
		bomb.shuffleBombs();
		
		int[] bombX = bomb.placeBombsX();
		int[] bombY = bomb.placeBombsY();
		
		String testX = "";
		String testY = "";
		for (int i = 0; i < 20; i++) {
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