package com.yang.elasticsearchdemo.controller;


import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/elasticsearch")
public class ElasticsearchController {
    public static Logger logger = LoggerFactory.getLogger(TestController.class);
    @Autowired
    TransportClient client;

    /**
     * 根据id查询文档
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/info/{id}")
    public ResponseEntity query(@PathVariable String id){
        //http://123.57.91.202:9200/knowledges/business/_search
        logger.debug("index=[{}],type=[{}],id=[{}]","knowledges","business",id);
        GetResponse result = this.client.prepareGet("knowledges","business",id).get();
        logger.debug("result=[{}]",result.getSourceAsString());
        return new ResponseEntity(result, HttpStatus.OK);
    }

    /**
     * 根据关键进行复合查询
     * @param queryKeyword
     * @return
     */
    @ResponseBody
    //@RequestMapping(value = "/infos/{queryKeyword}",method = RequestMethod.POST)
    @RequestMapping(value = "/infos",method = RequestMethod.POST)
    public ResponseEntity fuHeQuery(@RequestParam(name = "queryKeyword",required = true) String queryKeyword){
        //http://123.57.91.202:9200/knowledges/business/_search
        logger.debug("index=[{}],type=[{}],id=[{}]","knowledges","business",queryKeyword);
        //可以对检索关键字进行校验（为空、非法字符、敏感词等做校验），以下是对敏感词进行校验
        if("做头发".equals(queryKeyword)){
            return new ResponseEntity("检索关键字包含色情词语", HttpStatus.NOT_EXTENDED);
        }
        //布尔查询
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        boolQueryBuilder.must(QueryBuilders.multiMatchQuery(queryKeyword,"title","keyword"));
        boolQueryBuilder.must(QueryBuilders.matchQuery("businessInfo",queryKeyword));

        //范围查找
        RangeQueryBuilder rangeQueryBuilder = QueryBuilders.rangeQuery("createTime")
                                                            //.from("2018-05-15 23:59:59")
                                                            .to("2019-10-05");
        boolQueryBuilder.should(rangeQueryBuilder);

        //
        SearchRequestBuilder searchBuild = this.client.prepareSearch("knowledges")
                .setTypes("business").setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(boolQueryBuilder).setFrom(0).setSize(10);

        logger.debug("请求数据searchBuild=[{}]",searchBuild);
        SearchResponse response = searchBuild.get();
        List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
        SearchHits hits = response.getHits();
        for (SearchHit searchHit: hits) {
            result.add(searchHit.getSource());
        }
        logger.debug("返回的结果集result=[{}]",result);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    /**
     *  添加文档
     * @param index
     * @param type
     * @param title
     * @param keyword
     * @param businessInfo
     * @param status
     * @param createTime
     * @param age
     * @return
     * @throws Exception
     */
    @ResponseBody
    //@RequestMapping(value = "/infos/{queryKeyword}",method = RequestMethod.POST)
    @RequestMapping(value = "/addInfo",method = RequestMethod.POST)
    public ResponseEntity addInfos (
            @RequestParam(name = "index",required = true) String index,
            @RequestParam(name = "type",required = true) String type,
            @RequestParam(name = "title",required = true) String title,
            @RequestParam(name = "keyword",required = true) String keyword,
            @RequestParam(name = "businessInfo",required = true) String businessInfo,
            @RequestParam(name = "status",required = true) String status,
            @RequestParam(name = "createTime",required = true)
                    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")//时间格式校验
                    Date createTime,
            @RequestParam(name = "age",required = true) int age
    )throws Exception{
        logger.debug("index=[{}],type=[{}],title=[{}],keyword=[{}],businessInfo=[{}],status=[{}],createTime=[{}],age=[{}]",
                        index,type,title,keyword,businessInfo,status,createTime,age);
        IndexResponse result = null;
        try {
            XContentBuilder builder = XContentFactory.jsonBuilder()
                    .startObject()
                    .field("title",title)
                    .field("keyword",keyword)
                    .field("businessInfo",businessInfo)
                    .field("status",status)
                    .field("age",age)
                    .field("createTime",createTime.getTime())
                    .endObject();
            result = this.client.prepareIndex(index,type)
                        .setSource(builder).get();
        }catch (IOException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
//        finally {
//
//        }
        return new ResponseEntity(result, HttpStatus.OK);
    }

    /**
     * 删除文档
     * @param index
     * @param type
     * @param id
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/delInfo",method = RequestMethod.POST)
    public ResponseEntity delInfo (
            @RequestParam(name = "index",required = true) String index,
            @RequestParam(name = "type",required = true) String type,
            @RequestParam(name = "id",required = true) String id
    )throws Exception{
        logger.debug("index=[{}],type=[{}],id=[{}]",index,type,id);
        DeleteResponse result = this.client.prepareDelete(index,type,id).get();
        return new ResponseEntity(result,HttpStatus.OK);
    }

    /**
     * 更新文档
     * @param index
     * @param type
     * @param id
     * @param title
     * @param keyword
     * @param businessInfo
     * @param status
     * @param createTime
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/updateInfo",method = RequestMethod.POST)
    public ResponseEntity updateInfo (
            @RequestParam(name = "index",required = true) String index,
            @RequestParam(name = "type",required = true) String type,
            @RequestParam(name = "id",required = true) String id,
            @RequestParam(name = "title",required = false) String title,
            @RequestParam(name = "keyword",required = false) String keyword,
            @RequestParam(name = "businessInfo",required = false) String businessInfo,
            @RequestParam(name = "status",required = false) String status,
            @RequestParam(name = "createTime",required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")//时间格式校验
                    Date createTime
            /*,
            @RequestParam(name = "age",required = false) int age*/
    )throws Exception{
        logger.debug("更新文档index=[{}],type=[{}],id=[{}],title=[{}],keyword=[{}],businessInfo=[{}],status=[{}],createTime=[{}]",
                index,type,id,title,keyword,businessInfo,status,createTime);
        UpdateRequest updateRequest =  new UpdateRequest(index,type,id);
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
        if(title!=null && title.length()>0){
            builder.field("title",title);
        }
        if(keyword!=null && title.length()>0){
            builder.field("keyword",keyword);
        }
        if(businessInfo!=null && title.length()>0){
            builder.field("businessInfo",businessInfo);
        }
        if(status!=null && title.length()>0){
            builder.field("status",status);
        }
        /*
        if(age!= 0){
            builder.field("age",age);
        }
        */
        if(createTime!=null){
            builder.field("createTime",createTime.getTime());
        }
              builder.endObject();
        updateRequest.doc(builder);
        UpdateResponse result = this.client.update(updateRequest).get();
        return new ResponseEntity(result,HttpStatus.OK);
    }

}
