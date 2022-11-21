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
		int[][] occupiedSpaces = new int[width][height];
		while (numBombs > 0) {
			for (int i = 0; i < width; i++) {
				for (int j = 0; j < height; j++) {
					int chance = r.nextInt(0, tempNum);
					if (chance == 0 && occupiedSpaces[j][i] != 1 && numBombs > 0) {
						try {
							x[count] = i;
							y[count] = j;
						} catch (IndexOutOfBoundsException e) {
							System.out.println("To many mines were placed!");
						}
						occupiedSpaces[j][i] = 1;
						tempNum--;
						count++;
						numBombs--;
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