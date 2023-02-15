package villagegaulois;

import personnages.Chef;
import personnages.Gaulois;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
	}

	public String getNom() {
		return nom;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
		}
	}

	public Gaulois trouverHabitant(String nomGaulois) {
		if (nomGaulois.equals(chef.getNom())) {
			return chef;
		}
		for (int i = 0; i < nbVillageois; i++) {
			Gaulois gaulois = villageois[i];
			if (gaulois.getNom().equals(nomGaulois)) {
				return gaulois;
			}
		}
		return null;
	}

	public String afficherVillageois() {
		StringBuilder chaine = new StringBuilder();
		if (nbVillageois < 1) {
			chaine.append("Il n'y a encore aucun habitant au village du chef "
					+ chef.getNom() + ".\n");
		} else {
			chaine.append("Au village du chef " + chef.getNom()
					+ " vivent les légendaires gaulois :\n");
			for (int i = 0; i < nbVillageois; i++) {
				chaine.append("- " + villageois[i].getNom() + "\n");
			}
		}
		return chaine.toString();
	}
	
	public static class Marche {
		private Etal [] etals;
		
		public Marche (int nbEtal) {
			this.etals = new Etal [nbEtal];
			
		}
		private void utiliserEtal(int indiceEtal, Gaulois vendeur, String produit, int nbProduit) {
			etals[indiceEtal].occuperEtal(vendeur, produit, nbProduit);
		}
		private int trouverEtalLibre() {
			for (int indiceEtals = 0; indiceEtals < etals.length; indiceEtals ++) {
				if (etals[indiceEtals].isEtalOccupe() == false) {
					return indiceEtals;
				}
			}
			return -1;
		}
		private Etal [] trouverEtals (String produit) { 
			int compteur = 0;
			for (int indiceEtals = 0; indiceEtals < etals.length ;indiceEtals ++) {
				if (etals[indiceEtals].isEtalOccupe()==true) {
					compteur += 1;
				}
			}
			Etal[] contProd = new Etal [compteur];	
			for (int indiceEtal = 0; indiceEtal < etals.length ;indiceEtal ++) {
				if (etals[indiceEtal].contientProduit(produit)){
					contProd [indiceEtal] = etals[indiceEtal];
				}
			}
			return contProd;
		}
		private Etal trouverVendeur (Gaulois gaulois) {
			for (int indiceEtals = 0; indiceEtals < etals.length ;indiceEtals ++) {
				if(etals[indiceEtals].getVendeur() == gaulois) {
					return etals[indiceEtals];
				}
			}
			return null;
		}
		private String afficherMache() {
			int nbEtalVide = 0; 
			for (int indiceEtals = 0; indiceEtals < etals.length ;indiceEtals ++) {
				if(etals[indiceEtals].isEtalOccupe() == false) {
					nbEtalVide += 1;
				return etals[indiceEtals].afficherEtal();
				}
			}
			return "Il reste" + nbEtalVide + " etals non utilises dans le marche.\n";
		}
		
		
		}
}