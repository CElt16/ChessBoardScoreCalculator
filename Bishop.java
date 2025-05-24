
class Bishop extends Piece {

	public Bishop(char color) {
		super(color);
		this.points = 3;
	}

	// Fil taşının saldırı mekaniği
	public void markThreats(Board board, int row, int col) {
		Piece[][] grid = board.grid;

		int[][] directions = { { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };

		for (int[] dir : directions) {
			int r = row + dir[0];
			int c = col + dir[1];

			while (r >= 0 && r < 8 && c >= 0 && c < 8) {
				Piece target = grid[r][c];
				if (target != null) {
					if (target.color != this.color) {
						target.isThreatened = true;
					}
					break;
				}
				r += dir[0];
				c += dir[1];
			}
		}
	}
}
