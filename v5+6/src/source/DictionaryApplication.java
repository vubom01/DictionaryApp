package source;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import javafx.scene.control.TextFormatter;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


public class DictionaryApplication extends javax.swing.JFrame {

    static DictionaryManagement DicM = new DictionaryManagement();
    public static ArrayList<Word> Dic = new ArrayList<Word>();
    public static ArrayList<Word> DicAdd = new ArrayList<Word>();
    public static ArrayList<String> DicHistory = new ArrayList<String>();
    public static ArrayList<String> DicLike = new ArrayList<String>();
    static Voice voice = VoiceManager.getInstance().getVoice("kevin16");

    DictionaryApplication() {

    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btn_history = new javax.swing.JButton();
        btn_lookup = new javax.swing.JButton();
        checklike = new javax.swing.JCheckBox();
        btn_wordlike = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tf_keyword = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        list_suggest = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        meaning = new javax.swing.JEditorPane();
        btn_speak = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu_add = new javax.swing.JMenu();
        menu_delete = new javax.swing.JMenu();
        menu_change = new javax.swing.JMenu();
        menu_yourword = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        btn_history.setBackground(new java.awt.Color(0, 0, 0));
        btn_history.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/history.png")));
        btn_history.setBorder(null);
        btn_history.setBorderPainted(false);
        btn_history.setContentAreaFilled(false);
        btn_history.setFocusPainted(false);
        btn_history.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_historyActionPerformed(evt);
            }
        });

        btn_lookup.setFont(new java.awt.Font("Tahoma", 0, 14));
        btn_lookup.setForeground(new java.awt.Color(255, 255, 255));
        btn_lookup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search.png")));
        btn_lookup.setText("Search");
        btn_lookup.setBorder(null);
        btn_lookup.setBorderPainted(false);
        btn_lookup.setContentAreaFilled(false);
        btn_lookup.setFocusPainted(false);
        btn_lookup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lookupActionPerformed(evt);
            }
        });

        checklike.setBackground(new java.awt.Color(51, 51, 51));
        checklike.setFont(new java.awt.Font("Tahoma", 0, 14));
        checklike.setForeground(new java.awt.Color(255, 255, 255));
        checklike.setText("Like");
        checklike.setFocusPainted(false);
        checklike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checklikeActionPerformed(evt);
            }
        });


        btn_wordlike.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/wordlike.png")));
        btn_wordlike.setBorder(null);
        btn_wordlike.setBorderPainted(false);
        btn_wordlike.setContentAreaFilled(false);
        btn_wordlike.setFocusPainted(false);
        btn_wordlike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_wordlikeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(btn_lookup, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_history, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_wordlike, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(checklike)
                                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 26, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btn_lookup, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                                        .addComponent(btn_history, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(checklike, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btn_wordlike, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/definition.png")));
        jLabel1.setText("Definition");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
        );

        tf_keyword.setFont(new java.awt.Font("Tahoma", 0, 14));
        tf_keyword.setToolTipText("Enter your word");
        tf_keyword.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(204, 0, 0)));
        tf_keyword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_keywordKeyReleased(evt);
            }
        });

        list_suggest.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        list_suggest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                list_suggestMouseClicked(evt);
            }
        });
        list_suggest.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                list_suggestKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(list_suggest);

        meaning.setEditable(false);
        meaning.setContentType("text/html");
        meaning.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane2.setViewportView(meaning);

        btn_speak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/speak.png")));
        btn_speak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_speakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(tf_keyword, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btn_speak, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(tf_keyword, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                                                        .addComponent(btn_speak, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE))
                                        .addComponent(jScrollPane2))
                                .addContainerGap())
        );

        menu_add.setText("Add");
        menu_add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_addMouseClicked(evt);
            }
        });
        jMenuBar1.add(menu_add);

        menu_delete.setText("Delete");
        menu_delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_deleteMouseClicked(evt);
            }
        });
        jMenuBar1.add(menu_delete);

        menu_change.setText("Change");
        menu_change.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_changeMouseClicked(evt);
            }
        });
        jMenuBar1.add(menu_change);

        menu_yourword.setText("YourWord");
        menu_yourword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_yourwordMouseClicked(evt);
            }
        });
        jMenuBar1.add(menu_yourword);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setVisible(true);
        setTitle("DICTIONARY BY LEHUYVU");
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void tf_keywordKeyReleased(java.awt.event.KeyEvent evt) {
        String KeyWord = tf_keyword.getText();
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btn_lookupActionPerformed(new java.awt.event.ActionEvent(meaning, 0, ""));
        }
        list_suggest.clearSelection();
        ArrayList<Word> DicS = DicM.dictionarySearcher(Dic, KeyWord);
        DefaultListModel listModel = new DefaultListModel();
        for (int i=0; i<DicS.size(); i++) {
            listModel.addElement(DicS.get(i).getWord_target());
        }
        list_suggest.setModel(listModel);
    }

    private void btn_lookupActionPerformed(java.awt.event.ActionEvent evt) {
        String KeyWord = tf_keyword.getText();
        String res = DicM.dictionaryLookup(Dic, KeyWord);
        meaning.setText(res);
        if (!res.equals("Not found")) {
            for (int i=0; i<DicHistory.size(); i++) {
                if (DicHistory.get(i).equals(KeyWord)) {
                    DicHistory.remove(i);
                    break;
                }
            }
            if (DicHistory.size()>100) {
                DicHistory.remove(0);
            }
            DicHistory.add(KeyWord);
            DicM.dictionaryExportToFile(DicHistory,"data/history.txt");
        }
        int kt = 0;
        for (int i=0; i<DicLike.size(); i++) {
            if (DicLike.get(i).equals(KeyWord)) {
                kt = 1;
                break;
            }
        }
        if (kt == 1) checklike.setSelected(true);
        else checklike.setSelected(false);
    }

    private void list_suggestMouseClicked(java.awt.event.MouseEvent evt) {
        String KeyWord = list_suggest.getModel().getElementAt(list_suggest.getSelectionModel().getAnchorSelectionIndex());
        tf_keyword.setText(KeyWord);
        btn_lookupActionPerformed(new java.awt.event.ActionEvent(meaning, 0, ""));
    }

    private void list_suggestKeyReleased(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String KeyWord = list_suggest.getModel().getElementAt(list_suggest.getSelectionModel().getAnchorSelectionIndex());
            tf_keyword.setText(KeyWord);
            btn_lookupActionPerformed(new java.awt.event.ActionEvent(meaning, 0, ""));
        }
    }

    private void btn_speakActionPerformed(java.awt.event.ActionEvent evt) {
        voice.speak(tf_keyword.getText());
    }

    private void btn_historyActionPerformed(java.awt.event.ActionEvent evt) {
        tf_keyword.setText("");
        list_suggest.clearSelection();
        DefaultListModel listModel = new DefaultListModel();
        for (int i=0; i<DicHistory.size(); i++) {
            listModel.addElement(DicHistory.get(DicHistory.size()-i-1));
        }
        list_suggest.setModel(listModel);
    }

    private void btn_wordlikeActionPerformed(java.awt.event.ActionEvent evt) {
        tf_keyword.setText("");
        list_suggest.clearSelection();
        DefaultListModel listModel = new DefaultListModel();
        for (int i=0; i<DicLike.size(); i++) {
            listModel.addElement(DicLike.get(DicLike.size()-i-1));
        }
        list_suggest.setModel(listModel);
    }

    private void checklikeActionPerformed(java.awt.event.ActionEvent evt) {
        String KeyWord = tf_keyword.getText();
        String res = DicM.dictionaryLookup(Dic, KeyWord);
        if (!res.equals("Not found")) {
            boolean kt = checklike.isSelected();
            if (kt == false) {
                DicLike.remove(KeyWord);
            }
            else {
                DicLike.add(KeyWord);
            }
            DicM.dictionaryExportToFile(DicLike,"data/listlike.txt");
        }
    }


    private void menu_addMouseClicked(java.awt.event.MouseEvent evt) {
        AddWord app = new AddWord();
    }

    private void menu_deleteMouseClicked(java.awt.event.MouseEvent evt) {
        DeleteWord app = new DeleteWord();
    }

    private void menu_changeMouseClicked(java.awt.event.MouseEvent evt) {
        ChangeWord app = new ChangeWord();
    }

    private void menu_yourwordMouseClicked(java.awt.event.MouseEvent evt) {
        tf_keyword.setText("");
        list_suggest.clearSelection();
        DefaultListModel listModel = new DefaultListModel();
        for (int i=0; i<DicAdd.size(); i++) {
            listModel.addElement(DicAdd.get(DicAdd.size()-i-1).getWord_target());
        }
        list_suggest.setModel(listModel);
    }

    private javax.swing.JButton btn_history;
    private javax.swing.JButton btn_lookup;
    private javax.swing.JButton btn_speak;
    private javax.swing.JButton btn_wordlike;
    private javax.swing.JCheckBox checklike;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> list_suggest;
    private javax.swing.JEditorPane meaning;
    private javax.swing.JTextField tf_keyword;
    private javax.swing.JMenu menu_add;
    private javax.swing.JMenu menu_change;
    private javax.swing.JMenu menu_delete;
    private javax.swing.JMenu menu_yourword;
    private javax.swing.JMenuBar jMenuBar1;

    public void runApplicaiton() {
        initComponents();
        Dic = DicM.insertFromFile("data/dictionaries.txt");
        DicAdd = DicM.insertFromFile("data/wordadd.txt");
        for (int i=0; i<DicAdd.size(); i++) {
            Dic.add(DicAdd.get(i));
        }
        DicHistory = DicM.insertArrayFromFile("data/history.txt");
        DicLike = DicM.insertArrayFromFile("data/listlike.txt");
        voice.allocate();
        voice.setRate(190);
        voice.setPitch(150);
        voice.setVolume(100);
    }
}
