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


        // โหลดรูปจาก path ของ card
        ImageIcon icon = new ImageIcon(card.getImagePath());

        // scale รูป
        Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);

        // set รูป
        setIcon(new ImageIcon(img));


        // set ตำแหน่ง
        setBounds(x, y, width, height);


        // สำคัญ
        setOpaque(false);

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