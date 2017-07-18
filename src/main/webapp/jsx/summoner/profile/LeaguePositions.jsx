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
                        <img src={this.props.imageSrc}/>
                    </div>
                    <div className="col-md-6">
                        <div className="row">
                            {this.props.data.queueType}
                        </div>
                        <div className="row">
                            {this.props.data.tier} {this.props.data.rank}
                        </div>
                        <div className="row">
                            포인트 : {this.props.data.leaguePoints}LP {this.props.data.wins}승 {this.props.data.losses}패
                        </div>
                        <div className="row">
                            승률 :
                        </div>
                        <div className="row">
                            {this.props.data.leagueName}
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
        this.getLeaguePositionById(this.props.summonerId);
    }

    getLeaguePositionById(id){
        const deferred = Promise.resolve($.get({url: `/summoner/profile/league/position`, data: {summonerId: id}}).done());
        deferred.then(leaguePosition => this.setState({
            leaguePositions: leaguePosition
        }));
    }

    render() {
        const leaguePositionComponent = [];
        this.state.leaguePositions.forEach((leaguePosition) => {
            leaguePositionComponent.push(<LeaguePosition data={leaguePosition} imageSrc={"https://opgg-static.akamaized.net/images/medals/challenger_1.png"}/>)
        });

        return (
            <div>
                {leaguePositionComponent}
            </div>
        );
    }
}