package com.json.evaluatepath.handler;

import com.json.evaluatepath.documentcontext.DocumentContextImpl;
import io.vertx.ext.web.RoutingContext;

import static com.json.evaluatepath.resource.EvaluatePathResource.CASE1;

public class EvaluateJsonHandler {
    private final DocumentContextImpl documentContextImpl;

    public EvaluateJsonHandler(DocumentContextImpl documentContextImpl) {
        this.documentContextImpl = documentContextImpl;
    }
    public String documentContextCase1(RoutingContext rc) {
         documentContextImpl.apply(CASE1);
         return "Success";
    }
}
