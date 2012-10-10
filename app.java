/*
<applet code=app width=1000 height=600>
</applet>
*/

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class app extends Applet implements MouseListener{
    Image[] images = new Image[20];
    int frame = 0;
	static int n,v;
	static int current;
	int []ax=new int[13];
	int []ay=new int[13];
	static int []dist=new int[13];
	static int [][]cost=new int[13][13];
    String msg;
    Font f,f2,f3;
	Graphics buf;	
    public void init() {
        images[0] = getImage(getDocumentBase(), "images/diag1.gif");
        images[1] = getImage(getDocumentBase(), "images/machome.png");		
		images[2] = getImage(getDocumentBase(), "images/str.gif");			
        images[3] = getImage(getDocumentBase(), "images/standardgummi.png");	 
		
		n=12;current=0;
		cost[1][2]=6; 
		cost[1][12]=7;
		cost[1][5]=9;
		cost[2][1]=6;
		cost[2][3]=7;
		cost[2][6]=8;
		cost[3][2]=7;
		cost[3][12]=6;
		cost[3][9]=10;
		cost[3][10]=14;
		cost[3][7]=9;
		cost[4][12]=5;
		cost[4][5]=5;
		cost[5][1]=9;
		cost[5][4]=5;
		cost[6][2]=8;
		cost[6][8]=6;
		cost[7][3]=9;
		cost[7][10]=8;
		cost[8][6]=6;
		cost[8][11]=7;
		cost[9][3]=10;
		cost[9][11]=6;
		cost[10][3]=14;
		cost[10][7]=8;
		cost[11][9]=6;
		cost[11][8]=7;
		cost[11][10]=5;
		cost[12][1]=7;
		cost[12][4]=5;
		cost[12][3]=6;
		
		ax[1]=37;ay[1]=142;
		ax[2]=269;ay[2]=62;
		ax[3]=453;ay[3]=193;
		ax[4]=323;ay[4]=513;
		ax[5]=140;ay[5]=494;
		ax[6]=513;ay[6]=56;
		ax[7]=661;ay[7]=444;
		ax[8]=698;ay[8]=233;
		ax[9]=842;ay[9]=136;
		ax[10]=952;ay[10]=486;
		ax[11]=952;ay[11]=275;
		ax[12]=253;ay[12]=306;
		
        f = new Font("Dialog", Font.PLAIN, 25);
        msg = "Click on a source";
        setFont(f);
		addMouseListener(this);
		
		f2 = new Font("Dialog", Font.BOLD, 15);  
		
      	f3 = new Font("Dialog", Font.BOLD, 17);  	
    }
  

    public void paint(Graphics g) {
	     
        g.drawImage(images[0], 0, 150,70,70, this);
        g.drawImage(images[1], 200,10 ,70,70, this);
        g.drawImage(images[0], 200,300,70,70, this);
          g.drawImage(images[2], 393, 175,70,60, this);
		  g.drawImage(images[1], 265,450 ,70,70, this);
		  g.drawImage(images[2], 75, 450,70,60, this);		
		 g.drawImage(images[0], 450, 50,70,70, this);
		  g.drawImage(images[2], 600, 400,70,60, this);
		  g.drawImage(images[1], 630, 220,70,70, this);
		  g.drawImage(images[1], 780, 80,70,70, this);
		  g.drawImage(images[0], 900, 480,70,70, this);
		  g.drawImage(images[0], 900, 270,70,70, this);
		  
		  g.setColor(Color.red);
		  float dash1[] = {10.0f};
		  BasicStroke dashed =new BasicStroke(2.0f,BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER,
                        10.0f, dash1, 0.0f);
		  Graphics2D g2=(Graphics2D)g;		  
		  g2.setStroke(dashed);
		  g.drawLine(56,217,209,72);
		  g.drawLine(56,217,235,375);
		  g.drawLine(56,217,88,524);
		  g.drawLine(88,524,270,527);
		  g.drawLine(235,375,270,527);
		  g.drawLine(420,243,235,375);
		  g.drawLine(420,243,209,72);
		  g.drawLine(503,113,209,72);
		  g.drawLine(503,113,637,280);
		  g.drawLine(911,336,637,280);
		  g.drawLine(911,336,788,140);
		  g.drawLine(420,243,788,140);
		  g.drawLine(420,243,895,530);
		  g.drawLine(420,243,621,472);
		  g.drawLine(895,530,621,472);
		  g.drawLine(911,336,895,530);
		  
		  
		  g.setColor(Color.green);
		  g.fillOval(51,212,10,10);
		  g.fillOval(204,67,10,10);		  		  		 
		  g.fillOval(83,519,10,10);
		  g.fillOval(230,370,10,10);
		  g.fillOval(415,238,10,10);
		  g.fillOval(265,522,10,10);
		  g.fillOval(616,467,10,10);
		  g.fillOval(496,108,10,10);
		  g.fillOval(783,135,10,10);
		  g.fillOval(906,331,10,10);
		  g.fillOval(632,275,10,10);
		  g.fillOval(894,525,10,10);
		  
		  g.setFont(f3);
		  g.setColor(Color.DARK_GRAY);
		  g.drawString("6",147,145);
		  g.drawString("7",319,149);
		  g.drawString("8",353,82);
		  g.drawString("6",544,154);
		  g.drawString("7",767,300);
		  g.drawString("6",848,227);
		  g.drawString("10",637,196);
		  g.drawString("5",908,426);
		  g.drawString("8",728,512);
		  g.drawString("9",546,378);
		  g.drawString("6",338,316);
		  g.drawString("7",148,288);
		  g.drawString("5",253,432);
		  g.drawString("5",175,543);
		  g.drawString("9",80,383);
		  g.drawString("14",667,377);
		  
		  
		  if(current!=0)
		  {
		  g.setFont(f2);
		  g.setColor(Color.MAGENTA);
		    for(int i=1;i<=12;i++)
		    {
		      if(i!=current)
		      g.drawString(dist[i]+"",ax[i],ay[i]);
		    }
			g.drawImage(images[3], ax[current],ay[current],30,30, this);
		  }		  
		  else
		  {
		     g.drawImage(images[3], 24,26,30,30, this);
		  }
		  
          g.setFont(f);  		  
		  g.setColor(Color.GRAY);
		  g.drawString(msg,378,560);
		  buf=g; 

	 
    }
	
	
  
    public void mousePressed(MouseEvent me) {

}

public void mouseReleased(MouseEvent me) {

}

public void mouseDragged(MouseEvent me) {

}

public void mouseClicked(MouseEvent me) {
   int x=me.getX();int y=me.getY();int i;
   if(x>0 && x<70 &&y>150&&y<220)
   {
   msg="Mouse A";
   dij(1);
   msg="Click another source";   
	current=1;
	repaint();
   }
   if(x>200 && x<270 &&y>10&&y<280)
   {
   msg="Mouse B";
   dij(2);
  msg="Click another source";   
	current=2;
	repaint();
   }   
   if(x>200 && x<270 &&y>300&&y<370)
   {
   msg="Mouse L";
   dij(12);
  msg="Click another source";   
	current=12;
	repaint();
   }
   if(x>393 && x<463 &&y>175&&y<235)
   {
   msg="Mouse C";
   dij(3);
   msg="Click another source";   
	current=3;
	repaint();
   }
   if(x>265 && x<330 &&y>450&&y<520)
   {
   msg="Mouse D";
   dij(4);
   msg="Click another source";   
	current=4;
	repaint();
   }   
   if(x>75 && x<145 &&y>450&&y<510) 
   {
   msg="Mouse E";
   dij(5);
  msg="Click another source";   
	current=5;
	repaint();
   }
   if(x>450 && x<520 &&y>50&&y<120)
   {
   msg="Mouse F";
   dij(6);
  msg="Click another source";   
	current=6;
	repaint();
   }
   if(x>600 && x<670 &&y>400&&y<460)
   {
   msg="Mouse G";
   dij(7);
   msg="Click another source";   
	current=7;
	repaint();
   }
   if(x>630 && x<700 &&y>220&&y<290)
   {
   msg="Mouse H";
   dij(8);
  msg="Click another source";   
	current=8;
	repaint();
   }
   if(x>780 && x<850 &&y>80&&y<150)
   {
   msg="Mouse I";
   dij(9);
   msg="Click another source";   
	current=9;
	repaint();
   }
   if(x>900 && x<970 &&y>480&&y<550)
   {
   msg="Mouse J";
   dij(10);
   msg="Click another source";   
	current=10;
	repaint();
   }
   if(x>900 && x<970 &&y>270&&y<340)
   {
   msg="Mouse K";
   dij(11);
   msg="Click another source";   
	current=11;
	repaint();
   }
  
   
}
public void mouseEntered(MouseEvent me) {

}

public void mouseExited(MouseEvent me) {

}

public static void dij(int v)
{
  
   
 int i,u=0,count,w,min,j;
 int []flag=new int[13];
 for(i=1;i<=n;i++)
 {
  for(j=1;j<=n;j++)
  {   
   if(cost[i][j]==0)
    cost[i][j]=999;	
  }
  }
 for(i=1;i<=n;i++)
 {
  flag[i]=0;dist[i]=cost[v][i];
  }
 count=2;
 while(count<=n)
 {
  min=99;
  for(w=1;w<=n;w++)
   if(dist[w]<min && flag[w]==0)
   {
    min=dist[w];u=w;
	}
  flag[u]=1;
  count++;
  for(w=1;w<=n;w++)
   if((dist[u]+cost[u][w]<dist[w]) && flag[w]==0)
    dist[w]=dist[u]+cost[u][w];
 }
}

    
}