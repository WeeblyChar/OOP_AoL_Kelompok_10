package Main;

import javax.swing.*;

import Length.Length;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;

public class Main {
	public static JFrame mainFrame;
	private JComboBox comboBox_1, comboBox_2;
	private JFormattedTextField textField_1, textField_2;
	private String option_1, option_2;
	private double text_1;
	private String text_2;
	private NumberFormat doubleFormat;
	public JButton buttonCalculate, buttonTemperature;
	private Length from, to;
	private ImageIcon img = new ImageIcon("C:/Users/LEGION/OneDrive/Pictures/Anime/Emojis/ConcernedAwoo.png");

	Main create() {
		mainFrame = new JFrame("Measurement Converter");
		mainFrame.setIconImage(img.getImage());
		
		JLabel lengthLabel = new JLabel("Length Measurement Converter");
		JButton buttonLength = new JButton("X");
		
		buttonLength.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					JDialog lengthDialog = new JDialog(mainFrame, "Length Converter");
					JPanel lengthPanel = createLengthPanel();
					
					lengthDialog.add(lengthPanel);
					lengthDialog.setSize(400, 150);
					lengthDialog.setVisible(true);
					lengthDialog.setLocationRelativeTo(null);
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(mainFrame, "Length Frame Creation Error!");
				}
			}
		});
		
		JPanel mainPanel = new JPanel();
		JPanel wrapper_1 = new JPanel();
		
		wrapper_1.add(lengthLabel);
		wrapper_1.add(buttonLength);
		
		mainPanel.add(wrapper_1);
		
		mainFrame.add(mainPanel);
		return this;
	}
	
	JPanel createLengthPanel() {
		JPanel lengthPanel = new JPanel();
		
		String[] measurementList = { "Inch", "Foot", "Mile", "Yard", "Milimeter", "Centimeter", "Meter", "Kilometer" };

		comboBox_1 = new JComboBox(measurementList);
		comboBox_2 = new JComboBox(measurementList);

		doubleFormat = NumberFormat.getNumberInstance();
		doubleFormat.setMaximumFractionDigits(5);
		doubleFormat.setMinimumIntegerDigits(0);
		doubleFormat.setGroupingUsed(false);

		textField_1 = new JFormattedTextField(doubleFormat);
		textField_1.setValue(0);
		textField_1.setColumns(20);
		textField_2 = new JFormattedTextField(doubleFormat);
		textField_2.setEditable(false);
		textField_2.setValue(0);
		textField_2.setColumns(20);
//
		textField_1.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent event) {
				char input = event.getKeyChar();
				if (!((Character.isDigit(input) || (input == KeyEvent.VK_BACK_SPACE) || (input == KeyEvent.VK_DELETE)
						|| (input == KeyEvent.VK_PERIOD)))) {
					event.consume(); // do not add text to the textfield
				}
			}
		});

		buttonCalculate = new JButton("Calculate");

		buttonCalculate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				try {

					option_1 = comboBox_1.getSelectedItem().toString();
					from = new Length(option_1);

					option_2 = comboBox_2.getSelectedItem().toString();
					to = new Length(option_2);

					String temp = textField_1.getText();
					temp = temp.replace(",", "");
					text_1 = Double.parseDouble(temp);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(mainFrame, "TextField input Error!");
				}

				if (option_1 == option_2)
					textField_2.setValue(text_1);
				else {
					try {
						if (option_1.equalsIgnoreCase("Meter")) {
							double factor = to.getFactor();
							double temp = text_1 / factor;
							textField_2.setValue(temp);
						} else if (option_2.equalsIgnoreCase("Meter")) {
							double factor = from.getFactor();
							double temp = text_1 * factor;
							textField_2.setValue(temp);
						} else {
							double factor = from.getFactor();
							double temp = text_1 * factor;
							factor = to.getFactor();
							temp = temp / factor;
							textField_2.setValue(temp);
						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(mainFrame, "Calculation Error!");
					}
				}

			}
		});

		comboBox_1.setMaximumSize(comboBox_1.getPreferredSize());
		comboBox_2.setMaximumSize(comboBox_2.getPreferredSize());

		JPanel wrapper_1 = new JPanel();
		JPanel wrapper_2 = new JPanel();
		JPanel wrapper_3 = new JPanel();
		lengthPanel.setLayout(new GridLayout(3, 2, 5, 5));

		wrapper_1.add(comboBox_1);
		wrapper_1.add(textField_1);
		wrapper_2.add(comboBox_2);
		wrapper_2.add(textField_2);
		wrapper_3.add(buttonCalculate);

		lengthPanel.add(wrapper_1);
		lengthPanel.add(wrapper_2);
		lengthPanel.add(wrapper_3);
		
		return lengthPanel;
	}

	void show() {
		mainFrame.setSize(400, 150);
		mainFrame.setResizable(false);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Main().create().show();
			}
		});

	}

}
