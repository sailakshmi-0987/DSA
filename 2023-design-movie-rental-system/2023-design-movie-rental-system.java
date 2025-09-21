import java.util.*;

class MovieRentingSystem {
    private static class Pair {
        int shop, movie, price;
        Pair(int s, int m, int p) {
            shop = s; movie = m; price = p;
        }
    }

    private Map<Integer, TreeSet<Pair>> unrented;  
    private TreeSet<Pair> rented;                  
    private Map<String, Integer> priceMap;         

    public MovieRentingSystem(int n, int[][] entries) {
        unrented = new HashMap<>();
        priceMap = new HashMap<>();

        Comparator<Pair> compUnrented = (a, b) -> {
            if (a.price != b.price) return a.price - b.price;
            return a.shop - b.shop;
        };

        Comparator<Pair> compRented = (a, b) -> {
            if (a.price != b.price) return a.price - b.price;
            if (a.shop != b.shop) return a.shop - b.shop;
            return a.movie - b.movie;
        };

        rented = new TreeSet<>(compRented);

        for (int[] e : entries) {
            int shop = e[0], movie = e[1], price = e[2];
            priceMap.put(shop + "#" + movie, price);

            unrented.putIfAbsent(movie, new TreeSet<>(compUnrented));
            unrented.get(movie).add(new Pair(shop, movie, price));
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> res = new ArrayList<>();
        if (!unrented.containsKey(movie)) return res;

        Iterator<Pair> it = unrented.get(movie).iterator();
        int k = 0;
        while (it.hasNext() && k < 5) {
            res.add(it.next().shop);
            k++;
        }
        return res;
    }

    public void rent(int shop, int movie) {
        int price = priceMap.get(shop + "#" + movie);
        Pair p = new Pair(shop, movie, price);

        unrented.get(movie).remove(p);
        rented.add(p);
    }

    public void drop(int shop, int movie) {
        int price = priceMap.get(shop + "#" + movie);
        Pair p = new Pair(shop, movie, price);

        rented.remove(p);
        unrented.get(movie).add(p);
    }

    public List<List<Integer>> report() {
        List<List<Integer>> res = new ArrayList<>();
        Iterator<Pair> it = rented.iterator();
        int k = 0;
        while (it.hasNext() && k < 5) {
            Pair p = it.next();
            res.add(Arrays.asList(p.shop, p.movie));
            k++;
        }
        return res;
    }
}


/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop,movie);
 * obj.drop(shop,movie);
 * List<List<Integer>> param_4 = obj.report();
 */