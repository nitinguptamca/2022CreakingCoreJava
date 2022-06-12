package com.datastructure.sll2.sll;

public class CustomCollection<E extends SingleLinkedList<E>> {


    public static <E> SingleLinkedList<E> unModifiableList(SingleLinkedList<E>  list) {
        return  new UnModifiableList<E>(list);
    }

    public static class UnModifiableList<E> extends SingleLinkedList<E> {
        private final SingleLinkedList<E> list;

        public UnModifiableList(SingleLinkedList<E> list) {
            super();
            this.list=list;
        }

       public void addAtFirst(E data){
           throw new UnsupportedOperationException("modification not allow");
       }

    }
}
