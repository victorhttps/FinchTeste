package dev.victor.shop.objects;

import dev.victor.shop.database.MySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Cart extends MySQL {
    private int id_owner;
    private int id_product;
    private double valor;

    public Cart(int id_owner, int id_product, double valor) {
        this.id_owner = id_owner;
        this.id_product = id_product;
        this.valor = valor;
    }

    public int getId_owner() {
        return id_owner;
    }

    public int getId_product() {
        return id_product;
    }

    public void addCart(){

        try
        {
            PreparedStatement ps = null;

                ps = con.prepareStatement("INSERT INTO `cart`(`id`, `id_owner`, `id_product`, `valor`) VALUES(?, ?, ?, ?)");
                ps.setInt(1, (int)Math.random());
                ps.setInt(2, id_owner);
                ps.setInt(3, id_product);
                ps.setDouble(4, valor);

                ps.executeUpdate();

        }
        catch (SQLException ev)
        {
            ev.printStackTrace();
        }
    }
}
