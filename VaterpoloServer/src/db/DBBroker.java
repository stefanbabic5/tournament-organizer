/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import domain.AbstractDomainObject;
import domain.Turnir;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author stefan
 */
public class DBBroker {

    private static DBBroker instance;
    private Connection connection;

    private DBBroker() {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("dbconfig.properties"));
            String url = properties.getProperty("url");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");
            connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(false);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static DBBroker getInstance() {
        if (instance == null) {
            instance = new DBBroker();
        }
        return instance;
    }

    public ArrayList<AbstractDomainObject> select(AbstractDomainObject ado) throws SQLException {
        String upit = "SELECT * FROM " + ado.nazivTabele() + " " + ado.alijas()
                + " " + ado.join() + " " + ado.uslov();
        System.out.println("Upit: " + upit);
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery(upit);
        return ado.vratiListu(rs);
    }

    public PreparedStatement insert(AbstractDomainObject ado) throws SQLException {
        String upit = "INSERT INTO " + ado.nazivTabele() + " "
                + ado.koloneZaInsert() + " VALUES(" + ado.vrednostiZaInsert() + ")";
        System.out.println("Upit: " + upit);
        PreparedStatement ps = connection.prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);
        ps.executeUpdate();
        return ps;
    }

    public void update(AbstractDomainObject ado) throws SQLException {
        String upit = "UPDATE " + ado.nazivTabele() + " SET "
                + ado.vrednostiZaUpdate() + " WHERE " + ado.vrednostZaPrimarniKljuc();
        System.out.println("Upit: " + upit);
        Statement s = connection.createStatement();
        s.executeUpdate(upit);
    }

    public void delete(AbstractDomainObject ado) throws SQLException {
        String upit = "DELETE FROM " + ado.nazivTabele() + " WHERE " + ado.vrednostZaPrimarniKljuc();
        System.out.println("Upit: " + upit);
        Statement s = connection.createStatement();
        s.executeUpdate(upit);
    }

    public int getBrojKola(Turnir t) throws SQLException {
        String upit = "SELECT kolo FROM utakmica WHERE pobednikID = 0 and turnirID = " + t.getTurnirID() + " order by kolo limit 1";
        System.out.println("Upit: " + upit);
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery(upit);

        if (rs.next()) {
            return Integer.parseInt(rs.getString("kolo"));
        } else {
            upit = "SELECT MAX(CAST(kolo AS UNSIGNED)) AS kolo FROM utakmica WHERE turnirID = " + t.getTurnirID();
            System.out.println("Upit za poslednje kolo: " + upit);

            rs = s.executeQuery(upit);
            if (rs.next()) {
                return Integer.parseInt(rs.getString("kolo"));
            } else {
                return -1;
            }
        }

    }
}
