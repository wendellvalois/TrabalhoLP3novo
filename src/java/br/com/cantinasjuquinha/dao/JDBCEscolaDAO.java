/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cantinasjuquinha.dao;

import br.com.cantinasjuquinha.bean.Escola;
import br.com.cantinasjuquinha.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Danilo
 */
public class JDBCEscolaDAO implements EscolaDAO {

    Connection connection;

    public JDBCEscolaDAO() {

        connection = ConnectionFactory.getConnection();
    }

    @Override
    public void inserir(Escola escola) {
        try {
            /*           String SQL = "insert into (nome, matricula, telefone, email, login, senha) values"
                    + "(?,?,?,?,?,?)";
             */
            String SQL = "insert into escola (matriculaescola, nomeescola, telefoneescola, emailescola, enderecoescola) values"
                    + "(?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(SQL);

            ps.setString(1, escola.getmatriculaEscola());
            ps.setString(2, escola.getnomeEscola());
            ps.setString(3, escola.getenderecoEscola());
            ps.setString(4, escola.gettelefoneEscola());
            ps.setString(5, escola.getemailEscola());
            ps.setString(5, escola.getFuncionario());
            //ps.setString(5, escola.getLogin());
            //ps.setString(6, escola.getSenha());

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCEscolaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao inserir Escola", ex);
        }

    }

    @Override
    public void excluir(String matricula) {
        try {
            String SQL = "delete from escola where matriculaescola= ?";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setString(1, matricula);
            ps.executeUpdate();

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(JDBCEscolaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao remover registro de Escola", ex);
        }
    }

    @Override
    public List<Escola> listar() {
        List<Escola> responsaveis = new ArrayList<Escola>();
        try {
            String SQL = "select * from escola";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Escola escola = new Escola();
                escola.setmatriculaEscola(rs.getString("matriculaescola"));
                escola.setnomeEscola(rs.getString("nomeescola"));
                escola.setenderecoEscola(rs.getString("enderecoescola"));
                escola.settelefoneEscola(rs.getString("telefoneescola"));
                escola.setemailEscola(rs.getString("emailescola"));
                escola.setFuncionario(rs.getString("funcionario"));

                //escola.getEndereco()setRua(rs.getString("rua")); // com Endereco composto de vario valores
                responsaveis.add(escola);

            }
            ps.close();
            rs.close();
            return responsaveis;

        } catch (SQLException ex) {
            Logger.getLogger(JDBCEscolaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao listar Responsaveis em JDBC");
        }
    }

    @Override
    public Escola buscar(int matriculaescola) {
        try {
            Escola escola = new Escola();
            String SQL = "select * from escola where matriculaescola = ?";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            rs.next();
            escola.setnomeEscola("nome");
            escola.setenderecoEscola("enderecoescola");
            escola.settelefoneEscola("telefonescola");
            escola.setemailEscola("emailescola");

            return escola;

        } catch (SQLException ex) {
            Logger.getLogger(JDBCEscolaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Buscar Registro de Responsaveis");
        }
    }

    @Override
    public void editar(Escola escola) {
        try {
            String SQL = "update escola set nomeescola=?,"
                    + " telefoneescola=?, emailescola=?, "
                    + "enderecoescola=? where matriculaescola=?;";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setString(1, escola.getnomeEscola());
            ps.setString(2, escola.getenderecoEscola());
            ps.setString(3, escola.getemailEscola());
            ps.setString(4, escola.gettelefoneEscola());
            ps.setString(5, escola.getmatriculaEscola());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCEscolaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
