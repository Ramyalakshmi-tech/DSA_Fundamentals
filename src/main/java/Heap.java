

class MaxHeap {
    int[] heap;
    int size;
    int maxSize;

    public int parent(int pos){
        return (pos-1)/2;
    }
    public int leftChild(int pos){
        return 2*pos+1;
    }
    public int rightChild(int pos){
        return 2*pos+2;
    }
    public MaxHeap(int maxSize){
        this.maxSize=maxSize;
        this.size=0;
        heap=new int[maxSize];
    }
    public void swap(int fpos,int spos){
        int temp=heap[fpos];
        heap[fpos]=heap[spos];
        heap[spos]=temp;
    }
    public void insert(int element){
        if(size==maxSize){
            System.out.println("Heap is full");
        }
        heap[size]=element;
        size++;
        heapifyUp(size-1);
    }
    public void heapifyUp(int pos){
        int current=pos;//150
        while(current>0 && heap[current]>heap[parent(current)] ){
            swap(current,parent(current));
            current=parent(current);
        }
    }

    public int extractMax(){
        if(size==0){
            System.out.println("Heap is empty");
        }
        int max=heap[0];
        heap[0]=heap[size-1];
        size--;
        heapifyDown(0);
        return max;
    }
    public void heapifyDown(int pos){
        int largest=pos;
        int left=leftChild(pos);
        int right=rightChild(pos);
        if(heap[largest]<heap[left]){
            largest=left;
        }
        if(heap[largest]<heap[right]){
            right=largest;
        }
        if(largest!=pos){
            swap(largest,pos);
            heapifyDown(largest);
        }
    }

    public void delete(int element){
        int pos=find(element);
        if(pos==-1){
            System.out.println("Element not found");
        }
        heap[pos]=heap[size-1];
        size--;
        heapifyDown(pos);
    }
    public int find(int element){
        for(int i=0;i<size;i++){
            if(heap[i]==element){
                return i;
            }
        }
        return -1;
    }

    public int peek(){
        if(size==0){
            System.out.println("Heap is empty");
        }
        return heap[0];
    }
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(10);
        maxHeap.insert(10);
        maxHeap.insert(20);
        maxHeap.insert(5);
        maxHeap.insert(17);

        System.out.println("Max value: " + maxHeap.extractMax()); // Output: 20
        maxHeap.delete(17);  // Deleting value 17
        System.out.println("Max value after deletion: " + maxHeap.peek()); // Output: 10
    }
}

