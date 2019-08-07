package mm;

import java.awt.BorderLayout;
import mm.funs.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.glass.ui.Window.Level;
import com.sun.istack.internal.logging.Logger;

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
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class ll1parser extends JFrame {
	
	public ArrayList<String> gram = new ArrayList<String>();
    //Gramatica Independiente de Contexto
   public GIC gic;

	private JPanel contentPane;
	private JTextField filePane;
	
	DefaultListModel prodGramM = new DefaultListModel();
	JList prodGram = new JList(prodGramM);
	
	DefaultListModel termListM = new DefaultListModel();
	JList termList = new JList(termListM);
	
	DefaultListModel noTermListM = new DefaultListModel();
	JList noTermList = new JList(noTermListM);
	
	DefaultListModel gramList1M = new DefaultListModel();
	JList gramList1 = new JList(gramList1M);
	
	DefaultListModel primListM = new DefaultListModel();
	JList primList = new JList(primListM);
	
	DefaultListModel sigListM = new DefaultListModel();
	JList sigList = new JList(sigListM);
	
	DefaultListModel recListM = new DefaultListModel();
	JList recList = new JList(recListM);
	
	JTextField cad = new JTextField();
	JPanel panel_1 = new JPanel();
	
	
	JFileChooser fileChooser = new JFileChooser();
	File selectedFile;
	
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ll1parser frame = new ll1parser();
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
	public ll1parser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				backfun(arg0);
			}
		});
		btnNewButton.setBounds(447, 412, 137, 41);
		contentPane.add(btnNewButton);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBounds(10, 11, 597, 390);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Step 1/2", null, panel, null);
		panel.setLayout(null);
		
		filePane = new JTextField();
		filePane.setEnabled(false);
		filePane.setEditable(false);
		filePane.setBounds(10, 11, 380, 20);
		panel.add(filePane);
		filePane.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Select File");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectfile(e);
			}
		});
		btnNewButton_1.setBounds(400, 10, 81, 23);
		panel.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 69, 180, 123);
		panel.add(scrollPane);
		scrollPane.setViewportView(prodGram);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(210, 69, 180, 123);
		panel.add(scrollPane_1);
		scrollPane_1.setViewportView(termList);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(400, 69, 180, 123);
		panel.add(scrollPane_2);
		scrollPane_2.setViewportView(noTermList);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(20, 228, 180, 123);
		panel.add(scrollPane_3);
		scrollPane_3.setViewportView(gramList1);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(210, 228, 180, 123);
		panel.add(scrollPane_4);
		scrollPane_4.setViewportView(primList);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(400, 228, 180, 123);
		panel.add(scrollPane_5);
		scrollPane_5.setViewportView(sigList);
		
		JButton btnParse = new JButton("Parse");
		btnParse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parsell1(e);
			}
		});
		btnParse.setBounds(491, 10, 89, 23);
		panel.add(btnParse);
		
		JLabel lblNewLabel = new JLabel("New Grammer");
		lblNewLabel.setBounds(20, 203, 180, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Set");
		lblNewLabel_1.setBounds(210, 203, 180, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Follow Set");
		lblNewLabel_2.setBounds(400, 203, 180, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Production Grammer");
		lblNewLabel_3.setBounds(20, 44, 180, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Terminals");
		lblNewLabel_4.setBounds(210, 44, 180, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Non-Termonals");
		lblNewLabel_5.setBounds(400, 44, 180, 14);
		panel.add(lblNewLabel_5);
		
		
		tabbedPane.addTab("Step 2/2", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(10, 203, 572, 148);
		panel_1.add(scrollPane_6);
		scrollPane_6.setViewportView(recList);
		
		JLabel lblString = new JLabel("String");
		lblString.setBounds(10, 181, 46, 14);
		panel_1.add(lblString);
		cad.setBounds(60, 178, 393, 20);
		panel_1.add(cad);
		cad.setColumns(10);
		
		JButton btnCheck = new JButton("Check");
		btnCheck.setBounds(476, 177, 89, 23);
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkString(e);
			}
		});
		panel_1.add(btnCheck);
	}

	protected void checkString(ActionEvent e) {
		try{
            recList.removeAll();
            String cadena = cad.getText();
            ArrayList<String> reconocimiento = gic.reconocer(cadena);
            for (int i = 0; i < reconocimiento.size(); i++) {
                recListM.add(i,reconocimiento.get(i).toString());
            } 
        }catch(IndexOutOfBoundsException e11){
            System.out.println("ERROR");
        }
		
	}

	protected void parsell1(ActionEvent e) {
		try{
            if(selectedFile == null) {
            	JOptionPane.showMessageDialog(null, "Please, Select a .txt file contaning grammer");
            }
        gic = new GIC(gram);
        
        termList.removeAll();
        for (int i = 0; i < gic.terminales.size(); i++) {
            termListM.add(i,gic.terminales.get(i));
        }        
       
        gramList1.removeAll();
        gic.eliminarRecIzq();
        
        gic.factorizar();

        
        gic.orderGram();

       
        for (int i = 0; i < gic.producciones.size(); i++) {
            gramList1M.add(i,gic.producciones.get(i));
        }
        
        gic.noTerminales = gic.getNoTerminales(gic.producciones);

        
        noTermList.removeAll();
        for (int i = 0; i < gic.noTerminales.size(); i++) {
            noTermListM.add(i,gic.noTerminales.get(i));
        }
        

        
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

        
        gic.generateMTableColumns();
        gic.generateMTable();
        
       
        JTable table = new JTable(gic.mTab,gic.mTabColumn);
        panel_1.add(table);
        table.setBounds(10, 11, 572, 157);
        table.setEnabled(false);
        
        
        recList.removeAll();
    }catch(IndexOutOfBoundsException e1){
       
    }
		
	}

	protected void selectfile(ActionEvent e) {
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

	protected void backfun(ActionEvent arg0) {
		topdown ml=new topdown();
        ml.setVisible(true);
        this.hide();
		
	}
}
