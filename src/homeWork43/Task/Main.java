package homeWork43.Task;

public class Main {
    public static void main(String[] args) {
        Document doc = new Document("Sample Document", "2023-11-05");
        System.out.println("Initial State: " + doc.state.getStateName());

        doc.publish();
        System.out.println("After Publishing: " + doc.state.getStateName());

        doc.delete();
        System.out.println("After Deleting: " + doc.state.getStateName());

        doc.correct();
        System.out.println("After Correcting: " + doc.state.getStateName());
    }
}