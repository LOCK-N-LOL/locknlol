/**
 * @author Haylie
 * @since 2017. 5. 16..
 */
const hello = require('./hello');
const world = require('./world');
document.getElementById('greeting').innerHTML += hello + ', ' + world() + '!';