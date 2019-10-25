import java.util.*;

public class spaceship {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> queueLiquids = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(queueLiquids::offer);

        ArrayDeque<Integer> stackItems = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(stackItems::push);

        Map<String, Integer> elements = new LinkedHashMap<>();
        elements.put("Glass", 0);
        elements.put("Aluminium", 0);
        elements.put("Lithium", 0);
        elements.put("Carbon fiber", 0);
        while (!queueLiquids.isEmpty() && !stackItems.isEmpty()) {
            int currentLiquid = queueLiquids.poll();
            int currentItem = stackItems.pop();

            int result = currentLiquid + currentItem;

            if (result == 25) {
              int glass= elements.get("Glass")+1;
              elements.put("Glass",glass);
            } else if (result == 50) {
                int al=elements.get("Aluminium")+1;
                elements.put("Aluminium",al);
            } else if (result == 75) {
               int litium= elements.get("Lithium")+1;
               elements.put("Lithium",litium);

            } else if (result == 100) {
                int add=elements.get("Carbon fiber")+1;
                elements.put("Carbon fiber",add);
            } else {

                currentItem += 3;
                stackItems.push(currentItem);
            }
        }
        List<Integer>liquids=new ArrayList<>();
        List<Integer>items=new ArrayList<>();
        if (elements.get("Glass") > 0&&elements.get("Aluminium")>0&&elements.get("Lithium")>0&& elements.get("Carbon fiber")>0) {
            System.out.println("Wohoo! You succeeded in building the spaceship!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to build the spaceship.");
        }

        if (queueLiquids.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.print("Liquids left: ");
            for (Integer liquid : queueLiquids) {
                liquids.add(liquid);
            }
            for (int i = 0; i < liquids.size(); i++) {
                if (i==liquids.size()-1){
                    System.out.print(liquids.get(i));
                }else {
                    System.out.print(liquids.get(i)+", ");
                }
            }
            System.out.println();
        }

        if (stackItems.isEmpty()) {
            System.out.println("Physical items left: none");
        } else {
            System.out.print("Physical items left: ");
            for (Integer item : stackItems) {
                items.add(item);

            }
            for (int i = 0; i < items.size(); i++) {
                if (i==items.size()-1){
                    System.out.print(items.get(i));
                }else {
                    System.out.print(items.get(i)+", ");
                }
            }
            System.out.println();
        }

        elements.entrySet().stream().sorted((a, b) ->
                a.getKey().compareTo(b.getKey())).forEach(entry ->
                System.out.printf("%s: %d\n", entry.getKey(), entry.getValue()));


    }
}
