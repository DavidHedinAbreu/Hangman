public class HangedMan extends Piece {
    // Constructor.
    public HangedMan(Face face) {
        super(face, "../images/1.gif");
    }

    @Override
    public String getIcon() {
        String url = null;
        switch (super.getFace()) {
            case ONE:
                url = "../images/1.gif";
                break;
            case TWO:
                url = "../images/2.gif";
                break;
            case THREE:
                url = "../images/3.gif";
                break;
            case FOUR:
                url = "../images/4.gif";
                break;
            case FIVE:
                url = "../images/5.gif";
                break;
            case SIX:
                url = "../images/6.gif";
                break;
            case SEVEN:
                url = "../images/7.gif";
                break;
            case WINNER:
                url = "../images/WINNER.gif";
                break;
        }
        return url;
    }
}
