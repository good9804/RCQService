package com.rcq.rcqauth.entity;

import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name="problemlist")
public class ProblemList implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "userid")
    private String userid;

    @Column(name = "title")
    private String title;

    @OneToMany
    @JoinColumn(name = "problem") // 다른 테이블과의 관계 매핑
    private List<Problem> list;


}
