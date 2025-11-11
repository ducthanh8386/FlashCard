package View;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Control.CardControl;
import Model.FlashCard;


public class FlashCardAppView extends JFrame {
    private final CardControl controller;
    private void initializeComponents(){
        // nhaapk lieu
        englishInputField = new JTextField(20);
        vietnameseInputField = new JTextField(20);
        addButton = new JButton("Add");
        displayArea = new JTextArea(10,40);
        displayArea.setEditable(false);
        // Luyen tap
        cardQuestionLabel = new JLabel("Bat dau luyen tap", SwingConstants.CENTER);
        cardQuestionLabel.setFont(new Font("Serif", Font.BOLD, 24));
        cardAnswerLabel = new JLabel("Nhấn 'Hiện Nghĩa'!", SwingConstants.CENTER);
        cardAnswerLabel.setForeground(Color.BLUE);
        cardAnswerLabel.setVisible(false); // Ẩn nghĩa lúc đầu
        cardAnswerLabel.setFont(new Font("Serif", Font.PLAIN, 18));
        nextCardButton = new JButton("Thẻ Tiếp Theo");
        showAnswerButton = new JButton("Hiện Nghĩa");

    }
    private void setupLayout(){
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Nhập Thẻ Mới"));

        inputPanel.add(new JLabel("Tiếng Anh:"));
        inputPanel.add(englishInputField);
        inputPanel.add(new JLabel("Tiếng Việt:"));
        inputPanel.add(vietnameseInputField);
        inputPanel.add(addButton);
        inputPanel.add(new JLabel("")); // Căn chỉnh
        add(inputPanel, BorderLayout.NORTH);

        // --- 2. Panel Hiển thị danh sách (WEST) ---
        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Danh Sách Thẻ"));
        add(scrollPane, BorderLayout.WEST);

        // --- 3. Panel Luyện tập (CENTER) ---
        JPanel practicePanel = new JPanel(new BorderLayout(10, 10));
        practicePanel.setBorder(BorderFactory.createTitledBorder("Luyện Tập Flash Card"));

        // Panel hiển thị Thẻ
        JPanel cardDisplayPanel = new JPanel(new GridLayout(2, 1));
        cardDisplayPanel.add(cardQuestionLabel);
        cardDisplayPanel.add(cardAnswerLabel);
        practicePanel.add(cardDisplayPanel, BorderLayout.CENTER);

        // Panel Nút bấm
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.add(showAnswerButton);
        buttonPanel.add(nextCardButton);
        practicePanel.add(buttonPanel, BorderLayout.SOUTH);

        add(practicePanel, BorderLayout.CENTER);

    }
    private void updateCardListDisPlay(){
        displayArea.setText(controller.getAllCardsInfo());
    }
    public void resetPracticeCard(){FlashCard card = controller.getNextRandomCard();
        if (card != null) {
            cardQuestionLabel.setText(card.getEnglishWord());
            cardQuestionLabel.setToolTipText("Nghĩa: " + card.getVietnameseMeaning()); // Thêm tooltip
            cardAnswerLabel.setText(card.getVietnameseMeaning());
            cardAnswerLabel.setVisible(false); // Ẩn nghĩa
        } else {
            cardQuestionLabel.setText("Chưa có thẻ nào. Vui lòng thêm thẻ!");
            cardAnswerLabel.setText("");
        }}

    // Thành phần cho phần Nhập liệu
    private JTextField englishInputField;
    private JTextField vietnameseInputField;
    private JTextArea displayArea;
    private JButton addButton;

    // Thành phần cho phần Luyện tập
    private JLabel cardQuestionLabel; // Hiển thị từ (câu hỏi)
    private JLabel cardAnswerLabel;   // Hiển thị nghĩa (câu trả lời)
    private JButton nextCardButton;
    private JButton showAnswerButton;


    public FlashCardAppView(CardControl controller){
        this.controller = controller;
        setTitle("Flash Card App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,800);
        setLayout(new BorderLayout(10,10));
        setVisible(true);
        initializeComponents();
        setupLayout();
        updateCardListDisPlay();
        resetPracticeCard();

    }
    public String getEnglishInput() { return englishInputField.getText(); }
    public String getVietnameseInput() { return vietnameseInputField.getText(); }
    public void clearInputFields() { englishInputField.setText(""); vietnameseInputField.setText(""); }
    public JButton getAddButton() { return addButton; }
    public JButton getNextCardButton() { return nextCardButton; }
    public JButton getShowAnswerButton() { return showAnswerButton; }
    public JLabel getCardAnswerLabel() { return cardAnswerLabel; }

    public void showMessage(String message, String title, int messageType) {
        JOptionPane.showMessageDialog(this, message, title, messageType);
    }
    public void updateCardListDisplay(){
        displayArea.setText(controller.getAllCardsInfo());
    }



}
