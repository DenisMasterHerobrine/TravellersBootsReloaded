package dev.denismasterherobrine.travellersbootsreloaded.config;

import dev.architectury.platform.Platform;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;
import java.util.logging.Logger;

import static dev.denismasterherobrine.travellersbootsreloaded.TravellersBootsReloaded.MOD_ID;

public class ArchConfiguration {
    private final Map<String, String> defaultProperties;
    private final SortedProperties properties;
    private final File configFile;

    public static Path getConfigDirectory() {
        return Platform.getConfigFolder();
    }

    public ArchConfiguration(String filename) {
        this.properties = new SortedProperties();
        Path configDirectory = getConfigDirectory();
        this.configFile = configDirectory.resolve(filename).toFile();

        try {
            if (configFile.exists()) {
                FileInputStream fis = new FileInputStream(configFile);
                properties.load(fis);
                fis.close();
            } else {
                setDefaults();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        defaultProperties = new HashMap<>();
        defaultProperties.put("isStepHeightEnabled", "true");

        defaultProperties.put("speedModifierTier1", "1");
        defaultProperties.put("speedModifierTier2", "2");
        defaultProperties.put("speedModifierTier3", "3");
        defaultProperties.put("speedModifierTier4", "4");
        defaultProperties.put("speedModifierTier5", "5");

        defaultProperties.put("jumpModifierTier4", "1");
        defaultProperties.put("jumpModifierTier5", "2");

        reloadConfig();
    }

    public void setDefaults() {
        setProperty("isStepHeightEnabled", "true");
        setProperty("speedModifierTier1", "1");
        setProperty("speedModifierTier2", "2");
        setProperty("speedModifierTier3", "3");
        setProperty("speedModifierTier4", "4");
        setProperty("speedModifierTier5", "5");
        setProperty("jumpModifierTier4", "1");
        setProperty("jumpModifierTier5", "2");
        String comments =
                " Welcome to the Traveller's Boots Reloaded configuration. \n" +
                        " isStepHeightEnabled: Is Step Height boots ability should be enabled or not?";
        saveProperties(comments);
    }

    public void setProperty(String key, String value) {
        properties.setProperty(key, value);
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public boolean getBoolean(String key) {
        String property = getProperty(key);
        try {
            return Boolean.parseBoolean(property);
        } catch (Exception e) {
            Logger.getLogger(MOD_ID).warning("[Traveller's Boots: Reloaded - ArchConfiguration] Failed to parse boolean property " + key + " with value " + property + ". Resetting to default.");
            setProperty(key, defaultProperties.get(key));
            saveProperties();
            return Boolean.parseBoolean(defaultProperties.get(key));
        }
    }

    public int getInteger(String key) {
        String property = getProperty(key);
        try {
            return Integer.parseInt(property);
        } catch (Exception e) {
            Logger.getLogger(MOD_ID).warning("[Traveller's Boots: Reloaded - ArchConfiguration] Failed to parse Integer property " + key + " with value " + property + ". Resetting to default.");
            String defaultValue = defaultProperties.get(key);
            if (defaultValue != null) {
                setProperty(key, defaultValue);
                saveProperties();
                return Integer.parseInt(defaultValue);
            } else {
                Logger.getLogger(MOD_ID).severe("[Traveller's Boots: Reloaded - ArchConfiguration] Default value for Integer property " + key + " is not defined. Please define it in defaultProperties.");
                return 0;
            }
        }
    }

    public void saveProperties() {
        saveProperties(null);
    }

    public void saveProperties(String comments) {
        try {
            FileOutputStream fos = new FileOutputStream(configFile);
            properties.store(fos, comments);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reloadConfig() {
        try {
            if (configFile.exists()) {
                FileInputStream fis = new FileInputStream(configFile);
                properties.load(fis);
                fis.close();

                // Check for new default properties
                for (String key : defaultProperties.keySet()) {
                    if (!properties.containsKey(key)) {
                        String defaultValue = defaultProperties.get(key);
                        properties.setProperty(key, defaultValue);
                        Logger.getLogger(MOD_ID).info("[Traveller's Boots: Reloaded - ArchConfiguration] Property " + key + " added with default value " + defaultValue);
                    }
                }

                // Check for removed default properties
                Set<String> keys = new HashSet<>(properties.stringPropertyNames());
                for (String key : keys) {
                    if (!defaultProperties.containsKey(key)) {
                        properties.remove(key);
                        Logger.getLogger(MOD_ID).info("[Traveller's Boots: Reloaded - ArchConfiguration] Property " + key + " removed because it's not in default properties");
                    }
                }

                saveProperties();
            } else {
                setDefaults();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
