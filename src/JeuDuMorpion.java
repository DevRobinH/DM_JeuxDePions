import java.util.Scanner;

public class JeuDuMorpion {
	
	static PlateauJeu plateau = new PlateauJeu();
	
	public void reglesDuJeu() {
		String sRegles = "\nR�gles du jeu :\n\n"+
				"Le but du jeu est d'aligner une suite de 4 pions de m�me type sur une grille.\n"+
				"Tour � tour les deux joueurs placent un pion sur le plateau.\n" +
				"Le vainqueur est le joueur qui r�alise le premier un alignement (horizontal, vertical ou diagonal) cons�cutif d'au moins quatre de ses pions.\n" + 
				"Si, alors que toutes les cases de la grille de jeu sont remplies, aucun des deux joueurs n'a r�alis� un tel alignement, la partie est d�clar�e nulle.\n";
	
		System.out.println(sRegles);
	}
	
	/**
	 * Demande � l'utilisateur de rentrer les coordonn�es du pion qu'il souhaite placer.
	 *            
	 * @author Robin HENRY
	 * 
	 * @throws Exeption lorsque l'utilsateur rentre autre chose qu'un chiffre pour les coordonn�es du pion.
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
		
		// Demande � l'utilisateur une nouvelle entr�e tant que celle-ci n'est pas correcte
		while (iSortie2 == 0 )
		{
			iSortie2 = 1;			
			while (iSortie1 == 0)
			{
				iSortie1 = 1;
				// Le joueur est invit� � choisir une ligne:
				System.out.println("\n"+plateau.joueurTour.GetNomJoueur()+", choisissez une ligne pour y placer votre jeton("+plateau.joueurTour.GetPionJoueur()+"):");
				iChoixLigne = sc.nextInt();
				
				// V�rifier si la saisie de l'utilisateur est comprise dans le tableau	
				if(iChoixLigne >8 || iChoixLigne <1)
				{
					System.out.println("Cette case n'existe pas, veuillez r�essayer");
					iSortie1 = 0;
				}
				
				// Le joueur est invit� � choisir une colonne:
				System.out.println("\n"+plateau.joueurTour.GetNomJoueur()+", choisissez une colonne pour y placer votre jeton("+plateau.joueurTour.GetPionJoueur()+"):");
				iChoixColonne = sc.nextInt();
					
				// V�rifier si la saisie de l'utilisateur est comprise dans le tableau
				if(iChoixColonne >8 || iChoixColonne <1)
				{
					System.out.println("Cette case n'existe pas, veuillez r�essayer");
					iSortie1 = 0;
				}
			}
			// V�rifier si case libre ou pas
			if((plateau.sGrille[iChoixLigne -1][iChoixColonne -1] == "X") || (plateau.sGrille[iChoixLigne -1][iChoixColonne -1] == "O"))
				{
				System.out.println("Cette case est d�j� occup�e, veuillez r�essayer");
				iSortie2 = 0;
				iSortie1 = 0;
				}
		}	
		System.out.println("Votre pion a �t� plac� en X = " + iChoixLigne + " et  Y = " + iChoixColonne);
		// Les coordonn�es sont implant�es dans le plateau:
		plateau.joueurTour.SetPositionPionX(iChoixColonne -1);
		plateau.joueurTour.SetPositionPionY(iChoixLigne -1);
			
		// On ins�re le pion au niveau de l'affichage
		plateau.sGrille[iChoixLigne -1][iChoixColonne -1] = plateau.joueurTour.GetPionJoueur();
	}
	
}