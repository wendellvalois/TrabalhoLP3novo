/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cantinasjuquinha.dao;

import br.com.cantinasjuquinha.bean.Compra;
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
public class JDBCCompraDAO implements CompraDAO {

    Connection connection;

    public JDBCCompraDAO() {

        connection = ConnectionFactory.getConnection();
    }

    @Override
    public void inserir(Compra compra) {
        try {
            /*           String SQL = "insert into (nome, cpf, telefone, email, login, senha) values"
                    + "(?,?,?,?,?,?)";
             */
            
//            java.util.Date date = new Date();
//            Object param = new java.sql.Timestamp(date.getTime());
//// The JDBC driver knows what to do with a java.sql type:
//            preparedStatement.setObject(param);

            String SQL = "insert into compra ( `quantidade`, `aluno_matriculaaluno`, `codigoproduto`) values"
                    + "(?,?,?)";
            PreparedStatement ps = connection.prepareStatement(SQL);

           // ps.setString(1, compra.getIdcompra());
            ps.setString(1, compra.getQuantidade());
            ps.setString(2, compra.getAluno_matriculaaluno());
            ps.setString(3, compra.getCodigoproduto());

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCCompraDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao inserir Compra", ex);
        }

    }

    @Override
    public void excluir(String cpf) {
        try {

            String SQL = "delete from user where compra_cpfcompra= ?";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setString(1, cpf);
            ps.executeUpdate();

            SQL = "delete from compra where cpfcompra= ?";
            ps = connection.prepareStatement(SQL);
            ps.setString(1, cpf);
            ps.executeUpdate();

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(JDBCCompraDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao remover registro de Compra", ex);
        }
    }

    @Override
    public List<Compra> listar() {
        List<Compra> responsaveis = new ArrayList<Compra>();
        try {
            String SQL = "select * from compra";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Compra compra = new Compra();
                
//                
//                compra.setCpf(rs.getString("cpfcompra"));
//                compra.setNome(rs.getString("nomecompra"));
//                compra.setTelefone(rs.getString("telefonecompra"));
//                compra.setEmail(rs.getString("emailcompra"));
//                compra.setEndereco(rs.getString("enderecocompra"));

                //compra.getEndereco()setRua(rs.getString("rua")); // com Endereco composto de vario valores
                responsaveis.add(compra);

            }
            ps.close();
            rs.close();
            return responsaveis;

        } catch (SQLException ex) {
            Logger.getLogger(JDBCCompraDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao listar Responsaveis em JDBC");
        }
    }

    @Override
    public Compra buscar(int cpf) {
        try {
            Compra compra = new Compra();
            String SQL = "select * from compra where cpfcompra = ?";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setInt(1, cpf);
            ResultSet rs = ps.executeQuery();

            rs.next();
            /*
            compra.setNome("nome");
            compra.setEndereco("endereco");
            compra.setEndereco("endereco");
            compra.setEmail("email");
             */

//            compra.setCpf(rs.getString("cpfcompra"));
//            compra.setNome(rs.getString("nomecompra"));
//            compra.setTelefone(rs.getString("telefonecompra"));
//            compra.setEmail(rs.getString("emailcompra"));
//            compra.setEndereco(rs.getString("enderecocompra"));

            return compra;

        } catch (SQLException ex) {
            Logger.getLogger(JDBCCompraDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Buscar Registro de Responsaveis");
        }
    }

    @Override
    public void editar(Compra compra) {
        try {
            String SQL = "update compra set nomecompra=?,"
                    + " telefonecompra=?, emailcompra=?, "
                    + "enderecocompra=? where cpfcompra=?;";
            PreparedStatement ps = connection.prepareStatement(SQL);
//            ps.setString(1, compra.getNome());
//            ps.setString(2, compra.getTelefone());
//            ps.setString(3, compra.getEmail());
//            ps.setString(4, compra.getEndereco());
//            ps.setString(5, compra.getCpf());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCCompraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
