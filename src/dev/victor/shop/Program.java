package dev.victor.shop;

import dev.victor.shop.database.MySQL;
import dev.victor.shop.objects.Cart;
import dev.victor.shop.objects.Products;
import dev.victor.shop.objects.User;
import dev.victor.shop.objects.UserLogin;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Program extends MySQL {

    public static void mysql() {
        MySQL.open();
    }

    public static void main(String[] args) {
        mysql();
        Scanner sc = new Scanner(System.in);


        System.out.println("Logar: ");
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();

        User user = new User(email, senha);
        if (user.checkLogin()) {
            System.out.println("Opções:");
            System.out.println("0 para ver produtos/adicionar");
            System.out.println("1 para ver carrinho");
            System.out.print(": ");

            int resp = sc.nextInt();
            switch (resp) {
                case 0:
                    Products products = new Products(0);
                    products.getAll();
                    System.out.print("Digite o numero do produto que deseja adicionar ao carrinho: ");
                    int n = sc.nextInt();
                    System.out.println();
                    Products p = new Products(n);

                    Cart cart = new Cart(UserLogin.id, n, p.getValor());
                    cart.addCart();
                    break;
                case 1:

                    PreparedStatement stm = null;
                    try {
                        stm = con.prepareStatement("SELECT * FROM `cart` WHERE id_owner = ?");
                        stm.setInt(1, UserLogin.id);
                        ResultSet rs = stm.executeQuery();

                        System.out.println("Produtos:");
                        double soma = 0;

                        while (rs.next()) {
                            Products p2 = new Products(rs.getInt("id_product"));
                            System.out.println("Nome: " + p2.getNome());
                            System.out.println("Tipo: " + p2.getTipo());
                            System.out.println("Valor: " + p2.getValor());
                            System.out.println("");
                            soma += p2.getValor();
                        }
                        System.out.println("Valor Final: " + soma);
                    } catch (SQLException e) {

                        e.printStackTrace();
                    }

                    break;
                default:

            }

        } else {
            System.out.println("Senha incorreta");
        }
    }
}


