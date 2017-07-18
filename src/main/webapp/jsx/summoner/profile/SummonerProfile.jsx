/**
 * @auther jinie@coupang.com
 * @since 2017. 7. 18.
 * @props
 */
import React from 'react';
import ReactDOM from 'react-dom';
import LeaguePositions from './LeaguePositions';

const content = document.getElementById("leaguePositions");
ReactDOM.render(<LeaguePositions summonerId="2538840" /> , content);