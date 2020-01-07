/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EDD;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Oscar
 */
public class AVLTree {
//----------------------------------------------CLASE NODO AVL-----------------------------------------------------------

    

    NodoAVL raiz;

    public AVLTree() {
        this.raiz = null;
    }

    public int getFactEq(NodoAVL x) {
        if (x == null) {
            return -1;
        } else {
            return x.factEq;
        }
    }
    public String buscarAVL(int no, NodoAVL r) {
        
        if (raiz == null) {
            return "no";
        } else if (r.noIdentificacion == no) {
            //System.out.println("encontro id " + r.nombre);
            return Integer.toString(r.noIdentificacion);
        } else if (r.noIdentificacion < no) {
            //System.out.println("encontro id " + r.nombre);
            return buscarAVL(no, r.hijoDerecho);
        } else{
            //System.out.println("encontro id " + r.nombre);
            return buscarAVL(no, r.hijoIzquierdo);
        }
    }
    public String apuntCate(NodoAVL r) {
        StringBuilder b = new StringBuilder();
         if (r.hijoDerecho == null && r.hijoIzquierdo == null) {
            b.append(r.noIdentificacion+",");
        } else {
           b.append(r.noIdentificacion+",");
        }
        if (r.hijoIzquierdo != null) {
            b.append(apuntCate(r.hijoIzquierdo)+",");
        }
        if (r.hijoDerecho != null) {
            b.append(apuntCate(r.hijoDerecho)+",");
        }
        return b.toString();
    }

    public NodoAVL rotIzq(NodoAVL arbol) {
        NodoAVL temp = arbol.hijoIzquierdo;
        arbol.hijoIzquierdo = temp.hijoDerecho;
        temp.hijoDerecho = arbol;
        arbol.factEq = Math.max(getFactEq(arbol.hijoIzquierdo), getFactEq(arbol.hijoDerecho)) + 1;//Fact de EQ +1
        temp.factEq = Math.max(getFactEq(temp.hijoIzquierdo), getFactEq(temp.hijoDerecho)) + 1;//Fact de EQ +1
        return temp;
    }

    public NodoAVL rotDer(NodoAVL arbol) {
        NodoAVL temp = arbol.hijoDerecho;
        arbol.hijoDerecho = temp.hijoIzquierdo;
        temp.hijoIzquierdo = arbol;
        arbol.factEq = Math.max(getFactEq(arbol.hijoIzquierdo), getFactEq(arbol.hijoDerecho)) + 1;//Fact de EQ +1
        temp.factEq = Math.max(getFactEq(temp.hijoIzquierdo), getFactEq(temp.hijoDerecho)) + 1;//Fact de EQ +1
        return temp;
    }

    public NodoAVL rotDobleIzq(NodoAVL arbol) {
        NodoAVL aux;
        arbol.hijoIzquierdo = rotDer(arbol.hijoIzquierdo);
        aux = rotIzq(arbol);
        return aux;
    }

    public NodoAVL rotDobleDer(NodoAVL arbol) {
        NodoAVL aux;
        arbol.hijoDerecho = rotIzq(arbol.hijoDerecho);
        aux = rotDer(arbol);
        return aux;
    }

    public NodoAVL insertarAVL(NodoAVL nuevo, NodoAVL subArbol) {

        NodoAVL nuevoPadre = subArbol;
        if (nuevo.noIdentificacion < subArbol.noIdentificacion) {
            if (subArbol.hijoIzquierdo == null) {
                subArbol.hijoIzquierdo = nuevo;
            } else {
                subArbol.hijoIzquierdo = insertarAVL(nuevo, subArbol.hijoIzquierdo);
                if ((getFactEq(subArbol.hijoIzquierdo) - getFactEq(subArbol.hijoDerecho) == 2)) {
                    //Desbalanceo
                    if (nuevo.noIdentificacion < subArbol.hijoIzquierdo.noIdentificacion) {
                        nuevoPadre = rotIzq(subArbol);
                    } else {
                        nuevoPadre = rotDobleIzq(subArbol);
                    }
                }
            }
        } else if (nuevo.noIdentificacion > subArbol.noIdentificacion) {
            if (subArbol.hijoDerecho == null) {
                subArbol.hijoDerecho = nuevo;
            } else {
                subArbol.hijoDerecho = insertarAVL(nuevo, subArbol.hijoDerecho);
                if ((getFactEq(subArbol.hijoDerecho) - getFactEq(subArbol.hijoIzquierdo) == 2)) {
                    if (nuevo.noIdentificacion > subArbol.hijoDerecho.noIdentificacion) {
                        nuevoPadre = rotDer(subArbol);
                    } else {
                        nuevoPadre = rotDobleDer(subArbol);
                    }
                }
            }
        } else {
            //Nodo duplicado
            System.out.println("Nodo Duplicado, No se inserta");
        }
        //Actualizando el FE
        if ((subArbol.hijoIzquierdo == null) && (subArbol.hijoDerecho != null)) {
            subArbol.factEq = (subArbol.hijoDerecho.factEq + 1);
        } else if ((subArbol.hijoDerecho == null) && (subArbol.hijoIzquierdo != null)) {
            subArbol.factEq = (subArbol.hijoIzquierdo.factEq + 1);
        } else {
            subArbol.factEq = Math.max(getFactEq(subArbol.hijoIzquierdo), getFactEq(subArbol.hijoDerecho)) + 1;
        }
        return nuevoPadre;
    }

    public void insertar(int id) {
        NodoAVL nuevo = new NodoAVL(id);
        if (raiz == null) {
            raiz = nuevo;
        } else {
            raiz = insertarAVL(nuevo, raiz);
        }
    }

    public NodoAVL ObtRaiz() {
        return raiz;
    }

    public void modificar(int id) {
        NodoAVL aux = raiz;
        while (aux.noIdentificacion != id) {
            if (aux.noIdentificacion < id) {
                aux = aux.hijoDerecho;
                System.out.println("izquierdo: "+aux.noIdentificacion);
            } else {
                System.out.println("derecho: "+aux.noIdentificacion);
                aux = aux.hijoIzquierdo;
            }
            if (aux == null) {
                break;
            }
        }
    }

    public boolean eliminar(int id) {
        NodoAVL auxiliar = raiz;
        NodoAVL padre = raiz;
        boolean esHijoIzq = true;
        while (auxiliar.noIdentificacion != id) {
            padre = auxiliar;
            if (auxiliar.noIdentificacion < id) {
                esHijoIzq = true;
                auxiliar = auxiliar.hijoIzquierdo;
            } else {
                esHijoIzq = false;
                auxiliar = auxiliar.hijoDerecho;
            }
            if (auxiliar == null) {
                return false;
            }
        }//fin del while
        if (auxiliar.hijoIzquierdo == null && auxiliar.hijoDerecho == null) {
            if (auxiliar == raiz) {
                raiz = null;
            } else if (esHijoIzq) {
                //SI es hoja izquierda
                padre.hijoIzquierdo = null;
            } else {
                //SI es hoja derecha
                padre.hijoDerecho = null;
            }
        } else if (auxiliar.hijoDerecho == null) {
            if (auxiliar == raiz) {
                raiz = auxiliar.hijoIzquierdo;
            } else if (esHijoIzq) {
                padre.hijoIzquierdo = auxiliar.hijoIzquierdo;
            } else {
                padre.hijoDerecho = auxiliar.hijoIzquierdo;
            }
        } else if (auxiliar.hijoIzquierdo == null) {
            if (auxiliar == raiz) {
                raiz = auxiliar.hijoDerecho;
            } else if (esHijoIzq) {
                padre.hijoIzquierdo = auxiliar.hijoDerecho;
            } else {
                padre.hijoDerecho = auxiliar.hijoDerecho;
            }
        } else {
            NodoAVL reemplazo = obtenerNodoReemplazo(auxiliar);
            if (auxiliar == raiz) {
                raiz = reemplazo;
            } else if (esHijoIzq) {
                padre.hijoIzquierdo = reemplazo;
            } else {
                padre.hijoDerecho = reemplazo;
            }
            reemplazo.hijoIzquierdo = auxiliar.hijoIzquierdo;
        }
        return true;
    }
    //Metodo encargado de devolvernos el nodo Reemplazo

    public NodoAVL obtenerNodoReemplazo(NodoAVL nodoReemp) {
        //nodoReemp -> es el nodo que vamos a reemplazar
        NodoAVL reemplazarPadre = nodoReemp;
        NodoAVL reemplazo = nodoReemp;
        NodoAVL auxiliar = nodoReemp.hijoDerecho;
        while (auxiliar != null) {
            reemplazarPadre = reemplazo;
            reemplazo = auxiliar;
            auxiliar = auxiliar.hijoIzquierdo;
        }
        if (reemplazo != nodoReemp.hijoDerecho) {
            reemplazarPadre.hijoIzquierdo = reemplazo.hijoDerecho;
            reemplazo.hijoDerecho = nodoReemp.hijoDerecho;
        }
        return reemplazo;
    }

    String concatenacion = "";

    public void concat(NodoAVL r) {
        if (r != null) {
            //System.out.println("DATO: " + r.ID + " - NOMBRE: " + r.nombre + " - LADO: " + r.lado + " - INDICE: " + r.indice + " - PADRE: " + r.padre + " - PASS: " + r.pass);
            //concatenacion += r.identificador+"\n";
            concatenacion += r.noIdentificacion + "\n";
            concat(r.hijoIzquierdo);
            concat(r.hijoDerecho);
        }
    }

    public void volverABalancear(NodoAVL r) {
        while (r.hijoDerecho != null) {
            r.hijoDerecho = null;
        }
        while (r.hijoIzquierdo != null) {
            r.hijoIzquierdo = null;
        }
        raiz = null;
        System.out.println("\n");
        String[] partes = concatenacion.split("\n");
        for (int i = 0; i < partes.length; i++) {
            if (!partes[i].equals("")) {
                String[] romper = partes[i].split("-");
                insertar(Integer.parseInt(romper[0].trim()));
            }
        }
        concatenacion = "";
    }

    public void graficarArbol(String tipo,int num) {

        String ruta = "C:\\Users\\tracs\\Desktop\\AVL.txt";

        try {
            FileWriter fichero = new FileWriter(ruta);
            PrintWriter pw = new PrintWriter(fichero);

            String datosGrafo ="";
            if(tipo.equals("1"))
            {
                datosGrafo = getCodigoGraphviz();
            }
            if(tipo.equals("2"))
            {
               datosGrafo = getCodigoGraphviz2(num);
            }
             pw.print(datosGrafo);

            fichero.close();

            Runtime rt = Runtime.getRuntime();
            if(tipo.equals("1"))
            {
                rt.exec("dot -Tpng " + ruta + " -o C:\\Users\\tracs\\Desktop\\ArbolAVL.jpg");
            }
            if(tipo.equals("2"))
            {
               rt.exec("dot -Tpng " + ruta + " -o C:\\Users\\tracs\\Desktop\\ArbolAVL2.jpg");
            }

        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public String getCodigoGraphviz() {
        return "digraph grafica{\n"
                + "rankdir=TB;\n"
                + "node [shape = record, style=filled, fillcolor=darksalmon];\n"
                + "label=\"Arbol Avl\";"
                + getCodigoInterno(raiz) + "}\n";
    }
    public String getCodigoGraphviz2(int tipo) {
        return "digraph grafica{\n"
                + "rankdir=TB;\n"
                + "node [shape = record, style=filled, fillcolor=darksalmon];\n"
                + "label=\"Arbol Avl\";"
                + getCodigoInterno2(raiz,tipo) + "}\n";
    }

    public String getCodigoInterno(NodoAVL r) {
        String etiqueta;
        if (r.hijoDerecho == null && r.hijoIzquierdo == null) {
            etiqueta = "nodo" + r.noIdentificacion + " [ label =\"" + r.noIdentificacion +  "\"];\n";
        } else {
            etiqueta = "nodo" + r.noIdentificacion + " [ label =\"<C0>|" + r.noIdentificacion + "|<C1>\"];\n";
        }
        if (r.hijoIzquierdo != null) {
            etiqueta = etiqueta + getCodigoInterno(r.hijoIzquierdo)
                    + "nodo" + r.noIdentificacion + ":C0->nodo" + r.hijoIzquierdo.noIdentificacion + "\n";
        }
        if (r.hijoDerecho != null) {
            etiqueta = etiqueta + getCodigoInterno(r.hijoDerecho)
                    + "nodo" + r.noIdentificacion + ":C1->nodo" + r.hijoDerecho.noIdentificacion + "\n";
        }
        return etiqueta;
    }
    
    public String getCodigoInterno2(NodoAVL r,int num) {
        String etiqueta = "";
        if (r.hijoDerecho == null && r.hijoIzquierdo == null) {
            if(r.noIdentificacion==num){
                etiqueta = "node [shape = record, style=filled, fillcolor=lightblue];\n";
                etiqueta = etiqueta + "nodo" + r.noIdentificacion + " [ label =\" " + r.noIdentificacion +  "\"];\n"+ "node [shape = record, style=filled, fillcolor=darksalmon];\n";
            }
            if(r.noIdentificacion!=num){
                etiqueta = "nodo" + r.noIdentificacion + " [ label =\" " + r.noIdentificacion +  "\"];\n";
            }
        } else {
            etiqueta = "nodo" + r.noIdentificacion + " [ label =\"<C0>| " + r.noIdentificacion + "|<C1>\"];\n";
        }
        if (r.hijoIzquierdo != null) {
            etiqueta = etiqueta + getCodigoInterno2(r.hijoIzquierdo,num)
                    + "nodo" + r.noIdentificacion + ":C0->nodo" + r.hijoIzquierdo.noIdentificacion + "\n";
        }
        if (r.hijoDerecho != null) {
            etiqueta = etiqueta + getCodigoInterno2(r.hijoDerecho,num)
                    + "nodo" + r.noIdentificacion + ":C1->nodo" + r.hijoDerecho.noIdentificacion + "\n";
        }
        return etiqueta;
    }
    
    public String Indorden() {
        return Indorden(raiz);
    }
    
    public String Indorden(NodoAVL r) {
        String etiqueta ="";
        if (r.hijoIzquierdo != null) {
            etiqueta = etiqueta + Indorden(r.hijoIzquierdo);
        }
        if (r.hijoIzquierdo == null && r.hijoDerecho==null) {
            return " | " + r.noIdentificacion ;
        }
        if (r.hijoDerecho != null) {
            etiqueta = etiqueta +" | " + r.noIdentificacion + Indorden(r.hijoDerecho) ;
        }
        if (r.hijoDerecho == null) {
            return " | " + r.noIdentificacion ;
        }
        return etiqueta;
    }
    
    public void generar_graph(String a){
         String ruta = "C:\\Users\\tracs\\Desktop\\arre2.txt";
        
        try {
            FileWriter fichero = new FileWriter(ruta);
            PrintWriter pw = new PrintWriter(fichero);

            String datosGrafo ="";
            datosGrafo = getCodigoGraphviz(a);
            pw.print(datosGrafo);

            fichero.close();

            Runtime rt = Runtime.getRuntime();
            
            rt.exec("dot -Tpng " + ruta + " -o C:\\Users\\tracs\\Desktop\\arreglo2.jpg");
            

        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
    public String getCodigoGraphviz(String a) {
        return "digraph grafica{\n"
                + "nodesep=.05;\n"
                + "rankdir=LR;"
                + "node [shape=record,width = 1.5];\n"
                + "label=\"Ordenados \";"
                + getCodigoInterno(a) + "}\n";
    }
    
    public String getCodigoInterno(String a) {
        String etiqueta = "";
        if("1".equals(a)){
            etiqueta = etiqueta + "nodo0 [ label =\"{ " + Indorden() +  "} \"];\n";
        }
        if("2".equals(a)){
            etiqueta = etiqueta + "nodo0 [ label =\"{ " + Postorden() +  "} \"];\n";
        }
        if("3".equals(a)){
           etiqueta = etiqueta + "nodo0 [ label =\"{ " + Preorden() +  "} \"];\n";
        }
        
        return etiqueta;
    }
    
    public String Postorden() {
        return Postorden(raiz);
    }
    
    public String Postorden(NodoAVL r) {
        String etiqueta ="";
        if (r.hijoIzquierdo != null) {
            etiqueta = etiqueta + Postorden(r.hijoIzquierdo);
        }
        if (r.hijoIzquierdo == null && r.hijoDerecho==null) {
            return " | " + r.noIdentificacion ;
        }
        if (r.hijoIzquierdo == null && r.hijoDerecho!=null) {
            etiqueta = etiqueta + Postorden(r.hijoDerecho);
        }
        
        if (r.hijoDerecho != null) {
            etiqueta = etiqueta + Postorden(r.hijoDerecho)+" | " + r.noIdentificacion  ;
        }
        
        if (r.hijoDerecho == null && r.hijoIzquierdo==null) {
            return " | " + r.noIdentificacion ;
        }
        if (r.hijoDerecho == null && r.hijoIzquierdo!=null) {
            etiqueta = etiqueta + Postorden(r.hijoIzquierdo);
        }
        return etiqueta;
    }
    
    public String Preorden() {
        return Preorden(raiz);
    }
    
    public String Preorden(NodoAVL r) {
        String etiqueta ="";
        if (r.hijoIzquierdo != null) {
            etiqueta = etiqueta +" | " + r.noIdentificacion+ Preorden(r.hijoIzquierdo);
        }
        if (r.hijoIzquierdo == null && r.hijoDerecho==null) {
            return " | " + r.noIdentificacion;
        }
        if (r.hijoIzquierdo == null && r.hijoDerecho!=null) {
            etiqueta = etiqueta +" | " + r.noIdentificacion +Preorden(r.hijoDerecho);
        }
        if (r.hijoDerecho != null) {
            etiqueta = etiqueta + Preorden(r.hijoDerecho);
        }
        
        return etiqueta;
    }
    
}
