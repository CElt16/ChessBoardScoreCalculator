# ChessBoardScoreCalculator

## Programın Amacı ve Çalışma Prensibi

Bu program, kullanıcının belirttiği klasördeki tüm .txt dosyalarını okuyarak içlerindeki satranç tahtası formatındaki verileri işler.

Çalışma şekli:

1- Kullanıcıdan bir dosya yolu alınır.

2- Verilen klasördeki .txt uzantılı tüm dosyalar okunur.

Her dosyadaki satranç tahtası şu formatta temsil edilir:

ks as fs vs ss fs -- ks
ps ps -- -- ps ps -- ps
-- -- ps -- -- -- -- --
-- -- -- as -- -- ps --
vb -- -- pb -- fb -- pb
-- -- ab -- -- -- -- --
pb pb -- -- pb pb pb --
kb -- -- -- sb fb ab kb
 
Bu format, programda Board nesnesine dönüştürülür.

3- Program iki aşamalı olarak tahtadaki taşları analiz eder:

  İlk aşamada, her taşın saldırabileceği kareler belirlenir ve bu karelerdeki karşı renk taşlar tehdit altında olarak işaretlenir.

  İkinci aşamada, tehdit altında olan taşların puanlarının yarısı ilgili takıma eklenir.

4- Son olarak, her tahtanın puan sonuçları (Siyah ve Beyaz takımlar için) ekrana yazdırılır.


## Kullanım Kılavuzu
 
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

🔀 Alternatif olarak: Programı bir IDE (Eclipse, IntelliJ IDEA, VS Code, vb.) ile açabilir ve çalıştırabilirsiniz.

3️⃣ Programın Çalıştırılması

Derlemeden sonra programı çalıştırmak için şu komutu yazın:
> java Main

4️⃣ Program Kullanımı

Program çalıştırıldığında, bir klasör yolu girmeniz istenir.

Klasör yolunu tam olarak yazıp Enter tuşuna basın (örnek):

C:\Users\pc\Desktop\boards
Program, belirtilen klasördeki .txt dosyalarını okuyacak ve sonuçları konsola yazdırır.

![image](https://github.com/user-attachments/assets/1ebeb157-3928-4716-935d-8780a0b956b0)

5️⃣ Hata Yönetimi
Dosya okuma sırasında bir hata oluşursa, verdiğiniz dosya yolunu bulunduran bir hata mesajı konsola yazdırılır.

![image](https://github.com/user-attachments/assets/a31af3ee-d806-478e-8997-2c97cc9d5eea)

