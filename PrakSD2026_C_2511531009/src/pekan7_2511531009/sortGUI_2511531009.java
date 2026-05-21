package pekan7_2511531009;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class sortGUI_2511531009 extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTextField txtNama_1009, txtNim_1009, txtProdi_1009;
    private JComboBox<String> comboSorting_1009;
    private JButton addButton_1009, stepButton_1009, resetButton_1009;

    private JPanel panelArray_1009;
    private JLabel[] labelArray_1009;
    private JTextArea areaLangkah_1009;

    private ArrayList<mahasiswaADT_2511531009> listMhs_1009;
    private ArrayList<mahasiswaADT_2511531009> dataSorting_1009;

    private int i_1009;
    private boolean sortingSelesai_1009;

    public sortGUI_2511531009() {
        setTitle("Visualisasi Sorting Mahasiswa");
        setSize(950, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        listMhs_1009 = new ArrayList<>();

        // Input Panel
        JPanel panelInput_1009 = new JPanel(new GridLayout(5, 2, 5, 5));
        panelInput_1009.setBorder(BorderFactory.createTitledBorder("Input Data"));

        panelInput_1009.add(new JLabel("Nama Mahasiswa"));
        txtNama_1009 = new JTextField();
        panelInput_1009.add(txtNama_1009);

        panelInput_1009.add(new JLabel("NIM"));
        txtNim_1009 = new JTextField();
        panelInput_1009.add(txtNim_1009);

        panelInput_1009.add(new JLabel("Program Studi"));
        txtProdi_1009 = new JTextField();
        panelInput_1009.add(txtProdi_1009);

        panelInput_1009.add(new JLabel("Pilih Sorting"));
        comboSorting_1009 = new JComboBox<>();
        comboSorting_1009.addItem("Insertion Sort");
        comboSorting_1009.addItem("Selection Sort");
        comboSorting_1009.addItem("Bubble Sort");
        panelInput_1009.add(comboSorting_1009);

        addButton_1009 = new JButton("Tambah Data");
        panelInput_1009.add(addButton_1009);

        panelArray_1009 = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 8));
        panelArray_1009.setBorder(BorderFactory.createTitledBorder("Visualisasi Data"));

        JPanel panelControl_1009 = new JPanel();
        stepButton_1009  = new JButton("Langkah Selanjutnya");
        resetButton_1009 = new JButton("Reset");
        panelControl_1009.add(stepButton_1009);
        panelControl_1009.add(resetButton_1009);
        stepButton_1009.setEnabled(false);

        areaLangkah_1009 = new JTextArea();
        areaLangkah_1009.setEditable(false);
        areaLangkah_1009.setFont(new Font("Monospaced", Font.PLAIN, 13));
        JScrollPane scroll_1009 = new JScrollPane(areaLangkah_1009);
        scroll_1009.setPreferredSize(new Dimension(350, 0));
        scroll_1009.setBorder(BorderFactory.createTitledBorder("Log Langkah"));

        add(panelInput_1009,  BorderLayout.NORTH);
        add(panelArray_1009,  BorderLayout.CENTER);
        add(panelControl_1009, BorderLayout.SOUTH);
        add(scroll_1009,      BorderLayout.EAST);

        addButton_1009.addActionListener(e -> tambahData_1009());
        stepButton_1009.addActionListener(e -> prosesSorting_1009());
        resetButton_1009.addActionListener(e -> reset_1009());
    }

    private void tambahData_1009() {
        String nama_1009  = txtNama_1009.getText().trim();
        String nim_1009   = txtNim_1009.getText().trim();
        String prodi_1009 = txtProdi_1009.getText().trim();

        if (nama_1009.isEmpty() || nim_1009.isEmpty() || prodi_1009.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Data belum lengkap!");
            return;
        }

        mahasiswaADT_2511531009 mhs_1009 =
                new mahasiswaADT_2511531009(nama_1009, nim_1009, prodi_1009);
        listMhs_1009.add(mhs_1009);

        dataSorting_1009  = null;
        i_1009            = 1;
        sortingSelesai_1009 = false;

        tampilkanVisual_1009(listMhs_1009);
        areaLangkah_1009.setText("");

        txtNama_1009.setText("");
        txtNim_1009.setText("");
        txtProdi_1009.setText("");

        stepButton_1009.setEnabled(true);
    }

    private void tampilkanVisual_1009(ArrayList<mahasiswaADT_2511531009> data_1009) {
        panelArray_1009.removeAll();
        labelArray_1009 = new JLabel[data_1009.size()];

        for (int k_1009 = 0; k_1009 < data_1009.size(); k_1009++) {
            labelArray_1009[k_1009] = new JLabel(data_1009.get(k_1009).getNama_1009());
            labelArray_1009[k_1009].setFont(new Font("Arial", Font.BOLD, 15));
            labelArray_1009[k_1009].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            labelArray_1009[k_1009].setPreferredSize(new Dimension(120, 50));
            labelArray_1009[k_1009].setHorizontalAlignment(SwingConstants.CENTER);
            panelArray_1009.add(labelArray_1009[k_1009]);
        }

        panelArray_1009.revalidate();
        panelArray_1009.repaint();
    }

    private void prosesSorting_1009() {
        if (listMhs_1009.size() <= 1) {
            JOptionPane.showMessageDialog(this, "Data minimal 2!");
            return;
        }

        if (dataSorting_1009 == null) {
            dataSorting_1009 = new ArrayList<>();
            for (mahasiswaADT_2511531009 m : listMhs_1009) {
                dataSorting_1009.add(new mahasiswaADT_2511531009(
                        m.getNama_1009(), m.getNIM_1009(), m.getProdi_1009()));
            }
            i_1009 = 1;
        }

        String pilihan_1009 = (String) comboSorting_1009.getSelectedItem();

        if ("Insertion Sort".equals(pilihan_1009)) {
            insertionStep_1009();
        } else if ("Selection Sort".equals(pilihan_1009)) {
            selectionStep_1009();
        } else {
            bubbleStep_1009();
        }

        tampilkanVisual_1009(dataSorting_1009);
    }

    private void insertionStep_1009() {
        if (i_1009 < dataSorting_1009.size()) {
            mahasiswaADT_2511531009 key_1009 = dataSorting_1009.get(i_1009);
            int j_1009 = i_1009 - 1;

            while (j_1009 >= 0 &&
                   dataSorting_1009.get(j_1009).getNama_1009()
                           .compareToIgnoreCase(key_1009.getNama_1009()) > 0) {
                dataSorting_1009.set(j_1009 + 1, dataSorting_1009.get(j_1009));
                j_1009--;
            }
            dataSorting_1009.set(j_1009 + 1, key_1009);

            areaLangkah_1009.append(
                    "Langkah " + i_1009 + " : " + tampilNama_1009(dataSorting_1009) + "\n");
            i_1009++;
        } else {
            selesai_1009();
        }
    }

    private void selectionStep_1009() {
        if (i_1009 <= dataSorting_1009.size() - 1) {
            int min_1009 = i_1009 - 1;
            for (int j_1009 = i_1009; j_1009 < dataSorting_1009.size(); j_1009++) {
                if (dataSorting_1009.get(j_1009).getNama_1009()
                        .compareToIgnoreCase(dataSorting_1009.get(min_1009).getNama_1009()) < 0) {
                    min_1009 = j_1009;
                }
            }
            mahasiswaADT_2511531009 temp_1009 = dataSorting_1009.get(i_1009 - 1);
            dataSorting_1009.set(i_1009 - 1, dataSorting_1009.get(min_1009));
            dataSorting_1009.set(min_1009, temp_1009);

            areaLangkah_1009.append(
                    "Pass " + i_1009 + " : " + tampilNama_1009(dataSorting_1009) + "\n");
            i_1009++;
        } else {
            selesai_1009();
        }
    }

    private void bubbleStep_1009() {
        if (i_1009 < dataSorting_1009.size()) {
            for (int j_1009 = 0; j_1009 < dataSorting_1009.size() - i_1009; j_1009++) {
                if (dataSorting_1009.get(j_1009).getNama_1009()
                        .compareToIgnoreCase(
                                dataSorting_1009.get(j_1009 + 1).getNama_1009()) > 0) {
                    mahasiswaADT_2511531009 temp_1009 = dataSorting_1009.get(j_1009);
                    dataSorting_1009.set(j_1009, dataSorting_1009.get(j_1009 + 1));
                    dataSorting_1009.set(j_1009 + 1, temp_1009);
                }
            }
            areaLangkah_1009.append(
                    "Pass " + i_1009 + " : " + tampilNama_1009(dataSorting_1009) + "\n");
            i_1009++;
        } else {
            selesai_1009();
        }
    }

    private String tampilNama_1009(ArrayList<mahasiswaADT_2511531009> data_1009) {
        StringBuilder sb_1009 = new StringBuilder("[");
        for (int k_1009 = 0; k_1009 < data_1009.size(); k_1009++) {
            sb_1009.append(data_1009.get(k_1009).getNama_1009());
            if (k_1009 != data_1009.size() - 1) sb_1009.append(", ");
        }
        sb_1009.append("]");
        return sb_1009.toString();
    }

    private void selesai_1009() {
        if (!sortingSelesai_1009) {
            sortingSelesai_1009 = true;
            stepButton_1009.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Sorting selesai!");
        }
    }

    private void reset_1009() {
        listMhs_1009.clear();
        dataSorting_1009 = null;

        panelArray_1009.removeAll();
        panelArray_1009.revalidate();
        panelArray_1009.repaint();

        areaLangkah_1009.setText("");
        txtNama_1009.setText("");
        txtNim_1009.setText("");
        txtProdi_1009.setText("");

        i_1009 = 1;
        sortingSelesai_1009 = false;
        stepButton_1009.setEnabled(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new sortGUI_2511531009().setVisible(true));
    }
}
