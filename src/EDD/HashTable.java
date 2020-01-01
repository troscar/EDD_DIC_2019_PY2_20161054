
package EDD;

public class HashTable {
    
    static NodoUsuario arreglo[];
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
    
    public void Ingresar(String n, String a, String c, String p){
        NodoUsuario Nodo = new NodoUsuario(n, a, c, p);
        int  carne = Integer.parseInt(Nodo.getCarnet());
        int indice = (int)(carne % arreglo.length);
        for(int i = 0;i<arreglo.length;i++){
            if(PorcentajeLLeno()){
                //SE INGRESA NODO
                if((i==indice)&&("-1".equals(arreglo[i].getCarnet()))){
                    arreglo[i] = Nodo;
                }
                else{
                    
                }
            }else{
                //EL ARREGLO CRECE 
            }
        }
    }
            
    public void AumentoTamanio(){
        
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
                //System.out.println("primo");
                //System.out.println(aux);
                break;
                //if(aux>tamanio){
                //    break;}
            }
            else{
//                System.out.println("No primo");
                //System.out.println(aux);
                
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
        for (int i = 0; i < arreglo.length; i++) {
            if (!arreglo[i].getApellido().equals("-1")) {
                contador++;
            }
        }
        return contador;
    }
    
}
