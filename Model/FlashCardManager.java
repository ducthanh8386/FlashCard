package Model;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class FlashCardManager {
    private List<FlashCard> cards;
    public FlashCardManager() {
        this.cards = new ArrayList<>();
        addCards("Hello","Xin chao");
        addCards("Computer","May Tinh");
        addCards("Mouse","Chuot");


    }
    public void addCards(String englishWord, String vietnameseMeaning) {
        FlashCard newCard = new FlashCard(englishWord, vietnameseMeaning);
        cards.add(newCard);
    }
    public void removeCards(String englishWord, String vietnameseMeaning) {
        FlashCard removedCard = new FlashCard(englishWord, vietnameseMeaning);
        cards.remove(removedCard);
    }
    public FlashCard getRadomCards(){
        if(cards.isEmpty()){
            return null;
        }
        int randomIndex = (int) (Math.random()*cards.size());
        return cards.get(randomIndex);
    }
    public List<FlashCard> getAllCards(){
        return cards;
    }
    public int getCardsCount(){
        return cards.size();
    }
    // Chọn ngẫu Nhiên số thẻ
    public FlashCard getRandomCards(){
        if(cards.isEmpty()){
            return null;
        }
        int randomIndex = (int) (Math.random())*cards.size();
        return cards.get(randomIndex);
    }


}
