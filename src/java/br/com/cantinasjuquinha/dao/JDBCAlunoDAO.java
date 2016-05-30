/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cantinasjuquinha.dao;

import br.com.cantinasjuquinha.bean.Aluno;
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
public class JDBCAlunoDAO implements AlunoDAO{


    Connection connection;

    public JDBCAlunoDAO() {

        connection = ConnectionFactory.getConnection();
    }

    @Override
    public void inserir(Aluno aluno) {
        try {
            /*           String SQL = "insert into (nome, cpf, telefone, email, login, senha) values"
                    + "(?,?,?,?,?,?)";
             */
            String SQL = "insert into aluno (matriculaaluno, nomealuno, turmaaluno, turnoaluno, responsavel_cpfresponsavel) values"
                    + "(?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(SQL);

            ps.setString(1, aluno.getMatricula());
            ps.setString(2, aluno.getNome());
            ps.setString(3, aluno.getTurma());
            ps.setString(4, aluno.getTurno());
            ps.setInt(5, Integer.parseInt(aluno.getResponsavel()));
            //ps.setString(5, aluno.getLogin());
            //ps.setString(6, aluno.getSenha());

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCAlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao inserir Aluno", ex);
        }

    }

    @Override
    public void excluir(String cpf) {
        try {
            String SQL = "delete from aluno where matriculaaluno= ?";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setString(1, cpf);
            ps.executeUpdate();

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(JDBCAlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao remover registro de Aluno", ex);
        }
    }

    @Override
    public List<Aluno> listar() {
        List<Aluno> alunos = new ArrayList<Aluno>();
        try {
            String SQL = "select * from aluno";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setMatricula(rs.getString("matriculaaluno"));
                aluno.setNome(rs.getString("nomealuno"));
                aluno.setTurma(rs.getString("turmaaluno"));
                aluno.setTurno(rs.getString("turnoaluno"));
                aluno.setResponsavel(rs.getString("responsavelaluno"));

                //aluno.getResponsavel()setRua(rs.getString("rua")); // com Responsavel composto de vario valores
                alunos.add(aluno);

            }
            ps.close();
            rs.close();
            return alunos;

        } catch (SQLException ex) {
            Logger.getLogger(JDBCAlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao listar Responsaveis em JDBC");
        }
    }

    @Override
    public Aluno buscar(int id) {
        try {
            Aluno aluno = new Aluno();
            String SQL = "select * from aluno where id = ?";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            rs.next();
            aluno.setNome("nome");
            aluno.setResponsavel("endereco");
            aluno.setResponsavel("endereco");
            aluno.setTurno("email");

            return aluno;

        } catch (SQLException ex) {
            Logger.getLogger(JDBCAlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Buscar Registro de Responsaveis");
        }
    }

    @Override
    public void editar(Aluno aluno) {
        try {
            String SQL = "update aluno set nomealuno=?,"
                    + " turmaaluno=?, turnoaluno=?, "
                    + "responsavelaluno=? where matriculaaluno=?;";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getTurma());
            ps.setString(3, aluno.getTurno());
            ps.setString(4, aluno.getResponsavel());
            ps.setString(5, aluno.getMatricula());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCAlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
