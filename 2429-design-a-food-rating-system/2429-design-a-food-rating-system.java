class FoodRatings {
    private Map<String, String> foodToCuisine;
    private Map<String, Integer> foodToRating;
    private Map<String, PriorityQueue<Food>> cuisineToHeap;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodToCuisine = new HashMap<>();
        foodToRating = new HashMap<>();
        cuisineToHeap = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];

            foodToCuisine.put(food, cuisine);
            foodToRating.put(food, rating);

            cuisineToHeap.putIfAbsent(cuisine, new PriorityQueue<>(
                (a, b) -> a.rating == b.rating ? a.name.compareTo(b.name) : b.rating - a.rating
            ));

            cuisineToHeap.get(cuisine).offer(new Food(food, rating));
        }
    }
    
    public void changeRating(String food, int newRating) {
        String cuisine = foodToCuisine.get(food);
        foodToRating.put(food, newRating);
        cuisineToHeap.get(cuisine).offer(new Food(food, newRating));
    }
    
    public String highestRated(String cuisine) {
         PriorityQueue<Food> pq = cuisineToHeap.get(cuisine);
        while (true) {
            Food top = pq.peek();
            if (foodToRating.get(top.name) == top.rating) {
                return top.name;
            }
            pq.poll();
        }
    }
     private static class Food {
        String name;
        int rating;
        Food(String n, int r) {
            name = n;
            rating = r;
        }
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */