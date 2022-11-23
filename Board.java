public class Board {
	private static int width = Panel.TILE_COLS;
	private static int height = Panel.TILE_ROWS;
	private static char[][] boardLayout;
	private static char[][] boardCover;
	private static boolean[][] boardChecked;
	
	public static boolean hasLost = false;
	public static boolean hasWon = false;

	public static void createBoard(int[] x, int[] y) {
		char[][] makeBoard = new char[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				makeBoard[i][j] = ' ';
			}
		}

		char[][] makeCover = new char[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				makeCover[i][j] = '#';
			}
		}
		boardCover = makeCover;

		boolean[][] makeChecked = new boolean[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				makeChecked[i][j] = false;
			}
		}
		boardChecked = makeChecked;
		
		for (int i = 0; i < x.length; i++) {
			makeBoard[y[i]][x[i]] = '*';
		}
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				int iii = 0;
				if (makeBoard[i][j] != '*') {
					for (int ii = -1; ii < 2; ii++) {
						for (int jj = -1; jj < 2; jj++) {
							try {
								if (makeBoard[i + ii][j + jj] == '*') {
									iii++;
								}
							} catch (IndexOutOfBoundsException e) {
								;
							}
						}
					}
					if (iii > 0) {
						makeBoard[i][j] = (char)(iii + '0');
					}
				}
			}
		}
		boardLayout = makeBoard;
	}

	public static void selectOnBoard(int x, int y) {
		if (boardLayout[y][x] == ' ') {
			boardCover[y][x] = ' ';
			for (int k = 0; k < (width * height); k++) {
				for (int i = 0; i < height; i++) {
					for (int j = 0; j < width; j++) {
						if (boardLayout[i][j] == ' ' && boardCover[i][j] == ' ' && boardChecked[i][j] == false) {
							boardChecked[i][j] = true;
							for (int ii = -1; ii < 2; ii++) {
								for (int jj = -1; jj < 2; jj++) {
									try {
										boardCover[i + ii][j + jj] = ' ';
									} catch (IndexOutOfBoundsException e) {
										;
									}
								}
							}
						}
					}
				}
			}
		} else if (boardLayout[y][x] == '*') {
			hasLost = true;
			boardCover[y][x] = ' ';
		} else {
			boardCover[y][x] = ' ';
		}
		int countTile = 0;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (boardCover[i][j] == '#') {
					countTile++;
				}
			}
		}
		if (countTile == Panel.BOMB_NUMBER && boardLayout[y][x] != '*') {
			hasWon = true;
		}
	}

	public static String drawBoard() {
		String result = "";
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (boardCover[i][j] == '#') {
					result += '#';
				} else {
					result += boardLayout[i][j];
				}
			}
		}
		return result;
	}
}