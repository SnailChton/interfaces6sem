import java.util.*;

public class Words implements Result {
    public ArrayList<String> wordsArray;

    Words() {}
    Words(ArrayList<String> Array) {
        this.wordsArray = (ArrayList<String>) Array.clone();
        this.wordsArray.sort(String::compareTo);
    }

    @Override
    public ArrayList<String> getResult() {
        return this.wordsArray;
    }

}

