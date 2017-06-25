const path = require('path');

module.exports = {
    entry: './src/main/webapp/js/entry.js',// entry.js 를 시작으로 빌드된다.

    output: {
        filename: 'index.js', // 빌드가 완료되면 filename 으로 파일을 생성한다
        path: __dirname + '/src/main/webapp/js'
    },

    plugins: [],

    devServer: {
        inline: true, // 핫리로드를 위한 스크립트를 삽입한다.
        hot: true, // 소스가 변경되면 자동으로 빌드되어 반영된다.
        port: 8008, // 서버 포트
        host: '0.0.0.0', // localhost 를 사용하면 외부에서 접근할 수 없다.
        contentBase: './dist' // 서비스 웹 루트 경로
    }
};

