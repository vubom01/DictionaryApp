package source;

import javax.swing.*;

public class ChangeWord extends javax.swing.JFrame {

    static DictionaryManagement DicM = new DictionaryManagement();

    public ChangeWord() {
        initComponents();
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_target = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ta_explain = new javax.swing.JTextArea();
        btn_changeword = new javax.swing.JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Word_target:");

        ta_target.setColumns(20);
        ta_target.setRows(5);
        jScrollPane1.setViewportView(ta_target);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Change Word_explain:");

        ta_explain.setColumns(20);
        ta_explain.setRows(5);
        jScrollPane2.setViewportView(ta_explain);

        btn_changeword.setText("Change");
        btn_changeword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_changewordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel2))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(jScrollPane2))
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(164, 164, 164)
                                .addComponent(btn_changeword)
                                .addContainerGap(167, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                                .addComponent(btn_changeword)
                                .addContainerGap())
        );

        pack();
        setVisible(true);
        setTitle("ChangeWord");
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void btn_changewordActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
        Windows app = new Windows();
        app.jLabel1.setText("Successful!");
        
        String target = ta_target.getText();
        String explain = ta_explain.getText();

        DictionaryApplication dic = new DictionaryApplication();
        for (int i=0; i<dic.Dic.size(); i++) {
            if (dic.Dic.get(i).getWord_target().equals(target)) {
                dic.Dic.get(i).setWord_explain(explain);
            }
        }
        for (int i=0; i<dic.DicAdd.size(); i++) {
            if (dic.DicAdd.get(i).getWord_target().equals(target)) {
                dic.DicAdd.get(i).setWord_explain(explain);
            }
        }
        DicM.dictionaryExportWordToFile(dic.DicAdd, "data/wordadd.txt");

    }

    private javax.swing.JButton btn_changeword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea ta_explain;
    private javax.swing.JTextArea ta_target;
}
