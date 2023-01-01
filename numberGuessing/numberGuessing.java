
package numberGuessing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class numberGuessing extends JFrame {
    JTextField textfield1, textfield2;
    JLabel jLabel;
    JLabel text3;
    GuessButton gesButton;
    RetryButton retButton;
    static int random=(int) (Math.random()*100);
    int count=0;
    public numberGuessing()
    {

        Container c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.WHITE);
        JLabel labelpic = new JLabel("");
        JLabel Heading=new JLabel("NUMBER GUESSING GAME");
        Heading.setForeground(Color.black);
        Heading.setFont(new Font("Courier",Font.BOLD,28));
        Heading.setSize(370,35);
        Heading.setLocation(60,35);
        JLabel intro=new JLabel("You have to Guess number between 1-100");
        intro.setFont(new Font("tunga",Font.PLAIN,15));
        intro.setSize(370,20);
        intro.setLocation(90,80);
        JLabel welcome=new JLabel("Welcome to Game");
        welcome.setFont(new Font("tunga",Font.BOLD,24));
        welcome.setSize(250,20);
        welcome.setLocation(130,130);
        welcome.setForeground(Color.RED);
        textfield1=new JTextField(12);
        textfield1.setSize(70,30);
        textfield1.setLocation(270,165);
        jLabel=new JLabel(" ");
        jLabel.setFont(new Font("tunga",Font. ITALIC,16));
        jLabel.setSize(370,20);
        jLabel.setLocation(110,200);
        JLabel text2=new JLabel("Enter number to Guess: ");
        text2.setFont(new Font("tunga",Font.BOLD,13));
        text2.setSize(350,20);
        text2.setLocation(110,170);
        textfield2=new JTextField(10);
        textfield2.setSize(50,30);
        textfield2.setLocation(260,305);
        JLabel text1=new JLabel("Number of trials :- ");
        text1.setFont(new Font("tunga",Font.BOLD,16));
        text1.setSize(270,20);
        text1.setLocation(120,305);
        text3=new JLabel(" ");
        text3.setFont(new Font("tunga",Font.BOLD,36));
        text3.setSize(410,60);
        text3.setLocation(60,375);
        JButton button1 =new JButton("Guess");
        button1.setSize(80,30);
        button1.setLocation(120,250);
        gesButton =new GuessButton();
        button1.addActionListener(gesButton);
        JButton button2=new JButton("Retry");
        button2.setSize(80,30);
        button2.setLocation(260,250);
        retButton =new RetryButton();
        button2.addActionListener(retButton);
        c.add(jLabel);
        c.add(labelpic);
        c.add(Heading);
        c.add(intro);
        c.add(text2);
        c.add(textfield1);
        c.add(textfield2);
        c.add(button1);
        c.add(button2);
        c.add(text1);
        c.add(text3);
        c.add(welcome);
        textfield2.setEditable(false);
        setTitle("GUESS THE NUMBER");
        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private class GuessButton implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            int a = Integer.parseInt(textfield1.getText());
            count=count+1;
            if(count>7)
            {
                jLabel.setText("You Lose!!!, Try Again");
                jLabel.setForeground(Color.RED);
                count=0;
            }
            else {
                if(a<random)
                {
                    jLabel.setText("Wrong Guess!!! because "+a+" is Low, Try Again");
                    jLabel.setForeground(Color.blue);
                }
                else if(a>random)
                {
                    jLabel.setText("Wrong Guess!!! because "+a+" is High, Try Again");
                    jLabel.setForeground(Color.blue);
                }
                else
                {
                    jLabel.setText("Amazing.. You Guessed it Correct, You Win!!!!");
                    jLabel.setForeground(Color.green);
                    text3.setText("Thank You for playing...");
                    text3.setForeground(Color.PINK);

                }
                textfield1.requestFocus();
                textfield1.selectAll();

                textfield2.setText(count+"");
            }
        }
    }

    private class RetryButton implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            random=(int) (Math.random()*100);
            textfield1.setText("");
            textfield2.setText("");
            jLabel.setText("Try Again and Guess the Number.");
            jLabel.setForeground(Color.black);
            textfield2.setText("");
            count=0;
            textfield1.setEditable(true);
            textfield1.requestFocus();
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new numberGuessing();
    }


}