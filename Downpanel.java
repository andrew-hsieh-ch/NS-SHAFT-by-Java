package project1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Downpanel extends JPanel {

	private static final int WIDTH = 400, HEIGHT = 400;
	private BufferedImage myImage;
	private Graphics myBuffer;
	private Timer t1, t2;
	private Kids boy;
	private int step=9;
	private int stairnum = 0;
	private int l,r;
	private int j;
	private int cnt=0;
	private int point=0;
	private boolean stand=false;
	private boolean right = false;
	private boolean left = false;
	private boolean start = false;
	private boolean dead = false;
	private boolean fake=false;
	private boolean tramp=false;
	private boolean hurt=false;
	
	java.net.URL cel = getClass().getResource("ceiling.png");
	java.net.URL wal = getClass().getResource("wall.png");
	java.net.URL die = getClass().getResource("died.jpg");
	java.net.URL st = getClass().getResource("unnamed.jpg");
	
	private ImageIcon ceiling = new ImageIcon(cel);
	private ImageIcon wall = new ImageIcon(wal);
	private ImageIcon died = new ImageIcon(die);
	private ImageIcon started = new ImageIcon(st);
	private int wally = 0;
	private Map[] stair = new Map[10];
	
	public Downpanel() {
		// TODO Auto-generated constructor stub
		l = 0;
		r = 0;
		j = 0;
		myImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		myBuffer = myImage.getGraphics();
		stair[9]=new Map();
		stair[9].setY(500);
		stair[9].setDy(0);
		boy = new Kids();
		myBuffer.drawImage(started.getImage(), 0, 0, 400, 400, null);
		
		myBuffer.setColor(Color.black);
		myBuffer.setFont(new Font("Monospaced", Font.BOLD, 24));
		myBuffer.drawString("小朋友下樓梯", 80, 100);
		myBuffer.drawString("想按空白鍵開始吧", 120, 125);

		
		
		t1 = new Timer(9, new Listener());
		t2 = new Timer(700, new Listener2());
		addKeyListener(new key());
		setFocusable(true);
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
	}

	private class Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(start==true)
			{
				wally = (wally - 1) % 34;
				if(hurt==true)
				{
					myBuffer.setColor(Color.red);
					hurt=false;
				}
				else
				 myBuffer.setColor(Color.black);
				myBuffer.fillRect(0, 0, WIDTH, HEIGHT);
				myBuffer.drawImage(ceiling.getImage(), 0, 0, null);
				myBuffer.drawImage(wall.getImage(), 0, wally, null);
				myBuffer.drawImage(wall.getImage(), 382, wally, null);
				if(stairnum==0)
				{
					stair[stairnum] = new Map();
					stairnum++;
				}
				
				if(stand==true)
				{
					if(collide(boy,stair[step]))
					{
						if(stair[step].getPatern()==0||stair[step].getPatern()==5)
						{
							if(right==true)
							{
								r = (r + 1) % 4;
								boy.walk_right(r);
							}
							else if(left==true)
							{
								l = (l + 1) % 4;
								boy.walk_left(l);
							}
							else
								boy.forward(0);
							
						}
						else if(stair[step].getPatern()==1)
						{
							if(right==true)
							{
								r = (r + 1) % 4;
								boy.walk_right(r);
							}
							else if(left==true)
							{
								l = (l + 1) % 4;
								boy.walk_left(l);
							}
							else
								boy.forward(0);
							
							if(boy.getX()<18)
							{
								boy.setDx(0);
								boy.setX(18);
							}
							
							else
								boy.setDx(boy.getDx()-1);
						}
						
						else if(stair[step].getPatern()==2)
						{
							if(right==true)
							{
								r = (r + 1) % 4;
								boy.walk_right(r);
							}
							else if(left==true)
							{
								l = (l + 1) % 4;
								boy.walk_left(l);
							}
							else
								boy.forward(0);
							
							if(boy.getX()>350)
							{
								boy.setDx(0);
								boy.setX(350);
							}
							
							else
								boy.setDx(boy.getDx()+1);
						}
						
						else if(stair[step].getPatern()==3)
						{
							fake=true;
							boy.setY(stair[step].getY()-25);
							stand=false;
							
						}
						else if(stair[step].getPatern()==4)
						{
							stand=false;
							tramp=true;
							boy.setDy(-4);
						}
						
					}
					else
						stand=false;
				}
				
				else
				{
					for(int i=0;i<stairnum;i++)
					{
						if(collide(boy,stair[i])) 
						{
							boy.setY(stair[i].getY()-32);
							boy.setDy(stair[i].getDy());
							if(stair[i].getPatern()!=3)
							{
								if(stair[i].getPatern()!=5&&boy.getLife()<10)
								{
									boy.setLife(boy.getLife()+1);
								}
								else if(stair[i].getPatern()==5)
								{
									hurt=true;
									boy.setLife(boy.getLife()-3);
									boy.setY(stair[i].getY()-15);
									if(right==true)
										boy.walk_right(4);
									
									else if(left==true)
										boy.walk_left(4);
									
									else
										boy.forward(1);
									
									
								}
							}
							stand=true;
							step=i;
							break;
						}
					}
					if(stand==false)
					{
						if(right==true)
						{
							j = (j + 1) % 4;
							boy.jump_right(j);
						}
						else if(left==true)
						{
							j = (j + 1) % 4;
							boy.jump_left(j);
						}
						else
						{
							j = (j + 1) % 4;
							boy.jump(j);
						}
					}
				}
				
				
				if(stair[step].getPatern()==4&&tramp==true)
				{
					if(stair[step].drawoncetramp(myBuffer))
					{
						step=9;
						tramp=false;
					}
					
				}
				
				if(stair[step].getPatern()==3&&fake==true)
				{
					if(stair[step].drawonce(myBuffer))
						fake=false;
				}
				
				for(int i=0;i<stairnum;i++)
				{
					if(stair[i].getPatern()==1||stair[i].getPatern()==2)
						stair[i].drawmotion(myBuffer);
					
					else
					{
						if(stair[i].getPatern()==4&&i!=step)
						{
							stair[i].draw(myBuffer);
						}
						else if(stair[i].getPatern()!=4)
							stair[i].draw(myBuffer);
					}
					stair[i].move();
				}
				if(boy.getY()<0)
				{
					boy.setLife(boy.getLife()-3);
					boy.setY(5);
					boy.setDy(0.1);
					hurt=true;
					if(right==true)
						boy.jump_right(4);
					else if(left==true)
						boy.jump_left(4);
					else
						boy.jump(4);
				}
				
				if(boy.getLife()<0)
					boy.setLife(0);
				
				boy.move();
				boy.draw(myBuffer);
				
				myBuffer.setColor(Color.green);
				myBuffer.setFont(new Font("Monospaced", Font.PLAIN, 24));
				myBuffer.drawString("Life: " + boy.getLife(), 30, 50);
				myBuffer.setColor(Color.white);
				myBuffer.drawString("Floor: " + point/2, 250, 50);
				
				if(boy.getLife()<=0||boy.getY()>=400)
				{
					
					dead=true;
					start=false;
					boy.setLife(10);
					point=0;
					
				}
			}
			else if(dead==true)
			{
				myBuffer.setColor(Color.black);
				myBuffer.fillRect(0, 0, 400, 400);
				myBuffer.drawImage(died.getImage(), 25, 0, 375, 375, null);
				myBuffer.setColor(Color.white);
				myBuffer.setFont(new Font("Monospaced", Font.ITALIC, 20));
				myBuffer.drawString("Press  space  to  restart", 120, 300);
				for(int i=0;i<stairnum;i++)
				{
						stair[i].setY(-30);
				}
				cnt=0;
				boy.setX(400/2);
				boy.setY(100);
				boy.setDy(0);
				boy.setDx(0);
				boy.forward(0);
			}
			
			repaint();
		}
	}

	private class Listener2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			if (stairnum < 6) {
				stair[stairnum] = new Map();
				stairnum++;
			} 
			else 
			{
				stair[cnt].create();
				cnt=(cnt+1)%stairnum;
			}
			
			point++;
		}
	}

	private class key extends KeyAdapter {
		public void keyPressed(KeyEvent e) {

			if (e.getKeyCode() == KeyEvent.VK_LEFT)
				left = true;

			else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
				right = true;

			if (e.getKeyCode() == KeyEvent.VK_SPACE ) {
				
			}
				
		}

		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				left = false;
				l = 0;
				boy.forward(0);
			}

			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				right = false;
				r = 0;
				boy.forward(0);
			}

			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				start=true;
				dead=false;
				t1.start();
				t2.start();
				boy.jump(0);
			}
		}

	}
	
	public boolean collide(Kids b,Map s)
	{
		if(s.getPatern()!=5&&(b.getY()+28<=s.getY()&&b.getY()+35>=s.getY())
			&&(b.getX()+32>=s.getX()&&b.getX()<=s.getX()+97)&&b.getDy()>=s.getDy())
			return true;
		if(s.getPatern()==5&&(b.getY()+13<=s.getY()&&b.getY()+20>=s.getY())
				&&(b.getX()+32>=s.getX()&&b.getX()<=s.getX()+97)&&b.getDy()>=s.getDy())
			return true;
		else
			return false;
			
	}
	
	

}
