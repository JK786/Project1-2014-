/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//we are keeping ball of radius 10
package myprojectile;


import java.awt.*;
import java.awt.event.*;
import java.lang.*;

public class Myprojectile extends Frame implements ActionListener{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
     Myprojectile m=new Myprojectile();
        m.setTitle("My projectile");

    }

    Panel lower_panel=new Panel();
    Button launch= new Button("launch");
    Button quit= new Button("quit");
    int count=0;

    int floor=0;//acc to new coordiante

    int radius=10;
    int x=radius;//position of x coordinate of the centre of the ball
    int  y=-(radius);// position of centre of ball above y
    double dx=0;
    double dy=0;
    double vx,vy;
    double g=980;
    double theta=30;
    double timescale=1;
  Myprojectile()
    {


        addWindowListener(new MyWindowAdapter());
        lower_panel.add(launch);
        lower_panel.add(quit);
        this.add(lower_panel,BorderLayout.SOUTH);

        launch.addActionListener (this);
        quit.addActionListener (this);
		this.setBounds(0,0,1000,1000);
		this.setVisible(true);

    }


    @Override
    public void paint (Graphics g)
    {
          g.translate(0,600);
         g.drawLine(0,0 ,1000,0);
         g.drawLine(50,-5,50,5);
         g.drawLine(100,-5,100,5);
         g.drawLine(150,-5,150,5);
         g.drawLine(200,-5,200,5);
         g.drawLine(250,-5,250,5);
         g.drawLine(300,-5,300,5);
         g.drawLine(350,-5,350,5);
         g.drawLine(400,-5,400,5);
         g.drawLine(450,-5,450,5);
         g.drawLine(500,-5,500,5);
         g.drawLine(550,-5,550,5);
         g.drawLine(600,-5,600,5);
         g.drawLine(650,-5,650,5);
         g.drawLine(700,-5,700,5);
         g.drawLine(750,-5,750,5);
         g.drawLine(800,-5,800,5);
         g.drawLine(850,-5,850,5);
         g.drawLine(900,-5,900,5);
         g.drawLine(950,-5,950,5);
         g.drawLine(1000,-5,1000,5);
        g.fillOval(x-radius,y-radius,20,20);
    }



     public void actionPerformed(ActionEvent e)
    {
         if(e.getSource()==launch)
         {

            delaying();
         }


         if(e.getSource()==quit)
         {
             System.exit(0);
         }
     }

     	public void delaying () {
		double time=0;
		try {
			while (true) {
				//time++;
				Thread.sleep(33);

				time=time + (33.0/1000.0)*timescale;
				this.modify(time);
				this.update(getGraphics());
				if (y>floor+radius&&x>0)
				break;

                                


			}

		}
		catch (InterruptedException exception) {
		}
		
              }

     public void modify(double time)
    {
         this.theta= Math.PI/180.0 * theta;
       this.x=(int) ( (700* Math.cos(this.theta)) * time);
      this.y=(int) -(700*Math.cos(this.theta)*time-0.5*g*time*time);
       
      

    }

class MyWindowAdapter extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent we) {
        System.exit(0);
    }
}
