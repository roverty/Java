import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.applet.*;

public class Interface extends JFrame{

	public Interface(){	
		//Nombre de la ventana
		super("BattleShip");
		setLayout(new BorderLayout(5, 10));
		
		// contenedor de la etiqueta y grid de lado derecho
		JPanel subpanelE=new JPanel(new BorderLayout());
		//Espaciado entre componentes
		subpanelE.setBorder(new EmptyBorder(5, 5, 5, 5) );
		// contenedor de la etiqueta y botoenes de lado derecho
		subpanelE.add(new JLabel("Tablero enemigo"),BorderLayout.NORTH);
		subpanelE.add(new Board(),BorderLayout.CENTER);
		add(subpanelE, BorderLayout.EAST);
		
		//Contenedorde la etiqueta y grid del lado izquierdo
		JPanel subpanelW=new JPanel(new BorderLayout());
		subpanelW.setBorder(new EmptyBorder(5, 5, 5, 5) );
		subpanelW.add(new JLabel("Mi tablero"),BorderLayout.NORTH);
		subpanelW.add(new Board(),BorderLayout.CENTER);
		add(subpanelW, BorderLayout.WEST);
		
		JPanel subpanelS=new JPanel();
		JButton start=new JButton("START GAME");
		subpanelS.add(start);
		
		JButton setShips=new JButton("SET SHIPS");
		setShips.setEnabled(false);

		//Funcion para desctivar el boton start y activar el boton setships
		startGame(start,setShips);

		subpanelS.add(setShips);
		add(subpanelS, BorderLayout.SOUTH);

		setSize(700,400); //pack();
		//Para que la ventana no aparezca en la esquina
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	/**
	 * @brief startGame cambia dos botonees de estado
	 * @details cmabia el boton start game a desactivado
	 * y el boton setShips a aactivado
	 * 
	 * @param b_start es un Jbutton
	 * @param b_ships es otro Jbutton
	 */*/
	public static void startGame(JButton b_start,JButton b_ships ){
		b_start.addMouseListener(new MouseAdapter(){

			@Override
			public void mousePressed(MouseEvent e) {
				//AQUI se revisara la conexion con el otro jugador
				b_start.setEnabled(false);
				b_ships.setEnabled(true);

			}
		});
	}
}