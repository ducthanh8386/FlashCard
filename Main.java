import Model.FlashCardManager;
import View.FlashCardAppView;
import Model.FlashCard;
import Control.CardControl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class Main {

    public static void main(String[] args) {
        // 1. Khởi tạo Model
        FlashCardManager model = new FlashCardManager();

        // 2. Khởi tạo Controller và truyền Model vào
        CardControl controller = new CardControl(model);

        // 3. Khởi tạo View và truyền Controller vào
        // Đảm bảo Swing chạy trên EDT
        SwingUtilities.invokeLater(() -> {
            FlashCardAppView view = new FlashCardAppView(controller);

            //  Thiết lập Event Listeners (Kết nối View và Controller)

            // --- Xử lý sự kiện Thêm thẻ ---
            view.getAddButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String english = view.getEnglishInput();
                    String vietnamese = view.getVietnameseInput();

                    if (controller.addCard(english, vietnamese)) {
                        view.clearInputFields();
                        view.updateCardListDisplay(); // Cập nhật danh sách thẻ
                    } else {
                        view.showMessage("Vui lòng nhập đầy đủ cả Tiếng Anh và Tiếng Việt!",
                                "Lỗi Nhập liệu", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

            // --- Xử lý sự kiện Hiện nghĩa ---
            view.getShowAnswerButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    view.getCardAnswerLabel().setVisible(true);
                }
            });

            // --- Xử lý sự kiện Thẻ tiếp theo ---
            view.getNextCardButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    view.resetPracticeCard();
                }
            });
        });
    }
}