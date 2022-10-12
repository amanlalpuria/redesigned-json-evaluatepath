package com.json.evaluatepath.documentcontext;

import com.jayway.jsonpath.*;
import io.vertx.core.json.JsonObject;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.json.evaluatepath.resource.EvaluatePathResource.*;

public class DocumentContextImpl {
    private static final Logger LOGGER = LoggerFactory.getLogger(DocumentContextImpl.class);
    public void apply(String jsonToWorkOn) {
        DocumentContext documentContext = getParseContext().parse(jsonToWorkOn);
        String sourceKeyValue = evaluteJsonPath(documentContext, CASE1_MATCH_KEY.getString("sourcePath"));
        String sourceCodesetValue = null != CASE1_MATCH_CODE_SET
                ? evaluteJsonPath(documentContext, CASE1_MATCH_CODE_SET.getString("sourcePath"))
                : null;
        if (!CASE1_SOURCE_KEY_EXPECTED.equals(sourceKeyValue)) {
            System.out.println("Document context case1 test fail sourceKeyValue : " + sourceKeyValue + " expected : " + CASE1_SOURCE_KEY_EXPECTED);
        } else if (!CASE1_SOURCE_CODESET_VALUE_EXPECTED.equals(sourceCodesetValue)) {
            System.out.println("Document context case1 test fail sourceCodesetValue : " + sourceCodesetValue + " expected : " + CASE1_SOURCE_CODESET_VALUE_EXPECTED);
        } else {
            System.out.println("DocumentContextImpl output sourceKeyValue: " + sourceKeyValue + " sourceCodesetValue " + sourceCodesetValue);
        }
    }

    public static ParseContext getParseContext() {
        return JsonPath.using(Configuration.builder().options(Option.SUPPRESS_EXCEPTIONS).build());
    }

    public static <T> T evaluteJsonPath(DocumentContext responseJson, String jsonPath) {
        try {
            if (StringUtils.isEmpty(jsonPath)) {
                return null;
            }
            if (".".equals(jsonPath)) {
                return responseJson.read("$");
            } else {
                String path = "$." + jsonPath;
                return responseJson.read(path);
            }
        } catch (Exception e) {
            System.out.println("Error while getting jsonPath :" + jsonPath);
            return null;
        }
    }
}
