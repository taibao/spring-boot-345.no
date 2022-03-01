package com.vitas.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vitas.pojo.Users;
import com.vitas.utils.ESClient;
import org.elasticsearch.action.admin.cluster.repositories.delete.DeleteRepositoryAction;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.common.xcontent.json.JsonXContent;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.XAConnection;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/es")
public class EsController {
    @GetMapping("/testConnect")
    public String testConnect(){
        RestHighLevelClient client = ESClient.getClient();
        return "ok"; //返回结果
    }

    //创建索引
    @GetMapping("/createIndex")
    public String createdIndex() throws IOException {
        String index = "person";
        String type = "doc";
        //settings设置
        Settings.Builder settings =  Settings.builder().put("number_of_shards",3)
                .put("number_of_replicas",1);

        //mappings 设置
        XContentBuilder mappings = JsonXContent.contentBuilder()
                .startObject()
                    .startObject("properties")
                        .startObject("name")
                            .field("type","text")
                .endObject()
                .startObject("age")
                        .field("type","integer")
                .endObject()
                .startObject("birthday")
                        .field("type","date")
                        .field("format","yyyy-MM-dd")
                        .endObject()
                    .endObject()
                .endObject();


        //将settings和mappings封装到Resquest对象中
        CreateIndexRequest request = new CreateIndexRequest(index).settings(settings).mapping(String.valueOf(mappings));

        //通过client连接es，并创建索引
        RestHighLevelClient client = ESClient.getClient();
        CreateIndexResponse response = client.indices().create(request, RequestOptions.DEFAULT);

        //输出
        System.out.println(response);
        return "ok";

    }

    //检查索引是否存在
    @GetMapping("/indexExists")
    public String exists() throws IOException{
        String index = "person";
        String type = "doc";

        //准备request对象
        GetIndexRequest request = new GetIndexRequest(index);
        //通过client连接es
        RestHighLevelClient client = ESClient.getClient();
        boolean exists = client.indices().exists(request, RequestOptions.DEFAULT);
        //输出
        System.out.println(exists);
        return "ok";
    }


    @GetMapping("/delIndex")
    public String delUserIndex() throws IOException {
        String index = "person";
        String type = "doc";

        //准备request对象
        DeleteIndexRequest request = new DeleteIndexRequest(index);
        //通过client链接es
        RestHighLevelClient client = ESClient.getClient();
        AcknowledgedResponse delete = client.indices().delete(request, RequestOptions.DEFAULT);

        System.out.println(delete.isAcknowledged());
        return "ok";
    }

    //使用java操作文档

    //添加文档
    @GetMapping("/createDoc")
    public String createDoc() throws IOException{
        String index = "person";
        String type = "doc";

        //准备json数据
        Users person = new Users("1","张三","1","12");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(person);

        //准备request对象
        IndexRequest request= new IndexRequest(index,"_doc","1");
        request.source(json, XContentType.JSON);

        //通过client对象连接es
        RestHighLevelClient client = ESClient.getClient();
        IndexResponse response =client.index(request, RequestOptions.DEFAULT);

        //输出
        System.out.println(response.getResult());

        return "ok";
    }

    //修改文档
    @GetMapping("/updateDoc")
    public String updateDoc() throws IOException{
        String index = "person";
        String type = "doc";

        //创建一个map,指定需要修改的内润
        Map<String,Object> doc = new HashMap<>();
        doc.put("name","李四");

        //request对象
        UpdateRequest request = new UpdateRequest(index,"1");
        request.doc(doc);

        //连接es
        RestHighLevelClient client = ESClient.getClient();
        UpdateResponse update = client.update(request,RequestOptions.DEFAULT);

        System.out.println(update.getResult());
        //输出
        return "ok";
    }

    //删除文档
    @GetMapping("/deleteDoc")
    public String deleteDoc() throws IOException{
        String index = "person";
        String type = "doc";

        //request对象
        DeleteRequest request = new DeleteRequest(index,"1");

        //client执行
        RestHighLevelClient client = ESClient.getClient();
        DeleteResponse delete = client.delete(request,RequestOptions.DEFAULT);

        //输出
        System.out.println(delete.getResult());
        return "ok";
    }

    //批量添加文档
    @GetMapping("/bulkCreateDoc")
    public String bulkCreateDoc() throws IOException{
        String index = "person";
        String type = "doc";

        //准备一个json数据
        Users user2 = new Users("2","张四","1","18");
        Users user3 = new Users("3","张五","1","18");
        Users user4 = new Users("2","张六","1","18");
        Users user5 = new Users("5","张七","1","18");

        ObjectMapper mapper = new ObjectMapper();
        String json1 = mapper.writeValueAsString(user2);
        String json2 = mapper.writeValueAsString(user3);
        String json3 = mapper.writeValueAsString(user4);
        String json4 = mapper.writeValueAsString(user5);

        //准备request对象
        BulkRequest request = new BulkRequest();
        request.add(new IndexRequest(index,"_doc",user2.getId()).source(json1,XContentType.JSON));
        request.add(new IndexRequest(index,"_doc",user3.getId()).source(json2,XContentType.JSON));
        request.add(new IndexRequest(index,"_doc",user4.getId()).source(json3,XContentType.JSON));
        request.add(new IndexRequest(index,"_doc",user5.getId()).source(json4,XContentType.JSON));

        //通过client对象连接es
        RestHighLevelClient client = ESClient.getClient();
        BulkResponse response = client.bulk(request,RequestOptions.DEFAULT);

        //输出
        System.out.println(response);
        return "ok";
    }

    @GetMapping("/buldDeleteDoc")
    public String buldDeleteDoc() throws IOException{
        String index = "person";
        String type = "doc";

        BulkRequest request = new BulkRequest();
        request.add(new DeleteRequest(index,type,"1"));
        request.add(new DeleteRequest(index,type,"2"));
        request.add(new DeleteRequest(index,type,"3"));
        request.add(new DeleteRequest(index,type,"4"));
        request.add(new DeleteRequest(index,type,"5"));

        RestHighLevelClient client = ESClient.getClient();
        BulkResponse response = client.bulk(request,RequestOptions.DEFAULT);

        System.out.println(response);
        return "ok";
    }

    @GetMapping("/termQuery")
    public String termQuery() throws IOException{
        String index = "person";
        String type = "doc";

        //request
        SearchRequest request = new SearchRequest(index);
        request.searchType(type);

        //指定查询条件
        SearchSourceBuilder builder = new SearchSourceBuilder();
        builder.from(0);
        builder.size(5);
        builder.query(QueryBuilders.termQuery("name","机器"));

        request.source(builder);
        RestHighLevelClient client = ESClient.getClient();
        SearchResponse search =client.search(request,RequestOptions.DEFAULT);

        for(SearchHit hit: search.getHits().getHits()){
            Map<String,Object> result = hit.getSourceAsMap();
            System.out.println(result);
        }


        return "ok";
    }




}




