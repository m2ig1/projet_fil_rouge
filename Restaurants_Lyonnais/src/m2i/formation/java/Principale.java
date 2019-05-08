package m2i.formation.java;

import m2i.formation.java.buisness.Ville;
import m2i.formation.java.idao.impl.DAO_Ville;
import m2i.formation.java.utilities.Utilitaire2;

public class Principale {

	public static void main(String[] args) {
		
		System.out.println(Utilitaire2.GenereCreateSql("ville"));
		
		Ville lyon = new Ville(1, "Lyon");
		
		DAO_Ville daov = new DAO_Ville();
		
		daov.Create(lyon);
		System.out.println(daov.Retreive(1));
		daov.Delete(1);

	}

}
