package cinema.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		CardLayout cards_Index = new CardLayout();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel Index = new JPanel();
		Index.setBounds(0, 75, 884, 389);
		contentPane.add(Index);
		Index.setLayout(cards_Index);
		
		
		
		JButton btnCliente = new JButton("Cliente");
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JPanel clienteIndex = new ClienteIndex();
				Index.add(clienteIndex, "clienteIndex");
				cards_Index.show(Index,"clienteIndex");
			}
		});
		btnCliente.setBounds(0, 0, 89, 23);
		contentPane.add(btnCliente);
		
		JButton btnAtor = new JButton("Ator");
		btnAtor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel atorIndex = new AtorIndex();
				Index.add(atorIndex, "atorIndex");
				cards_Index.show(Index,"atorIndex");
			}
		});
		btnAtor.setBounds(99, 0, 89, 23);
		contentPane.add(btnAtor);
	}
}
