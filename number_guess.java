import java.awt.*;
import java.awt.event.*;
import java.util.*;

class Myframe implements ActionListener {
  int num;
  int tryed = 0;
  String play = "yes";
  Image img;

  Frame f;
  TextField tf, tf1, tf2;
  Button b;
  Label l, l1, l2, l3, l4;

  Myframe() {
    f = new Frame();
    l = new Label("this is the guessing no appication ");
    b = new Button("generte a no ");
    l1 = new Label();
    l2 = new Label();
    tf = new TextField();
    tf1 = new TextField();
    tf2 = new TextField();
    l3 = new Label();
    l4 = new Label();

    Toolkit t = f.getToolkit();
    Dimension ScreenSize = t.getScreenSize();
    int width = ScreenSize.width * 4 / 10;
    int height = ScreenSize.height * 6 / 10;
    f.setBounds(width / 3, height / 4, width, height);

    l.setBounds(30, 50, 300, 40);
    b.setBounds(350, 40, 100, 40);
    l1.setBounds(30, 90, 200, 40);
    l2.setBounds(30, 140, 300, 40);
    tf.setBounds(370, 140, 70, 40);
    tf1.setBounds(50, 190, 400, 40);

    l3.setBounds(30, 240, 250, 40);
    tf2.setBounds(350, 240, 40, 40);
    l4.setBounds(30, 290, 250, 40);

    f.add(l);
    f.add(b);
    f.add(l1);
    f.add(l2);
    f.add(tf);
    f.add(tf1);
    f.add(l3);
    f.add(tf2);
    f.add(l4);

    b.addActionListener(this);
    tf.addActionListener(this);
    tf2.addActionListener(this);
    f.setBackground(Color.lightGray);
    f.setLayout(null);
    f.setVisible(true);
    f.setTitle("This is the no guesssing application");
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == b) {
      Random r = new Random();
      num = r.nextInt(100);
      l1.setText("congratulations no generated  ");
      l2.setText("enter no here betwen 1 to 100 and press ok or enter");
    } else if (e.getSource() == tf) {
      while (play.equals("yes")) {
        int guess = -1;
        while (guess != num) {
          guess = Integer.parseInt(tf.getText());
          ++tryed;
          if (guess == num) {
            tf1.setText("very nice!  u have guess a corect no in " + tryed + "try");
            l3.setText("do u want to play the game again yes or no ");
            play = tf2.getText();
          } else if (guess > num) {
            tf1.setText("u have guessed a high no select any low no  ");
            tf.setText("");
          } else {
            tf1.setText("u have guessed a low no select any high no  ");
            tf.setText("");
          }
        }
      }
    } else if (e.getSource() == tf2) {
      play = tf2.getText();
      if (play.equals("no")) {

        l4.setText("thanku for playing the game ");
      } else {
        tf1.setText("");
        tf.setText("");
        tf2.setText("");
        l4.setText("generate the no again ");
      }
    }
  }

  public static void main(String args[]) {
    new Myframe();
    Scanner s = new Scanner(System.in);
  }
}
