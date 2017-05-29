package com.locknlol.coukie.domain.champion;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QChampionSpellImage is a Querydsl query type for ChampionSpellImageDto
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QChampionSpellImage extends EntityPathBase<ChampionSpellImage> {

    private static final long serialVersionUID = 1413906092L;

    public static final QChampionSpellImage championSpellImage = new QChampionSpellImage("championSpellImage");

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

    public QChampionSpellImage(String variable) {
        super(ChampionSpellImage.class, forVariable(variable));
    }

    public QChampionSpellImage(Path<? extends ChampionSpellImage> path) {
        super(path.getType(), path.getMetadata());
    }

    public QChampionSpellImage(PathMetadata metadata) {
        super(ChampionSpellImage.class, metadata);
    }

}

