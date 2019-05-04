package m2i.formation.java.utilities;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Utilitaire 
{
	  ///////////////////////////////////////////////////////////////////////////////////////////
	 //permet de retourner une collection de l'ensemble des attributs d'un objet de type class//
	///////////////////////////////////////////////////////////////////////////////////////////
	public static Field[] ListeDesChamps(String NomComplet) throws ClassNotFoundException
	{
		//récuperation de la classe de NomComplet dans un operateur diamant Class<?> qui prend le type de la classe de nomComplet
		Class<?> maClasse = Class.forName(NomComplet);
		//recuperation des attributs de la classe dans un tableau de champs
		Field[] rep = maClasse.getDeclaredFields();
		
		//verifie si la classe issue de NomComplet herite d'une autre classe
		if(maClasse.getSuperclass() != null) 
		{
			//si elle herite, on récupère les attribut de la mere et on les ajoute à rep		
			Field[] rep2 =  maClasse.getSuperclass().getDeclaredFields();
		
			Field[] fusion = new Field[rep.length + rep2.length];
			for(int i = 0 ; i< rep.length ; i++)
			{
				fusion[i] = rep[i];
			}
			for(int i = 0; i< rep2.length; i++)
			{
				fusion[rep.length + i] = rep2[i];
			}
			rep = fusion;
		}
		
		return rep ; 
	}
	  ///////////////////////////////////////////////////////////////
	 //Creer les requetes SQL à partire des attributs d'une classe//
	///////////////////////////////////////////////////////////////
	public static Map<String,String> requetesSql(String NomComplet)
	{
		Map<String,String> attributs = new HashMap<String, String>();
		Field[] mesAttributs;
		try {
			Class<?> maClasse = Class.forName(NomComplet);
			mesAttributs = Utilitaire.ListeDesChamps(NomComplet);
			String Sqlcreate = "Insert Into " + maClasse.getSimpleName() + " (";
			
			String SqlRead = "SELECT * FROM "+ maClasse.getSimpleName() + " WHERE ";
			String SqlReadAll = "SELECT * FROM " + maClasse.getSimpleName();
			String SqlUpdate = "UPDATE "+ maClasse.getSimpleName() + " SET ";
			String SqlDelete = "DELETE FROM "+maClasse.getSimpleName()+ " WHERE ";
			
			for(Field f : mesAttributs)
			{
				Sqlcreate += f.getName() + ","; 
				SqlUpdate += f.getName() + " = ?, ";
				
				if(f.getName().toUpperCase().contains("ID_" + maClasse.getSimpleName().toUpperCase()))
				{
					SqlRead += f.getName() + " = ?";
					SqlDelete += f.getName() + " = ?";
				}
				
			}
			Sqlcreate = Sqlcreate.substring(0, Sqlcreate.length()-1);
			Sqlcreate += ") VALUES("; 
			
			SqlUpdate = SqlUpdate.substring(0, SqlUpdate.length()-2);
			SqlUpdate += " WHERE ";
			
			for(int i = 0; i <mesAttributs.length ; i++)
			{
				Sqlcreate += "?,";
				
				if(mesAttributs[i].getName().toUpperCase().contains("ID"))
					SqlUpdate += mesAttributs[i].getName() + "= ?";
			}
			Sqlcreate = Sqlcreate.substring(0, Sqlcreate.length()-1);
			Sqlcreate += ")";
			
			attributs.put("Create", Sqlcreate);
			attributs.put("Read", SqlRead);
			attributs.put("readAll", SqlReadAll);
			attributs.put("Update", SqlUpdate);
			attributs.put("Delete", SqlDelete);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return attributs;
	}
	
}
