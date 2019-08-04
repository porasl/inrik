package com.inrik.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;

import liquibase.Liquibase;
//import liquibase.Liquibase;
import liquibase.changelog.ChangeSet;
import liquibase.database.DatabaseConnection;
import liquibase.database.jvm.JdbcConnection;
import liquibase.resource.ClassLoaderResourceAccessor;

	public class LiquibaseRunner{
		private static org.slf4j.Logger LOG = LoggerFactory.getLogger(LiquibaseRunner.class);

		public static void main(String[] argv) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println("Where is your MySQL JDBC Driver?");
				e.printStackTrace();
				return;
			}

			System.out.println("MySQL JDBC Driver Registered!");
			Connection connection = null;
			Properties prop = new Properties();
			try{
				InputStream in = 
						new FileInputStream("/Users/hamid/eclipse-workspace/inrik/src/main/java/com/inrik/config/liquibase/liquibase.properties");
				try {
					prop.load(in);
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
				String driver = prop.getProperty("driver");
				String ip = prop.getProperty("ip");
				String dbname = prop.getProperty("dbname");
				String username = prop.getProperty("username");
				String password = prop.getProperty("password");
				String url = "jdbc:mysql://"+ ip +":3306/"+dbname;
				System.out.println("Url: " + url);
				connection = DriverManager.getConnection(url,username,password);
				}catch (SQLException | IOException e) {
						System.out.println("Connection Failed! Check output console");
						e.printStackTrace();
						return;
				}
			
			try {
				DatabaseConnection dbc = new JdbcConnection(connection);
				Liquibase liquibase = 
						new Liquibase("com/inrik/config/liquibase/changelog-master.xml", new ClassLoaderResourceAccessor(), dbc);
				List<ChangeSet> changesToApply = liquibase.listUnrunChangeSets(null);
				for (ChangeSet changeSet : changesToApply) {
					LOG.info("Database needs change applied: " + changeSet.toString());
				}
				if (!changesToApply.isEmpty()) {
					LOG.info("Upgrading database");
					liquibase.update(null);
					liquibase.changeLogSync(null);
				} else {
					LOG.info("Database is upto date");
				}
			} catch (Exception e) {
				LOG.error("Database cannot be upgraded.", e);
				System.exit(1);
			} finally {
				if (connection != null) {
					try {
						connection.close();
					} catch (SQLException e) {
						//LOG.error("Error while upgrading database", e);
					}
				}
			
			}
		}
	}