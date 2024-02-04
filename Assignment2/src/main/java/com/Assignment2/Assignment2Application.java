package com.Assignment2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Assignment2Application {

	public static void main(String[] args) {
		SpringApplication.run(Assignment2Application.class, args);
	}
}
//        
//        public static void getPokedex() {
//            try {
//            String url = "https://pokeapi.co/api/v2/pokemon/";
//            RestTemplate restTemplate = new RestTemplate();
//            ObjectMapper mapper = new ObjectMapper();
//
//            String jSonQuote = restTemplate.getForObject(url, String.class);
//            JsonNode root = mapper.readTree(jSonQuote);
//
//            //Print the whole response to console.
//            System.out.println(root.get("results"));
//            System.out.println("First 20 Pokemon:");
//
//            for (JsonNode rt : root.get("results")) {
//                String name = rt.get("name").asText();
//                String urls = rt.get("url").asText();
//                System.out.println(name + ": More info at " + urls);
//            }
//
//           // return root;
//        } catch (JsonProcessingException ex) {
//            Logger.getLogger(Application2Controller.class.getName()).log(Level.SEVERE,
//                    null, ex);
//            //return "error in /pokedex";
//                System.out.println("error in /pokedex");
//        }
//        }
//
//}
