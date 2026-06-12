package pekan9_2511531009;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

@SuppressWarnings("serial")
public class GraphSearchGUI_2511531009 extends JFrame {

    private final Map<String, List<String>> graph_1009 = new LinkedHashMap<>();

    private List<String> foundPath_1009    = new ArrayList<>();
    private List<String> visitedOrder_1009 = new ArrayList<>();
    private Set<String>  visitedNodes_1009 = new LinkedHashSet<>();

    private JTextArea graphArea_1009;
    private JComboBox<String> startBox_1009, goalBox_1009;
    private JTextArea resultArea_1009;

    private static final String[] NODES_1009 = {
        "Gerbang Utama", "Gedung Rektorat", "Fakultas Teknik",
        "Lab Komputer",  "Aula",            "Perpustakaan",
        "Kantin",        "Lapangan",        "Parkiran",
        "Masjid"
    };
    private static final int[][] GRID_POS_1009 = {
        {0, 1}, {1, 1}, {2, 0}, {3, 0}, {4, 0},
        {2, 1}, {3, 1}, {4, 1}, {0, 2}, {1, 2}
    };

    public GraphSearchGUI_2511531009() {
        buildGraph_1009();
        buildUI_1009();
    }

    private void buildGraph_1009() {
        addEdge_1009("Gerbang Utama",   "Gedung Rektorat");
        addEdge_1009("Gerbang Utama",   "Parkiran");
        addEdge_1009("Gedung Rektorat", "Fakultas Teknik");
        addEdge_1009("Gedung Rektorat", "Perpustakaan");
        addEdge_1009("Gedung Rektorat", "Masjid");
        addEdge_1009("Fakultas Teknik", "Lab Komputer");
        addEdge_1009("Fakultas Teknik", "Kantin");
        addEdge_1009("Perpustakaan",    "Aula");
        addEdge_1009("Perpustakaan",    "Lab Komputer");
        addEdge_1009("Lab Komputer",    "Kantin");
        addEdge_1009("Aula",            "Lapangan");
        addEdge_1009("Kantin",          "Lapangan");
        addEdge_1009("Parkiran",        "Gedung Rektorat");
        addEdge_1009("Masjid",          "Kantin");
        addEdge_1009("Lapangan",        "Masjid");
    }

    private void addEdge_1009(String a_1009, String b_1009) {
        graph_1009.computeIfAbsent(a_1009, k_1009 -> new ArrayList<>()).add(b_1009);
        graph_1009.computeIfAbsent(b_1009, k_1009 -> new ArrayList<>()).add(a_1009);
    }

    public List<String> BFS_1009(String start_1009, String goal_1009) {
        visitedOrder_1009 = new ArrayList<>();
        Map<String, String> parent_1009 = new LinkedHashMap<>();
        Queue<String> queue_1009 = new LinkedList<>();
        Set<String> visited_1009 = new LinkedHashSet<>();
        queue_1009.add(start_1009); visited_1009.add(start_1009); parent_1009.put(start_1009, null);
        while (!queue_1009.isEmpty()) {
            String cur_1009 = queue_1009.poll();
            visitedOrder_1009.add(cur_1009);
            if (cur_1009.equals(goal_1009)) return buildPath_1009(parent_1009, goal_1009);
            for (String nb_1009 : graph_1009.getOrDefault(cur_1009, new ArrayList<>())) {
                if (!visited_1009.contains(nb_1009)) {
                    visited_1009.add(nb_1009); parent_1009.put(nb_1009, cur_1009); queue_1009.add(nb_1009);
                }
            }
        }
        return new ArrayList<>();
    }

    public List<String> DFS(String start_1009, String goal_1009) {
        visitedOrder_1009 = new ArrayList<>();
        Map<String, String> parent_1009 = new LinkedHashMap<>();
        Set<String> visited_1009 = new LinkedHashSet<>();
        parent_1009.put(start_1009, null);
        dfsHelper_1009(start_1009, goal_1009, visited_1009, parent_1009);
        return visited_1009.contains(goal_1009) ? buildPath_1009(parent_1009, goal_1009) : new ArrayList<>();
    }

    private boolean dfsHelper_1009(String cur_1009, String goal_1009, Set<String> visited_1009, Map<String, String> parent_1009) {
        visited_1009.add(cur_1009); visitedOrder_1009.add(cur_1009);
        if (cur_1009.equals(goal_1009)) return true;
        for (String nb_1009 : graph_1009.getOrDefault(cur_1009, new ArrayList<>())) {
            if (!visited_1009.contains(nb_1009)) {
                parent_1009.put(nb_1009, cur_1009);
                if (dfsHelper_1009(nb_1009, goal_1009, visited_1009, parent_1009)) return true;
            }
        }
        return false;
    }

    private List<String> buildPath_1009(Map<String, String> parent_1009, String goal_1009) {
        LinkedList<String> path_1009 = new LinkedList<>();
        for (String n_1009 = goal_1009; n_1009 != null; n_1009 = parent_1009.get(n_1009))
            path_1009.addFirst(n_1009);
        return path_1009;
    }

    public void displayGraph_1009() {
        int[] innerW_1009 = {15, 16, 16, 13, 10};

        Set<String> hEdge_1009 = edgeSet_1009(
            "Fakultas Teknik", "Lab Komputer",
            "Lab Komputer",    "Aula",
            "Gerbang Utama",   "Gedung Rektorat",
            "Gedung Rektorat", "Perpustakaan",
            "Perpustakaan",    "Kantin",
            "Kantin",          "Lapangan"
        );
        Set<String> vEdge_1009 = edgeSet_1009(
            "Gerbang Utama",   "Parkiran",
            "Gedung Rektorat", "Masjid",
            "Fakultas Teknik", "Perpustakaan",
            "Lab Komputer",    "Kantin",
            "Aula",            "Lapangan"
        );

        StringBuilder sb_1009 = new StringBuilder();

        for (int row_1009 = 0; row_1009 < 3; row_1009++) {
            StringBuilder top_1009  = new StringBuilder();
            StringBuilder mid_1009  = new StringBuilder();
            StringBuilder bot_1009  = new StringBuilder();
            StringBuilder vert_1009 = new StringBuilder();

            for (int col_1009 = 0; col_1009 < 5; col_1009++) {
                String name_1009  = nameAt_1009(row_1009, col_1009);
                int w_1009        = innerW_1009[col_1009];
                int cellW_1009    = w_1009 + 4;

                if (name_1009 == null) {
                    top_1009.append(" ".repeat(cellW_1009));
                    mid_1009.append(" ".repeat(cellW_1009));
                    bot_1009.append(" ".repeat(cellW_1009));
                } else {
                    String border_1009 = "-".repeat(w_1009 + 2);
                    String prefix_1009, suffix_1009;
                    if      (foundPath_1009.contains(name_1009))    { prefix_1009 = "*"; suffix_1009 = "*"; }
                    else if (visitedNodes_1009.contains(name_1009)) { prefix_1009 = ">"; suffix_1009 = "<"; }
                    else                                            { prefix_1009 = "|"; suffix_1009 = "|"; }
                    top_1009.append("+").append(border_1009).append("+");
                    mid_1009.append(prefix_1009).append(" ").append(padCenter_1009(name_1009, w_1009)).append(" ").append(suffix_1009);
                    bot_1009.append("+").append(border_1009).append("+");
                }

                if (col_1009 < 4) {
                    String left_1009  = nameAt_1009(row_1009, col_1009);
                    String right_1009 = nameAt_1009(row_1009, col_1009 + 1);
                    boolean conn_1009 = left_1009 != null && right_1009 != null && hasEdge_1009(hEdge_1009, left_1009, right_1009);
                    String dash_1009  = conn_1009 ? (isConsecutive_1009(left_1009, right_1009) ? "***" : "---") : "   ";
                    top_1009.append("   ");
                    mid_1009.append(dash_1009);
                    bot_1009.append("   ");
                }
            }
            sb_1009.append(top_1009).append("\n").append(mid_1009).append("\n").append(bot_1009).append("\n");

            if (row_1009 < 2) {
                for (int col_1009 = 0; col_1009 < 5; col_1009++) {
                    String above_1009 = nameAt_1009(row_1009, col_1009);
                    String below_1009 = nameAt_1009(row_1009 + 1, col_1009);
                    int cellW_1009    = innerW_1009[col_1009] + 4;
                    boolean conn_1009 = above_1009 != null && below_1009 != null && hasEdge_1009(vEdge_1009, above_1009, below_1009);
                    if (conn_1009) {
                        int half_1009 = cellW_1009 / 2;
                        vert_1009.append(" ".repeat(half_1009)).append("|").append(" ".repeat(cellW_1009 - half_1009 - 1));
                    } else {
                        vert_1009.append(" ".repeat(cellW_1009));
                    }
                    if (col_1009 < 4) vert_1009.append("   ");
                }
                sb_1009.append(vert_1009).append("\n");
            }
        }

        sb_1009.append("\n(~) diagonal/long edges:\n");
        String[][] diag_1009 = {
            {"Gedung Rektorat", "Fakultas Teknik"},
            {"Perpustakaan",    "Lab Komputer"},
            {"Perpustakaan",    "Aula"},
            {"Fakultas Teknik", "Kantin"},
            {"Lapangan",        "Masjid"},
            {"Masjid",          "Kantin"}
        };
        for (String[] d_1009 : diag_1009) {
            String mark_1009 = isConsecutive_1009(d_1009[0], d_1009[1]) ? "  <-- on path" : "";
            sb_1009.append("  ").append(d_1009[0]).append(" ~ ").append(d_1009[1]).append(mark_1009).append("\n");
        }
        sb_1009.append("\nLegenda: |x|=belum dikunjungi  >x<=dikunjungi  *x*=jalur hasil");
        graphArea_1009.setText(sb_1009.toString());
    }

    private String padCenter_1009(String s_1009, int width_1009) {
        if (s_1009.length() >= width_1009) return s_1009.substring(0, width_1009);
        int pad_1009 = width_1009 - s_1009.length(), left_1009 = pad_1009 / 2;
        return " ".repeat(left_1009) + s_1009 + " ".repeat(pad_1009 - left_1009);
    }

    private String nameAt_1009(int row_1009, int col_1009) {
        for (int i_1009 = 0; i_1009 < NODES_1009.length; i_1009++)
            if (GRID_POS_1009[i_1009][1] == row_1009 && GRID_POS_1009[i_1009][0] == col_1009)
                return NODES_1009[i_1009];
        return null;
    }

    private boolean isConsecutive_1009(String a_1009, String b_1009) {
        for (int i_1009 = 0; i_1009 < foundPath_1009.size() - 1; i_1009++) {
            String x_1009 = foundPath_1009.get(i_1009), y_1009 = foundPath_1009.get(i_1009 + 1);
            if ((x_1009.equals(a_1009) && y_1009.equals(b_1009)) || (x_1009.equals(b_1009) && y_1009.equals(a_1009))) return true;
        }
        return false;
    }

    private Set<String> edgeSet_1009(String... pairs_1009) {
        Set<String> s_1009 = new HashSet<>();
        for (int i_1009 = 0; i_1009 < pairs_1009.length; i_1009 += 2)
            s_1009.add(key_1009(pairs_1009[i_1009], pairs_1009[i_1009 + 1]));
        return s_1009;
    }

    private boolean hasEdge_1009(Set<String> set_1009, String a_1009, String b_1009) {
        return a_1009 != null && b_1009 != null && set_1009.contains(key_1009(a_1009, b_1009));
    }

    private String key_1009(String a_1009, String b_1009) {
        return a_1009.compareTo(b_1009) < 0 ? a_1009 + "|" + b_1009 : b_1009 + "|" + a_1009;
    }

    public void displayPath(String algo_1009, String start_1009, String goal_1009) {
        StringBuilder sb_1009 = new StringBuilder();
        sb_1009.append("Algoritma         : ").append(algo_1009).append("\n");
        sb_1009.append("Start             : ").append(start_1009).append("\n");
        sb_1009.append("Goal              : ").append(goal_1009).append("\n\n");
        sb_1009.append("Urutan dikunjungi (").append(visitedOrder_1009.size()).append(" node):\n");
        sb_1009.append(String.join(" → ", visitedOrder_1009)).append("\n\n");
        if (foundPath_1009.isEmpty()) {
            sb_1009.append("Jalur tidak ditemukan.");
        } else {
            sb_1009.append("Jalur ditemukan (").append(foundPath_1009.size()).append(" node):\n");
            sb_1009.append(String.join(" → ", foundPath_1009));
        }
        resultArea_1009.setText(sb_1009.toString());
    }

    public void resetGraph_1009() {
        foundPath_1009.clear(); visitedOrder_1009.clear(); visitedNodes_1009.clear();
        resultArea_1009.setText("");
        displayGraph_1009();
    }

    private void runSearch_1009(boolean isBFS_1009) {
        String start_1009 = (String) startBox_1009.getSelectedItem();
        String goal_1009  = (String) goalBox_1009.getSelectedItem();
        if (start_1009 == null || goal_1009 == null) return;
        if (start_1009.equals(goal_1009)) { resultArea_1009.setText("Start dan Goal tidak boleh sama."); return; }
        String algo_1009   = isBFS_1009 ? "BFS" : "DFS";
        foundPath_1009     = isBFS_1009 ? BFS_1009(start_1009, goal_1009) : DFS(start_1009, goal_1009);
        visitedNodes_1009  = new LinkedHashSet<>(visitedOrder_1009);
        displayGraph_1009();
        displayPath(algo_1009, start_1009, goal_1009);
    }

    private void buildUI_1009() {
        setTitle("BFS & DFS – Peta Kampus | 2511531009");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(8, 8));

        JPanel ctrl_1009   = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 6));
        String[] nodes_1009 = graph_1009.keySet().toArray(new String[0]);
        startBox_1009 = new JComboBox<>(nodes_1009);
        goalBox_1009  = new JComboBox<>(nodes_1009);
        goalBox_1009.setSelectedIndex(nodes_1009.length - 1);

        JButton bfsBtn_1009   = new JButton("BFS");
        JButton dfsBtn_1009   = new JButton("DFS");
        JButton resetBtn_1009 = new JButton("Reset");
        ctrl_1009.add(new JLabel("Start:")); ctrl_1009.add(startBox_1009);
        ctrl_1009.add(new JLabel("Goal:"));  ctrl_1009.add(goalBox_1009);
        ctrl_1009.add(bfsBtn_1009); ctrl_1009.add(dfsBtn_1009); ctrl_1009.add(resetBtn_1009);
        add(ctrl_1009, BorderLayout.NORTH);

        graphArea_1009 = new JTextArea(12, 80);
        graphArea_1009.setEditable(false);
        graphArea_1009.setFont(new Font("Monospaced", Font.PLAIN, 13));
        add(new JScrollPane(graphArea_1009), BorderLayout.CENTER);

        resultArea_1009 = new JTextArea(7, 80);
        resultArea_1009.setEditable(false);
        resultArea_1009.setFont(new Font("Monospaced", Font.PLAIN, 13));
        add(new JScrollPane(resultArea_1009), BorderLayout.SOUTH);

        bfsBtn_1009.addActionListener(e_1009 -> runSearch_1009(true));
        dfsBtn_1009.addActionListener(e_1009 -> runSearch_1009(false));
        resetBtn_1009.addActionListener(e_1009 -> resetGraph_1009());

        pack();
        setLocationRelativeTo(null);
        displayGraph_1009();
    }

    public static void main(String[] args_1009) {
        SwingUtilities.invokeLater(() -> new GraphSearchGUI_2511531009().setVisible(true));
    }
}
