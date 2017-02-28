package ru.geekbrains.java2.dz.dz4;


import javax.swing.*;
import java.awt.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileWriter;
import java.io.PrintWriter;

class Window extends JFrame {

	String fileName = "src\\ru\\geekbrains\\java2\\dz\\dz4\\1.txt";
	private static String userName = "User1";
	private static int fieldHeight = 600;
	private static PrintWriter pw;



	Window()  throws Exception {

		pw = new PrintWriter(new FileWriter(fileName), true);

		setBounds(500, 200, 800, fieldHeight);
		setTitle("Chat");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		JLabel userNameLabel = new JLabel("Yor name: " + userName);
		add(userNameLabel, BorderLayout.NORTH);

		JTextArea jta = new JTextArea();
		jta.setSize(800, fieldHeight - 100);
		jta.setEditable(false);
		JScrollPane jsp = new JScrollPane(jta);
		add(jsp);

		JPanel contents = new JPanel();
		contents.setSize(800, fieldHeight - jta.getHeight());
		JButton button = new JButton("ВВОД");
		JFormattedTextField ftfString = new JFormattedTextField();
		ftfString.setColumns(fieldHeight / 10);
		contents.add(ftfString);
		contents.add(button);

		add(contents, BorderLayout.SOUTH);

		button.addActionListener(e -> saveTextInTextArea(ftfString, jta));

		ftfString.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					saveTextInTextArea(ftfString, jta);
				}
			}
		});

		JMenuBar mainMenu = new JMenuBar();
		JMenu mFile = new JMenu("File");
		JMenu mEdit = new JMenu("Edit");

		JMenuItem miFileExit = new JMenuItem("Exit");

		setJMenuBar(mainMenu);

		mainMenu.add(mFile);
		mainMenu.add(mEdit);

		mFile.addSeparator();
		mFile.add(miFileExit);

		miFileExit.addActionListener(e -> System.exit(0));

		setVisible(true);
	}

	static void saveTextInTextArea(JFormattedTextField ftfString, JTextArea jta) {
		String abc = ftfString.getText();
		abc = userName + ": " + abc;
		jta.append(abc);
		jta.append("\n");
		pw.println(abc);
		ftfString.setText("");
	}

}
