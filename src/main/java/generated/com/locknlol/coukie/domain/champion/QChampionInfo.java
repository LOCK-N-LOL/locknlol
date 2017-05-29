package com.locknlol.coukie.domain.champion;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QChampionInfo is a Querydsl query type for ChampionInfo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QChampionInfo extends EntityPathBase<ChampionInfo> {

    private static final long serialVersionUID = 2098927879L;

    public static final QChampionInfo championInfo = new QChampionInfo("championInfo");

    public final NumberPath<Long> attack = createNumber("attack", Long.class);

    public final NumberPath<Long> defense = createNumber("defense", Long.class);

    public final NumberPath<Long> difficulty = createNumber("difficulty", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> magic = createNumber("magic", Long.class);

    public QChampionInfo(String variable) {
        super(ChampionInfo.class, forVariable(variable));
    }

    public QChampionInfo(Path<? extends ChampionInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QChampionInfo(PathMetadata metadata) {
        super(ChampionInfo.class, metadata);
    }

}

