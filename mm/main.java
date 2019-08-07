package mm;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					main frame = new main();
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
	public main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 352);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
	
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Top-Down");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				topdown(e);
				
			}
		});
		btnNewButton.setBounds(47, 37, 118, 87);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Bottom-Up");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bottomup(e);
			}
		});
		btnNewButton_1.setBounds(175, 37, 110, 87);
		contentPane.add(btnNewButton_1);
		
		JButton btnPolishNotation = new JButton("Polish Notation");
		btnPolishNotation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				openpolish();
			}
		});
		btnPolishNotation.setBounds(47, 135, 358, 87);
		contentPane.add(btnPolishNotation);
		
		JButton btnac = new JButton("3AC");
		btnac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openthree_ac();
			}
		});
		btnac.setBounds(295, 37, 110, 87);
		contentPane.add(btnac);
	}
	
	 protected void openthree_ac() {
		three_ac threeac = new three_ac();
		threeac.setVisible(true);
		this.hide();
		
	}

	protected void openpolish() {
		 polish p = new polish();
			p.setVisible(true);
	        this.hide();
		
	}

	@SuppressWarnings("deprecation")
	private void topdown(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
	        // TODO add your handling code here:
	        topdown tp= new topdown();
	        tp.setVisible(true);
	        this.hide();
	    }
	 
	 private void bottomup(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
	        // TODO add your handling code here:
		 bottomup bu= new bottomup();
	        bu.setVisible(true);
	        this.hide();
	    }
}
