import java.util.Scanner;

public class PlateauJeu {

	public static String nomJoueur1,nomJoueur2;
	public static String pionJoueur1 = "O";
	public static String pionJoueur2 = "X";
	public static String grille[][] = new String[8][8];//tableau en 2 dimensions: 8 lignes, 8 éléments
	public static String valeurTableau = " ";
	
	public static void main(String[] args) {
		
		int i;
		int j;
		
		//Instances de la classe puissance 4:
		JeuPuissance4 puissance4 = new JeuPuissance4();
		
		//Instances de la classe Morpion:
		JeuDuMorpion morpion = new JeuDuMorpion();
		
		//Affectation par défaut des cases du tableau:
		for (i=0; i<8; i++){
			for (j=0; j<8; j++){
				PlateauJeu.grille[i][j] = valeurTableau;
			}
		}
		
		//Instance de la classe Scanner:
		Scanner sc = new Scanner(System.in);
		
		char choixDuJeu = '3';
		

		//while(choixDuJeu != 1 && choixDuJeu != 2){
			
			String listeDeJeux = "Liste des jeux disponibles : \n" +
					"1. Puissance 4\n"+
					"2. Morpion\n"+
					"Entrez le numéro du jeu souhaité :";
			
			System.out.println(listeDeJeux);
			choixDuJeu = sc.next(".").charAt(0); 

			switch (choixDuJeu)
			{
				case '1': // Puissance 4
					
					// Méthode qui affiche les règles du jeu Puissance 4
					puissance4.reglesDuJeu() ;
					
					// Méthode qui permet de paramétrer les joueurs, avant une partie
					parametrageJoueur() ;

					// Méthode qui va générer le plateau de jeu 
					afficherPlateau() ;
					
					// Méthode qui permet au joueur de choisir la colonne où le pion est inséré
					puissance4.choixColonne() ;

					break;
				    
				case '2': // Morpion
					
					// Méthode qui affiche les règles du jeu du Morpion
					morpion.reglesDuJeu() ;
					
					// Méthode qui permet de paramétrer les joueurs, avant une partie
					parametrageJoueur() ;

					// Méthode qui va générer le plateau de jeu 
					afficherPlateau() ;
					
					// Méthode qui permet au joueur de choisir les coordonnées du pion à placer
					morpion.choixCoordonnees() ;

					break;
					
				default:
				    System.out.println("Aucun jeu ne correspond à cette valeur.");
				break;
			}
		//}
		//sc.close();
	}
		
		
	public static void parametrageJoueur(){
		
		// Instance de la classe Scanner :
		Scanner sc = new Scanner(System.in);
			
		System.out.println("Nom du joueur 1 :");
	    nomJoueur1 = sc.nextLine();
	    
	    System.out.println("Nom du joueur 2 :");
	    nomJoueur2 = sc.nextLine();
	    
	    // Choix des pions :
	    System.out.println("Type de pion pour "+nomJoueur1+": O ou X ?");
	    // Récupère le 1er caractère :
	    char typeDePion = sc.next(".").charAt(0);
	    
	    switch (typeDePion)
		{
			case 'o':
			case 'O':
			case '0':
				pionJoueur1 = "O";
				pionJoueur2 = "X";
				break;	
			
			case 'x':
			case 'X':
				pionJoueur1 = "X";
				pionJoueur2 = "O";
			 	break;
		    
			default:
				System.out.println("Ce type de pion n'existe pas");
				break;
		}
	    
	    System.out.println("\n"+nomJoueur1+": "+pionJoueur1);
	    System.out.println(nomJoueur2+": "+pionJoueur2+"\n");
	    
	    System.out.printf("		"+nomJoueur1+" vs "+nomJoueur2+"\n\n");


	    //sc.close();
	}
	
	
	
	public static void afficherPlateau(){
		
		int i;
		int j;
		int col; // Axe des abscisses

		
		System.out.println("	_   _   _   _   _   _   _   _");
		
		//Initialisation du compteur:
		i=0;
		
		//Affichage du tableau à 2 dimensions :
		while (i < 8)
		{
		  j = 0;	  
		  // Affichage du nombre de lignes :
		  System.out.print("   "+(i+1)+"  | ");
		  while(j < 8)
		  {
		    System.out.print(grille[i][j]);
		    System.out.print(" | ");
		    j++;
		  }
		  //retour à la ligne pour chaque ligne du tableau :
		  System.out.println("");
		  i++;
		}
		
		// Affichage du nombre de colonnes :
		System.out.println("	¯   ¯   ¯   ¯   ¯   ¯   ¯   ¯");
		System.out.printf("      ");
		for (col=0; col<8; col++){
			System.out.printf("  "+(col+1)+" ");
		}
		System.out.println("");
	}

}
