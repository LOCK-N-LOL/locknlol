/**
 * @auther jinie@coupang.com
 * @since 2017. 7. 18.
 * @props
 */
import React from 'react';
import $ from 'jquery';

class LeaguePosition extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div>
                <div className="row">
                    <div className="col-md-6">
                        <img src={this.props.rankImg}/>
                    </div>
                    <div className="col-md-6">
                        <div className="row">
                            {this.props.queueType}
                        </div>
                        <div className="row">
                            {this.props.tier} {this.props.rank}
                        </div>
                        <div className="row">
                            포인트 : {this.props.leaguePoints}LP {this.props.wins}승 {this.props.losses}패
                        </div>
                        <div className="row">
                            승률 : { this.props.winRate}
                        </div>
                        <div className="row">
                            {this.props.leagueName}
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default class extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            leaguePositions: []
        }
    }

    componentDidMount() {
        this.getLeaguePositionByName(this.props.summonerName);
    }

    getLeaguePositionByName(summonerName){
        const deferred = Promise.resolve($.get({url: '/summoner/profile/league/position', data: {summonerName: summonerName}}).done());
        deferred.then(leaguePosition => this.setState({
            leaguePositions: leaguePosition
        }));

    }

    render() {
        const leaguePositionComponent = [];
        this.state.leaguePositions.forEach((leaguePosition) => {
            leaguePositionComponent.push(<LeaguePosition {...leaguePosition}/>)
        });

        return (
            <div>
                {leaguePositionComponent}
            </div>
        );
    }
}