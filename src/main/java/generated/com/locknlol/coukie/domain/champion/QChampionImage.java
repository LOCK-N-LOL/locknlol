package com.locknlol.coukie.domain.champion;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QChampionImage is a Querydsl query type for ChampionImageDto
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QChampionImage extends EntityPathBase<ChampionImage> {

    private static final long serialVersionUID = 642220066L;

    public static final QChampionImage championImage = new QChampionImage("championImage");

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

    public QChampionImage(String variable) {
        super(ChampionImage.class, forVariable(variable));
    }

    public QChampionImage(Path<? extends ChampionImage> path) {
        super(path.getType(), path.getMetadata());
    }

    public QChampionImage(PathMetadata metadata) {
        super(ChampionImage.class, metadata);
    }

}

