// importing awt libraries
import java.awt.*;
import java.awt.event.*;
// class which inherits Frame class and implements KeyListener interface
public class KeyListenerExample extends Frame implements KeyListener {
    // creating object of Label class   and TextArea class
    Label l;
    TextArea area;
    // class constructor
    KeyListenerExample() {

        l = new Label();// creating the label
        l.setBounds (20, 50, 250, 20);// setting the location of the label in frame
        area = new TextArea();// creating the text area
        area.setBounds (20, 80, 300, 300);// setting the location of text area
        area.addKeyListener(this);// adding the KeyListener to the text area
        add(l);// adding the label and text area to the frame
        add(area);// setting the size, layout and visibility of frame
        setSize (400, 400);
        setLayout (null);
        setVisible (true);
    }
    // overriding the keyPressed() method of KeyListener interface where we set the text of the label when key is pressed
    public void keyPressed (KeyEvent e){
        int keyCode = e.getKeyCode();
        switch (keyCode){
            case KeyEvent.VK_UP: l.setText ("UP ARROW Key Pressed"); break;
            case KeyEvent.VK_LEFT: l.setText ("LEFT ARROW Key Pressed"); break;
            case KeyEvent.VK_DOWN: l.setText ("DOWN ARROW Key Pressed"); break;
            case KeyEvent.VK_RIGHT: l.setText ("RIGHT ARROW Key Pressed"); break;
            case KeyEvent.VK_F1: l.setText ("F1 Pressed"); break;
            case KeyEvent.VK_F12: System.exit(0);
            default: l.setText ("Key Pressed"); break;
        }


    }
    // overriding the keyReleased() method of KeyListener interface where we set the text of the label when key is released
    public void keyReleased (KeyEvent e) {
        l.setText ("Key Released");
    }
    // overriding the keyTyped() method of KeyListener interface where we set the text of the label when a key is typed
    public void keyTyped (KeyEvent e) {
        l.setText ("Key Typed");
    }
    // main method
    public static void main(String[] args) {
        new KeyListenerExample();
    }
}