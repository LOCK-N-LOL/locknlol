package com.locknlol.coukie.domain.riot.match.info;

import com.google.common.base.Preconditions;
import com.locknlol.coukie.adapter.riot.dto.*;
import com.locknlol.coukie.domain.riot.match.RiotMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.util.stream.Collectors.toList;

/**
 * Created by Oscar on 2017. 6. 25..
 */
@Service
public class MatchInfoService {
	@Autowired
	private RiotMatchService riotMatchService;

	//특정 match에 관련한 summoner의 경기 정보를 가져온다.
	public List<MatchBasicInfoDto> getRecentTwentyMatchsInfo(String summonerName) {
		RiotMatchDto matchDto = riotMatchService.getRecentMatches(summonerName);
		Preconditions.checkNotNull(matchDto);

		List<RiotMatchByMatchIdDto> matchDetails = getMatchesDetail(matchDto.getMatches());
		List<MatchBasicInfoDto> matchBasicInfos = getMatchBasicInfos(matchDetails, summonerName);
		return matchBasicInfos;
	}
	//api call 개많음 ㅎㅎ;
	private List<RiotMatchByMatchIdDto> getMatchesDetail(List<MatchReferenceDto> matchReferenceDtos) {
		List<Long> matchIds = matchReferenceDtos.stream()
				.filter(matchReferenceDto -> 420 == matchReferenceDto.getQueue() ||  440 == matchReferenceDto.getQueue())
				.map(MatchReferenceDto::getGameId)
				.collect(toList());

		return matchIds.stream()
			.map(matchId -> riotMatchService.getMatchByMatchId(matchId))
			.collect(toList());
	}

	private List<MatchBasicInfoDto> getMatchBasicInfos(List<RiotMatchByMatchIdDto> matchDetails, String summonerName) {
		List<MatchBasicInfoDto> matchBasicInfos = new ArrayList<>();
		for(RiotMatchByMatchIdDto matchDetail : matchDetails) {
			int participantId = getParticipantId(matchDetail, summonerName);
			Optional<ParticipantDto> participantDto = matchDetail.getParticipants().stream()
				.filter(participant -> participant.getParticipantId() == participantId)
				.findAny();
			participantDto.ifPresent(
				participant -> {
					MatchBasicInfoDto matchBasic = convert(participant);
					matchBasic.setDuration(matchDetail.getGameDuration());
					matchBasicInfos.add(matchBasic);
				}
			);
		}
		return matchBasicInfos;
	}

	private List<ParticipantsDto> convert(RiotMatchByMatchIdDto matchDetail) {
		Map<Integer, Integer> participantsKeyChampionValue = new HashMap<>();
		matchDetail.getParticipants()
			.forEach(participants -> participantsKeyChampionValue.put(participants.getParticipantId(), participants.getChampionId()));

		List<ParticipantsDto> participants = new ArrayList<>();
		matchDetail.getParticipantIdentities()
			.stream()
			.map(participant -> {
				PlayerDto player = participant.getPlayer();
				ParticipantsDto participantDto = new ParticipantsDto();
				participantDto.builder()
					.summonerName(player.getSummonerName())
					.championId(participantsKeyChampionValue.get(participant.getParticipantId()))
					.build();
				return participantDto;
			});

		return participants;
	}

	private MatchBasicInfoDto convert(ParticipantDto participantDto) {
		MatchBasicInfoDto matchBasic = new MatchBasicInfoDto();
		ParticipantStatsDto stats = participantDto.getStats();
		matchBasic.setChampionId(participantDto.getChampionId());
		matchBasic.setKills(stats.getKills());
		matchBasic.setDeaths(stats.getDeaths());
		matchBasic.setAssists(stats.getAssists());
		matchBasic.setChampLevel(stats.getChampLevel());
		matchBasic.addItems(stats.getItem0());
		matchBasic.addItems(stats.getItem1());
		matchBasic.addItems(stats.getItem2());
		matchBasic.addItems(stats.getItem3());
		matchBasic.addItems(stats.getItem4());
		matchBasic.addItems(stats.getItem5());
		matchBasic.addItems(stats.getItem6());
		return matchBasic;
	}

	private int getParticipantId(RiotMatchByMatchIdDto matchDetail, String summonerName) {
		return matchDetail.getParticipantIdentities()
			.stream()
			.filter(participant -> participant.getPlayer().getSummonerName().equals(summonerName))
			.map(player -> player.getParticipantId())
			.findFirst().get();
	}
}
