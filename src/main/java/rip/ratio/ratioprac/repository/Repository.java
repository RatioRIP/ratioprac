package rip.ratio.ratioprac.repository;

import java.util.Collection;

/**
 * What's a repository you may ask?
 * It's a fucking map
 */
public interface Repository<K, V> {

  Collection<V> findAll();

  V find(K key);

  boolean insert(K key, V value);

  boolean remove(K key);
}
