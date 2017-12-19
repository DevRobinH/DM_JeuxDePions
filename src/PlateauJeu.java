import java.util.Scanner;

public class PlateauJeu {
	
	// Déclaration du tableau :
	public static String sGrille[][] = new String[8][8];//tableau en 2 dimensions: 8 lignes, 8 éléments par lignes
	public static String sValeurTableau = " ";
	
	// Nombre de tours d'une partie
	private static int iNbTours = 63;
	
	// Instances de la classe joueur:
	static Joueur joueur1 = new Joueur();
	static Joueur joueur2 = new Joueur();
	static Joueur joueurTour = new Joueur();
	
	private static int iCptX;
	private static int iCptY;
	private static int iCptDiagGauche;
	private static int iCptDiagDroite;
	
	// Méthodes d'accès à iCptX:
	public static int GetiCptX(){
		return iCptX;
	}
			
	public static void SetiCptX(int CptX){
		iCptX = CptX;
	}
	
	// Méthodes d'accès à iCptY:
	public static int GetiCptY(){
		return iCptY;
	}
			
	public static void SetiCptY(int CptY){
		iCptY = CptY;
	}
	// Méthodes d'accès à iCptDiagGauche:
	public static int GetiCptDiagGauche(){
		return iCptDiagGauche;
	}
				
	public static void SetiCptDiagGauche(int CptDiagGauche){
		iCptDiagGauche = CptDiagGauche;
	}
	
	// Méthodes d'accès à iCptDiagDroite:
	public static int GetiCptDiagDroite(){
		return iCptDiagDroite;
	}
			
	public static void SetiCptDiagDroite(int CptDiagDroite){
		iCptDiagDroite = CptDiagDroite;
	}				
		
		
	public static void main(String[] args) {
		
		int i=0;
		int j;
		
		int iCoordonneeX;
		int iCoordonneeY;

		char cChoixDuJeu;
		
		// Instances de la classe JeuPuissance4:
		JeuPuissance4 puissance4 = new JeuPuissance4();
		
		// Instances de la classe JeuDuMorpion:
		JeuDuMorpion morpion = new JeuDuMorpion();
		
		// Instance de la classe Scanner:
		Scanner sc = new Scanner(System.in);	

		while (true) {
			
			// Initialisation du tableau:
			for (i=0; i<8; i++){
				for (j=0; j<8; j++){
					PlateauJeu.sGrille[i][j] = sValeurTableau;
				}
			}	
			
			String listeDeJeux = "Liste des jeux disponibles : \n" +
					"1. Puissance 4\n"+
					"2. Morpion\n"+
					"Entrez le numéro du jeu souhaité :";
			
			System.out.println(listeDeJeux);
			cChoixDuJeu = sc.next(".").charAt(0); 
			
			switch (cChoixDuJeu)
			{
				case '1': // Puissance 4
					
					// Méthode qui affiche les règles du jeu Puissance 4 :
					puissance4.reglesDuJeu() ;
					
					// Méthode qui permet de paramétrer les joueurs, avant une partie :
					parametrageJoueur() ;

					// Méthode qui va générer le plateau de jeu :
					afficherPlateau() ;
					
					//Compte le nombre de tours:
					for(i=0; i<=iNbTours; i++){
						
						// Si le nombre de coups maximum est atteint :
						if (i==iNbTours){
							System.out.println("\n\nPartie nulle ! Nouvelle Partie ?");
							break; //On sort de la boucle
						}
						
						// Méthode qui permet au joueur de choisir la colonne où le pion est à insérer :
						puissance4.choixColonne() ;
						
						// Les coordonnées du joueur en cours sont récupérées
						iCoordonneeX = joueurTour.GetPositionPionX();
						iCoordonneeY = joueurTour.GetPositionPionY();
						
						// Plateau avec le nouveau pion positionné: :
						afficherPlateau() ;
						
						// Vérifie si le joueur a gagné:
						verifierAlignement(sGrille, iCoordonneeX, iCoordonneeY);
						
						if (GetiCptX()==4){
							System.out.println("\nPartie terminée: "+joueurTour.GetNomJoueur()+" a gagné en " + ((i/2)+1) + " coups \n");
							break;
						}
						if (GetiCptY()==4){
							System.out.println("\nPartie terminée: "+joueurTour.GetNomJoueur()+" a gagné en " + ((i/2)+1) + " coups \n");
							break;
						}
						if (GetiCptDiagDroite()==4){
							System.out.println("\nPartie terminée: "+joueurTour.GetNomJoueur()+" a gagné en " + ((i/2)+1) + " coups \n");
							break;
						}
						if (GetiCptDiagGauche()==4){
							System.out.println("\nPartie terminée: "+joueurTour.GetNomJoueur()+" a gagné en " + ((i/2)+1) + " coups \n");
							break;
						}
							
						
						// Changement de joueur pour le tour suivant :
						changementDeJoueur();
					}	
					
					break; // Sortie du switch
				    
				case '2': // Morpion
					
					// Méthode qui affiche les règles du jeu du Morpion
					morpion.reglesDuJeu() ;
					
					// Méthode qui permet de paramétrer les joueurs, avant une partie
					parametrageJoueur() ;
					
					// Méthode qui va générer le plateau de jeu 
					afficherPlateau() ;	

					for(i=0; i<=iNbTours; i++){	
						
						// Si le nombre de coups maximum est atteint :
						if (i==iNbTours){
							System.out.println("\n\nPartie nulle ! Nouvelle Partie ?");
							break; //On sort de la boucle
						}
						
						// Méthode qui permet au joueur de choisir les coordonnées du pion à placer
						morpion.choixCoordonnees() ;
						
						iCoordonneeX = joueurTour.GetPositionPionX();
						iCoordonneeY = joueurTour.GetPositionPionY();
						
						// Méthode qui va afficher le plateau avec le pion positionné 
						afficherPlateau() ;					
	
						// Vérifie si le joueur a gagné:
						verifierAlignement(sGrille, iCoordonneeX, iCoordonneeY);
						if (GetiCptX()==4){
							System.out.println("\nPartie terminée: "+joueurTour.GetNomJoueur()+" a gagné en " + (i/2)+1 + " coups \n");
							break;
						}
						if (GetiCptY()==4){
							System.out.println("\nPartie terminée: "+joueurTour.GetNomJoueur()+" a gagné en " + (i/2)+1 + " coups \n");
							break;
						}
						if (GetiCptDiagDroite()==4){
							System.out.println("\nPartie terminée: "+joueurTour.GetNomJoueur()+" a gagné en " + (i/2)+1 + " coups \n");
							break;
						}
						if (GetiCptDiagGauche()==4){
							System.out.println("\nPartie terminée: "+joueurTour.GetNomJoueur()+" a gagné en " + (i/2)+1 + " coups \n");
							break;
						}
						
						// Changement de joueur pour le tour suivant :
						changementDeJoueur();
					}
					break; // Sortie du switch
					
				default:
				    System.out.println("Aucun jeu ne correspond à cette valeur.");
				break;
			}
		}
		//sc.close();
	}
		
	/**
	 * Configure les joueurs, choisit qui commence, récapitule le nom des 2 joueurs
	 *            
	 * @author Mamprin Florent
	 * 
	 * @version 1.0
	 */
	
	public static void parametrageJoueur(){
		
		int sortie=0;
		
		// Instance de la classe Scanner :
		Scanner sc = new Scanner(System.in);
			
		System.out.println("Nom du joueur 1 :");
		joueur1.SetNomJoueur(sc.nextLine());
	    
	    System.out.println("Nom du joueur 2 :");
	    joueur2.SetNomJoueur(sc.nextLine());
	    
	    while (sortie == 0){
		    // Choix des pions :
		    System.out.println("Type de pion pour "+joueur1.GetNomJoueur()+": O ou X ?");
		    // Récupère le 1er caractère :
		    char cTypeDePion = sc.next(".").charAt(0);
		    
		    switch (cTypeDePion)
			{
				case 'o':
				case 'O':
				case '0':
					joueur1.SetPionJoueur("O") ;
					joueur2.SetPionJoueur("X") ;
					sortie = 1;
					break;	
				
				case 'x':
				case 'X':
					joueur1.SetPionJoueur("X") ;
					joueur2.SetPionJoueur("O") ;
					sortie = 1;
				 	break;
			    
				default:
					System.out.println("Ce type de pion n'existe pas\n");
			}
	    }
	    
	    //Affichage des joueurs avec leur pion:
	    System.out.println("\n"+joueur1.GetNomJoueur()+": "+joueur1.GetPionJoueur());
	    System.out.println(joueur2.GetNomJoueur()+": "+joueur2.GetPionJoueur());
	    
	    //Le joueur qui a les "O" commencera la partie:
	    if (joueur1.GetPionJoueur() == "O"){
	    	joueurTour.SetNomJoueur(joueur1.GetNomJoueur());
	    	joueurTour.SetPionJoueur(joueur1.GetPionJoueur());
	    }
	    else{
	    	joueurTour.SetNomJoueur(joueur2.GetNomJoueur());
	    	joueurTour.SetPionJoueur(joueur2.GetPionJoueur());
	    }
	    
	    //Affichage du joueur qui débute:
	    System.out.printf(joueurTour.GetNomJoueur()+" commence");
	    
	    System.out.printf("\n\n	     "+joueur1.GetNomJoueur()+" vs "+joueur2.GetNomJoueur()+"\n");

	    	
	    //sc.close();
	}
	
	
	/**
	 * Affiche le tableau (soit notre plateau de jeu) avec les données qui le composent
	 *            
	 * @author Mamprin Florent
	 *  
	 * @version 1.0
	 */
	public static void afficherPlateau(){
		
		int i;		// Nombre de lignes
		int j;		// Nombre d'éléments par ligne
		int col; 	// Axe des abscisses

		
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
		    System.out.print(sGrille[i][j]);
		    System.out.print(" | ");
		    j++;
		  }
		  //retour à la ligne pour chaque ligne du tableau :
		  System.out.println("");
		  i++;
		}
		
		System.out.println("	¯   ¯   ¯   ¯   ¯   ¯   ¯   ¯");
		System.out.printf("      ");
		// Affichage du numéro de colonne :
		for (col=0; col<8; col++){
			System.out.printf("  "+(col+1)+" ");
		}
		System.out.println("");
	}
	
	/**
	 * Donne la main au joueur suivant. Change de joueur.
	 *            
	 * @author Mamprin Florent
	 *  
	 * @version 1.0
	 */
	
	public static void changementDeJoueur(){
		
		// Si je joueur du tour actuel est le joueur 1:
		if (joueurTour.GetNomJoueur() == joueur1.GetNomJoueur()) {
			// alors le joueur actuel devient le joueur 2 :
			joueurTour.SetNomJoueur(joueur2.GetNomJoueur());
			joueurTour.SetPionJoueur(joueur2.GetPionJoueur());
		}
		// Sinon l'inverse :
		else {
			joueurTour.SetNomJoueur(joueur1.GetNomJoueur());
			joueurTour.SetPionJoueur(joueur1.GetPionJoueur());
		}
		
	}
	
	/**
	 * Vérifie si le pion placé par le joueur lui permet de gagner la partie
	 *            
	 * @author Mamprin Florent
	 * 
	 * @param String[][]sMonTableau : La grille de notre jeu actuel
	 * int x : coordonée en abscisse du pion choisi par le joueur en cours
	 * int y : coordonée en ordonnée du pion choisi par le joueur en cours
	 *  
	 * @version 1.0
	 */
	public static void verifierAlignement(String[][]sMonTableau, int x, int y){
		
		int iCptX=1;	 			// Compteur de pion alignés: horizontalement
		SetiCptX(iCptX);
		int iCptY=1;  				// Compteur de pion alignés: verticalement
		SetiCptY(iCptY);
		int iCptDiagDroite=1; 		// Compteur de pion alignés: diagonale droite
		SetiCptDiagDroite(iCptDiagDroite);
		int iCptDiagGauche=1; 		// Compteur de pion alignés diagonale gauche
		SetiCptDiagGauche(iCptDiagGauche);
		
		// Vérif horizontale en partant vers la droite
		if((x<7)&&(sMonTableau[y][x+1] == joueurTour.GetPionJoueur())){
			iCptX +=1;
			SetiCptX(iCptX);		
			// 2ème case à droite
			if((x<6)&&(sMonTableau[y][x+2] == joueurTour.GetPionJoueur())){
				iCptX +=1;
				SetiCptX(iCptX);
			}				
			// 3ème case à droite
			if((x<5)&&(sMonTableau[y][x+3] == joueurTour.GetPionJoueur())){
				iCptX +=1;
				SetiCptX(iCptX);
			}
					
		}
		// Vérif horizontale en partant vers la gauche
		if((x>0)&&(sMonTableau[y][x-1] == joueurTour.GetPionJoueur())){
			iCptX +=1;
			SetiCptX(iCptX);
			// 2ème case à gauche
			if((x>1)&&(sMonTableau[y][x-2] == joueurTour.GetPionJoueur()))
			{
				iCptX +=1;
				SetiCptX(iCptX);
			}
			// 3ème case à gauche
			if((x>2)&&(sMonTableau[y][x-3] == joueurTour.GetPionJoueur())){
				iCptX +=1;
				SetiCptX(iCptX);
			}
		}
		
		// Vérif vertical en partant vers le bas
		if((y<7)&&(sMonTableau[y+1][x] == joueurTour.GetPionJoueur())){
			iCptY +=1;
			SetiCptY(iCptY);
			// 2ème case vers le bas
			if((y<6)&&(sMonTableau[y+2][x] == joueurTour.GetPionJoueur())){
				iCptY +=1;
				SetiCptY(iCptY);
			}
			// 3ème vers le bas
			if((y<5)&&(sMonTableau[y+3][x] == joueurTour.GetPionJoueur())){
				iCptY +=1;
				SetiCptY(iCptY);
			}			
		}
		
		// Vérif vertical en partant vers le haut
		if((y>0)&&(sMonTableau[y-1][x] == joueurTour.GetPionJoueur())){
			iCptY +=1;
			SetiCptY(iCptY);
			// 2ème case vers le haut
			if((y>1)&&(sMonTableau[y-2][x] == joueurTour.GetPionJoueur())){
				iCptY +=1;
				SetiCptY(iCptY);
			}
				// 3ème case vers le haut
				if((y>2)&&(sMonTableau[y-3][x] == joueurTour.GetPionJoueur()))
				{
					iCptY +=1;
					SetiCptY(iCptY);
				}
		}
		
		// Diagonale Droite montante: 1ère case en haut à droite
		if((x<7)&&(y>0)&&(sMonTableau[y-1][x+1] == joueurTour.GetPionJoueur())){
			iCptDiagDroite +=1;
			SetiCptDiagDroite (iCptDiagDroite);
			// 2ème case en haut à droite
			if((x<6)&&(y>1)&&(sMonTableau[y-2][x+2] == joueurTour.GetPionJoueur()))
			{
				iCptDiagDroite +=1;
				SetiCptDiagDroite (iCptDiagDroite);
			}				
			// 3ème case en haut à droite
			if((x<5)&&(y>2)&&(sMonTableau[y-3][x+3] == joueurTour.GetPionJoueur())){
				iCptDiagDroite +=1;
				SetiCptDiagDroite (iCptDiagDroite);
			}
		}
		
		// Diagonale Droite descendante: 1ère case en bas à gauche
		if((x>0)&&(y<7)&&(sMonTableau[y+1][x-1] == joueurTour.GetPionJoueur())){
			iCptDiagDroite +=1;
			SetiCptDiagDroite (iCptDiagDroite);
			// 2ème case en bas à gauche
			if((x>1)&&(y<6)&&(sMonTableau[y+2][x-2] == joueurTour.GetPionJoueur())){
				iCptDiagDroite +=1;
				SetiCptDiagDroite (iCptDiagDroite);
			}				
				// 3ème case en bas à gauche
				if((x>2)&&(y<5)&&(sMonTableau[y+3][x-3] == joueurTour.GetPionJoueur())){
					iCptDiagDroite +=1;
					SetiCptDiagDroite (iCptDiagDroite);
				}
		}
		
		// Diagonale Gauche montante: 1ère case en haut à gauche
		if((x>0)&&(y>0)&&(sMonTableau[y-1][x-1] == joueurTour.GetPionJoueur())){
			iCptDiagGauche +=1;
			SetiCptDiagGauche(iCptDiagGauche);
			// 2ème case en haut à gauche
			if((x>1)&&(y>1)&&(sMonTableau[y-2][x-2] == joueurTour.GetPionJoueur())){
				iCptDiagGauche +=1;
				SetiCptDiagGauche(iCptDiagGauche);
			}				
			// 3ème case en haut à gauche
			if((x>2)&&(y>2)&&(sMonTableau[y-3][x-3] == joueurTour.GetPionJoueur())){
				iCptDiagGauche +=1;
				SetiCptDiagGauche(iCptDiagGauche);
			}
		}
		
		// Diagonale Gauche descendante: 1ère case en bas à droite
		if((x<7)&&(y<7)&&(sMonTableau[y+1][x+1] == joueurTour.GetPionJoueur())){
			iCptDiagGauche +=1;
			SetiCptDiagGauche(iCptDiagGauche);
			// 2ème case en bas à droite
			if((x<6)&&(y<6)&&(sMonTableau[y+2][x+2] == joueurTour.GetPionJoueur())){
				iCptDiagGauche +=1;
				SetiCptDiagGauche(iCptDiagGauche);
			}				
				// 3ème case en bas à droite
				if((x<5)&&(y<5)&&(sMonTableau[y+3][x+3] == joueurTour.GetPionJoueur())){
					iCptDiagGauche +=1;
					SetiCptDiagGauche(iCptDiagGauche);
				}
		}
		
		//Compteur de pions alignés, pour test unitaire
//		System.out.println("\nCompteur de x: "+ GetiCptX());
//		System.out.println("\nCompteur de y: "+ GetiCptY());
//		System.out.println("\nCompteur de diag Droite: "+ GetiCptDiagDroite());
//		System.out.println("\nCompteur de diag Gauche: "+ GetiCptDiagGauche());
		
	}
}