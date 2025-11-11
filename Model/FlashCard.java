package Model;

public class FlashCard {
    private String englishWord;
    private String vietnameseMeaning;
    public FlashCard(String englishWord, String vietnameseMeaning) {
        this.englishWord = englishWord;
        this.vietnameseMeaning = vietnameseMeaning;

    }
    // lay tu tieng viet , tieng anh

    public String getEnglishWord() {
        return englishWord;
    }

    public String getVietnameseMeaning() {
        return vietnameseMeaning;
    }

    public void setEnglishWord(String englishWord) {
        this.englishWord = englishWord;
    }

    public void setVietnameseMeaning(String vietnameseMeaning) {
        this.vietnameseMeaning = vietnameseMeaning;
    }

    @Override
    public String toString() {
        return  "Tieng Anh: " +" " +  englishWord +
                "\nTieng Viet: " +" "+ vietnameseMeaning +
                "\n " ;
    }
}
