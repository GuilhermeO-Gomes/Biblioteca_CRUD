package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.LivrosController;

public class TelaLivros extends JFrame {

    private static final long serialVersionUID = 1L;
	private JLabel lblId;
    private JLabel lblTitulo;
    private JLabel lblAutor;
    private JLabel lblGenero;
    private JLabel lblIdioma;
    private JLabel lblQtd;
    private JLabel lblPreco;
    
    private JTextField txtId;
    private JTextField txtTitulo;
    private JTextField txtAutor;
    private JTextField txtGenero;
    private JTextField txtIdioma;
    private JTextField txtQtd;
    private JTextField txtPreco;
 

    private JButton btnNovo;
    private JButton btnSalvar;
    private JButton btnExcluir;
    private JButton btnLimpar;

    private JTable tabelaLivros;
    private DefaultTableModel modeloTabela;

    private LivrosController controller;

    public TelaLivros() {
        setTitle("Cadastro de Livros - Java SE 7 + Swing + MySQL");
        setSize(700, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        criarComponentes();

        controller = new LivrosController(this);
        configurarEventos();
       }
 
    private void criarComponentes() {
        JPanel painelFormulario = new JPanel(new GridLayout(7, 2, 10, 10));
        painelFormulario.setBorder(BorderFactory.createTitledBorder("Dados dos Livros"));

        lblId = new JLabel("ID:"); 
        txtId = new JTextField();
        txtId.setEditable(false);

        lblTitulo = new JLabel("Titulo:");
        txtTitulo = new JTextField();

        lblAutor = new JLabel("Autor:");
        txtAutor = new JTextField();
        
        lblGenero = new JLabel("Gênero:");
        txtGenero = new JTextField();
        
        lblIdioma = new JLabel("Idioma:");
        txtIdioma = new JTextField();
        
        lblQtd = new JLabel("Quantidade:");
        txtQtd = new JTextField();
        
        lblPreco = new JLabel("Preço:");
        txtPreco = new JTextField();

        painelFormulario.add(lblId);
        painelFormulario.add(txtId);
        painelFormulario.add(lblTitulo);
        painelFormulario.add(txtTitulo);
        painelFormulario.add(lblAutor);
        painelFormulario.add(txtAutor);
        painelFormulario.add(lblGenero);
        painelFormulario.add(txtGenero);
        painelFormulario.add(lblIdioma);
        painelFormulario.add(txtIdioma);
        painelFormulario.add(lblQtd);
        painelFormulario.add(txtQtd);
        painelFormulario.add(lblPreco);
        painelFormulario.add(txtPreco);
        

        add(painelFormulario, BorderLayout.NORTH);

        modeloTabela = new DefaultTableModel(new Object[] { "ID", "Titulo", "Autor", "Genero", "Idioma", "Qtd", "Preco" }, 0) {
            private static final long serialVersionUID = 1L;

            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tabelaLivros = new JTable(modeloTabela);
        JScrollPane scrollPane = new JScrollPane(tabelaLivros);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Lista de Livros"));
        add(scrollPane, BorderLayout.CENTER);

        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));

        btnNovo = new JButton("Novo");
        btnSalvar = new JButton("Salvar");
        btnExcluir = new JButton("Excluir");
        btnLimpar = new JButton("Limpar");

        painelBotoes.add(btnNovo);
        painelBotoes.add(btnSalvar);
        painelBotoes.add(btnExcluir);
        painelBotoes.add(btnLimpar);

        add(painelBotoes, BorderLayout.SOUTH);
    }

    private void configurarEventos() {
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                controller.limpar();
            }
        });

        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                controller.salvar();
            }
        });

        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                controller.excluir();
            }
        });

        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                controller.limpar();
            }
        });

        tabelaLivros.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                controller.preencherFormulario();
            }
        });
    }

    public JTextField getTxtId() {
        return txtId;
    }

    public JTextField getTxtTitulo() {
        return txtTitulo;
    }

    public JTextField getTxtAutor() {
        return txtAutor;
    }
    
    public JTextField getTxtGenero() {
        return txtGenero;
    }
    
    public JTextField getTxtIdioma() {
        return txtIdioma;
    }
    
    public JTextField getTxtQtd() {
        return txtQtd;
    }
    
    public JTextField getTxtPreco() {
        return txtPreco;
    }

    public JTable getTabelaLivros() {
        return tabelaLivros;
    }
}
