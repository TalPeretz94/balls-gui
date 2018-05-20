package ball;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.*;
public class BallControl extends JPanel
{ private Ball ball = new Ball();
  private JButton jbtSuspend = new JButton("Suspend");
  private JButton jbtResume = new JButton("Resume");
  private JScrollBar jsbDelay = new JScrollBar();
  private JButton jbtBall=new JButton("add ball");
  private String[] Scolors = { "Red", "Green", "Black", "Blue", "Yellow" };
  private Color[] Ccolors = { Color.red, Color.green, Color.black, Color.blue, Color.yellow };
  private Color newC=Color.red;
  private String[] Ssize = { "defult", "big", "small","XXXXL"};
  private int[] Csize = { 5,20,2,70};
  private int newR=5;
  JComboBox ballColor = new JComboBox(Scolors);
  JComboBox ballSize = new JComboBox(Ssize);
  private boolean crazyColors=false;
  private JButton jbtMode=new JButton("crazy mode");
  
  
  public BallControl()
  {  // Group buttons in a panel
    JPanel panel = new JPanel();
    panel.add(jbtSuspend);
    panel.add(jbtResume);
    panel.add(jbtBall);
    panel.add(ballColor);
    panel.add(ballSize);
    panel.add(jbtMode);
    
    // Add ball and buttons to the panel
    ball.setBorder(new javax.swing.border.LineBorder(Color.red));
    jsbDelay.setOrientation(JScrollBar.HORIZONTAL);
    ball.setDelay(jsbDelay.getMaximum());
    setLayout(new BorderLayout());
    add(jsbDelay, BorderLayout.NORTH);
    add(ball, BorderLayout.CENTER);
    add(panel, BorderLayout.SOUTH);
    // Register listeners
    jbtSuspend.addActionListener(new ActionListener()
    { public void actionPerformed(ActionEvent e)
      { ball.suspend();
      }
    });
    jbtResume.addActionListener(new ActionListener()
    {  public void actionPerformed(ActionEvent e)
       { ball.resume();
       }
    });
    jsbDelay.addAdjustmentListener(new AdjustmentListener()
    { public void adjustmentValueChanged(AdjustmentEvent e)
      { ball.setDelay(jsbDelay.getMaximum() - e.getValue());
      }
    });
    
    jbtBall.addActionListener(new ActionListener()
    { public void actionPerformed(ActionEvent e)
      { 
    	

    	ball.addBall(newC,newR);
		
    	
      }
    });
    
	ballColor.addItemListener(new ItemListener() {

		@Override
		public void itemStateChanged(ItemEvent e) {
			newC = Ccolors[ballColor.getSelectedIndex()];
			repaint();
		}
	});
	
	ballSize.addItemListener(new ItemListener() {

		@Override
		public void itemStateChanged(ItemEvent e) {
			newR = Csize[ballSize.getSelectedIndex()];
			repaint();
		}
	});

    
    
  }
  
  

  
}

