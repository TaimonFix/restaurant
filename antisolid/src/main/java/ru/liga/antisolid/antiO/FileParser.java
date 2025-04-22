package ru.liga.antisolid.antiO;

/**
 * Open/Closed
 * Нарушение: создан класс {@link FileParser}, который самостоятельно обрабатывает поддерживаемые
 * форматы файлов, при этом класс закрыт для расширения.
 */
public final class FileParser {

    public static void parseFile(FileFormat fileFormat, String fileName) {
        switch (fileFormat) {
            case PDF, DOCX -> System.out.println("Парсинг файла: " + fileName);
            default -> System.out.println("Парсер не поддерживается для данного типа файла.");
        }
    }

    public static void main(String[] args) {
        parseFile(FileFormat.DOCX, "test.docx");
        parseFile(FileFormat.XLSX, "test.xlsx");
    }
}
