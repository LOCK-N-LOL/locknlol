package com.locknlol.coukie.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QImage is a Querydsl query type for Image
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QImage extends EntityPathBase<Image> {

    private static final long serialVersionUID = -608003578L;

    public static final QImage image = new QImage("image");

    public final StringPath full = createString("full");

    public final StringPath group = createString("group");

    public final NumberPath<Long> h = createNumber("h", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath sprite = createString("sprite");

    public final NumberPath<Long> w = createNumber("w", Long.class);

    public final NumberPath<Long> x = createNumber("x", Long.class);

    public final NumberPath<Long> y = createNumber("y", Long.class);

    public QImage(String variable) {
        super(Image.class, forVariable(variable));
    }

    public QImage(Path<? extends Image> path) {
        super(path.getType(), path.getMetadata());
    }

    public QImage(PathMetadata metadata) {
        super(Image.class, metadata);
    }

}

