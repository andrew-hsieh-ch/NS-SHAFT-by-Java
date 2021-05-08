package project1;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Kids {
	private static final int FRAME=400;
	private static final int tall=32;
	private static final int fat=32;
	private double x,y;
	private double dx,dy;
	private int life=10;
	private ImageIcon image;
	
	private ImageIcon[] wright=new ImageIcon[6]; 
	private ImageIcon[] wleft=new ImageIcon[6];
	private ImageIcon[] forward=new ImageIcon[2];
	private ImageIcon[] jright=new ImageIcon[5];
	private ImageIcon[] jleft=new ImageIcon[5];
	private ImageIcon[] jump=new ImageIcon[5];
	java.net.URL for1 = getClass().getResource("forward.png");
	java.net.URL for2 = getClass().getResource("forwardhurt.png");
	
	java.net.URL wr1 = getClass().getResource("right1.png");
	java.net.URL wr2 = getClass().getResource("right2.png");
	java.net.URL wr3 = getClass().getResource("right3.png");
	java.net.URL wr4 = getClass().getResource("right4.png");
	java.net.URL wr5 = getClass().getResource("righthurt1.png");
	java.net.URL wr6 = getClass().getResource("righthurt2.png");
	
	java.net.URL wl1 = getClass().getResource("left1.png");
	java.net.URL wl2 = getClass().getResource("left2.png");
	java.net.URL wl3 = getClass().getResource("left3.png");
	java.net.URL wl4 = getClass().getResource("left4.png");
	java.net.URL wl5 = getClass().getResource("lefthurt1.png");
	java.net.URL wl6 = getClass().getResource("lefthurt2.png");
	
	java.net.URL jr1 = getClass().getResource("rightjump1.png");
	java.net.URL jr2 = getClass().getResource("rightjump2.png");
	java.net.URL jr3 = getClass().getResource("rightjump3.png");
	java.net.URL jr4 = getClass().getResource("rightjump4.png");
	java.net.URL jr5 = getClass().getResource("rightjumphurt.png");
	
	java.net.URL jl1 = getClass().getResource("leftjump1.png");
	java.net.URL jl2 = getClass().getResource("leftjump2.png");
	java.net.URL jl3 = getClass().getResource("leftjump3.png");
	java.net.URL jl4 = getClass().getResource("leftjump4.png");
	java.net.URL jl5 = getClass().getResource("leftjumphurt1.png");
	
	java.net.URL j1 = getClass().getResource("jump1.png");
	java.net.URL j2 = getClass().getResource("jump2.png");
	java.net.URL j3 = getClass().getResource("jump3.png");
	java.net.URL j4 = getClass().getResource("jump4.png");
	java.net.URL j5 = getClass().getResource("jumphurt.png");
	
	public Kids() {
		// TODO Auto-generated constructor stub
		forward[0]=new ImageIcon(for1);
		forward[1]=new ImageIcon(for2);
		
		wright[0]=new ImageIcon(wr1);
		wright[1]=new ImageIcon(wr2);
		wright[2]=new ImageIcon(wr3);
		wright[3]=new ImageIcon(wr4);
		wright[4]=new ImageIcon(wr5);
		wright[5]=new ImageIcon(wr6);
		
		wleft[0]=new ImageIcon(wl1);
		wleft[1]=new ImageIcon(wl2);
		wleft[2]=new ImageIcon(wl3);
		wleft[3]=new ImageIcon(wl4);
		wleft[4]=new ImageIcon(wl5);
		wleft[5]=new ImageIcon(wl6);
		
		jright[0]=new ImageIcon(jr1);
		jright[1]=new ImageIcon(jr2);
		jright[2]=new ImageIcon(jr3);
		jright[3]=new ImageIcon(jr4);
		jright[4]=new ImageIcon(jr5);
		
		jleft[0]=new ImageIcon(jl1);
		jleft[1]=new ImageIcon(jl2);
		jleft[2]=new ImageIcon(jl3);
		jleft[3]=new ImageIcon(jl4);
		jleft[4]=new ImageIcon(jl5);
		
		jump[0]=new ImageIcon(j1);
		jump[1]=new ImageIcon(j2);
		jump[2]=new ImageIcon(j3);
		jump[3]=new ImageIcon(j4);
		jump[4]=new ImageIcon(j5);
		
		x=FRAME/2;
		y=100;
		dx=0;
		dy=0.1;
		image=forward[0];
	}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getDx() {
		return dx;
	}

	public void setDx(double dx) {
		this.dx = dx;
	}

	public double getDy() {
		return dy;
	}

	public void setDy(double dy) {
		this.dy = dy;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public void forward(int i)
	{
		setDx(0);
		image=forward[i];
	}
	
	public void walk_right(int i)
	{
		if(x<18)
		{
			dx=0;
			x=19;
		}
		else if(x>350)
		{
			dx=0;
			x=349;
		}
		else
			dx=3;
		image=wright[i];
	}
	
	public void walk_left(int i)
	{
		if(x<18)
		{
			dx=0;
			x=19;
		}
		else if(x>350)
		{
			dx=0;
			x=349;
		}
		else
			dx=-3;
		image=wleft[i];
	}
	
	public void jump(int i)
	{
		dx=0;
		dy=dy+0.075;
		if(dy>4)
			dy=4;
		image=jump[i];
	}
	
	public void jump_right(int i)
	{
		if(x<18)
		{
			dx=0;
			x=19;
		}
		else if(x>350)
		{
			dx=0;
			x=349;
		}
		else
			dx=3;
		dy=dy+0.075;
		if(dy>4)
			dy=4;
		dx=3;
		image=jright[i];
	}
	
	public void jump_left(int i)
	{
		if(x<18)
		{
			dx=0;
			x=19;
		}
		else if(x>350)
		{
			dx=0;
			x=349;
		}
		else
			dx=-3;
		dy=dy+0.075;
		if(dy>4)
			dy=4;
		dx=-3;
		image=jleft[i];
	}
	
	public void move()
	{
		x=x+dx;
		y=y+dy;
	}
	
	public void draw(Graphics myBuffer)
	{
		myBuffer.drawImage(image.getImage(),(int)x,(int)y,null);
	}
	

}

