import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class BoardReader {

	/**
	 * Verilen klasördeki tüm .txt dosyalarını okur, her dosya için bir Board nesnesi oluşturur,
	 * tahtayı başlatır, tehditleri işler ve puanları toplar.
	 * 
	 * @param folderPath İşlenecek .txt dosyalarının bulunduğu klasörün yolu
	 * @return İşlenen tüm tahtaların bulunduğu liste
	*/
    public List<Board> readBoardsFromFolder(String folderPath) {
    	List<Board> boards = new ArrayList<>();

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(folderPath), "*.txt")) {
            for (Path filePath : stream) {
                Board board = new Board(filePath.getFileName().toString());
                initializeBoard(filePath.toString(), board);
                board.processThreats();
                board.collectPoints();
                boards.add(board);
            }
        } catch (NoSuchFileException e) {
            System.err.println("Hata: Klasör bulunamadı - " + folderPath);
        } catch (IOException e) {
            System.err.println("Hata: Dosyalar okunurken bir hata oluştu.");
            e.printStackTrace();
        }

        return boards;
    }
    
    
    /**
     * Verilen dosya yolundaki tahta bilgilerini okur ve Board nesnesini 
     * ilgili taşlarla başlatır.
     * 
     * Dosya satır satır okunur, her satır boşluklarla ayrılan hücrelere bölünür.
     * Hücredeki değerler taş tipi ve renk koduna göre yorumlanır ve
     * ilgili taş Board'a yerleştirilir.
     * 
     * @param path Tahta bilgilerini içeren .txt dosyasının dosya konumu
     * @param board Taşların yerleştirileceği Board nesnesi
     */
    private void initializeBoard(String path, Board board) {
        try {
            List<String[]> grid = Files.lines(Paths.get(path))
                .map(line -> line.trim().split("\\s+"))
                .collect(Collectors.toList());

            for (int row = 0; row < grid.size(); row++) {
                for (int col = 0; col < grid.get(row).length; col++) {
                    String cellValue = grid.get(row)[col];
                    
                    if (cellValue.length() < 2) continue;

                    char pieceTypeChar = cellValue.charAt(0);
                    char pieceColorChar = cellValue.charAt(1);

                    Piece piece = switch (pieceTypeChar) {
                        case 'p' -> new Pawn(pieceColorChar);
                        case 's' -> new King(pieceColorChar);
                        case 'a' -> new Knight(pieceColorChar);
                        case 'f' -> new Bishop(pieceColorChar);
                        case 'v' -> new Queen(pieceColorChar);
                        case 'k' -> new Rook(pieceColorChar);
                        default  -> null;
                    };

                    if (piece != null) {
                        board.put(piece, row, col);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Hata: Dosyayı okurken bir hata oluştu: " + path);
            e.printStackTrace();
        }
    }
}
