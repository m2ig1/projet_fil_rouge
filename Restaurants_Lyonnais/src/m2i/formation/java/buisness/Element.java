package m2i.formation.java.buisness;

import java.util.List;

public class Element 
{
	//Attributs
	int ID_Element;
	String Nom;
	int ID_Carte;
	List<Ingredient> ingredient;
	
	
	//Constructeur
	public Element(int iD_Element, String nom, int iD_Carte, List<Ingredient> ingredient) {
		super();
		ID_Element = iD_Element;
		Nom = nom;
		ID_Carte = iD_Carte;
		this.ingredient = ingredient;
	}


	//Getteurs et Setteurs
	public int getID_Element() {
		return ID_Element;
	}
	public void setID_Element(int iD_Element) {
		ID_Element = iD_Element;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public int getID_Carte() {
		return ID_Carte;
	}
	public void setID_Carte(int iD_Carte) {
		ID_Carte = iD_Carte;
	}
	public List<Ingredient> getIngredient() {
		return ingredient;
	}
	public void setIngredient(List<Ingredient> ingredient) {
		this.ingredient = ingredient;
	}
	
	
	
	
	
	
}
