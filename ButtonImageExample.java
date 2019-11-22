  
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.*;
import javax.imageio.ImageIO;

public class ButtonImageExample implements ActionListener
{
    private JButton rockButton;
    private ImageIcon rockImage;
    private JButton paperButton;
    private ImageIcon paperImage;    
    private JButton scissorsButton;
    private ImageIcon scissorsImage;
    private int win;
    private int loss;

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
				//rock = 0, paper = 1, scissors = 2
				//a = player, b = computer
				int a = 0;
				int b = getCompRand(0,2);
				if(a==b) {
					//tie
				}
				else if((a-b)%3 == 1) 
				{
					win++;
					System.out.println("Wins: "+win);
					//once the wins rack up to 2/3, it needs to prompt end game.
				}
				else {
					loss++;
					System.out.println("Loss "+loss);
				}
				
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
				System.out.println("You chose rock!");
				//rock = 0, paper = 1, scissors = 2
				//a = player, b = computer
				int a = 1;
				int b = getCompRand(0,2);
				if(a==b) {
					//tie
				}
				else if((a-b)%3 == 1) 
				{
					win++;
					System.out.println("Wins: "+win);
					//once the wins rack up to 2/3, it needs to prompt end game.
				}
				else {
					loss++;
					System.out.println("Loss "+loss);
				}
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
				System.out.println("You chose rock!");
				//rock = 0, paper = 1, scissors = 2
				//a = player, b = computer
				int a = 2;
				int b = getCompRand(0,2);
				if(a==b) {
					//tie
				}
				else if((a-b)%3 == 1) 
				{
					win++;
					System.out.println("Wins: "+win);
					//once the wins rack up to 2/3, it needs to prompt end game.
				}
				else {
					loss++;
					System.out.println("Loss "+loss);
				}
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
    
    public static int getCompRand(int min, int max) {
    	int x = (int) (Math.random()*((max-min)+1)+min);
    	return x;
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
}
