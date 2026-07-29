package controller;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


import dao.LivrosDAO;
import model.Livros;
import view.TelaLivros;


public class LivrosController {

    private TelaLivros tela;
    private LivrosDAO livrosDAO;

    public LivrosController(TelaLivros tela) {
        this.tela = tela;
        this.livrosDAO = new LivrosDAO();
    }

    public void salvar() {
        String titulo = tela.getTxtTitulo().getText().trim();
        String autor = tela.getTxtAutor().getText().trim();
        String genero = tela.getTxtGenero().getText().trim();
        String idioma = tela.getTxtIdioma().getText().trim();
        String qtd_txt = tela.getTxtQtd().getText().trim();
        String preco_txt = tela.getTxtPreco().getText().trim();


        if (titulo.isEmpty() || autor.isEmpty() || genero.isEmpty() || idioma.isEmpty() || qtd_txt.isEmpty() || preco_txt.isEmpty()) {
            JOptionPane.showMessageDialog(
                tela,
                "Preencha os campos.",
                "Atenção",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }
      //Conversão dos dados de texto para seus respectivos tipos de número
        int qtd = Integer.parseInt(qtd_txt);
        double preco = Double.parseDouble(preco_txt);
        
        if(qtd <= 0) {
        	JOptionPane.showMessageDialog(tela, "Não pode coloca quantidades inferiores a 0.", "Atenção", JOptionPane.WARNING_MESSAGE);
        	return;
        }
        
        if(preco <= 0) {
        	JOptionPane.showMessageDialog(tela, "Não pode coloca quantidades inferiores a 0.", "Atenção", JOptionPane.WARNING_MESSAGE);
        	return;
        }
        

        try {
            String idTexto = tela.getTxtId().getText().trim();
            
            

            if (idTexto.isEmpty()) {
                Livros livros = new Livros(titulo, autor, genero, idioma, qtd, preco);
                livrosDAO.salvar(livros);
                JOptionPane.showMessageDialog(tela, "Livro salvo com sucesso.");
            } else {
                Livros livros = new Livros(Integer.parseInt(idTexto), titulo, autor, genero, idioma, qtd, preco);
                livrosDAO.atualizar(livros);
                JOptionPane.showMessageDialog(tela, "Livro atualizado com sucesso.");
            }

            limpar();
            carregarTabela();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                tela,
                "Erro ao salvar: " + e.getMessage(),
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public void excluir() {
        int linha = tela.getTabelaLivros().getSelectedRow();

        if (linha == -1) {
            JOptionPane.showMessageDialog(
                tela,
                "Selecione um cliente na tabela para excluir.",
                "Atenção",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        int confirmacao = JOptionPane.showConfirmDialog(
            tela,
            "Deseja realmente excluir o livro selecionado?",
            "Confirmação",
            JOptionPane.YES_NO_OPTION
        );

        if (confirmacao != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            int id = Integer.parseInt(tela.getTxtId().getText());
            livrosDAO.excluir(id);
            JOptionPane.showMessageDialog(tela, "Livro excluído com sucesso.");
            limpar();
            carregarTabela();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                tela,
                "Erro ao excluir: " + e.getMessage(),
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public void limpar() {
        tela.getTxtId().setText("");
        tela.getTxtTitulo().setText("");
        tela.getTxtAutor().setText("");
        tela.getTxtGenero().setText("");
        tela.getTxtIdioma().setText("");
        tela.getTxtQtd().setText("");
        tela.getTxtPreco().setText("");
        tela.getTxtTitulo().requestFocus();
        tela.getTabelaLivros().clearSelection();
    }

    public void carregarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tela.getTabelaLivros().getModel();
        modelo.setRowCount(0);

        try {
            List<Livros> livros = livrosDAO.listar();

            int i;
            for (i = 0; i < livros.size(); i++) {
                Livros l = livros.get(i);
                modelo.addRow(new Object[] {
                    l.getId(),
                    l.getTitulo(),
                    l.getAutor(),
                    l.getGenero(),
                    l.getIdioma(),
                    l.getQtd(),
                    l.getPreco(),
                });
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                tela,
                "Erro ao carregar tabela: " + e.getMessage(),
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public void preencherFormulario() {
        int linha = tela.getTabelaLivros().getSelectedRow();

        if (linha != -1) {
            tela.getTxtId().setText(tela.getTabelaLivros().getValueAt(linha, 0).toString());
            tela.getTxtTitulo().setText(tela.getTabelaLivros().getValueAt(linha, 1).toString());
            tela.getTxtAutor().setText(tela.getTabelaLivros().getValueAt(linha, 2).toString());
            tela.getTxtGenero().setText(tela.getTabelaLivros().getValueAt(linha, 3).toString());
            tela.getTxtIdioma().setText(tela.getTabelaLivros().getValueAt(linha, 4).toString());
            tela.getTxtQtd().setText(tela.getTabelaLivros().getValueAt(linha, 5).toString());
            tela.getTxtPreco().setText(tela.getTabelaLivros().getValueAt(linha, 6).toString());
           
        }
    }
}
