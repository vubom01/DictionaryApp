package source;

import javax.swing.*;
import java.util.ArrayList;

public class DeleteWord extends javax.swing.JFrame {

    static DictionaryManagement DicM = new DictionaryManagement();

    public DeleteWord() {
        initComponents();
    }

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        btn_delete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Enter your word_delete:");

        btn_delete.setText("Delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(0, 101, Short.MAX_VALUE))
                                        .addComponent(jScrollPane1))
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_delete)
                                .addGap(112, 112, 112))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_delete)
                                .addGap(0, 16, Short.MAX_VALUE))
        );

        pack();
        setVisible(true);
        setTitle("DeleteWord");
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {
        String word = jTextArea1.getText();
        dispose();
        Windows app = new Windows();
        app.jLabel1.setText("Successful!");
        DictionaryApplication dic = new DictionaryApplication();
        for (int i=0; i<dic.DicAdd.size(); i++) {
            if (dic.DicAdd.get(i).getWord_target().equals(word)) {
                dic.DicAdd.remove(i);
            }
        }
        DicM.dictionaryExportWordToFile(dic.DicAdd, "data/wordadd.txt");
        for (int i=0; i<dic.DicHistory.size(); i++) {
            if (dic.DicHistory.get(i).equals(word)) {
                dic.DicHistory.remove(i);
            }
        }
        for (int i=0; i<dic.DicLike.size(); i++) {
            if (dic.DicLike.get(i).equals(word)) {
                dic.DicLike.remove(i);
            }
        }
        for (int i=0; i<dic.Dic.size(); i++) {
            if (dic.Dic.get(i).getWord_target().equals(word)) {
                dic.Dic.remove(i);
            }
        }
        DicM.dictionaryExportToFile(dic.DicHistory,"data/history.txt");
        DicM.dictionaryExportToFile(dic.DicLike,"data/listlike.txt");
    }

    private javax.swing.JButton btn_delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
}
