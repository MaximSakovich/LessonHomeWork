package homeWork39.repository;

import homeWork39.lib.MyLinkedListReader;
import homeWork39.model.Reader;

// Аналогично методам для работы с читателями
public class ReaderRepository {
    private MyLinkedListReader<Reader> readers;

    public ReaderRepository() {
        this.readers = new MyLinkedListReader<>();
    }

    // Логика добавления читателя
    public void addReader(Reader reader) {
        readers.add(reader);
    }

    // Логика удаления читателя
    public void removeReader(Reader reader) {
        readers.remove(reader);
    }

    public MyLinkedListReader<Reader> getAllReaders() {
        return readers;
    }
    public Reader getReaderByName(String firstName, String lastName) {
        for (Reader reader : readers) {
            if (reader.getFirstName().equals(firstName) && reader.getLastName().equals(lastName)) {
                return reader;
            }
        }
        return null;
    }
}