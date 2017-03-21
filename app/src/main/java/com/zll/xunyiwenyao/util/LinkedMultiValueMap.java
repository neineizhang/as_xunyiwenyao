package com.zll.xunyiwenyao.util;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class LinkedMultiValueMap<K, V> implements MultiValueMap<K, V> {
	 
    
	
	protected Map<K, List<V>> mSource = new LinkedHashMap<K, List<V>>();
	
    public LinkedMultiValueMap() {
		// TODO Auto-generated constructor stub
	}
	
	public void add(K key, V value) {
		// TODO Auto-generated method stub
		if (key != null) {
            // 如果有这个Key就继续添加Value，没有就创建一个List并添加Value
            if (!mSource.containsKey(key))
                mSource.put(key, new ArrayList<V>(2));
            mSource.get(key).add(value);
        }
	}

	public void add(K key, List<V> values) {
		// TODO Auto-generated method stub

	}

	public void set(K key, V value) {
		// TODO Auto-generated method stub

	}

	public void set(K key, List<V> values) {
		// TODO Auto-generated method stub

	}

	public void set(Map<K, List<V>> values) {
		// TODO Auto-generated method stub

	}

	public List<V> remove(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	public void clear() {
		// TODO Auto-generated method stub

	}

	public Set<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V getValue(K key, int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<V> getValues(K key) {
		// TODO Auto-generated method stub
		return null;
	}


	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean containsKey(K key) {
		// TODO Auto-generated method stub
		return false;
	}

}
