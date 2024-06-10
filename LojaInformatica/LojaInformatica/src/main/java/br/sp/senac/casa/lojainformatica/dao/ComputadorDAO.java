package br.sp.senac.casa.lojainformatica.dao;

import br.sp.senac.casa.lojainformatica.classes.Computador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author skaio
 */
public class ComputadorDAO {
    // Criar URL para o DB: 

    static String URL = "jdbc:mysql://localhost:3306/lojainformatica";
    static String login = "root";
    static String senha = "58725997";

    // Método Salvar, 
    public static boolean salvar(Computador obj) {
        Connection conexao = null;
        boolean retorno = false;
        try {
            // 1-Carregando o driver do mysql:
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2- Fazendo a conexão com o DB: 
            conexao = DriverManager.getConnection(URL, login, senha);

            //3- Preparando o comando SQL
            PreparedStatement instrucaoSQL = conexao.prepareStatement(
                    "INSERT INTO computador (marcaComputador,hdComputador, processadorComputador) VALUES (?,?,?);");

            // instrucaoSQL.setString(1, obj.getMarca());   // ********* Mudar**********
            instrucaoSQL.setString(1, obj.getMarca());
            instrucaoSQL.setString(2, obj.getHd());
            instrucaoSQL.setString(3, obj.getProcessador());

            // 4- Executar o comando:
            int linhasAfetadas = instrucaoSQL.executeUpdate();
            if (linhasAfetadas > 0) {
                retorno = true;
            }
            // Caso não rode por não encontrar a classe, irá exibir a mensagem de erro no catch abaixo: 

        } catch (ClassNotFoundException e) {
            System.out.println("Driver MySQL não encontrado!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();

                } catch (SQLException ex) {
                    Logger.getLogger(ComputadorDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return retorno;

    }

    public static ArrayList<Computador> listar() {
        ArrayList<Computador> listaRetorno = new ArrayList<>();
        Connection conexao = null;
        ResultSet rs = null;

        try {
            // 1-Carregando o driver do mysql:
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2- Fazendo a conexão com o DB: 
            conexao = DriverManager.getConnection(URL, login, senha);

            //3- Preparando o comando SQL
            PreparedStatement instrucaoSQL = conexao.prepareStatement(
                    "SELECT * FROM Computador");

            //4- Executar o comando: 
            rs = instrucaoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {

                    String marca = rs.getString("marcaComputador");
                    String hd = rs.getString("hdComputador");
                    String processador = rs.getString("processadorComputador");
                    Computador item = new Computador(marca, hd, processador);
                    listaRetorno.add(item);

                }
            }

        } catch (Exception e) {
            listaRetorno = null;
        } finally {

            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ComputadorDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ComputadorDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return listaRetorno;

    }

    //Depois vamos ligar a DAO com a tela de Computador (telaComputadores)
}
