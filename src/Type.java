public enum Type {
    CLUB,
    DIAMOND,
    HEART,
    SPADE;

    public String getSuitSymbol() {

        switch(this) {

            case HEART: return "♥";
            case DIAMOND: return "♦";
            case CLUB: return "♣";
            case SPADE: return "♠";

        }

        return "?";
    }

}