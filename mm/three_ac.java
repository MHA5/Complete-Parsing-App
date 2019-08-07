package mm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.Stack;
import java.awt.event.ActionEvent;

public class three_ac extends JFrame {
	
	static int index=1;
    String exp;
    JTextArea threeacres = new JTextArea();
	private JPanel contentPane;
	private JTextField threeacexp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					three_ac frame = new three_ac();
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
	public three_ac() {
		setTitle("Thee Address Code");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		threeacexp = new JTextField();
		threeacexp.setFont(new Font("Tahoma", Font.PLAIN, 24));
		threeacexp.setBounds(103, 74, 349, 36);
		contentPane.add(threeacexp);
		threeacexp.setColumns(10);
		
		
		threeacres.setFont(new Font("Monospaced", Font.PLAIN, 24));
		threeacres.setBounds(103, 170, 349, 196);
		contentPane.add(threeacres);
		
		JButton btnNewButton = new JButton("Convert Expression into 3AC");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Three_AC();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(103, 121, 349, 38);
		contentPane.add(btnNewButton);
		
		JLabel lblExpression = new JLabel("Expression");
		lblExpression.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblExpression.setBounds(103, 34, 133, 29);
		contentPane.add(lblExpression);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goback();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBack.setBounds(304, 34, 148, 38);
		contentPane.add(btnBack);
	}

	protected void goback() {
		// TODO Auto-generated method stub
		main m= new main();
		m.setVisible(true);
		this.hide();
		
	}

	protected void Three_AC() {
		index=1;
        threeacres.setText("");;
        exp = threeacexp.getText();
        exp=exp.replaceAll(" ","");
        Shunting parentNode=shunt(exp);
        postOrder(parentNode);
        dfs(parentNode);
		
	}
	
	public void dfs(Shunting root){
        if (isOperator3AC(root.charac)){
            dfs(root.operand1);
            dfs(root.operand2);
            threeacres.append(root.name +" = " + root.operand1.name + " "+ root.charac  + " " + root.operand2.name + "\n");
        }
    }

    public static void postOrder(Shunting root){
        if (root.operand1!=null){
            postOrder(root.operand1);
        }

        if (root.operand2!=null){
            postOrder(root.operand2);
        }
        System.out.print(root.charac +" ");

    }

    private static Shunting shunt(String inputString) {


        Stack1 myStack=new Stack1();
        Operator opr=new Operator();
        Stack<Character> operatorStack= new Stack();
        Stack<Shunting> expressionStack=new Stack();

        Character c;
        for (int i=0;i<inputString.length();i++){

            c=inputString.charAt(i);

            if (c=='('){
                operatorStack.push(c);
            }

            else if (Character.isDigit(c)){
                expressionStack.push(new Shunting(c));
            }

            else if (isOperator3AC(c)){

                while (opr.getOperatorPrecedence(myStack.getTopOfOperator(operatorStack)) >= opr.getOperatorPrecedence(c)) {
                    Character operator = operatorStack.pop();
                    Shunting e2 = expressionStack.pop();
                    Shunting e1 = expressionStack.pop();

                    expressionStack.push(new Shunting(operator,e1,e2,"t"+index++));
                }

                operatorStack.push(c);
            }

            else if (c==')'){

                while (myStack.getTopOfOperator(operatorStack) != '(') {

                    Character operator = operatorStack.pop();
                    Shunting e2 = expressionStack.pop();
                    Shunting e1 = expressionStack.pop();

                    expressionStack.push(new Shunting(operator,e1,e2,"t"+index++));
                }

                operatorStack.pop();
            }

            else{
                System.out.println("error error");
            }
        }

        while(!operatorStack.empty()){
            Character operator=operatorStack.pop();
            Shunting e2=expressionStack.pop();
            Shunting e1=expressionStack.pop();
            expressionStack.push(new Shunting(operator,e1,e2,"t"+index++));
        }


        return expressionStack.pop();
    }

    public static boolean isOperator3AC(Character c){
        if (c=='+' || c=='-' || c=='/' || c=='*'|| c=='%'){
            return true;
        }
        else{
            return false;
        }
    }
}
