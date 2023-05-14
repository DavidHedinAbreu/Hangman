public class Letter extends Piece {
    // Constructor.
    public Letter(Face face) {
        super(face, "../images/A.gif");
    }

    @Override
    public String getIcon() {
        String url = null;
        switch (super.getFace()) {
            case A:
                url = "../images/A.gif";
                break;
            case B:
                url = "../images/B.gif";
                break;
            case BLANK:
                url = "../images/BLANK.gif";
                break;
            case C:
                url = "../images/C.gif";
                break;
            case D:
                url = "../images/D.gif";
                break;
            case E:
                url = "../images/E.gif";
                break;
            case EMPTY:
                url = "../images/EMPTY.gif";
                break;
            case F:
                url = "../images/F.gif";
                break;
            case G:
                url = "../images/G.gif";
                break;
            case H:
                url = "../images/H.gif";
                break;
            case I:
                url = "../images/I.gif";
                break;
            case J:
                url = "../images/J.gif";
                break;
            case K:
                url = "../images/K.gif";
                break;
            case L:
                url = "../images/L.gif";
                break;
            case M:
                url = "../images/M.gif";
                break;
            case N:
                url = "../images/N.gif";
                break;
            case O:
                url = "../images/O.gif";
                break;
            case P:
                url = "../images/P.gif";
                break;
            case Q:
                url = "../images/Q.gif";
                break;
            case R:
                url = "../images/R.gif";
                break;
            case S:
                url = "../images/S.gif";
                break;
            case T:
                url = "../images/T.gif";
                break;
            case U:
                url = "../images/U.gif";
                break;
            case V:
                url = "../images/V.gif";
                break;
            case W:
                url = "../images/W.gif";
                break;
            case X:
                url = "../images/X.gif";
                break;
            case Y:
                url = "../images/Y.gif";
                break;
            case Z:
                url = "../images/Z.gif";
                break;
            default:
                url = "../images/EMPTY.gif";
        }
        return url;
    }
}
