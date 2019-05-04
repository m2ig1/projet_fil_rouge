package m2i.formation.java.buisness;

public class Restaurant 
{
	//Attributs
	int ID_Resto;
	String Nom;
	int IDE_Arrondissement;
	//un resto a une seul spé et une seul carte
	Specialite spe;
	Carte carte;
	
	
	//Constructeur
	public Restaurant(int iD_Resto, String nom, int iDE_Arrondissement, Specialite spe, Carte carte) {
		super();
		ID_Resto = iD_Resto;
		Nom = nom;
		IDE_Arrondissement = iDE_Arrondissement;
		this.spe = spe;
		this.carte = carte;
	}

	
	//Getteurs et Setteurs
	public int getID_Resto() {
		return ID_Resto;
	}
	public void setID_Resto(int iD_Resto) {
		ID_Resto = iD_Resto;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public int getIDE_Arrondissement() {
		return IDE_Arrondissement;
	}
	public void setIDE_Arrondissement(int iDE_Arrondissement) {
		IDE_Arrondissement = iDE_Arrondissement;
	}
	public Specialite getSpe() {
		return spe;
	}
	public void setSpe(Specialite spe) {
		this.spe = spe;
	}
	public Carte getCarte() {
		return carte;
	}
	public void setCarte(Carte carte) {
		this.carte = carte;
	}
	
	
	//Méthode pour changer de carte
	public void ChangerDeCarte(Carte c)
	{
		this.carte = c;
	}
	

	
}
