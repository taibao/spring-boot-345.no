package com.vitas.utils;

import org.apache.http.HttpHost;
import org.apache.http.client.methods.HttpPost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;

public class ESClient {
    public static RestHighLevelClient getClient(){
        //创建httpHost请求
        HttpHost host = new HttpHost("localhost",9200);
        //创建RestClientBuilder
        RestClientBuilder builder = RestClient.builder(host);
        //创建RestHighLevelClient
        RestHighLevelClient client = new RestHighLevelClient(builder);
        return client;
    }

}
