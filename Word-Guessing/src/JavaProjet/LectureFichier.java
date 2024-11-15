package JavaProjet;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class LectureFichier {
	
	
	
	public static ArrayList<String> dictionnaire(){
    

    // Création de l'ArrayList pour stocker les mots fr
    final ArrayList<String> dictionnaire = new ArrayList<String>();

    // Lecture du fichier
    try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Lenovo\\eclipse-workspace\\JavaProjet\\dictionnaire.txt"))) {
        String ligne;
        // Parcours des lignes du fichier
        while ((ligne = br.readLine()) != null) {
            // Séparation des dictionnaire par des espaces
            String[] motsLigne = ligne.split(" ");

            // Ajout des mots à l'ArrayList
            for (String mot : motsLigne) {
                dictionnaire.add(mot);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    
  
    

  return dictionnaire;
}


	
}
