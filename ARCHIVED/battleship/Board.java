import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.applet.*;
/**
 * @brief clase tablero c
 * @details clase tablero hecha con jbutton's y un grid como contenedor
 * @return un tablero
 */
public class Board extends Container{

	public Board(){
		this.setLayout(new GridLayout(10,10));

		JButton[][] b=new JButton[10][10];
		//Nos ayudara a manejar a la logica del juego de manera más fácil
		char[][] aux=new char[10][10];
		
		for (int i=0;i<b.length ;i++ ) {
			for (int j=0; j<b[i].length;j++ ) {
				aux[i][j]='e';
				b[i][j]=new JButton();
				//cambiarColor(b[i][j]);
				this.add(b[i][j]);
			}
		}
		setVerticalShips(b,aux);
		//inicia el listener para cambiar de color cada boton
		for (int i=0;i<b.length ;i++ ) 
			for (int j=0; j<b[i].length;j++ ) 
				cambiarColor(b[i][j]);



	}
	/**
	 * @brief cambia color es un metodo para cambiar de color
	 * @details este es un metodo con un Listener que esta a la escucha
	 * de cuando un boton es presionado
	 * 
	 * @param b es un Jbutton
	 */*/
	public void cambiarColor(JButton b){
		b.addMouseListener(new MouseAdapter(){

			@Override
			public void mousePressed(MouseEvent e) {
				b.setBackground(Color.RED);
			}
		});
	}
	public void setVerticalShips(JButton[][] grid,char[][] aux){
		//int k=5;// porque son 5 naves
		//while (k!=0) {
		grid[0][0].addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e){
				if(aux[0][0]=='e' && aux[0+1][0]=='e' ){
					aux[0][0]='s';
					aux[0+1][0]='s';
					grid[0][0].setBackground(Color.BLUE);
					grid[0+1][0].setBackground(Color.BLUE);
				}
			}
		});
		//}

	}

}