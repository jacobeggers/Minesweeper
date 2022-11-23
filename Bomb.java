import java.util.Random;

public class Bomb {
	private int numBombs;
	private int width;
	private int height;
	private int[] x;
	private int[] y;
	Random r = new Random();

	public Bomb(int numBombs, int width, int height) {
		this.numBombs = numBombs;
		this.x = new int[numBombs];
		this.y = new int[numBombs];
		this.width = width;
		this.height = height;
	}
	
	public void shuffleBombs() {
		int tempNum = width * height;
		int count = 0;
		int tempBombs = numBombs;
		int[][] occupiedSpaces = new int[height][width];
		while (tempBombs > 0) {
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					int chance = r.nextInt(0, tempNum);
					if (chance == 0 && occupiedSpaces[i][j] != 1 && tempBombs > 0) {
						try {
							x[count] = j;
							y[count] = i;
						} catch (IndexOutOfBoundsException e) {
							System.out.println("Too many mines were placed!");
						}
						occupiedSpaces[i][j] = 1;
						tempNum--;
						count++;
						tempBombs--;
					}
				}
			}
		}
	}

	public int[] placeBombsX() {
		return x;
	}

	public int[] placeBombsY() {
		return y;
	}
}