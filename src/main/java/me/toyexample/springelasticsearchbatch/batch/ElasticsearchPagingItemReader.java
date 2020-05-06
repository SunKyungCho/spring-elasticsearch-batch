package me.toyexample.springelasticsearchbatch.batch;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.batch.item.database.AbstractPagingItemReader;

import java.util.concurrent.CopyOnWriteArrayList;

public abstract class ElasticsearchPagingItemReader<T> extends AbstractPagingItemReader<T> {

    protected RestHighLevelClient restHighLevelClient;

    @Override
    protected void doOpen() throws Exception {
        super.doOpen();
        restHighLevelClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("nas.queryjet.net", 45192, "http"))
        );
    }

    @Override
    protected void doClose() throws Exception {
        restHighLevelClient.close();
        super.doClose();
    }


    protected abstract void doReadPage();

    @Override
    protected void doJumpToPage(int itemIndex) {

    }
}
