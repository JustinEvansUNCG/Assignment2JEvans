package com.Assignment2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Justin Evans
 */
@RestController
public class Application2Controller {
    
   /**
     * Takes the first 20 creatures from the game Pokemon and makes them available at the endpoint, alongside the path to get more information on a specific Pokemon
     * 
     * @return json array
     */
    @GetMapping("/pokedex")
    public Object getPokemon() {
        try {
            String url = "https://pokeapi.co/api/v2/pokemon/";
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();

            String jSonQuote = restTemplate.getForObject(url, String.class);
            JsonNode root = mapper.readTree(jSonQuote);

            //Print the whole response to console.
            System.out.println(root.get("results"));
            System.out.println("First 20 Pokemon:");

            for (JsonNode rt : root.get("results")) {
                String name = rt.get("name").asText();
                String urls = rt.get("url").asText();
                System.out.println(name + ": More info at " + urls);
            }

            return root;
        } catch (JsonProcessingException ex) {
            Logger.getLogger(Application2Controller.class.getName()).log(Level.SEVERE,
                    null, ex);
            return "error in /pokedex";
        }

    }
}
