public class Board {
	private static int width = 8;
	private static int height = 8;
	private static String[][] boardLayout;
	private static String[][] boardCover;
	private static boolean[][] boardChecked;
	public static final String ANSI_RED = "\033[0;31m";
	public static final String ANSI_RESET = "\033[0;37m";

	public static void createBoard(int[] x, int[] y) {
		String[][] makeBoard = new String[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				makeBoard[i][j] = " ";
			}
		}

		String[][] makeCover = new String[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				makeCover[i][j] = "#";
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
			makeBoard[y[i]][x[i]] = "*";
		}
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				int iii = 0;
				if (makeBoard[i][j] != "*") {
					for (int ii = -1; ii < 2; ii++) {
						for (int jj = -1; jj < 2; jj++) {
							try {
								if (makeBoard[i + ii][j + jj].equals("*")) {
									iii++;
								}
							} catch (IndexOutOfBoundsException e) {
								;
							}
						}
					}
					if (iii > 0) {
						makeBoard[i][j] = Integer.toString(iii);
					}
				}
			}
		}
		boardLayout = makeBoard;
	}

	public static void selectOnBoard(int x, int y) {
		if (boardLayout[y][x].equals(" ")) {
			boardCover[y][x] = " ";
			for (int k = 0; k < (width * height); k++) {
				for (int i = 0; i < height; i++) {
					for (int j = 0; j < width; j++) {
						if (boardLayout[i][j].equals(" ") && boardCover[i][j].equals(" ") && boardChecked[i][j] == false) {
							boardChecked[i][j] = true;
							for (int ii = -1; ii < 2; ii++) {
								for (int jj = -1; jj < 2; jj++) {
									try {
										boardCover[i + ii][j + jj] = " ";
									} catch (IndexOutOfBoundsException e) {
										;
									}
								}
							}
						}
					}
				}
			}
		} else {
			boardCover[y][x] = " ";
		}
	}

	public static String drawBoard() {
		String result = "";
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (boardCover[i][j].equals("#")) {
					result += "#";
				} else {
					result += boardLayout[i][j];
				}
			}
		}
		return result;
	}
}