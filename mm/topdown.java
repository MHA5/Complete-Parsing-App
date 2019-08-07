package mm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class topdown extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					topdown frame = new topdown();
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
	public topdown() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Regular Expression");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gore();
		
			}
		});
		btnNewButton.setBounds(80, 65, 162, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Tokenizer");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gotoken();
			}
		});
		btnNewButton_1.setBounds(252, 65, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Left Recursion");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goll();
			}
		});
		btnNewButton_2.setBounds(203, 99, 138, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("LL1Parser");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goll1();
			}
		});
		btnNewButton_3.setBounds(80, 99, 113, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Back");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goback();
			}
		});
		btnNewButton_4.setBounds(80, 135, 261, 23);
		contentPane.add(btnNewButton_4);
	}

	protected void goback() {
		main m =new main();
		m.setVisible(true);
		this.hide();
		
	}

	protected void goll() {
		 leftrec lr =new leftrec();
		 lr.setVisible(true);
		 this.hide();
		
	}

	protected void goll1() {
		ll1parser ll =new ll1parser();
		ll.setVisible(true);
		this.hide();
		
	}

	protected void gotoken() {
		tokens t = new tokens();
		t.setVisible(true);
		this.hide();
		
	}

	protected void gore() {
		RE r= new RE();
		r.setVisible(true);
		this.hide();
		
	}
}
