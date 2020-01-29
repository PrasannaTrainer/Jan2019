package com.hexaware.model;
import com.hexaware.persistence.DbConnection;

public class Employ{
    private int empno;
    private String name;
    private String dept;
    private String desig;
    private int basic;

    public final int getEmpno() {
      return empno;
    }
    public final void setEmpno(final int argEmpno) {
      this.empno=argEmpno;
    }
    public final String getName() {
      return name;
    }
    public final void setName(final String argName) {
      this.name=argName;
    }
    public final String getDept() {
      return dept;
    }
    public final void setDept(final String argDept) {
      this.dept=argDept;
    }
    public final String getDesig() {
      return desig;
    }
    public final void setDesig(final String argDesig) {
      this.desig=argDesig;
    }

    public final int getBasic() {
      return basic;
    }

    public final void setBasic(final int argBasic) {
      this.basic=argBasic;
    }

 /**
 * @param argEmpno to initialize employ No.
 * @param argName to initialize employ name.
 * @param argDept to initialize employ dept.
 * @param argDesig to initialize employ Desig.
 * @param argBasic to initialize employ basic.
 * used to get details through constructor.
 */

  public Employ() {

  }
  public Employ(int argEmpno, String argName,
        String argDept,
        String argDesig,
        int argBasic) {
    this.empno = argEmpno;
    this.name = argName;
    this.dept = argDept;
    this.desig = argDesig;
    this.basic = argBasic;
  }
 
  @Override
  public String toString() {
      return String.format("%10s %10s %10s %10s %10s",
        empno, name, dept, desig, basic);
      
  }
}