import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        System.out.print("Lütfen .txt satranç tahtalarının bulunduğu klasörün tam konumununu giriniz: ");
        String folderPath = scanner.nextLine();

        BoardReader reader = new BoardReader();
        
        List<Board> boards = reader.readBoardsFromFolder(folderPath);

        printResults(boards);

        scanner.close();
	}
	
	
	/**
	 * Listede bulunan Board nesnelerinin dosya adlarını ve puan sonuçlarını
	 * formatlı bir şekilde konsola yazdırır.
	 * 
	 * @param boards Yazdırılacak Board nesnelerinin listesi
	*/
	public static void printResults(List<Board> boards) {
		System.out.println("Tahta Dosya Adı\t\tSonuçlar");
		for(Board board : boards) {
			String fileName = board.getFileName();
		    double blackScore = board.getBlackPoints();
		    double whiteScore = board.getWhitePoints();

		    System.out.println(fileName + "\t\tSiyah:" + blackScore + "\tBeyaz:" + whiteScore);
		}
	}

}
