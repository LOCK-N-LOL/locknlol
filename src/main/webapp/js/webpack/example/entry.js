/**
 * @author Haylie
 * @since 2017. 5. 16..
 */
import hello from './hello';
import world from './world';
document.getElementById('greeting').innerHTML += hello + ', ' + world() + '!';
