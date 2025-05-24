
abstract class Piece {
	double points; // Taşın puan değeri
	char color; // siyah için 's', beyaz için 'b'
	boolean isThreatened; // Taş tehdit altında mı
	
	/**
	 * Verilen konumdan itibaren taşın oluşturduğu tüm tehditleri kontrol etmek için abstract metod.
	 * @param board İşlem yapılacak tahta
	 * @param row Taşın satır indeksi
	 * @param col Taşın sütun indeksi
	 */
	abstract void markThreats(Board board, int row, int col);
	
	public Piece(char color) {
		this.color = color;
		this.isThreatened = false;
	}
}
