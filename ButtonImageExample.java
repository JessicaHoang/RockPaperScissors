import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.*;
import javax.imageio.ImageIO;

public class ButtonImageExample
{
    private JButton rockButton;
    private ImageIcon rockImage;
    private JButton paperButton;
    private ImageIcon paperImage;    
    private JButton scissorsButton;
    private ImageIcon scissorsImage;
    private int newHeight =50;
    private int newWidth = 50;

    private void displayGUI()
    {
        JFrame frame = new JFrame("Button Image Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel();
        try
        {
            rockImage = new ImageIcon(ImageIO.read(
                    new URL("https://i.imgur.com/7MIVSeg.jpg")));
            paperImage = new ImageIcon(ImageIO.read(
                    new URL("https://i.imgur.com/u3joh0q.jpg")));
            scissorsImage = new ImageIcon(ImageIO.read(
                    new URL("https://i.imgur.com/F4BHro1.png")));
        }
        catch(MalformedURLException mue)
        {
            mue.printStackTrace();
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }       
        Image image = rockImage.getImage(); // transform it 
        Image newimg = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        rockImage = new ImageIcon(newimg);
        
        image = paperImage.getImage(); // transform it 
        newimg = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        paperImage = new ImageIcon(newimg);
        
        image = scissorsImage.getImage(); // transform it 
        newimg = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        scissorsImage = new ImageIcon(newimg);
        
        rockButton = new JButton("Rock!");
        rockButton.setIcon(rockImage);
        rockButton.setHorizontalTextPosition(AbstractButton.CENTER);
        rockButton.setVerticalTextPosition(AbstractButton.BOTTOM);
        
        paperButton = new JButton("Paper!");
        paperButton.setIcon(paperImage);
        paperButton.setHorizontalTextPosition(AbstractButton.CENTER);
        paperButton.setVerticalTextPosition(AbstractButton.BOTTOM);

        scissorsButton = new JButton("Scissors!");
        scissorsButton.setIcon(scissorsImage);
        scissorsButton.setHorizontalTextPosition(AbstractButton.CENTER);
        scissorsButton.setVerticalTextPosition(AbstractButton.BOTTOM);

		JPanel southBtnPanel = new JPanel(new GridLayout(1, 3, 1, 1));
		southBtnPanel.add(rockButton);
		southBtnPanel.add(paperButton);
		southBtnPanel.add(scissorsButton);
		
		contentPane.add(southBtnPanel,BorderLayout.SOUTH);
        //contentPane.add(rockButton);
        //contentPane.add(paperButton);
        //contentPane.add(scissorsButton);

        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new ButtonImageExample().displayGUI();
            }
        });
    }
}
