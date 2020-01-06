//* Basic node stored in AVL trees
//*

package EDD;

/**
 *
 * @author Oscar
 */
class NodoAVL {

        int noIdentificacion;
        NodoAVL hijoIzquierdo;
        NodoAVL hijoDerecho;
        int factEq;

        public NodoAVL(int noIdentificacion) {
            this.noIdentificacion = noIdentificacion;
            this.hijoIzquierdo = null;
            this.hijoDerecho = null;
            this.factEq = 0;
        }
}