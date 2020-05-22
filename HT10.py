import networkx as nx

def addNodes(node):
    if node not in allNodos:
        G.add_node(node)
        D.add_node(node)
# agrega o elimina los nodos
def addEdge(node1,node2,weight1):
    G.add_edge(node1,node2,weight=weight1)
    D.add_edge(node1,node2,weight=weight1)

def eliminateEdge(node1,node2):
    G.remove_edge(node1,node2)
    D.remove_edge(node1,node2)

def buscarRuta(node1,node2):
    try:
        floyd=nx.fw_predecessor_distance(D,None) 
        city1=floyd[0][node1][node2]
        route=[]
        route.append(city1) 
        while city1!=node1:
            newCity=floyd[0][node1][city1] 
            route.append(newCity) 
            city1=newCity 
        count=0
        tope=len(route)-1
        orderRoute=[]
        while count < len(route)-1:
            orderRoute.append(route[tope-1]) 
            tope-=1
            count+=1
            # despliega ruta
        if len(orderRoute)!=0:
            print ("Tu opción para la ruta más corta es desde "+node1+" a "+node2+" es la siguiente: ")
            print (orderRoute)
            print ('\n')
        else:
            print ("Esta ruta es la más corta y es directa\n")
    except Exception:
        print ("No encontramos una ruta para este traslado :( \n")

def Validate(texto):
    si=True
    try:
        float(texto)
    except:
        si=False
    return si
# centro grafo
G = nx.Graph() 
D = nx.DiGraph()
allArrays=[]
# abrir txt
archivo = open("guategrafo.txt","r")
for line in archivo:
    array=line.split()
    allNodos=G.nodes()
    allArrays.append(array)
    addNodes(array[0])
    addNodes(array[1])
    addEdge(array[0],array[1],array[2])

# Inicio
ciclo=0
while ciclo==0:
    opcion= input("Bienvenido a tu menú\n>>1. Encontrar ruta eficiente\n>>2. Centro del grafo\n>>3. Problemas o circumnstancias\n>>4. Nueva ruta\n>>5. Salir del menú \n>")
    if opcion=="1":
        ciudad1=input("Por favor, ingresa el nombre de la ciudad sin espacios: ")
        while ciudad1 not in allNodos:
            ciudad1=input("Lo siento no encontramos la ciudad, intentalo de nuevo!: ")
        ciudad2=input("¿A que ciudad deseas llegar?: ")
        while ciudad2 not in allNodos:
            ciudad2=input("Lo siento no encontramos la ciudad, intentalo de nuevo!: ")
        buscarRuta(ciudad1,ciudad2)
        ciclo=0
    if opcion=="2":
        try:
            print (nx.center(G,None))
        except Exception:
            print ("No existe")
        ciclo=0
    if opcion=="3":
        try:
            ciudad1=input("Por favor, ingresa el nombre de la ciudad sin espacios: ")
            ciudad2=input("¿A que ciudad deseas llegar? Si esta no se encuentra conectada con la ciudad que ingreso anteriormente no se realizara ninguna acción: ")
            eliminateEdge(ciudad1,ciudad2)
            print ("El proceso de eliminación se realizo con exito!")
            print (D.edges)
        except Exception:
            print ("Lo sentimos, alguno de esos nodos no existe en este programa..")
        ciclo=0
    if opcion=="4":
        ciudad1=input("Por favor, ingresa el nombre de la ciudad sin espacios: ")
        ciudad2=input("¿A que ciudad deseas llegar?")
        km=input("¿Cuales son los KM entre estas ciudades")
        while not Validate(km):
            km=input("Por favor, ingresa la cantidad en números: ")
        addNodes(ciudad1)
        addNodes(ciudad2)
        addEdge(ciudad1,ciudad2,km)
        ciclo=0
    if opcion=="5":
        print ("Has salido del programa. ")
        ciclo=1
