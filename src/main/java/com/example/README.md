# Paragraph Analyzer

Aplikasi **Java berbasis konsol** sederhana yang menganalisis sebuah paragraf dan memberikan statistik dasar teks seperti:

- Jumlah kata  
- Jumlah kalimat  
- Jumlah karakter  
- Rata-rata panjang kata  


## Fitur

- Menganalisis paragraf yang dimasukkan oleh pengguna  
- Mendeteksi jumlah kalimat (dengan pemisah `.`, `!`, atau `?`)  
- Menghitung jumlah kata dan karakter (tidak termasuk spasi)  
- Menghitung rata-rata panjang kata  
- Menentukan apakah paragraf tergolong **pendek** atau **panjang**


## Struktur Proyek

src/

└── main/

└── java/

└── com/

└── example/

└── ParagraphAnalysis.java

---

## Cara Menjalankan Program

1. **Kompilasi program:**
   ```bash
   javac com/example/ParagraphAnalysis.java
2. **Jalankan program:**
   ```bash
   java com.example.ParagraphAnalysis
3. **Ikuti menu di layar:**
   ```bash
   === PARAGRAPH ANALYZER ===
   1. Analyze a paragraph
   2. Exit
4. **Contoh hasil output:**
   ```bash
   Masukkan sebuah paragraf:
   Hello world! This is a simple test.

   --- ANALYSIS RESULT ---
   Paragraph: Hello world! This is a simple test.
   Word count: 6
   Sentence count: 2
   Character count: 27
   Average word length: 4.50
   This is a short paragraph.

---

## Deskripsi Kelas
### ParagraphAnalysis

|        Metode       |                                              Deskripsi                                             |
|:-------------------:|:--------------------------------------------------------------------------------------------------:|
| main(String[] args) |                                  Titik awal program (entry point).                                 |
|        run()        |                        Menjalankan loop utama untuk menu dan input pengguna.                       |
|     printMenu()     |                                  Menampilkan menu utama di layar.                                  |
|   getMenuChoice()   |                         Membaca dan memvalidasi pilihan menu dari pengguna.                        |
|  analyzeParagraph() | Meminta input paragraf dari pengguna dan  menjalankan analisis menggunakan kelas ParagraphAnalyzer |

### ParagraphAnalyzer

|          Metode          |                                     Deskripsi                                    |
|:------------------------:|:--------------------------------------------------------------------------------:|
|      getwordCount()      |                      Menghitung jumlah kata dalam paragraf.                      |
|    getSentenceCount()    |                     Menghitung jumlah kalimat dalam paragraf.                    |
|    getCharacterCount()   |                    Menghitung jumlah karakter dalam paragraf.                    |
|  getAverageWordLength()  |                        Menghitung rata-rata panjang kata.                        |
|       printReport()      |                       Menampilkan hasil analisis ke layar.                       |
| getParagraphLengthType() | Menentukan apakah paragraf tergolong panjang atau pendek (panjang = kalimat > 2) |

## Lisensi

Proyek ini bersifat open-source dan bebas digunakan untuk keperluan pembelajaran.