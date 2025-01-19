package com.example.Data;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

public class LiquadoraData {
    private final String LIQUADORA_PATH = "CC2016_Hoja_trabajo_1/app/src/main/java/com/example/JSON/liquadoraSpeed.json";
    private final String LIQUADORA_MATERIAL_PATH = "CC2016_Hoja_trabajo_1/app/src/main/java/com/example/JSON/liquadoraMaterials.json";
    private final Map<Integer, String> speedMap = new HashMap<>();
    private final Map<String, Float> materialMap = new HashMap<>();

    private static final Logger logger = Logger.getLogger(LiquadoraData.class.getName());  


    public LiquadoraData() {
        loadFromJson();
    }

    public Map<Integer, String> getSpeedMap() {
        return speedMap;
    }

    public Map<String, Float> getMaterialMap() {
        return materialMap;
    }

    public void setMaterialMap(Map<String, Float> materialMap) throws IOException {
        this.materialMap.clear();
        this.materialMap.putAll(materialMap);
        saveToJson();
    }

    public void deleteMaterial(String material) throws IOException {
        materialMap.remove(material);
        saveToJson();
    }

    private void loadFromJson() {
        Gson gson = new Gson();
        try {
            FileReader reader = new FileReader(LIQUADORA_PATH);
            java.lang.reflect.Type type = new TypeToken<Map<Integer, String>>() {}.getType();
            Map<Integer, String> loadedMap = gson.fromJson(reader, type);
            speedMap.clear();
            speedMap.putAll(loadedMap);
        } catch (JsonIOException | JsonSyntaxException | FileNotFoundException e) {
            logger.log(Level.SEVERE, "Error loading data from JSON", e);
        }
        try {FileReader reader = new FileReader(LIQUADORA_MATERIAL_PATH);
            java.lang.reflect.Type type = new TypeToken<Map<String, Float>>() {}.getType();
            Map<String, Float> loadedMap = gson.fromJson(reader, type);
            materialMap.clear();
            materialMap.putAll(loadedMap);
        } catch (JsonIOException | JsonSyntaxException | FileNotFoundException e) {
            logger.log(Level.SEVERE, "Error loading data from JSON", e);
        }
    }

    private void saveToJson() throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileWriter writer = new FileWriter(LIQUADORA_PATH); 
            gson.toJson(speedMap, writer);
        } catch (JsonIOException | JsonSyntaxException | FileNotFoundException e) {
            logger.log(Level.SEVERE, "Error saving data to JSON", e);
        }
    }


    
}
