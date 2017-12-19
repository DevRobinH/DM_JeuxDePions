import java.util.Scanner;

public class JeuPuissance4 {
	//Instance de la classe PlateauJeu:
	static PlateauJeu plateau = new PlateauJeu();
	
	/**
	 * Affiche les r�gles du jeu Puissance 4.
	 *            
	 * @author Mamprin Florent
	 *  
	 * @version 1.0
	 */
	public void reglesDuJeu() {
		String regles = "\nR�gles du jeu :\n\n"+
				"Le but du jeu est d'aligner une suite de 4 pions de m�me type sur une grille.\n"+
				"Tour � tour les deux joueurs placent un pion dans la colonne de leur choix.\n" +
				"Le pion tombe alors en bas de la colonne.\n" +
				"Le vainqueur est le joueur qui r�alise le premier un alignement (horizontal, vertical ou diagonal) cons�cutif d'au moins quatre de ses pions.\n" + 
				"Si, alors que toutes les cases de la grille de jeu sont remplies, aucun des deux joueurs n'a r�alis� un tel alignement, la partie est d�clar�e nulle.\n";
	
		System.out.println(regles);
	}
	
	/**
	 * Demande � l'utilisateur � choisir une colonne, et appelle la m�thode graviteColonne en fonction de son choix.
	 *            
	 * @author Mamprin Florent
	 *  
	 * @version 1.0
	 */
	public void choixColonne(){
		char cChoixColonne;
		int iSortie=0;
		int iColonne = 1;
		
		//Instance de la classe Scanner:
		Scanner sc = new Scanner(System.in);

		
		// Tant que la saisie est incorrecte:
		while (iSortie == 0){
			// Le joueur est invit� � choisir une colonne:
			System.out.println("\n"+plateau.joueurTour.GetNomJoueur()+", choisissez une colonne pour y placer votre jeton("+plateau.joueurTour.GetPionJoueur()+"):");
			
			// R�cup�ration de la saisie utilisateur:
			cChoixColonne = sc.next(".").charAt(0);

			//en fonction du choix de l'utilisateur:
			switch (cChoixColonne)
			{
				case '1': //colonne 1
				case '2': //colonne 2
				case '3': //colonne 3
				case '4': //colonne 4
				case '5': //colonne 5
				case '6': //colonne 6
				case '7': //colonne 7
				case '8': //colonne 8
					
					iColonne = Character.getNumericValue(cChoixColonne);
					
					// On pourra sortir de la boucle :
					iSortie = 1;
					
					//Appel de la m�thode pour que le pion tombe:
					graviteColonne(iColonne);
					break;
				
				//si nombre ne correspond � aucune des colonnes:
				default: 
					System.out.println("Cette colonne n'existe pas");
					break;
			}
		}
	}
	
	/**
	 * Place le pion au plus bas dans la colonne, jusqu'� rencontrer un pion.
	 *            
	 * @author Mamprin Florent
	 * 
	 * @param iColonneChoisie : la colonne choisie par l'utilisateur
	 *  
	 * @version 1.0
	 */
	public void graviteColonne(int iColonneChoisie){

		int iValX = iColonneChoisie-1;
		int iValY = 0;
				
		//On va tester de la derni�re � la 1�re case de la colonne:
		for (int i=7; i>-1; i--){
			// Si la case actuelle contient d�j� un pion
			if(plateau.sGrille[i][iColonneChoisie-1] != " "){
				//Si la case est pleine, on redemande la saisie:
				if (i==0){
					System.out.println("Cette colonne est pleine, veuillez en choisir une autre: ");
					choixColonne();
				}
				continue; //on teste avec la ligne du dessus
			}
			else{
				//Sinon on ins�re le pion
				plateau.sGrille[i][iColonneChoisie-1]= plateau.joueurTour.GetPionJoueur();
				
				// La valeur en ordonn�e est r�cup�r�e gr�ce au compteur de ligne:
				iValY = i ;
				
				break; //Pion pos� => on sort de la boucle
			}
		}
		
		//Les coordonn�es du joueur actuel lui sont affect�es:
		plateau.joueurTour.SetPositionPionX(iValX);
		plateau.joueurTour.SetPositionPionY(iValY);
		
	}

}