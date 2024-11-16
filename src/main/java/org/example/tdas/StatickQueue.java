package org.example.tdas;

public class StatickQueue implements Queue{
    private final int MAX = 20;
    public final int[] array;
    int count;


    public StatickQueue() {
        this.array = new int[MAX];
        this.count = 0;
    }

    //Invertir con pila auxiliar
    public void invertirCola(StatickQueue cola, StatickStack pila){

        while(count!=0){
            int a = cola.getFirst();
            pila.add(a);
            cola.remove();
        }
        while(!pila.isEmpty()){
            int a = pila.getTop();
            cola.add(a);
            pila.remove();
        }
    }


    @Override
    public int getFirst() {
        if(isEmpty()){
            throw new RuntimeException("Esta vacio breooooo");
        }
        else{
            return array[0];
        }
    }

    @Override
    public void remove() {

        if(isEmpty()){
            throw new RuntimeException("Esta breoooo");
        }
        for(int i = 0;i < array.length - 1;i++){
            this.array[i] = this.array[i + 1];
        }
        count--;
    }

    @Override
    public void add(int value) {
    if(this.count == MAX){
        throw new RuntimeException("La cola esta llena...");
    }
    this.array[this.count] = value;
    this.count++;
    }

    @Override
    public boolean isEmpty() {
        if(count == 0){
            return true;
        }
        return false;
    }


    public void pasarColaAOtra(StatickQueue cola1, StatickQueue cola2) {
        while (!cola1.isEmpty()) {
            cola2.add(cola1.getFirst());
            cola1.remove();
        }
    }
}

