# ChessBoardScoreCalculator

Kullanım Kılavuzu
 
1️⃣ Gereksinimler
Eğer konsoldan çalıştırılacaksa,

Java Development Kit (JDK) 11 veya üstü yüklü olmalıdır.
JAVA_HOME ve PATH ortam değişkenleri ayarlanmış olmalıdır.
Komut satırına (CMD, Terminal) erişim gereklidir.

2️⃣ Projenin Derlenmesi
Komut satırını (Terminal, CMD) açın.

Proje klasörüne gidin (örneğin):
> cd C:\Users\pc\workspace\SatrancTahtaOkuyucu

Ardından bu komutu yazarak tüm .java dosyalarını derleyin:
> javac *.java

Derleme başarılı olursa .class dosyaları aynı klasörde oluşacaktır.

🔀 Alternatif olarak: Projeyi bir IDE (Eclipse, IntelliJ IDEA, VS Code, vb.) ile açabilir ve çalıştırabilirsiniz.

3️⃣ Programın Çalıştırılması
Derlemeden sonra programı çalıştırmak için şu komutu yazın:
> java Main

4️⃣ Program Kullanımı
Program çalıştırıldığında, bir klasör yolu girmeniz istenir.

Klasör yolunu tam olarak yazıp Enter tuşuna basın (örnek):

C:\Users\pc\Desktop\boards
Program, belirtilen klasördeki .txt dosyalarını okuyacak ve sonuçları konsola yazdırır.

![sonuclar](https://github.com/user-attachments/assets/077e772f-95cb-4e05-ac96-baa951e89157)

5️⃣ Hata Yönetimi
Dosya okuma sırasında bir hata oluşursa, verdiğiniz dosya yolunu bulunduran bir hata mesajı konsola yazdırılır.

Hata: Klasör bulunamadı - /verilen klasör konumu/
