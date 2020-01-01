
package EDD;

import java.io.IOException;

public class HashTable {
    
    public NodoUsuario arreglo[];
    static int tamanio ;
    public NodoUsuarioRechazo arregloRechazo[];
    int cont = 0;
    int h;
    
    //METODO CONTRUCTOR DE  LA TABLA HASH
    public HashTable() {
        tamanio=37;
        h=0;
        arreglo = new NodoUsuario[37];
        arregloRechazo = new NodoUsuarioRechazo[50];
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
            if(p.length()>=8){
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
            }else{
                arregloRechazo[h]=new NodoUsuarioRechazo(n, a, c, p,"CONSTRASEÑA INVALIDA");
                h++;
            }    
        }
        else{
            //System.out.println("existe usuario");
            arregloRechazo[h]=new NodoUsuarioRechazo(n, a, c, p,"USUARIO EXISTENTE");
            h++;
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
    //MUESTRA LOS USUARIOS QUE NO SE ASIGNARON POR UN MOTIVO INCLUYE RAZON POR LA CUAL
    public void Mostrar_Rechazos(){
        for (int i = 0; i < arregloRechazo.length; i++) {
            if(arregloRechazo[i]!=null){
                System.out.println(i+"-"+arregloRechazo[i].getCarnet()+"-"
                +arregloRechazo[i].getPassword()+"-"
                +arregloRechazo[i].getNombre()+"-"
                +arregloRechazo[i].getApellido()+"-"
                +arregloRechazo[i].getRazon());
            }
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
    
    public static String graficar(String ruta, String nombre) {
        try {
            String dotPath = "C:\\Users\\tracs\\Desktop\\";
            String fileInputPath = ruta;
            String fileOutputPath = dotPath+ nombre;
            String tParam = "-Tjpg";
            String tOParam = "-o";
            String[] cmd = new String[5];
            cmd[0] = dotPath;
            cmd[1] = tParam;
            cmd[2] = fileInputPath;
            cmd[3] = tOParam;
            cmd[4] = fileOutputPath;
            Runtime rt = Runtime.getRuntime();
            rt.exec(cmd);
        } catch (IOException e) {
            return "ERROR " + e.toString();
            //e.printStackTrace();
        }
        return "Generado con exito";
    }
    
}
