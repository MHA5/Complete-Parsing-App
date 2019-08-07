package mm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mm.funs.Grammar;
import mm.funs.LR0Parser;
import mm.funs.LR1Parser;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

public class lalr1form extends JFrame {
	public static String parserKind;
    public static LR0Parser lr0Parser;
    public static LR1Parser lr1Parser;
    JTextArea lalr1output = new JTextArea();
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lalr1form frame = new lalr1form();
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
	public lalr1form() {
		JLabel error = new JLabel("");
		JComboBox parser = new JComboBox();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, -39, 735, 500);
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
				if(parserKind.equals("LR(0)") || parserKind.equals("SLR(1)")){
		            lalr1output.setText(lr0Parser.getGrammar()+"");
		        }else{
		            lalr1output.setText(lr1Parser.getGrammar()+"");
		        }
				
			}
		});
		button.setBounds(46, 157, 89, 23);
		contentPane.add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 35, 590, 69);
		contentPane.add(scrollPane);
		
		JTextArea lalr1input = new JTextArea();
		scrollPane.setViewportView(lalr1input);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(46, 180, 590, 223);
		contentPane.add(scrollPane_1);
		
		
		scrollPane_1.setViewportView(lalr1output);
		
		JButton button_1 = new JButton("First Sets");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleFirst(e);
			}

			private void handleFirst(ActionEvent e) {
				if(parserKind.equals("LR(0)") || parserKind.equals("SLR(1)")){
		            String str = "";
		            for(String s : lr0Parser.getGrammar().getFirstSets().keySet()){
		                str += s + " : " + lr0Parser.getGrammar().getFirstSets().get(s) + "\n";
		            }
		            lalr1output.setText(str);
		        }else{
		            String str = "";
		            for(String s : lr1Parser.getGrammar().getFirstSets().keySet()){
		                str += s + " : " + lr1Parser.getGrammar().getFirstSets().get(s) + "\n";
		            }
		            lalr1output.setText(str);
		        }
				
			}
		});
		button_1.setBounds(145, 157, 89, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Follow Sets");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleFollow(e);
			}

			private void handleFollow(ActionEvent e) {
				if(parserKind.equals("LR(0)") || parserKind.equals("SLR(1)")){
		            String str = "";
		            for(String s : lr0Parser.getGrammar().getFallowSets().keySet()){
		                str += s + " : " + lr0Parser.getGrammar().getFallowSets().get(s) + "\n";
		            }
		            lalr1output.setText(str);
		        }else{
		            String str = "";
		            for(String s : lr1Parser.getGrammar().getFallowSets().keySet()){
		                str += s + " : " + lr1Parser.getGrammar().getFallowSets().get(s) + "\n";
		            }
		            lalr1output.setText(str);
		        }
				
			}
		});
		button_2.setBounds(244, 157, 89, 23);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("Canonical");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleState(e);
			}

			private void handleState(ActionEvent e) {
				if(parserKind.equals("LR(0)") || parserKind.equals("SLR(1)")){
		            lalr1output.setText(lr0Parser.canonicalCollectionStr());
		        }else{
		            lalr1output.setText(lr1Parser.canonicalCollectionStr());
		        }
				
			}
		});
		button_3.setBounds(343, 157, 89, 23);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("Go To Table");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleGoTo(e);
			}

			private void handleGoTo(ActionEvent e) {
				if(parserKind.equals("LR(0)") || parserKind.equals("SLR(1)")){
		            lalr1output.setText(lr0Parser.goToTableStr());
		        }else{
		            lalr1output.setText(lr1Parser.goToTableStr());
		        }
				
			}
		});
		button_4.setBounds(442, 157, 89, 23);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("Action Table");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleAction(e);
			}

			private void handleAction(ActionEvent e) {
				if(parserKind.equals("LR(0)") || parserKind.equals("SLR(1)")){
		            lalr1output.setText(lr0Parser.actionTableStr());
		        }else{
		            lalr1output.setText(lr1Parser.actionTableStr());
		        }
				
			}
		});
		button_5.setBounds(534, 157, 102, 23);
		contentPane.add(button_5);
		
		JButton btnParse = new JButton("Parse");
		btnParse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hadleStart(e);
			}

			private void hadleStart(ActionEvent e) {
				parserKind = (String)parser.getSelectedItem();
	            boolean canBeParse = true;
	            String grammarText = lalr1input.getText();
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
		btnParse.setBounds(534, 115, 102, 23);
		contentPane.add(btnParse);
		
		
		parser.setBounds(56, 158, 63, 20);
		contentPane.add(parser);
		parser.addItem("LALR(1)");
		
		JButton button_7 = new JButton("Back");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bottomup(e);
			}
		});
		button_7.setBounds(442, 115, 89, 23);
		contentPane.add(button_7);
		
		
		error.setBounds(46, 146, 46, 14);
		contentPane.add(error);
	}
	
	private void bottomup(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
	 bottomup bu= new bottomup();
        bu.setVisible(true);
        this.hide();
    }

}
