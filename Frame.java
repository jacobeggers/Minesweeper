import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame extends JFrame implements MouseListener {
	
	Panel panel = new Panel();
	
	public Frame() {
		System.out.println();
		Bomb bomb = new Bomb(10, 9, 9);
		
		bomb.shuffleBombs();
		
		int[] bombX = bomb.placeBombsX();
		int[] bombY = bomb.placeBombsY();

		Board.createBoard(bombX, bombY);

		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setTitle("Minesweeper");
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
		int x = (e.getX() - 8) / (Panel.WINDOW_WIDTH / 9);
		int y = (e.getY() - 32) / (Panel.WINDOW_HEIGHT / 9);
		Board.selectOnBoard(x, y);
		panel.updateWindow();
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