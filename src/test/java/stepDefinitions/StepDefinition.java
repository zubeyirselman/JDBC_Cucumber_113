package stepDefinitions;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import utilities.JDBCReusableMethods;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertEquals;

public class StepDefinition {

    String query;
    ResultSet rs;
    int flag;

    @Given("Database baglantisi kurulur.")
    public void database_baglantisi_kurulur() {
        JDBCReusableMethods.createConnection();
    }

    @Given("Query hazirlanir.")
    public void query_hazirlanir() {
        query = "select charge_id from heallife_hospitaltraining.ambulance_call where patient_id=1 and driver='Smith';";
    }
    @Given("Query calistirilir ve sonuclari alinir.")
    public void query_calistirilir_ve_sonuclari_alinir() {
        Statement st = JDBCReusableMethods.getStatement();
        rs = JDBCReusableMethods.executeQuery(query);
    }

    @Given("Query sonuclari dogrulanir.")
    public void query_sonuclari_dogrulanir() throws SQLException {
        int expectedData = 2;
        while (rs.next()){
            flag++;
        }
        assertEquals(expectedData,flag);
    }
    @Given("Database baglantisi kapatilir.")
    public void database_baglantisi_kapatilir() {
        JDBCReusableMethods.closeConnection();
    }
}
