import React from 'react';

class EntityList extends React.Component {
    render() {
        console.log("log well...");
        return (
            <ul>
                <li><a href="/staticDataV3/champions">챔피언 정보 모두 보기</a></li>
                <li><a href="/staticDataV3/items">아이템 정보 모두 보기</a></li>
                <li><a href="/staticDataV3/summonerSpells">서머너 스펠 정보 모두 보기</a></li>
                <li><a href="/staticDataV3/saveChampions">챔피언 정보 저장하기</a></li>
            </ul>
        );
    }
}

export default EntityList;