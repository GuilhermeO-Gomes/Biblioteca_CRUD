package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Livros;
import util.Conexao;

public class LivrosDAO {

    public void salvar(Livros livros) {
        Connection conn = null;
        PreparedStatement stmt = null;

        String sql = "INSERT INTO livros (titulo, autor, genero, idioma, qtd, preco) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            conn = Conexao.conectar();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, livros.getTitulo());
            stmt.setString(2, livros.getAutor());
            stmt.setString(3, livros.getGenero());
            stmt.setString(4, livros.getIdioma());
            stmt.setInt(5, livros.getQtd());
            stmt.setDouble(6, livros.getPreco());
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar livro: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void atualizar(Livros livros) {
        Connection conn = null;
        PreparedStatement stmt = null;

        String sql = "UPDATE livros SET titulo = ?, autor = ?, genero = ?, idioma = ?, qtd = ?,preco = ?, WHERE id = ?";

        try {
            conn = Conexao.conectar();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, livros.getTitulo());
            stmt.setString(2, livros.getAutor());
            stmt.setString(3, livros.getGenero());
            stmt.setString(4, livros.getIdioma());
            stmt.setInt(5, livros.getQtd());
            stmt.setDouble(6, livros.getPreco());
            stmt.setInt(7, livros.getId());
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar livro: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void excluir(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;

        String sql = "DELETE FROM livros WHERE id = ?";

        try {
            conn = Conexao.conectar();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao excluir livro: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<Livros> listar() {
        List<Livros> lista = new ArrayList<Livros>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT id, titulo, autor, genero, idioma, qtd, preco FROM livros ORDER BY id DESC";

        try {
            conn = Conexao.conectar();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Livros livros = new Livros();
                livros.setId(rs.getInt("id"));
                livros.setTitulo(rs.getString("titulo"));
                livros.setAutor(rs.getString("autor"));
                livros.setGenero(rs.getString("genero"));
                livros.setIdioma(rs.getString("idioma"));
                livros.setQtd(rs.getInt("qtd"));
                livros.setPreco(rs.getDouble("preco"));
                lista.add(livros);
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar livros: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return lista;
    }
}