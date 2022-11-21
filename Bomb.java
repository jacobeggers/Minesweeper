import java.util.Random;

public class Bomb {
	private int numBombs;
	private int width;
	private int height;
	Random r = new Random();

	public Bomb(int numBombs, int width, int height) {
		this.numBombs = numBombs;
		this.width = width;
		this.height = height;
	}

	public int[] placeBombsX() {
		int[] x = new int[numBombs];
		for (int i = 0; i < numBombs; i++) {
			x[i] = r.nextInt(0, width);
		}
		return x;
	}

	public int[] placeBombsY() {
		int[] y = new int[numBombs];
		for (int i = 0; i < numBombs; i++) {
			y[i] = r.nextInt(0, height);
		}
		return y;
	}
}