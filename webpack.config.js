const glob = require('glob');
const path = require('path');

const makeEntry = (files) => {
    const prefix = './src/main/webapp/jsx/';
    const suffix = ".jsx";
    const entry = {};

    files.forEach(file => {
        file = file.substring(prefix.length-1);
        file = file.substring(0, file.length-suffix.length);
        entry[file] = prefix + file + suffix;
    });

    return entry;
};

const example = {
    entry: './src/main/webapp/js/webpack/example/entry.js',

    output: {
        filename: 'webpack-example.js',
        path: path.resolve(__dirname, 'src/main/webapp/js/webpack/example/')
    },

    resolve: {
        extensions: ['.js', '.jsx']
    },

    plugins: [],

    module: {
        rules: [
            {
                test: /\.js$/,
                exclude: /(node_modules|bower_components)/,
                use: {
                    loader: 'babel-loader',
                    options: {
                        cacheDirectory: true,
                        presets: ['es2015', 'react'],
                        plugins: ['transform-runtime']
                    }
                }
            }
        ]
    }
};

const react = {
    entry: makeEntry(glob.sync('./src/main/webapp/jsx/**/*.jsx')),

    output: {
        filename: '[name].js',
        path: path.resolve(__dirname, 'src/main/webapp/js/'),
    },

    resolve: {
        extensions: ['.js', '.jsx', '.css', '.scss']
    },

    plugins: [],

    devtool: 'source-map',

    module: {
        rules: [
            {
                test: /\.jsx$/,
                exclude: /(node_modules|bower_components)/,
                use: {
                    loader: 'babel-loader',
                    options: {
                        cacheDirectory: true,
                        presets: ['es2015', 'react'],
                        plugins: ['transform-runtime']
                    }
                }
            },
            {
                test: /\.css$/,
                use: [ 'style-loader', 'css-loader' ]
            },
            {
                test: /\.scss$/,
                use: [{
                    loader: "style-loader" // creates style nodes from JS strings
                }, {
                    loader: "css-loader" // translates CSS into CommonJS
                }, {
                    loader: "sass-loader?outputStyle=compressed&sourceMap=true&sourceMapContents=true" // compiles Sass to CSS
                }]
            }
        ]
    }
};

module.exports = [example, react];
