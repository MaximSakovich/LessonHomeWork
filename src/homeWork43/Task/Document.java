package homeWork43.Task;

public class Document {
    private final String title;
    private final String registrationDate;
    public State state;

    public Document(String title, String registrationDate) {
        this.title = title;
        this.registrationDate = registrationDate;
        this.state = State.DRAFT;
    }

    public void publish() {
        if (state == State.DRAFT) {
            state = State.PUBLISHED;
        } else {
            System.out.println("Ошибка: Нельзя опубликовать документ, который не находится в стадии 'В разработке'.");
        }
    }

    public void delete() {
        if (state != State.DELETED) {
            state = State.DELETED;
        } else {
            System.out.println("Ошибка: Документ уже удален.");
        }
    }

    public void correct() {
        if (state == State.PUBLISHED) {
            state = State.DRAFT;
        } else {
            System.out.println("Ошибка: Нельзя отправить на редакцию документ, который не был опубликован.");
        }
    }
}
