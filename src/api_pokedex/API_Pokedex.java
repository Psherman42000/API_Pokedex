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
    private String strinPoke;
    
    public void Post(String num, String name, String type, String next_evolution, String prev_evolution){
        pokeJson = new JSONObject();
        pokeJson.put("num", num);
        pokeJson.put("name",name);
        pokeJson.put("type",type);
        pokeJson.put("next_evolution",next_evolution);
        pokeJson.put("prev_evolution",prev_evolution);
        
        conn.addPokemon(pokeJson.toJSONString());// salvando pokemon no banco de dados
    }

    public JSONObject Get(String num){
        pokeJson = new JSONObject();
        strinPoke = conn.GetPokemon(num); //buscando o pokemon no banco de dados
        try {
            pokeJson = (JSONObject) parser.parse(strinPoke);//transformando a string em JSON
        } catch (ParseException ex) {
            Logger.getLogger(API_Pokedex.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pokeJson;
    }    
    
    public API_Pokedex() {
        conn = new ConexaoBanco();
        JSONParser parser = new JSONParser();
    }
}
