package mm;

import java.util.regex.Pattern;
/*author{
fahadabe
}*/
import java.util.regex.Matcher;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

import mm.RE;


public class RE extends javax.swing.JFrame {
    //private static String REGEX;
   //private static String INPUT;
   
   private static Pattern pattern;
   private static Matcher matcher;

    public RE() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        Regex = new javax.swing.JTextField();
        Matcher = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Matcher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MatcherActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Calibri Light", 1, 12)); // NOI18N
        jButton1.setText("Result");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Calibri Light", 1, 12)); // NOI18N
        jLabel4.setText("Input:");

        jLabel5.setFont(new java.awt.Font("Calibri Light", 1, 12)); // NOI18N
        jLabel5.setText("Matcher:");

        jButton2.setFont(new java.awt.Font("Calibri Light", 1, 12)); // NOI18N
        jButton2.setText("Reset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Calibri Light", 1, 12)); // NOI18N
        jButton3.setText("Back");
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(101)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel5)
        				.addComponent(jLabel4))
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(Regex, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
        				.addGroup(layout.createParallelGroup(Alignment.LEADING)
        					.addComponent(Matcher)
        					.addGroup(layout.createSequentialGroup()
        						.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
        						.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))))
        			.addContainerGap(167, Short.MAX_VALUE))
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap(240, Short.MAX_VALUE)
        			.addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
        			.addGap(224))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(84)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(Regex, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(Matcher, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
        					.addGap(5)))
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(37, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        pattern = Pattern.compile(Regex.getText());
        matcher = pattern.matcher(Matcher.getText());
        /*Boolean str=(matcher.matches());
        //str=false;
        String a=Boolean.toString(str);
        System.out.print(a);
        jt3.setText(a);*/
        /*if(Regex.getText()!=null && Matcher.getText()!=null)
        {
            JOptionPane.showMessageDialog(null, "Please enter data.");
        }*/
        if(matcher.matches())
        {
          JOptionPane.showMessageDialog(null, "Pattern Matched SucceessFully.");  
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Pattern Did not Matched, Please Enter Again.");
        }
            
        /*if(matcher.matches())
      {
          
          JOptionPane.showMessageDialog(null, "Pattern Matched  SucceessFully.");
      }
      
      else
      {
          JOptionPane.showMessageDialog(null, "Pattern Did not Matched ,Enter Again.");
          
      }*/
    }//GEN-LAST:event_jButton1ActionPerformed

    private void MatcherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MatcherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MatcherActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Regex.setText(" ");
        Matcher.setText(" ");
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        topdown ml=new topdown();
        ml.setVisible(true);
        this.hide();
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(RE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Matcher;
    private javax.swing.JTextField Regex;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}


