require([
    'react',
    'react-dom',
    'js/EntityList'
], function (React, ReactDOM, EntityList) {
    const contentElement = document.getElementById('content');
    ReactDOM.render(<EntityList />, contentElement);
});
