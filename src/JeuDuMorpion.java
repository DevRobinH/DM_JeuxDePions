import java.util.Scanner;

public class JeuDuMorpion {
	
	static PlateauJeu plateau = new PlateauJeu();
	
	public void reglesDuJeu() {
		String sRegles = "\nRègles du jeu :\n\n"+
				"Le but du jeu est d'aligner une suite de 4 pions de même type sur une grille.\n"+
				"Tour à tour les deux joueurs placent un pion sur le plateau.\n" +
				"Le vainqueur est le joueur qui réalise le premier un alignement (horizontal, vertical ou diagonal) consécutif d'au moins quatre de ses pions.\n" + 
				"Si, alors que toutes les cases de la grille de jeu sont remplies, aucun des deux joueurs n'a réalisé un tel alignement, la partie est déclarée nulle.\n";
	
		System.out.println(sRegles);
	}
	
	/**
	 * Demande à l'utilisateur de rentrer les coordonnées du pion qu'il souhaite placer.
	 *            
	 * @author Robin HENRY
	 * 
	 * @throws Exeption lorsque l'utilsateur rentre autre chose qu'un chiffre pour les coordonnées du pion.
	 * 
	 * @version 1.5
	 */
	public void choixCoordonnees() {
		
		int iChoixLigne = 7;
		int iChoixColonne = 7;
		int iSortie1 = 0;
		int iSortie2 = 0;
				
		//Instance de la classe Scanner:
		Scanner sc = new Scanner(System.in);
		
		// Demande à l'utilisateur une nouvelle entrée tant que celle-ci n'est pas correcte
		while (iSortie2 == 0 )
		{
			iSortie2 = 1;			
			while (iSortie1 == 0)
			{
				iSortie1 = 1;
				// Le joueur est invité à choisir une ligne:
				System.out.println("\n"+plateau.joueurTour.GetNomJoueur()+", choisissez une ligne pour y placer votre jeton("+plateau.joueurTour.GetPionJoueur()+"):");
				iChoixLigne = sc.nextInt();
				
				// Vérifier si la saisie de l'utilisateur est comprise dans le tableau	
				if(iChoixLigne >8 || iChoixLigne <1)
				{
					System.out.println("Cette case n'existe pas, veuillez réessayer");
					iSortie1 = 0;
				}
				
				// Le joueur est invité à choisir une colonne:
				System.out.println("\n"+plateau.joueurTour.GetNomJoueur()+", choisissez une colonne pour y placer votre jeton("+plateau.joueurTour.GetPionJoueur()+"):");
				iChoixColonne = sc.nextInt();
					
				// Vérifier si la saisie de l'utilisateur est comprise dans le tableau
				if(iChoixColonne >8 || iChoixColonne <1)
				{
					System.out.println("Cette case n'existe pas, veuillez réessayer");
					iSortie1 = 0;
				}
			}
			// Vérifier si case libre ou pas
			if((plateau.sGrille[iChoixLigne -1][iChoixColonne -1] == "X") || (plateau.sGrille[iChoixLigne -1][iChoixColonne -1] == "O"))
				{
				System.out.println("Cette case est déjà occupée, veuillez réessayer");
				iSortie2 = 0;
				iSortie1 = 0;
				}
		}	
		System.out.println("Votre pion a été placé en X = " + iChoixLigne + " et  Y = " + iChoixColonne);
		// Les coordonnées sont implantées dans le plateau:
		plateau.joueurTour.SetPositionPionX(iChoixColonne -1);
		plateau.joueurTour.SetPositionPionY(iChoixLigne -1);
			
		// On insère le pion au niveau de l'affichage
		plateau.sGrille[iChoixLigne -1][iChoixColonne -1] = plateau.joueurTour.GetPionJoueur();
	}
	
}