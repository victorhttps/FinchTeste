package dev.victor.shop.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class MySQL {
    protected static Connection con = null;

    public static void open() {
        String url = "jdbc:mysql://localhost:8090/shop";
        String user = "root";
        String password = "";
        try {
            con = DriverManager.getConnection(url, user, password);
            // System.out.println("Conexao com MySQL aberta");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected static void close() {
        if (con != null) {
            try {
                con.close();
                System.out.println("Conexao fechada com sucesso!");
            } catch (SQLException e) {
                System.out.println("Não foi possivel fechar a conexao!");
            }
        }
    }
}