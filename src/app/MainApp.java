/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package app;

import program.Program;
import db.Database;
import java.util.logging.Level;
import java.util.logging.Logger;
import oru.inf.InfException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oru.inf.InfDB;
import oru.inf.InfException;
import javax.swing.*;

/**
 *
 * @author Sara
 */
public class MainApp extends javax.swing.JFrame {

    private String datum;
    private static InfDB idb;
    private final Program program;
    /**
     * Creates new form MainApp
     * @throws oru.inf.InfException
     */
    public MainApp() throws InfException {
        program = new Program(new Database());
        program.printAllAgents();
        initComponents();
        try {
            idb = new InfDB("mibdb", "3306", "mibdba", "mibkey");
            sattDatum();
            fyllPlatser();
        } catch (InfException e) {
            System.out.println("Knas");
        }
        
    }
    
    private void fyllAgenter()
    {
        List<String> allAgents = program.getAllAgents();
        for(String oneAgent : allAgents){
            System.out.println(oneAgent);
            jAnsvarigBox.addItem(oneAgent);
        }
    }
    /*
    private void fyllAnsvarigRoller() {
        try {
            int id = 1;
            String cont = idb.fetchSingle("SELECT count(namn) FROM Agent");
            int max = Integer.parseInt(cont);
            while (id <= max) {
                String namn = idb.fetchSingle("SELECT Namn FROM Agent WHERE Agent_ID=" + id);
                jAnsvarigBox.addItem(namn);
                id++;
            }
        } catch (Exception e) {
            System.out.println("Knas!");
        }
    }
    */

    //Lägger in automatiskt dagens datum i datumfältet i gränssnittet
    //Detta ska ändras så att man kan välja datum men det måste vara denna typ (YY-MM-DD)
    private void sattDatum() {
        LocalDate date = LocalDate.now();
        String datum = date.toString();
        this.datum = datum;
        datumField.setText(datum);
    }

    //Samma funktion som fyllAnsvarigRoller-metoden fast den fyller PLATS i gränssnittet
    private void fyllPlatser() {
        try {
            int id = 1;
            String cont = idb.fetchSingle("SELECT count(Benamning) FROM Plats");
            int max = Integer.parseInt(cont);
            while (id <= max) {
                String plats = idb.fetchSingle("SELECT Benamning FROM Plats WHERE Plats_ID=" + id);
                jPlatsBox.addItem(plats);
                id++;
            }

        } catch (Exception e) {
            System.err.println("Knas");
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

        panelLogin = new javax.swing.JPanel();
        btnLogin = new javax.swing.JButton();
        txtPassword = new javax.swing.JTextField();
        txtUsername = new javax.swing.JTextField();
        panelHome = new javax.swing.JPanel();
        lblUser = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        panelRegAlien = new javax.swing.JPanel();
        datumLabel = new javax.swing.JLabel();
        namnLabel = new javax.swing.JLabel();
        ansvLabel = new javax.swing.JLabel();
        tfnField1 = new javax.swing.JTextField();
        jAlienID = new javax.swing.JSpinner();
        namnField = new javax.swing.JTextField();
        teleLabel = new javax.swing.JLabel();
        jPlatsBox = new javax.swing.JComboBox<>();
        harRegRubrik = new javax.swing.JLabel();
        platsLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        bRegistrera = new javax.swing.JButton();
        datumField = new javax.swing.JTextField();
        losenField = new javax.swing.JTextField();
        losenLabel = new javax.swing.JLabel();
        jAnsvarigBox = new javax.swing.JComboBox<>();
        regAliRubrik = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(600, 400));
        setSize(new java.awt.Dimension(600, 400));

        panelLogin.setPreferredSize(new java.awt.Dimension(600, 400));
        panelLogin.setRequestFocusEnabled(false);

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLoginLayout = new javax.swing.GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLoginLayout.createSequentialGroup()
                        .addComponent(btnLogin)
                        .addGap(30, 30, 30)))
                .addContainerGap(241, Short.MAX_VALUE))
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnLogin)
                .addContainerGap(146, Short.MAX_VALUE))
        );

        lblUser.setText("hello");

        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelHomeLayout = new javax.swing.GroupLayout(panelHome);
        panelHome.setLayout(panelHomeLayout);
        panelHomeLayout.setHorizontalGroup(
            panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHomeLayout.createSequentialGroup()
                .addGroup(panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelHomeLayout.createSequentialGroup()
                        .addGap(279, 279, 279)
                        .addComponent(lblUser))
                    .addGroup(panelHomeLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(btnLogout)))
                .addContainerGap(295, Short.MAX_VALUE))
        );
        panelHomeLayout.setVerticalGroup(
            panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHomeLayout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(lblUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 200, Short.MAX_VALUE)
                .addComponent(btnLogout)
                .addGap(45, 45, 45))
        );

        datumLabel.setText("Datum:");

        namnLabel.setText("Namn:");

        ansvLabel.setText("Ansvarig:");

        tfnField1.setColumns(7);
        tfnField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfnField1ActionPerformed(evt);
            }
        });

        jAlienID.setToolTipText("ID får inte vara identiskt med ett annat Alien_ID i databasen");
        jAlienID.setValue(4);
        jAlienID.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jAlienIDStateChanged(evt);
            }
        });

        namnField.setColumns(7);
        namnField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namnFieldActionPerformed(evt);
            }
        });

        teleLabel.setText("Telefon");

        platsLabel.setText("Plats:");

        jLabel1.setText("Alien_ID");

        bRegistrera.setText("Registrera");
        bRegistrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRegistreraActionPerformed(evt);
            }
        });

        datumField.setColumns(7);
        datumField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datumFieldActionPerformed(evt);
            }
        });

        losenField.setColumns(7);
        losenField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                losenFieldActionPerformed(evt);
            }
        });

        losenLabel.setText("Lösenord:");

        jAnsvarigBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAnsvarigBoxActionPerformed(evt);
            }
        });

        regAliRubrik.setFont(new java.awt.Font("Cambay Devanagari", 1, 24)); // NOI18N
        regAliRubrik.setText("Registrera alien");

        javax.swing.GroupLayout panelRegAlienLayout = new javax.swing.GroupLayout(panelRegAlien);
        panelRegAlien.setLayout(panelRegAlienLayout);
        panelRegAlienLayout.setHorizontalGroup(
            panelRegAlienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegAlienLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRegAlienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRegAlienLayout.createSequentialGroup()
                        .addComponent(jPlatsBox, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panelRegAlienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRegAlienLayout.createSequentialGroup()
                                .addComponent(losenField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jAnsvarigBox, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(bRegistrera, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelRegAlienLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1))
                    .addGroup(panelRegAlienLayout.createSequentialGroup()
                        .addGroup(panelRegAlienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelRegAlienLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(panelRegAlienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(datumLabel)
                                    .addComponent(platsLabel))
                                .addGap(71, 71, 71))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegAlienLayout.createSequentialGroup()
                                .addGroup(panelRegAlienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jAlienID, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(datumField, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)))
                        .addGroup(panelRegAlienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegAlienLayout.createSequentialGroup()
                                .addComponent(namnLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelRegAlienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ansvLabel)
                                    .addComponent(teleLabel)
                                    .addComponent(tfnField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegAlienLayout.createSequentialGroup()
                                .addGroup(panelRegAlienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(namnField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(losenLabel))
                                .addGap(112, 112, 112))))
                    .addGroup(panelRegAlienLayout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(regAliRubrik))
                    .addGroup(panelRegAlienLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(harRegRubrik, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(255, Short.MAX_VALUE))
        );
        panelRegAlienLayout.setVerticalGroup(
            panelRegAlienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegAlienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(regAliRubrik)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jAlienID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRegAlienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(datumLabel)
                    .addComponent(namnLabel)
                    .addComponent(teleLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRegAlienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namnField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfnField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datumField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRegAlienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(platsLabel)
                    .addComponent(losenLabel)
                    .addComponent(ansvLabel))
                .addGap(4, 4, 4)
                .addGroup(panelRegAlienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(losenField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jAnsvarigBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPlatsBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(bRegistrera)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(harRegRubrik, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(135, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelRegAlien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelRegAlien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed

        Integer userId = Integer.valueOf(txtUsername.getText());
        String password = txtPassword.getText();
        
        program.logIn(userId, password);
        
        if(!program.isLoggedIn())
        {
            System.out.println("Could not login!");
            return;
        }
        
        if(program.isLoggedInAsAgent())
        {
            showRegAlien();
        }
        else if(program.isLoggedInAsAlien())
        {
            //show alienHome();
        }
        else
        {
            //Not logged in at all show error?
        }
        
    }//GEN-LAST:event_btnLoginActionPerformed

    private void showHome()
    {
        //Disable all other panels
        panelLogin.setVisible(false);
        
        //Show home panel
        lblUser.setText(program.getUserName());
        panelHome.setVisible(true);
    }
    
    private void showLogin()
    {
        panelHome.setVisible(false);
        panelLogin.setVisible(true);
    }
    
    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        program.logOut();
        showLogin();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void datumFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datumFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_datumFieldActionPerformed

    private void namnFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namnFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namnFieldActionPerformed

    private void losenFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_losenFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_losenFieldActionPerformed

    private void tfnField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfnField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfnField1ActionPerformed

    private void bRegistreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRegistreraActionPerformed
        // TODO add your handling code here:
        try {
            //Hämtar valt plats ID
            String cont = jPlatsBox.getSelectedItem().toString();
            String platsid = idb.fetchSingle("SELECT Plats_ID FROM Plats WHERE Benamning='" + cont + "'");
            //Omvandlar variabeln platsid till en int
            int plats = Integer.parseInt(platsid);
            //En "check" så att rätt värde visas
            System.out.println("Plats: " + plats);

            //Hämtar inmatat Alien ID
            String cont2 = jAlienID.getValue().toString();
            int aid = Integer.parseInt(cont2);
            System.out.println("Alien ID: " + aid);

            //Hämtar inmatat ansvarig_ID (DATATYPEN MÅSTE VARA AV INT DÄR DATABASENS TYPER ÄR INT)
            String ansvarig = jAnsvarigBox.getSelectedItem().toString();
            String ans1 = idb.fetchSingle("SELECT Agent_ID FROM Agent WHERE Namn ='" + ansvarig + "'");
            int ans = Integer.parseInt(ans1);
            System.out.println("Ansvarig :" + ans);

            //Hämtar datum
            this.datum = datumField.getText();
            System.out.println("Datum: " + datum);

            //Hämtar inmatat lösenord
            String losenord = losenField.getText();
            System.out.println("Lösenord: " + losenord);

            //Hämtar inmatat namn
            String namn = namnField.getText();
            System.out.println("Namn: " + namn);

            //Hämtar telefon
            String telefon = tfnField1.getText();

            //Hämtar alla variabler och lägger till Alien
            try {

                //Kollar så att samtliga rader är inmatade annars error
                if(losenord.isEmpty() || namn.isEmpty() || telefon.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Samtliga fält måste vara ifyllda!");
                }
                else{
                    //Sätter in samtliga värden i databasen och reggar en ny alien
                    idb.insert("INSERT INTO Alien (Alien_ID, Registreringsdatum, Losenord, Namn, Telefon, Plats, Ansvarig_Agent) VALUES ('"
                        + aid + "','"
                        + datum + "','"
                        + losenord + "','"
                        + namn + "','"
                        + telefon + "','"
                        + plats + "','"
                        + ans + "')");
                    //Printas ut under button att alien har reggats
                    harRegRubrik.setText(namn + " har registrerats!");
                }

            } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "Nånting blev fel. Kanske Alien_ID redan finns i databasen?");
            }

        } catch (InfException e) {
            System.out.println("Knas" + e.getMessage());
        }
    }//GEN-LAST:event_bRegistreraActionPerformed

    private void jAnsvarigBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAnsvarigBoxActionPerformed
        // TODO add your handling code here¨
    }//GEN-LAST:event_jAnsvarigBoxActionPerformed

    private void jAlienIDStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jAlienIDStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jAlienIDStateChanged

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
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            MainApp m;
            try {
                m = new MainApp();
                m.panelHome.setVisible(false);
                m.panelRegAlien.setVisible(false);
                m.panelLogin.setVisible(true);             
                m.setVisible(true);
            
            } catch (InfException ex) {
                Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ansvLabel;
    private javax.swing.JButton bRegistrera;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnLogout;
    private javax.swing.JTextField datumField;
    private javax.swing.JLabel datumLabel;
    private javax.swing.JLabel harRegRubrik;
    private javax.swing.JSpinner jAlienID;
    private javax.swing.JComboBox<String> jAnsvarigBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox<String> jPlatsBox;
    private javax.swing.JLabel lblUser;
    private javax.swing.JTextField losenField;
    private javax.swing.JLabel losenLabel;
    private javax.swing.JTextField namnField;
    private javax.swing.JLabel namnLabel;
    private javax.swing.JPanel panelHome;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JPanel panelRegAlien;
    private javax.swing.JLabel platsLabel;
    private javax.swing.JLabel regAliRubrik;
    private javax.swing.JLabel teleLabel;
    private javax.swing.JTextField tfnField1;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

    private void showRegAlien() {
        panelHome.setVisible(false);
        panelLogin.setVisible(false);
        fyllAgenter();
        panelRegAlien.setVisible(true);
        
    }
}
