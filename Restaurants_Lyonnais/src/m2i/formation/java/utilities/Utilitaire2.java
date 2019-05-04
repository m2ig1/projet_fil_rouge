package m2i.formation.java.utilities;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utilitaire2 
{
	
	
	final static String url = "jdbc:mysql://localhost:3306/projet_ecole?serverTimezone=UTC"; 
	final static String user = "root";
	final static String pwd = "" ;
	
	private static Connection _Cnn = Connexion.getConnection(url, user, pwd);
	
	//Recupère la liste des nom de colonnes de la table "nomTable"
	public static List<String> nomDesColonnes(String nomTable)
	{
		List<String> lstColonnes = new ArrayList<String>();
		try {
			//Connection à la base de données
			Statement st = _Cnn.createStatement();
			//récupération de la table "nomTable"
			ResultSet rs = st.executeQuery("select * from " + nomTable);
			//récupération des métadonnees de la table 
			ResultSetMetaData rsmd = rs.getMetaData();
			
			//on parcours les métadonnées et on enregistre le nom de chaque colonnes de la table dans une variable lstColonnes
			for(int i = 1; i< rsmd.getColumnCount()+1; i++)
			{
				lstColonnes.add(rsmd.getColumnName(i));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lstColonnes;
	}

	
	
	public static String GenereCreateSql(String nomTable)
	{
		List<String> mesAttributs = Utilitaire2.nomDesColonnes(nomTable);
		String Sqlcreate = "Insert Into " + nomTable + " (";
			
			for(String f : mesAttributs)
			{
				Sqlcreate += f + ","; 
			}
			Sqlcreate = Sqlcreate.substring(0, Sqlcreate.length()-1);
			Sqlcreate += ") VALUES("; 
			
			for(int i = 0; i <mesAttributs.size() ; i++)
			{
				Sqlcreate += "?,";
			}
			Sqlcreate = Sqlcreate.substring(0, Sqlcreate.length()-1);
			Sqlcreate += ")";
			
		return Sqlcreate;
	}
	
	public static String GenereUpdateSql(String nomTable)
	{
		List<String> mesAttributs = Utilitaire2.nomDesColonnes(nomTable);
		String SqlUpdate = "UPDATE "+ nomTable + " SET ";
		for(String f : mesAttributs)
		{
			SqlUpdate += f + " = ?, ";
		}
		SqlUpdate = SqlUpdate.substring(0, SqlUpdate.length()-2);
		SqlUpdate += " WHERE ";
		for(int i = 0; i <mesAttributs.size() ; i++)
		{
			if(mesAttributs.get(i).toUpperCase().contains("ID_"+nomTable.toUpperCase()))
				SqlUpdate += mesAttributs.get(i) + "= ?";
		}
		 
		return SqlUpdate;
	}
	
	public static String GenereDeleteSql(String nomTable)
	{
		List<String> mesAttributs = Utilitaire2.nomDesColonnes(nomTable);
		String SqlDelete = "DELETE FROM "+nomTable+ " WHERE ";
			
			for(String f : mesAttributs)
			{
				if(f.toUpperCase().contains("ID_" + nomTable.toUpperCase()))
				{
					SqlDelete += f + " = ?";
				}
			}
		return SqlDelete;
	}
	
	public static String GenereReadSql(String nomTable)
	{
		List<String> mesAttributs = Utilitaire2.nomDesColonnes(nomTable);
		String SqlRead =  "SELECT * FROM "+ nomTable + " WHERE ";
			
			for(String f : mesAttributs)
			{
				if(f.toUpperCase().contains("ID_" + nomTable.toUpperCase()))
				{
					SqlRead += f + " = ?";
				}
				
			}

		return SqlRead;
	}
	
	public static String GenereReadAllSql(String nomTable)
	{
		return "SELECT * FROM " + nomTable;
	}

	public static Map<String, String> RequeteSql(String nomTable)
	{
		Map<String, String> requetes = new HashMap<String, String>();
		
		requetes.put("Create", Utilitaire2.GenereCreateSql(nomTable));
		requetes.put("Read", Utilitaire2.GenereReadSql(nomTable));
		requetes.put("readAll", Utilitaire2.GenereReadAllSql(nomTable));
		requetes.put("Update", Utilitaire2.GenereUpdateSql(nomTable));
		requetes.put("Delete", Utilitaire2.GenereDeleteSql(nomTable));
		
	return requetes;
	}
	
}
