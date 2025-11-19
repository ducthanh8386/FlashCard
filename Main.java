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
        FlashCardManager model = new FlashCardManager();
        CardControl controller = new CardControl(model);
        SwingUtilities.invokeLater(() -> {
            FlashCardAppView view = new FlashCardAppView(controller);

     // them, the moi
            view.getAddButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String english = view.getEnglishInput();
                    String vietnamese = view.getVietnameseInput();

                    if (controller.addCard(english, vietnamese)) {
                        view.clearInputFields();
                        view.updateCardListDisplay(); 
                    } else {
                        view.showMessage("Vui lòng nhập đầy đủ cả Tiếng Anh và Tiếng Việt!",
                                "Lỗi Nhập liệu", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

    
            view.getShowAnswerButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    view.getCardAnswerLabel().setVisible(true);
                }
            });

            // The tiep theo
            view.getNextCardButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    view.resetPracticeCard();
                }
            });
        });
    }
}
