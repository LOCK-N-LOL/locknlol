package com.locknlol.coukie.domain.champion;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QChampionPassiveImage is a Querydsl query type for ChampionPassiveImageDto
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QChampionPassiveImage extends EntityPathBase<ChampionPassiveImage> {

    private static final long serialVersionUID = -68684339L;

    public static final QChampionPassiveImage championPassiveImage = new QChampionPassiveImage("championPassiveImage");

    public final com.locknlol.coukie.domain.QImage _super = new com.locknlol.coukie.domain.QImage(this);

    //inherited
    public final StringPath full = _super.full;

    //inherited
    public final StringPath group = _super.group;

    //inherited
    public final NumberPath<Long> h = _super.h;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final StringPath sprite = _super.sprite;

    //inherited
    public final NumberPath<Long> w = _super.w;

    //inherited
    public final NumberPath<Long> x = _super.x;

    //inherited
    public final NumberPath<Long> y = _super.y;

    public QChampionPassiveImage(String variable) {
        super(ChampionPassiveImage.class, forVariable(variable));
    }

    public QChampionPassiveImage(Path<? extends ChampionPassiveImage> path) {
        super(path.getType(), path.getMetadata());
    }

    public QChampionPassiveImage(PathMetadata metadata) {
        super(ChampionPassiveImage.class, metadata);
    }

}

