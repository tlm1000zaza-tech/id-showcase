public enum Type {

        CLUB("C"),
        DIAMOND("D"),
        HEART("H"),
        SPADE("S");

        private String symbol;

        Type(String symbol) {
            this.symbol = symbol;
        }

        public String getSymbol() {
            return symbol;
        }

    }