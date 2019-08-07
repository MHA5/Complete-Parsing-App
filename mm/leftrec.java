package mm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mm.funs.GIC;

import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListModel;
import java.awt.Font;

public class leftrec extends JFrame {
	
	DefaultListModel prodGramM = new DefaultListModel();
	JList prodGram = new JList(prodGramM);
	
	DefaultListModel gramList1M = new DefaultListModel();
	JList gramList1 = new JList(gramList1M);
	
	DefaultListModel primListM = new DefaultListModel();
	JList primList = new JList(primListM);
	
	DefaultListModel sigListM = new DefaultListModel();
	JList sigList = new JList(sigListM);
	
	public ArrayList<String> gram = new ArrayList<String>();
    //Gramatica Independiente de Contexto
   public GIC gic;

	
	JFileChooser fileChooser = new JFileChooser();
	File selectedFile;

	private JPanel contentPane;
	private JTextField filePane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					leftrec frame = new leftrec();
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
	public leftrec() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 713, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		filePane = new JTextField();
		filePane.setEnabled(false);
		filePane.setEditable(false);
		filePane.setColumns(10);
		filePane.setBounds(46, 36, 380, 20);
		contentPane.add(filePane);
		
		JButton button = new JButton("Select File");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectfile(arg0);
			}
		});
		button.setBounds(427, 35, 81, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Parse");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removerec(e);
			}
		});
		button_1.setBounds(519, 35, 89, 23);
		contentPane.add(button_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 93, 561, 121);
		contentPane.add(scrollPane);
		
		
		scrollPane.setViewportView(prodGram);
		
		JLabel label = new JLabel("Production Grammer");
		label.setBounds(46, 67, 180, 14);
		contentPane.add(label);
		
		JLabel lblLeftRecursion = new JLabel("Left Recursion & Factoring Removed");
		lblLeftRecursion.setBounds(46, 226, 180, 14);
		contentPane.add(lblLeftRecursion);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(47, 252, 178, 121);
		contentPane.add(scrollPane_1);
		
		
		scrollPane_1.setViewportView(gramList1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(237, 252, 178, 121);
		contentPane.add(scrollPane_2);
		
		
		scrollPane_2.setViewportView(primList);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(427, 252, 178, 121);
		contentPane.add(scrollPane_3);
		
		
		scrollPane_3.setViewportView(sigList);
		
		JLabel label_2 = new JLabel("Follow Set");
		label_2.setBounds(426, 226, 180, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("First Set");
		label_3.setBounds(236, 226, 180, 14);
		contentPane.add(label_3);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				topdown(e);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(437, 384, 171, 39);
		contentPane.add(btnNewButton);
	}

	protected void topdown(ActionEvent e) {
		topdown ml=new topdown();
        ml.setVisible(true);
        this.hide();
		
	}

	protected void removerec(ActionEvent e) {
		try{
            if(selectedFile == null) {
            	JOptionPane.showMessageDialog(null, "Please, Select a .txt file contaning grammer");
            }
        gic = new GIC(gram);
              
        gramList1.removeAll();
        gic.eliminarRecIzq();
        
        gic.factorizar();

        gic.orderGram();

        for (int i = 0; i < gic.producciones.size(); i++) {
            gramList1M.add(i,gic.producciones.get(i));
        }
        
        gic.noTerminales = gic.getNoTerminales(gic.producciones);
        
        gic.prim();
        primList.removeAll();
        for (int i = 0; i < gic.prim.size(); i++) {
            primListM.add(i,gic.prim.get(i).toString());
        }

        gic.sgte();
        sigList.removeAll();
        for (int i = 0; i < gic.sgtes.size(); i++) {
            sigListM.add(i,gic.sgtes.get(i).toString());
        }
    }catch(IndexOutOfBoundsException e1){
       
    }
		
}
	protected void selectfile(ActionEvent arg0) {
		String path = null;
        gram = new ArrayList<String>();

        
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
             selectedFile = fileChooser.getSelectedFile();
             path = selectedFile.getAbsolutePath();
             filePane.setText(path);
        }
        
        //GET INFO FILE
        String line;
        try (
            InputStream fis = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
            BufferedReader br = new BufferedReader(isr);
        ) {
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                gram.add(line);
            }
        } catch (FileNotFoundException ex) {
            
        } catch (IOException ex) {
           
        }
        
        prodGram.removeAll();
        for (int i = 0; i < gram.size(); i++) {
        	prodGramM.add(i, gram.get(i));
        }
		
	}
}
