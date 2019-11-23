  
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
    private JSplitPane splitPane; //this will allow you to split into different panes

    private void displayGUI()
    {
        JFrame frame = new JFrame("Button Image Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel result = new JLabel();

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
        /*Split panel to buttons on one panel and the scores on the other*/
        
        
        /*Icon images*/
        Image image = rockImage.getImage(); // transform it 
        Image newimg = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        rockImage = new ImageIcon(newimg);
        
        image = paperImage.getImage(); // transform it 
        newimg = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        paperImage = new ImageIcon(newimg);
        
        image = scissorsImage.getImage(); // transform it 
        newimg = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        scissorsImage = new ImageIcon(newimg);
        
        /*Button, Actionlistener, and Actionperformed for Rock*/
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
				System.out.println(a);
				System.out.println(b);
				result.setText("a is 0");
				rpsLogic(a,b);
				
			}
		});
		
		/*Button, Actionlistener, and Actionperformed for Paper*/
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
				int a = 1;
				int b = getCompRand(0,2);
				System.out.println(a);
				System.out.println(b);
				result.setText("a is 1");
				rpsLogic(a,b);
			}
		});

		/*Button, Actionlistener, and Actionperformed for Scissors*/
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
				int a = 2;
				int b = getCompRand(0,2);
				System.out.println(a);
				System.out.println(b);
				result.setText("a is 2");
				rpsLogic(a,b);
			}
		});

		JPanel southBtnPanel = new JPanel(new GridLayout(1, 3, 1, 1));
		southBtnPanel.add(rockButton);
		southBtnPanel.add(paperButton);
		southBtnPanel.add(scissorsButton);
		
		contentPane.add(southBtnPanel,BorderLayout.SOUTH);

		frame.add(result);
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

	/*Main function*/
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
    
    /*randomly generates Computer's choice*/
    public static int getCompRand(int min, int max) {
    	int x = (int) (Math.random()*((max-min)+1)+min);
    	return x;
    }

    /*Rock Paper Scissors logic to determine whether the player wins or loses.*/
    public void rpsLogic(int player, int computer) 
    {
    	if(player==computer) {
			//tie
		}
		else if((player-computer)%3 == 1) 
		{
			win++;
			System.out.println("Wins: "+win);
			if(win == 2) 
			{
				System.out.println("2/3 Win. Congratz you won!");
				//reset game
				win = 0;
				loss = 0;
			}
			else 
			{
				//do nothing, game continues
			}
		}
		else {
			loss++;
			System.out.println("Loss "+loss);
			if(loss == 2) 
			{
				System.out.println("2/3 Losses. Better luck next time!");
				win = 0;
				loss = 0;
			}
			else 
			{
				//do nothing, game continues
			}
		}
    }
	@Override
	public void actionPerformed(ActionEvent e) {}
}
