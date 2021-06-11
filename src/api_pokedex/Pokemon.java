package api_pokedex;

public class Pokemon {
    private String num;
    private String name;
    private String type;
    private String next_evolution;
    private String prev_evolution;

    public String getNum() {
        return num;
    }

    public Pokemon(String num, String name, String type, String next_evolution, String prev_evolution) {
        this.num = num;
        this.name = name;
        this.type = type;
        this.next_evolution = next_evolution;
        this.prev_evolution = prev_evolution;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNext_evolution() {
        return next_evolution;
    }

    public void setNext_evolution(String next_evolution) {
        this.next_evolution = next_evolution;
    }

    public String getPrev_evolution() {
        return prev_evolution;
    }

    public void setPrev_evolution(String prev_evolution) {
        this.prev_evolution = prev_evolution;
    }
    
}
