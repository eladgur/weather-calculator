
class City {

    private String id;
    private String name;
    private int population;

    City(String id, String name, int population) {
        this.id = id;
        this.name = name;
        this.population = population;
    }

    int getPopulation() {
        return population;
    }

    String getId() {
        return this.id;
    }
}
