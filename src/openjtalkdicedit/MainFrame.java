/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package openjtalkdicedit;

import com.sun.glass.events.KeyEvent;
import java.awt.Component;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JViewport;

/**
 *
 * @author user
 */
public class MainFrame extends javax.swing.JFrame {
public ArrayList arrFind = new ArrayList();
JViewport viewL;
editDialog edt = new editDialog(this, true);

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        listCSV.setModel(new DefaultListModel());
        listFind.setModel(new DefaultListModel());
        viewL = jScrollPane1.getViewport();
        readFile();
    }
    public void readFile() {
        try{
            InputStreamReader f = new InputStreamReader(new FileInputStream(textFileName.getText()), "euc-jp");
            BufferedReader b = new BufferedReader(f);

            String s;
            while((s = b.readLine())!=null){
                /*
                String[] field = s.split(",",15);
                if (field[14].indexOf(",") >= 0) {
                    System.out.println(s);
                }
                StringBuilder sb = new StringBuilder();
                sb.append(field[0]);
                sb.append(",");
                sb.append(field[1]);
                sb.append(",");
                sb.append(field[2]);
                sb.append(",");
                sb.append(field[3]);
                sb.append(",");
                sb.append(field[4]);
                sb.append(",");
                sb.append(field[5]);
                sb.append(",");
                sb.append(field[6]);
                sb.append(",");
                sb.append(field[7]);
                sb.append(",");
                sb.append(field[8]);
                sb.append(",");
                sb.append(field[9]);
                sb.append(",");
                sb.append(field[10]);
                sb.append(",");
                sb.append(field[11]);
                sb.append(",");
                sb.append(field[12]);
                sb.append(",");
                sb.append(field[13]);
                sb.append(",");
                sb.append(field[14]);
                ((DefaultListModel)listCSV.getModel()).addElement(sb.toString());
                */
                ((DefaultListModel)listCSV.getModel()).addElement(s);
            }
            b.close();
        }catch(Exception e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "エラー(CSV)");
        }
        ((DefaultListModel)listCSV.getModel()).addElement(" "); //最後の行をあけておく（新規追加用）
        JOptionPane.showMessageDialog(this, "読み込み完了しました。");
    }
    public void writeCSV() {
        JOptionPane.showMessageDialog(this, "書き込みを開始します。");
        //CSVの書き込み
        try {
            File csv = new File(textFileName.getText()); // CSVデータファイル
            //古いファイルのバックアップ
            if (csv.exists()) {
                File fileB = new File(csv.getAbsolutePath() + "~");
                if (fileB.exists()) {
                    fileB.delete();
                }
                csv.renameTo(fileB);
            }
            // 常に新規作成
            PrintWriter bw;
            bw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csv),"euc-jp")));
            
            DefaultListModel dl = (DefaultListModel)listCSV.getModel();
            //データ部
            for (int i = 0; i < dl.getSize(); i++) {
                String s = (String) dl.elementAt(i);
                if (!s.trim().equals("")) {
                    bw.write(s);
                    bw.println();
                }
            }
            bw.close();
        } catch (FileNotFoundException e) {
            // Fileオブジェクト生成時の例外捕捉
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "エラーが発生しました");
            return;
        } catch (IOException e) {
            // BufferedWriterオブジェクトのクローズ時の例外捕捉
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "エラーが発生しました");
            return;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "エラーが発生しました");
            return;
        }
        JOptionPane.showMessageDialog(this, "CSVを更新しました");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listCSV = new javax.swing.JList();
        textFileName = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        textFind = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        listFind = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("OpenJTalk辞書編集");

        listCSV.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listCSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listCSVMouseClicked(evt);
            }
        });
        listCSV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                listCSVKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(listCSV);

        textFileName.setText("/home/user/tool/voiceLinux/OpenJTalk/open_jtalk-1.07/mecab-naist-jdic/naist-jdic.csv");
        textFileName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFileNameActionPerformed(evt);
            }
        });

        jButton1.setText("Write");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Find");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        textFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFindActionPerformed(evt);
            }
        });

        listFind.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listFind.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                listFindPropertyChange(evt);
            }
        });
        listFind.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listFindValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(listFind);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(textFind)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(textFileName, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFileName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(textFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textFileNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFileNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFileNameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        writeCSV();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String s = textFind.getText();
        if (s.equals("")) {
            return;
        }
        DefaultListModel dl = (DefaultListModel)listCSV.getModel();
        DefaultListModel dlf = (DefaultListModel)listFind.getModel();
        dlf.clear();
        arrFind.clear();
        //データ部
        for (int i = 0; i < dl.getSize(); i++) {
            String s2 = (String) dl.elementAt(i);
            if (s2.indexOf(s) == 0) {
                dlf.addElement(s2);
                arrFind.add(i);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void listFindPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_listFindPropertyChange

    }//GEN-LAST:event_listFindPropertyChange

    private void listFindValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listFindValueChanged
        int i = listFind.getSelectedIndex();
        if (i >= 0) {
            int idx = (Integer) arrFind.get(i);
            listCSV.setSelectedIndex(idx);
            System.out.println(idx);
            listCSV.ensureIndexIsVisible(idx);
        }
    }//GEN-LAST:event_listFindValueChanged

    private void listCSVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listCSVMouseClicked
        if (evt.getClickCount() == 2) {
            String s = (String)((DefaultListModel)listCSV.getModel()).getElementAt(listCSV.getSelectedIndex());
            edt.setStr(s);
            edt.editStr = "";
            edt.setVisible(true);
            //閉じられたら
            if (!edt.editStr.equals("")) {
                ((DefaultListModel)listCSV.getModel()).setElementAt(edt.editStr, listCSV.getSelectedIndex());
                if (listCSV.getSelectedIndex() == ((DefaultListModel)listCSV.getModel()).getSize() - 1) {
                    ((DefaultListModel)listCSV.getModel()).addElement(" ");
                }
            }
        }
    }//GEN-LAST:event_listCSVMouseClicked

    private void textFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFindActionPerformed
        jButton2ActionPerformed(evt);
    }//GEN-LAST:event_textFindActionPerformed

    private void listCSVKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listCSVKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            ((DefaultListModel)listCSV.getModel()).removeElementAt(listCSV.getSelectedIndex());
        }
    }//GEN-LAST:event_listCSVKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList listCSV;
    private javax.swing.JList listFind;
    private javax.swing.JTextField textFileName;
    private javax.swing.JTextField textFind;
    // End of variables declaration//GEN-END:variables
}
