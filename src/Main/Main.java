package Main;

import javax.swing.*;

import Length.*;
import Temperature.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;

public class Main {
	public static JFrame mainFrame;
	private String option_1, option_2;
	private double text_1;
	private NumberFormat doubleFormat;
	private Length fromLen, toLen;
//	private ImageIcon img = new ImageIcon("C:/Users/LEGION/OneDrive/Pictures/Anime/Emojis/ConcernedAwoo.png");

	Main create() {
		initializeFormattedNumbers();
		
		mainFrame = new JFrame("Measurement Converter");
//		mainFrame.setIconImage(img.getImage());

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
		
		JLabel tempLabel = new JLabel("Temperature Measurement Converter");
		JButton buttonTemp = new JButton("X");
		
		buttonTemp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					JDialog tempDialog = new JDialog(mainFrame, "Temperature Converter");
					JPanel tempPanel = createTempPanel();

					tempDialog.add(tempPanel);
					tempDialog.setSize(400, 150);
					tempDialog.setVisible(true);
					tempDialog.setLocationRelativeTo(null);
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(mainFrame, "Temperature Frame Creation Error!");
				}
			}
		});

		JPanel mainPanel = new JPanel();
		JPanel wrapper_1 = new JPanel();
		JPanel wrapper_2 = new JPanel();

		wrapper_1.add(lengthLabel);
		wrapper_1.add(buttonLength);
		wrapper_2.add(tempLabel);
		wrapper_2.add(buttonTemp);

		mainPanel.add(wrapper_1);
		mainPanel.add(wrapper_2);

		mainFrame.add(mainPanel);
		return this;
	}
	
	void initializeFormattedNumbers() {
		doubleFormat = NumberFormat.getNumberInstance();
		doubleFormat.setMaximumFractionDigits(5);
		doubleFormat.setMinimumIntegerDigits(0);
		doubleFormat.setGroupingUsed(false);
		return;
	}

	JPanel createTempPanel() {
		JPanel tempPanel = new JPanel();
		JComboBox comboBox_1, comboBox_2;
		JFormattedTextField textField_1, textField_2;

		String[] tempList = { "Celcius", "Fahrenheit", "Kelvin", "Reaumur" };
		
		comboBox_1 = new JComboBox(tempList);
		comboBox_2 = new JComboBox(tempList);
		
		textField_1 = new JFormattedTextField(doubleFormat);
		textField_1.setValue(0);
		textField_1.setColumns(20);
		textField_2 = new JFormattedTextField(doubleFormat);
		textField_2.setEditable(false);
		textField_2.setValue(0);
		textField_2.setColumns(20);
		
		textField_1.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent event) {
				char input = event.getKeyChar();
				if (!((Character.isDigit(input) || (input == KeyEvent.VK_BACK_SPACE) || (input == KeyEvent.VK_DELETE)
						|| (input == KeyEvent.VK_PERIOD) || (input == KeyEvent.VK_MINUS) ))) {
					event.consume(); // do not add text to the textfield
				}
			}
		});
		
		JButton buttonTemperature;
		buttonTemperature = new JButton("Calculate");
		
		buttonTemperature.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {

					option_1 = comboBox_1.getSelectedItem().toString();
					option_2 = comboBox_2.getSelectedItem().toString();

					String temp = textField_1.getText();
					temp = temp.replace(",", "");
					
					text_1 = Double.parseDouble(temp);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(mainFrame, "TextField input Error!");
				}

				if (option_1 == option_2)
					textField_2.setValue(text_1);
				else {
					try {
						double result = 0;
						switch (option_1) {
							case "Celcius":
								Celcius celcius_1;
								celcius_1 = new Celcius(text_1);
								result = ((Celcius)celcius_1).getResult(option_2);
								break;
							case "Fahrenheit":
								Fahrenheit fahrenheit_1;
								fahrenheit_1 = new Fahrenheit(text_1);
								result = ((Fahrenheit)fahrenheit_1).getResult(option_2);
								break;
							case "Kelvin":
								Kelvin kelvin_1;
								kelvin_1 = new Kelvin(text_1);
								result = ((Kelvin)kelvin_1).getResult(option_2);
								break;
							case "Reaumur":
								Reaumur reamumur_1;
								reamumur_1 = new Reaumur(text_1);
								result = ((Reaumur)reamumur_1).getResult(option_2);
								break;
							default:
								break;
						}
						textField_2.setValue(result);
					} catch (Exception e1) {
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
		tempPanel.setLayout(new GridLayout(3, 2, 5, 5));

		wrapper_1.add(comboBox_1);
		wrapper_1.add(textField_1);
		wrapper_2.add(comboBox_2);
		wrapper_2.add(textField_2);
		wrapper_3.add(buttonTemperature);

		tempPanel.add(wrapper_1);
		tempPanel.add(wrapper_2);
		tempPanel.add(wrapper_3);

		return tempPanel;
	}

	JPanel createLengthPanel() {
		JPanel lengthPanel = new JPanel();
		JComboBox comboBox_1, comboBox_2;
		JFormattedTextField textField_1, textField_2;

		String[] measurementList = { "Inch", "Foot", "Mile", "Yard", "Milimeter", "Centimeter", "Meter", "Kilometer" };

		comboBox_1 = new JComboBox(measurementList);
		comboBox_2 = new JComboBox(measurementList);

		textField_1 = new JFormattedTextField(doubleFormat);
		textField_1.setValue(0);
		textField_1.setColumns(20);
		textField_2 = new JFormattedTextField(doubleFormat);
		textField_2.setEditable(false);
		textField_2.setValue(0);
		textField_2.setColumns(20);

		textField_1.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent event) {
				char input = event.getKeyChar();
				if (!((Character.isDigit(input) || (input == KeyEvent.VK_BACK_SPACE) || (input == KeyEvent.VK_DELETE)
						|| (input == KeyEvent.VK_PERIOD)))) {
					event.consume(); // do not add text to the textfield
				}
			}
		});

		JButton buttonCalculate;
		buttonCalculate = new JButton("Calculate");

		buttonCalculate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				try {

					option_1 = comboBox_1.getSelectedItem().toString();
					fromLen = new Length(option_1);

					option_2 = comboBox_2.getSelectedItem().toString();
					toLen = new Length(option_2);

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
							double factor = toLen.getFactor();
							double temp = text_1 / factor;
							textField_2.setValue(temp);
						} else if (option_2.equalsIgnoreCase("Meter")) {
							double factor = fromLen.getFactor();
							double temp = text_1 * factor;
							textField_2.setValue(temp);
						} else {
							double factor = fromLen.getFactor();
							double temp = text_1 * factor;
							factor = toLen.getFactor();
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
