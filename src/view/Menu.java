/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author David Darío Del Prado González
 */
public class Menu extends javax.swing.JPanel
{
    /**
     * The frame that contains this panel, and acts as a controller to it.
     */
    private Frame controller;
    
    /**
     * Creates new form Menu
     */
    public Menu()
    {
        initComponents();
    }
    
    public Menu(Frame controller)
    {
        this();
        
        //Reference the frame as the controller
        this.controller = controller; 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {
        java.awt.GridBagConstraints gridBagConstraints;

        btnPlay = new javax.swing.JButton();
        btnUserStats = new javax.swing.JButton();
        btnGlobalStats = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        lblGreetings = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        btnPlay.setText("Jugar");
        btnPlay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPlay.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnPlayActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(btnPlay, gridBagConstraints);

        btnUserStats.setText("Estadísticas del Usuario");
        btnUserStats.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUserStats.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnUserStatsActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(btnUserStats, gridBagConstraints);

        btnGlobalStats.setText("Estadísticas globales");
        btnGlobalStats.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGlobalStats.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnGlobalStatsActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(btnGlobalStats, gridBagConstraints);

        btnLogout.setText("Cerrar sesión");
        btnLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogout.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnLogoutActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(btnLogout, gridBagConstraints);

        btnExit.setText("Salir");
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(btnExit, gridBagConstraints);

        lblGreetings.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        lblGreetings.setText("jLabel1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        add(lblGreetings, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnPlayActionPerformed
    {//GEN-HEADEREND:event_btnPlayActionPerformed
        //Call the controller goToGame method
        controller.goToGame();
    }//GEN-LAST:event_btnPlayActionPerformed

    private void btnUserStatsActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnUserStatsActionPerformed
    {//GEN-HEADEREND:event_btnUserStatsActionPerformed
        //Call the controller goToUserStats method
        controller.goToUserStats();
    }//GEN-LAST:event_btnUserStatsActionPerformed

    private void btnGlobalStatsActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnGlobalStatsActionPerformed
    {//GEN-HEADEREND:event_btnGlobalStatsActionPerformed
        //Call the controller goToGlobalStats method
        controller.goToGlobalStats();
    }//GEN-LAST:event_btnGlobalStatsActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnLogoutActionPerformed
    {//GEN-HEADEREND:event_btnLogoutActionPerformed
        //Call the controller logOut method
        controller.logOut();
    }//GEN-LAST:event_btnLogoutActionPerformed
    
    public void setLblGreetingsText(String text)
    {
        //Set the label as a personalized text to greet the user.
        lblGreetings.setText(text);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnGlobalStats;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnPlay;
    private javax.swing.JButton btnUserStats;
    private javax.swing.JLabel lblGreetings;
    // End of variables declaration//GEN-END:variables
}
