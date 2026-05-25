package pekan8_2511531009;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class BubbleSortGUI_2511531009 extends JFrame {

	private static final long serialVersionUID = 1L;
	private int[] array_1009;
	private JLabel[] labelArray_1009;
	private JButton stepButton_1009, resetButton_1009, setButton_1009;
	private JTextField inputField_1009;
	private JPanel panelArray_1009;
	private JTextArea stepArea_1009;
	
	private int i_1009 = 1, j_1009;
	private boolean sorting_1009 = false;
	private int stepCount_1009 = 1;
	
	
	/**
	 * 
	 */
	public BubbleSortGUI_2511531009() {
		setTitle("Bubble Sort Langkah per Langkah");
		setSize(750, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		// Panel Input
		JPanel inputPanel_1009 = new JPanel(new FlowLayout());
		inputField_1009 = new JTextField(30);
		setButton_1009 = new JButton("Set Array");
		inputPanel_1009.add(new JLabel("Masukkan angka (pisahkan dengan koma) : "));
		inputPanel_1009.add(inputField_1009);
		inputPanel_1009.add(setButton_1009);
		
		// Array Visual Panel
		panelArray_1009 = new JPanel();
		panelArray_1009.setLayout(new FlowLayout());
		
		// Control Panel
		JPanel controlPanel_1009 = new JPanel();
		stepButton_1009 = new JButton("Langkah Selanjutnya");
		resetButton_1009 = new JButton("Reset");
		stepButton_1009.setEnabled(false);
		controlPanel_1009.add(stepButton_1009);
		controlPanel_1009.add(resetButton_1009);
		
		// Text Area for Log Steps
		stepArea_1009 = new JTextArea(8, 60);
		stepArea_1009.setEditable(false);
		stepArea_1009.setFont(new Font("Monospaced", Font.PLAIN, 14));
		JScrollPane scrollPane_1009 = new JScrollPane(stepArea_1009);
		
		// Adds Panel to Frame
		add(inputPanel_1009, BorderLayout.NORTH);
		add(panelArray_1009, BorderLayout.CENTER);
		add(controlPanel_1009, BorderLayout.SOUTH);
		add(scrollPane_1009, BorderLayout.EAST);
		
		// Event Set Array
		setButton_1009.addActionListener(e -> setArrayFromInput_1009());
		
		// Next Step Event
		stepButton_1009.addActionListener(e -> performStep_1009());

		// Reset Event
		resetButton_1009.addActionListener(e -> reset_1009());
	}
	
	private void setArrayFromInput_1009() {
		String text_1009 = inputField_1009.getText().trim();
		if (text_1009.isEmpty())
			return;
		String[] parts_1009 = text_1009.split(",");
		array_1009 = new int[parts_1009.length];
		try {
			for (int k_1009 = 0; k_1009 < parts_1009.length; k_1009++) {
				array_1009[k_1009] = Integer.parseInt(parts_1009[k_1009].trim());
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Masukkan hanya angka yang dipisahkan " + "dengan koma!", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		i_1009 = 0;
		j_1009 = 0;
		stepCount_1009 = 1;
		sorting_1009 = true;
		stepArea_1009.setEnabled(true); // some says this is unneccessary, but idk
		stepArea_1009.setText("");
		panelArray_1009.removeAll();
		labelArray_1009 = new JLabel[array_1009.length];
		for (int k_1009 = 0; k_1009 < array_1009.length; k_1009++) {
			labelArray_1009[k_1009] = new JLabel(String.valueOf(array_1009[k_1009]));
			labelArray_1009[k_1009].setFont(new Font("Arial", Font.BOLD, 24));
			labelArray_1009[k_1009].setOpaque(true);
			labelArray_1009[k_1009].setBackground(Color.WHITE);
			labelArray_1009[k_1009].setBorder(BorderFactory.createLineBorder(Color.BLACK));
			labelArray_1009[k_1009].setPreferredSize(new Dimension(50, 50));
			labelArray_1009[k_1009].setHorizontalAlignment(SwingConstants.CENTER);
			panelArray_1009.add(labelArray_1009[k_1009]);
		}
		stepButton_1009.setEnabled(true); // ini penting : memperbaiki bug next step
		panelArray_1009.revalidate();
		panelArray_1009.repaint();
	}

	private void performStep_1009() {
		if (!sorting_1009 || i_1009 >= array_1009.length - 1) {
			sorting_1009 = false;
			stepArea_1009.setEnabled(false);
			JOptionPane.showMessageDialog(this,  "Sorting Selesai!");
			return;
		}
		resetHighlights();
		StringBuilder stepLog_1009 = new StringBuilder();
		labelArray_1009[j_1009].setBackground(Color.CYAN);
		labelArray_1009[j_1009].setBackground(Color.CYAN);
		
		if (array_1009[j_1009] > array_1009[j_1009 + 1]) {
			// Swap
			int temp_1009 = array_1009[j_1009];
			array_1009[j_1009] = array_1009[j_1009 + 1];
			array_1009[j_1009 + 1] = temp_1009;
			labelArray_1009[j_1009].setBackground(Color.RED);
			labelArray_1009[j_1009 + 1].setBackground(Color.RED);
			stepLog_1009.append("Langkah ").append(stepCount_1009).append(": Menukar elemen ke-").append(j_1009).append(" (").append(array_1009[j_1009 +1]).append(") dengan ke-").append(j_1009 + 1).append(" (").append(array_1009[j_1009]).append(") \n");
		} else {
			stepLog_1009.append("Langkah ").append(stepCount_1009).append(": Tidak ada pertukaran antara ke-").append(j_1009).append(" dan ke-").append(j_1009 + 1).append("\n");
		}
		stepLog_1009.append("Hasil :").append(arrayToString_1009(array_1009)).append("\n\n");
		stepLog_1009.append(stepLog_1009.toString());
		updateLabels_1009();
		j_1009++;
		if (j_1009 >= array_1009.length - i_1009 - 1) {
			j_1009 = 0;
			i_1009++;
		}
		stepCount_1009++;
		
		if (i_1009 >= array_1009.length - 1) {
			sorting_1009 = false;
			stepButton_1009.setEnabled(false);
			JOptionPane.showMessageDialog(this,  "Sorting Selesai!");
		}
	}
	

	private void resetHighlights() {
		for (JLabel label_1009 : labelArray_1009) {
			label_1009.setBackground(Color.WHITE);
		}
		
	}

	private void updateLabels_1009() {
		for (int k_1009 = 0; k_1009 < array_1009.length; k_1009++) {
			labelArray_1009[k_1009].setText(String.valueOf(array_1009[k_1009]));
		}
	}
	private String arrayToString_1009(int[] array_10092) {
		StringBuilder sb_1009 = new StringBuilder();
		for (int k_1009 = 0; k_1009 < array_10092.length; k_1009++) {
			sb_1009.append(array_10092[k_1009]);
			if (k_1009 < array_10092.length - 1)
				sb_1009.append(", ");
		}
		return sb_1009.toString();
	}

	private void reset_1009() {
		inputField_1009.setText("");
		panelArray_1009.removeAll();
		panelArray_1009.revalidate();
		panelArray_1009.repaint();
		stepArea_1009.setText("");
		stepButton_1009.setEnabled(false);
		sorting_1009 = false;
		i_1009 = 0;
		j_1009 = 0;
		stepCount_1009 = 1;
	}
	
	public static void main(String[] args) {
	    SwingUtilities.invokeLater(() -> {
	    	BubbleSortGUI_2511531009 frame_1009 = new BubbleSortGUI_2511531009();
	    	frame_1009.setVisible(true);
	    });
	}
}
