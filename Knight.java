
class Knight extends Piece {

	public Knight(char color) {
		super(color);
		this.points = 3;
	}

	// At taşının saldırı mekaniği
	public void markThreats(Board board, int row, int col) {
		Piece[][] grid = board.grid;

		int[][] moves = { { -2, -1 }, { -2, 1 }, { -1, -2 }, { -1, 2 }, { 1, -2 }, { 1, 2 }, { 2, -1 }, { 2, 1 } };

		for (int[] move : moves) {
			int r = row + move[0];
			int c = col + move[1];

			if (r >= 0 && r < 8 && c >= 0 && c < 8) {
				Piece target = grid[r][c];
				if (target != null && target.color != this.color) {
					target.isThreatened = true;
				}
			}
		}
	}
}
