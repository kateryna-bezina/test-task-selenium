package steps;

import org.openqa.selenium.WebDriver;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class StepRegistry {
    private final WebDriver driver;
    private final Map<Class<?>, Object> cache = new HashMap<>();

    public StepRegistry(WebDriver driver) {
        this.driver = driver;
    }

    public <T> T get(Class<T> clazz) {
        if (cache.containsKey(clazz)) {
            return clazz.cast(cache.get(clazz));
        }
        try {
            Constructor<T> constructor = clazz.getConstructor(WebDriver.class);
            T instance = constructor.newInstance(driver);
            cache.put(clazz, instance);
            return instance;
        } catch (Exception e) {
            throw new RuntimeException("Failed to create steps: " + clazz.getName(), e);
        }
    }
}
