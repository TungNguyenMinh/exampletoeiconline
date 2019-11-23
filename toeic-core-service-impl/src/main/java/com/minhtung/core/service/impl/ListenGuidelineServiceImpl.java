package com.minhtung.core.service.impl;

import com.minhtung.core.dao.ListenGuidelineDao;
import com.minhtung.core.daoimpl.ListenGuidelineDaoImpl;
import com.minhtung.core.dto.ListenGuidelineDTO;
import com.minhtung.core.persistence.entity.ListenGuidelineEntity;
import com.minhtung.core.service.ListenGuidelineService;
import com.minhtung.core.utils.ListenGuidelineBeanUtil;

import java.util.ArrayList;
import java.util.List;

public class ListenGuidelineServiceImpl implements ListenGuidelineService {
    private ListenGuidelineDao listenGuidelineDao = new ListenGuidelineDaoImpl();

    /*public Object[] findListenGuidelineByProperties(String property, Object value, String sortExpession, String sortDirection, Integer offset, Integer limit) {
        List<ListenGuidelineDTO> result = new ArrayList<ListenGuidelineDTO>();
        Object[] objects = (Object[]) listenGuidelineDao.findeByProperty(property, value, sortExpession, sortDirection, offset, limit);
        for (ListenGuidelineEntity item : (List<ListenGuidelineEntity>) objects[1]) {
            ListenGuidelineDTO dto = new ListenGuidelineBeanUtil().entity2Dto(item);
            result.add(dto);
        }
        objects[1] = result;
        return objects;
    }*/
}
