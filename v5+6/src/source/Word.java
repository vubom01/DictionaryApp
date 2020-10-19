package source;

public class Word {

    private String word_target;
    private String word_explain;
    private boolean check = false;

    Word() {

    }
    Word(String word_target, String word_explain) {
        this.word_target = word_target;
        this.word_explain = word_explain;
    }
    public String getWord_target() {
        return word_target;
    }
    public String getWord_explain() {
        return word_explain;
    }
    public boolean getCheck() {
        return check;
    }
    public void setWord_target(String word_target) {
        this.word_target = word_target;
    }
    public void setWord_explain(String word_explain) {
        this.word_explain = word_explain;
    }
    public void setCheck(boolean check) {
        this.check = check;
    }

}
