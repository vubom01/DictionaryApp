package dic;

import java.io.*;

public class DictionaryManagement {

    private Dictionary dic = new Dictionary();

    DictionaryManagement() {

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

    public String dictionaryLookup(String word) {
        for (int i=0; i<dic.getCntWord(); i++) {
            if (dic.getWord(i).getWord_target().equals(word)) {
                return (word+"\n-------------------------------------------------------------------------------------------------------------------\n"
                        +dic.getWord(i).getWord_explain());
            }
        }
        return "Not found";
    }

    public Dictionary dictionarySearcher(String word) {
        Dictionary res = new Dictionary();
        for (int i=0; i<dic.getCntWord(); i++) {
            int n = dic.getWord(i).getWord_target().length();
            if (n >= word.length() && dic.getWord(i).getWord_target().substring(0, word.length()).equals(word)) {
                int j = res.getCntWord();
                res.setWord(j, dic.getWord(i));
                res.setCntWord(res.getCntWord()+1);
            }
        }
        return res;
    }

    public void insertFromFile() {
        BufferedReader bufferedReader = null;
        try {
            String st = null;
            bufferedReader = new BufferedReader(new FileReader("data\\dictionaries.txt"));
            String word_target = "";
            String word_explain = "";
            while ((st = bufferedReader.readLine()) != null) {
                if (st.length()>0 && Character.compare(st.charAt(0), '@') == 0) {
                    Word word = new Word();
                    if (word_target.length() > 0) {
                        word.setWord_target(word_target);
                        if (word_explain.length()>0 && Character.compare(word_explain.charAt(0), '\n') == 0) {
                            word_explain = word_explain.substring(1,word_explain.length());
                        }
                        word.setWord_explain(word_explain);
                        addWord(word);
                    }
                    int i = st.indexOf('/');
                    if (i>0) {
                        word_target = st.substring(1, i-1);
                        word_explain = st.substring(i, st.length());
                    }
                    else {
                        word_target = st.substring(1, st.length());
                        word_explain = "";
                    }
                }
                if (st.length() == 0) word_explain = word_explain + '\n';
                else if (Character.compare(st.charAt(0), '@') != 0)
                    word_explain = word_explain + '\n' + st;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void dictionaryExportToFile(Dictionary dic) {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter("data\\out.txt"));
            for (int i=0; i<dic.getCntWord(); i++) {
                bufferedWriter.write(dic.getWord(i).getWord_target()+": "+dic.getWord(i).getWord_explain()+'\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
