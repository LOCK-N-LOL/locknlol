/******/ (function(modules) { // webpackBootstrap
/******/ 	// The module cache
/******/ 	var installedModules = {};

/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {

/******/ 		// Check if module is in cache
/******/ 		if(installedModules[moduleId])
/******/ 			return installedModules[moduleId].exports;

/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = installedModules[moduleId] = {
/******/ 			exports: {},
/******/ 			id: moduleId,
/******/ 			loaded: false
/******/ 		};

/******/ 		// Execute the module function
/******/ 		modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);

/******/ 		// Flag the module as loaded
/******/ 		module.loaded = true;

/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}


/******/ 	// expose the modules object (__webpack_modules__)
/******/ 	__webpack_require__.m = modules;

/******/ 	// expose the module cache
/******/ 	__webpack_require__.c = installedModules;

/******/ 	// __webpack_public_path__
/******/ 	__webpack_require__.p = "";

/******/ 	// Load entry module and return exports
/******/ 	return __webpack_require__(0);
/******/ })
/************************************************************************/
/******/ ([
/* 0 */
/***/ function(module, exports, __webpack_require__) {

	/**
	 * @author Haylie
	 * @since 2017. 5. 16..
	 */
	const hello = __webpack_require__(1);
	const world = __webpack_require__(2);
	document.getElementById('greeting').innerHTML += hello + ', ' + world() + '!';

/***/ },
/* 1 */
/***/ function(module, exports) {

	/**
	 * @author Haylie
	 * @since 2017. 5. 16..
	 */
	module.exports = "Front";

/***/ },
/* 2 */
/***/ function(module, exports) {

	/**
	 * @author Haylie
	 * @since 2017. 5. 16..
	 */
	module.exports = function () {
	    return 'hi';
	};

/***/ }
/******/ ]);