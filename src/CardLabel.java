import javax.swing.*;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CardLabel extends JLabel {

    private JPanel parent;
    private Card card;

    private int originalX;
    private int originalY;
    private int originalW;
    private int originalH;

    private boolean hovered = false;

    private boolean selected = false;


    public CardLabel(Card card, JPanel parent, int x, int y, int width, int height) {

        this.card = card;
        this.parent = parent;

        this.originalX = x;
        this.originalY = y;
        this.originalW = width;
        this.originalH = height;

        ImageIcon icon = new ImageIcon(card.getImagePath());

        Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);

        setIcon(new ImageIcon(img));

        setBounds(x, y, width, height);

        setOpaque(false);


        // ⭐ เพิ่มตรงนี้
        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                hoverOn();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hoverOff();
            }

            @Override
            public void mouseClicked(MouseEvent e) {

                toggleSelect();

                if(parent instanceof GamePanel) {

                    GamePanel panel = (GamePanel) parent;

                    panel.cardClicked(card);

                }

            }

        });

    }

    private void hoverOn() {

        if(hovered) return;

        hovered = true;

        originalX = getX();
        originalY = getY();
        originalW = getWidth();
        originalH = getHeight();

        int newW = (int)(originalW * 1.2);
        int newH = (int)(originalH * 1.2);

        int newX = originalX - (newW - originalW) / 2;
        int newY = originalY - 40;

        ImageIcon icon = new ImageIcon(card.getImagePath());

        Image img = icon.getImage().getScaledInstance(newW, newH, Image.SCALE_SMOOTH);

        setIcon(new ImageIcon(img));

        setBounds(newX, newY, newW, newH);

    }

    private void hoverOff() {

        hovered = false;

        ImageIcon icon = new ImageIcon(card.getImagePath());

        Image img = icon.getImage().getScaledInstance(originalW, originalH, Image.SCALE_SMOOTH);

        setIcon(new ImageIcon(img));

        setBounds(originalX, originalY, originalW, originalH);

    }



    private void toggleSelect() {

        if(selected) {

            setLocation(getX(), getY() + 20);

            selected = false;

        }
        else {

            setLocation(getX(), getY() - 20);

            selected = true;

        }

    }


    public Card getCard() {

        return card;

    }

}