package project1;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Map {

	private int x,y;
	private int dx,dy;
	private int pics;
	private int patern;
	private int i=0;
	private int times=0;
	
	private ImageIcon[][] stairs=new ImageIcon[6][6];
	
	java.net.URL nor = getClass().getResource("normal.png");
	
	java.net.URL cl1 = getClass().getResource("conveyor_left1.png");
	java.net.URL cl2 = getClass().getResource("conveyor_left2.png");
	java.net.URL cl3 = getClass().getResource("conveyor_left3.png");
	java.net.URL cl4 = getClass().getResource("conveyor_left4.png");
	
	java.net.URL cr1 = getClass().getResource("conveyor_right1.png");
	java.net.URL cr2 = getClass().getResource("conveyor_right2.png");
	java.net.URL cr3 = getClass().getResource("conveyor_right3.png");
	java.net.URL cr4 = getClass().getResource("conveyor_right4.png");
	
	java.net.URL f1 = getClass().getResource("fake1.png");
	java.net.URL f2 = getClass().getResource("fake 2.png");
	java.net.URL f3 = getClass().getResource("fake 3.png");
	java.net.URL f4 = getClass().getResource("fake 4.png");
	java.net.URL f5 = getClass().getResource("fake 5.png");
	java.net.URL f6 = getClass().getResource("fake 6.png");

	java.net.URL t1 = getClass().getResource("trampoline1.png");
	java.net.URL t2 = getClass().getResource("trampoline2.png");
	java.net.URL t3 = getClass().getResource("trampoline3.png");
	java.net.URL t4 = getClass().getResource("trampoline4.png");
	java.net.URL t5 = getClass().getResource("trampoline5.png");
	java.net.URL t6 = getClass().getResource("trampoline6.png");
	
	java.net.URL nail = getClass().getResource("nails.png");
	
	public Map() {
		// TODO Auto-generated constructor stub
		stairs[0][0]=new ImageIcon(nor);      //normal
		
		stairs[1][0]=new ImageIcon(cl1);      //conveyor_left
		stairs[1][1]=new ImageIcon(cl2);
		stairs[1][2]=new ImageIcon(cl3);
		stairs[1][3]=new ImageIcon(cl4);
		
		stairs[2][0]=new ImageIcon(cr1);    //conveyor_right
		stairs[2][1]=new ImageIcon(cr2);
		stairs[2][2]=new ImageIcon(cr3);
		stairs[2][3]=new ImageIcon(cr4);
		
		stairs[3][0]=new ImageIcon(f1);                       //fake
		stairs[3][1]=new ImageIcon(f2);
		stairs[3][2]=new ImageIcon(f3);
		stairs[3][3]=new ImageIcon(f4);
		stairs[3][4]=new ImageIcon(f5);
		stairs[3][5]=new ImageIcon(f6);
		
		stairs[4][0]=new ImageIcon(t1);         //trampoline 
		stairs[4][1]=new ImageIcon(t2);
		stairs[4][2]=new ImageIcon(t3);
		stairs[4][3]=new ImageIcon(t4);
		stairs[4][4]=new ImageIcon(t5);
		stairs[4][5]=new ImageIcon(t6);
		
		stairs[5][0]=new ImageIcon(nail);                           //nail
		
		
		create();
		dy=-1;
		dx=0;
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public int getDx() {
		return dx;
	}


	public void setDx(int dx) {
		this.dx = dx;
	}


	public int getDy() {
		return dy;
	}


	public void setDy(int dy) {
		this.dy = dy;
	}


	public int getPics() {
		return pics;
	}


	public void setPics(int pics) {
		this.pics = pics;
	}


	public int getPatern() {
		return patern;
	}


	public void setPatern(int patern) {
		this.patern = patern;
	}
	
	public void move()
	{
		y=y+dy;
	}
	
	public void create()
	{
		x=(int)(Math.random()*265+18);
		y=400;
		dy=-1;
		i=0;
		times=0;
		patern=(int)(Math.random()*6);
		switch(patern)
		{
		case 0:
			pics=1;
			break;
		case 1:
			pics=4;
			break;
		case 2:
			pics=4;
			break;
		case 3:
			pics=6;
			break;
		case 4:
			pics=6;
			break;
		case 5:
			pics=1;
			break;
		}
	}
	
	public void drawmotion(Graphics myBuffer)
	{
		times++;
		myBuffer.drawImage(stairs[patern][i].getImage(),x,y,null);
		if((times%5)==0)
			i=(i+1)%pics;
		
		
	}
	
	public boolean drawonce(Graphics myBuffer)
	{
		times++;
		myBuffer.drawImage(stairs[patern][i].getImage(),x,y,null);
		if((times%5)==0)
			i=(i+1)%pics;
		
		if(i==(pics-1)&&times==(pics-1)*5+4)
		{
			i=0;
			times=0;
			return true;
		}
		
		return false;
	}
	
	public boolean drawoncetramp(Graphics myBuffer)
	{
		times++;
		myBuffer.drawImage(stairs[patern][i].getImage(),x,y+2*i,null);
		if((times%3)==0)
			i=(i+1)%pics;
		
		if(i==(pics-1)&&times==(pics-1)*3+2)
		{
			i=0;
			times=0;
			return true;
		}
		
		return false;
	}
	
	public void draw(Graphics myBuffer)
	{
		myBuffer.drawImage(stairs[patern][i].getImage(),x,y,null);
	}

}
