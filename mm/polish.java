package mm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.awt.event.ActionEvent;

public class polish extends JFrame {

	private JPanel contentPane;
	private JTextField infixtoprefix_infix;
	private JTextField infixtoprefix_prefix;
	private JTextField infixtopostfix_postfix;
	private JTextField infixtopostfix_infix;
	private JTextField prefixtoinfix_infix;
	private JTextField prefixtoinfix_prefix;
	private JTextField prefixtopostfix_postfix;
	private JTextField prefixtopostfix_prefix;
	private JTextField postfixtoinfix_infix;
	private JTextField postfixtoinfix_postfix;
	private JTextField postfixtoprefix_prefix;
	private JTextField postfixtoprefix_postfix;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					polish frame = new polish();
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
	public polish() {
		setTitle("Polish Notations");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 778, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(26, 11, 670, 418);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Infix -> Prefix", null, panel, null);
		panel.setLayout(null);
		
		infixtoprefix_infix = new JTextField();
		infixtoprefix_infix.setFont(new Font("Tahoma", Font.PLAIN, 24));
		infixtoprefix_infix.setBounds(170, 134, 323, 35);
		panel.add(infixtoprefix_infix);
		infixtoprefix_infix.setColumns(10);
		
		infixtoprefix_prefix = new JTextField();
		infixtoprefix_prefix.setEditable(false);
		infixtoprefix_prefix.setFont(new Font("Tahoma", Font.PLAIN, 24));
		infixtoprefix_prefix.setBounds(170, 180, 323, 35);
		panel.add(infixtoprefix_prefix);
		infixtoprefix_prefix.setColumns(10);
		
		JLabel lblInfix = new JLabel("Infix");
		lblInfix.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblInfix.setBounds(87, 134, 73, 35);
		panel.add(lblInfix);
		
		JLabel lblPrefix = new JLabel("Prefix");
		lblPrefix.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblPrefix.setBounds(87, 184, 73, 26);
		panel.add(lblPrefix);
		
		JButton btnNewButton = new JButton("Convert");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InfixtoPrefix();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton.setBounds(319, 223, 174, 35);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Infix -> Postfix", null, panel_1, null);
		panel_1.setLayout(null);
		
		JButton button = new JButton("Convert");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InfixtoPostfix();
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 24));
		button.setBounds(330, 223, 163, 35);
		panel_1.add(button);
		
		infixtopostfix_postfix = new JTextField();
		infixtopostfix_postfix.setFont(new Font("Tahoma", Font.PLAIN, 24));
		infixtopostfix_postfix.setEditable(false);
		infixtopostfix_postfix.setColumns(10);
		infixtopostfix_postfix.setBounds(170, 180, 323, 35);
		panel_1.add(infixtopostfix_postfix);
		
		infixtopostfix_infix = new JTextField();
		infixtopostfix_infix.setFont(new Font("Tahoma", Font.PLAIN, 24));
		infixtopostfix_infix.setColumns(10);
		infixtopostfix_infix.setBounds(170, 134, 323, 35);
		panel_1.add(infixtopostfix_infix);
		
		JLabel label = new JLabel("Infix");
		label.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label.setBounds(87, 134, 73, 35);
		panel_1.add(label);
		
		JLabel lblPostfix = new JLabel("Postfix");
		lblPostfix.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblPostfix.setBounds(87, 184, 73, 26);
		panel_1.add(lblPostfix);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Prefix -> Infix", null, panel_2, null);
		panel_2.setLayout(null);
		
		JButton button_1 = new JButton("Convert");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrefixtoInfix();
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		button_1.setBounds(326, 223, 167, 35);
		panel_2.add(button_1);
		
		prefixtoinfix_infix = new JTextField();
		prefixtoinfix_infix.setFont(new Font("Tahoma", Font.PLAIN, 24));
		prefixtoinfix_infix.setEditable(false);
		prefixtoinfix_infix.setColumns(10);
		prefixtoinfix_infix.setBounds(170, 180, 323, 35);
		panel_2.add(prefixtoinfix_infix);
		
		prefixtoinfix_prefix = new JTextField();
		prefixtoinfix_prefix.setFont(new Font("Tahoma", Font.PLAIN, 24));
		prefixtoinfix_prefix.setColumns(10);
		prefixtoinfix_prefix.setBounds(170, 134, 323, 35);
		panel_2.add(prefixtoinfix_prefix);
		
		JLabel lblPrefix_1 = new JLabel("Prefix");
		lblPrefix_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblPrefix_1.setBounds(87, 134, 73, 35);
		panel_2.add(lblPrefix_1);
		
		JLabel lblInfix_1 = new JLabel("Infix");
		lblInfix_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblInfix_1.setBounds(87, 184, 73, 26);
		panel_2.add(lblInfix_1);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Prefix -> Postfix", null, panel_3, null);
		panel_3.setLayout(null);
		
		JButton button_2 = new JButton("Convert");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrefixtoPostfix();
			}
		});
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		button_2.setBounds(334, 223, 159, 35);
		panel_3.add(button_2);
		
		prefixtopostfix_postfix = new JTextField();
		prefixtopostfix_postfix.setFont(new Font("Tahoma", Font.PLAIN, 24));
		prefixtopostfix_postfix.setEditable(false);
		prefixtopostfix_postfix.setColumns(10);
		prefixtopostfix_postfix.setBounds(170, 180, 323, 35);
		panel_3.add(prefixtopostfix_postfix);
		
		prefixtopostfix_prefix = new JTextField();
		prefixtopostfix_prefix.setFont(new Font("Tahoma", Font.PLAIN, 24));
		prefixtopostfix_prefix.setColumns(10);
		prefixtopostfix_prefix.setBounds(170, 134, 323, 35);
		panel_3.add(prefixtopostfix_prefix);
		
		JLabel lblPrefix_2 = new JLabel("Prefix");
		lblPrefix_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblPrefix_2.setBounds(87, 134, 73, 35);
		panel_3.add(lblPrefix_2);
		
		JLabel lblPostfix_1 = new JLabel("Postfix");
		lblPostfix_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblPostfix_1.setBounds(87, 184, 73, 26);
		panel_3.add(lblPostfix_1);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Postfix -> Infix", null, panel_4, null);
		panel_4.setLayout(null);
		
		JButton button_3 = new JButton("Convert");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PostfixtoInfix();
			}
		});
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		button_3.setBounds(319, 223, 174, 35);
		panel_4.add(button_3);
		
		postfixtoinfix_infix = new JTextField();
		postfixtoinfix_infix.setFont(new Font("Tahoma", Font.PLAIN, 24));
		postfixtoinfix_infix.setEditable(false);
		postfixtoinfix_infix.setColumns(10);
		postfixtoinfix_infix.setBounds(170, 180, 323, 35);
		panel_4.add(postfixtoinfix_infix);
		
		postfixtoinfix_postfix = new JTextField();
		postfixtoinfix_postfix.setFont(new Font("Tahoma", Font.PLAIN, 24));
		postfixtoinfix_postfix.setColumns(10);
		postfixtoinfix_postfix.setBounds(170, 134, 323, 35);
		panel_4.add(postfixtoinfix_postfix);
		
		JLabel lblPostfix_2 = new JLabel("Postfix");
		lblPostfix_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblPostfix_2.setBounds(87, 134, 73, 35);
		panel_4.add(lblPostfix_2);
		
		JLabel lblInfix_2 = new JLabel("Infix");
		lblInfix_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblInfix_2.setBounds(87, 184, 73, 26);
		panel_4.add(lblInfix_2);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Postfix -> Prefix", null, panel_5, null);
		panel_5.setLayout(null);
		
		JButton button_4 = new JButton("Convert");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PostfixtoPrefix();
			}
		});
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 24));
		button_4.setBounds(330, 223, 163, 35);
		panel_5.add(button_4);
		
		postfixtoprefix_prefix = new JTextField();
		postfixtoprefix_prefix.setFont(new Font("Tahoma", Font.PLAIN, 24));
		postfixtoprefix_prefix.setEditable(false);
		postfixtoprefix_prefix.setColumns(10);
		postfixtoprefix_prefix.setBounds(170, 180, 323, 35);
		panel_5.add(postfixtoprefix_prefix);
		
		postfixtoprefix_postfix = new JTextField();
		postfixtoprefix_postfix.setFont(new Font("Tahoma", Font.PLAIN, 24));
		postfixtoprefix_postfix.setColumns(10);
		postfixtoprefix_postfix.setBounds(170, 134, 323, 35);
		panel_5.add(postfixtoprefix_postfix);
		
		JLabel lblPostfix_3 = new JLabel("Postfix");
		lblPostfix_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblPostfix_3.setBounds(87, 134, 73, 35);
		panel_5.add(lblPostfix_3);
		
		JLabel label_2 = new JLabel("Prefix");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_2.setBounds(87, 184, 73, 26);
		panel_5.add(label_2);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				goback();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnBack.setBounds(533, 429, 163, 35);
		contentPane.add(btnBack);
	}
	protected void goback() {
		// TODO Auto-generated method stub
		main m =new main();
		m.setVisible(true);
		this.hide();
		
	}

	static boolean isOperator(char x)
    {
        switch (x) {
            case '+':
            case '-':
            case '/':
            case '*':
                return true;
        }
        return false;
    }
    protected void PostfixtoPrefix() {
    	String PosttoPre = postfixtoprefix_postfix.getText();
        postfixtoprefix_prefix.setText(postToPre(PosttoPre));
		
	}
    
    static String postToPre(String post_exp) {
        Stack<String> s = new Stack<String>();
        // length of expression
        int length = post_exp.length();
        // reading from right to left
        for (int i = 0; i < length; i++) {
            // check if symbol is operator
            if (isOperator(post_exp.charAt(i))) {
                // pop two operands from stack
                String op1 = s.peek();
                s.pop();
                String op2 = s.peek();
                s.pop();
                // concat the operands and operator
                String temp = post_exp.charAt(i) + op2 + op1;
                // Push String temp back to stack
                s.push(temp);
            }
            // if symbol is an operand
            else {
                // push the operand to the stack
                s.push(post_exp.charAt(i) + "");
            }
        }
        // stack[0] contains the Prefix expression
        return s.peek();
    }

    protected void PostfixtoInfix() {
    	String PosttoInf = postfixtoinfix_postfix.getText();
        postfixtoinfix_infix.setText(getInfix(PosttoInf));
		
	}
    
    static boolean isOperand(char x) {
        return (x >= 'a' && x <= 'z') ||
                (x >= 'A' && x <= 'Z');
    }

    // Get Infix for a given postfix
// expression
    static String getInfix(String exp) {
        Stack<String> s = new Stack<String>();
        for (int i = 0; i < exp.length(); i++) {
            // Push operands
            if (isOperand(exp.charAt(i))) {
                s.push(exp.charAt(i) + "");
            }
            // We assume that input is
            // a valid postfix and expect
            // an operator.
            else {
                String op1 = s.peek();
                s.pop();
                String op2 = s.peek();
                s.pop();
                s.push("(" + op2 + exp.charAt(i) +
                        op1 + ")");
            }
        }

        // There must be a single element
        // in stack now which is the required
        // infix.
        return s.peek();
    }


    protected void PrefixtoPostfix() {
    	String PretoPost = prefixtopostfix_prefix.getText();
        prefixtopostfix_postfix.setText(preToPost(PretoPost));
		
	}
    
    static String preToPost(String pre_exp) {

        Stack<String> s= new Stack<String>();

        // length of expression
        int length = pre_exp.length();

        // reading from right to left
        for (int i = length - 1; i >= 0; i--) {

            // check if symbol is operator
            if (isOperator(pre_exp.charAt(i))) {

                // pop two operands from stack
                String op1 = s.peek(); s.pop();
                String op2 = s.peek(); s.pop();

                // concat the operands and operator
                String temp = op1 + op2 + pre_exp.charAt(i);

                // Push String temp back to stack
                s.push(temp);
            }

            // if symbol is an operand
            else
            {
                // push the operand to the stack
                s.push( pre_exp.charAt(i)+"");
            }
        }

        // stack contains only the Postfix expression
        return s.peek();
    }

	protected void PrefixtoInfix() {
		String PretoInf = prefixtoinfix_prefix.getText();
        prefixtoinfix_infix.setText(parse(PretoInf));
		
	}
	
	static final Map<String, Integer> PREC = new HashMap<>();
    static { PREC.put("+", 1); PREC.put("-", 1); PREC.put("*", 2); PREC.put("/", 2); }

    static class Source {
        final String s;
        Source(String s) { this.s = s; }
        int index = 0;
        String token;
        String next() { return token = index >= s.length() ? null : s.substring(index, ++index); }
    }

    static String parse(String s) { return parse(new Source(s), 0); }

    static String parse(Source t, int prec) {
        Integer self = PREC.get(t.next());
        if (self != null) {
            String op = t.token;
            String result = String.format("%s%s%s",parse(t, self), op, parse(t, self));
            if (self < prec) result = "(" + result + ")";
            return result;
        } else
            return t.token;
    }

	protected void InfixtoPostfix() {
		String InftoPost = infixtopostfix_infix.getText();
        infixtopostfix_postfix.setText(infixToPostfix(InftoPost));
		
	}
	
	static int Prec(char ch)
    {
        switch (ch)
        {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    // The main method that converts given infix expression
    // to postfix expression.
    static String infixToPostfix(String exp)
    {
        // initializing empty String for result
        String result = new String("");

        // initializing empty stack
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i<exp.length(); ++i)
        {
            char c = exp.charAt(i);

            // If the scanned character is an operand, add it to output.
            if (Character.isLetterOrDigit(c))
                result += c;

                // If the scanned character is an '(', push it to the stack.
            else if (c == '(')
                stack.push(c);

                //  If the scanned character is an ')', pop and output from the stack
                // until an '(' is encountered.
            else if (c == ')')
            {
                while (!stack.isEmpty() && stack.peek() != '(')
                    result += stack.pop();

                if (!stack.isEmpty() && stack.peek() != '(')
                    return "Invalid Expression"; // invalid expression
                else
                    stack.pop();
            }
            else // an operator is encountered
            {
                while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())){
                    if(stack.peek() == '(')
                        return "Invalid Expression";
                    result += stack.pop();
                }
                stack.push(c);
            }

        }

        // pop all the operators from the stack
        while (!stack.isEmpty()){
            if(stack.peek() == '(')
                return "Invalid Expression";
            result += stack.pop();
        }
        return result;
    }

	protected void InfixtoPrefix() {
		String InftoPre = infixtoprefix_infix.getText();
        infixtoprefix_prefix.setText(infixToPrefix(InftoPre));
		
	}
	
	static boolean isOperatorInToPre(char c)
    {
        return (!(c >= 'a' && c <= 'z') &&
                !(c >= '0' && c <= '9') &&
                !(c >= 'A' && c <= 'Z'));
    }

    static int getPriority(char C)
    {
        if (C == '-' || C == '+')
            return 1;
        else if (C == '*' || C == '/')
            return 2;
        else if (C == '^')
            return 3;
        return 0;
    }

    static String infixToPrefix(String infix)
    {
        // stack for operators.
        Stack<Character> operators = new Stack<Character>();

        // stack for operands.
        Stack<String> operands = new Stack<String>();

        for (int i = 0; i < infix.length(); i++)
        {

            // If current character is an
            // opening bracket, then
            // push into the operators stack.
            if (infix.charAt(i) == '(')
            {
                operators.push(infix.charAt(i));
            }

            // If current character is a
            // closing bracket, then pop from
            // both stacks and push result
            // in operands stack until
            // matching opening bracket is
            // not found.
            else if (infix.charAt(i) == ')')
            {
                while (!operators.empty() &&
                        operators.peek() != '(')
                {

                    // operand 1
                    String op1 = operands.peek();
                    operands.pop();

                    // operand 2
                    String op2 = operands.peek();
                    operands.pop();

                    // operator
                    char op = operators.peek();
                    operators.pop();

                    // Add operands and operator
                    // in form operator +
                    // operand1 + operand2.
                    String tmp = op + op2 + op1;
                    operands.push(tmp);
                }

                // Pop opening bracket
                // from stack.
                operators.pop();
            }

            // If current character is an
            // operand then push it into
            // operands stack.
            else if (!isOperatorInToPre(infix.charAt(i)))
            {
                operands.push(infix.charAt(i) + "");
            }

            // If current character is an
            // operator, then push it into
            // operators stack after popping
            // high priority operators from
            // operators stack and pushing
            // result in operands stack.
            else
            {
                while (!operators.empty() &&
                        getPriority(infix.charAt(i)) <=
                                getPriority(operators.peek()))
                {

                    String op1 = operands.peek();
                    operands.pop();

                    String op2 = operands.peek();
                    operands.pop();

                    char op = operators.peek();
                    operators.pop();

                    String tmp = op + op2 + op1;
                    operands.push(tmp);
                }

                operators.push(infix.charAt(i));
            }
        }

        // Pop operators from operators
        // stack until it is empty and
        // operation in add result of
        // each pop operands stack.
        while (!operators.empty())
        {
            String op1 = operands.peek();
            operands.pop();

            String op2 = operands.peek();
            operands.pop();

            char op = operators.peek();
            operators.pop();

            String tmp = op + op2 + op1;
            operands.push(tmp);
        }

        // Final prefix expression is
        // present in operands stack.
        return operands.peek();
    }
}
