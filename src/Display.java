import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Display extends Canvas implements KeyListener {
    public static Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    public static int frameWidth = (int)size.getWidth();
    public static int screenWidth = (int)size.getWidth();
    public static int frameHeight = (int)size.getHeight();
    public static int screenHeight = (int)size.getHeight();
    public static JFrame mainframe = new JFrame("mainframe");
    public static JLabel theTextLabel,ClickAway;

    public void paint(Graphics g) {
        //setBackground(Color.BLACK);
        g.setColor(Color.BLACK);
        g.drawString("Version 1.0",20,20);
        g.setColor(Color.DARK_GRAY);
        g.drawOval(frameWidth /4,frameHeight/4, frameWidth /2,frameHeight/2);
        g.fillOval(frameWidth /4,frameHeight/4, frameWidth /2,frameHeight/2);



        /*ClickAway = new JLabel("Click Away!", JLabel.CENTER);
        ClickAway.setVerticalAlignment(JLabel.CENTER);
        ClickAway.setFont(new Font("Times New Roman",Font.PLAIN,frameHeight/10));
        ClickAway.setPreferredSize(new Dimension(frameWidth /2,frameHeight/2));
        ClickAway.setForeground(Color.WHITE);
        ClickAway.setVisible(true);*/

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed (KeyEvent e){
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_F1 -> {
                if (frameWidth == screenWidth && frameHeight == screenHeight) {
                    frameWidth = screenWidth / 2;
                    frameHeight = screenHeight / 2;
                    mainframe.setSize(frameWidth, frameHeight);
                    frameWidth = getWidth();
                    frameHeight = getHeight();
                } else {
                    frameWidth = screenWidth;
                    frameHeight = screenHeight;
                    mainframe.setSize(frameWidth, frameHeight);
                }
            }
            case KeyEvent.VK_UP -> {
                mainframe.setLayout(new BorderLayout());
                theTextLabel.setText ("UP ARROW Key Pressed");

            }
            case KeyEvent.VK_LEFT -> {
                mainframe.setLayout(new BorderLayout());
                theTextLabel.setText ("LEFT ARROW Key Pressed");

            }
            case KeyEvent.VK_DOWN -> {
                mainframe.setLayout(new BorderLayout());
                theTextLabel.setText ("DOWN ARROW Key Pressed");

            }
            case KeyEvent.VK_RIGHT -> {
                mainframe.setLayout(new BorderLayout());
                theTextLabel.setText ("RIGHT ARROW Key Pressed");

            }
            case KeyEvent.VK_F12 -> System.exit(0);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        theTextLabel.setText ("");
    }

    public static void initializeMainframe(){

        Display D = new Display();

        theTextLabel = new JLabel();
        theTextLabel.setHorizontalAlignment(0);
        theTextLabel.setBackground(new Color (0,0,0,0));
        int theTextLabelWidth = frameWidth/8;
        int theTextLabelHeight = frameWidth/8;

        theTextLabel.setBounds (frameWidth/2-theTextLabelWidth/2,frameHeight/2-theTextLabelHeight/2, theTextLabelWidth, theTextLabelHeight);

        //mainframe.add(ClickAway);
      /*  mainframe.add(new JLabel(new ImageIcon("C:\\Users\\Owner\\IdeaProjects\\Code01\\src\\ClickAway.gif")));
        JLabel label = new JLabel(new ImageIcon("C:\\Users\\Owner\\IdeaProjects\\Code01\\src\\ClickAway.gif"));
        label.setPreferredSize(new Dimension(100,100));
        mainframe.add(label);*/

        mainframe.setSize(screenWidth, screenHeight);
        mainframe.getContentPane().setBackground(Color.WHITE);
        //mainframe.setLayout(null);
        mainframe.setTitle("This is, in fact, the main frame");
        mainframe.addKeyListener(D);
        mainframe.setUndecorated(true);
        mainframe.add(theTextLabel);
        mainframe.add(D);
        mainframe.setVisible(true);
        mainframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void ConfirmWindowSize(){
        System.out.println("Process initialized");
        System.out.println(size);
    }

    public static void main(String[] args) {
        ConfirmWindowSize();
        initializeMainframe();
    }
}