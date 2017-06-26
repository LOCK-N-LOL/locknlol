/**
 * @author jinie@coupang.com
 * @since 2017. 6. 25.
 */
const gulp = require('gulp');
const del = require('del');
const flatten = require('gulp-flatten');
const sass = require('gulp-sass');
const sourcemaps = require('gulp-sourcemaps');

const dir = {
    assets: "src/main/webapp/assets/",
    bower: "bower_components/",
    npm: "node_modules/",
    sass: "src/main/webapp/sass/",
    css: "src/main/webapp/css/"
};

const paths = {
    jsFiles: [
        dir.bower + 'bootstrap/dist/**/*.js',
        dir.bower + 'jquery/dist/**/*.js',
        dir.bower + 'lodash/dist/**/*.js'
        // dir.bower + 'react/**/*.js'
    ],
    cssFiles: [
        dir.bower + 'bootstrap/dist/**/*.css',
        dir.bower + 'font-awesome/css/**/*.css',
        dir.npm + 'ace-css/css/**'
    ],
    fontFiles: [
        '**/*.eot',
        '**/*.otf',
        '**/*.svg',
        '**/*.ttf',
        '**/*.woff',
        '**/*.woff2'
    ],
    sassFiles: [
        dir.sass + "**/*.scss", // 포함 file
        "!" + dir.sass + "assets/layout/**" // !가 있으면 제외 file
    ]
};

const assets = {
    js: {
        src: paths.jsFiles,
        dest: dir.assets + "js/"
    },
    css: {
        src: paths.cssFiles,
        dest: dir.assets + "css/"
    },
    fonts: {
        src: paths.fontFiles,
        dest: dir.assets + "fonts/"
    },
    tasks: [
        'assets:js',
        'assets:css',
        'assets:fonts'
    ]
};

gulp.task("assets:clean", () => {
    return del([dir.assets + '**'], {force: true});
});

gulp.task("assets:js", () => {
    return gulp.src(assets.js.src)
               .pipe(flatten())
               .pipe(gulp.dest(assets.js.dest))
});

gulp.task("assets:css", () => {
    return gulp.src(assets.css.src)
               .pipe(flatten())
               .pipe(gulp.dest(assets.css.dest))
});

gulp.task("assets:fonts", () => {
    return gulp.src(assets.fonts.src)
               .pipe(flatten())
               .pipe(gulp.dest(assets.fonts.dest))
});

gulp.task('assets', assets.tasks);

gulp.task("sass", () => {
    return gulp.src(paths.sassFiles)
               .pipe(sourcemaps.init())
               .pipe(sass({outputStyle: 'expanded'}))
               .pipe(sourcemaps.write())
               .pipe(gulp.dest(dir.css))
});

gulp.task("sass:watch", () => {
    gulp.watch(paths.sassFiles, ['sass']) // sass-hotfix
});

gulp.task("sass:commit", () => {
    return gulp.src(paths.sassFiles)
               .pipe(sass({outputStyle: 'expanded'}))
               .pipe(gulp.dest(dir.css))
});

gulp.task("sass:deploy", () => {
    return gulp.src(paths.sassFiles)
               .pipe(sass({outputStyle: 'compressed'}))
               .pipe(gulp.dest(dir.css))
});

gulp.task('default', assets.tasks, () => { console.log('Gulp is running'); });
