package com.hexaware.persistence;
import com.hexaware.model.Employ;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;
/**
 * WalletMapper class used to fetch Wallet data from database.
 * @author hexware
 */
public class EmployMapper implements ResultSetMapper<Employ> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped customer object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public final Employ map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
       * @return Wallet
       */
     
      return new Employ(rs.getInt("Empno"), 
        rs.getString("name"), rs.getString("dept"), 
        rs.getString("desig"), rs.getInt("basic")
        );
  }
}