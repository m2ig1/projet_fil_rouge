package m2i.formation.java.buisness;

import java.util.List;

public class Arrondissement 
{
	//Attributs
	int ID_Arrondissement;
	int numeroArrondissement;
	int IDE_Ville;
	//il y a plusieur resto dans un arrondissement
	List<Restaurant> resto;
	
	
	//Constructeur
	public Arrondissement(int iD_Arrondissement, int numeroArrondissement, int iDE_Ville, List<Restaurant> resto) {
		super();
		ID_Arrondissement = iD_Arrondissement;
		this.numeroArrondissement = numeroArrondissement;
		IDE_Ville = iDE_Ville;
		this.resto = resto;
	}
	public Arrondissement(int iD_Arrondissement, int numeroArrondissement, int iDE_Ville) {
		super();
		ID_Arrondissement = iD_Arrondissement;
		this.numeroArrondissement = numeroArrondissement;
		IDE_Ville = iDE_Ville;
	}
	
	
	//Getteur et Setteur
	public int getID_Arrondissement() {
		return ID_Arrondissement;
	}
	public void setID_Arrondissement(int iD_Arrondissement) {
		ID_Arrondissement = iD_Arrondissement;
	}
	public int getNumeroArrondissement() {
		return numeroArrondissement;
	}
	public void setNumeroArrondissement(int numeroArrondissement) {
		this.numeroArrondissement = numeroArrondissement;
	}
	public int getIDE_Ville() {
		return IDE_Ville;
	}
	public void setIDE_Ville(int iDE_Ville) {
		IDE_Ville = iDE_Ville;
	}
	public List<Restaurant> getResto() {
		return resto;
	}
	public void setResto(List<Restaurant> resto) {
		this.resto = resto;
	}
	
	
	//methode d'ajout de restaurant
	public void AjoutResto(Restaurant R)
	{
		this.resto.add(R);
	}
	
	
	
	
	
	

}
