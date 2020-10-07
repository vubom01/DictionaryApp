package dic;

public class Dictionary {

    private Word[] words = new Word[200000];
    private int cntWord ;

    Dictionary() {

    }

    public int getCntWord() {
        return cntWord;
    }
    public Word getWord(int i) {
        return words[i];
    }
    public void setCntWord(int cntWord) {
        this.cntWord = cntWord;
    }
    public void setWord(int i, Word word) {
        this.words[i] = word;
    }
}