/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cobi.kgg.ui.dialog;

import com.sun.management.OperatingSystemMXBean;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import org.cobi.kgg.business.entity.Constants;
import org.cobi.kgg.ui.GlobalManager;
import org.openide.ErrorManager;
import org.openide.util.Exceptions;
import org.openide.util.ImageUtilities;

/**
 *
 * @author Jiang Li
 */
public class SetMemoryDialog extends javax.swing.JDialog implements Constants {

    private long physicalMemory;
    private long needMemory = 4096;
    private long longSettingMemory;
    private long longFinalSettingMemory;
    private long currentSetMemory;
    private File fleSetting;
    boolean hasOpenWidnow = false;

    public boolean isHasOpenWidnow() {
        return hasOpenWidnow;
    }

    public void setHasOpenWidnow(boolean hasOpenWidnow) {
        this.hasOpenWidnow = hasOpenWidnow;
    }

    /**
     * Creates new form SetMemoryDialog
     */
    public SetMemoryDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setIconImage(ImageUtilities.loadImage("org/cobi/kgg/ui/png/16x16/logo1.png"));
        OperatingSystemMXBean osmxbTerm = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        physicalMemory = osmxbTerm.getTotalPhysicalMemorySize() / 1024 / 1024;
        longSettingMemory = physicalMemory > needMemory ? needMemory : physicalMemory;
        jLabel1.setText("Your computer's memory is about " + physicalMemory + " Mb. ");
        jLabel2.setText("KGG need large memory, say " + needMemory + " Mb, to run large dataset. ");
        jLabel3.setText("You can set the memory for as " + longSettingMemory + " Mb, or more. ");
        fleSetting = new File(GlobalManager.ETC_PATH + "kgg4.conf");

        readSettingMemory();
        jTextField1.setText(String.valueOf(currentSetMemory));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(org.openide.util.NbBundle.getMessage(SetMemoryDialog.class, "SetMemoryDialog.title")); // NOI18N
        setResizable(false);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(SetMemoryDialog.class, "SetMemoryDialog.jLabel1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(SetMemoryDialog.class, "SetMemoryDialog.jLabel2.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(SetMemoryDialog.class, "SetMemoryDialog.jLabel3.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(SetMemoryDialog.class, "SetMemoryDialog.jLabel4.text")); // NOI18N

        jTextField1.setText(org.openide.util.NbBundle.getMessage(SetMemoryDialog.class, "SetMemoryDialog.jTextField1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jButton1, org.openide.util.NbBundle.getMessage(SetMemoryDialog.class, "SetMemoryDialog.jButton1.text")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jButton2, org.openide.util.NbBundle.getMessage(SetMemoryDialog.class, "SetMemoryDialog.jButton2.text")); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(SetMemoryDialog.class, "SetMemoryDialog.jLabel5.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2)
                                .addGap(92, 92, 92))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            longFinalSettingMemory = Integer.valueOf(jTextField1.getText());
            List<String> lstContent = new ArrayList<String>();
            if (longFinalSettingMemory > physicalMemory) {
                String strInfo = "The memory you set cannot be larger than your computer's memory!!!";
                int intOption = JOptionPane.showConfirmDialog(this, strInfo, "System Message", JOptionPane.OK_OPTION);
                return;
            }
            BufferedReader brRead = new BufferedReader(new FileReader(fleSetting));
            String strLine;
            while ((strLine = brRead.readLine()) != null) {
                if (strLine.contains("default_options")) {
                    strLine = strLine.replaceFirst("-J-Xmx\\d+\\.*\\w+", "-J-Xmx" + longFinalSettingMemory + "m");
                    lstContent.add(strLine);
                } else {
                    lstContent.add(strLine);
                }
            }
            brRead.close();

            fleSetting.delete();
            BufferedWriter bwWrite = new BufferedWriter(new FileWriter(fleSetting, true));
            for (Iterator<String> itrLine = lstContent.iterator(); itrLine.hasNext();) {
                String strTerm = itrLine.next();
                bwWrite.write(strTerm);
                bwWrite.newLine();
            }
            bwWrite.close();
            GlobalManager.hasSetMemorry = true;
            String strInfo = "The memory has been reset successfully and you should restart the application.";
            int intOption = JOptionPane.showConfirmDialog(null, strInfo, "System Message", JOptionPane.OK_CANCEL_OPTION);
            if (intOption == 0) {
                GlobalManager.writeKGGSettings();
                if (hasOpenWidnow) {
                    org.openide.LifecycleManager.getDefault().exit();
                } else {
                    System.exit(0);
                }
            }
        } catch (Exception ex) {
            Exceptions.printStackTrace(ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(SetMemoryDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SetMemoryDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SetMemoryDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SetMemoryDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SetMemoryDialog dialog = new SetMemoryDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    public boolean readSettingMemory() {
        try {
            if (!fleSetting.exists()) {
                // String strInfo = "The memory setting file " + fleSetting.getCanonicalPath() + " does not exist!";
                //JOptionPane.showConfirmDialog(this, strInfo, "System Message", JOptionPane.OK_OPTION);
                if (!fleSetting.getParentFile().exists()) {
                    fleSetting.getParentFile().mkdirs();
                }
                BufferedWriter bwWrite = new BufferedWriter(new FileWriter(fleSetting, true));
                bwWrite.write("# ${HOME} will be replaced by user home directory according to platform\ndefault_userdir=\"${HOME}/.${APPNAME}/dev\"\ndefault_mac_userdir=\"${HOME}/Library/Application Support/${APPNAME}/dev\"\n\n# options used by the launcher by default, can be overridden by explicit\n# command line switches\ndefault_options=\"--branding kgg4 -J-Xms24m -J-Xmx6144m\"\n# for development purposes you may wish to append: -J-Dnetbeans.logger.console=true -J-ea\n\n# default location of JDK/JRE, can be overridden by using --jdkhome <dir> switch\n#jdkhome=\"/path/to/jdk\"\n\n# clusters' paths separated by path.separator (semicolon on Windows, colon on Unices)\n#extra_clusters=\n");
                bwWrite.close();
            }
            BufferedReader brRead = new BufferedReader(new FileReader(fleSetting));
            String strLine;
            while ((strLine = brRead.readLine()) != null) {
                if (strLine.contains("default_options")) {
                    String strTerm = strLine.split(" ")[3];
                    currentSetMemory = Long.valueOf(strTerm.substring(6, strTerm.length() - 2));
                    brRead.close();
                    break;
                }
            }
        } catch (FileNotFoundException ex) {
            ErrorManager.getDefault().notify(ex);
        } catch (IOException ex) {
            ErrorManager.getDefault().notify(ex);
        }
        return false;

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}