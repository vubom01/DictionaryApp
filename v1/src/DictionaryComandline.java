public class DictionaryComandline {

    DictionaryManagement DicM = new DictionaryManagement();

    DictionaryComandline() {

    }

    public void showAllWords(Dictionary dic) {
        System.out.printf("%-10s%-20s%-20s\n","No", "| English", "| Vietnamese");
        for (int i = 0; i < dic.getCntWord(); i++) {
            System.out.printf("%-10d%-20s%-20s\n",i+1,"| "+dic.getWord(i).getWord_target(),"| "+dic.getWord(i).getWord_explain());
        }
    }

    public void dictionaryBasic() {
        DicM.insertFromCommandline();
        showAllWords(DicM.getDic());
    }
}
