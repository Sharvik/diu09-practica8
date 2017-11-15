/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Entrar
 */
public class MainWindow extends javax.swing.JFrame {

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        originLabel = new javax.swing.JLabel();
        destinationLabel = new javax.swing.JLabel();
        originTextField = new javax.swing.JTextField();
        destTextField = new javax.swing.JTextField();
        originButton = new javax.swing.JButton();
        destButton = new javax.swing.JButton();
        currentFileLabel = new javax.swing.JLabel();
        authorLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        compressButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SuperZIP");

        originLabel.setText("Input folder : ");

        destinationLabel.setText("Output folder : ");

        originTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                originTextFieldFocusLost(evt);
            }
        });

        destTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                destTextFieldFocusLost(evt);
            }
        });

        originButton.setText("Add folder...");
        originButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                originButtonActionPerformed(evt);
            }
        });

        destButton.setText("Add folder...");
        destButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                destButtonActionPerformed(evt);
            }
        });

        authorLabel.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        authorLabel.setText("David Medina & Geraldo Rodrigues");

        compressButton.setText("Compress");
        compressButton.setEnabled(false);
        compressButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compressButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.setEnabled(false);
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(currentFileLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(authorLabel))
                            .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(destinationLabel)
                                    .addComponent(originLabel))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(originTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                                    .addComponent(destTextField))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(originButton)
                                    .addComponent(destButton)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(compressButton)
                        .addGap(18, 18, 18)
                        .addComponent(cancelButton)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(originLabel)
                    .addComponent(originTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(originButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(destinationLabel)
                    .addComponent(destTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(destButton))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(compressButton)
                    .addComponent(cancelButton))
                .addGap(26, 26, 26)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(currentFileLabel)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(authorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void originButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_originButtonActionPerformed
        JFileChooser fc = new JFileChooser(System.getProperty("user.home"));

        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int res = fc.showOpenDialog(null);

        if (res == JFileChooser.APPROVE_OPTION) {
            if (!fc.getSelectedFile().isDirectory()) {
                JOptionPane.showMessageDialog(
                        null,
                        "The object selected is not a directory",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                String filename = fc.getSelectedFile().getAbsolutePath();
                originTextField.setText(filename);

                if (!destTextField.getText().isEmpty()) {
                    compressButton.setEnabled(true);
                }
            }
        }
    }//GEN-LAST:event_originButtonActionPerformed

    private void destButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destButtonActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser(System.getProperty("user.home"));

        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int res = fc.showOpenDialog(null);

        if (res == JFileChooser.APPROVE_OPTION) {
            if (!fc.getSelectedFile().isDirectory()) {
                JOptionPane.showMessageDialog(
                        null,
                        "The object selected is not a directory",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                String filename = fc.getSelectedFile().getAbsolutePath();
                destTextField.setText(filename);

                if (!originTextField.getText().isEmpty()) {
                    compressButton.setEnabled(true);
                }
            }
        }
    }//GEN-LAST:event_destButtonActionPerformed

    private void compressButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compressButtonActionPerformed
        if (originTextField.getText().isEmpty() || destTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Unknown origin and/or destination folder",
                    "Folder Error",
                    JOptionPane.ERROR_MESSAGE);
        } else if (originTextField.getText().equals(destTextField.getText())) {
            JOptionPane.showMessageDialog(
                    null,
                    "The folders can not be the same",
                    "Same Folders",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            String in = originTextField.getText();
            String out = destTextField.getText();
            Path parentDir = Paths.get(in).getFileName();
            out += "\\" + parentDir.toString() + ".zip";
            ZipCompressor zip = new ZipCompressor(in, out);
            wk = new Worker(zip, progressBar, currentFileLabel, compressButton, cancelButton);
            wk.execute();
        }
    }//GEN-LAST:event_compressButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        wk.cancel(true);
        cancelButton.setEnabled(false);
        compressButton.setEnabled(true);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void originTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_originTextFieldFocusLost
        System.out.println(originTextField.getText());
        if(Files.isDirectory(Paths.get(originTextField.getText()), LinkOption.NOFOLLOW_LINKS)){
            if(!destTextField.getText().isEmpty()) 
                compressButton.setEnabled(true);
            else
                compressButton.setEnabled(false);
        }
    }//GEN-LAST:event_originTextFieldFocusLost

    private void destTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_destTextFieldFocusLost
        System.out.println(destTextField.getText());
        System.out.println(Files.isDirectory(Paths.get(destTextField.getText())));
        if(Files.isDirectory(Paths.get(destTextField.getText()))){
            if(!originTextField.getText().isEmpty()) 
                compressButton.setEnabled(true);
            else
                compressButton.setEnabled(false);
        }
    }//GEN-LAST:event_destTextFieldFocusLost
    
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
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel authorLabel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton compressButton;
    private javax.swing.JLabel currentFileLabel;
    private javax.swing.JButton destButton;
    private javax.swing.JTextField destTextField;
    private javax.swing.JLabel destinationLabel;
    private javax.swing.JButton originButton;
    private javax.swing.JLabel originLabel;
    private javax.swing.JTextField originTextField;
    private javax.swing.JProgressBar progressBar;
    // End of variables declaration//GEN-END:variables
    private Worker wk;
}
