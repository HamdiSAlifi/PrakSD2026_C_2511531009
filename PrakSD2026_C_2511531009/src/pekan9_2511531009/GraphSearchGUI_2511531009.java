package pekan9_2511531009;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

@SuppressWarnings("serial")
public class GraphSearchGUI_2511531009 extends JFrame {

    private final Map<String, List<String>> graph_1009 = new LinkedHashMap<>();
    private final Map<String, int[]> nodePos_1009      = new LinkedHashMap<>();

    private List<String> foundPath_1009      = new ArrayList<>();
    private List<String> visitedOrder_1009   = new ArrayList<>();
    private Set<String>  visitedNodes_1009   = new LinkedHashSet<>();

    private final GraphPanel_1009 graphPanel_1009 = new GraphPanel_1009();
    private JComboBox<String> startBox_1009, goalBox_1009;
    private JTextArea resultArea_1009;

    public GraphSearchGUI_2511531009() {
        buildGraph_1009();
        buildUI_1009();
    }

    private void buildGraph_1009() {
        addEdge_1009("Gerbang Utama",    "Gedung Rektorat");   // 1
        addEdge_1009("Gerbang Utama",    "Parkiran");          // 2
        addEdge_1009("Gedung Rektorat",  "Fakultas Teknik");   // 3
        addEdge_1009("Gedung Rektorat",  "Perpustakaan");      // 4
        addEdge_1009("Gedung Rektorat",  "Masjid");            // 5
        addEdge_1009("Fakultas Teknik",  "Lab Komputer");      // 6
        addEdge_1009("Fakultas Teknik",  "Kantin");            // 7
        addEdge_1009("Perpustakaan",     "Aula");              // 8
        addEdge_1009("Perpustakaan",     "Lab Komputer");      // 9
        addEdge_1009("Lab Komputer",     "Kantin");            // 10
        addEdge_1009("Aula",             "Lapangan");          // 11
        addEdge_1009("Kantin",           "Lapangan");          // 12
        addEdge_1009("Parkiran",         "Gedung Rektorat");   // 13
        addEdge_1009("Masjid",           "Kantin");            // 14
        addEdge_1009("Lapangan",         "Masjid");            // 15

        nodePos_1009.put("Gerbang Utama",   new int[]{60,  210});
        nodePos_1009.put("Parkiran",         new int[]{60,  350});
        nodePos_1009.put("Gedung Rektorat",  new int[]{210, 210});
        nodePos_1009.put("Masjid",           new int[]{210, 350});
        nodePos_1009.put("Fakultas Teknik",  new int[]{370, 110});
        nodePos_1009.put("Perpustakaan",     new int[]{370, 280});
        nodePos_1009.put("Lab Komputer",     new int[]{520, 110});
        nodePos_1009.put("Kantin",           new int[]{520, 280});
        nodePos_1009.put("Aula",             new int[]{650, 180});
        nodePos_1009.put("Lapangan",         new int[]{650, 350});
    }

    private void addEdge_1009(String a_1009, String b_1009) {
        graph_1009.computeIfAbsent(a_1009, k -> new ArrayList<>()).add(b_1009);
        graph_1009.computeIfAbsent(b_1009, k -> new ArrayList<>()).add(a_1009);
    }

    public List<String> BFS(String start_1009, String goal_1009) {
        visitedOrder_1009 = new ArrayList<>();
        Map<String, String> parent_1009 = new LinkedHashMap<>();
        Queue<String> queue_1009 = new LinkedList<>();
        Set<String> visited_1009 = new LinkedHashSet<>();

        queue_1009.add(start_1009);
        visited_1009.add(start_1009);
        parent_1009.put(start_1009, null);

        while (!queue_1009.isEmpty()) {
            String cur_1009 = queue_1009.poll();
            visitedOrder_1009.add(cur_1009);
            if (cur_1009.equals(goal_1009)) return buildPath_1009(parent_1009, goal_1009);
            for (String nb_1009 : graph_1009.getOrDefault(cur_1009, new ArrayList<>())) {
                if (!visited_1009.contains(nb_1009)) {
                    visited_1009.add(nb_1009);
                    parent_1009.put(nb_1009, cur_1009);
                    queue_1009.add(nb_1009);
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

    private boolean dfsHelper_1009(String cur_1009, String goal_1009,
                                    Set<String> visited_1009,
                                    Map<String, String> parent_1009) {
        visited_1009.add(cur_1009);
        visitedOrder_1009.add(cur_1009);
        if (cur_1009.equals(goal_1009)) return true;
        for (String nb_1009 : graph_1009.getOrDefault(cur_1009, new ArrayList<>())) {
            if (!visited_1009.contains(nb_1009)) {
                parent_1009.put(nb_1009, cur_1009);
                if (dfsHelper_1009(nb_1009, goal_1009, visited_1009, parent_1009)) return true;
            }
        }
        return false;
    }

    public void displayGraph() {
        graphPanel_1009.repaint();
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

    public void resetGraph() {
        foundPath_1009.clear();
        visitedOrder_1009.clear();
        visitedNodes_1009.clear();
        resultArea_1009.setText("");
        displayGraph();
    }

    private List<String> buildPath_1009(Map<String, String> parent_1009, String goal_1009) {
        LinkedList<String> path_1009 = new LinkedList<>();
        for (String n_1009 = goal_1009; n_1009 != null; n_1009 = parent_1009.get(n_1009))
            path_1009.addFirst(n_1009);
        return path_1009;
    }

    private void runSearch_1009(boolean isBFS_1009) {
        String start_1009 = (String) startBox_1009.getSelectedItem();
        String goal_1009  = (String) goalBox_1009.getSelectedItem();
        if (start_1009 == null || goal_1009 == null) return;
        if (start_1009.equals(goal_1009)) {
            resultArea_1009.setText("Start dan Goal tidak boleh sama.");
            return;
        }

        String algo_1009 = isBFS_1009 ? "BFS" : "DFS";
        foundPath_1009   = isBFS_1009 ? BFS(start_1009, goal_1009) : DFS(start_1009, goal_1009);
        visitedNodes_1009 = new LinkedHashSet<>(visitedOrder_1009);

        displayGraph();
        displayPath(algo_1009, start_1009, goal_1009);
    }

    private void buildUI_1009() {
        setTitle("BFS & DFS – Peta Kampus | 2511531009");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(8, 8));

        JPanel ctrl_1009 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 6));
        String[] nodes_1009 = graph_1009.keySet().toArray(new String[0]);
        startBox_1009 = new JComboBox<>(nodes_1009);
        goalBox_1009  = new JComboBox<>(nodes_1009);
        goalBox_1009.setSelectedIndex(nodes_1009.length - 1);

        JButton bfsBtn_1009   = new JButton("BFS");
        JButton dfsBtn_1009   = new JButton("DFS");
        JButton resetBtn_1009 = new JButton("Reset");

        ctrl_1009.add(new JLabel("Start:"));  ctrl_1009.add(startBox_1009);
        ctrl_1009.add(new JLabel("Goal:"));   ctrl_1009.add(goalBox_1009);
        ctrl_1009.add(bfsBtn_1009);
        ctrl_1009.add(dfsBtn_1009);
        ctrl_1009.add(resetBtn_1009);
        add(ctrl_1009, BorderLayout.NORTH);

        graphPanel_1009.setPreferredSize(new Dimension(780, 420));
        graphPanel_1009.setBackground(new Color(245, 245, 245));
        add(graphPanel_1009, BorderLayout.CENTER);

        resultArea_1009 = new JTextArea(7, 60);
        resultArea_1009.setEditable(false);
        resultArea_1009.setFont(new Font("Monospaced", Font.PLAIN, 13));
        add(new JScrollPane(resultArea_1009), BorderLayout.SOUTH);

        bfsBtn_1009.addActionListener(e -> runSearch_1009(true));
        dfsBtn_1009.addActionListener(e -> runSearch_1009(false));
        resetBtn_1009.addActionListener(e -> resetGraph());

        pack();
        setLocationRelativeTo(null);
    }

    private class GraphPanel_1009 extends JPanel {
        private static final int R_1009 = 28;

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2_1009 = (Graphics2D) g;
            g2_1009.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            Set<String> drawn_1009 = new HashSet<>();
            for (Map.Entry<String, List<String>> e_1009 : graph_1009.entrySet()) {
                String a_1009  = e_1009.getKey();
                int[]  pa_1009 = nodePos_1009.get(a_1009);
                for (String b_1009 : e_1009.getValue()) {
                    String key_1009 = a_1009.compareTo(b_1009) < 0 ? a_1009 + b_1009 : b_1009 + a_1009;
                    if (drawn_1009.contains(key_1009)) continue;
                    drawn_1009.add(key_1009);
                    int[]   pb_1009    = nodePos_1009.get(b_1009);
                    boolean onPath_1009 = isEdgeOnPath_1009(a_1009, b_1009);
                    g2_1009.setColor(onPath_1009 ? new Color(220, 60, 60) : new Color(160, 160, 160));
                    g2_1009.setStroke(new BasicStroke(onPath_1009 ? 3f : 2f));
                    g2_1009.drawLine(pa_1009[0], pa_1009[1], pb_1009[0], pb_1009[1]);
                }
            }

            for (Map.Entry<String, int[]> e_1009 : nodePos_1009.entrySet()) {
                String name_1009 = e_1009.getKey();
                int x_1009 = e_1009.getValue()[0];
                int y_1009 = e_1009.getValue()[1];

                Color fill_1009;
                if (foundPath_1009.contains(name_1009))        fill_1009 = new Color(220, 60, 60);
                else if (visitedNodes_1009.contains(name_1009)) fill_1009 = new Color(100, 180, 255);
                else                                            fill_1009 = new Color(255, 220, 80);

                g2_1009.setColor(fill_1009);
                g2_1009.fillOval(x_1009 - R_1009, y_1009 - R_1009, R_1009 * 2, R_1009 * 2);
                g2_1009.setColor(Color.DARK_GRAY);
                g2_1009.setStroke(new BasicStroke(2f));
                g2_1009.drawOval(x_1009 - R_1009, y_1009 - R_1009, R_1009 * 2, R_1009 * 2);

                g2_1009.setFont(new Font("SansSerif", Font.BOLD, 10));
                FontMetrics fm_1009  = g2_1009.getFontMetrics();
                String label_1009    = name_1009.length() > 12 ? name_1009.substring(0, 10) + ".." : name_1009;
                int    lw_1009       = fm_1009.stringWidth(label_1009);
                g2_1009.setColor(Color.BLACK);
                g2_1009.drawString(label_1009, x_1009 - lw_1009 / 2, y_1009 + fm_1009.getAscent() / 2 - 1);
            }

            drawLegend_1009(g2_1009);
        }

        private boolean isEdgeOnPath_1009(String a_1009, String b_1009) {
            for (int i_1009 = 0; i_1009 < foundPath_1009.size() - 1; i_1009++) {
                String pa_1009 = foundPath_1009.get(i_1009);
                String pb_1009 = foundPath_1009.get(i_1009 + 1);
                if ((pa_1009.equals(a_1009) && pb_1009.equals(b_1009)) ||
                    (pa_1009.equals(b_1009) && pb_1009.equals(a_1009))) return true;
            }
            return false;
        }

        private void drawLegend_1009(Graphics2D g2_1009) {
            int lx_1009 = 10, ly_1009 = 10;
            g2_1009.setFont(new Font("SansSerif", Font.PLAIN, 11));
            Color[]  colors_1009 = {new Color(255, 220, 80), new Color(100, 180, 255), new Color(220, 60, 60)};
            String[] labels_1009 = {"Belum dikunjungi", "Dikunjungi", "Jalur hasil"};
            for (int i_1009 = 0; i_1009 < colors_1009.length; i_1009++) {
                g2_1009.setColor(colors_1009[i_1009]);
                g2_1009.fillRect(lx_1009, ly_1009 + i_1009 * 18, 14, 14);
                g2_1009.setColor(Color.DARK_GRAY);
                g2_1009.drawRect(lx_1009, ly_1009 + i_1009 * 18, 14, 14);
                g2_1009.drawString(labels_1009[i_1009], lx_1009 + 18, ly_1009 + i_1009 * 18 + 12);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GraphSearchGUI_2511531009().setVisible(true));
    }
}
