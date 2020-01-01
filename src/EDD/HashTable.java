
package EDD;

public class HashTable {
    
    public NodoUsuario arreglo[];
    static int tamanio ;
    int cont = 0;
    //METODO CONTRUCTOR DE  LA TABLA HASH
    public HashTable() {
        tamanio=37;
        arreglo = new NodoUsuario[37];
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = new NodoUsuario("-1", "-1", "-1","-1");
        }
    }
    
    static int primo;
    static int primoMayorSiguiente;
    //INGRESA CON EL FORMATO DEL ARCHIVO USUARIOS.JSON 
    public void Ingresar(String n, String a, String c, String p){
        NodoUsuario Nodo = new NodoUsuario(n, a, c, p);
        String pasanum = Nodo.getCarnet();
        String numsin;
        numsin = pasanum.replaceAll("[-]", "");
        int  carne = Integer.parseInt(numsin);
        int indice = (int)(carne % arreglo.length);
        if (!carnet_existe(c)) {
            if(PorcentajeLLeno()){
                //SE INGRESA NODO
                if(("-1".equals(arreglo[indice].getCarnet()))){
                    arreglo[indice] = Nodo;
                }
                else{
                    //COLISION
                    int ite =0;
                    boolean colisionCompleta = true;
                    while(colisionCompleta){
                        indice = (int)(((carne % 7)+1)*ite);
                        if("-1".equals(arreglo[indice].getCarnet())){
                            arreglo[indice] = Nodo;
                            colisionCompleta = false;
                        }
                        ite++;
                    }
                }
            }else{
                //EL ARREGLO CRECE 
                //System.out.println("PORCENTAJE LLEGO A MAS DEL 55%");
                AumentoTamanio();
                //Ingresar(n, a, c, p);
            }
        }
        else{
            System.out.println("existe usuario");
        }
    }
    //MUESTAR LOS VALORES DE CADA ELEMENTO EN EL ARREGLO
    public void Mostrar(){
        for (int i = 0; i < arreglo.length; i++) {
            System.out.println(i+"-"+arreglo[i].getCarnet()+"-"
            +arreglo[i].getPassword()+"-"
            +arreglo[i].getNombre()+"-"
            +arreglo[i].getApellido());
        }
    }
    //METODO AUMENTA EL TAMANIO DEL ARREGLO AL PROXIMO NUMERO PRIMO        
    public void AumentoTamanio(){
        int nuevoTamnio = primoSiguiente();
        tamanio = nuevoTamnio;
        System.out.println(tamanio);
        NodoUsuario arregloaux[] = new NodoUsuario[nuevoTamnio];
        for (int i = 0; i < arregloaux.length; i++) {
            arregloaux[i] = new NodoUsuario("-1", "-1", "-1","-1");
        }
        for (int i = 0; i < arreglo.length; i++) {
            if(!"-1".equals(arreglo[i].getCarnet())){
                NodoUsuario Nodo = arreglo[i];
                int  carne = Integer.parseInt(Nodo.getCarnet());
                int indice = (int)(carne % arregloaux.length);
                if(("-1".equals(arregloaux[indice].getCarnet()))){
                    arregloaux[indice] = Nodo;
                }
                else{
                    //COLISION
                    int ite =0;
                    boolean colisionCompleta = true;
                    while(colisionCompleta){
                        indice = (int)(((carne % 7)+1)*ite);
                        if("-1".equals(arregloaux[indice].getCarnet())){
                            arregloaux[indice] = Nodo;
                            colisionCompleta = false;
                        }
                        ite++;
                    }
                }
            }
        }
        arreglo = new NodoUsuario[nuevoTamnio];
        arreglo = arregloaux;
    }        
    //METODO DEVUELVE EL PRIMO SIGUIENTE A TAMANIO ACTUAL
    public static int primoSiguiente() {
        int aux = tamanio+1;
        int a = 0;
        while(true){
            a=0;
            for(int i=1;i<=aux;i++){
                if(aux%i==0){
                    a++;
                }
            }
            if(a==2){
                break;
            }
            else{
//                             
            }
            aux++;
        }
        return aux;
    }
    //METODO DEVUELVE SI EL PORCENTAJE FUE REVASADO O NO 
    public boolean PorcentajeLLeno(){
        int porc =(int)(tamanio * 0.55);
        return porc >tamanioTablaHash();
    }
    //RETORNA EL TAMANIO DEL ARREGLO HASH CON LOS ELEMENTOS NO NULOS
    public int tamanioTablaHash() {
        int contador = 0;
        for (NodoUsuario arreglo1 : arreglo) {
            if (!"-1".equals(arreglo1.getCarnet())) {
                contador++;
            }
        }
        return contador;
    }
    //BUSCAR UN ELEMENTO POR CARNE devuelve la PASSWORD
    public String buscar_carne(String carn){
        for (int i = 0; i < arreglo.length; i++) {
            if(arreglo[i].getCarnet().equals(carn)){
                return arreglo[i].getPassword();
            }
        }
        return "";
    }
    //COMPRUEBA SI YA EXISTE UN CARNET EN EL ARREGLO
    public boolean carnet_existe(String carn){
        for (int i = 0; i < arreglo.length; i++) {
            if(arreglo[i].getCarnet().equals(carn)){
                return true;
            }
        }
        return false;
    }
    
}
