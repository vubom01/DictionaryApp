import java.util.Scanner;

public class DictionaryManagement {
    private Dictionary dic = new Dictionary();

    DictionaryManagement(){

    }

    public Dictionary getDic() {
        return dic;
    }

    public void addWord(Word word) {
        dic.setWord(dic.getCntWord(), word);
        dic.setCntWord(dic.getCntWord()+1);
    }

    public void deleteWord(String word) {
        int n = dic.getCntWord();
        for (int i=0; i<n; i++) {
            if (dic.getWord(i).getWord_target().equals(word)) {
                for (int j=i; j<n; j++) {
                    dic.setWord(j, dic.getWord((j+1)));
                }
                dic.setCntWord(dic.getCntWord()-1);
                return;
            }

        }
    }

    public void changeWord(String word_target, String word_explain) {
        for (int i=0; i<dic.getCntWord(); i++) {
            if (dic.getWord(i).getWord_target().equals(word_target)) {
                dic.getWord(i).setWord_explain(word_explain);
            }
        }
    }

    public void insertFromCommandline() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String endl = scan.nextLine();
        for (int i = 0; i < n; i++) {
            Word word = new Word();
            word.setWord_target(scan.nextLine());
            word.setWord_explain(scan.nextLine());
            addWord(word);
        }
        scan.close();
    }
}
