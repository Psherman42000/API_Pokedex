package api_pokedex;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class API_Pokedex {
    
    private JSONObject pokeJson;
    private JSONParser parser;
    private ConexaoBanco conn;
    private String strinPoke;
    
    public API_Pokedex() {
        conn = new ConexaoBanco();
        JSONParser parser = new JSONParser();
    }
    
    public void post(String num, String name, String type, String next_evolution, String prev_evolution){ //esse metodo salva um pokemon no banco de dados
        pokeJson = new JSONObject();// criando um objeto JSON e salvando os dados nele.
        pokeJson.put("num", num);
        pokeJson.put("name",name);
        pokeJson.put("type",type);
        pokeJson.put("next_evolution",next_evolution);
        pokeJson.put("prev_evolution",prev_evolution);
        
        conn.addPokemon(num,pokeJson.toJSONString());// salvando pokemon no banco de dados passando o identificador e o objeto JSON
    }

    public JSONObject get(String num){//esse metodo busca um pokemon no banco de dados
        pokeJson = new JSONObject();
        strinPoke = conn.GetPokemon(num); //buscando o pokemon no banco de dados
        try {
            pokeJson = (JSONObject) parser.parse(strinPoke);//transformando a string em JSON
        } catch (ParseException ex) {
            Logger.getLogger(API_Pokedex.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pokeJson;
    }    
    
    public void Delete(String num){//esse metodo apaga um pokemon do banco de dados
        conn.deletePokemon(num); //buscando o pokemon no banco de dados
    }  
    
    public JSONObject getAll(){//esse metodo busca todos os pokemon no banco de dados
        pokeJson = new JSONObject();
        strinPoke = conn.GetAllPokemon(); //buscando o pokemon no banco de dados
        try {
            pokeJson = (JSONObject) parser.parse(strinPoke);//transformando a string em JSON
        } catch (ParseException ex) {
            Logger.getLogger(API_Pokedex.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pokeJson;
    } 
    
    public void put(String num, String name, String type, String next_evolution, String prev_evolution){ //esse metodo atualiza um pokemon ja existente no banco de dados
        pokeJson = new JSONObject();// criando um objeto JSON e salvando os dados nele.
        pokeJson.put("num", num);
        pokeJson.put("name",name);
        pokeJson.put("type",type);
        pokeJson.put("next_evolution",next_evolution);
        pokeJson.put("prev_evolution",prev_evolution);
        
        conn.updatePokemon(num,pokeJson.toJSONString());// salvando pokemon no banco de dados passando o identificador e o objeto JSON
    }
    
}
