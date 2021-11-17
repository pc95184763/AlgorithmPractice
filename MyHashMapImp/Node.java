package MyHashMapImp;








public class Node<K, V> {

  private final K key ;
  private V value ;
  Node<K, V> next ;


  public K getKey() {
    return key;
  }

  public V getValue() {
    return value;
  }



   Node(K key, V val) {
     this.key = key ;
     this.value = val ;
   }




}
