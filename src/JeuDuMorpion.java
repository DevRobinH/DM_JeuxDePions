import java.util.Scanner;

public class JeuDuMorpion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Test modif nouvel user
	}
	
	public void reglesDuJeu() {
		String regles = "\nR�gles du jeu :\n\n"+
				"Le but du jeu est d'aligner une suite de 4 pions de m�me type sur une grille.\n"+
				"Tour � tour les deux joueurs placent un pion sur le plateau.\n" +
				"Le vainqueur est le joueur qui r�alise le premier un alignement (horizontal, vertical ou diagonal) cons�cutif d'au moins quatre de ses pions.\n" + 
				"Si, alors que toutes les cases de la grille de jeu sont remplies, aucun des deux joueurs n'a r�alis� un tel alignement, la partie est d�clar�e nulle.\n";
	
		System.out.println(regles);
	}
	
	public void choixCoordonnees() {
		
		//Instance de la classe Scanner:
		Scanner sc = new Scanner(System.in);
		
		//Instance de la classe PlateauJeu:
		PlateauJeu plateau = new PlateauJeu();
		
	    System.out.println("\n"+PlateauJeu.nomJoueur1+", choisissez une coordonn�e pour y placer votre jeton("+plateau.pionJoueur1+"):");
	    
	}
}
