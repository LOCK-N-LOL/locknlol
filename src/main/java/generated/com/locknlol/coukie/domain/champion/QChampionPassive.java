package com.locknlol.coukie.domain.champion;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QChampionPassive is a Querydsl query type for ChampionPassive
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QChampionPassive extends EntityPathBase<ChampionPassive> {

    private static final long serialVersionUID = 289189934L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QChampionPassive championPassive = new QChampionPassive("championPassive");

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QChampionPassiveImage image;

    public final StringPath name = createString("name");

    public QChampionPassive(String variable) {
        this(ChampionPassive.class, forVariable(variable), INITS);
    }

    public QChampionPassive(Path<? extends ChampionPassive> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QChampionPassive(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QChampionPassive(PathMetadata metadata, PathInits inits) {
        this(ChampionPassive.class, metadata, inits);
    }

    public QChampionPassive(Class<? extends ChampionPassive> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.image = inits.isInitialized("image") ? new QChampionPassiveImage(forProperty("image")) : null;
    }

}

