import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Respuesta {
	
    public static String getDataFile(String PATH_FILE){
        BufferedReader reader;
        String line,data = "";

        try{
            reader = new BufferedReader(new FileReader(PATH_FILE));

            while((line = reader.readLine()) != null){
                data += line + "\t";
            }
            reader.close();

        }
        
        catch(Exception e){
            e.printStackTrace();
        }

        return data;
    }

    
    public static String getDataFile(String PATH_FILE,String SALTO){
        BufferedReader reader;
        String line,data = "";

        try{
            reader = new BufferedReader(new FileReader(PATH_FILE));

            while((line = reader.readLine()) != null){
                data += line + SALTO;
            }
            
            reader.close();

        }

        catch(Exception e){
            e.printStackTrace();
        }

        return data;
    }
    
    
    public static boolean getExists(String PATH_FILE){
        return (new File(PATH_FILE)).exists();
    }

   
    public static List getFileTokens(String DELIMITADOR, String PATH_FILE){

        return Collections.list(new StringTokenizer(Respuesta.getDataFile(PATH_FILE), DELIMITADOR)).stream()
                .map(token -> (String) token)
                .collect(Collectors.toList());
    }

   
    public static List getStringTokens(String DELIMITADOR, String VALUE){

        return Collections.list(new StringTokenizer(VALUE, DELIMITADOR)).stream()
                .map(token -> (String) token)
                .collect(Collectors.toList());

    }

    
    public static Object getAtom(String VALUE) {
        try {
            // return int
            return Integer.parseInt(VALUE);
        }
        catch (NumberFormatException e) {
            try {
                // return float
                return Float.parseFloat(VALUE);
            }
            catch (NumberFormatException e2) {
                try {
                    // return decimal
                    return Double.parseDouble(VALUE);
                }
                catch (NumberFormatException e3) {
                    //return string
                    return VALUE;
                }
            }
        }
    }
}
