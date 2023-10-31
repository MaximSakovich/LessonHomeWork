package homeWork39.model;

import java.util.Date;

public class Book {
    private String title;
    private String author;
    private int id;
    private boolean isTaken;// взята ли книга кем-то в настоящее время

    private String takenDate;//дата выдачи книги читателю

   private Reader reader;

    public Book(String title, String author, int id, boolean isTaken) {
        this.title = title;
        this.author = author;
        this.id = id;
        this.isTaken = isTaken;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", id=" + id +
                ", isTaken=" + isTaken +
                ", takenDate=" + takenDate +
                ", reader=" + reader +
                '}';
    }

    public Reader getReader() {return this.reader;
 }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }

    public String getTakenDate() {
        return takenDate;
    }

    public void setTakenDate(String takenDate) {
        this.takenDate = takenDate;
    }

  public void setReader(Reader reader) {
   this.reader = reader;
    }
}
