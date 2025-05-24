
class Pawn extends Piece {

	public Pawn(char color) {
		super(color);
		this.points = 1;
	}

	// Piyon taşının saldırı mekaniği
	public void markThreats(Board board, int row, int col) {
		Piece[][] grid = board.grid;

		if (row >= 7)
			return;

		if (col > 0) {
			Piece targetLeft = grid[row + 1][col - 1];
			if (targetLeft != null && targetLeft.color != this.color)
				targetLeft.isThreatened = true;
		}
		if (col < 7) {
			Piece targetRight = grid[row + 1][col + 1];
			if (targetRight != null && targetRight.color != this.color)
				targetRight.isThreatened = true;
		}
	}
}
