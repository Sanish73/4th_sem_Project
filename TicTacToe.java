package library1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;


public class TicTacToe implements ActionListener{
	
	
	Random random = new Random();				  //whose turn is first ...randmly generated by PC
	JFrame frame = new JFrame();
	JPanel title_panel = new JPanel();  				//panel to hold the title (TIC TAC TOR)
	JPanel button_panel = new JPanel();			//panel to hold the Button(9 button)	
	JLabel textfield = new JLabel();		//label to serve as may be a text field to dispaly a message
	JButton[] buttons = new JButton[90];			//array of buttons to click
	boolean player1_turn;						//ture if its player 1 turn and automatically player 2 
	
	TicTacToe(){			//constructor
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setLayout(new BorderLayout());
		frame.setTitle("Sanish Tick_Tac_Toe");
		frame.setVisible(true);
		
		
		//brackground of text field
		textfield.setBackground(new Color(25,25,25));
		textfield.setForeground(new Color(25,255,0));
		textfield.setFont(new Font("Ink Free",Font.BOLD,75));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setVerticalAlignment(JLabel.TOP);
		textfield.setText("Sanish");
		textfield.setOpaque(true);
		
		
		//panel to hold the title (TIC TAC TOR)
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0,0,800, 100);
		
		button_panel.setLayout(new GridLayout(3,3));
		button_panel.setBackground(Color.RED);
		
		
		for( int i = 0; i<9; i++) {
			buttons[i] = new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli",Font.BOLD,129));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
				
		}
		
		title_panel.add(textfield);
		frame.add(button_panel);
		frame.add(title_panel,BorderLayout.NORTH);
		
		firstTurn();
		
		}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i<9 ; i++) {
			if(e.getSource() == buttons[i]) {
				if(player1_turn) {
					if(buttons[i].getText() =="") {
							buttons[i].setForeground(Color.orange);
							buttons[i].setText("X");
							player1_turn = false;
							textfield.setText("O turn");
							check();
							
				}
				}	
			
				
				else {
					if(buttons[i].getText() =="") {
						buttons[i].setForeground(Color.magenta);
						buttons[i].setText("O");
						player1_turn = true;
						textfield.setText("X turn");
						check();
					}
					}
				}
					
		}
		
	}
		
		
		
		
	
	
	
	//whose turn
	public void firstTurn() {				
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(random.nextInt(2) == 0) {
			player1_turn = true;
			textfield.setText("X turn");
		}
		else {
			player1_turn = false;
			textfield.setText("O turn");
			
		}
	}
	
	
	
	
	
	
	//method to chek the who wins 
	public void check() {
			//check X wins condition..
		if((buttons[0].getText()=="X") &&
			(buttons[1].getText()=="X") &&
				(buttons[2].getText()=="X")){
			xWins(0 ,1, 2);
			
		}
		
		if((buttons[3].getText()=="X") &&
				(buttons[4].getText()=="X") &&
					(buttons[5].getText()=="X")){
				xWins(3 ,4, 5);
				
			}
		if((buttons[6].getText()=="X") &&
				(buttons[7].getText()=="X") &&
					(buttons[8].getText()=="X")){
				xWins(6 ,7 , 8);
				
			}
		if((buttons[0].getText()=="X") &&
				(buttons[3].getText()=="X") &&
					(buttons[6].getText()=="X")){
				xWins(0 ,3, 6);
				
			}
		if((buttons[1].getText()=="X") &&
				(buttons[4].getText()=="X") &&
					(buttons[7].getText()=="X")){
				xWins(1 ,4, 7);
				
			}
		if((buttons[2].getText()=="X") &&
				(buttons[5].getText()=="X") &&
					(buttons[8].getText()=="X")){
				xWins(2,5, 8);
				
			}
		if((buttons[0].getText()=="X") &&
				(buttons[4].getText()=="X") &&
					(buttons[8].getText()=="X")){
				xWins(0 ,4, 8);
				
			}
		if((buttons[2].getText()=="X") &&
				(buttons[4].getText()=="X") &&
					(buttons[6].getText()=="X")){
				xWins(2 ,4, 6);
				
			}
		
		//--------------------------------------------------//
		//check O wins condition
		if((buttons[0].getText()=="O") &&
				(buttons[1].getText()=="O") &&
					(buttons[2].getText()=="O")){
				oWins(0 ,1, 2);
				
			}
			
			if((buttons[3].getText()=="O") &&
					(buttons[4].getText()=="O") &&
						(buttons[5].getText()=="O")){
					oWins(3 ,4, 5);
					
				}
			if((buttons[6].getText()=="O") &&
					(buttons[7].getText()=="O") &&
						(buttons[8].getText()=="O")){
					oWins(6 ,7 , 8);
					
				}
			if((buttons[0].getText()=="O") &&
					(buttons[3].getText()=="O") &&
						(buttons[6].getText()=="O")){
					oWins(0 ,3, 6);
					
				}
			if((buttons[1].getText()=="O") &&
					(buttons[4].getText()=="O") &&
						(buttons[7].getText()=="O")){
					oWins(1 ,4, 7);
					
				}
			if((buttons[2].getText()=="O") &&
					(buttons[5].getText()=="O") &&
						(buttons[8].getText()=="O")){
					oWins(2,5, 8);
					
				}
			if((buttons[0].getText()=="O") &&
					(buttons[4].getText()=="O") &&
						(buttons[8].getText()=="O")){
					oWins(0 ,4, 8);
					
				}
			if((buttons[2].getText()=="O") &&
					(buttons[4].getText()=="O") &&
						(buttons[6].getText()=="O")){
				oWins(2 ,4, 6);
					
				}
		
	}
	
	//when x wins...and where user click ... to see if wins.....to see the points
	public void xWins(int a, int b, int c) {
		buttons[a].setBackground(Color.green);
		buttons[b].setBackground(Color.green);
		buttons[c].setBackground(Color.green);
		for(int i = 0; i<9; i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setFont(new Font("Ink Free",Font.BOLD,126));
		textfield.setForeground(Color.orange);
		textfield.setBackground(Color.black);
		textfield.setText("X wins");
		
		
		
		
	}
	
	
	//when o wins ..... and where o user clic ... like to chek  row or colum is same or not
	public void oWins(int a, int b, int c) {
		buttons[a].setBackground(Color.green);
		buttons[b].setBackground(Color.green);
		buttons[c].setBackground(Color.green);
		
		for(int i = 0; i<9; i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setFont(new Font("Ink Free",Font.BOLD,126));
		textfield.setForeground(Color.magenta);
		textfield.setBackground(Color.black);
		textfield.setText("O wins");
		
	}
	
	
	
}
