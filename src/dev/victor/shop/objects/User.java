package dev.victor.shop.objects;

import dev.victor.shop.database.MySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User extends MySQL {
    private String email;
    private String senha;
    private String nome;

    public User(String email, String senha) {
        this.email = email;
        this.senha = senha;

    }

    public String getNome() {
        PreparedStatement stm = null;
        try {
            stm = con.prepareStatement("SELECT * FROM `users` WHERE `email` = ?");
            stm.setString(1, email);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {

                return rs.getString("nome");
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }

        return "";
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }


    public boolean checkLogin() {
        PreparedStatement stm = null;

        try {
            stm = con.prepareStatement("SELECT * FROM `users` WHERE `email` = ?");
            stm.setString(1, email);
            ResultSet rs = stm.executeQuery();
            if (rs.next() && rs.getString("senha").equalsIgnoreCase(senha)) {
                UserLogin.id = rs.getInt("id");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
