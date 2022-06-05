package kuis2_24;

/**
 *
 * @author sabil
 */
public class Node_24 {
    Pembeli_24 data;
    Pesanan_24 datapsn;
    Node_24 prev, next;
    
    Node_24(Node_24 prev, Pembeli_24 data, Pesanan_24 datapsn, Node_24 next){
        this.prev = prev;
        this.data = data;
        this.datapsn = datapsn;
        this.next = next;
    }
}
