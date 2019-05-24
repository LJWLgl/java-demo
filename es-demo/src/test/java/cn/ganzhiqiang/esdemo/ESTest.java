package cn.ganzhiqiang.esdemo;

import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zqgan
 * @since 2019/4/21
 *
 * cd /opt/elasticsearch-head
 * npm run start &
 **/

public class ESTest {


        private static String host="127.0.0.1"; // 服务器地址

        private static int port=9300; // 端口

        private TransportClient client=null;

        /**
         * 获取连接
         * @return
         */
        @SuppressWarnings({ "unchecked", "resource" })
        @Before
        public void getCient()throws Exception{

            Settings esSettings = Settings.builder()
                    .put("cluster.name", "elasticsearch_nanxuan")
                    .put("client.transport.sniff", false).build();
            client = new PreBuiltTransportClient(esSettings)
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host), port));
            System.out.println(client);
        }

        /**
         * 关闭连接
         */
        @After
        public void close(){
            if(client!=null){
                client.close();
            }
        }

        /**
         * 添加索引
         */
        @Test
        public void testIndex()throws Exception{
            IndexResponse response =client.prepareIndex("twitter", "tweet", "1")
                    .setSource(XContentFactory.jsonBuilder()
                            .startObject()
                            .field("user", "kimchy")
                            .field("postDate", new Date())
                            .field("message", "trying out Elasticsearch")
                            .endObject()
                    )
                    .get();
            System.out.println("索引名称："+response.getIndex());
            System.out.println("类型："+response.getType());
            System.out.println("文档ID："+response.getId()); // 第一次使用是1
            System.out.println("当前实例状态："+response.status());
        }

    /**
     * 创建索引库
     *
     * 需求:创建一个索引库为：msg 消息队列,类型为：tweet,id 为 1,
     * 索引库的名称必须为小写
     *
     * @return void
     * @throws IOException
     */
    @Test
    public void addIndex1() throws IOException {
        IndexResponse response = client.prepareIndex("msg", "tweet", "2")
                .setSource(XContentFactory.jsonBuilder()
                        .startObject().field("userName", "飞机")
                        .field("sendDate", new Date())
                        .field("msg", "李哲")
                        .endObject())
                .get();

        System.out.println("索引名称:" + response.getIndex() + "\n类型:" + response.getType()
                + "\n文档ID:" + response.getId() + "\n当前实例状态:" + response.status());
    }

    @Test
    public void getData1() {
        GetResponse getResponse = client.prepareGet("msg", "tweet", "1").get();
        System.out.println("索引库的数据:" + getResponse.getSourceAsString());
    }

//    @Test
//    public void updateData() {
//        JsonObject jsonObject = new JsonObject();
//        jsonObject.addProperty("userName", "王五");
//        jsonObject.addProperty("sendDate", "2008-08-08");
//        jsonObject.addProperty("msg", "你好,张三，好久不见");
//
//        UpdateResponse updateResponse = client.prepareUpdate("msg", "tweet", "1")
//                .setDoc(jsonObject.toString(),XContentType.JSON)
//                .get();
//
//        logger.info("updateResponse索引名称:" + updateResponse.getIndex()
//                + "\n updateResponse类型:" + updateResponse.getType()
//                + "\n updateResponse文档ID:" + updateResponse.getId()
//                + "\n当前实例updateResponse状态:" + updateResponse.status());
//    }

    @Test
    public void deleteData() {
        DeleteResponse deleteResponse = client.prepareDelete("msg", "tweet", "1").get();
        System.out.println("deleteResponse索引名称:" + deleteResponse.getIndex()
                + "\n deleteResponse类型:" + deleteResponse.getType()
                + "\n deleteResponse文档ID:" + deleteResponse.getId()
                + "\n当前实例deleteResponse状态:" + deleteResponse.status());
    }

    @Test
    public void queryByFilter_Accept() {
        SearchResponse response = client.prepareSearch("msg")//设置要查询的索引(index)
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setTypes("tweet")//设置type, 这个在建立索引的时候同时设置了, 或者可以使用head工具查看
                .setQuery(QueryBuilders.matchQuery("msg", "李")) //在这里"message"是要查询的field,"Accept"是要查询的内容
                .setFrom(0)
                .setSize(10)
                .setExplain(true)
                .execute()
                .actionGet();
        List<String> docList = new ArrayList<String>();
        for (SearchHit hit : response.getHits()) {
            docList.add(hit.getSourceAsString());
        }
        client.close();
        System.out.println(docList.size());
    }

}
