package homeWork43.Task;

public enum State {
    DRAFT("В разработке"),
    PUBLISHED("Опубликованный"),
    DELETED("удаленный");

    private final String stateName;

    State(String stateName) {
        this.stateName = stateName;
    }

    public String getStateName() {
        return stateName;
    }
}
