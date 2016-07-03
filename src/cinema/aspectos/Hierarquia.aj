package cinema.aspectos;
import javax.swing.JPanel;
import javax.swing.JFrame;
import cinema.gui.*;

public aspect Hierarquia {
	declare parents: TelaPrincipal extends JFrame;
	// extensões de ator
	declare parents: AtorCria extends JPanel ;
	declare parents: AtorIndex extends JPanel;
	declare parents: AtorUpdate extends JPanel;
	// extensões de cinema
	declare parents: CinemaCria extends JPanel;
	declare parents: CinemaIndex extends JPanel;
	declare parents: CinemaUpdate extends JPanel;
	// extensões de cliente
	declare parents: ClienteCria extends JPanel;
	declare parents: ClienteIndex extends JPanel;
	declare parents: ClienteUpdate extends JPanel;
	// extensões de compra
	declare parents: CompraCria extends JPanel;
	declare parents: CompraIndex extends JPanel;
	declare parents: CompraUpdate extends JPanel;
	// extensões de diretor
	declare parents: DiretorCria extends JPanel;
	declare parents: DiretorIndex extends JPanel;
	declare parents: DiretorUpdate extends JPanel;
	// extensões de filme
	declare parents: FilmeCria extends JPanel;
	declare parents: FilmeIndex extends JPanel;
	declare parents: FilmeUpdate extends JPanel;
	// extensões de funcao
	declare parents: FuncaoCria extends JPanel;
	declare parents: FuncaoIndex extends JPanel;
	declare parents: FuncaoUpdate extends JPanel;
	// extensões de funcionario
	declare parents: FuncionarioCria extends JPanel;
	declare parents: FuncionarioIndex extends JPanel;
	declare parents: FuncionarioUpdate extends JPanel;
	// extensões de sala
	declare parents: SalaCria extends JPanel;
	declare parents: SalaIndex extends JPanel;
	declare parents: SalaUpdate extends JPanel;
	// extensões de sessao
	declare parents: SessaoCria extends JPanel;
	declare parents: SessaoIndex extends JPanel;
	declare parents: SessaoUpdate extends JPanel;
}
