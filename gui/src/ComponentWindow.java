import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComponentWindow extends JFrame implements ActionListener {
    private JTextArea textArea;
    private JTextField jTextLeft1, jTextLeft2;
    private JLabel jLResult;
    private JTextField radius, area;

    public ComponentWindow() {
        setTitle("C084007 김동년");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        JPanel mainPanel = new JPanel(new BorderLayout());
        JButton northButton = new JButton("NORTH");
        JButton southButton = new JButton("SOUTH");
        JButton eastButton = new JButton("EAST");
        JButton westButton = new JButton("WEST");

        northButton.addActionListener(this);
        southButton.addActionListener(this);
        eastButton.addActionListener(this);
        westButton.addActionListener(this);

        Container contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(2, 2, 5, 5));

        mainPanel.add(northButton, BorderLayout.NORTH);
        mainPanel.add(southButton, BorderLayout.SOUTH);
        mainPanel.add(eastButton, BorderLayout.EAST);
        mainPanel.add(westButton, BorderLayout.WEST);
        mainPanel.add(contentPane, BorderLayout.CENTER);
        setContentPane(mainPanel);

        JPanel p1 = new JPanel();
        p1.setLayout(new FlowLayout());
        p1.setBackground(Color.GREEN);

        jTextLeft1 = new JTextField(10);
        JLabel jLPlus = new JLabel("+");
        jTextLeft2 = new JTextField(10);
        JLabel jLEqual = new JLabel("=");
        jLResult = new JLabel("결과는 여기에...");
        JButton jBResult = new JButton("Calculation");
        jBResult.addActionListener(this);

        p1.add(jTextLeft1);
        p1.add(jLPlus);
        p1.add(jTextLeft2);
        p1.add(jLEqual);
        p1.add(jLResult);
        p1.add(jBResult);
        contentPane.add(p1);

        JPanel section2Panel = new JPanel(new GridLayout(2, 5, 5, 5));
        section2Panel.setBackground(Color.YELLOW);
        for (int i = 0; i <= 9; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.setOpaque(true);
            button.addActionListener(this);
            section2Panel.add(button);
        }
        contentPane.add(section2Panel);

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

        JPanel section4Panel = new JPanel(new BorderLayout());
        section4Panel.setBackground(Color.RED);

        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.Y_AXIS));
        containerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        containerPanel.setBackground(Color.RED);

        JPanel loginPanel = new JPanel(new GridLayout(3, 2, 5, 5));

        JLabel idLabel = new JLabel("아이디");
        JTextField idField = new JTextField();
        idField.setPreferredSize(new Dimension(200, 30));

        JLabel pwLabel = new JLabel("비밀번호");
        JTextField pwField = new JTextField();
        pwField.setPreferredSize(new Dimension(200, 30));

        JButton loginButton = new JButton("로그인");
        loginButton.setPreferredSize(new Dimension(200, 30));
        loginButton.addActionListener(this);

        loginPanel.add(idLabel);
        loginPanel.add(idField);
        loginPanel.add(pwLabel);
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

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
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

        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ComponentWindow());
    }
}
