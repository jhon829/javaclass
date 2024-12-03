import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ComponentWindow extends JFrame implements ActionListener {
    private JTextArea textArea;
    private JTextField jTextLeft1, jTextLeft2;
    private JLabel jLResult;
    private JTextField radius, area;
    private JTextField idField, pwField;

    private static final String CORRECT_ID = "jhon829";
    private static final String CORRECT_PASSWORD = "1234";

    public ComponentWindow() {
        setTitle("C084007 김동년");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        JPanel mainPanel = new JPanel(new BorderLayout());

        // 메뉴바 생성
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem newItem = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open File...");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem saveAsItem = new JMenuItem("Save as...");
        JMenuItem exitItem = new JMenuItem("Exit");

        newItem.addActionListener(this);
        openItem.addActionListener(this);
        saveItem.addActionListener(this);
        saveAsItem.addActionListener(this);
        exitItem.addActionListener(this);

        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(saveAsItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        // 방향 버튼 추가
        JButton northButton = new JButton("NORTH");
        JButton eastButton = new JButton("EAST");
        JButton westButton = new JButton("WEST");

        northButton.addActionListener(this);
        eastButton.addActionListener(this);
        westButton.addActionListener(this);

        mainPanel.add(northButton, BorderLayout.NORTH);
        mainPanel.add(eastButton, BorderLayout.EAST);
        mainPanel.add(westButton, BorderLayout.WEST);

        // 중앙 패널 설정
        Container contentPane = new JPanel(new GridLayout(2, 2, 5, 5));
        mainPanel.add(contentPane, BorderLayout.CENTER);

        // 섹션 1: 계산기
        JPanel p1 = new JPanel(new FlowLayout());
        p1.setBackground(Color.GREEN);
        jTextLeft1 = new JTextField(10);
        jTextLeft2 = new JTextField(10);
        jLResult = new JLabel("결과는 여기에...");
        JButton jBResult = new JButton("Calculation");
        jBResult.addActionListener(this);

        p1.add(jTextLeft1);
        p1.add(new JLabel("+"));
        p1.add(jTextLeft2);
        p1.add(new JLabel("="));
        p1.add(jLResult);
        p1.add(jBResult);

        contentPane.add(p1);

        // 섹션 2: 숫자 버튼
        JPanel section2Panel = new JPanel(new GridLayout(2, 5, 5, 5));
        section2Panel.setBackground(Color.YELLOW);
        for (int i = 0; i <= 9; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.addActionListener(this);
            section2Panel.add(button);
        }
        contentPane.add(section2Panel);

        // 섹션 3: 원 계산기
        JPanel section3Panel = new JPanel(new BorderLayout());
        section3Panel.setBackground(Color.BLUE);

        JPanel topPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        radius = new JTextField();
        area = new JTextField();
        topPanel.add(new JLabel("원의 반지름"));
        topPanel.add(radius);
        topPanel.add(new JLabel("원의 넓이"));
        topPanel.add(area);

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);

        JPanel bottomPanel = new JPanel(new FlowLayout());
        JButton calculateBtn = new JButton("계산");
        calculateBtn.addActionListener(this);
        String[] colors = {"Blue", "Red"};
        JComboBox<String> colorComboBox = new JComboBox<>(colors);
        JButton resetBtn = new JButton("리셋");
        resetBtn.addActionListener(this);

        colorComboBox.addActionListener(e -> {
            String selectedColor = (String) colorComboBox.getSelectedItem();
            if (selectedColor.equals("Blue")) {
                textArea.setForeground(Color.BLUE);
            } else if (selectedColor.equals("Red")) {
                textArea.setForeground(Color.RED);
            }
        });

        bottomPanel.add(calculateBtn);
        bottomPanel.add(colorComboBox);
        bottomPanel.add(resetBtn);

        section3Panel.add(topPanel, BorderLayout.NORTH);
        section3Panel.add(scrollPane, BorderLayout.CENTER);
        section3Panel.add(bottomPanel, BorderLayout.SOUTH);

        contentPane.add(section3Panel);

        // 섹션 4: 로그인 및 계산기
        JPanel section4Panel = new JPanel(new BorderLayout());
        section4Panel.setBackground(Color.RED);

        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.Y_AXIS));
        containerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        containerPanel.setBackground(Color.RED);

        JPanel loginPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        idField = new JTextField();
        pwField = new JTextField();
        JButton loginButton = new JButton("로그인");
        loginButton.addActionListener(this);

        loginPanel.add(new JLabel("아이디"));
        loginPanel.add(idField);
        loginPanel.add(new JLabel("비밀번호"));
        loginPanel.add(pwField);
        loginPanel.add(new JLabel(""));
        loginPanel.add(loginButton);

        JPanel numberPanel = new JPanel(new GridLayout(4, 4, 2, 2));
        String[] buttonLabels = {
                "1", "2", "3", "C",
                "4", "5", "6", "X",
                "7", "8", "9", "-",
                "0", "+", "-", "="
        };
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(this);
            numberPanel.add(button);
        }

        containerPanel.add(loginPanel);
        containerPanel.add(numberPanel);
        section4Panel.add(containerPanel, BorderLayout.CENTER);

        contentPane.add(section4Panel);

        // SOUTH 패널 생성 및 버튼 추가
        JPanel southPanel = new JPanel(new GridLayout(2, 1));
        JButton fileChooseButton = new JButton("파일 선택");
        fileChooseButton.addActionListener(this);
        southPanel.add(fileChooseButton);
        JButton southButton = new JButton("SOUTH");
        southButton.addActionListener(this);
        southPanel.add(southButton);
        mainPanel.add(southPanel, BorderLayout.SOUTH);

        setContentPane(mainPanel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JMenuItem) {
            JMenuItem menuItem = (JMenuItem) e.getSource();
            String menuText = menuItem.getText();

            switch (menuText) {
                case "Open File...":
                    JFileChooser fileChooser = new JFileChooser();
                    int result = fileChooser.showOpenDialog(this);
                    if (result == JFileChooser.APPROVE_OPTION) {
                        File selectedFile = fileChooser.getSelectedFile();
                        JOptionPane.showMessageDialog(this, "선택된 파일: " + selectedFile.getAbsolutePath(), "파일 선택", JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;
                case "Exit":
                    System.exit(0);
                    break;
            }
        } else if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            String buttonText = button.getText();
            System.out.println(buttonText + "를 클릭했네요");

            switch (buttonText) {
                case "Calculation":
                    try {
                        double num1 = Double.parseDouble(jTextLeft1.getText());
                        double num2 = Double.parseDouble(jTextLeft2.getText());
                        double result = num1 + num2;
                        jLResult.setText(String.format("%.2f", result));
                    } catch (NumberFormatException ex) {
                        jLResult.setText("유효한 숫자를 입력하세요");
                    }
                    break;
                case "계산":
                    try {
                        double r = Double.parseDouble(radius.getText());
                        double circleArea = Math.PI * r * r;
                        area.setText(String.format("%.2f", circleArea));
                        textArea.append(String.format("반지름: %.2f, 넓이: %.2f\n", r, circleArea));
                    } catch (NumberFormatException ex) {
                        textArea.append("유효한 반지름을 입력하세요\n");
                    }
                    break;
                case "리셋":
                    textArea.setForeground(Color.BLACK);
                    textArea.setText("");
                    radius.setText("");
                    area.setText("");
                    break;
                case "로그인":
                    String enteredId = idField.getText();
                    String enteredPassword = pwField.getText();
                    if (enteredId.equals(CORRECT_ID) && enteredPassword.equals(CORRECT_PASSWORD)) {
                        JOptionPane.showMessageDialog(this, "로그인 성공", "알림", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "로그인 실패", "알림", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case "파일 선택":
                    JFileChooser fileChooser = new JFileChooser();
                    int resultFileChooser = fileChooser.showOpenDialog(this);
                    if (resultFileChooser == JFileChooser.APPROVE_OPTION) {
                        File selectedFile = fileChooser.getSelectedFile();
                        JOptionPane.showMessageDialog(this, "선택된 파일: " + selectedFile.getAbsolutePath(), "파일 선택", JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ComponentWindow());
    }
}
