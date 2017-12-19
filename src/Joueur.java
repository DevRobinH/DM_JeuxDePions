public class Joueur {

	private String sNomJoueur;
	private String sPionJoueur;
	private int iPositionPionX;
	private int iPositionPionY;
	
	// Constructeur par d�faut
	public Joueur() {
		sNomJoueur = " ";
		sPionJoueur = " ";
	}
	
	// Constructeur param�tr� : bot
	public Joueur(String sNomJoueur, String sPionJoueur) {
		this.sNomJoueur = sNomJoueur;
		this.sPionJoueur = sPionJoueur;
	}
	
	// M�thodes d'acc�s � nomJoueur:
	public String GetNomJoueur(){
		return sNomJoueur;
	}
	
	public void SetNomJoueur(String sNomJoueur){
		this.sNomJoueur = sNomJoueur;
	}
	
	// M�thodes d'acc�s � pionJoueur:
	public String GetPionJoueur(){
		return sPionJoueur;
	}
	
	public void SetPionJoueur(String sPionJoueur){
		this.sPionJoueur = sPionJoueur;
	}
	
	// M�thodes d'acc�s � positionPionX:
	public int GetPositionPionX(){
		return iPositionPionX;
	}
	
	public void SetPositionPionX(int iPositionPionX){
		this.iPositionPionX = iPositionPionX;
	}

	// M�thodes d'acc�s � positionPionX:
	public int GetPositionPionY(){
		return iPositionPionY;
	}
	
	public void SetPositionPionY(int iPositionPionY){
		this.iPositionPionY = iPositionPionY;
	}

}