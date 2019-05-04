package m2i.formation.java.buisness;

import java.util.List;

public class Carte 
{
	//Attributs
	int ID_Carte; //peut etre pas utile, une carte par resto
	String Nom;
	int IDE_Resto;
	List<Element> elem;
	
	
	//Constructeur
	public Carte(int iD_Carte, String nom, int iDE_Resto, List<Element> elem) {
		super();
		ID_Carte = iD_Carte;
		Nom = nom;
		IDE_Resto = iDE_Resto;
		this.elem = elem;
	}

	
	//Getteurs et Setteurs
	public int getID_Carte() {
		return ID_Carte;
	}
	public void setID_Carte(int iD_Carte) {
		ID_Carte = iD_Carte;
	}
	public int getIDE_Resto() {
		return IDE_Resto;
	}
	public void setIDE_Resto(int iDE_Resto) {
		IDE_Resto = iDE_Resto;
	}
	public List<Element> getElem() {
		return elem;
	}
	public void setElem(List<Element> elem) {
		this.elem = elem;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}


	//Méthode pour ajouter un élément
	public void AjoutElement(Element e)
	{
		this.elem.add(e);
	}
	
	//Suprimer un élement
	public void SuprimerElement(Element e)
	{
		this.elem.remove(e);
	}

	
}
