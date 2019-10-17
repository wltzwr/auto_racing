package com.autohome.autoracing.component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class PartsFactory implements ResourceLoaderAware {
    private JSONObject partsJson;

    public JSONObject getAllParts(){
        return partsJson;
    }

    public Object getPart(String type, Integer id){
        JSONArray array = partsJson.getJSONArray(type);
        JSONObject obj = array.getJSONObject(id);

        return partsJson.getJSONArray(type).getJSONObject(id);
    }


    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        Resource resource= resourceLoader.getResource("classpath:/parts.json");
        try {
            partsJson = JSON.parseObject(resource.getInputStream(), JSONObject.class
                    , Feature.AutoCloseSource
                    , Feature.AllowComment
                    , Feature.AllowSingleQuotes
                    , Feature.UseBigDecimal);
        } catch (IOException e) {
        }
    }
}
