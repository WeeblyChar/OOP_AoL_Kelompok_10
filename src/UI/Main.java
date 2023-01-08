package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;

public class Main {
	private static JFrame frame;
	private JComboBox comboBox_1, comboBox_2;
	private JFormattedTextField textField_1, textField_2;
	private String option_1, option_2;
	private double text_1;
	private String text_2;
	private NumberFormat doubleFormat;
	private JButton buttonCalculate;
	private Length from, to;

	Main create() {
		frame = new JFrame("Length Measurement Converter");
		String[] measurementList = { "Inch", "Foot", "Mile", "Yard", "Milimeter", "Centimeter", "Meter", "Kilometer" };

		comboBox_1 = new JComboBox(measurementList);
		comboBox_2 = new JComboBox(measurementList);

		doubleFormat = NumberFormat.getNumberInstance();
		doubleFormat.setMaximumFractionDigits(5);
		doubleFormat.setMinimumIntegerDigits(0);

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
					JOptionPane.showMessageDialog(frame, "TextField input Error!");
				}
				
				if (option_1 == option_2)
					textField_2.setValue(text_1);
				else {
					try {
						if(option_1.equalsIgnoreCase("Meter")) {
							double factor = to.getFactor();
							double temp = text_1 / factor;
							textField_2.setValue(temp);
						}else if(option_2.equalsIgnoreCase("Meter")) {
							double factor = from.getFactor();
							double temp = text_1 * factor;
							textField_2.setValue(temp);
						}else {
							double factor = from.getFactor();
							double temp = text_1 * factor;
							factor = to.getFactor();
							temp = temp / factor;
							textField_2.setValue(temp);
						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(frame, "Calculation Error!");
					}
				}

			}
		});

		comboBox_1.setMaximumSize(comboBox_1.getPreferredSize());
		comboBox_2.setMaximumSize(comboBox_2.getPreferredSize());

		JPanel panel = new JPanel();
		JPanel wrapper_1 = new JPanel();
		JPanel wrapper_2 = new JPanel();
		JPanel wrapper_3 = new JPanel();
		panel.setLayout(new GridLayout(3, 2, 5, 5));

		wrapper_1.add(comboBox_1);
		wrapper_1.add(textField_1);

		wrapper_2.add(comboBox_2);
		wrapper_2.add(textField_2);

		wrapper_3.add(buttonCalculate);

		panel.add(wrapper_1);
		panel.add(wrapper_2);
		panel.add(wrapper_3);

		frame.add(panel);

		return this;
	}

	void show() {
		frame.setSize(400, 150);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
