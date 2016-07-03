package cinema.gui;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class TelaPrincipal {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame2 = new TelaPrincipal();
					frame2.setVisible(true);
					frame2.setIconImage(new ImageIcon(getClass().getResource("/Movies-icon.png")).getImage());
					frame2.setTitle("Sistema de Gest\u00E3o de Dados");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		setVisible(true);
		setIconImage(new ImageIcon(getClass().getResource("/Movies-icon.png")).getImage());
		setTitle("Sistema de Gest\u00E3o de Dados");
		
		CardLayout cards_Index = new CardLayout();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCapa = new JLabel("");
		lblCapa.setIcon(new ImageIcon("img/cinema.png"));
		lblCapa.setBounds(204, 152, 500, 310);
		contentPane.add(lblCapa);
		
		JPanel Index = new JPanel();
		Index.setBounds(0, 75, 884, 389);
		contentPane.add(Index);
		Index.setLayout(cards_Index);
		
		
		JButton btnCliente = new JButton("Cliente");
		btnCliente.setIcon(new ImageIcon("img/cliente.png"));
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JPanel clienteIndex = new ClienteIndex();
				Index.add(clienteIndex, "clienteIndex");
				cards_Index.show(Index,"clienteIndex");
				lblCapa.setVisible(false);
			}
		});
		btnCliente.setBounds(2, 5, 89, 23);
		contentPane.add(btnCliente);
		btnCliente.setBorder(new RoundedBorder(5));
		
		JButton btnAtor = new JButton("Ator");
		btnAtor.setIcon(new ImageIcon("img/ator.png"));
		btnAtor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel atorIndex = new AtorIndex();
				Index.add(atorIndex, "atorIndex");
				cards_Index.show(Index,"atorIndex");
				lblCapa.setVisible(false);
			}
		});
		btnAtor.setBounds(95, 5, 89, 23);
		contentPane.add(btnAtor);
		btnAtor.setBorder(new RoundedBorder(5));
		
		JButton btnFilme = new JButton("Filme");
		btnFilme.setIcon(new ImageIcon("img/filme.png"));
		btnFilme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel filmeIndex = new FilmeIndex();
				Index.add(filmeIndex, "filmeIndex");
				cards_Index.show(Index,"filmeIndex");
				lblCapa.setVisible(false);
			}
		});
		btnFilme.setBounds(190, 5, 89, 23);
		contentPane.add(btnFilme);
		btnFilme.setBorder(new RoundedBorder(5));
		
		JButton btnDiretor = new JButton("Diretor");
		btnDiretor.setIcon(new ImageIcon("img/diretor.png"));
		btnDiretor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel diretorIndex = new DiretorIndex();
				Index.add(diretorIndex, "diretorIndex");
				cards_Index.show(Index,"diretorIndex");
				lblCapa.setVisible(false);
			}
		});
		btnDiretor.setBounds(285, 5, 89, 23);
		contentPane.add(btnDiretor);
		btnDiretor.setBorder(new RoundedBorder(5));
		
		JButton btnFuncionario = new JButton("Funcion\u00E1rio");
		btnFuncionario.setIcon(new ImageIcon("img/funcionario.png"));
		btnFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel funcionarioIndex = new FuncionarioIndex();
				Index.add(funcionarioIndex, "FuncionarioIndex");
				cards_Index.show(Index,"FuncionarioIndex");
				lblCapa.setVisible(false);
			}
		});
		btnFuncionario.setBounds(382, 5, 111, 23);
		contentPane.add(btnFuncionario);
		btnFuncionario.setBorder(new RoundedBorder(5));
		
		JButton btnSala = new JButton("Sala");
		btnSala.setIcon(new ImageIcon("img/sala.png"));
		btnSala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel salaIndex = new SalaIndex();
				Index.add(salaIndex, "SalaIndex");
				cards_Index.show(Index,"SalaIndex");
				lblCapa.setVisible(false);
			}
		});
		btnSala.setBounds(500, 5, 89, 23);
		contentPane.add(btnSala);
		btnSala.setBorder(new RoundedBorder(5));
		
		JButton btnCompra = new JButton("Compra");
		btnCompra.setIcon(new ImageIcon("img/compra.png"));
		btnCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel compraIndex = new CompraIndex();
				Index.add(compraIndex, "CompraIndex");
				cards_Index.show(Index,"CompraIndex");
				lblCapa.setVisible(false);
			}
		});
		btnCompra.setBounds(599, 5, 89, 23);
		contentPane.add(btnCompra);
		btnCompra.setBorder(new RoundedBorder(5));
		
		JButton btnFuno = new JButton("Fun\u00E7\u00E3o");
		btnFuno.setIcon(new ImageIcon("img/funcao.png"));
		btnFuno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel funcaoIndex = new FuncaoIndex();
				Index.add(funcaoIndex, "FuncaoIndex");
				cards_Index.show(Index,"FuncaoIndex");
				lblCapa.setVisible(false);
			}
		});
		btnFuno.setBounds(698, 5, 89, 23);
		contentPane.add(btnFuno);
		btnFuno.setBorder(new RoundedBorder(5));
		
		JButton btnSessao = new JButton("Sessao");
		btnSessao.setIcon(new ImageIcon("img/sessao.png"));
		btnSessao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel sessaoIndex = new SessaoIndex();
				Index.add(sessaoIndex, "SessaoIndex");
				cards_Index.show(Index,"SessaoIndex");
				lblCapa.setVisible(false);
			}
		});
		btnSessao.setBounds(792, 5, 89, 23);
		contentPane.add(btnSessao);
		btnSessao.setBorder(new RoundedBorder(5));
		
		JButton btnCinema = new JButton("Cinema");
		btnCinema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel cinemaIndex = new CinemaIndex();
				Index.add(cinemaIndex, "CinemaIndex");
				cards_Index.show(Index,"CinemaIndex");
				lblCapa.setVisible(false);
			}
		});
		btnCinema.setIcon(new ImageIcon("img/cinema-2.png"));
		btnCinema.setBounds(2, 32, 89, 23);
		contentPane.add(btnCinema);
		btnCinema.setBorder(new RoundedBorder(5));
	}
}

//Classe para adicionar bordas aos botões
class RoundedBorder implements Border {

    private int radius;


    RoundedBorder(int radius) {
        this.radius = radius;
    }


    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
    }


    public boolean isBorderOpaque() {
        return true;
    }


    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x, y, width-1, height-1, radius, radius);
    }
}