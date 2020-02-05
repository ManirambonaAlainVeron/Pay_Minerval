/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen;

import java.awt.Color;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

/**
 *
 * @author DELL
 */
public class UI_direction extends javax.swing.JFrame {

    /**
     * Creates new form UI_direction
     */
    public UI_direction() {
        initComponents();
        Examen.Generalites.Centrer_Fenetres(this);
        Charger_tab_direction(tab_direction);
        jPanel1.setFocusable(true);
        this.setTitle("Application de Gestion du Paiement de Minerval");
    }
    public void Charger_tab_direction(JTable tab)
    {
        ResultSet resu=Examen.Connect.extraireData("select *from payement");
        int index,i=0;
        index=Examen.Generalites.getResultSetRowCount(resu);
        String[] titres={"NumP","Nom","Prenom","Carte","Classe","date","Tranche","Montant"};
        String[][]data=new String[index][titres.length];
        if(resu!=null)
        {
            try {
                while(resu.next())
                {
                    data[i][0]=""+resu.getString("NumP");
                    data[i][1]=resu.getString("nom");
                    data[i][2]=resu.getString("Prenom");
                    data[i][3]=resu.getString("carte");
                    data[i][4]=resu.getString("Classe");
                    data[i][5]=resu.getString("date");
                    data[i][6]=resu.getString("Tranche");
                    data[i][7]=resu.getString("Montant");
                    i++;
                }
                tab.setModel(new Model_table(data,titres));
            } catch (SQLException ex) {
                Logger.getLogger(UI_direction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    public void charge_tab_checrh_classe(JTable tab)
    {
               ResultSet resu=Examen.Connect.extraireData("select *from payement where classe='"+txt_cherch_classe.getText()+"'and carte not in(select num_carte from etudiant inner join classe_etudiant on etID=etudiant where terminer='OUI')");
        int index,i=0;
        index=Examen.Generalites.getResultSetRowCount(resu);
        String[] titres={"NumP","Nom","Prenom","Carte","Classe","date","Tranche","Montant"};
        String[][]data=new String[index][titres.length];
        if(resu!=null)
        {
            try {
                while(resu.next())
                {
                    data[i][0]=""+resu.getString("NumP");
                    data[i][1]=resu.getString("nom");
                    data[i][2]=resu.getString("Prenom");
                    data[i][3]=resu.getString("carte");
                    data[i][4]=resu.getString("Classe");
                    data[i][5]=resu.getString("date");
                    data[i][6]=resu.getString("Tranche");
                    data[i][7]=resu.getString("Montant");
                    i++;
                }
                tab.setModel(new Model_table(data,titres));
            } catch (SQLException ex) {
                Logger.getLogger(UI_direction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
    }
    public void charche_tab_cherch_num(JTable tab)
    {
        ResultSet resu=Examen.Connect.extraireData("select *from payement where carte='"+txt_cherch_num.getText()+"'");
        int index,i=0;
        index=Examen.Generalites.getResultSetRowCount(resu);
        String[] titres={"NumP","Nom","Prenom","Carte","Classe","date","Tranche","Montant"};
        String[][]data=new String[index][titres.length];
        if(resu!=null)
        {
            try {
                while(resu.next())
                {
                    data[i][0]=""+resu.getString("NumP");
                    data[i][1]=resu.getString("nom");
                    data[i][2]=resu.getString("Prenom");
                    data[i][3]=resu.getString("carte");
                    data[i][4]=resu.getString("Classe");
                    data[i][5]=resu.getString("date");
                    data[i][6]=resu.getString("Tranche");
                    data[i][7]=resu.getString("Montant");
                    i++;
                }
                tab.setModel(new Model_table(data,titres));
            } catch (SQLException ex) {
                Logger.getLogger(UI_direction.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tab_direction = new javax.swing.JTable();
        bt_actualiser = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txt_cherch_num = new javax.swing.JTextField();
        bt_cherch_num = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt_cherch_classe = new javax.swing.JTextField();
        bl_ch_classe = new javax.swing.JButton();
        bt_print = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Verification du paiement de Minerval (ULT)");

        tab_direction.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tab_direction);

        bt_actualiser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bt_actualiser.setText("Actualiser");
        bt_actualiser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_actualiserActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Rechercher par carte:");

        txt_cherch_num.setForeground(new java.awt.Color(102, 102, 102));
        txt_cherch_num.setText("Tapez numero du carte ici");
        txt_cherch_num.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_cherch_numFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_cherch_numFocusLost(evt);
            }
        });

        bt_cherch_num.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bt_cherch_num.setIcon(new javax.swing.ImageIcon("E:\\Logos\\recher.JPG")); // NOI18N
        bt_cherch_num.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cherch_numActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Rechercher par Classe:");

        txt_cherch_classe.setForeground(new java.awt.Color(102, 102, 102));
        txt_cherch_classe.setText("Tapez la classe ici");
        txt_cherch_classe.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_cherch_classeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_cherch_classeFocusLost(evt);
            }
        });

        bl_ch_classe.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bl_ch_classe.setIcon(new javax.swing.ImageIcon("E:\\Logos\\recher.JPG")); // NOI18N
        bl_ch_classe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bl_ch_classeActionPerformed(evt);
            }
        });

        bt_print.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bt_print.setText("Imprimer");
        bt_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_printActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon("E:\\Logos\\ult.jfif")); // NOI18N
        jLabel4.setText("jLabel4");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(365, 365, 365)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(339, 339, 339)
                                .addComponent(bt_actualiser, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bt_print, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_cherch_num, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_cherch_num, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_cherch_classe, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bl_ch_classe, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 279, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(276, 276, 276))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(bt_cherch_num, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txt_cherch_num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3)
                    .addComponent(txt_cherch_classe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bl_ch_classe, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_actualiser, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_print, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jMenu3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));
        jMenu3.setText("Retourner");

        jMenuItem1.setText("vers Login");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem2.setText("Fermer");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuBar1.add(jMenu3);

        jMenu1.setText("Historique");

        jMenuItem3.setText("Etudiant");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_actualiserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_actualiserActionPerformed
        // TODO add your handling code here:
        Charger_tab_direction(tab_direction);
        txt_cherch_num.setText("Tapez numero du carte ici");
        txt_cherch_classe.setText("Tapez la classe ici");
        

    }//GEN-LAST:event_bt_actualiserActionPerformed

    private void bt_cherch_numActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cherch_numActionPerformed
        // TODO add your handling code here:
        if(txt_cherch_num.getText().trim().equalsIgnoreCase("")||txt_cherch_num.getText().trim().equalsIgnoreCase("Tapez numero du carte ici"))
        {
            Examen.Generalites.Donner_info_User("Saisissez d'abord le numero a chercher dans la zonne de saisie!");
        }
        else{
        charche_tab_cherch_num(tab_direction);
        }
    }//GEN-LAST:event_bt_cherch_numActionPerformed

    private void bl_ch_classeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bl_ch_classeActionPerformed
        // TODO add your handling code here:
        if(txt_cherch_classe.getText().trim().equalsIgnoreCase("")||txt_cherch_classe.getText().trim().equalsIgnoreCase("Tapez la classe ici"))
        {
            Examen.Generalites.Donner_info_User("Saisissez d'abord dans la zonne de recherche la classe a chercher!");
        }
        else
        {
            charge_tab_checrh_classe(tab_direction);
        }
    }//GEN-LAST:event_bl_ch_classeActionPerformed

    private void bt_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_printActionPerformed
        try {
            // TODO add your handling code here:
            MessageFormat header=new MessageFormat("Liste de paiement de minerval à universite du lac Tanganyika(ULT)");
            MessageFormat footer=new MessageFormat("");
            Boolean a=tab_direction.print(JTable.PrintMode.NORMAL, header, footer);
            
            if(a)
            {
                Examen.Generalites.Donner_info_User("OK,l'Impression est finie");
                
            }
            else
            {
                Examen.Generalites.Donner_info_User("Impression est annulé.......");
            }} catch (PrinterException ex) {
            Logger.getLogger(UI_direction.class.getName()).log(Level.SEVERE, null, ex);
        }
               
    }//GEN-LAST:event_bt_printActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        UI_authentifier b=new UI_authentifier();
        b.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
          UI_historique h=new UI_historique();
        h.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void txt_cherch_classeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cherch_classeFocusGained
        // TODO add your handling code here:
         if(txt_cherch_classe.getText().equals("Tapez la classe ici"))
        {
            txt_cherch_classe.setText("");
            txt_cherch_classe.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_txt_cherch_classeFocusGained

    private void txt_cherch_classeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cherch_classeFocusLost
        // TODO add your handling code here:
            if(txt_cherch_classe.getText().equals(""))
        {
            txt_cherch_classe.setText("Tapez la classe ici");
            txt_cherch_classe.setForeground(new Color(102,102,102));
        }
         else if(txt_cherch_classe.getText()!=""&&txt_cherch_classe.getText()!="Tapez la classe ici")
         {
             txt_cherch_classe.setForeground(new Color(0,0,0));
         }
    }//GEN-LAST:event_txt_cherch_classeFocusLost

    private void txt_cherch_numFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cherch_numFocusGained
        // TODO add your handling code here:
         if(txt_cherch_num.getText().equals("Tapez numero du carte ici"))
        {
            txt_cherch_num.setText("");
            txt_cherch_num.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_txt_cherch_numFocusGained

    private void txt_cherch_numFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cherch_numFocusLost
        // TODO add your handling code here:
             if(txt_cherch_num.getText().equals(""))
        {
            txt_cherch_num.setText("Tapez numero du carte ici");
            txt_cherch_num.setForeground(new Color(102,102,102));
        }
         else if(txt_cherch_num.getText()!=""&&txt_cherch_num.getText()!="Tapez numero du carte ici")
         {
             txt_cherch_num.setForeground(new Color(0,0,0));
         }
    }//GEN-LAST:event_txt_cherch_numFocusLost

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
            java.util.logging.Logger.getLogger(UI_direction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UI_direction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UI_direction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI_direction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI_direction().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bl_ch_classe;
    private javax.swing.JButton bt_actualiser;
    private javax.swing.JButton bt_cherch_num;
    private javax.swing.JButton bt_print;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tab_direction;
    private javax.swing.JTextField txt_cherch_classe;
    private javax.swing.JTextField txt_cherch_num;
    // End of variables declaration//GEN-END:variables
}