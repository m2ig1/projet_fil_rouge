package m2i.formation.java.buisness;

import java.util.List;

public class Ville 
{
	//Attributs
	int id_ville;
	String nom_ville;
	//il y a plusieur arrondissement dans une ville
	List<Arrondissement> arr;
	
	
	//Constructeur
	public Ville(int iD_Ville, String nom, List<Arrondissement> arr) 
	{
		super();
		id_ville = iD_Ville;
		this.nom_ville = nom;
		this.arr = arr;
	}
	
	public Ville(int iD_Ville, String nom) 
	{
		super();
		id_ville = iD_Ville;
		this.nom_ville = nom;
	}

	
	//Getteur et Setteur
	public int getID_Ville() {
		return id_ville;
	}
	public void setID_Ville(int iD_Ville) {
		id_ville = iD_Ville;
	}
	public String getNom() {
		return nom_ville;
	}
	public void setNom(String nom) {
		this.nom_ville = nom;
	}
	public List<Arrondissement> getArr() {
		return arr;
	}
	public void setArr(List<Arrondissement> arr) {
		this.arr = arr;
	}

	@Override
	public String toString() {
		return "Ville [ID_Ville=" + id_ville + ", Nom=" + nom_ville + "]";
	}
	
	
	
	

}
