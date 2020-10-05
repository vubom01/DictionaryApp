package dic;

public class DictionaryCommandline {

    DictionaryManagement DicM = new DictionaryManagement();

    DictionaryCommandline(){

    }

    public void dictionaryBasic() {
        DicM.insertFromCommandline();
        DicM.showAllWords();
    }

    public void dictionaryAdvanced(String word_lookup) {
        DicM.insertFromFile();
        DicM.deleteWord("string");
        DicM.deleteWord("happy");
        DicM.showAllWords();
        DicM.dictionaryLookup(word_lookup);
    }
}

