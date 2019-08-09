package com.ssafy.day0809;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SimpleUI   {
	private JFrame frame;
	private JTextField input;
	private JButton copyBtn,resetBtn;
	private JLabel output;
	private JPanel cenPanel;
	
	public SimpleUI() {
		makeUI();
		addListener();
	}
	private void makeUI() {
		frame = new JFrame("간단한 UI");
		input = new JTextField();
		output = new JLabel("복사된 내용이 여기에 표시됩니다.");
		copyBtn = new JButton("복사");
		resetBtn = new JButton("취소");
		cenPanel = new JPanel();
		
		cenPanel.add(copyBtn);
		cenPanel.add(resetBtn);
		
		frame.getContentPane().add(input, BorderLayout.NORTH);
		frame.getContentPane().add(cenPanel, BorderLayout.CENTER);
		frame.getContentPane().add(output, BorderLayout.SOUTH);
		
		frame.setSize(400, 120);
		frame.setVisible(true);
		
	}
	private void addListener() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		copyBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				output.setText(input.getText());
			}
		});
		
		resetBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				input.setText(null);
				output.setText(null);
			}
		});
	}

	
	
	
	
	
}










