package ru.geekbrains.java2.dz.dz4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileWriter;
import java.io.PrintWriter;

class Window extends JFrame {

	/**
	 * путь к файлу указывается
	 * от корня проекта
	 */
	String fileName = "src\\ru\\geekbrains\\java2\\dz\\dz4\\1.txt";
	private static String userName = "User1";
	private static int fieldHeight = 600;
	private static PrintWriter pw;


	Window() throws Exception {

		/**
		 * не забываем указывать в конструктор FileWriter append: true
		 */
		pw = new PrintWriter(new FileWriter(fileName, true), true);

		// размеры окна
		setBounds(500, 200, 800, fieldHeight);

		// название
		setTitle("Chat");

		// закрытие приложения по закрытию окна
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		/**
		 * ограничиваем изменение размера окна
		 */
		setResizable(false);

		// добавляется надпись или некая метка:
		JLabel userNameLabel = new JLabel("Yor name: " + userName);
		add(userNameLabel, BorderLayout.NORTH);

		/**
		 *	поле чата
		 */
		JTextArea jta = new JTextArea();
		jta.setSize(800, fieldHeight - 100);

		/**
		 * сеттер запрещает ставить курсор в поле чата
		 */
		jta.setEditable(false);

		/**
		 *	перенос строк +
		 */
		jta.setLineWrap(true);


		// оборачиваем в возможность скроллить
		JScrollPane jsp = new JScrollPane(jta);
		add(jsp);

		// используем jPanel для ввода текста
		JPanel contents = new JPanel();
		contents.setSize(800, fieldHeight - jta.getHeight());

		// кнопочка:
		JButton button = new JButton("ВВОД");

		// полоска для ввода текста:
		JFormattedTextField ftfString = new JFormattedTextField();
		ftfString.setColumns(fieldHeight / 10);
		contents.add(ftfString);
		contents.add(button);

		// выводим как и раньше методом add
		add(contents, BorderLayout.SOUTH);

		// событие для клика:
		button.addActionListener(e -> saveTextInTextArea(ftfString, jta));


		// событие для enter:
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


		// ещё скопируем меню на будущее:
		JMenuBar mainMenu = new JMenuBar();
		JMenu mFile = new JMenu("File");
		JMenu mEdit = new JMenu("Edit");

		JMenuItem miFileExit = new JMenuItem("Exit");

		setJMenuBar(mainMenu);

		mainMenu.add(mFile);
		mainMenu.add(mEdit);

		mFile.addSeparator();
		mFile.add(miFileExit);

		// событие на exit:
		miFileExit.addActionListener(e -> System.exit(0));

		setVisible(true);
	}


	static void saveTextInTextArea(JFormattedTextField ftfString, JTextArea jta) {
		String abc = ftfString.getText();
		abc = userName + ": " + abc;
		/**
		 * используем .append для записи нового текста в textArea
		 */
		jta.append(abc);
		jta.append("\n");

		// в поток записываем новые строчки:
		pw.println(abc);
		ftfString.setText("");
	}

}