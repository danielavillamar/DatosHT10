import java.util.ArrayList;

// DANIELA VILLAMAR
// 19086
// HT10 (ULTIMA)

public class Main {
	final static String MENU_INICIO = "\n\t\t\t\tMenú" +
            "\n\t1.) Nuevo Archivo" +
            "\n\t2.) Salida";
    final static String INSTRUCCIONES = "\n¿Que desea hacer hoy?";

    public static void main(String[] args){
        
        int opcion = 0;
        while(true){

        
            System.out.println(MENU_INICIO);
            System.out.print(INSTRUCCIONES);
// Tipo scanner para ver que opción 
            opcion = Keyboard.readInt();

            switch (opcion){
                case 1:
                    System.out.print("\n¿Path?");
                    String path = Keyboard.readString();

                    if(Resource.getExists(path)){
                        String dato = Resource.getDataFile(path,";");
                        try{
                            ArrayList info = (ArrayList)Resource.getStringTokens(";",dato);

                            if(!info.isEmpty()){
                                //Creando matriz adyacente
                                Grafo grafo = new Grafo();
                                if(grafo.createMatrix(info)){
                                    grafo.printMatrix();
                                    System.out.println("\nListo! ");
                                    grafo.FloydAlgorithm();
                                }
                                else{
                                    System.out.println("\n\n\t\t\tIntentalo de nuevo, ocurrio un problema :( ");
                                    break;
                                }
                            }
                            else{
                                System.out.println("\n\n\t\t\tParece que no hay nada que hacer.. ");
                            }

                        }
                        catch (Exception e){
                            System.out.println(e.toString());
                        }

                    }
                    else{
                        System.out.println("\n\t\tOpss, no encontramos tu archivo! :( \n");
                    }
                    break;
                case 2:
                    System.exit(0);
            }
        }

    }

}
