package me.toyexample.springelasticsearchbatch.batch;

import lombok.SneakyThrows;
import me.toyexample.springelasticsearchbatch.domain.Movie;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.util.Map;

public class MoviePagingItemReader extends ElasticsearchPagingItemReader<Movie>{


    @SneakyThrows
    @Override
    protected void doReadPage() {

        SearchRequest searchRequest = new SearchRequest();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        searchRequest.source(searchSourceBuilder);
        SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        response.getHits();

        for (SearchHit hit : response.getHits()) {
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();

        }
    }
}
