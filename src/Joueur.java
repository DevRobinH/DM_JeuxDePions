public class Joueur {

	private String sNomJoueur;
	private String sPionJoueur;
	private int iPositionPionX;
	private int iPositionPionY;
	
	// Constructeur par défaut
	public Joueur() {
		sNomJoueur = " ";
		sPionJoueur = " ";
	}
	
	// Constructeur paramétré : bot
	public Joueur(String sNomJoueur, String sPionJoueur) {
		this.sNomJoueur = sNomJoueur;
		this.sPionJoueur = sPionJoueur;
	}
	
	// Méthodes d'accès à nomJoueur:
	public String GetNomJoueur(){
		return sNomJoueur;
	}
	
	public void SetNomJoueur(String sNomJoueur){
		this.sNomJoueur = sNomJoueur;
	}
	
	// Méthodes d'accès à pionJoueur:
	public String GetPionJoueur(){
		return sPionJoueur;
	}
	
	public void SetPionJoueur(String sPionJoueur){
		this.sPionJoueur = sPionJoueur;
	}
	
	// Méthodes d'accès à positionPionX:
	public int GetPositionPionX(){
		return iPositionPionX;
	}
	
	public void SetPositionPionX(int iPositionPionX){
		this.iPositionPionX = iPositionPionX;
	}

	// Méthodes d'accès à positionPionX:
	public int GetPositionPionY(){
		return iPositionPionY;
	}
	
	public void SetPositionPionY(int iPositionPionY){
		this.iPositionPionY = iPositionPionY;
	}

}