package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloMapperTestSuite {
    @Autowired
    TrelloMapper trelloMapper;

    TrelloListDto trelloListDto1 = new TrelloListDto("1", "one", true);
    TrelloListDto trelloListDto2 = new TrelloListDto("2", "two", false);
    List<TrelloListDto> trelloListDtos = new ArrayList<>(Arrays.asList(trelloListDto1, trelloListDto2));

    TrelloList trelloList1 = new TrelloList("1", "name", true);
    TrelloList trelloList2 = new TrelloList("2", "two", false);
    List<TrelloList> trelloLists = new ArrayList<>(Arrays.asList(trelloList1, trelloList2));

    @Test
    public void mapToLists() {
        List<TrelloList> trelloLists = trelloMapper.mapToLists(trelloListDtos);
        assertEquals(2, trelloLists.size());
    }

    @Test
    public void mapToListsDto() {
        List<TrelloListDto> trelloListDtos = trelloMapper.mapToListsDto(trelloLists);
        assertEquals(2, trelloListDtos.size());
    }

    @Test
    public void mapToBoards() {
        TrelloBoardDto trelloBoardDto1 = new TrelloBoardDto("1", "one", trelloListDtos);
        TrelloBoardDto trelloBoardDto2 = new TrelloBoardDto("2", "two", trelloListDtos);
        List<TrelloBoardDto> trelloBoardDtos = new ArrayList<>(Arrays.asList(trelloBoardDto1, trelloBoardDto2));

        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoards(trelloBoardDtos);

        assertEquals(2, trelloBoards.size());
    }

    @Test
    public void mapToBoardsDto() {
        TrelloBoard trelloBoard1 = new TrelloBoard("1", "one", trelloLists);
        TrelloBoard trelloBoard2 = new TrelloBoard("2", "two", trelloLists);
        List<TrelloBoard> trelloBoards = new ArrayList<>(Arrays.asList(trelloBoard1, trelloBoard2));

        List<TrelloBoardDto> trelloBoardDtos = trelloMapper.mapToBoardsDto(trelloBoards);

        assertEquals(2, trelloBoardDtos.size());
    }

    @Test
    public void mapToCard() {
        TrelloCardDto trelloCardDto = new TrelloCardDto("1", "one", "1", "1");

        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);

        assertEquals("one", trelloCard.getDescription());
        assertEquals("1", trelloCard.getListId());
        assertEquals("1", trelloCard.getName());
        assertEquals("1", trelloCard.getPos());
    }

    @Test
    public void mapToCardDto() {
        TrelloCard trelloCard = new TrelloCard("1", "one", "1", "1");

        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);

        assertEquals("one", trelloCard.getDescription());
        assertEquals("1", trelloCard.getListId());
        assertEquals("1", trelloCard.getName());
        assertEquals("1", trelloCard.getPos());
    }
}