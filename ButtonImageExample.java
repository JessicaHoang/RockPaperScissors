import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		rockButton.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				System.out.println("You chose rock!");
			}
		});
        
        paperButton = new JButton("Paper!");
        paperButton.setIcon(paperImage);
        paperButton.setHorizontalTextPosition(AbstractButton.CENTER);
        paperButton.setVerticalTextPosition(AbstractButton.BOTTOM);
		paperButton.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				System.out.println("You chose paper!");
			}
		});

        scissorsButton = new JButton("Scissors!");
        scissorsButton.setIcon(scissorsImage);
        scissorsButton.setHorizontalTextPosition(AbstractButton.CENTER);
        scissorsButton.setVerticalTextPosition(AbstractButton.BOTTOM);
		scissorsButton.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				System.out.println("You chose scissors!");
			}
		});

		JPanel southBtnPanel = new JPanel(new GridLayout(1, 3, 1, 1));
		southBtnPanel.add(rockButton);
		southBtnPanel.add(paperButton);
		southBtnPanel.add(scissorsButton);
		
		contentPane.add(southBtnPanel,BorderLayout.SOUTH);

        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
    
	private static void introductionPanel()
	{ // give the instruction to the game
		String text="Player gets their choice between Rock, Paper, and Scissors.\nThe player will compete against the computers random choice.\n"
				+ "Rock beats Scissors. Paper beats Rock. Scissors beats paper.\n                      "
				+ "           Good Luck! Best 2/3 WINS!";
		JOptionPane.showMessageDialog(null,text, "How to play", 0, new ImageIcon(System.getProperty("user.dir")+"/image/5.gif"));
	}

    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new ButtonImageExample().displayGUI();
                introductionPanel();
            }
        });
    }
}
