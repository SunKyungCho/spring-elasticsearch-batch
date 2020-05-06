package me.toyexample.springelasticsearchbatch.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long movieNo;
    @Column(updatable = false)
    private String movieCode;
    private String name;
    private String nameEn;
    private String director;
    private String genre;
    private String nation;
    private String audit;
    private String showTime;
    private String status;
    private String openDate;
    private String productionYear;
    private String actors;
    @Lob
    private String description;
    private String imageUrl;
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createAt;
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updateAt;

    @Override
    public String toString() {
        return "Movie{" +
                "movieNo=" + movieNo +
                ", movieCode='" + movieCode + '\'' +
                ", name='" + name + '\'' +
                ", nameEn='" + nameEn + '\'' +
                ", director='" + director + '\'' +
                ", genre='" + genre + '\'' +
                ", nation='" + nation + '\'' +
                ", audit='" + audit + '\'' +
                ", showTime='" + showTime + '\'' +
                ", status='" + status + '\'' +
                ", openDate='" + openDate + '\'' +
                ", productionYear='" + productionYear + '\'' +
                ", actors='" + actors + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}