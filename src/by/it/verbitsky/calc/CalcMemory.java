package by.it.verbitsky.calc;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class CalcMemory implements MemoryCalc {
    //Будет хранить значения, добавленные в память
    private Map<String, Var> buffer = new HashMap<>();

    @Override
    public void memoryAdd(String key, Var value) {
        buffer.put(key.toUpperCase(), value);
    }

    @Override
    public Var getFromMemory(String key) {
        return buffer.get(key);
    }

    @Override
    public void printvar() {
        if (!buffer.isEmpty()) {
            Set<String> keys = buffer.keySet();
            for (String key : keys) {
                System.out.printf("%s=%s\n", key, buffer.get(key).toString());
            }
        } else System.out.println(Patterns.EMPTY_BUFFER);
    }

    @Override
    public void sortvar() {
        buffer = new TreeMap<>(buffer);
        printvar();
    }

    @Override
    public void clearMemory() {
        buffer.clear();
    }

}
