package com.example.order_service.domain;

import com.example.order_service.converter.JsonToMapConverter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
@ToString
@Entity
@Table(name = "outbox")
public class Outbox implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String event;

    @Column(name = "event_id")
    private Long eventId;

//    @Type(type = "json")
//    @Column(columnDefinition = "jsonb")
    @Convert(converter = JsonToMapConverter.class)
    private Map<String, Object> payload;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
