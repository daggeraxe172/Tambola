package Tambola;
/*
Tambola Number Generator:
This is a fun app to generate Random numbers using JAVA GUI to aid in playing TAMBOLA during get-together functions or with your Friends.
Everyone will be able to see the Numbers big and clear on GUI with added DRUM effects.
Cheers !
 */
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

class GUItambola extends JFrame implements ActionListener{
    Container container = getContentPane();

    JButton tambola = new JButton("X");
    ArrayList<Integer> arr = new ArrayList<Integer>(100);
    int i=0;
    GUItambola(){
        addlayout();
        addbounds();
        addcomponentstocontainer();
        addactionevent();
    }

    public void addlayout(){
        setLayout(null);
    }
    public void addbounds(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        tambola.setBounds(0,0,(int)width,(int)height);
        tambola.setFont(new Font("Arial", Font.PLAIN, (int)width/2));
        tambola.setForeground(Color.red);
    }
    public void addcomponentstocontainer(){
        container.add(tambola);
    }
    public void addactionevent(){
        tambola.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == tambola){
            try {
                /*
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
 */
                Clip clip = AudioSystem.getClip();
                // getAudioInputStream() accepts a File or InputStream

                //copy absolute path
                AudioInputStream ais = AudioSystem.getAudioInputStream(new File("F:\\NewA\\Tambola\\src\\Tambola\\drum-roll-sound-effect.wav"));
                clip.open(ais);
                clip.start();
                //clip.loop(Clip.LOOP_CONTINUOUSLY); //to play again and again
            } catch (Exception exp) {
                System.out.println(exp);
            }

            Random random = new Random();
            int num = random.nextInt(90) + 1;
            String number = String.valueOf(num);


            if(!arr.contains(num)){
                tambola.setText(number);
                arr.add(num);

                System.out.print(num+"   ");

                if((++i % 20)==0)
                    System.out.println("\n");
            }
            else{
                tambola.doClick();
            }
        }
    }

}

public class Tambola {
    public static void main(String[] args){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        GUItambola tambola = new GUItambola();
        tambola.setTitle("TAMBOLA");
        tambola.setBounds(0,0,(int)width,(int)height);
        tambola.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        tambola.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                //frame.dispose();
            }
        });
        tambola.setVisible(true);
        tambola.setResizable(true);
    }
}
