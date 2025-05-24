
class King extends Piece {

	public King(char color) {
		super(color);
		this.points = 100;
	}

	// Şah taşının saldırı mekaniği
	public void markThreats(Board board, int row, int col) {
		Piece[][] grid = board.grid;

		int[][] directions = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

		for (int[] dir : directions) {
			int r = row + dir[0];
			int c = col + dir[1];

			if (r >= 0 && r < 8 && c >= 0 && c < 8) {
				Piece target = grid[r][c];
				if (target != null && target.color != this.color) {
					target.isThreatened = true;
				}
			}
		}
	}
}
