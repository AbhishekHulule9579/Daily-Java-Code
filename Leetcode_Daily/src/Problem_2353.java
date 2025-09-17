import java.util.*;

public class Problem_2353 {

    static class FoodRatings {
        private static class Food {
            String name;
            int rating;
            Food(String name, int rating) {
                this.name = name;
                this.rating = rating;
            }
        }
        private Map<String, PriorityQueue<Food>> cuisinePQ = new HashMap<>();
        private Map<String, String> foodToCuisine = new HashMap<>();
        private Map<String, Integer> foodToRating = new HashMap<>();

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            for (int i = 0; i < foods.length; i++) {
                String food = foods[i];
                String cuisine = cuisines[i];
                int rating = ratings[i];
                foodToCuisine.put(food, cuisine);
                foodToRating.put(food, rating);
                Comparator<Food> cmp = (a, b) -> a.rating != b.rating ? b.rating - a.rating : a.name.compareTo(b.name);
                cuisinePQ.computeIfAbsent(cuisine, k -> new PriorityQueue<Food>(cmp)).offer(new Food(food, rating));
            }
        }

        public void changeRating(String food, int newRating) {
            String cuisine = foodToCuisine.get(food);
            foodToRating.put(food, newRating);
            cuisinePQ.get(cuisine).offer(new Food(food, newRating));
        }

        public String highestRated(String cuisine) {
            PriorityQueue<Food> pq = cuisinePQ.get(cuisine);
            while (!pq.isEmpty()) {
                Food food = pq.peek();
                if (food.rating == foodToRating.get(food.name)) {
                    return food.name;
                }
                pq.poll();
            }
            return "";
        }
    }

    public static void main(String[] args) {
        String[] foods = {"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"};
        String[] cuisines = {"korean", "japanese", "japanese", "greek", "japanese", "korean"};
        int[] ratings = {9, 12, 8, 15, 14, 7};
        FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
        System.out.println("null");
        System.out.println(obj.highestRated("korean"));
        System.out.println(obj.highestRated("japanese"));
        obj.changeRating("sushi", 16);
        System.out.println("null");
        System.out.println(obj.highestRated("japanese"));
        obj.changeRating("ramen", 16);
        System.out.println("null");
        System.out.println(obj.highestRated("japanese"));
    }
}
