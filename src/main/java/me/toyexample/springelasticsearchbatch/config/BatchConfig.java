package me.toyexample.springelasticsearchbatch.config;

import lombok.RequiredArgsConstructor;
import me.toyexample.springelasticsearchbatch.batch.ElasticsearchPagingItemReader;
import me.toyexample.springelasticsearchbatch.domain.Movie;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable
@RequiredArgsConstructor
public class BatchConfig {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;


    @Bean
    public Job exampleJob() {
        return jobBuilderFactory.get("exampleJob")
                .start(elasticStep())
                .build();
    }

    private Step elasticStep() {
        return stepBuilderFactory.get("elasticStep")
                .<Movie, Movie>chunk(100)
                .reader(reader())
                .writer(writer())
                .build();
    }

    private ItemReader<Movie> reader() {
        ElasticsearchPagingItemReader<Movie> reader = new ElasticsearchPagingItemReader<>();
        reader.setPageSize(1000);
        return reader;
    }

    private ItemWriter<Movie> writer() {
        return list -> {
            for (Movie movie : list) {
                movie.toString();
            }
        };
    }
}
