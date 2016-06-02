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
public class JDBCAlunoDAO implements AlunoDAO {

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
            String SQL = "insert into aluno (matriculaaluno, nomealuno, turmaaluno, turnoaluno, responsavel_cpfresponsavel,saldoaluno) values"
                    + "(?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(SQL);

            ps.setString(1, aluno.getMatricula());
            ps.setString(2, aluno.getNome());
            ps.setString(3, aluno.getTurma());
            ps.setString(4, aluno.getTurno());
            ps.setInt(5, Integer.parseInt(aluno.getResponsavel()));
            ps.setInt(6, Integer.parseInt(aluno.getSaldo()));
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
    public List<Aluno> listar(String cpfresponsavel) {

        List<Aluno> alunos = new ArrayList<Aluno>();
        try {
            System.out.println("dentro do jdbc listar" + cpfresponsavel);
            int cpf = Integer.parseInt(cpfresponsavel);
            String SQL = "select * from aluno where responsavel_cpfresponsavel=" + cpf;
            PreparedStatement ps = connection.prepareStatement(SQL);

            //ps.setInt(1, cpf);
//            ps.setString(1, cpfresponsavel);
            //          ps.executeUpdate();
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setMatricula(rs.getString("matriculaaluno"));
                aluno.setNome(rs.getString("nomealuno"));
                aluno.setTurma(rs.getString("turmaaluno"));
                aluno.setTurno(rs.getString("turnoaluno"));
                //            aluno.setResponsavel(rs.getString("responsavel_cpfresponsavel"));
                aluno.setSaldo(rs.getString("saldoaluno"));

                //aluno.getResponsavel()setRua(rs.getString("rua")); // com Responsavel composto de vario valores
                alunos.add(aluno);

            }

            rs.close();
            ps.close();
            return alunos;

        } catch (SQLException ex) {
            Logger.getLogger(JDBCAlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao listar Alunos em JDBC");
        }
    }

    public void realizacompra(String valorstring, String matriculaaluno) {

        //recebe-se valor da compra e matricula do aluno a ser descontado
        Aluno aluno = this.buscar(Integer.parseInt(matriculaaluno));

        String saldostring = aluno.getSaldo();

        if (valorstring == null) {
            valorstring = "0";
        }

        //pega o valor de saldo e valor a ser cobrado e transforma em int
        int valor = Integer.parseInt(valorstring);
        int saldo = Integer.parseInt(saldostring);

        if (saldo > valor) {
            saldo -= valor;
            aluno.setSaldo(String.valueOf(saldo));
            this.editar(aluno);

        } else {
            System.out.println("saldo insuficiente");
            //modificar para uma alerta
        }
        
        

        
//        aluno.setNome(request.getParameter("nome"));
//        aluno.setTurma(request.getParameter("turma"));
//        aluno.setTurno(request.getParameter("turno"));
//        aluno.setResponsavel(request.getParameter("responsavel"));
//        aluno.setLogin(request.getParameter("login"));
//        aluno.setSenha(request.getParameter("senha"));

       

        

    }

    @Override
    public Aluno buscar(int matricula) {
        try {

            Aluno aluno = new Aluno();
            String SQL = "select * from aluno where matriculaaluno = ?";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setInt(1, matricula);
            ResultSet rs = ps.executeQuery();

            rs.next();

            aluno.setMatricula(rs.getString("matriculaaluno"));
            aluno.setNome(rs.getString("nomealuno"));
            aluno.setTurma(rs.getString("turmaaluno"));
            aluno.setTurno(rs.getString("turnoaluno"));
            aluno.setResponsavel(rs.getString("responsavel_cpfresponsavel"));
            aluno.setSaldo(rs.getString("saldoaluno"));

            return aluno;

        } catch (SQLException ex) {
            Logger.getLogger(JDBCAlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Buscar Registro de Responsaveis");
        }
    }

    @Override
    public void editar(Aluno aluno) {
        try {
            //          String SQL = "update aluno set nomealuno=?,"
            //                + " turmaaluno=?, turnoaluno=?, "
            //              + "responsavelaluno=? where matriculaaluno=?;";
            String SQL = "update aluno set saldoaluno=? where matriculaaluno=?;";
            PreparedStatement ps = connection.prepareStatement(SQL);
//            ps.setString(1, aluno.getNome());
//            ps.setString(2, aluno.getTurma());
//            ps.setString(3, aluno.getTurno());
//            ps.setString(4, aluno.getResponsavel());
//            ps.setString(5, aluno.getMatricula());
            ps.setString(1, aluno.getSaldo());
            ps.setString(2, aluno.getMatricula());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCAlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
