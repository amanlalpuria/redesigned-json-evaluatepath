package com.json.evaluatepath.jsonflattener;

import com.github.wnameless.json.flattener.JsonFlattener;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class JsonFlattenerImpl {

    String resourcePath = "rxnormcode";
    public void apply(String jsonToWorkOn) {
        //flatten json
        Map<String, Object> flattenJson = JsonFlattener.flattenAsMap(jsonToWorkOn);
        flattenJson.values().removeIf(Objects::isNull);
        ConcurrentMap<String, Object> concurrentMap = new ConcurrentHashMap<>(flattenJson);

        List<String> matchingKeys = concurrentMap.keySet().stream()
                .filter(e -> e.contains(resourcePath)).collect(Collectors.toList());

        matchingKeys.stream().forEach(key -> {
            System.out.println("resourcePath - key=" + key + ", value=" + concurrentMap.get(key));
        });
    }
}
