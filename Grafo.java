import java.util.ArrayList;

public class Grafo {

	private int[][] MATRIX;
    private ArrayList ciudades = new ArrayList();
    private int vertex;
// Creacion matriz
    public boolean createMatrix(ArrayList datos){
        ArrayList<Grafo2> listaGrafo2 = new ArrayList<Grafo2>();
        ciudades.clear();
        int from = 0;
        int to = 0;
        int arrive = 0;
        for(int control=0; control < datos.size();control++){

            String[] info = datos.get(control).toString().split(" ");

            if(!ciudades.contains(info[0])){
                ciudades.add(info[0]);
                from = ciudades.indexOf(info[0]);
            }
            else{
                from = ciudades.indexOf(info[0]);
            }

            if(!ciudades.contains(info[1])){
                ciudades.add(info[1]);
                to = ciudades.indexOf(info[1]);
            }
            else{
                to = ciudades.indexOf(info[1]);
            }

            try{
                arrive = Integer.parseInt(info[2]);
            }
            catch (Exception e){
                System.out.println("\n\n\t\t\tPor favor, carga de nuevo el archivo. Algo esta mal.. ");
                return false;
            }
            listaGrafo2.add(new Grafo2(from,to,arrive));

        }
        vertex = ciudades.size();
        MATRIX = new int[vertex + 1][vertex + 1];

        for(int control = 0; control<listaGrafo2.size(); control++)
        {
            Grafo2 actual = listaGrafo2.get(control);
            int startVertex = actual.startVertex;
            int endVertex = actual.endVertex;
            int weight = actual.weight;
            MATRIX[startVertex][endVertex] = weight;
        }
        return true;
    }

    public void printMatrix()
    {
        for(int i = 0; i< vertex; i++)
        {
            for(int j=0; j< vertex;j++)
            {
                System.out.print(MATRIX[i][j] + " ");
            }
            System.out.println();
        }

    }
    public void FloydAlgorithm(){ 
        FloydWarshall.floydWarshall(MATRIX, vertex,ciudades);
    }
	
}
