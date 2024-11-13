/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author stefan
 */
public class Tabela extends AbstractDomainObject {

    private Turnir turnir;
    private Tim tim;
    private int homeWins;
    private int homeWinsPenalty;
    private int homeLossesPenalty;
    private int homeLosses;
    private int awayWins;
    private int awayWinsPenalty;
    private int awayLossesPenalty;
    private int awayLosses;
    private int scoredHome;
    private int allowedHome;
    private int scoredAway;
    private int allowedAway;
    private int pointsHome;
    private int pointsAway;

    public Tabela() {
    }

    public Tabela(Turnir turnir, Tim tim, int homeWins, int homeWinsPenalty, int homeLossesPenalty, int homeLosses, int awayWins, int awayWinsPenalty, int awayLossesPenalty, int awayLosses, int scoredHome, int allowedHome, int scoredAway, int allowedAway, int pointsHome, int pointsAway) {
        this.turnir = turnir;
        this.tim = tim;
        this.homeWins = homeWins;
        this.homeWinsPenalty = homeWinsPenalty;
        this.homeLossesPenalty = homeLossesPenalty;
        this.homeLosses = homeLosses;
        this.awayWins = awayWins;
        this.awayWinsPenalty = awayWinsPenalty;
        this.awayLossesPenalty = awayLossesPenalty;
        this.awayLosses = awayLosses;
        this.scoredHome = scoredHome;
        this.allowedHome = allowedHome;
        this.scoredAway = scoredAway;
        this.allowedAway = allowedAway;
        this.pointsHome = pointsHome;
        this.pointsAway = pointsAway;
    }

    public int getPointsHome() {
        return pointsHome;
    }

    public void setPointsHome(int pointsHome) {
        this.pointsHome = pointsHome;
    }

    public int getPointsAway() {
        return pointsAway;
    }

    public void setPointsAway(int pointsAway) {
        this.pointsAway = pointsAway;
    }

    public Turnir getTurnir() {
        return turnir;
    }

    public void setTurnir(Turnir turnir) {
        this.turnir = turnir;
    }

    public Tim getTim() {
        return tim;
    }

    public void setTim(Tim tim) {
        this.tim = tim;
    }

    public int getHomeWins() {
        return homeWins;
    }

    public void setHomeWins(int homeWins) {
        this.homeWins = homeWins;
    }

    public int getHomeWinsPenalty() {
        return homeWinsPenalty;
    }

    public void setHomeWinsPenalty(int homeWinsPenalty) {
        this.homeWinsPenalty = homeWinsPenalty;
    }

    public int getHomeLossesPenalty() {
        return homeLossesPenalty;
    }

    public void setHomeLossesPenalty(int homeLossesPenalty) {
        this.homeLossesPenalty = homeLossesPenalty;
    }

    public int getHomeLosses() {
        return homeLosses;
    }

    public void setHomeLosses(int homeLosses) {
        this.homeLosses = homeLosses;
    }

    public int getAwayWins() {
        return awayWins;
    }

    public void setAwayWins(int awayWins) {
        this.awayWins = awayWins;
    }

    public int getAwayWinsPenalty() {
        return awayWinsPenalty;
    }

    public void setAwayWinsPenalty(int awayWinsPenalty) {
        this.awayWinsPenalty = awayWinsPenalty;
    }

    public int getAwayLossesPenalty() {
        return awayLossesPenalty;
    }

    public void setAwayLossesPenalty(int awayLossesPenalty) {
        this.awayLossesPenalty = awayLossesPenalty;
    }

    public int getAwayLosses() {
        return awayLosses;
    }

    public void setAwayLosses(int awayLosses) {
        this.awayLosses = awayLosses;
    }

    public int getScoredHome() {
        return scoredHome;
    }

    public void setScoredHome(int scoredHome) {
        this.scoredHome = scoredHome;
    }

    public int getAllowedHome() {
        return allowedHome;
    }

    public void setAllowedHome(int allowedHome) {
        this.allowedHome = allowedHome;
    }

    public int getScoredAway() {
        return scoredAway;
    }

    public void setScoredAway(int scoredAway) {
        this.scoredAway = scoredAway;
    }

    public int getAllowedAway() {
        return allowedAway;
    }

    public void setAllowedAway(int allowedAway) {
        this.allowedAway = allowedAway;
    }

    @Override
    public String nazivTabele() {
        return " Tabela ";
    }

    @Override
    public String alijas() {
        return " st ";
    }

    @Override
    public String join() {
        return " JOIN TIM T ON (T.TIMID = ST.TIMID) "
                + "JOIN TURNIR TUR ON (TUR.TURNIRID = ST.TURNIRID) "
                + "JOIN GRAD G ON (G.GRADID = T.GRADID) "
                + "JOIN ADMINISTRATOR A ON (A.ADMINISTRATORID=TUR.ADMINISTRATORID) ";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {

            Grad g = new Grad(rs.getLong("GradID"), rs.getString("NazivGrada"));

            Tim t = new Tim(rs.getLong("TimID"), rs.getString("NazivTima"), g, null);

            Administrator a = new Administrator(rs.getLong("AdministratorID"),
                    rs.getString("Ime"), rs.getString("Prezime"),
                    rs.getString("Username"), rs.getString("Password"));

            Turnir turnir = new Turnir(rs.getLong("turnirID"), rs.getString("nazivTurnira"),
                    rs.getDate("datumPocetka"), rs.getDate("datumKraja"), rs.getString("tipTurnira"),
                    rs.getString("pobednik"), g, a, null, null);
            
            Tabela st = new Tabela(turnir, t, rs.getInt("homeWins"), rs.getInt("homeWinsPenalty"),
                    rs.getInt("homeLossesPenalty"), rs.getInt("homeLosses"), rs.getInt("awayWins"), 
                    rs.getInt("awayWinsPenalty"), rs.getInt("awayLossesPenalty"), rs.getInt("awayLosses"), 
                    rs.getInt("scoredHome"), rs.getInt("allowedHome"), rs.getInt("scoredAway"), rs.getInt("allowedAway"), rs.getInt("pointsHome"), rs.getInt("pointsAway"));
            
            lista.add(st);
        }

        rs.close();
        return lista;
    }
    
    @Override
    public String koloneZaSelect() {
        return " * FROM ";
    }

    @Override
    public String koloneZaInsert() {
        return " (turnirID, timID, homeWins, homeWinsPenalty, homeLossesPenalty, homeLosses,"
                + " awayWins, awayWinsPenalty, awayLossesPenalty, awayLosses, "
                + "scoredHome, allowedHome, scoredAway, allowedAway, pointsHome, pointsAway) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " turnirID = " + turnir.getTurnirID() + " and timID = " + tim.getTimID() + " ";
    }

    @Override
    public String vrednostiZaInsert() {
        return " " + turnir.getTurnirID() + ", "
                + tim.getTimID() + ", "
                + homeWins + ", "
                + homeWinsPenalty + ", "
                + homeLossesPenalty + ", "
                + homeLosses + ", "
                + awayWins + ", "
                + awayWinsPenalty + ", "
                + awayLossesPenalty + ", "
                + awayLosses + ", "
                + scoredHome + ", "
                + allowedHome + ", "
                + scoredAway + ", "
                + allowedAway + ", "
                + pointsHome + ", "
                + pointsAway;
    }

    @Override
    public String vrednostiZaUpdate() {
        return " homeWins = " + homeWins + ", "
                + "homeWinsPenalty = " + homeWinsPenalty + ", "
                + "homeLossesPenalty = " + homeLossesPenalty + ", "
                + "homeLosses = " + homeLosses + ", "
                + "awayWins = " + awayWins + ", "
                + "awayWinsPenalty = " + awayWinsPenalty + ", "
                + "awayLossesPenalty = " + awayLossesPenalty + ", "
                + "awayLosses = " + awayLosses + ", "
                + "scoredHome = " + scoredHome + ", "
                + "allowedHome = " + allowedHome + ", "
                + "scoredAway = " + scoredAway + ", "
                + "allowedAway = " + allowedAway + ", "
                + "pointsHome = " + pointsHome + ", "
                + "pointsAway = " + pointsAway;
    }

    @Override
    public String uslov() {
        return "where st.turnirid = " + turnir.getTurnirID() + " order by (pointsHome + pointsAway) desc, (scoredHome + scoredAway - allowedHome - allowedAway) DESC ";
    }
}
