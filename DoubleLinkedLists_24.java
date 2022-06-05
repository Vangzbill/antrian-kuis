package kuis2_24;

/**
 *
 * @author sabil
 */
public class DoubleLinkedLists_24 {
    Node_24 head;
    int size;
    
    public DoubleLinkedLists_24(){
        head = null;
        size = 0;
    }
    
    public boolean isEmpty(){
        return head == null;
    }
    
    public void addFirst(Pembeli_24 data, Pesanan_24 datapsn){
        if(isEmpty()){
            head = new Node_24(null, data, datapsn, null);
        } else {
            Node_24 newNode = new Node_24(null, data, datapsn, head);
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }
    
    public void addLast(Pembeli_24 data, Pesanan_24 datapsn){
        if(isEmpty()){
            addFirst(data, datapsn);
        } else {
            Node_24 current = head;
            while (current.next != null){
                current = current.next;
            }
            Node_24 newNode = new Node_24(current, data, datapsn, null);
            current.next = newNode;
            size++;
        }
    }
    
    public int size(){
        return size;
    }
    
    public void print(){
        if (!isEmpty()){
            Node_24 tmp = head;
            int idx = 1;
            System.out.println("=======================");
            System.out.println("Daftar Antrian Resto");
            System.out.println("=======================");
            System.out.println("|No\t|Nama Customer\t|No. HP");
            while (tmp != null){
                System.out.println(idx++ + "\t" + tmp.data.nama + "\t\t" + tmp.data.noHp);
                tmp = tmp.next;
            }
            System.out.println("==========================");
        } else {
            System.out.println("Antrian Kosong");
        }
    }
    
    public void removeFirst() throws Exception {
        if(isEmpty()){
            throw new Exception("Antrian masih kosong, tidak dapat dihapus!");
        } else if (size == 1){
            removeLast();
        } else{
            head = head.next;
            head.prev = null;
            size--;
        }
    }
    
    public void removeLast() throws Exception{
        if(isEmpty()){
            throw new Exception("Antrian masih kosong, tidak dapat dihapus!");
        } else if(head.next == null){
            head = null;
            size--;
            return;
        }
        Node_24 current = head;
        while(current.next.next != null) { 
            current = current.next;
        }
        current.next = null;
        size--;
    }
    
    public void remove(int index) throws Exception {
        if (isEmpty() || index >= size) {
            throw new Exception("Nilai indeks di luar batas");
        } else if (index == 1){
            removeFirst();
        } else {
            Node_24 current = head;
            int i = 1;
            while (i < index){
                current = current.next;
                i++;
            }
            if(current.next == null){
                current.prev.next = null;
            } else if (current.prev == null){
                current = current.next;
                current.prev = null;
                head = current;
            } else {
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
            size--;
        }
    }
    
    public void asc(){
        Node_24 current = null, index = null;
        Pesanan_24 temp;
        if (head == null) {
            return;
        } else {
            for (current = head; current.next != null; current = current.next) {
                for (index = current.next; index != null; index = index.next) {
                    if (current.datapsn.namaPesanan.compareTo(index.datapsn.namaPesanan)>0) {
                        temp = current.datapsn;
                        current.datapsn = index.datapsn;
                        index.datapsn = temp;
                    }
                }
            }
        }
    }
    
    public void printAsc(){
        if (!isEmpty()){
            Node_24 tmp = head;
            int idx = 1;
            System.out.println("=======================");
            System.out.println("Daftar Antrian Resto");
            System.out.println("=======================");
            System.out.println("|Kode Pesanan\t|Nama Pesanan\t|Harga");
            while (tmp != null){
                System.out.println(tmp.datapsn.kodePesanan + "\t\t" + tmp.datapsn.namaPesanan + "\t\t" + tmp.datapsn.harga);
                tmp = tmp.next;
            }
            System.out.println("==========================");
        } else {
            System.out.println("Antrian Kosong");
        }
    }
    
    public void total() {
        if (!isEmpty()) {
            Node_24 current = head;
            int total = 0;
            while (current != null) {
                total += current.datapsn.harga;
                current = current.next;
            }
            System.out.println("====================");
            System.out.println("TOTAL PENDAPATAN");
            System.out.println("====================");
            System.out.println("Pendapatan hari ini : " + total);
        } else {
            System.out.println("Total masih kosong");
        }
    }
}
