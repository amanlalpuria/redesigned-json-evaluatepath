package com.json.evaluatepath.router;

import com.json.evaluatepath.handler.EvaluateJsonHandler;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.LoggerFormat;
import io.vertx.ext.web.handler.LoggerHandler;

public class DocumentContextRouter {
    private final Vertx vertx;
    private final EvaluateJsonHandler evaluateJsonHandler;

    public DocumentContextRouter(Vertx vertx,
                                 EvaluateJsonHandler evaluateJsonHandler) {
        this.vertx = vertx;
        this.evaluateJsonHandler = evaluateJsonHandler;
    }

    /**
     * Set books API routes
     *
     * @param documentContextRouter Router
     */
    public void setRouter(Router router) {
        router.mountSubRouter("/api/v1", (Router) buildDocumentContextRounter());
    }

    /**
     * Build books API
     * All routes are composed by an error handler, a validation handler and the actual business logic handler
     */
    private Router buildDocumentContextRounter() {
        final Router router = Router.router(vertx);

        router.route("/test*").handler(BodyHandler.create());
        router.get("/test").handler(LoggerHandler.create(LoggerFormat.DEFAULT)).handler(evaluateJsonHandler::documentContextCase1);

        return router;
    }
}

