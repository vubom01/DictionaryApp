import java.util.Scanner;

public class DictionaryComandline {

    static DictionaryManagement DicM = new DictionaryManagement();

    DictionaryComandline() {

    }

    public static void showAllWords(Dictionary dic) {
        System.out.printf("%-10s%-20s%-20s\n","No", "| English", "| Vietnamese");
        for (int i = 0; i < dic.getCntWord(); i++) {
            System.out.printf("%-10d%-20s%-20s\n",i+1,"| "+dic.getWord(i).getWord_target(),"| "+dic.getWord(i).getWord_explain());
        }
    }

    public void dictionaryBasic() {
        DicM.insertFromCommandline();
        showAllWords(DicM.getDic());
    }

    public void dictionaryAdvanced() {
        DicM.insertFromFile("data\\dictionaries.txt");
        showAllWords(DicM.getDic());
        //DicM.dictionaryLookup();
        Dictionary dic = dictionarySearcher();
        DicM.dictionaryExportToFile(dic, "data\\output.txt");
    }

    public static Dictionary dictionarySearcher() {
        Scanner scan = new Scanner(System.in);
        String word = scan.next();
        scan.close();
        Dictionary res = new Dictionary();
        Dictionary dic = DicM.getDic();
        for (int i = 0; i < dic.getCntWord(); i++) {
            int n = dic.getWord(i).getWord_target().length();
            if (n >= word.length() && dic.getWord(i).getWord_target().substring(0, word.length()).equals(word)) {
                int j = res.getCntWord();
                res.setWord(j, dic.getWord(i));
                res.setCntWord(res.getCntWord() + 1);
            }
        }
        return res;
    }
}
