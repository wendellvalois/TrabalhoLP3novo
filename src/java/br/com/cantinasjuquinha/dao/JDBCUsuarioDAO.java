/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cantinasjuquinha.dao;

import br.com.cantinasjuquinha.bean.Usuario;
import br.com.cantinasjuquinha.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wendellvalois
 */
public class JDBCUsuarioDAO implements UsuarioDAO {

    Connection connection;

    public JDBCUsuarioDAO() {

        connection = ConnectionFactory.getConnection();
    }

    @Override
    public void inserir(Usuario usuario) {
        try {
            /*           String SQL = "insert into (nome, cpf, telefone, email, usuario, senha) values"
                    + "(?,?,?,?,?,?)";
             */
            String SQL = "insert into user(username, password, funcionario_cpffuncionario, responsavel_cpfresponsavel, aluno_matriculaaluno) values"
                    + "(?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(SQL);

            ps.setString(1, usuario.getLogin());
            ps.setString(2, usuario.getSenha());

            if (usuario.getCpfFuncionario() == null) {
                ps.setNull(3, Types.NULL);
            } else {
                ps.setInt(3, Integer.parseInt(usuario.getCpfFuncionario()));
            }
            
            if (usuario.getCpfResponsavel() == null) {
                ps.setNull(4, Types.NULL);
            } else {
                ps.setInt(4, Integer.parseInt(usuario.getCpfResponsavel()));
            }
            
            if (usuario.getMatriculaAluno() == null) {
                ps.setNull(5, Types.NULL);
            } else {
                ps.setInt(5, Integer.parseInt(usuario.getMatriculaAluno()));
            }

            //ps.setInt(3, Integer.parseInt(usuario.getCpfFuncionario()));
            //ps.setInt(4, Integer.parseInt(usuario.getCpfResponsavel()));
            //ps.setInt(5, Integer.parseInt(usuario.getMatriculaAluno()));
            System.out.println(usuario.getCpfFuncionario() + usuario.getCpfResponsavel() + usuario.getMatriculaAluno());

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao inserir Login", ex);
        }
    }

    @Override
    public void excluir(String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario buscar(String login) {
    try {
            Usuario usuario = new Usuario();
            String SQL = "select * from user where username = ?";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();

            rs.next();
            /*
            usuario.setNome("nome");
            usuario.setEndereco("endereco");
            usuario.setEndereco("endereco");
            usuario.setEmail("email");
            */
                            
                usuario.setLogin(rs.getString("username"));
                usuario.setSenha(rs.getString("password"));
                usuario.setCpfFuncionario(rs.getString("funcionario_cpffuncionario"));
                usuario.setCpfResponsavel(rs.getString("responsavel_cpfresponsavel"));
                usuario.setMatriculaAluno(rs.getString("aluno_matriculaaluno"));

            return usuario;

        } catch (SQLException ex) {
            Logger.getLogger(JDBCUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Buscar Registro de Responsaveis");
        }    
    }

    @Override
    public void editar(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
