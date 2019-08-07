package mm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class bottomup extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bottomup frame = new bottomup();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public bottomup() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 501, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("LR0 Parser");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lr0form(e);
			}
		});
		btnNewButton.setBounds(86, 98, 136, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SLR1 Parser");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				slr1form(e);
			}
		});
		btnNewButton_1.setBounds(232, 98, 127, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("LALR1 Parser");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lalr1form(e);
			}
		});
		btnNewButton_2.setBounds(86, 132, 136, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("CLR1 Parser");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clr1form(arg0);
			}
		});
		btnNewButton_3.setBounds(232, 132, 127, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainform(e);
			}
		});
		btnBack.setBounds(181, 182, 89, 23);
		contentPane.add(btnBack);
	}
	
	private void mainform(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        main m=new main();
        m.setVisible(true);
        this.hide();
    }
	
	private void lr0form(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
		lr0form m=new lr0form();
        m.setVisible(true);
        this.hide();
    }
	
	private void slr1form(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
		slr1form m=new slr1form();
        m.setVisible(true);
        this.hide();
    }
	
	private void lalr1form(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
		lalr1form m=new lalr1form();
        m.setVisible(true);
        this.hide();
    }
	
	private void clr1form(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
		clr1form m=new clr1form();
        m.setVisible(true);
        this.hide();
    }

}
