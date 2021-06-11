package api_pokedex;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class API_Pokedex {
    
    private JSONObject pokeJson;
    private JSONParser parser;
    private Pokemon poke;
    private ConexaoBanco conn;
    
    public void Post(String num, String name, String type, String next_evolution, String prev_evolution){
        pokeJson = new JSONObject();
        pokeJson.put("num", num);
        pokeJson.put("name",name);
        pokeJson.put("type",type);
        pokeJson.put("next_evolution",next_evolution);
        pokeJson.put("prev_evolution",prev_evolution);
        
        conn.addPokemon(pokeJson.toJSONString());
    }

    public API_Pokedex() {
        conn = new ConexaoBanco();
    }
}
