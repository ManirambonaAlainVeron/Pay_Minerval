/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author DELL
 */
public class UI_classe extends javax.swing.JFrame {

    /**
     * Creates new form UI_classe
     */
    public UI_classe() {
        initComponents();
        Examen.Generalites.Centrer_Fenetres(this);
        charger_tab_classe(tab_classe);
        this.setTitle("Application de Gestion du Paiement de Minerval");
        deplacer_classe();
        jPanel1.setFocusable(true);
        

    }
    static Classes cl=null;
    public void charger_tab_classe(JTable tab)
    {
        ResultSet reso=Examen.Connect.extraireData("select *from classe");
        int index,i=0;
        index=Examen.Generalites.getResultSetRowCount(reso);
        String[] titres={"clId","Nom de la classe","Minerval"};
        String[][]data=new String[index][titres.length];
        if(reso!=null)
        {
            try {
                while(reso.next())
                {
                    data[i][0]=""+reso.getString("clId");
                    data[i][1]=reso.getString("nom_cl");
                    data[i][2]=""+reso.getString("minos");
                    i++;
                 }
            } catch (SQLException ex) {
                Logger.getLogger(UI_classe.class.getName()).log(Level.SEVERE, null, ex);
            }
            tab.setModel(new Model_table(data,titres));
        }
                
        
    }
    public void deplacer_classe()
    {
        tab_classe.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                bt_enregistre.setEnabled(false);
                

                int index_line=0;
                index_line=tab_classe.getSelectedRow();
                if(index_line==-1)
                    return;
                 txt_nom_classe.setForeground(new Color(0,0,0));
                txt_minerval.setForeground(new Color(0,0,0));
                txt_nom_classe.setText(tab_classe.getValueAt(index_line,1).toString());
                txt_minerval.setText(tab_classe.getValueAt(index_line, 2).toString());
                
                if(cl==null)
                  cl=new Classes();
                cl.setClId(Integer.parseInt(tab_classe.getValueAt(index_line,0).toString()));
                
            }
        
            
        });
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
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_nom_classe = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_minerval = new javax.swing.JTextField();
        bt_enregistre = new javax.swing.JButton();
        bt_supprime = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tab_classe = new javax.swing.JTable();
        bt_actualise = new javax.swing.JButton();
        bt_modifie = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Item_etud = new javax.swing.JMenuItem();
        Item_tra = new javax.swing.JMenuItem();
        Item_et_cl = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        Item_login = new javax.swing.JMenuItem();
        Item_fermer = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Enregistrement des Classes");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Nom de la Classe:");

        txt_nom_classe.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_nom_classe.setForeground(new java.awt.Color(102, 102, 102));
        txt_nom_classe.setText("Tapez la classe ici");
        txt_nom_classe.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_nom_classeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_nom_classeFocusLost(evt);
            }
        });
        txt_nom_classe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nom_classeActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Minerval:");

        txt_minerval.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_minerval.setForeground(new java.awt.Color(102, 102, 102));
        txt_minerval.setText("Tapez le Minerval ici");
        txt_minerval.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_minervalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_minervalFocusLost(evt);
            }
        });

        bt_enregistre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bt_enregistre.setText("Enregistrer");
        bt_enregistre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_enregistreActionPerformed(evt);
            }
        });

        bt_supprime.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bt_supprime.setText("Supprimer");
        bt_supprime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_supprimeActionPerformed(evt);
            }
        });

        tab_classe.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tab_classe);

        bt_actualise.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bt_actualise.setText("Actualiser");
        bt_actualise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_actualiseActionPerformed(evt);
            }
        });

        bt_modifie.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bt_modifie.setText("Modifier");
        bt_modifie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_modifieActionPerformed(evt);
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
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(bt_modifie, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bt_enregistre, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bt_supprime)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_actualise, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(92, 92, 92)
                                    .addComponent(txt_minerval, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(141, 141, 141)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txt_nom_classe, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nom_classe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_minerval, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_modifie, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_enregistre, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_supprime, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_actualise, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jMenu1.setText("Enregistrer");

        Item_etud.setText("Etudiant");
        Item_etud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Item_etudActionPerformed(evt);
            }
        });
        jMenu1.add(Item_etud);

        Item_tra.setText("Tranche");
        Item_tra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Item_traActionPerformed(evt);
            }
        });
        jMenu1.add(Item_tra);

        Item_et_cl.setText("Etudiant->Classe");
        Item_et_cl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Item_et_clActionPerformed(evt);
            }
        });
        jMenu1.add(Item_et_cl);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Retourner");

        Item_login.setText("Vers Login");
        Item_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Item_loginActionPerformed(evt);
            }
        });
        jMenu2.add(Item_login);

        Item_fermer.setText("Fermer");
        Item_fermer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Item_fermerActionPerformed(evt);
            }
        });
        jMenu2.add(Item_fermer);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Historique");

        jMenuItem1.setText("Etudiant");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nom_classeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nom_classeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nom_classeActionPerformed

    private void bt_enregistreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_enregistreActionPerformed
        // TODO add your handling code here:
        if(txt_nom_classe.getText().trim().equalsIgnoreCase("")||txt_minerval.getText().trim().equalsIgnoreCase("")||txt_nom_classe.getText().trim().equalsIgnoreCase("Tapez la classe ici")||txt_minerval.getText().trim().equalsIgnoreCase("Tapez le Minerval ici"))
        {
            Examen.Generalites.Donner_info_User("Saisissez d'abord les donnes à enregistrer!");
            return;
        }
        cl=new Classes();
        cl.setNom(txt_nom_classe.getText());
        cl.setMinerval(Integer.parseInt(txt_minerval.getText()));
        if(cl.enregistre_classe()>0)
        {
            Examen.Generalites.Donner_info_User("Votre enregistrement est reussie!");
             charger_tab_classe(tab_classe);
        txt_nom_classe.setForeground(new Color(102,102,102));
        txt_minerval.setForeground(new Color(102,102,102));
        txt_nom_classe.setText("Tapez la classe ici");
        txt_minerval.setText("Tapez le Minerval ici");
        }
        else
            Examen.Generalites.Donner_info_User("Votre enregistrement est echoue!");
        {
        charger_tab_classe(tab_classe);
        txt_nom_classe.setForeground(new Color(102,102,102));
        txt_minerval.setForeground(new Color(102,102,102));
        txt_nom_classe.setText("Tapez la classe ici");
        txt_minerval.setText("Tapez le Minerval ici");
        }
    }//GEN-LAST:event_bt_enregistreActionPerformed

    private void bt_supprimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_supprimeActionPerformed
        // TODO add your handling code here:
        if(txt_nom_classe.getText().trim().equalsIgnoreCase("")||txt_minerval.getText().trim().equalsIgnoreCase("")||txt_nom_classe.getText().trim().equalsIgnoreCase("Tapez la classe ici")||txt_minerval.getText().trim().equalsIgnoreCase("Tapez le Minerval ici"))
        {
           Examen.Generalites.Donner_info_User("Selectionner d'abord dans le tableau la ligne à supprimer!");
            return;
        }
        try{
        if(cl.supprimer_classe()>0)
        {
            Examen.Generalites.Donner_info_User("La suppression est reussie!");
             charger_tab_classe(tab_classe);
        txt_nom_classe.setForeground(new Color(102,102,102));
        txt_minerval.setForeground(new Color(102,102,102));
        txt_nom_classe.setText("Tapez la classe ici");
        txt_minerval.setText("Tapez le Minerval ici");
        }
        else
        {Examen.Generalites.Donner_info_User("Echec de la suppression!");
        charger_tab_classe(tab_classe);

         charger_tab_classe(tab_classe);
        txt_nom_classe.setForeground(new Color(102,102,102));
        txt_minerval.setForeground(new Color(102,102,102));
        txt_nom_classe.setText("Tapez la classe ici");
        txt_minerval.setText("Tapez le Minerval ici");}
        bt_enregistre.setEnabled(true);
        }catch(NullPointerException e){
            Examen.Generalites.Donner_info_User("Selectionner d'abord dans le tableau la ligne à supprimer!");
        }catch(NumberFormatException e){
            Examen.Generalites.Donner_info_User("Selectionner d'abord dans le tableau la ligne à supprimer!");

        }
        
    }//GEN-LAST:event_bt_supprimeActionPerformed

    private void bt_actualiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_actualiseActionPerformed
        // TODO add your handling code here:
        charger_tab_classe(tab_classe);
        txt_nom_classe.setForeground(new Color(102,102,102));
        txt_minerval.setForeground(new Color(102,102,102));
        txt_nom_classe.setText("Tapez la classe ici");
        txt_minerval.setText("Tapez le Minerval ici");
        charger_tab_classe(tab_classe);
       
    }//GEN-LAST:event_bt_actualiseActionPerformed

    private void bt_modifieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_modifieActionPerformed
        // TODO add your handling code here:
        if(txt_nom_classe.getText().trim().equalsIgnoreCase("")||txt_minerval.getText().trim().equalsIgnoreCase("")||txt_nom_classe.getText().trim().equalsIgnoreCase("Tapez la classe ici")||txt_minerval.getText().trim().equalsIgnoreCase("Tapez le Minerval ici"))
        {
          Examen.Generalites.Donner_info_User("Selectionner d'abord dans le tableau la ligne à modifier!");
            return;
        }
         try{
        cl.setNom(txt_nom_classe.getText());
       
        cl.setMinerval(Integer.parseInt(txt_minerval.getText()));
        if(cl.modifier_classe()>0){
            Examen.Generalites.Donner_info_User("la modification est reussie!");
         charger_tab_classe(tab_classe);
        txt_nom_classe.setForeground(new Color(102,102,102));
        txt_minerval.setForeground(new Color(102,102,102));
        txt_nom_classe.setText("Tapez la classe ici");
        txt_minerval.setText("Tapez le Minerval ici");
        }
        else{
            Examen.Generalites.Donner_info_User("Echec de la modification");
            charger_tab_classe(tab_classe);
             charger_tab_classe(tab_classe);
        txt_nom_classe.setForeground(new Color(102,102,102));
        txt_minerval.setForeground(new Color(102,102,102));
        txt_nom_classe.setText("Tapez la classe ici");
        txt_minerval.setText("Tapez le Minerval ici");
        }
            bt_enregistre.setEnabled(true);
            
        }catch(NullPointerException e){
            Examen.Generalites.Donner_info_User("Selectionner d'abord dans le tableau la ligne à modifier!");
        }catch(NumberFormatException e){
            Examen.Generalites.Donner_info_User("Selectionner d'abord dans le tableau la ligne à modifier!");
        }

        
    }//GEN-LAST:event_bt_modifieActionPerformed

    private void Item_etudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Item_etudActionPerformed
        // TODO add your handling code here:
        UI_etudiant e=new UI_etudiant();
        e.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_Item_etudActionPerformed

    private void Item_traActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Item_traActionPerformed
        // TODO add your handling code here:
        UI_tranche t=new UI_tranche();
        t.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_Item_traActionPerformed

    private void Item_et_clActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Item_et_clActionPerformed
        // TODO add your handling code here:
        UI_etud_class et=new UI_etud_class();
        et.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_Item_et_clActionPerformed

    private void Item_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Item_loginActionPerformed
        // TODO add your handling code here:
        UI_authentifier  d=new UI_authentifier ();
        d.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_Item_loginActionPerformed

    private void Item_fermerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Item_fermerActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_Item_fermerActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        UI_historique h=new UI_historique();
        h.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void txt_nom_classeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_nom_classeFocusGained
        // TODO add your handling code here:
          if(txt_nom_classe.getText().equals("Tapez la classe ici"))
        {
            txt_nom_classe.setText("");
            txt_nom_classe.setForeground(new Color(0,0,0));
        }
        
    }//GEN-LAST:event_txt_nom_classeFocusGained

    private void txt_nom_classeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_nom_classeFocusLost
        // TODO add your handling code here:
           if(txt_nom_classe.getText().equals(""))
        {
            txt_nom_classe.setText("Tapez la classe ici");
            txt_nom_classe.setForeground(new Color(102,102,102));
        }
         else if(txt_nom_classe.getText()!=""&&txt_nom_classe.getText()!="Tapez la classe ici")
         {
             txt_nom_classe.setForeground(new Color(0,0,0));
         }
    }//GEN-LAST:event_txt_nom_classeFocusLost

    private void txt_minervalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_minervalFocusGained
        // TODO add your handling code here:
           if(txt_minerval.getText().equals("Tapez le Minerval ici"))
        {
            txt_minerval.setText("");
            txt_minerval.setForeground(new Color(0,0,0));
        }
        
    }//GEN-LAST:event_txt_minervalFocusGained

    private void txt_minervalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_minervalFocusLost
        // TODO add your handling code here:
           if(txt_minerval.getText().equals(""))
        {
            txt_minerval.setText("Tapez le Minerval ici");
            txt_minerval.setForeground(new Color(102,102,102));
        }
         else if(txt_minerval.getText()!=""&&txt_minerval.getText()!="Tapez le Minerval ici")
         {
             txt_minerval.setForeground(new Color(0,0,0));
         }
    }//GEN-LAST:event_txt_minervalFocusLost

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
            java.util.logging.Logger.getLogger(UI_classe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UI_classe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UI_classe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI_classe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI_classe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Item_et_cl;
    private javax.swing.JMenuItem Item_etud;
    private javax.swing.JMenuItem Item_fermer;
    private javax.swing.JMenuItem Item_login;
    private javax.swing.JMenuItem Item_tra;
    private javax.swing.JButton bt_actualise;
    private javax.swing.JButton bt_enregistre;
    private javax.swing.JButton bt_modifie;
    private javax.swing.JButton bt_supprime;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable tab_classe;
    private javax.swing.JTextField txt_minerval;
    private javax.swing.JTextField txt_nom_classe;
    // End of variables declaration//GEN-END:variables
}