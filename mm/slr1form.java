package mm;

import mm.funs.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

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

public class slr1form extends JFrame {
	public static String parserKind;
    public static LR0Parser lr0Parser;
    public static LR1Parser lr1Parser;
    JComboBox parser = new JComboBox();
    JLabel error = new JLabel("");
    JTextArea slr1output = new JTextArea();
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					slr1form frame = new slr1form();
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
	public slr1form() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 735, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("Augmented");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleGrammar(e);
			}

			private void handleGrammar(ActionEvent e) {
				slr1output.setText(lr0Parser.getGrammar()+"");
			}
		});
		button.setBounds(46, 156, 89, 23);
		contentPane.add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 35, 590, 69);
		contentPane.add(scrollPane);
		
		JTextArea slr1input = new JTextArea();
		scrollPane.setViewportView(slr1input);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(46, 180, 590, 223);
		contentPane.add(scrollPane_1);
		
		
		scrollPane_1.setViewportView(slr1output);
		
		JButton button1 = new JButton("First Sets");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleFirst(e);
			}

			private void handleFirst(ActionEvent e) {
				if(parserKind.equals("SLR(1)")){
		            String str = "";
		            for(String s : lr0Parser.getGrammar().getFirstSets().keySet()){
		                str += s + " : " + lr0Parser.getGrammar().getFirstSets().get(s) + "\n";
		            }
		            slr1output.setText(str);
		        }
				
			}
		});
		button1.setBounds(145, 156, 89, 23);
		contentPane.add(button1);
		
		JButton button2 = new JButton("Follow Sets");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleFollow(e);
			}
			private void handleFollow(ActionEvent e) {
				if(parserKind.equals("SLR(1)")){
		            String str = "";
		            for(String s : lr0Parser.getGrammar().getFallowSets().keySet()){
		                str += s + " : " + lr0Parser.getGrammar().getFallowSets().get(s) + "\n";
		            }
		            slr1output.setText(str);
		        }
				
			}
		});
		button2.setBounds(244, 156, 89, 23);
		contentPane.add(button2);
		
		JButton button3 = new JButton("Canonical");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleState(e);
			}

			private void handleState(ActionEvent e) {
				if(parserKind.equals("SLR(1)")){
		            slr1output.setText(lr0Parser.canonicalCollectionStr());
		        }
				
			}
		});
		button3.setBounds(343, 156, 89, 23);
		contentPane.add(button3);
		
		JButton button4 = new JButton("Go To Table");
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleGoTo(e);
			}

			private void handleGoTo(ActionEvent e) {
				if(parserKind.equals("SLR(1)")){
		            slr1output.setText(lr0Parser.goToTableStr());
		        }
				
			}
			
		});
		button4.setBounds(435, 156, 89, 23);
		contentPane.add(button4);
		
		JButton button5 = new JButton("Action Table");
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleAction(e);
			}

			private void handleAction(ActionEvent e) {
				if(parserKind.equals("SLR(1)")){
		            slr1output.setText(lr0Parser.actionTableStr());
		        }
				
			}
		});
		button5.setBounds(534, 156, 102, 23);
		contentPane.add(button5);
		
		JButton btnParse = new JButton("Parse");
		btnParse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hadleStart(e);
			}

			private void hadleStart(ActionEvent e) {
				
				parserKind = (String)parser.getSelectedItem();
	            boolean canBeParse = true;
	            String grammarText = slr1input.getText();
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
	            
//	            if(parserKind.equals(null)) {
//	            	button.setEnabled(false);
//	            	button1.setEnabled(false);
//	            	button2.setEnabled(false);
//	            	button3.setEnabled(false);
//	            	button4.setEnabled(false);
//	            	button5.setEnabled(false);
//	            }else {
//	            	button.setEnabled(true);
//	            	button1.setEnabled(true);
//	            	button2.setEnabled(true);
//	            	button3.setEnabled(true);
//	            	button4.setEnabled(true);
//	            	button5.setEnabled(true);
//	            }
	            
				
			}
		});
		btnParse.setBounds(534, 115, 102, 23);
		contentPane.add(btnParse);
		
		
		parser.setBounds(56, 157, 57, 20);
		contentPane.add(parser);
		parser.addItem("SLR(1)");
		
		JButton button_7 = new JButton("Back");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bottomup(e);
			}
		});
		button_7.setBounds(442, 115, 89, 23);
		contentPane.add(button_7);
		
		
		error.setBounds(46, 142, 590, 14);
		contentPane.add(error);
	}
	
	private void bottomup(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
	 bottomup bu= new bottomup();
        bu.setVisible(true);
        this.hide();
    }

}
