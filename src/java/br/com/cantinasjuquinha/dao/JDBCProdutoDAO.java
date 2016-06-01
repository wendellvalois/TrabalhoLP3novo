/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cantinasjuquinha.dao;

import br.com.cantinasjuquinha.bean.Produto;
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
public class JDBCProdutoDAO implements ProdutoDAO {

    Connection connection;

    public JDBCProdutoDAO() {

        connection = ConnectionFactory.getConnection();
    }

    @Override
    public void inserir(Produto produto) {
        try {
            /*           String SQL = "insert into (nome, cpf, telefone, email, login, senha) values"
                    + "(?,?,?,?,?,?)";
            
            INSERT INTO `cantinadb`.`produto` (`codigoproduto`, `precoproduto`, 
            `nomeproduto`, `fornecedorproduto`) VALUES ('2422', '5', 'suco de uva', 'cajuba');

             */
            String SQL = "insert into produto (codigoproduto, precoproduto, "
                    + "nomeproduto, fornecedorproduto, ingredientesproduto) values"
                    + "(?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(SQL);

//    private String codigoproduto;
//    private String precoproduto;
//    private String nomeproduto;
//    private String valorproduto;
//    private String fornecedorproduto;
//    private String ingredientesproduto;
            ps.setString(1, produto.getCodigoproduto());
            
            ps.setString(2, produto.getPrecoproduto());
            ps.setString(3, produto.getNomeproduto());
            ps.setString(4, produto.getFornecedorproduto());
            ps.setString(5, produto.getIngredientesproduto());
            //ps.setString(6, produto.getSenha());

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao inserir Produto", ex);
        }

    }

    @Override
    public void excluir(String cpf) {
        try {
            String SQL = "delete from produto where cpfproduto= ?";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setString(1, cpf);
            ps.executeUpdate();

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(JDBCProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao remover registro de Produto", ex);
        }
    }

    @Override
    public List<Produto> listar() {
        List<Produto> responsaveis = new ArrayList<Produto>();
        try {
            String SQL = "select * from produto";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Produto produto = new Produto();

                ps.setString(1, produto.getCodigoproduto());
                ps.setString(2, produto.getPrecoproduto());
                ps.setString(3, produto.getNomeproduto());
                ps.setString(4, produto.getFornecedorproduto());
                ps.setString(5, produto.getIngredientesproduto());

                produto.setCodigoproduto(rs.getString("codigo"));
                produto.setPrecoproduto(rs.getString("preco"));
                produto.setNomeproduto(rs.getString("nome"));
                produto.setFornecedorproduto(rs.getString("fornecedor"));
                produto.setIngredientesproduto(rs.getString("ingredientes"));

                responsaveis.add(produto);

            }
            ps.close();
            rs.close();
            return responsaveis;

        } catch (SQLException ex) {
            Logger.getLogger(JDBCProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao listar Responsaveis em JDBC");
        }
    }

    @Override
    public Produto buscar(int cpf) {
        try {
            Produto produto = new Produto();
            String SQL = "select * from produto where cpfproduto = ?";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setInt(1, cpf);
            ResultSet rs = ps.executeQuery();

            rs.next();
            /*
            produto.setNome("nome");
            produto.setEndereco("endereco");
            produto.setEndereco("endereco");
            produto.setEmail("email");
             */

            produto.setCodigoproduto(rs.getString("codigo"));
            produto.setPrecoproduto(rs.getString("preco"));
            produto.setNomeproduto(rs.getString("nome"));
            produto.setFornecedorproduto(rs.getString("fornecedor"));
            produto.setIngredientesproduto(rs.getString("ingredientes"));

            return produto;

        } catch (SQLException ex) {
            Logger.getLogger(JDBCProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Buscar Registro de Responsaveis");
        }
    }

    @Override
    public void editar(Produto produto) {
        try {
            String SQL = "update produto set precoproduto=?,"
                    + " nomeproduto=?,  "
                    + "fornecedorproduto=?, ingredientesproduto=? "
                    + "where cpfproduto=?;";
            PreparedStatement ps = connection.prepareStatement(SQL);

            ps.setString(1, produto.getPrecoproduto());
            ps.setString(2, produto.getNomeproduto());
            ps.setString(4, produto.getFornecedorproduto());
            ps.setString(5, produto.getIngredientesproduto());
            ps.setString(6, produto.getCodigoproduto());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
