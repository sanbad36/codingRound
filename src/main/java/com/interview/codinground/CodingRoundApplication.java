package com.interview.codinground;

import com.interview.codinground.util.Cache;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CodingRoundApplication {

	public static void main(String[] args) {

		Cache<String, Integer> cache = new Cache<>(3);
		cache.put("A", 1);
		cache.put("B", 2);
		cache.put("C", 3);

		System.out.println("Intial Cache: ");
		cache.displayCache();
		cache.put("D", 4);
		cache.displayCache();
		cache.get("C");
		cache.displayCache(); // C D B
		cache.put("E", 5); //  E C D
		cache.displayCache();

	}

}



/*

Design a cache Library.
Should be able define the size and
Should able to read, write, update
Should evict least recently used entry in cache when cache gets filled up.
Should be able to hold any type of objects.

 */