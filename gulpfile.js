/**
 * @author jinie@coupang.com
 * @since 2017. 6. 25.
 */
const gulp = require('gulp');
const del = require('del');
const flatten = require('gulp-flatten');
// const uglify = require('gulp-uglify');
// const minifycss = require('gulp-minify-css');
const sass = require('gulp-sass');
// const sourcemaps = require('gulp-sourcemaps');

const dir = {
    assets: "src/main/webapp/assets/",
    bower: "bower_components/",
    npm: "node_modules/",
    sass: "src/main/webapp/sass/",
    css: "src/main/webapp/css/",
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
        dir.sass + "**/*.scss",
        "!" + dir.sass + "assets/layout/**"
    ]
};

gulp.task("assets-files-clean", function() {
    del(['src/main/resources/assets/**'], {force: true});
});

gulp.task("assets-js-files", function() {
    return gulp.src(paths.jsFiles)
               .pipe(flatten())
               .pipe(gulp.dest(dir.assets + "js/"))
               // .pipe(uglify())
               // .pipe(rename({ suffix: ".min"}))
               // .pipe(gulp.dest(config.assets + 'js/'))
});

gulp.task("assets-css-files", function() {
    return gulp.src(paths.cssFiles)
               .pipe(flatten())
               .pipe(gulp.dest(dir.assets + 'css/'))
               // .pipe(minifycss())
               // .pipe(rename({ suffix: ".min"}))
               // .pipe(gulp.dest(config.assets + 'css/'))
});

gulp.task("assets-font-files", function() {
    return gulp.src(paths.fontFiles)
               .pipe(flatten())
               .pipe(gulp.dest(dir.assets + 'fonts/'))
});

gulp.task("sass", function() {
   return gulp.src(paths.sassFiles)
              // .pipe(sourcemaps.init())
              .pipe(sass())
              // .pipe(sourcemaps.write())
              .pipe(gulp.dest(dir.css))
});

const executes = [
    'assets-js-files',
    'assets-css-files',
    'assets-font-files'
];

// gulp.task('default', ["assets-files-clean"], () => { console.log('Assets is cleaning'); });
gulp.task('default', executes, () => { console.log('Gulp is running'); });
