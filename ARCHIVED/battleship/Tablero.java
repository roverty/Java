import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.applet.*;

class Board extends Container{

	public Board(){
		this.setLayout(new GridLayout(10,10));

		JButton[][] b=new JButton[10][10];
		for (int i=0;i<b.length ;i++ ) {
			for (int j=0; j<b[i].length;j++ ) {
				b[i][j]=new JButton();
				cambiarColor(b[i][j]);
				this.add(b[i][j]);
			}
		}
	}
	public static void cambiarColor(JButton b){
		b.addMouseListener(new MouseAdapter(){

			@Override
			public void mousePressed(MouseEvent e) {
				b.setBackground(Color.RED);
			}
		});
	}

}
class Interfaz extends JFrame{

	public Interfaz(){	
		super("BattleShip");
		// BorderLayout
		setLayout(new BorderLayout(5, 10));
		JPanel subpanelE=new JPanel(new BorderLayout());
		subpanelE.setBorder(new EmptyBorder(5, 5, 5, 5) );
		subpanelE.add(new JLabel("Tablero enemigo"),BorderLayout.NORTH);
		subpanelE.add(new Board(),BorderLayout.CENTER);
		//subpanelE.add(new JLabel(" "),BorderLayout.EAST);
		add(subpanelE, BorderLayout.EAST);
		JPanel subpanelW=new JPanel(new BorderLayout());
		subpanelW.setBorder(new EmptyBorder(5, 5, 5, 5) );
		subpanelW.add(new JLabel("Mi tablero"),BorderLayout.NORTH);
		subpanelW.add(new Board(),BorderLayout.CENTER);
		add(subpanelW, BorderLayout.WEST);
		JPanel subpanelS=new JPanel();
		subpanelS.add(new JButton("START GAME"));
		subpanelS.add(new JButton("SET SHIPS"));
		add(subpanelS, BorderLayout.SOUTH);
		setSize(700,400); //pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
	
	}
}
public class Tablero2{
	public static void main(String[] args) {
		Interfaz i=new Interfaz();
	}
}
