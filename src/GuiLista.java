import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiLista extends JFrame {
    private JLabel jlPendentes, jlConcluidas, jlInformativo1, jlInformativo2;
    private JCheckBox cbP1,cbP2,cbP3,cbP4 ,cbC1,cbC2,cbC3,cbC4;
    private static GuiLista frame;
    private JMenuBar mbMenu;
    private JMenu jmCriar , jmEditar;

    public GuiLista (){
        inicializarComponentes();
        definirEventos();
    }

    public void inicializarComponentes(){
        setTitle("Lista de Terefas");
        setBounds(0,0,400,350);
        setLayout(null);
        setLayout(new GridLayout(6,1));

        jlPendentes = new JLabel("Pendentes:",JLabel.LEFT);
        jlConcluidas = new JLabel("Concluídas:",JLabel.LEFT);
        jlInformativo1 = new JLabel("Selecione para concluir");
        jlInformativo2 = new JLabel("Selecione para excluir");
        cbP1 = new JCheckBox("Teste1");
        cbP2 = new JCheckBox("Teste2");
        cbP3 = new JCheckBox("Teste3");
        cbP4 = new JCheckBox("Teste4");
        cbC1 = new JCheckBox("Teste1");
        cbC2 = new JCheckBox("Teste2");
        cbC3 = new JCheckBox("Teste3");
        cbC4 = new JCheckBox("Teste4");

        add(jlPendentes);
        add(jlConcluidas);
        add(jlInformativo1);
        add(jlInformativo2);
        add(cbP1);
        add(cbC1);
        add(cbP2);
        add(cbC2);
        add(cbP3);
        add(cbC3);
        add(cbP4);
        add(cbC4);

        mbMenu = new JMenuBar();
        jmCriar = new JMenu("Adicionar tarefa ");
        jmEditar = new JMenu("Editar tarefa ");
        mbMenu.add(jmCriar);
        mbMenu.add(jmEditar);
        setJMenuBar(mbMenu);

    }

    public void definirEventos(){

    }

    public static void main (String args[]){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame = new GuiLista();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Dimension tela =  Toolkit.getDefaultToolkit().getScreenSize();
                frame.setLocation((tela.width - frame.getSize().width) / 2,
                        (tela.height - frame.getSize().height)/2);
                frame.setVisible(true);
            }
        });
    }
}
