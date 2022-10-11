package com.json.evaluatepath;

import com.json.evaluatepath.documentcontext.DocumentContextImpl;
import com.json.evaluatepath.jsonflattener.JsonFlattenerImpl;

import static com.json.evaluatepath.resource.EvaluatePathResource.CASE1;


public class EvaluateJsonMain {

    public static void main(String args[]){
        System.out.println("Project Started");

        //approach 1
        DocumentContextImpl documentContextImpl = new DocumentContextImpl();
        documentContextImpl.apply(CASE1);

        //approach 2
        JsonFlattenerImpl jsonFlattenerImpl = new JsonFlattenerImpl();
        jsonFlattenerImpl.apply(CASE1);
    }
}
