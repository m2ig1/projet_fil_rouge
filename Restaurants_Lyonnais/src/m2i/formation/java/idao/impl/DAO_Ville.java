package m2i.formation.java.idao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import m2i.formation.java.buisness.Ville;
import m2i.formation.java.idao.IDAO;
import m2i.formation.java.utilities.Connexion;
import m2i.formation.java.utilities.Utilitaire2;

public class DAO_Ville implements IDAO<Ville> 
{

	
	final static String url = "jdbc:mysql://151.80.59.182:3306/restaurant?serverTimezone=UTC"; 
	final static String user = "m2ig1";
	final static String pwd = "m2iFormation" ;
	
	private static Connection _Cnn = Connexion.getConnection(url, user, pwd);
	
	@Override
	public int Create(Ville obj) {
int rep = -1; //retournera le nombre de fois que la requete est effectué
		
		//Squelete de la requete SQL
		String chSql_insert = Utilitaire2.GenereCreateSql("ville") ;
		
		try {
			//Variable qui permet de remplir le squelet de requete 
			PreparedStatement ps = _Cnn.prepareStatement(chSql_insert);
			
			//Remplissage de la requete SQL
			ps.setInt(1, obj.getID_Ville());					
			ps.setString(2, obj.getNom());
			
			//Execution de la requete
			rep = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//on retourne le nombre de fois que la requete a ete effectue
		return rep;	
	}

	@Override
	public Ville Retreive(int id) {
		Ville rep = null;
		String chSql = Utilitaire2.GenereReadSql("ville");
		
		try {
			PreparedStatement ps = _Cnn.prepareStatement(chSql);
			ps.setInt(1, id);
			
			//Sauvegarde de la reponse de la base de donnée
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				int id_ville = rs.getInt(1);
				String nom = rs.getString(2);
								
				rep = new Ville(id_ville, nom);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return rep;
	}

	@Override
	public List<Ville> RetreiveAll() {
		ArrayList<Ville> rep = new ArrayList<Ville>();
		String chSql = Utilitaire2.GenereReadAllSql("ville");
		
		try {
			Statement s = _Cnn.createStatement();
			ResultSet rs = s.executeQuery(chSql);
			
			while(rs.next())
			{
				int id_ville = rs.getInt(1);
				String nom = rs.getString(2);
				
				rep.add(new Ville(id_ville, nom));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rep;
	}

	@Override
	public int Update(Ville obj) 
	{
		int rep = -1;
		String chSql = Utilitaire2.GenereUpdateSql("ville");
		
		try {
			PreparedStatement ps = _Cnn.prepareStatement(chSql);
			
			ps.setString(1, obj.getNom());
			ps.setInt(2, obj.getID_Ville());
			
			rep=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rep;

	}

	@Override
	public int Delete(int id) {
		int rep = -1;
		String chSql = Utilitaire2.GenereDeleteSql("ville");
		
		PreparedStatement ps;
		try {
			ps = _Cnn.prepareStatement(chSql);
			ps.setInt(1, id);
			rep=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rep;
	}

}
