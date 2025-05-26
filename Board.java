
class Board {
	public Piece[][] grid;
	private double whitePoints;
	private double blackPoints;
	private String fileName;
	private final int BOARD_SIZE = 8;

	public Board(String fileName) {
		this.fileName = fileName;
		grid = new Piece[BOARD_SIZE][BOARD_SIZE];
		this.whitePoints = 0;
		this.blackPoints = 0;
	}

	public double getWhitePoints() {
		return whitePoints;
	}

	public double getBlackPoints() {
		return blackPoints;
	}

	public String getFileName() {
		return fileName;
	}

	public void put(Piece tas, int row, int col) {
		grid[row][col] = tas;
	}

	// Tahtadaki her bir kareyi gezer. Eğer karede bir taş varsa
	// o taşın saldırı menzilindeki bütün karşı renk taşları tehdit altında olarak işaretler.
	public void processThreats() {
		for (int row = 0; row < BOARD_SIZE; ++row) {
			for (int col = 0; col < BOARD_SIZE; ++col) {
				Piece piece = grid[row][col];
				if (piece != null)
					piece.markThreats(this, row, col);				
			}
		}
	}

	// Tahtadaki her bir kareyi gezer. Gördüğü tehdit altında olan taşlardan yarı puan, tehdit altında
	// olan taşlardan tam puan toplayarak bulunduğu takıma ekler.
	public void collectPoints() {
		for (int row = 0; row < BOARD_SIZE; ++row) {
			for (int col = 0; col < BOARD_SIZE; ++col) {
				Piece piece = grid[row][col];

				if (piece == null)
					continue;

				if (piece.isThreatened)
					piece.points /= 2;

				if (piece.color == 'b')
					whitePoints += piece.points;
				else
					blackPoints += piece.points;
			}
		}
	}
}
