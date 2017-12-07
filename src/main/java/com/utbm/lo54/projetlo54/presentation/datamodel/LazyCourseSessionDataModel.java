/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utbm.lo54.projetlo54.presentation.datamodel;

/**
 *
 * @author Jonathan
 */
import com.utbm.lo54.projetlo54.entity.CourseSession;
import com.utbm.lo54.projetlo54.metier.CourseSessionServiceImpl;
import com.utbm.lo54.projetlo54.metier.interfaces.service.CourseSessionService;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

public class LazyCourseSessionDataModel extends LazyDataModel<CourseSession> {

    private List<CourseSession> datasource;
    private CourseSessionService courseSessionSrv;

    public LazyCourseSessionDataModel(List<CourseSession> datasource) {
        this.courseSessionSrv = new CourseSessionServiceImpl();
        this.datasource = datasource;
    }

    @Override
    public CourseSession getRowData(String rowKey) {
        for (CourseSession courseSession : datasource) {
            if (courseSession.getId().toString().equals(rowKey)) {
                return courseSession;
            }
        }
        return courseSessionSrv.read(Integer.valueOf(rowKey));

    }

    @Override
    public Object getRowKey(CourseSession courseSession) {
        return courseSession.getId();
    }

    @Override
    public List<CourseSession> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        List<CourseSession> data;

        System.out.println("Méthode LOAD ---------");
        System.out.println(first);
        System.out.println(pageSize);
        System.out.println(sortField);
        System.out.println(sortOrder);
        System.out.println("FILTRES  :  " + filters.toString());

        System.out.println("FIN Méthode LOAD ---------");
        data = courseSessionSrv.getAll(first, pageSize, sortField, sortOrder.toString());

        //rowCount
        this.setRowCount(courseSessionSrv.getCount());

        return data;
    }
}
