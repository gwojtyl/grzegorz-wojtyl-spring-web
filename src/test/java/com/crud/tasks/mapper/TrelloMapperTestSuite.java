package com.crud.tasks.mapper;

import com.crud.tasks.domain.TrelloList;
import com.crud.tasks.domain.TrelloListDto;
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

    @Test
    public void mapToList() {
        TrelloListDto trelloListDto1 = new TrelloListDto("1", "one", true);
        TrelloListDto trelloListDto2 = new TrelloListDto("2", "two", false);
        List<TrelloListDto> trelloListDtos = new ArrayList<>(Arrays.asList(trelloListDto1, trelloListDto2));

        List<TrelloList> trelloLists = trelloMapper.mapToList(trelloListDtos);

        assertEquals(2, trelloLists.size());
    }


}