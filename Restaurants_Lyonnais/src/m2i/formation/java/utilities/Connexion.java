package m2i.formation.java.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
	
	//Attributs
	private static Connection _instance = null;

	//constructeur privé pour qu'il ne soit pas possible d'instencier la classe
	private Connexion () 
	{
		
	}
	
	public static Connection getConnection(String url, String user, String pwd)
	{
		if(_instance == null)
		{
			synchronized(Connexion.class) 	//à toujours utiliser !
			
			
			// on met un verou sur tout le type pour evité que d'autre thred execute le code
			// le programme peut etre éxecuté par plusieurs thred dans un ordre different.
			// si un autre thred arrive alors que instance a deja été créer, ca evitera que _instance soit dif de nul
			// et que le code retourne autre chose que null
			{
		
				if(_instance == null)
				{
					try {
						_instance = DriverManager.getConnection(url, user, pwd);
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
				}
			}
		
		}
		
		return _instance;
		
	}
}
