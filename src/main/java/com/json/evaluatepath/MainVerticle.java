package com.json.evaluatepath;

import com.json.evaluatepath.documentcontext.DocumentContextImpl;
import com.json.evaluatepath.handler.EvaluateJsonHandler;
import com.json.evaluatepath.router.DocumentContextRouter;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.ErrorHandler;

public class MainVerticle extends AbstractVerticle {
    private static final Logger LOGGER = LoggerFactory.getLogger(MainVerticle.class);

    @Override
    public void start(Promise<Void> promise) {
        final DocumentContextImpl documentContextImp = new DocumentContextImpl();
        final EvaluateJsonHandler evaluateJsonHandler = new EvaluateJsonHandler(documentContextImp);
        final DocumentContextRouter bookRouter = new DocumentContextRouter(vertx, evaluateJsonHandler);

        final Router router = Router.router(vertx);
        bookRouter.setRouter(router);

        buildHttpServer(vertx, promise, router);
    }

    /**
     * Run HTTP server on port 8888 with specified routes
     *
     * @param vertx   Vertx context
     * @param promise Callback
     * @param router  Router
     */
    private void buildHttpServer(Vertx vertx,
                                 Promise<Void> promise,
                                 Router router) {
        final int port = 8888;

        vertx.createHttpServer()
                .requestHandler(router)
                .listen(port, http -> {
                    if (http.succeeded()) {
                        promise.complete();
                        LOGGER.info("Success");
                    } else {
                        promise.fail(http.cause());
                        LOGGER.info("Failure");
                    }
                });
    }
}
