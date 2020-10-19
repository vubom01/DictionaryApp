package source;

import java.io.*;
import java.util.ArrayList;

public class DictionaryManagement {

    static database dtb = new database();

    public String dictionaryLookup(ArrayList<Word> dic, String word) {

        String res = dtb.Lookup(word);
        if (res.equals("Not found")) {
            for (int i = 0; i < dic.size(); i++) {
                if (dic.get(i).getWord_target().equals(word)) {
                    return (word + "\n-------------------------------------------------------------------------------------\n"
                            + dic.get(i).getWord_explain());
                }
            }
        }
        return res;
    }

    public ArrayList<Word> dictionarySearcher(ArrayList<Word> dic, String word) {
        ArrayList<Word> res = new ArrayList<Word>();
        for (int i=0; i<dic.size(); i++) {
            int n = dic.get(i).getWord_target().length();
            if (n >= word.length() && dic.get(i).getWord_target().substring(0, word.length()).equals(word)) {
                res.add(dic.get(i));
            }
        }
        return res;
    }

    public ArrayList<Word> insertFromFile(String fileName) {
        ArrayList<Word> dic = new ArrayList<Word>();
        BufferedReader bufferedReader = null;
        try {
            String st = null;
            bufferedReader = new BufferedReader(new FileReader(fileName));
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
                        for (int i = 0; i < word_explain.length(); i++) {
                            if (Character.compare(word_explain.charAt(i), '+') == 0
                                    && Character.compare(word_explain.charAt(i-1), '(') != 0) {
                                word_explain = word_explain.substring(0,i) + ":" + word_explain.substring(i+1,word_explain.length());
                            }
                        }
                        word.setWord_explain(word_explain);
                        dic.add(word);
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

        return dic;
    }

    public ArrayList<String> insertArrayFromFile(String fileName) {
        BufferedReader bufferedReader = null;
        ArrayList<String> res = new ArrayList<String>();
        try {
            String st = null;
            bufferedReader = new BufferedReader(new FileReader(fileName));
            while ((st = bufferedReader.readLine()) != null) {
                res.add(st);
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
        return res;
    }

    public void dictionaryExportToFile(ArrayList<String> st, String fileName) {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(fileName));
            for (int i=0; i<st.size(); i++) {
                bufferedWriter.write(st.get(i)+'\n');
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

    public void dictionaryExportWordToFile(ArrayList<Word> st, String fileName) {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(fileName));
            for (int i=0; i<st.size(); i++) {
                bufferedWriter.write("@" + st.get(i).getWord_target() + '\n' + st.get(i).getWord_explain() + '\n');
            }
            bufferedWriter.write("@");
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
