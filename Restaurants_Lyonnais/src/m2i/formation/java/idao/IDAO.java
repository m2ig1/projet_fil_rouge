package m2i.formation.java.idao;

import java.util.List;


//data access object
public interface IDAO <T> //on precise à la classe qu'on va utiliser nimporte quelle objet T
{
	int Create(T obj);	//permet d'inserer un enregistrement dans la base de données
	T Retreive(int id); 	//permet de recupérer un enregistrement d'id dans la tabe et retourne un objet de type T
	List<T> RetreiveAll(); 	// recupère tous les enregistrement de la table dans une liste d'objet de type T
	int Update(T obj);		// met a jours l'objet obj et ertourne (int) le nombre d'objet modifié
	int Delete(int id);		// sup l'objet d'identifiant id et retourne le nombre d'objet suprimé
	
	
}
