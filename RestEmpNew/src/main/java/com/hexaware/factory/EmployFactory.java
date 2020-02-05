package com.hexaware.factory;

//import com.hexaware.cms.persistence.OrdersDAO;
import com.hexaware.persistence.DbConnection;
import java.util.List;
import com.hexaware.model.Employ;
import com.hexaware.persistence.EmployDAO;
public class EmployFactory {
     /**
   *  Protected constructor.
   */
  protected EmployFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static EmployDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(EmployDAO.class);
  }
  /**
   * Call the data base connection.
   * @return the array of Employ object.
   */
    public static Employ[] showEmploy() {
    List<Employ> employees = dao().show();
    return employees.toArray(new 
      Employ[employees.size()]);
  }

  /**
   * Call the Show Employ to Search Data.
   * @return the Employ object.
   */
    public static Employ showEmploy(int empno) {
    Employ employ = dao().show(empno);
    return employ;
  }

  /**
   * AddEmploy .
   * @return the array of Employ object.
   */
    public static String addEmploy(Employ employ) {
    dao().addEmploy(employ);
    return "Record Added...";
  }
}