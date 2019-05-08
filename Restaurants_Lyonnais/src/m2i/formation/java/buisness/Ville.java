package m2i.formation.java.buisness;

import java.util.List;

public class Ville 
{
	//Attributs
	int ID_Ville;
	String Nom;
	//il y a plusieur arrondissement dans une ville
	List<Arrondissement> arr;
	
	
	//Constructeur
	public Ville(int iD_Ville, String nom, List<Arrondissement> arr) 
	{
		super();
		ID_Ville = iD_Ville;
		this.Nom = nom;
		this.arr = arr;
	}
	
	public Ville(int iD_Ville, String nom) 
	{
		super();
		ID_Ville = iD_Ville;
		this.Nom = nom;
	}

	
	//Getteur et Setteur
	public int getID_Ville() {
		return ID_Ville;
	}
	public void setID_Ville(int iD_Ville) {
		ID_Ville = iD_Ville;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		this.Nom = nom;
	}
	public List<Arrondissement> getArr() {
		return arr;
	}
	public void setArr(List<Arrondissement> arr) {
		this.arr = arr;
	}

	@Override
	public String toString() {
		return "Ville [ID_Ville=" + ID_Ville + ", Nom=" + Nom + "]";
	}
	
	
	
	

}
