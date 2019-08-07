package mm;



import mm.funs.*;
import java.awt.EventQueue;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.JLabel;

public class lr0form extends JFrame{
	public static String parserKind;
    public static LR0Parser lr0Parser;
    public static LR1Parser lr1Parser;
    JTextArea lr0input = new JTextArea();
    JTextArea lr0output = new JTextArea();
    JLabel error = new JLabel("");
    JComboBox parser = new JComboBox();

	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lr0form frame = new lr0form();
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
	
	public lr0form() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 735, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Augmented");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleGrammar(e);
			}

			private void handleGrammar(ActionEvent e) {
				if(parserKind.equals("LR(0)")){
		            lr0output.setText(lr0Parser.getGrammar()+"");
		        }
				
			}
		});
		btnNewButton.setBounds(46, 157, 89, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(46, 180, 590, 223);
		contentPane.add(scrollPane_1);
		scrollPane_1.setViewportView(lr0output);
		
		lr0output.getCaret().setDot( Integer.MAX_VALUE );
		
		JButton btnNewButton_1 = new JButton("First Sets");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleFirst(e);
			}
		});
		btnNewButton_1.setBounds(145, 157, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Follow Sets");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleFollow(e);
			}

			private void handleFollow(ActionEvent e) {
				String str = "";
	            for(String s : lr0Parser.getGrammar().getFallowSets().keySet()){
	                str += s + " : " + lr0Parser.getGrammar().getFallowSets().get(s) + "\n";
	            }
	            lr0output.setText(str);
				
			}
		});
		btnNewButton_2.setBounds(244, 157, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Canonical");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleState(e);
			}

			private void handleState(ActionEvent e) {
				lr0output.setText(lr0Parser.canonicalCollectionStr());
				
			}
		});
		btnNewButton_3.setBounds(343, 157, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Go To Table");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleGoTo(e);
			}

			private void handleGoTo(ActionEvent e) {
				lr0output.setText(lr0Parser.goToTableStr());
				
			}
		});
		btnNewButton_4.setBounds(435, 157, 89, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Action Table");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleAction(e);
			}

			private void handleAction(ActionEvent e) {
				lr0output.setText(lr0Parser.actionTableStr());
				
			}
		});
		btnNewButton_5.setBounds(534, 157, 102, 23);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Parse");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handlestart(e);
			}

			private void handlestart(ActionEvent e) {
				parserKind = (String)parser.getSelectedItem();
	            boolean canBeParse = true;
	            String grammarText = lr0input.getText();
	            Grammar grammar = new Grammar(grammarText);
	            if(parser.getSelectedItem().equals("LR(0)") || parser.getSelectedItem().equals("SLR(1)")){
	                lr0Parser = new LR0Parser(grammar);
	                if(parser.getSelectedItem().equals("LR(0)")){
	                    canBeParse = lr0Parser.parserLR0();
	                }else {
	                    canBeParse = lr0Parser.parserSLR1();
	                }
	            }else {
	                lr1Parser = new LR1Parser(grammar);
	                if(parser.getSelectedItem().equals("CLR(1)")){
	                    canBeParse = lr1Parser.parseCLR1();
	                }else {
	                    canBeParse = lr1Parser.parseLALR1();
	                }
	            }
	            if(!canBeParse){
	                error.setText("");
	            }else {
	            	error.setText("");
	            }
				
			}
		});
		btnNewButton_6.setBounds(534, 115, 102, 23);
		contentPane.add(btnNewButton_6);
		
		
		parser.setBounds(66, 158, 51, 20);
		contentPane.add(parser);
		parser.addItem("LR(0)");
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bottomup(arg0);
			}
		});
		btnBack.setBounds(435, 115, 89, 23);
		contentPane.add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 35, 590, 69);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(lr0input);
		
		
		error.setBounds(46, 142, 590, 14);
		contentPane.add(error);
		
		lr0input.getCaret().setDot( Integer.MAX_VALUE );
	}
	
	private void bottomup(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
	 bottomup bu= new bottomup();
        bu.setVisible(true);
        this.hide();
    }
	
	
	
	
	
	private void handleFirst(java.awt.event.ActionEvent evt) {
		String str = "";
        for(String s : lr0Parser.getGrammar().getFirstSets().keySet()){
            str += s + " : " + lr0Parser.getGrammar().getFirstSets().get(s) + "\n";
            lr0output.setText(str);
        }
    }
}
	

