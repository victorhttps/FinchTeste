package dev.victor.shop.objects;

import dev.victor.shop.database.MySQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Products extends MySQL {

    private String nome;
    private double valor;
    private String tipo;
    private int id;

    public Products(int id) {
        this.id = id;
    }

    public String getNome() {
        PreparedStatement stm = null;
        try {
            stm = con.prepareStatement("SELECT * FROM `product` WHERE `id` = ?");
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {

                return rs.getString("nome");
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }

        return "";
    }

    public String getTipo() {
        PreparedStatement stm = null;
        try {
            stm = con.prepareStatement("SELECT * FROM `product` WHERE `id` = ?");
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {

                return rs.getString("tipo");
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }

        return "";
    }


    public double getValor() {
        PreparedStatement stm = null;
        try {
            stm = con.prepareStatement("SELECT * FROM `product` WHERE `id` = ?");
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {

                return rs.getDouble("valor");
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }

        return 0.0;
    }

    public void getAll() {
        PreparedStatement stm = null;
        try {
            stm = con.prepareStatement("SELECT * FROM `product`");
            ResultSet rs = stm.executeQuery();

            System.out.println("Produtos:");

            while (rs.next()) {
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("Tipo: " + rs.getString("tipo"));
                System.out.println("Valor: " + rs.getDouble("valor"));
                System.out.println("Numero do produto: " + rs.getInt("id"));
                System.out.println("");
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}
