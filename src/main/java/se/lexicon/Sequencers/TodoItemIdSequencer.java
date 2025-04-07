package se.lexicon.Sequencers;

public class TodoItemIdSequencer {
    private static int currentId = 0;

    public int nextId(){
        return ++currentId;
    }

    public static int getCurrentId() {
        return currentId;
    }

    public static void setCurrentId(int currentId) {
        TodoItemIdSequencer.currentId = currentId;
    }
}
