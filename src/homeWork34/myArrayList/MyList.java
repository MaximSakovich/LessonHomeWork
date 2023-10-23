package homeWork34.myArrayList;

public interface MyList<T> {
    void add(T value);

    void addAll(T... values);

    int size();

    int indexOf(T value);

    int lastIndexOf(T value);

    boolean contains(T value);

    T[] toArray();

   boolean remove(T value);

    T remove(int index);

    // Отвечает на вопрос является ли коллекция пустой
    // написать метод валидации isPasswordValid
    boolean isEmpty();

    T get(int index);
}