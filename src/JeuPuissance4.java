import java.util.Scanner;

public class JeuPuissance4 {

	public static void main(String[] args) {

	}
	
	public void reglesDuJeu() {
		String regles = "\nR�gles du jeu :\n\n"+
				"Le but du jeu est d'aligner une suite de 4 pions de m�me type sur une grille.\n"+
				"Tour � tour les deux joueurs placent un pion dans la colonne de leur choix.\n" +
				"Le pion tombe alors en bas de la colonne.\n" +
				"Le vainqueur est le joueur qui r�alise le premier un alignement (horizontal, vertical ou diagonal) cons�cutif d'au moins quatre de ses pions.\n" + 
				"Si, alors que toutes les cases de la grille de jeu sont remplies, aucun des deux joueurs n'a r�alis� un tel alignement, la partie est d�clar�e nulle.\n";
	
		System.out.println(regles);
	}
	
	public void choixColonne(){
		int i;
		//int j;
		int choixColonne = 8;
		
		//Instance de la classe Scanner:
		Scanner sc = new Scanner(System.in);
		
		//Instance de la classe PlateauJeu:
		PlateauJeu plateau = new PlateauJeu();
		
		// Le joueur est invit� � choisir une colonne:
		System.out.println("\n"+plateau.nomJoueur1+", choisissez une colonne pour y placer votre jeton("+plateau.pionJoueur1+"):");
		
		// R�cup�ration de la saisie utilisateur:
		choixColonne = sc.nextInt();
		
		//en fonction du choix de l'utilisateur:
		switch (choixColonne)
		{
			case 1: //colonne 1
				//On va tester de la derni�re � la 1�re ligne:
				for (i=7; i>-1; i--){
					// Si la case actuelle contient d�j� un pion
					if(plateau.grille[i][0] != " "){
						if (i==0){
							System.out.println("Cette colonne est pleine, veuillez en choisir une autre: ");
							
						}
						continue; //on teste avec la ligne du dessus
					}
					else{
						//Sinon on ins�re le pion
						plateau.grille[i][0]= plateau.pionJoueur1;
						break; //Pion pos� => on sort de la boucle
					}
				}
				
				break;
			case 2: //colonne 2
				plateau.grille[0][1]= plateau.pionJoueur1;
				break;
			case 3: //colonne 3
				plateau.grille[0][2]= plateau.pionJoueur1;
				break;
			case 4: //colonne 4
				plateau.grille[0][3]= plateau.pionJoueur1;
				break;
			case 6: //colonne 5
				plateau.grille[0][4]= plateau.pionJoueur1;
				break;
			case 7: //colonne 6
				plateau.grille[0][5]= plateau.pionJoueur1;
				break;
			case 8: //colonne 7
				plateau.grille[0][6]= plateau.pionJoueur1;
				break;
			case 9: //colonne 18
				plateau.grille[0][7]= plateau.pionJoueur1;
				break;			
			default: //Aucune colonne colonne
				System.out.println("Cette colonne n'existe pas");
				break;
		}
		plateau.afficherPlateau();
				
		//sc.close();
	}
	
	public void choixColonne2(){
		
	}

}
