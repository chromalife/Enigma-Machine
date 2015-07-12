import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.BoxLayout;

import java.awt.FlowLayout;

import javax.swing.JTextField;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

/**Class: Encrypt13

* @author Anwar Saleeby

* @version 1.0

* @collaborators Brock Bearchell

* Course : ITEC 3150 Spring 2014

* Written: 2/18/14

*

* This class – Is a simple encoder using the ROT-13 method.

* Purpose: – To move replace letters with letters 13 spaces away from the current letter.

*/

public class Encrypt13 extends JFrame
{

	private JPanel contentPane;
	private JTextField txtEnterHere;
	private JLabel lblEncryptCode;
	private JLabel lblEncryptedMessage;
	private JLabel lblOriginalMessage;



	/**
	 * Create the frame.
	 */
	public Encrypt13()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 117);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));

		lblOriginalMessage = new JLabel("Original message:");

		contentPane.add(lblOriginalMessage);

		txtEnterHere = new JTextField();
		txtEnterHere.setText("enter here");
		//This allows us to use the enter key to send the text through the JTextField();
		txtEnterHere.setFocusable(isFocusable());
		txtEnterHere.addActionListener(new ActionListener()

		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				String s = txtEnterHere.getText();
				String x = "";
				for (int i = 0; i < s.length(); i++) 
				{
					
					char c = s.charAt(i);
					//This sorts the Characters and moves them 13 places one s.charAt(i)
					if       (c >= 'a' && c <= 'm') c += 13;
					else if  (c >= 'A' && c <= 'M') c += 13;
					else if  (c >= 'n' && c <= 'z') c -= 13;
					else if  (c >= 'N' && c <= 'Z') c -= 13;
					System.out.print(c);
					//Adds the string c, our jumbled code, to an empty string for printing outside of the loop.
					x = x + c;
					
				}
				lblEncryptCode.setText(x);
			}

		});


		//Sets our Labels and content pane to a default message. 
		contentPane.add(txtEnterHere);
		txtEnterHere.setColumns(10);

		lblEncryptedMessage = new JLabel("Encrypted message:");
		contentPane.add(lblEncryptedMessage);

		lblEncryptCode = new JLabel("Encrypt code");
		contentPane.add(lblEncryptCode);
		
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Encrypt13 frame = new Encrypt13();
					frame.setVisible(true);
				} 
				
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
}