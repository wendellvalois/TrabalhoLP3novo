/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cantinasjuquinha.dao;

import br.com.cantinasjuquinha.bean.Responsavel;
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
 * @author wendellvalois
 */
public class JDBCResponsavelDAO implements ResponsavelDAO {

    Connection connection;

    public JDBCResponsavelDAO() {

        connection = ConnectionFactory.getConnection();
    }

    @Override
    public void inserir(Responsavel responsavel) {
        try {
            /*           String SQL = "insert into (nome, cpf, telefone, email, login, senha) values"
                    + "(?,?,?,?,?,?)";
             */
            String SQL = "insert into responsavel (cpfresponsavel, nomeresponsavel, telefoneresponsavel, emailresponsavel, enderecoresponsavel) values"
                    + "(?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(SQL);

            ps.setString(1, responsavel.getCpf());
            ps.setString(2, responsavel.getNome());
            ps.setString(3, responsavel.getTelefone());
            ps.setString(4, responsavel.getEmail());
            ps.setString(5, responsavel.getEndereco());
            //ps.setString(5, responsavel.getLogin());
            //ps.setString(6, responsavel.getSenha());

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCResponsavelDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao inserir Responsavel", ex);
        }

    }

    @Override
    public void remover(int id) {
        try {
            String SQL = "delete from responsavel where id= ?";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setInt(1, id);
            ps.executeUpdate();

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(JDBCResponsavelDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao remover registro de Responsavel", ex);
        }
    }

    @Override
    public List<Responsavel> listar() {
        List<Responsavel> responsaveis = new ArrayList<Responsavel>();
        try {
            String SQL = "select * from responsavel";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Responsavel responsavel = new Responsavel();
                responsavel.setCpf(rs.getString("cpfresponsavel"));
                responsavel.setNome(rs.getString("nomeresponsavel"));
                responsavel.setTelefone(rs.getString("telefoneresponsavel"));
                responsavel.setEmail(rs.getString("emailresponsavel"));
                responsavel.setEndereco(rs.getString("enderecoresponsavel"));

                //responsavel.getEndereco()setRua(rs.getString("rua")); // com Endereco composto de vario valores
                responsaveis.add(responsavel);

            }
            ps.close();
            rs.close();
            return responsaveis;

        } catch (SQLException ex) {
            Logger.getLogger(JDBCResponsavelDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao listar Responsaveis em JDBC");
        }
    }

    @Override
    public Responsavel buscar(int id) {
        try {
            Responsavel responsavel = new Responsavel();
            String SQL = "select * from responsavel where id = ?";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            rs.next();
            responsavel.setNome("nome");
            responsavel.setEndereco("endereco");
            responsavel.setEndereco("endereco");
            responsavel.setEmail("email");

            return responsavel;

        } catch (SQLException ex) {
            Logger.getLogger(JDBCResponsavelDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Buscar Registro de Responsaveis");
        }
    }

    @Override
    public void editar(Responsavel responsavel) {
        try {
            String SQL = "update responsavel set nomeresponsavel=?,"
                    + " telefoneresponsavel=?, emailresponsavel=?, "
                    + "enderecoresponsavel=? where cpfresponsavel=?;";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setString(1, responsavel.getNome());
            ps.setString(2, responsavel.getTelefone());
            ps.setString(3, responsavel.getEmail());
            ps.setString(4, responsavel.getEndereco());
            ps.setString(5, responsavel.getCpf());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCResponsavelDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
