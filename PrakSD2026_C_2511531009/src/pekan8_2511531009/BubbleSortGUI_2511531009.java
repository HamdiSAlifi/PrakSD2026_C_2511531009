package pekan8_2511531009;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class BubbleSortGUI_2511531009 extends JFrame {

    private JTextField inputField_1009;
    private JButton setButton_1009;
    private JButton stepButton_1009;
    private JButton resetButton_1009;
    private JTextArea stepArea_1009;
    private JPanel panelArray_1009;

    private int[] array_1009;
    private JLabel[] labelArray_1009;

    private int i_1009 = 0;
    private int j_1009 = 0;
    private int stepCount_1009 = 1;
    private boolean sorting_1009 = false;

    public BubbleSortGUI_2511531009() {
        setTitle("Visualisasi Bubble Sort");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Panel input bagian atas
        JPanel inputPanel = new JPanel(new FlowLayout());

        JLabel inputLabel = new JLabel("Masukkan angka (pisahkan dengan koma):");
        inputField_1009 = new JTextField(30);

        setButton_1009 = new JButton("Set Array");
        stepButton_1009 = new JButton("Step");
        resetButton_1009 = new JButton("Reset");

        stepButton_1009.setEnabled(false);

        inputPanel.add(inputLabel);
        inputPanel.add(inputField_1009);
        inputPanel.add(setButton_1009);
        inputPanel.add(stepButton_1009);
        inputPanel.add(resetButton_1009);

        add(inputPanel, BorderLayout.NORTH);

        // Panel untuk menampilkan array
        panelArray_1009 = new JPanel(new FlowLayout());
        panelArray_1009.setPreferredSize(new Dimension(750, 120));
        add(panelArray_1009, BorderLayout.CENTER);

        // Text area untuk menampilkan langkah sorting
        stepArea_1009 = new JTextArea();
        stepArea_1009.setEditable(false);
        stepArea_1009.setFont(new Font("Monospaced", Font.PLAIN, 14));

        JScrollPane scrollPane = new JScrollPane(stepArea_1009);
        scrollPane.setPreferredSize(new Dimension(750, 250));

        add(scrollPane, BorderLayout.SOUTH);

        // Event tombol
        setButton_1009.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setArrayFromInput();
            }
        });

        stepButton_1009.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performStep();
            }
        });

        resetButton_1009.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset();
            }
        });
    }

    private void setArrayFromInput() {
        String text = inputField_1009.getText().trim();

        if (text.isEmpty()) {
            return;
        }

        String[] parts_1009 = text.split(",");
        array_1009 = new int[parts_1009.length];

        try {
            for (int k = 0; k < parts_1009.length; k++) {
                array_1009[k] = Integer.parseInt(parts_1009[k].trim());
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Masukkan hanya angka yang dipisahkan koma!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        i_1009 = 0;
        j_1009 = 0;
        stepCount_1009 = 1;
        sorting_1009 = true;

        stepButton_1009.setEnabled(true);
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

        panelArray_1009.revalidate();
        panelArray_1009.repaint();
    }

    private void performStep() {
        if (!sorting_1009 || i_1009 >= array_1009.length - 1) {
            sorting_1009 = false;
            stepButton_1009.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Sorting selesai!");
            return;
        }

        resetHighlights();

        StringBuilder stepLog_1009 = new StringBuilder();

        labelArray_1009[j_1009].setBackground(Color.CYAN);
        labelArray_1009[j_1009 + 1].setBackground(Color.CYAN);

        if (array_1009[j_1009] > array_1009[j_1009 + 1]) {
            // Swap
            int temp_1009 = array_1009[j_1009];
            array_1009[j_1009] = array_1009[j_1009 + 1];
            array_1009[j_1009 + 1] = temp_1009;

            labelArray_1009[j_1009].setBackground(Color.RED);
            labelArray_1009[j_1009 + 1].setBackground(Color.RED);

            stepLog_1009.append("Langkah ").append(stepCount_1009).append(": ")
                    .append("Menukar elemen ke-").append(j_1009)
                    .append(" (").append(array_1009[j_1009 + 1]).append(")")
                    .append(" dengan ke-").append(j_1009 + 1)
                    .append(" (").append(array_1009[j_1009]).append(")\n");

        } else {
            stepLog_1009.append("Langkah ").append(stepCount_1009).append(": ")
                    .append("Tidak ada pertukaran antara ke-")
                    .append(j_1009).append(" dan ke-")
                    .append(j_1009 + 1).append("\n");
        }

        stepLog_1009.append("Hasil: ").append(arrayToString(array_1009)).append("\n\n");
        stepArea_1009.append(stepLog_1009.toString());

        updateLabels();

        j_1009++;

        if (j_1009 >= array_1009.length - 1 - i_1009) {
            j_1009 = 0;
            i_1009++;
        }

        stepCount_1009++;

        if (i_1009 >= array_1009.length - 1) {
            sorting_1009 = false;
            stepButton_1009.setEnabled(false);
            resetHighlights();

            for (JLabel label_1009 : labelArray_1009) {
                label_1009.setBackground(Color.GREEN);
            }

            JOptionPane.showMessageDialog(this, "Sorting selesai!");
        }
    }

    private void updateLabels() {
        for (int k_1009 = 0; k_1009 < array_1009.length; k_1009++) {
            labelArray_1009[k_1009].setText(String.valueOf(array_1009[k_1009]));
        }
    }

    private void resetHighlights() {
        for (JLabel label_1009 : labelArray_1009) {
            label_1009.setBackground(Color.WHITE);
        }
    }

    private void reset() {
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

    private String arrayToString(int[] arr) {
        StringBuilder sb_1009 = new StringBuilder();

        for (int k_1009 = 0; k_1009 < arr.length; k_1009++) {
            sb_1009.append(arr[k_1009]);

            if (k_1009 < arr.length - 1) {
                sb_1009.append(", ");
            }
        }

        return sb_1009.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BubbleSortGUI_2511531009().setVisible(true);
            }
        });
    }
}