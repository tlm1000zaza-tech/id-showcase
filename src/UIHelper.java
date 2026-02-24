import java.awt.*;

public class UIHelper {
    public static void apply(Component comp
            , double SizescaleX , int SizeoffsetX
            , double PosscaleX , int PosoffsetX
            , double SizescaleY , int SizeoffsetY
            , double PosscaleY , int PosoffsetY
            , double anchorX, double anchorY
    ) {
        int parentW;
        int parentH;

        if (comp.getParent() != null) {
            parentW = comp.getParent().getWidth();
            parentH = comp.getParent().getHeight();
            System.out.println("Case 1");
        } else {
            Dimension screen = new Dimension();
            parentW = screen.width;
            parentH = screen.height;
            System.out.println("Case 2");
        }

        int x = (int) (PosscaleX * parentW) + PosoffsetX;
        int y = (int) (PosscaleY * parentH) + PosoffsetY;
        int w = (int) (SizescaleX * parentW) + SizeoffsetX;
        int h = (int) (SizescaleY * parentH) + SizeoffsetY;
        int anchX = (int) (w * anchorX);
        int anchY = (int) (h * anchorY);

        System.out.println(anchorX);
        System.out.println("PX : " + parentH);
        System.out.println("PY : " + parentW);
        System.out.println("X : " + x);
        System.out.println("Y : " + y);
        System.out.println("W : " + w);
        System.out.println("H : " + h);
        comp.setBounds(x-anchX, y-anchY , w ,h);

    };
    public static void apply(Component comp
            , double SizescaleX , int SizeoffsetX
            , double PosscaleX , int PosoffsetX
            , double SizescaleY , int SizeoffsetY
            , double PosscaleY , int PosoffsetY

    ) {
        int parentW;
        int parentH;

        if (comp.getParent() != null) {
            parentW = comp.getParent().getWidth();
            parentH = comp.getParent().getHeight();
            System.out.println("Case 1");
        } else {
            Dimension screen = new Dimension();
            parentW = screen.width;
            parentH = screen.height;
            System.out.println("Case 2");
        }

        int x = (int) (PosscaleX * parentW) + PosoffsetX;
        int y = (int) (PosscaleY * parentH) + PosoffsetY;
        int w = (int) (SizescaleX * parentW) + SizeoffsetX;
        int d = (int) (SizescaleY * parentH) + SizeoffsetY;
        System.out.println("PX : " + parentH);
        System.out.println("PY : " + parentW);
        System.out.println("X : " + x);
        System.out.println("Y : " + y);
        System.out.println("W : " + w);
        System.out.println("H : " + d);
        comp.setBounds(x, y , w ,d);

    };
}